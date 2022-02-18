<template>
  <div class="login-container">
    <el-form autoComplete="on" :model="loginForm" :rules="loginRules" ref="loginForm" label-position="left"
             label-width="0px"
             class="card-box login-form">
      <h3 class="title">后台管理</h3>

      <!--  账号   -->
      <el-form-item prop="email">
        <span class="svg-container svg-container_login">
          <i class="el-icon-s-custom"></i>
        </span>
        <el-input name="email" type="text" v-model="loginForm.email" autoComplete="on" placeholder="email"/>
      </el-form-item>

      <!--  密码   -->
      <el-form-item prop="password">
        <span class="svg-container">
          <i class="el-icon-lock"></i>
        </span>
        <el-input name="password" :type="pwdType" @keyup.enter.native="handleLogin" v-model="loginForm.password"
                  autoComplete="on" placeholder="password"></el-input>
        <span class="show-pwd" @click="showPwd"><i class="el-icon-view"></i></span>

      </el-form-item>

      <el-form-item>
        <el-button type="primary" style="width:100%;" :loading="loading" @click.native.prevent="handleLogin">
          Sign in
        </el-button>
      </el-form-item>
      <div class="tips">
        <span style="margin-right:20px;">username: admin</span>
        <span> password: admin</span>
      </div>
    </el-form>
  </div>
</template>


<script>
import {isvalidUsername} from '@/utils/validate'
import userApi from "@/api/user";
import {getUser, setUser} from "@/utils/auth";

export default {
  layout: 'admin',
  name: 'admin_login',
  data() {
    const validateUsername = (rule, value, callback) => {
      if (!isvalidUsername(value)) {
        callback(new Error('请输入正确的用户名'))
      } else {
        callback()
      }
    }
    const validatePass = (rule, value, callback) => {
      if (value.length < 1) {
        callback(new Error('密码不能小于5位'))
      } else {
        callback()
      }
    }
    return {
      loginForm: {
        email: 'admin',
        password: 'admin'
      },
      loginRules: {
        email: [{required: true, trigger: 'blur', validator: validateUsername}],
        password: [{required: true, trigger: 'blur', validator: validatePass}]
      },
      loading: false,
      pwdType: 'password'
    }
  },
  created() {

  },
  methods: {
    //显示密码
    showPwd() {
      if (this.pwdType === 'password') {
        this.pwdType = ''
      } else {
        this.pwdType = 'password'
      }
    },
    handleLogin() {
      if (this.loginForm.email === "admin") {
        userApi.login(this.loginForm.email, this.loginForm.password).then(res => {
          if (res.data.code === 20000) {
            //保存用户信息,用户ID暂时用1代替
            setUser(undefined, res.data.data.token, undefined, undefined, undefined, undefined)
            location.href = '/admin/user'
            // console.log(getUser().token)
          } else {
            this.$message({
              message: '用户名或密码错误',
              type: 'error'
            })
            // this.email = ''
            this.password = ''
          }
        })
      }
    }

  }

}
</script>

<style scoped>


.login-container {
  position: fixed;
  height: 100%;
  width: 100%;
  background-color: #2d3a4b;
}

input:-webkit-autofill {
  -webkit-box-shadow: 0 0 0px 1000px #293444 inset !important;
  -webkit-text-fill-color: #fff !important;
}

input {
  background: transparent;
  border: 0px;
  -webkit-appearance: none;
  border-radius: 0px;
  padding: 12px 5px 12px 15px;
  color: #eee;
  height: 47px;
}

.el-input {
  display: inline-block;
  height: 47px;
  width: 85%;
}

.tips {
  font-size: 14px;
  color: #fff;
  margin-bottom: 10px;
}

.svg-container {
  padding: 6px 5px 6px 15px;
  color: #889aa4;
  vertical-align: middle;
  width: 30px;
  display: inline-block;


}

.title {
  font-size: 26px;
  font-weight: 400;
  color: #eee;
  margin: 0px auto 40px auto;
  text-align: center;
  font-weight: bold;
}

.login-form {
  position: absolute;
  left: 0;
  right: 0;
  width: 400px;
  padding: 35px 35px 15px 35px;
  margin: 120px auto;
}

.el-form-item {
  border: 1px solid rgba(255, 255, 255, 0.1);
  background: rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  color: #454545;
}

.show-pwd {
  position: absolute;
  right: 10px;
  top: 7px;
  font-size: 16px;
  color: #889aa4;
  cursor: pointer;
  user-select: none;
}

.thirdparty-button {
  position: absolute;
  right: 35px;
  bottom: 28px;
}

</style>
