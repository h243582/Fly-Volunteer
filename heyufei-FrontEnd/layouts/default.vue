<template>
  <div>
    <header>
      <div class="ch-nav-box-index">
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
                  <a href="/zyk/pub/myd/schAppraisalTop.action" target="_blank" >院校满意度</a>
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
                  <a href="/zxd" target="_blank" >咨询室</a>
                </li>

                <li class="nav-long-name">
                  <a href="/zyck/" target="_blank">高考填报志愿参考</a>
                </li>
              </ul>
            </li>


            <li  v-if="user.token !== undefined" >
              <el-button type="success"  plain size="mini" style="margin-top: 26px;margin-left: 5px" >登入</el-button>
            </li>

            <!-- 已登入时，显示用户名和头像 -->
            <li v-if="user.name === undefined">
                <router-link to="/manager">
                  <el-button type="primary" plain style="margin-top: -26px;margin-left: 5px">{{user.name}}</el-button>
                  <el-avatar shape="square"  :src="user.avatar" style="margin-top: 26px;margin-left: 5px"/>
                </router-link>
                <el-button type="danger" plain size="mini" @click="logout">注销</el-button>
            </li>
          </ul>
        </div>

      </div>
    </header>

    <nuxt />

    <!-- 尾部 -->
    <div class="footer-wrapper">
      <div class="footer">
        <div class="footer-list">
          <a href="//www.chsi.com.cn/" target="_blank">学信网</a>
          <a href="https://chesicc.chsi.com.cn/zxgw/zxjs/201604/20160418/1529506207.html" target="_blank">中心简介</a>
          <a href="//www.chsi.com.cn/about/contact.shtml" target="_blank">联系我们</a>
          <a href="//www.chsi.com.cn/about/copyright.shtml" target="_blank">版权声明</a>
          <a href="/sitemap.jsp" target="_blank">网站地图</a>
          <a href="/help/" target="_blank">帮助中心</a>
          <a href="//www.chsi.com.cn/ad/index.shtml" target="_blank">网站宣传</a>
        </div>
        <div class="footer-units">
          主办单位：<a href="https://chesicc.chsi.com.cn/" target="_blank">全国高等学校学生信息咨询与就业指导中心</a><br>
          Copyright © 2003-2021 <a href="//www.chsi.com.cn/" target="_blank">学信网</a> All Rights Reserved<br>
          <a href="http://beian.miit.gov.cn" target="_blank">京ICP备19004913号-1</a>
          <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010202009747" target="_blank">
            <img src="https://t1.chei.com.cn/chsi/images/jgwab.png" style="vertical-align: middle; margin-bottom: 2px; margin-left: 8px;"> 京公网安备11010202009747号</a>
        </div>
        <div class="footer-media">
          <a href="javascript:;"><i class="iconfont" title="官方微信">&#xe694;</i>官方微信<img src="/news/file.do?method=downFile&amp;id=1537666622"></a>
          <a href="http://weibo.com/chsigk" target="_blank"><i class="iconfont" title="官方微博">&#xe693;</i>官方微博</a>
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
import { getUser, removeUser } from "@/utils/auth";
import userApi from "@/api/user";



export default {
  data() {
    return {
      user: {},
    };
  },
  created() {
    this.user = getUser();
  },
  methods: {
    logout() {
      userApi.logout().then((res) => {});
      removeUser(); //清除登陆用户信息
      location.href = "/login";
    },
  },
};
</script>
