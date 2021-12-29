<template>
  <div class="wrapper loginsign" style="height: 600px">
    <!-- 注册 -->
    <div class="item signup">
      <div class="form">
        <h3 class="loginsign-title">注册新账号</h3>
        <el-form :model="pojo" :rules="rules" ref="pojo" label-width="120px" class="demo-form-inline">
          <el-upload
              class="avatar-uploader"
              action="#"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload"
              :http-request="uploadImg">

            <img v-if="pojo.imageUrl" :src="pojo.imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
          <div class="upload-name">点击上传头像</div>




          <el-form-item class="control-label" label="姓名" prop="name" style="margin-bottom: 20px">
            <el-input v-model="pojo.name" placeholder="真实姓名或常用昵称"/>
          </el-form-item>

          <el-form-item class="control-label" label="手机号码" prop="mobile" style="margin-bottom: 20px">
            <el-input v-model="pojo.mobile" placeholder="仅支持大陆手机号"/>
          </el-form-item>

          <el-form-item class="control-label" label="短信验证码" prop="yzm">
            <el-input id="appendedInputButton" v-model="pojo.yzm" size="30" placeholder="验证码" style=" width: 40%"/>
            <el-button type="primary" @click="sendMessage" plain style="padding-top: 10px; width: 58%">获取验证码</el-button>
          </el-form-item>


          <el-form-item class="control-label" label="密码" prop="password" style="margin-bottom: 20px">
            <el-input type="password" v-model="pojo.password"/>
          </el-form-item>

          <el-checkbox v-model="checked" style="float:right;" prop="agree">同意协议并接受《服务条款》</el-checkbox>

          <el-button type="success" @click="register"  style="float:right;width: 100%">注 册</el-button>

        </el-form>
      </div>
    </div>

    <!-- 登入 -->
    <div class="item">
      <div class="form">
        <h3 class="loginsign-title">用户登录</h3>
        <el-form>
          <el-form-item class="control-label" label="手机号码" prop="mobile" style="margin-bottom: 20px">
            <el-input v-model="username" placeholder="仅支持大陆手机号"/>
          </el-form-item>

          <el-form-item class="control-label" label="密码" prop="password" style="margin-bottom: 20px">
            <el-input type="password" v-model="password" placeholder="请输入密码"/>
          </el-form-item>
        </el-form>

        <el-button type="primary" @click="login"  style="float:right;width: 100%">登 录</el-button>


      </div>
    </div>

  </div>
</template>
<script>
import '~/assets/css/loginsign.css'
import userApi from '@/api/user'
import {setUser} from '@/utils/auth'

export default {
  data() {
    return {
      checked: false,
      password: '',
      username: '',
      pojo: {
        mobile:'',
        imageUrl: 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png',
        name:'',
        password:'',
        yzm:''
      },
      rules: {
        name: [
          {required: true, message: '请输入姓名', trigger: 'blur'},
          {min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 3, max: 11, message: '长度在 3 到 11 个字符', trigger: 'blur'}
        ],
        mobile: [
          {required: true, message: '请输入手机号码', trigger: 'blur'},
        ]
      },

    }
  },
  methods: {
    sendMessage() {
      userApi.sendsms(this.pojo.mobile).then(res => {
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
      userApi.register(this.pojo).then(res => {
        if (res.data.flag) {
          this.$message({
            message: '注册成功',
            type: 'success'
          })
          this.pojo = {}
        } else {
          this.$message({
            message: '注册出错',
            type: 'error'
          })
        }
      })
    },
    login() {
      userApi.login(this.username, this.password).then(res => {
        if (res.data.code === 20000) {
          //保存用户信息,用户ID暂时用1代替
          setUser(res.data.data.id, res.data.data.token, res.data.data.name, res.data.data.avatar)
          location.href = '/'
        } else {
          this.$message({
            message: '用户名或密码错误',
            type: 'error'
          })
          this.username = ''
          this.password = ''
        }
      })
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
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
    uploadImg (params) {
      console.log(params)

    },

  }
}
</script>

