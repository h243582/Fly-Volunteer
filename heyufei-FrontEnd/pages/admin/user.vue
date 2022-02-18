<template>
  <div>
    <br>
    <!-- 此处是顶部搜索栏   -->
    <el-form :inline="true">
      <el-form-item label="邮箱">
        <el-input v-model="searchMap.email" placeholder="邮箱"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="searchMap.password" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="searchMap.nickname" placeholder="昵称"></el-input>
      </el-form-item>
      <!--      <el-form-item label="头像">-->
      <!--        <el-input v-model="searchMap.avatar" placeholder="头像"></el-input>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="注册日期">-->
      <!--        <el-input v-model="searchMap.registerDate" placeholder="注册日期"></el-input>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="修改日期">-->
      <!--        <el-input v-model="searchMap.updateDate" placeholder="修改日期"></el-input>-->
      <!--      </el-form-item>-->
      <el-form-item label="是否会员">
        <el-switch v-model="searchMap.isVip" placeholder="是否会员"></el-switch>

      </el-form-item>

      <el-button type="primary" @click="fetchData()">查询</el-button>
      <el-button type="primary" @click="addEdit()">新增</el-button>
      <el-button type="primary" @click="reset()">重置</el-button>
    </el-form>
    <el-table
        :data="list"
        border    >
      <!--      <el-table-column prop="id" label="ID" width="160" show-overflow-tooltip></el-table-column>-->
      <el-table-column prop="email" label="邮箱" width="170"></el-table-column>
      <!--      <el-table-column prop="password" label="密码" width="100" show-overflow-tooltip></el-table-column>-->
      <el-table-column prop="nickname" label="昵称" width="130"></el-table-column>
      <el-table-column prop="avatar" label="头像" width="80">
        <template slot-scope="scope">
          <img :src="scope.row.avatar" style="width: 50px;height: 50px;border: 1px solid black;border-radius: 60px"
               alt="">
        </template>
      </el-table-column>
      <el-table-column prop="register_date" label="注册日期" width="180">
        <template slot-scope="scope">
          {{ formatDate(scope.row.registerDate) }}
        </template>
      </el-table-column>
      <el-table-column prop="update_date" label="修改日期" width="180">
        <template slot-scope="scope">
          {{ formatDate(scope.row.updateDate) }}
        </template>
      </el-table-column>
      <el-table-column prop="isVip" label="是否会员" width="80">
        <template slot-scope="scope">
          <div v-if="scope.row.isVip===false">
            否
          </div>
          <div v-if="scope.row.isVip===true">
            是
          </div>
        </template>
      </el-table-column>

      <el-table-column
          label="操作"
          width="200">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.row.id)" type="success" size="small">修改</el-button>
          <el-button @click="handleDelete(scope.row.id)" type="warning" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5,10,20,50]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
    <el-dialog title="编辑" :visible.sync="dialogFormVisible">
      <el-form label-width="80px">
        <el-form-item label="头像">
            <el-upload
                class="avatar-uploader"
                action="#"
                :show-file-list="false"
                :before-upload="beforeAvatarUpload"
                :http-request="uploadImg"
                v-loading="imgProgress">

              <img v-if="pojo.avatar" :src="pojo.avatar" class="avatar" alt="">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
        </el-form-item>

        <el-form-item label="邮箱">
          <el-input v-model="pojo.email" v-bind:disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="pojo.password"></el-input>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="pojo.nickname"></el-input>
        </el-form-item>
        <el-form-item label="注册日期">
          <el-input :placeholder="formatDate(pojo.registerDate)" id="register_date" v-bind:disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="修改日期">
          <el-input :placeholder="formatDate(pojo.updateDate)" id="update_date" v-bind:disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="是否会员">
          <el-switch v-model="pojo.isVip"></el-switch>
        </el-form-item>

        <el-button type="primary" @click="handleUpdate()">保存</el-button>
        <el-button @click="dialogFormVisible = false">关闭</el-button>
      </el-form>
    </el-dialog>

    <el-dialog title="新增用户" :visible.sync="addFormVisible">
      <el-form label-width="80px">
        <el-form-item label="头像">
          <el-upload
              class="avatar-uploader"
              action="#"
              :show-file-list="false"
              :before-upload="beforeAvatarUpload"
              :http-request="uploadImg"
              v-loading="imgProgress">

            <img v-if="pojo.avatar" :src="pojo.avatar" class="avatar" alt="">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>

        <el-tooltip class="item" effect="dark" content="Right Center 提示文字" placement="top" :disabled="visible">
        <el-form-item label="邮箱">
<!--          <el-popover-->
<!--              placement="right-end"-->
<!--              width="80"-->
<!--              trigger="manual"  offset = 90-->
<!--              v-model="visible">-->
<!--              {{emailMessage}}-->
<!--          </el-popover>-->
            <el-input v-model="pojo.email" v-on:blur="findEmail()"></el-input>
<!--          <el-input v-model="pojo.email" v-on:blur="findEmail()"></el-input>-->

        </el-form-item>
        </el-tooltip>


        <el-form-item label="密码">
          <el-input v-model="pojo.password"></el-input>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="pojo.nickname"></el-input>
        </el-form-item>
        <el-form-item label="是否会员">
          <el-switch v-model="pojo.isVip"></el-switch>
        </el-form-item>

        <el-button type="primary" @click="handleAdd()">保存</el-button>
        <el-button @click="addFormVisible = false">关闭</el-button>
      </el-form>
    </el-dialog>

  </div>
</template>
<script>
import userApi from '@/api/user'
import COS from "cos-js-sdk-v5";
import "~/assets/css/admin/user.css"

export default {
  layout: 'admin',
  name: 'user',
  data() {
    return {
      list: [],
      total: 0, // 总记录数
      currentPage: 1, // 当前页
      pageSize: 5, // 每页大小
      searchMap: {}, // 查询条件
      dialogFormVisible: false, // 编辑窗口是否可见
      addFormVisible: false, // 新增用户窗口是否可见
      pojo: {}, // 编辑表单绑定的实体对象0
      cityList: [], // 城市列表
      id: '', // 当前用户修改的ID
      imgProgress: false,
      emailMessage: '',
      visible: true

    }
  },
  created() {
    this.fetchData()
  },
  methods: {

    findEmail(){
      if (this.pojo.email === ''|| this.pojo.email === undefined ) return
      userApi.findByEmail(this.pojo.email).then(response => {
        this.visible = true
        if (response.data.data===null){
          this.emailMessage = '邮箱可用'
        }else {
          this.emailMessage = '邮箱已存在不可用'
        }

      })
    },
    //重置分页列表
    reset() {
      this.currentPage = 1
      this.pageSize = 5
      this.searchMap = {}
      this.fetchData();
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.fetchData()
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.fetchData()
    },

    //分页刷新列表
    fetchData() {
      userApi.search(this.currentPage, this.pageSize, this.searchMap).then(response => {
        this.list = response.data.data.rows
        this.total = response.data.data.total


      })
    },

    // 打开新增用户窗口
    addEdit() {
      this.addFormVisible = true // 打开窗口
      this.pojo = {} // 清空数据
    },

    //新增用户的提交按钮
    handleAdd() {
      userApi.addUser(this.pojo).then(response => {
        this.$message({
          message: response.data.message,
          type: (response.data.flag ? 'success' : 'error')
        })
        if (response.data.flag) { // 如果成功
          this.fetchData() // 刷新列表
        }
      })
      this.addFormVisible = false // 关闭窗口
    },

    //用于打开修改窗口和显示修改的用户信息
    handleEdit(id) {
      this.id = id
      this.dialogFormVisible = true // 打开窗口
      if (id !== '') { // 修改
        userApi.findById(id).then(response => {
          if (response.data.flag) {
            this.pojo = response.data.data
            this.pojo.password = ''
          }
        })
      } else {
        this.pojo = {} // 清空数据
      }
    },

    //修改用户
    handleUpdate() {
      userApi.updateUser(this.id, this.pojo).then(response => {
        this.$message({
          message: response.data.message,
          type: (response.data.flag ? 'success' : 'error')
        })
        if (response.data.flag) { // 如果成功
          this.fetchData() // 刷新列表
        }
      })
      this.dialogFormVisible = false // 关闭窗口
    },

    //删除记录
    handleDelete(id) {
      this.$confirm('确定要删除此纪录吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        userApi.deleteById(id).then(response => {
          this.$message({message: response.data.message, type: (response.data.flag ? 'success' : 'error')})
          if (response.data.flag) {
            this.fetchData() // 刷新数据
          }
        })
      })
    },

    //格式化
    formatDate(datetime) {
      function addDateZero(num) {
        return (num < 10 ? "0" + num : num);
      }

      let d = new Date(datetime);
      return d.getFullYear() + '年' + addDateZero(d.getMonth() + 1) + '月' + addDateZero(d.getDate()) + '     ' + addDateZero(d.getHours()) + ':' + addDateZero(d.getMinutes() + ':' + addDateZero(d.getSeconds()));
    },
    fileDateFormat(fmt, date) {
      let ret;
      const opt = {
        "Y+": date.getFullYear().toString(),        // 年
        "m+": (date.getMonth() + 1).toString(),     // 月
        "d+": date.getDate().toString(),            // 日
        "H+": date.getHours().toString(),           // 时
        "M+": date.getMinutes().toString(),         // 分
        "S+": date.getSeconds().toString()          // 秒
        // 有其他格式化字符需求可以继续添加，必须转化成字符串
      };
      for (let k in opt) {
        ret = new RegExp("(" + k + ")").exec(fmt);
        if (ret) {
          fmt = fmt.replace(ret[1], (ret[1].length === 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
        }
      }
      return fmt;
    },

    //上传头像
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
    uploadImg(res) {
      if (res.file) {
        this.imgProgress = true
        // 下面的代码是固定写法
        // 填写自己腾讯云cos中的key和id (密钥)
        const cos = new COS({
          SecretId: 'AKIDY2PVXMBrCMQYUFwfGi40kPq1QcYCckdf', // 身份识别ID
          SecretKey: 'z8x43NhlbFFVdW7ZptIRKyMh1A4uWtSR' // 身份秘钥
        })
        let date = new Date();

        // 执行上传操作
        cos.putObject({
          Bucket: 'heyufei-1305336662', /* 存储桶 */
          Region: 'ap-shanghai', /* 存储桶所在地域，必须字段 */
          Key: '/Fly-Volunteer/Head-' + this.fileDateFormat("YYYYmmddHHMM", date) + res.file.name, /* 文件名 */
          StorageClass: 'STANDARD', // 上传模式, 标准模式
          Body: res.file, // 上传文件对象
          // onProgress: (progressEvent) => { // 上传进度
          //   let num = progressEvent.loaded / progressEvent.total * 100 | 0;  //百分比
          //   if (num !== undefined) {
          //     this.progress = num
          //   }
          // }
        }, (err, data) => {
          // 上传成功之后
          if (data.statusCode === 200) {
            this.imgProgress = false
            this.pojo.avatar = `https:${data.Location}`
          }
        })
      }


    },
  }
}
</script>


