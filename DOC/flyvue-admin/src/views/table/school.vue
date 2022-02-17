<template>
<div>
  <br>
  <el-form :inline="true">
          <el-form-item label="院校名称">
<el-input v-model="searchMap.name" placeholder="院校名称"></el-input></el-form-item>
          <el-form-item label="院校所在地">
<el-input v-model="searchMap.tb_province_id" placeholder="院校所在地"></el-input></el-form-item>
          <el-form-item label="教育行政主管部门">
<el-input v-model="searchMap.tb_department_id" placeholder="教育行政主管部门"></el-input></el-form-item>
          <el-form-item label="院校类型">
<el-input v-model="searchMap.tb_type_id" placeholder="院校类型"></el-input></el-form-item>
          <el-form-item label="学历层次">
<el-input v-model="searchMap.tb_levels_id" placeholder="学历层次"></el-input></el-form-item>
          <el-form-item label="一流大学建设高校">
<el-input v-model="searchMap.top_university" placeholder="一流大学建设高校"></el-input></el-form-item>
          <el-form-item label="一流学科建设高校">
<el-input v-model="searchMap.top_discipline" placeholder="一流学科建设高校"></el-input></el-form-item>
          <el-form-item label="研究生院">
<el-input v-model="searchMap.graduate_school" placeholder="研究生院"></el-input></el-form-item>
          <el-form-item label="满意度">
<el-input v-model="searchMap.satisfaction" placeholder="满意度"></el-input></el-form-item>

    <el-button type="primary" @click="fetchData()">查询</el-button>
    <el-button type="primary" @click="handleEdit('')">新增</el-button>
  </el-form>
  <el-table
    :data="list"
    border
    style="width: 100%">
          <el-table-column prop="id" label="ID" width="80"></el-table-column>
          <el-table-column prop="name" label="院校名称" width="80"></el-table-column>
          <el-table-column prop="tb_province_id" label="院校所在地" width="80"></el-table-column>
          <el-table-column prop="tb_department_id" label="教育行政主管部门" width="80"></el-table-column>
          <el-table-column prop="tb_type_id" label="院校类型" width="80"></el-table-column>
          <el-table-column prop="tb_levels_id" label="学历层次" width="80"></el-table-column>
          <el-table-column prop="top_university" label="一流大学建设高校" width="80"></el-table-column>
          <el-table-column prop="top_discipline" label="一流学科建设高校" width="80"></el-table-column>
          <el-table-column prop="graduate_school" label="研究生院" width="80"></el-table-column>
          <el-table-column prop="satisfaction" label="满意度" width="80"></el-table-column>

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
        <el-form-item label="院校名称"><el-input v-model="pojo.name"></el-input></el-form-item>
        <el-form-item label="院校所在地"><el-input v-model="pojo.tb_province_id"></el-input></el-form-item>
        <el-form-item label="教育行政主管部门"><el-input v-model="pojo.tb_department_id"></el-input></el-form-item>
        <el-form-item label="院校类型"><el-input v-model="pojo.tb_type_id"></el-input></el-form-item>
        <el-form-item label="学历层次"><el-input v-model="pojo.tb_levels_id"></el-input></el-form-item>
        <el-form-item label="一流大学建设高校"><el-input v-model="pojo.top_university"></el-input></el-form-item>
        <el-form-item label="一流学科建设高校"><el-input v-model="pojo.top_discipline"></el-input></el-form-item>
        <el-form-item label="研究生院"><el-input v-model="pojo.graduate_school"></el-input></el-form-item>
        <el-form-item label="满意度"><el-input v-model="pojo.satisfaction"></el-input></el-form-item>

        <el-button type="primary" @click="handleSave()">保存</el-button>
        <el-button @click="dialogFormVisible = false" >关闭</el-button>
    </el-form>
  </el-dialog>
</div>
</template>
<script>
import schoolApi from '@/api/school'
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
      schoolApi.search(this.currentPage, this.pageSize, this.searchMap).then(response => {
        this.list = response.data.rows
        this.total = response.data.total
      })
    },
    handleSave() {
      schoolApi.update(this.id, this.pojo).then(response => {
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
        schoolApi.findById(id).then(response => {
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
        schoolApi.deleteById(id).then(response => {
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
