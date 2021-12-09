
<template>
  <div class="wrapper loginsign">

    <!-- 注册 -->
    <div class="item signup">
      <div class="form">
        <h3 class="loginsign-title">注册新账号</h3>
        <form class="sui-form">
          <div class="control-group">
            <label for="inputname" class="control-label">名字</label>
            <div class="controls">
              <input type="text" id="inputname" v-model="pojo.nickname" placeholder="真实姓名或常用昵称" class="input-xlarge" />
            </div>
          </div>
          <div class="different">
            <div class="radio-content">
              <div id="a1" class="phone">
                <div class="control-group number">
                  <input type="text" v-model="pojo.mobile" placeholder="仅支持大陆手机号" class="input-xlarge" />
                </div>
                <div class="control-group code">
                  <div class="input-append">
                    <input id="appendedInputButton" type="text" placeholder="短信验证" class="span2 input-large msg-input" />
                    <button type="button" class="sui-btn msg-btn" @click="sendsms" >获取验证码</button>
                  </div>
                </div>
                <div class="control-group">
                  <label for="inputpassword" class="control-label">密码</label>
                  <div class="controls">
                    <input type="text" v-model="pojo.password" id="inputpassword" placeholder="请输入6-16位密码" class="input-xlarge" />
                  </div>
                </div>
              </div>
              <!-- <div id="a2" class="email">
               <div class="control-group inputemail">
                <input type="text" placeholder="输入手机号" class="input-xlarge" />
               </div>
               <div class="control-group">
                <label for="inputpassword" class="control-label">密码：</label>
                <div class="controls">
                 <input type="text" id="inputpassword" placeholder="请输入6-16位字符" class="input-xlarge" />
                </div>
               </div>
              </div>  -->
            </div>
          </div>
          <div class="control-group btn-signup">
            <label class="control-label"></label>
            <div class="controls">
              <label> <input type="checkbox" /><span class="type-text" style="font-size:12px;">同意协议并接受《服务条款》</span> </label>
              <button type="button" class="sui-btn btn-danger btn-yes" @click="register">注 册</button>
            </div>
          </div>
        </form>
      </div>
    </div>

    <!-- 登入 -->
    <div class="item">
      <div class="form">
        <h3 class="loginsign-title">用户登录</h3>
        <form class="sui-form login-form">
          <div class="control-group">
            <label for="inputname" class="control-label">用户名：</label>
            <div class="controls">
              <input type="text" id="inputname" v-model="username" placeholder="11位手机号或Email" class="input-xlarge" data-rules="required" />
            </div>
          </div>
          <div class="control-group">
            <label for="inputpassword" class="control-label">密码：</label>
            <div class="controls">
              <input type="text" id="inputpassword" v-model="password" placeholder="输入登录密码" class="input-xlarge" />
            </div>
          </div>
          <div class="controls">
            <label> <input type="checkbox" name="remember-me" /><span class="type-text" style="font-size:12px;">记住登录状态</span> </label>
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
  data(){
    return {
      pojo: {},
      username: '',
      password: ''
    }
  },
  methods :{
    sendsms () {
      userApi.sendsms(this.pojo.mobile).then( res =>{
        if(res.data.flag){
          this.$message({
            message: '验证码已发送成功',
            type: 'success'
          })
        }else{
          this.$message({
            message: '发送验证码出错',
            type: 'error'
          })
        }
      })
    },
    register () {
      userApi.register(this.pojo).then( res =>{
        if(res.data.flag){
          this.$message({
            message: '注册成功',
            type: 'success'
          })
          this.pojo={}
        }else{
          this.$message({
            message: '注册出错',
            type: 'error'
          })
        }
      })
    },
    login () {
      userApi.login(this.username,this.password).then( res =>{
        if(res.data.code==20000){
          //保存用户信息,用户ID暂时用1代替
          setUser(res.data.data.id, res.data.data.token, res.data.data.name,res.data.data.avatar)
          location.href='/manager'
        }else{
          this.$message({
            message: '用户名或密码错误',
            type: 'error'
          })
          this.username=''
          this.password=''
        }
      })
    }
  }
  // mounted(){  //钩子函数，整个页面被渲染后才执行
  //     var obj = new WxLogin({
  //         id: "weixin",
  //         appid: "wx3bdb1192c22883f3",
  //         scope: "snsapi_login",
  //         redirect_uri: "http://note.java.itcast.cn/weixinlogin"
  //     });
  // },
  // head: {
  //     script:[
  //         {src:'http://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js'}
  //     ]
  // }
}
</script>

