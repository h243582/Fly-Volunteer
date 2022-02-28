<template>
  <div>
    <div id="top">
      <i class="el-icon-platform-eleme"></i>
      管理员界面
    </div>
    <div id="left">
      <el-col :span="20">
        <el-menu
            default-active="2"
            class="el-menu-vertical-demo">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-user"></i>
              <span>人员信息管理</span>
            </template>
            <el-menu-item-group>
              <template slot="title">用户</template>
              <router-link to="/admin/user" class="router_link">
                <el-menu-item>用户管理</el-menu-item>
              </router-link>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-reading"></i>
              <span>学校信息管理</span>
            </template>
            <el-menu-item-group>
              <template slot="title">学校列表</template>
              <router-link to="/admin/school" class="router_link">
                <el-menu-item>学校管理</el-menu-item>
              </router-link>
              <router-link to="/admin/school-type" class="router_link">
                <el-menu-item>学校类型</el-menu-item>
              </router-link>
              <router-link to="/admin/school" class="router_link">
                <el-menu-item>学校管理</el-menu-item>
              </router-link>
              <router-link to="/admin/school" class="router_link">
                <el-menu-item>学校管理</el-menu-item>
              </router-link>
            </el-menu-item-group>
          </el-submenu>


          <el-menu-item index="2">
            <i class="el-icon-reading"></i>
            <span slot="title">学校信息管理</span>
          </el-menu-item>
          <el-menu-item index="3" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">导航三</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title">导航四</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </div>
    <div id="left_block">
      <nuxt/>
    </div>
  </div>

</template>

<script>
export default {
  name: "admin"
}
</script>

<style scoped>
#top {
  width: 100%;
  height: 40px;
  padding-left: 20px;
  background-color: #fa5846;
  color: #faf3f5;
  font-size: 20px;
}

#left {
  position: absolute;
  display: block;
  height: 800px;
  width: 250px;
  /*background-color: #00a854;*/
  float: left;

}

#left_block {
  margin-top: 40px;
  margin-left: 250px;

  /*height: 800px;*/
  /*width: 200px;*/
}

.router_link {
  text-decoration: none
}
</style>
