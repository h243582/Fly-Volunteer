<template>
  <div>
    <br>
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
      <el-form-item label="头像">
        <el-input v-model="searchMap.avatar" placeholder="头像"></el-input>
      </el-form-item>
      <el-form-item label="注册日期">
        <el-input v-model="searchMap.register_date" placeholder="注册日期"></el-input>
      </el-form-item>
      <el-form-item label="修改日期">
        <el-input v-model="searchMap.update_date" placeholder="修改日期"></el-input>
      </el-form-item>
      <el-form-item label="是否会员">
        <el-input v-model="searchMap.is_vip" placeholder="是否会员"></el-input>
      </el-form-item>

      <el-button type="primary" @click="fetchData()">查询</el-button>
      <el-button type="primary" @click="handleEdit('')">新增</el-button>
    </el-form>
    <el-table
      :data="list"
      border
      style="width: 100%">
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="email" label="邮箱" width="80"></el-table-column>
      <el-table-column prop="password" label="密码" width="80"></el-table-column>
      <el-table-column prop="nickname" label="昵称" width="80"></el-table-column>
      <el-table-column prop="avatar" label="头像" width="80"></el-table-column>
      <el-table-column prop="register_date" label="注册日期" width="80"></el-table-column>
      <el-table-column prop="update_date" label="修改日期" width="80"></el-table-column>
      <el-table-column prop="is_vip" label="是否会员" width="80"></el-table-column>

      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.row.id)" type="text" size="small">修改</el-button>
          <el-button @click="handleDelete(scope.row.id)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="fetchData"
      @current-change="fetchData"
      :current-page="currentPage"
      :page-sizes="[5,10,20]"
      :page-size="10"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
    <el-dialog title="编辑" :visible.sync="dialogFormVisible">
      <el-form label-width="80px">
        <el-form-item label="邮箱">
          <el-input v-model="pojo.email"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="pojo.password"></el-input>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="pojo.nickname"></el-input>
        </el-form-item>
        <el-form-item label="头像">
          <el-input v-model="pojo.avatar"></el-input>
        </el-form-item>
        <el-form-item label="注册日期">
          <el-input v-model="pojo.register_date"></el-input>
        </el-form-item>
        <el-form-item label="修改日期">
          <el-input v-model="pojo.update_date"></el-input>
        </el-form-item>
        <el-form-item label="是否会员">
          <el-input v-model="pojo.is_vip"></el-input>
        </el-form-item>

        <el-button type="primary" @click="handleSave()">保存</el-button>
        <el-button @click="dialogFormVisible = false">关闭</el-button>
      </el-form>
    </el-dialog>
  </div>
</template>
<script>
import userApi from '@/api/user'

export default {
  data() {
    return {
      list: [],
      total: 0, // 总记录数
      currentPage: 1, // 当前页
      pageSize: 10, // 每页大小
      searchMap: {}, // 查询条件
      dialogFormVisible: false, // 编辑窗口是否可见
      pojo: {}, // 编辑表单绑定的实体对象
      cityList: [], // 城市列表
      id: '' // 当前用户修改的ID
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      userApi.search(this.currentPage, this.pageSize, this.searchMap).then(response => {
        this.list = response.data.rows
        this.total = response.data.total
      })
    },
    handleSave() {
      userApi.update(this.id, this.pojo).then(response => {
        this.$message({
          message: response.message,
          type: (response.flag ? 'success' : 'error')
        })
        if (response.flag) { // 如果成功
          this.fetchData() // 刷新列表
        }
      })
      this.dialogFormVisible = false // 关闭窗口
    },
    handleEdit(id) {
      this.id = id
      this.dialogFormVisible = true // 打开窗口
      if (id !== '') { // 修改
        userApi.findById(id).then(response => {
          if (response.flag) {
            this.pojo = response.data
          }
        })
      } else {
        this.pojo = {} // 清空数据
      }
    },
    handleDelete(id) {
      this.$confirm('确定要删除此纪录吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        userApi.deleteById(id).then(response => {
          this.$message({ message: response.message, type: (response.flag ? 'success' : 'error') })
          if (response.flag) {
            this.fetchData() // 刷新数据
          }
        })
      })
    }
  }
}
</script>
