<template>
  <div>
    <div class="header-wrapper ch-simple">
      <div class="ch-header-second clearfix" style="margin-left: 0">
        <h1>院校库</h1>
      </div>
    </div>
    <div id="body-hyf">

      <!--查找-->
      <el-form :inline="true">
        <el-form-item label="学校名称">
          <input class="ch-input" v-model="pageIf.schoolName" type="text" placeholder="请输入院校名称" style="width: 300px"/>
          <div style="color: #999999;margin-top: 5px;">（ 注：本名单未包含港澳台地区高等学校 ）</div>
        </el-form-item>
        <el-form-item label="院校所在地">
          <el-select v-model="pageIf.provinceId" filterable placeholder="全部" mini maxlength="60">
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
        <br>
        <el-form-item label="一流大学建设高校">
          <el-switch v-model="pageIf.topUniversity" placeholder="一流大学建设高校"></el-switch>
        </el-form-item>
        <el-form-item label="一流学科建设高校">
          <el-switch v-model="pageIf.topDiscipline" placeholder="一流学科建设高校"></el-switch>
        </el-form-item>
        <el-form-item label="研究生院">
          <el-switch v-model="pageIf.graduateSchool" placeholder="研究生院"></el-switch>
        </el-form-item>

        <el-button type="primary" style="width: 300px" @click="fetchData()">查询</el-button>
        <button class="ch-btn ch-btn-big" @click="findByName()">重置选择</button>

      </el-form>

      <!--  表格  -->
      <div>
        <el-table :data="list" stripe @row-click="joinInSchool">
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
                <i class="el-icon-close"></i>
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
                <i class="el-icon-close"></i>
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
                <i class="el-icon-close"></i>
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
    </div>
  </div>
</template>

<script>
import schoolApi from '@/api/school'
import provinceApi from '@/api/province'
import departmentApi from '@/api/school-department'
import departmentTypeApi from '@/api/school-departmentType'
import typeApi from '@/api/school-type'
import levelsApi from '@/api/school-levels'
import Cookie from "js-cookie";

export default {
  name: "school",
  data() {
    return {
      list: [],
      total: 0, // 总记录数
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

      pojo: {},
      searchMap: {}, // 查询条件
      selectedFlag: false
    }
  },
  created() {
    this.fetchData()
    this.fetchSelectData()
  },
  methods: {
    findByName() {
      this.fetchData();
      // this.pageIf.schoolName=''
    },
    findByProvince(index, item) {
      this.selectedFlag = true
      console.log(index)
      console.log(item)
    },

    //分页刷新列表
    fetchData() {
      schoolApi.search(this.pageIf).then(response => {
        this.list = response.data.data.rows
        this.total = response.data.data.total
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
    //重置分页列表
    reset() {
      this.pageIf = {}
      this.pageIf.currentPage = 1
      this.pageIf.pageSize = 10
      this.fetchData();
    },
    //进入学校详情页
    joinInSchool(row, event, column) {
      // location.href = '/school/joinInSchool/'+row
      // this.$router.push({ path: '/school/joinInSchool/'+row.id })
      Cookie.set('schoolInformation', row);

      this.$router.push({ path: `/school/schoolInformation`})



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

<style scoped>
#body-hyf {
  margin-left: 5%;
}

.sch-tab .tab-item a {
  padding-left: 0;
  padding-right: 0;
}

.yxk-filter {
  padding: 0;
  border: none;
  margin-bottom: 8px;
  margin-top: 24px;
}

.yxk-filter li {
  padding: 4px 0;
}

.yxk-filter li.search-bar {
  margin-bottom: 5px;
}

.yxk-filter .list-th {
  width: 105px;
  padding-right: 0;
  text-align: left;
  font-weight: 700;
  font-size: 14px;
}

.yxk-filter li.yxk-option-con .list-td {
  width: 1075px;
  padding-left: 0;
}

.yxk-fliter-list .ch-input {
  width: 430px;
  border-radius: 4px;
}

.yxk-fliter-list .ch-btn {
  border-radius: 4px;
}

.yxk-fliter-list {
  border-radius: 4px;
}

.yxk-filter .yxk-option {
  padding: 0;
  margin-right: 20px;
}

.yxk-filter .yxk-option.selected {
  color: #1db278;
  background: none;
}

.yxk-filter .ch-check-label {
  padding-left: 0;
}

.yxk-filter .ch-check-label + .ch-check-label {
  margin-left: 10px;
}

.yxk-filter .yxk-xz a {
  margin-right: 10px;
}

.yxk-filter .ch-check-label input[type=checkbox] {
  position: relative;
  top: -1px;
}
</style>
