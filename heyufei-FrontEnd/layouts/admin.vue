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
            class="el-menu-vertical-demo"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-user"></i>
              <span>人员信息管理</span>
            </template>
            <el-menu-item-group>
              <router-link to="/admin/user" class="router_link">
                <el-menu-item index="1-1">用户管理</el-menu-item>
              </router-link>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-reading"></i>
              <span>学校信息管理</span>
            </template>
            <el-menu-item-group>
              <router-link to="/admin/school" class="router_link">
                <el-menu-item index="2-1">学校管理</el-menu-item>
              </router-link>

              <router-link to="/admin/school-type" class="router_link">
                <el-menu-item index="2-2">学校类型</el-menu-item>
              </router-link>

              <router-link to="/admin/school-department" class="router_link">
                <el-menu-item index="2-3">学校所属部门</el-menu-item>
              </router-link>

<!--              <router-link to="/admin/school-departmentType" class="router_link">-->
<!--                <el-menu-item index="2-4">教育主管部门类别</el-menu-item>-->
<!--              </router-link>-->

            </el-menu-item-group>
          </el-submenu>


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

element.style {
  padding-left: 20px;
  color: rgb(90, 87, 87);
  background-color: rgb(228, 229, 230);
}
</style>
