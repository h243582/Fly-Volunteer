<template>
  <div>
    <div class="header-wrapper zx-yx-header-wrapper"
         style="background-image: url('https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/joinInSchool-backgroud.png');padding-left: 1%">
      <div class="zx-yx-header">
        <h1 class="zx-yx-title">
          <a href="">{{ school.schoolName }}<i class="el-icon-s-custom"></i></a>
          <span class="zx-yx-gz">795人关注</span>
        </h1>
        <div class="zx-yx-baseinfo">
          <div style="display: inline-block;margin-right: 25px;">
            <span>教育行政主管部门：</span>{{school.department}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span>所在地：</span>{{school.province}}<br>
            <span>院校特性：</span>
          </div>
          <a class="ch-btn zx-question" href="/" target="_blank">在线咨询</a>
          <a class="ch-btn zx-question" href="/" target="_blank">招生章程</a>
        </div>
      </div>
    </div>
    <div>
      <el-menu :default-active=1 class="el-menu-demo" mode="horizontal"  background-color="#1CB278" text-color="#fff"	active-text-color="#fff"	style="padding-left: 16%"	>
        <el-menu-item :index=1><a href="/school/schoolInformation/">学校首页</a></el-menu-item>
        <el-menu-item :index=2><a href="/school/schoolInformation/">学校简介</a></el-menu-item>
        <el-menu-item :index=3><a href="/school/schoolInformation/">院系设置</a></el-menu-item>
        <el-menu-item :index=4><a href="/school/schoolInformation/">专业介绍</a></el-menu-item>
        <el-menu-item :index=5><a href="/school/schoolInformation/">招生简章</a></el-menu-item>
        <el-menu-item :index=6><a href="/school/schoolInformation/">录取规则</a></el-menu-item>
        <el-menu-item :index=7><a href="/school/schoolInformation/">奖学金设置</a></el-menu-item>
        <el-menu-item :index=8><a href="/school/schoolInformation/">食宿条件</a></el-menu-item>
        <el-menu-item :index=9><a href="/school/schoolInformation/">往年录取信息</a></el-menu-item>
      </el-menu>
    </div>
    <nuxt/>
  </div>
</template>

<script>
import Cookie from "js-cookie";

export default {
  name: "schoolInformation",
  data() {
    return {
      id: 1,
      schoolInformation: {},
      school: {
        department: "",
        hasGraduateSchool: "",
        id: "",
        isTopDiscipline: "",
        isTopUniversity: "",
        level: "",
        province: "",
        satisfaction: "",
        schoolName: "",
        schoolType: ""
      },
    }
  },
  created() {
    var schoolInformation = Cookie.get("schoolInformation");

    if (schoolInformation!==undefined){
      this.school = JSON.parse(schoolInformation);

    }
  }
}
</script>

<style scoped>

</style>
