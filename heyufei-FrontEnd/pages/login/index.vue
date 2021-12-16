<template>
  <div class="wrapper loginsign">
    <!-- 注册 -->
    <div class="item signup">
      <div class="form">
        <h3 class="loginsign-title">注册新账号</h3>
        <el-form :model="pojo" :rules="rules" ref="pojo" label-width="120px" class="demo-form-inline">
          <el-form-item class="control-label" label="姓名" prop="name" style="margin-bottom: 20px">
            <el-input v-model="pojo.name" placeholder="真实姓名或常用昵称"/>
          </el-form-item>

          <el-form-item class="control-label" label="手机号码" prop="mobile" style="margin-bottom: 20px">
            <el-input v-model="pojo.mobile" placeholder="仅支持大陆手机号"/>
          </el-form-item>

          <el-form-item class="control-label" label="短信验证码" prop="yzm" style="margin-bottom: 20px">
            <el-input  id="appendedInputButton" v-model="pojo.yzm" size="30" placeholder="短信验证码" style="width: 192px"/>
            <el-button type="primary" @click="sendsms" plain>获取验证码</el-button>
          </el-form-item>


          <el-form-item class="control-label" label="密码" prop="password" style="margin-bottom: 20px">
            <el-input type="password" v-model="pojo.password"/>
          </el-form-item>

          <el-checkbox v-model="checked" style="float:right;" prop="agree">同意协议并接受《服务条款》</el-checkbox>

          <el-button type="success" @click="register" plain style="float:right;width: 400px">注 册</el-button>

        </el-form>
      </div>
    </div>

    <!-- 登入 -->
    <div class="item">
      <div class="form">
        <h3 class="loginsign-title">用户登录</h3>
        <form class="sui-form login-form">
          <!--          <div class="control-group">-->
          <!--            <label for="inputname2" class="control-label">用户名：</label>-->
          <!--            <div class="controls">-->
          <!--              <input type="text" id="inputname2" v-model="username" placeholder="11位手机号或Email" class="input-xlarge" data-rules="required" />-->
          <!--            </div>-->
          <!--          </div>-->
          <!--          <div class="control-group">-->
          <!--            <label for="inputpassword2" class="control-label">密码：</label>-->
          <!--            <div class="controls">-->
          <!--              <input type="text" id="inputpassword2" v-model="password" placeholder="输入登录密码" class="input-xlarge" />-->
          <!--            </div>-->
          <!--          </div>-->
          <div class="controls">
            <label> <input type="checkbox" name="remember-me"/><span class="type-text"
                                                                     style="font-size:12px;">记住登录状态</span> </label>
            <button type="button" class="sui-btn btn-danger btn-yes" @click="login">登 录</button>
          </div>
          <!-- <div class="other-methods"></div> -->
          <!-- <el-button type="success">微信登入</el-button> -->
          <!-- <div id="weixin"></div> -->
        </form>
      </div>
    </div>

  </div>
</template>
<script>
import '~/assets/css/page-sj-person-loginsign.css'
import userApi from '@/api/user'
import {setUser} from '@/utils/auth'

export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.pojo.checkPass !== '') {
          this.$refs.pojo.validateField('checkPass');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.pojo.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      checked:false,
      pojo: {},
      ruleForm: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
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
        ],
        agree: [
          {required: true, message: '请输入勾选', trigger: 'blur'},
        ],
      },
    }
  },
  methods: {
    sendsms() {
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
      userApi.login(this.usernameLog, this.passwordLog).then(res => {
        if (res.data.code === 20000) {
          //保存用户信息,用户ID暂时用1代替
          setUser(res.data.data.id, res.data.data.token, res.data.data.name, res.data.data.avatar)
          location.href = '/manager'
        } else {
          this.$message({
            message: '用户名或密码错误',
            type: 'error'
          })
          this.usernameLog = ''
          this.passwordLog = ''
        }
      })
    }
  }
}
</script>

