<template>
  <div>
    <div style="margin-top: 20px">
      <el-button @click="toggleSelection()">调用</el-button>
<!--      <div value-format="timestamp">{{ demo }}</div>-->

    </div>
    <el-table
        :data="tableData.filter(data => !search || data.username.toLowerCase().includes(search.toLowerCase()))"
        height="600"
        border
        :class="success-row"
        :row-class-name="tableRowClassName"
        style="width: 1250px">

      <el-table-column
          type="selection"
          width="45">
      </el-table-column>
      <el-table-column
          prop="id"
          sortable
          label="编号"
          width="80">
      </el-table-column>
      <el-table-column
          prop="avatar"
          sortable
          label="头像"
          width="105">
        <template  slot-scope="scope">
          <img :src="scope.row.avatar" style="width: 50px;height: 50px;border: 1px solid black;border-radius: 60px" alt="">
        </template>
      </el-table-column>
      <el-table-column
          prop="email"
          sortable
          label="邮箱"
          width="160">
      </el-table-column>
      <el-table-column
          prop="password"
          sortable
          label="密码"
          show-overflow-tooltip
          width="140">
      </el-table-column>
      <el-table-column
          prop="nickname"
          sortable
          label="昵称"
          width="110">
      </el-table-column>
      <el-table-column
          prop="isVip"
          sortable
          label="是否vip"
          width="95">
        <template  slot-scope="scope">
          <div v-if="scope.row.isVip===0">
            否
          </div>
          <div v-if="scope.row.isVip===1">
            是
          </div>
        </template>
      </el-table-column>
      <el-table-column
          prop="registerDate"
          sortable
          label="注册日期"
          width="150">
        <template  slot-scope="scope">
          {{formateDate(scope.row.registerDate)}}
        </template>
      </el-table-column>
      <el-table-column
          prop="updateDate"
          sortable
          label="修改日期"
          width="150">
        <template  slot-scope="scope">
          {{formateDate(scope.row.updateDate)}}
        </template>
      </el-table-column>
      <el-table-column
          fixed="right"
          width="150">
        <template slot="header" slot-scope="scope">
          <el-input
              v-model="search"
              placeholder="搜索用户名">
          </el-input>
        </template>

        <template slot-scope="scope">
          <el-button
              size="mini"
              type="success"
              @click.native.prevent="updateUser(scope.$index, tableData)">编辑
          </el-button>
          <el-button
              size="mini"
              type="warning"
              @click.native.prevent="deleteRow(scope.$index, tableData)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        background
        layout="prev, pager, next"
        :current-page.sync="pageNo"
        :total=length>
    </el-pagination>

    <el-dialog title= "用户编辑" :visible.sync="dialogFormVisible">
      <el-form ref="user" label-width="80px">
        <el-form-item label="头像">
          <img :src="user.avatar" style="width: 50px;height: 50px;border: 1px solid black;border-radius: 60px" alt="">
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="user.email" v-bind:disabled="true" ></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input type="password" v-model="user.password" ></el-input>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="user.nickname" id="nickname" ></el-input>
        </el-form-item>
<!--        <el-checkbox-group v-model="user.isVip">-->
<!--          <el-checkbox-button label="美食/餐厅线上活动" name="type"></el-checkbox-button>-->
<!--        </el-checkbox-group>-->

<!--        <el-form-item label="是否会员">-->
<!--          <el-switch v-model="isvipComputed(user.isVip)"></el-switch>-->
<!--        </el-form-item>-->
        <el-form-item label="注册日期">
          <el-input :placeholder="formateDate(user.registerDate)" id="register_date"  v-bind:disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="修改日期">
          <el-input :placeholder="formateDate(user.updateDate)" id="update_date"  v-bind:disabled="true"></el-input>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="formSubmit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import userApi from "@/api/user";

export default {
  layout: 'admin',
  name: 'node',

  // async asyncData () {
  //   const Uid = Cookie.get('Uid');
  //   await axios.post('/admin/base/shortcut',qs.stringify({
  //     nodeId: '5',
  //     uid: Uid,
  //   }));
  //   let { data } = await axios.get('/admin/user/lists')
  //   return {
  //     pageNow: data.page.now || 1 ,
  //     pageSize: data.page.size || 10 ,
  //     pageCount: data.page.count || 0 ,
  //     lists: data.lists || []
  //   }
  // },
  data() {
    return {
      pageNo:1,
      length: 60,
      readonly: 'readonly',
      form: '',
      search: '',
      success: '',
      row: '',
      dialogFormVisible: false,
      user: {},
      tableData: [],
      userIdToString:'',
      demo:1639487312000
    }
  },
  created() {
    userApi.getAllUserListLimit(this.pageNo,10 ).then( res=>{
      console.log("返回的参数：");
      if (res.data.code === 20000) {
        var arrays = res.data.data.rows
        console.log(arrays)
      }

      this.tableData = arrays
    })
  },
  methods:{
    formateDate(datetime) {
      function addDateZero(num) {
        return (num < 10 ? "0" + num : num);
      }

      let d = new Date(datetime);
      let formatdatetime = d.getFullYear() + '-' + addDateZero(d.getMonth() + 1) + '-' + addDateZero(d.getDate()) + '  ' + addDateZero(d.getHours()) + ':' + addDateZero(d.getMinutes() + ':' + addDateZero(d.getSeconds()));
      return formatdatetime;
    },
    tableRowClassName({row, rowIndex}) {
      //双数设置背景
      if (rowIndex % 2 === 1) {
        return 'success-row';
      }
      return '';
    },
    deleteRow(index, rows) {
      var id = rows[index].id;
      // $.ajax({
      //   type: 'post',
      //   url: '${pageContext.request.contextPath}/deleteUser',
      //   data: {'id': id},
      //   success: (id) => {
      //     alert(id)
      //   }
      // })
      //删除行
      rows.splice(index, 1);
    },
    toggleSelection() {
      alert("调用")
    },
    updateUser(index, rows) {
      this.dialogFormVisible = true;
      this.user.id = rows[index].id;
      this.user.email = rows[index].email;
      // this.user.password = rows[index].password;
      this.user.nickname = rows[index].nickname;
      this.user.isVip = rows[index].isVip;
      this.user.registerDate = rows[index].registerDate;
      this.user.updateDate = rows[index].updateDate;
      this.user.avatar = rows[index].avatar;
    },
    formSubmit(){
      this.dialogFormVisible = false;
      console.log(this.user);

      // userApi.saveinfo(this.user).then( res=>{
      //   console.log("返回的参数：");
      //   if (res.data.code === 20000) {
      //     var arrays = res.data.data.rows
      //     console.log(arrays)
      //   }
      //
      //   this.tableData = arrays
      // })

      // var index = $(".el-pager>.active")[0].innerText;

      // $.ajax({
      //   type: 'post',
      //   url: '${pageContext.request.contextPath}/updateUser',
      //   data: {"index":index-1,
      //     id: this.user.id,
      //     username: this.user.username,
      //     phone: this.user.phone,
      //     password: this.user.password,
      //     name: this.user.name,
      //     sex: this.user.sex,
      //     purviewId: this.user.purviewId,
      //     department:this.user.department,
      //     position: this.user.position
      //   },
      //   success: (data) => {
      //     this.tableData = data.data;
      //     this.length = data.userCounts;
      //   }
      // })
    },
  },
  computed:{
      isvipComputed: function (isvip){
        return isvip!==0
      }
  }


};
</script>
