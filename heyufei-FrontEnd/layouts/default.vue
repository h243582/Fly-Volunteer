<template>
  <div>
      <div class="ch-nav-box-index">cd
        <div class="nav-wrapper">
          <ul class="nav-index-list clearfix">
            <li>
              <img src="~/assets/img/game_bwlb3.png" style="margin: 16px" width="50" alt=""/>
            </li>

            <li class="nav-first-li clearfix">

              <div class="nav-th"><span>信息公开</span></div>

              <ul class="nav-td clearfix">
                <li style="margin-right: 1em">
                  <a href="/login" target="_blank">招生章程</a>
                </li>

                <li>
                  <a href="/zsgs" target="_blank">名单公示</a>
                </li>

                <li class="nav-long-name">
                  <a href="/xxgk" target="_blank">教育部招生政策规定</a>
                </li>
              </ul>
            </li>

            <li class="nav-cx clearfix">
              <div class="nav-th" style="margin-left: 30px">
                <span>大学</span>
              </div>

              <ul class="nav-td clearfix">
                <li><a href="/sch/" target="_blank">院校库</a></li>

                <li class="nav-long-name">
                  <a href="/zyk/pub/myd/schAppraisalTop.action" target="_blank">院校满意度</a>
                </li>

                <li>
                  <a href="/gkzt/zbft2021" target="_blank">招办访谈</a>
                </li>

                <li class="nav-long-name">
                  <a href="/gkzt/tszs" target="_blank">特殊类型招生</a>
                </li>
              </ul>
            </li>

            <li class="nav-ss clearfix">
              <div class="nav-th" style="margin-left: 30px">
                <span>专业</span>
              </div>

              <ul class="nav-td clearfix">
                <li><a href="/zyk/zybk/" target="_blank">专业库</a></li>

                <li class="nav-long-name">
                  <a href="/zyk/pub/myd/specAppraisalTop.action" target="_blank">专业满意度</a>
                </li>

                <li>
                  <a href="/zyk/pub/zytj/recommendTop.action" target="_blank">专业推荐</a>
                </li>

                <li>
                  <a href="/zyk/zybk/zyjd/listPage" target="_blank">专业解读</a>
                </li>
              </ul>
            </li>

            <li class="nav-zy clearfix">
              <div class="nav-th" style="margin-left: 30px">
                <span>志愿</span>
              </div>

              <ul class="nav-td clearfix" style="width: 165px">
                <li class="nav-long-name">
                  <a href="/zxdy/" target="_blank">咨询周</a>
                </li>

                <li class="nav-long-name">
                  <a href="/zxd" target="_blank">咨询室</a>
                </li>

                <li class="nav-long-name">
                  <a href="/zyck/" target="_blank">高考填报志愿参考</a>
                </li>
              </ul>
            </li>


            <li v-if="user.token === undefined">
              <router-link to="/login">
                  <el-button type="success" plain size="mini" style="margin-top: 26px;margin-left: 5px">登入</el-button>
              </router-link>
            </li>

            <!-- 已登入时，显示用户名和头像 -->
            <li v-if="user.name !== undefined">
              <router-link to="/login" style="float:left;margin-left: 5px;margin-top: 26px;" >
                <el-button plain size="mini" style="width: 70px;overflow: hidden;text-overflow: ellipsis;">{{ user.name }}</el-button>
              </router-link>
              <router-link to="/login" style="float:left;margin: 18px 5px ;line-height: inherit">
                <el-avatar :size="40" :src="user.avatar" />
              </router-link>
              <div style="float:left;margin-top: 26px;">
                <el-button type="danger" plain size="mini" @click="logout">注销</el-button>
              </div>
            </li>
          </ul>
        </div>

      </div>

    <nuxt/>

    <!-- 尾部 -->
    <div class="footer-wrapper">
      <div class="footer">
        <div class="footer-list">
          <a href="//www.chsi.com.cn/" target="_blank">学信网</a>
          <a href="" target="_blank">中心简介</a>
          <a href="//www.chsi.com.cn/about/contact.shtml" target="_blank">联系我们</a>
          <a href="//www.chsi.com.cn/about/copyright.shtml" target="_blank">版权声明</a>
          <a href="/sitemap.jsp" target="_blank">网站地图</a>
          <a href="/help/" target="_blank">帮助中心</a>
          <a href="//www.chsi.com.cn/ad/index.shtml" target="_blank">网站宣传</a>
        </div>
        <div class="footer-units">
          主办单位：<a href="https://chesicc.chsi.com.cn/" target="_blank">全国高等学校学生信息咨询与就业指导中心</a><br>
          Copyright © 2003-2021 <a >学信网</a> All Rights Reserved<br>
          <a href="http://beian.miit.gov.cn" target="_blank">京ICP备19004913号-1</a>
          <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010202009747">
            <img src="https://t1.chei.com.cn/chsi/images/jgwab.png"
                 style="vertical-align: middle; margin-bottom: 2px; margin-left: 8px;"> 京公网安备11010202009747号</a>
        </div>
        <div class="footer-msg">
          客服热线：010-67410388<br>
          客服邮箱：kefu#chsi.com.cn（将#替换为@）
        </div>
      </div>
    </div>
  </div>
</template>


<script>


import '~/assets/css/hyf-1.css'
import {getUser, removeUser} from "@/utils/auth";
import userApi from "@/api/user";


export default {
  name: "default",

  data() {
    return {
      user: {},
    };
  },
  created() {
    this.user = getUser();
    // this.user.avatar = 'https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img%2Fimage-20210514113216346.png';
    // this.user.name = '和方法1212313'
  },
  methods: {
    logout() {
      userApi.logout().then((res) => {
      });
      removeUser(); //清除登陆用户信息
      location.href = "/login";
    },
  },
};
</script>
