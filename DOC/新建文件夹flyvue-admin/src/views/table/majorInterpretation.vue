<template>
<div>
  <br>
  <el-form :inline="true">
          <el-form-item label="专业id">
<el-input v-model="searchMap.tb_major_id" placeholder="专业id"></el-input></el-form-item>
          <el-form-item label="标题题解">
<el-input v-model="searchMap.title2" placeholder="标题题解"></el-input></el-form-item>
          <el-form-item label="来自的平台">
<el-input v-model="searchMap.from" placeholder="来自的平台"></el-input></el-form-item>
          <el-form-item label="作者">
<el-input v-model="searchMap.author" placeholder="作者"></el-input></el-form-item>
          <el-form-item label="详细说明">
<el-input v-model="searchMap.detail" placeholder="详细说明"></el-input></el-form-item>
          <el-form-item label="主办方">
<el-input v-model="searchMap.sponsor" placeholder="主办方"></el-input></el-form-item>
          <el-form-item label="就业前景">
<el-input v-model="searchMap.prospects" placeholder="就业前景"></el-input></el-form-item>
          <el-form-item label="就业方向">
<el-input v-model="searchMap.direction" placeholder="就业方向"></el-input></el-form-item>
          <el-form-item label="报考指南">
<el-input v-model="searchMap.application_guide" placeholder="报考指南"></el-input></el-form-item>

    <el-button type="primary" @click="fetchData()">查询</el-button>
    <el-button type="primary" @click="handleEdit('')">新增</el-button>
  </el-form>
  <el-table
    :data="list"
    border
    style="width: 100%">
          <el-table-column prop="id" label="ID" width="80"></el-table-column>
          <el-table-column prop="tb_major_id" label="专业id" width="80"></el-table-column>
          <el-table-column prop="title2" label="标题题解" width="80"></el-table-column>
          <el-table-column prop="from" label="来自的平台" width="80"></el-table-column>
          <el-table-column prop="author" label="作者" width="80"></el-table-column>
          <el-table-column prop="detail" label="详细说明" width="80"></el-table-column>
          <el-table-column prop="sponsor" label="主办方" width="80"></el-table-column>
          <el-table-column prop="prospects" label="就业前景" width="80"></el-table-column>
          <el-table-column prop="direction" label="就业方向" width="80"></el-table-column>
          <el-table-column prop="application_guide" label="报考指南" width="80"></el-table-column>

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
        <el-form-item label="专业id"><el-input v-model="pojo.tb_major_id"></el-input></el-form-item>
        <el-form-item label="标题题解"><el-input v-model="pojo.title2"></el-input></el-form-item>
        <el-form-item label="来自的平台"><el-input v-model="pojo.from"></el-input></el-form-item>
        <el-form-item label="作者"><el-input v-model="pojo.author"></el-input></el-form-item>
        <el-form-item label="详细说明"><el-input v-model="pojo.detail"></el-input></el-form-item>
        <el-form-item label="主办方"><el-input v-model="pojo.sponsor"></el-input></el-form-item>
        <el-form-item label="就业前景"><el-input v-model="pojo.prospects"></el-input></el-form-item>
        <el-form-item label="就业方向"><el-input v-model="pojo.direction"></el-input></el-form-item>
        <el-form-item label="报考指南"><el-input v-model="pojo.application_guide"></el-input></el-form-item>

        <el-button type="primary" @click="handleSave()">保存</el-button>
        <el-button @click="dialogFormVisible = false" >关闭</el-button>
    </el-form>
  </el-dialog>
</div>
</template>
<script>
import majorInterpretationApi from '@/api/majorInterpretation'
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
      majorInterpretationApi.search(this.currentPage, this.pageSize, this.searchMap).then(response => {
        this.list = response.data.rows
        this.total = response.data.total
      })
    },
    handleSave() {
      majorInterpretationApi.update(this.id, this.pojo).then(response => {
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
        majorInterpretationApi.findById(id).then(response => {
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
        majorInterpretationApi.deleteById(id).then(response => {
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
