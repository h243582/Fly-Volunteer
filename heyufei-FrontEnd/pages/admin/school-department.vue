<template>
  <div>
    <el-form :inline="true">
<!--      <el-form-item label="教育主管部门">-->
<!--        <el-input v-model="pageIf.name" placeholder="教育主管部门"></el-input>-->
<!--      </el-form-item>-->

<!--      <el-button type="primary" style="width: 300px" @click="fetchData()">查询</el-button>-->
      <el-button type="primary" @click="addEdit('')">新增</el-button>
      <el-button type="primary" @click="reset()">重置选择</el-button>

    </el-form>


    <!--  表格  -->
    <div style="width: 600px">
      <el-table :data="departmentList" stripe border>
        <el-table-column
            prop="name"
            label="教育主管部门" align="center"
            width="180">
        </el-table-column>
        <el-table-column
            prop="departmentTypeId"
            label="教育主管部门类别" align="center"
            width="160">
        </el-table-column>

        <el-table-column
            label="操作"
            width="180">
          <template slot-scope="scope">
            <el-button @click="updateEdit(scope.row.id)" size="small">修改</el-button>
            <el-button @click="tableDelete(scope.row.id)" type="warning" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="this.pageIf.currentPage"
          :page-sizes="[5,10,20,50]"
          :page-size="this.pageIf.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>


    <el-dialog title="新增" :visible.sync="addFormVisible">
      <el-form label-width="160px">
        <el-form-item label="教育主管部门">
          <el-input v-model="pojo.name" v-on:blur="findSearchByName()" style="width: 70%;float:left;"></el-input>
          <span>{{ message }}</span>
        </el-form-item>
        <el-form-item label="教育主管部门类别">
          <el-select v-model="pojo.departmentTypeId" filterable placeholder="请选择">
            <el-option
                v-for="item in departmentTypeList"
                :key="item.id"
                :label="item.name"
                :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>

          <el-button @click="addFormVisible = false">关闭</el-button>
        <el-button type="primary" @click="handleAdd()" style="float: right">保存</el-button>

      </el-form>
    </el-dialog>

    <el-dialog title="修改" :visible.sync="updateFormVisible">
        <el-form label-width="160px">
          <el-form-item label="教育主管部门">
            <el-input v-model="pojo.name" v-on:blur="findSearchByName()" style="width: 70%;float:left;"></el-input>
            <span>{{ message }}</span>
          </el-form-item>
          <el-form-item label="教育主管部门类别">
            <el-select v-model="pojo.departmentTypeId" filterable placeholder="请选择">
              <el-option
                  v-for="item in departmentTypeList"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
        <el-button type="primary" @click="updateTable()">保存</el-button>
        <el-button @click="updateFormVisible = false">关闭</el-button>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import provinceApi from '@/api/province'
import departmentApi from '@/api/school-department'
import departmentTypeApi from '@/api/school-departmentType'
import typeApi from '@/api/school-type'
import levelsApi from '@/api/school-levels'

export default {
  name: "admin-school",
  layout: 'admin',

  data() {
    return {
      id:'',
      total: 0, // 总记录数
      addFormVisible: false,
      updateFormVisible:false,
      pojo:{},//新增


      message: '', //查重专用
      pageIf: { //查询专用
        currentPage: 1, // 当前页
        pageSize: 10, // 每页大小
        name: '',
      },

      provinceList: [],
      departmentList: [],
      levelsList: [],
      departmentTypeList: [],
      typeList: [],


    }
  },
  created() {
    this.fetchData()

  },

  methods: {
    //分页刷新列表
    fetchData() {
      departmentApi.findAllLimit(this.pageIf.currentPage,this.pageIf.pageSize).then(response => {
        this.departmentList = response.data.data.records
        this.total = response.data.data.total

        departmentTypeApi.getList().then(response => {
          this.departmentTypeList = response.data.data

          for (let i = 0; i < this.departmentList.length; i++) {
            for (let j = 0; j < this.departmentTypeList.length; j++) {
              if (this.departmentList[i].departmentTypeId === this.departmentTypeList[j].id){
                this.departmentList[i].departmentTypeId = this.departmentTypeList[j].name
              }
            }
          }

        })

      })




      this.pojo = {// 还原数据
        name:"",
      }
      this.message =''
      this.addFormVisible= false
      this.updateFormVisible=false
    },
    //重置分页列表
    reset() {

      this.pageIf = {}
      this.pageIf.currentPage = 1
      this.pageIf.pageSize = 10
      this.fetchData();
    },
    // 打开新增用户窗口
    addEdit() {
      this.addFormVisible = true // 打开窗口
      this.message=''
      this.pojo = {} // 清空数据
    },

    //新增用户的提交按钮
    handleAdd() {
      if (this.message === '院校名重复'){
        this.$message({
          message: "院校名重复",
          type: 'error'
        })
      }else {
        departmentApi.save(this.pojo).then(response => {
            this.$message({
              message: "新建成功",
              type: 'success'
            })
          this.fetchData() // 刷新数据
        })
      }
    },


    //打开修改窗口
    updateEdit(id) {
      this.id = id
      this.updateFormVisible = true // 打开窗口
      if (id !== '') { // 修改
          departmentApi.findById(id).then(response => {
            if (response.data.flag) {
              this.pojo = response.data.data
            }
          })
      } else {
        this.pojo = {} // 清空数据
      }
    },

    //修改学校保存按钮
    updateTable() {
      if (this.message === '院校名重复'){
        this.$message({
          message: "院校名重复",
          type: 'error'
        })
      }else {
        departmentApi.update(this.id, this.pojo).then(response => {
          this.$message({
            message: response.data.message,
            type: (response.data.flag ? 'success' : 'error')
          })

          this.fetchData() // 刷新列表
        })
      }
    },

    //删除记录
    tableDelete(id) {
        this.$confirm('确定要删除此纪录吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          departmentApi.deleteById(id).then(response => {
            this.$message({message: response.data.message, type: (response.data.flag ? 'success' : 'error')})
            if (response.data.flag) {
              this.fetchData() // 刷新数据
            }
          })
        })
      },

    //新增时查询是否重复
    findSearchByName() {
      this.searchMap = {}
      this.searchMap.name = this.pojo.name
      departmentApi.findSearch(this.searchMap).then(response => {
        if (response.data.data.length === 0 ||response.data.data.length === null) {
          this.message = '院校名可用'
        } else {
          this.message = '院校名重复'
        }
      })
    },


    //用于分页
    handleCurrentChange(val) {
      this.pageIf.currentPage = val;
      this.fetchData()
    },
    //用于分页
    handleSizeChange(val) {
      this.pageIf.pageSize = val;
      this.fetchData()
    },


  }
}
</script>

