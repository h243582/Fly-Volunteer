<template>
  <div>
    <el-form :inline="true">
      <el-form-item label="院校名称">
        <el-input v-model="pageIf.schoolName" placeholder="院校名称"></el-input>
      </el-form-item>
      <el-form-item label="院校所在地">
        <el-select v-model="pageIf.provinceId" filterable placeholder="全部">
          <el-option label="全部" value="" key=""></el-option>
          <el-option
              v-for="item in provinceList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="教育行政主管部门">
        <el-select v-model="pageIf.departmentId" filterable placeholder="全部">
          <el-option label="全部" value="" key=""></el-option>
          <el-option
              v-for="item in departmentList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="院校类型">
        <el-select v-model="pageIf.typeId" filterable placeholder="全部">
          <el-option label="全部" value="" key=""></el-option>
          <el-option
              v-for="item in typeList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="学历层次">
        <el-select v-model="pageIf.levelsId" filterable placeholder="全部">
          <el-option label="全部" value="" key=""></el-option>
          <el-option
              v-for="item in levelsList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="一流大学建设高校">
        <el-switch v-model="pageIf.topUniversity" placeholder="一流大学建设高校"></el-switch>
      </el-form-item>
      <el-form-item label="一流学科建设高校">
        <el-switch v-model="pageIf.topDiscipline" placeholder="一流学科建设高校"></el-switch>
      </el-form-item>
      <el-form-item label="研究生院">
        <el-switch v-model="pageIf.graduateSchool" placeholder="研究生院"></el-switch>
      </el-form-item>
      <!--      <el-form-item label="满意度">-->
      <!--        <el-input v-model="pageIf.satisfaction" placeholder="满意度"></el-input>-->
      <!--      </el-form-item>-->

      <el-button type="primary" style="width: 300px" @click="fetchData()">查询</el-button>
      <el-button type="primary" @click="addEdit('')">新增</el-button>
      <el-button type="primary" @click="reset()">重置选择</el-button>

    </el-form>


    <!--  表格  -->
    <div style="width: 1551px">
      <el-table :data="list" stripe border>
        <el-table-column
            prop="schoolName"
            label="院校名称"
            width="280">
        </el-table-column>
        <el-table-column
            prop="province"
            label="院校所在地" align="center"
            width="150">
        </el-table-column>
        <el-table-column
            prop="department"
            label="教育行政主管部门" align="center"
            width="150">
        </el-table-column>
        <el-table-column
            prop="schoolType"
            label="院校类型" align="center"
            width="100">
        </el-table-column>
        <el-table-column
            prop="level"
            label="学历层次" align="center"
            width="140">
        </el-table-column>
        <el-table-column
            prop="isTopUniversity"
            label="一流大学建设高校" align="center"
            width="150">
          <template slot-scope="scope">
            <div v-if="scope.row.isTopUniversity===false">
<!--              <i class="el-icon-close"></i>-->
            </div>
            <div v-if="scope.row.isTopUniversity===true">
              <i class="el-icon-check"></i>
            </div>
          </template>
        </el-table-column>
        <el-table-column
            prop="isTopDiscipline"
            label="一流学科建设高校" align="center"
            width="150">
          <template slot-scope="scope">
            <div v-if="scope.row.isTopDiscipline===false">
<!--              <i class="el-icon-close"></i>-->
            </div>
            <div v-if="scope.row.isTopDiscipline===true">
              <i class="el-icon-check"></i>
            </div>
          </template>
        </el-table-column>
        <el-table-column
            prop="hasGraduateSchool"
            label="研究生院" align="center"
            width="100">
          <template slot-scope="scope">
            <div v-if="scope.row.hasGraduateSchool===false">
<!--              <i class="el-icon-close"></i>-->
            </div>
            <div v-if="scope.row.hasGraduateSchool===true">
              <i class="el-icon-check"></i>
            </div>
          </template>
        </el-table-column>
        <el-table-column
            prop="satisfaction"
            label="满意度" align="center"
            width="170">
          <template slot-scope="scope">
            <el-rate
                v-model="scope.row.satisfaction"
                disabled
                show-score
                text-color="#ff9900"
                score-template="{value}">
            </el-rate>
          </template>
        </el-table-column>
        <el-table-column
            label="操作"
            width="160">
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
        <el-form-item label="院校名称">
          <el-input v-model="pojo.name" v-on:blur="findSearchByName()" style="width: 70%;float:left;"></el-input>
          <span>{{ message }}</span>
        </el-form-item>

        <el-form-item label="院校所在地">
          <el-select v-model="pojo.provinceId" filterable placeholder="请选择">
            <el-option
                v-for="item in provinceList"
                :key="item.id"
                :label="item.name"
                :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="教育行政主管部门">
          <el-select v-model="pojo.departmentId" filterable placeholder="请选择">
            <el-option
                v-for="item in departmentList"
                :key="item.id"
                :label="item.name"
                :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="院校类型">
          <el-select v-model="pojo.typeId" filterable placeholder="请选择">
            <el-option
                v-for="item in typeList"
                :key="item.id"
                :label="item.name"
                :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学历层次">
          <el-select v-model="pojo.levelsId" filterable placeholder="请选择">
            <el-option
                v-for="item in levelsList"
                :key="item.id"
                :label="item.name"
                :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="一流大学建设高校">
          <el-switch v-model="pojo.topUniversity" placeholder="一流大学建设高校"></el-switch>
        </el-form-item>
        <el-form-item label="一流学科建设高校">
          <el-switch v-model="pojo.topDiscipline" placeholder="一流学科建设高校"></el-switch>
        </el-form-item>
        <el-form-item label="研究生院">
          <el-switch v-model="pojo.graduateSchool" placeholder="研究生院"></el-switch>
        </el-form-item>
        <el-form-item label="院校满意度">
          <el-rate
              v-model="pojo.satisfaction"
              allow-half show-score style="padding-top: 10px"
              text-color="#ff9900">
          </el-rate>
        </el-form-item>
          <el-button @click="addFormVisible = false">关闭</el-button>
        <el-button type="primary" @click="handleAdd()" style="float: right">保存</el-button>

      </el-form>
    </el-dialog>

    <el-dialog title="修改" :visible.sync="updateFormVisible">
        <el-form label-width="160px">
          <el-form-item label="院校名称">
            <el-input v-model="pojo.name" style="width: 70%;float:left;"></el-input>
<!--            <el-input v-model="pojo.name" v-on:blur="findSearchByName()" style="width: 70%;float:left;"></el-input>-->
<!--            <span>{{ message }}</span>-->
          </el-form-item>

          <el-form-item label="院校所在地">
            <el-select v-model="pojo.provinceId" filterable placeholder="请选择">
              <el-option
                  v-for="item in provinceList"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="教育行政主管部门">
            <el-select v-model="pojo.departmentId" filterable placeholder="请选择">
              <el-option
                  v-for="item in departmentList"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="院校类型">
            <el-select v-model="pojo.typeId" filterable placeholder="请选择">
              <el-option
                  v-for="item in typeList"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="学历层次">
            <el-select v-model="pojo.levelsId" filterable placeholder="请选择">
              <el-option
                  v-for="item in levelsList"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="一流大学建设高校">
            <el-switch v-model="pojo.topUniversity" placeholder="一流大学建设高校"></el-switch>
          </el-form-item>
          <el-form-item label="一流学科建设高校">
            <el-switch v-model="pojo.topDiscipline" placeholder="一流学科建设高校"></el-switch>
          </el-form-item>
          <el-form-item label="研究生院">
            <el-switch v-model="pojo.graduateSchool" placeholder="研究生院"></el-switch>
          </el-form-item>
          <el-form-item label="院校满意度">
            <el-rate
                v-model="pojo.satisfaction"
                allow-half show-score style="padding-top: 10px"
                text-color="#ff9900">
            </el-rate>
          </el-form-item>


        <el-button type="primary" @click="updateTable()">保存</el-button>
        <el-button @click="updateFormVisible = false">关闭</el-button>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import schoolApi from '@/api/school'
import provinceApi from '@/api/province'
import departmentApi from '@/api/school-department'
import departmentTypeApi from '@/api/school-departmentType'
import typeApi from '@/api/school-type'
import levelsApi from '@/api/school-levels'
import userApi from "@/api/user";

export default {
  name: "admin-school",
  layout: 'admin',

  data() {
    return {
      id:'',
      list: [],
      total: 0, // 总记录数
      addFormVisible: false,
      updateFormVisible:false,
      pojo: {
        name:"",
        provinceId:"1",
        departmentId:"1",
        typeId:"10",
        levelsId:"1",
      },
      message: '',
      pageIf: {
        currentPage: 1, // 当前页
        pageSize: 10, // 每页大小
        schoolName: '',
      },

      provinceList: [],
      departmentList: [],
      levelsList: [],
      departmentTypeList: [],
      typeList: [],

      searchMap: {}, // 查询条件

    }
  },
  created() {
    this.fetchData()
    this.fetchSelectData()

  },
  methods: {
    //分页刷新列表
    fetchData() {
      schoolApi.search(this.pageIf).then(response => {
        this.list = response.data.data.rows
        this.total = response.data.data.total
      })
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
        schoolApi.save(this.pojo).then(response => {
          if (response.data.data.flag === false) {
            this.$message({
              message: "新建失败",
              type: 'error'
            })
          }else {
            this.$message({
              message: "新建成功",
              type: 'success'
            })
          }
        })
        this.addFormVisible = false // 打开窗口
        this.pojo = {
          name:"",
          provinceId:"1",
          departmentId:"1",
          typeId:"10",
          levelsId:"1",
        } // 还原数据
      }
    },


    //打开修改窗口
    updateEdit(id) {
      this.id = id
      this.updateFormVisible = true // 打开窗口
      if (id !== '') { // 修改
        schoolApi.findById(id).then(response => {
          if (response.data.flag) {
            this.pojo = response.data.data
            console.log(this.pojo)

          }
        })
      } else {
        this.pojo = {} // 清空数据
      }
    },

    //修改学校保存按钮
    updateTable() {
      schoolApi.update(this.id, this.pojo).then(response => {
        this.$message({
          message: response.data.message,
          type: (response.data.flag ? 'success' : 'error')
        })
        if (response.data.flag) { // 如果成功
          this.fetchData() // 刷新列表
        }
      })
      this.updateFormVisible = false // 关闭窗口
    },

    //删除记录
    tableDelete(id) {
        this.$confirm('确定要删除此纪录吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          schoolApi.deleteById(id).then(response => {
            this.$message({message: response.data.message, type: (response.data.flag ? 'success' : 'error')})
            if (response.data.flag) {
              this.fetchData() // 刷新数据
            }
          })
        })
      },
    findSearchByName() {
      this.searchMap = {}
      this.searchMap.schoolName = this.pojo.name
      schoolApi.search(this.searchMap).then(response => {
        if (response.data.data.total === 0) {
          this.message = '院校名可用'
        } else {
          this.message = '院校名重复'
        }
      })
    },
    fetchSelectData() {
      provinceApi.getList().then(response => {
        this.provinceList = response.data.data
      })
      departmentApi.getList().then(response => {
        this.departmentList = response.data.data
      })
      typeApi.getList().then(response => {
        this.typeList = response.data.data
      })
      levelsApi.getList().then(response => {
        this.levelsList = response.data.data
      })
      departmentTypeApi.getList().then(response => {
        this.departmentTypeList = response.data.data
      })

    },



    handleCurrentChange(val) {
      this.pageIf.currentPage = val;
      this.fetchData()
    },
    handleSizeChange(val) {
      this.pageIf.pageSize = val;
      this.fetchData()
    },


  },

}
</script>

