<template>
  <div class="wrapper loginsign" style="height: 600px">
    <!-- 注册 -->
    <div class="item signup">
      <div class="form">
        <h3 class="loginsign-title">注册新账号</h3>
        <el-form :model="pojo" :rules="rules" ref="pojo" label-width="120px" class="demo-form-inline">
          <div v-if="progress===0 || progress===100">
            <el-upload
                class="avatar-uploader"
                action="#"
                :show-file-list="false"
                :before-upload="beforeAvatarUpload"
                :http-request="uploadImg">

              <img v-if="pojo.avatar" :src="pojo.avatar" class="avatar" alt="">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </div>

          <div v-if="progress!==0&&progress!==100">
            <el-progress class="progress" type="circle" :percentage="progress" stroke-width="4"	 ></el-progress>
          </div>

          <div class="upload-name">点击上传头像</div>


          <el-form-item class="control-label" label="姓名" prop="nickname" style="margin-bottom: 20px">
            <el-input v-model="pojo.nickname" placeholder="真实姓名或常用昵称"/>
          </el-form-item>

          <el-form-item class="control-label" label="邮箱" prop="mobile" style="margin-bottom: 20px">
            <el-input v-model="pojo.email" placeholder="请输入邮箱"/>
          </el-form-item>

          <el-form-item class="control-label" label="短信验证码" prop="yzm">
            <el-input id="appendedInputButton" v-model="pojo.yzm" size="30" placeholder="验证码" style=" width: 38%"/>
            <el-button type="primary" @click="sendMessage" plain style="padding-top: 10px; width: 58%">获取验证码
            </el-button>
          </el-form-item>


          <el-form-item class="control-label" label="密码" prop="password" style="margin-bottom: 20px">
            <el-input type="password" v-model="pojo.password"/>
          </el-form-item>

          <el-checkbox v-model="checked" style="float:right;" prop="agree">同意协议并接受《服务条款》</el-checkbox>

          <el-row>
            <el-button type="success" @click="register" style="float:right;width: 100%">注 册</el-button>
          </el-row>
        </el-form>
      </div>
    </div>

    <!-- 登入 -->
    <div class="item">
      <div class="form">
        <h3 class="loginsign-title">用户登录</h3>
        <el-form>

          <el-form-item class="control-label" label="邮箱" prop="mobile" style="margin-bottom: 20px">
            <el-input v-model="email" placeholder="请输入邮箱"/>
          </el-form-item>

          <el-form-item class="control-label" label="密码" prop="password" style="margin-bottom: 20px">
            <el-input type="password" v-model="password" placeholder="请输入密码"/>
          </el-form-item>

          <el-row>
            <el-button type="primary" @click="login" style="float:right;width: 100%">登 录</el-button>
          </el-row>

        </el-form>

      </div>
    </div>

  </div>
</template>


<script>
import '~/assets/css/loginsign.css'
import userApi from '@/api/user'
import {setUser} from '@/utils/auth'
import COS from 'cos-js-sdk-v5'
import file from "cos-js-sdk-v5"; //脚手架安装

export default {
  data() {
    return {
      checked: false,
      email: '',
      password: '',

      pojo: {
        avatar: 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png',
      },
      rules: {
        nickname: [
          {required: true, message: '请输入姓名', trigger: 'blur'},
          {min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 3, max: 11, message: '长度在 3 到 11 个字符', trigger: 'blur'}
        ],
        email: [
          {required: true, message: '请输入电子邮箱', trigger: 'blur'},
        ]
      },
      progress: 0,

    }
  },
  methods: {
    sendMessage() {
      console.log(this.pojo.email)
      userApi.sendsms(this.pojo.email).then(res => {
        console.log(res.data)
        if (res.data.flag) {
          this.$message({
            message: '验证码已发送成功',
            type: 'success'
          })
        } else {
          this.$message({
            message: '发送验证码出错',
            type: 'error'
          })
        }
      })
    },
    register() {
      userApi.register(this.pojo,this.pojo.yzm).then(res => {
        if (res.data.flag) {
          this.$message({
            message: '注册成功',
            type: 'success'
          })
          this.pojo = {}
          this.pojo.avatar='https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png'
        } else {
          this.$message({
            message: '注册出错',
            type: 'error'
          })
        }
      })
    },
    login() {
      userApi.login(this.email, this.password).then(res => {
        if (res.data.code === 20000) {
          //保存用户信息,用户ID暂时用1代替
          setUser(res.data.data.id, res.data.data.token, res.data.data.nickname, res.data.data.avatar, res.data.data.isvip)
          location.href = '/'
        } else {
          this.$message({
            message: '用户名或密码错误',
            type: 'error'
          })
          // this.username = ''
          this.password = ''
        }
      })
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }

      return isJPG && isLt2M;
    },
    dateFormat(fmt, date) {
      let ret;
      const opt = {
        "Y+": date.getFullYear().toString(),        // 年
        "m+": (date.getMonth() + 1).toString(),     // 月
        "d+": date.getDate().toString(),            // 日
        "H+": date.getHours().toString(),           // 时
        "M+": date.getMinutes().toString(),         // 分
        "S+": date.getSeconds().toString()          // 秒
        // 有其他格式化字符需求可以继续添加，必须转化成字符串
      };
      for (let k in opt) {
        ret = new RegExp("(" + k + ")").exec(fmt);
        if (ret) {
          fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
        }
      }
      return fmt;
    },

    uploadImg(res) {
      if (res.file) {
        // 下面的代码是固定写法
        // 填写自己腾讯云cos中的key和id (密钥)
        const cos = new COS({
          SecretId: 'AKIDY2PVXMBrCMQYUFwfGi40kPq1QcYCckdf', // 身份识别ID
          SecretKey: 'z8x43NhlbFFVdW7ZptIRKyMh1A4uWtSR' // 身份秘钥
        })
        let date = new Date();

        // 执行上传操作
        cos.putObject({
          Bucket: 'heyufei-1305336662', /* 存储桶 */
          Region: 'ap-shanghai', /* 存储桶所在地域，必须字段 */
          Key: '/Fly-Volunteer/Head-' + this.dateFormat("YYYYmmddHHMM", date) + res.file.name, /* 文件名 */
          StorageClass: 'STANDARD', // 上传模式, 标准模式
          Body: res.file, // 上传文件对象
          onProgress: (progressEvent) => { // 上传进度
            let num = progressEvent.loaded / progressEvent.total * 100 | 0;  //百分比
            if (num !== undefined) {
              this.progress = num
            }
          }
        }, (err, data) => {
          console.log(err || data)
          // 上传成功之后
          if (data.statusCode === 200) {
            this.pojo.avatar = `https:${data.Location}`
          }
        })
      }


    },
  }
}
</script>

