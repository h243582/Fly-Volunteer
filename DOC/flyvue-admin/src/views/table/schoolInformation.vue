<template>
<div>
  <br>
  <el-form :inline="true">
          <el-form-item label="学校id">
<el-input v-model="searchMap.tb_school_id" placeholder="学校id"></el-input></el-form-item>
          <el-form-item label="学校信息更新时间">
<el-input v-model="searchMap.update_time" placeholder="学校信息更新时间"></el-input></el-form-item>
          <el-form-item label="学校领导">
<el-input v-model="searchMap.leaders" placeholder="学校领导"></el-input></el-form-item>
          <el-form-item label="学校简介">
<el-input v-model="searchMap.introduce" placeholder="学校简介"></el-input></el-form-item>
          <el-form-item label="周边环境">
<el-input v-model="searchMap.environment" placeholder="周边环境"></el-input></el-form-item>
          <el-form-item label="通讯地址">
<el-input v-model="searchMap.postal_address" placeholder="通讯地址"></el-input></el-form-item>
          <el-form-item label="联系电话">
<el-input v-model="searchMap.telephone" placeholder="联系电话"></el-input></el-form-item>
          <el-form-item label="重点实验室">
<el-input v-model="searchMap.key_laboratory" placeholder="重点实验室"></el-input></el-form-item>
          <el-form-item label="重点学科">
<el-input v-model="searchMap.key_disciplines" placeholder="重点学科"></el-input></el-form-item>
          <el-form-item label="可授予的学位">
<el-input v-model="searchMap.conferable_degrees" placeholder="可授予的学位"></el-input></el-form-item>
          <el-form-item label="师资力量">
<el-input v-model="searchMap.faculty" placeholder="师资力量"></el-input></el-form-item>
          <el-form-item label="学生人数">
<el-input v-model="searchMap.students_number" placeholder="学生人数"></el-input></el-form-item>
          <el-form-item label="录取批次">
<el-input v-model="searchMap.admission_batch" placeholder="录取批次"></el-input></el-form-item>
          <el-form-item label="对艺术类招生的录取办法">
<el-input v-model="searchMap.art_enrollment" placeholder="对艺术类招生的录取办法"></el-input></el-form-item>
          <el-form-item label="加分政策">
<el-input v-model="searchMap.extra_points" placeholder="加分政策"></el-input></el-form-item>
          <el-form-item label="对少数民族考生的特殊政策">
<el-input v-model="searchMap.ethnic_minority" placeholder="对少数民族考生的特殊政策"></el-input></el-form-item>
          <el-form-item label="对往届生的录取政策">
<el-input v-model="searchMap.previous_students" placeholder="对往届生的录取政策"></el-input></el-form-item>
          <el-form-item label="转专业的实施办法">
<el-input v-model="searchMap.transfer_major" placeholder="转专业的实施办法"></el-input></el-form-item>
          <el-form-item label="其它">
<el-input v-model="searchMap.other" placeholder="其它"></el-input></el-form-item>
          <el-form-item label="奖学金设置">
<el-input v-model="searchMap.scholarship" placeholder="奖学金设置"></el-input></el-form-item>
          <el-form-item label="困难生资助办法">
<el-input v-model="searchMap.difficult_student" placeholder="困难生资助办法"></el-input></el-form-item>
          <el-form-item label="宿舍">
<el-input v-model="searchMap.dormitory" placeholder="宿舍"></el-input></el-form-item>
          <el-form-item label="食堂">
<el-input v-model="searchMap.canteen" placeholder="食堂"></el-input></el-form-item>
          <el-form-item label="其它">
<el-input v-model="searchMap.average_food" placeholder="其它"></el-input></el-form-item>
          <el-form-item label="往年录取信息">
<el-input v-model="searchMap.admission_information" placeholder="往年录取信息"></el-input></el-form-item>

    <el-button type="primary" @click="fetchData()">查询</el-button>
    <el-button type="primary" @click="handleEdit('')">新增</el-button>
  </el-form>
  <el-table
    :data="list"
    border
    style="width: 100%">
          <el-table-column prop="id" label="ID" width="80"></el-table-column>
          <el-table-column prop="tb_school_id" label="学校id" width="80"></el-table-column>
          <el-table-column prop="update_time" label="学校信息更新时间" width="80"></el-table-column>
          <el-table-column prop="leaders" label="学校领导" width="80"></el-table-column>
          <el-table-column prop="introduce" label="学校简介" width="80"></el-table-column>
          <el-table-column prop="environment" label="周边环境" width="80"></el-table-column>
          <el-table-column prop="postal_address" label="通讯地址" width="80"></el-table-column>
          <el-table-column prop="telephone" label="联系电话" width="80"></el-table-column>
          <el-table-column prop="key_laboratory" label="重点实验室" width="80"></el-table-column>
          <el-table-column prop="key_disciplines" label="重点学科" width="80"></el-table-column>
          <el-table-column prop="conferable_degrees" label="可授予的学位" width="80"></el-table-column>
          <el-table-column prop="faculty" label="师资力量" width="80"></el-table-column>
          <el-table-column prop="students_number" label="学生人数" width="80"></el-table-column>
          <el-table-column prop="admission_batch" label="录取批次" width="80"></el-table-column>
          <el-table-column prop="art_enrollment" label="对艺术类招生的录取办法" width="80"></el-table-column>
          <el-table-column prop="extra_points" label="加分政策" width="80"></el-table-column>
          <el-table-column prop="ethnic_minority" label="对少数民族考生的特殊政策" width="80"></el-table-column>
          <el-table-column prop="previous_students" label="对往届生的录取政策" width="80"></el-table-column>
          <el-table-column prop="transfer_major" label="转专业的实施办法" width="80"></el-table-column>
          <el-table-column prop="other" label="其它" width="80"></el-table-column>
          <el-table-column prop="scholarship" label="奖学金设置" width="80"></el-table-column>
          <el-table-column prop="difficult_student" label="困难生资助办法" width="80"></el-table-column>
          <el-table-column prop="dormitory" label="宿舍" width="80"></el-table-column>
          <el-table-column prop="canteen" label="食堂" width="80"></el-table-column>
          <el-table-column prop="average_food" label="其它" width="80"></el-table-column>
          <el-table-column prop="admission_information" label="往年录取信息" width="80"></el-table-column>

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
        <el-form-item label="学校id"><el-input v-model="pojo.tb_school_id"></el-input></el-form-item>
        <el-form-item label="学校信息更新时间"><el-input v-model="pojo.update_time"></el-input></el-form-item>
        <el-form-item label="学校领导"><el-input v-model="pojo.leaders"></el-input></el-form-item>
        <el-form-item label="学校简介"><el-input v-model="pojo.introduce"></el-input></el-form-item>
        <el-form-item label="周边环境"><el-input v-model="pojo.environment"></el-input></el-form-item>
        <el-form-item label="通讯地址"><el-input v-model="pojo.postal_address"></el-input></el-form-item>
        <el-form-item label="联系电话"><el-input v-model="pojo.telephone"></el-input></el-form-item>
        <el-form-item label="重点实验室"><el-input v-model="pojo.key_laboratory"></el-input></el-form-item>
        <el-form-item label="重点学科"><el-input v-model="pojo.key_disciplines"></el-input></el-form-item>
        <el-form-item label="可授予的学位"><el-input v-model="pojo.conferable_degrees"></el-input></el-form-item>
        <el-form-item label="师资力量"><el-input v-model="pojo.faculty"></el-input></el-form-item>
        <el-form-item label="学生人数"><el-input v-model="pojo.students_number"></el-input></el-form-item>
        <el-form-item label="录取批次"><el-input v-model="pojo.admission_batch"></el-input></el-form-item>
        <el-form-item label="对艺术类招生的录取办法"><el-input v-model="pojo.art_enrollment"></el-input></el-form-item>
        <el-form-item label="加分政策"><el-input v-model="pojo.extra_points"></el-input></el-form-item>
        <el-form-item label="对少数民族考生的特殊政策"><el-input v-model="pojo.ethnic_minority"></el-input></el-form-item>
        <el-form-item label="对往届生的录取政策"><el-input v-model="pojo.previous_students"></el-input></el-form-item>
        <el-form-item label="转专业的实施办法"><el-input v-model="pojo.transfer_major"></el-input></el-form-item>
        <el-form-item label="其它"><el-input v-model="pojo.other"></el-input></el-form-item>
        <el-form-item label="奖学金设置"><el-input v-model="pojo.scholarship"></el-input></el-form-item>
        <el-form-item label="困难生资助办法"><el-input v-model="pojo.difficult_student"></el-input></el-form-item>
        <el-form-item label="宿舍"><el-input v-model="pojo.dormitory"></el-input></el-form-item>
        <el-form-item label="食堂"><el-input v-model="pojo.canteen"></el-input></el-form-item>
        <el-form-item label="其它"><el-input v-model="pojo.average_food"></el-input></el-form-item>
        <el-form-item label="往年录取信息"><el-input v-model="pojo.admission_information"></el-input></el-form-item>

        <el-button type="primary" @click="handleSave()">保存</el-button>
        <el-button @click="dialogFormVisible = false" >关闭</el-button>
    </el-form>
  </el-dialog>
</div>
</template>
<script>
import schoolInformationApi from '@/api/schoolInformation'
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
      schoolInformationApi.search(this.currentPage, this.pageSize, this.searchMap).then(response => {
        this.list = response.data.rows
        this.total = response.data.total
      })
    },
    handleSave() {
      schoolInformationApi.update(this.id, this.pojo).then(response => {
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
        schoolInformationApi.findById(id).then(response => {
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
        schoolInformationApi.deleteById(id).then(response => {
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
