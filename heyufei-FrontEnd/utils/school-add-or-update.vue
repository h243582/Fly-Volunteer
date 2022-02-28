<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="院校名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="院校名称"></el-input>
    </el-form-item>
    <el-form-item label="院校所在地" prop="tbProvinceId">
      <el-input v-model="dataForm.tbProvinceId" placeholder="院校所在地"></el-input>
    </el-form-item>
    <el-form-item label="教育行政主管部门" prop="tbDepartmentId">
      <el-input v-model="dataForm.tbDepartmentId" placeholder="教育行政主管部门"></el-input>
    </el-form-item>
    <el-form-item label="院校类型" prop="tbTypeId">
      <el-input v-model="dataForm.tbTypeId" placeholder="院校类型"></el-input>
    </el-form-item>
    <el-form-item label="学历层次" prop="tbLevelsId">
      <el-input v-model="dataForm.tbLevelsId" placeholder="学历层次"></el-input>
    </el-form-item>
    <el-form-item label="一流大学建设高校" prop="topUniversity">
      <el-input v-model="dataForm.topUniversity" placeholder="一流大学建设高校"></el-input>
    </el-form-item>
    <el-form-item label="一流学科建设高校" prop="topDiscipline">
      <el-input v-model="dataForm.topDiscipline" placeholder="一流学科建设高校"></el-input>
    </el-form-item>
    <el-form-item label="研究生院" prop="graduateSchool">
      <el-input v-model="dataForm.graduateSchool" placeholder="研究生院"></el-input>
    </el-form-item>
    <el-form-item label="满意度" prop="satisfaction">
      <el-input v-model="dataForm.satisfaction" placeholder="满意度"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          name: '',
          tbProvinceId: '',
          tbDepartmentId: '',
          tbTypeId: '',
          tbLevelsId: '',
          topUniversity: '',
          topDiscipline: '',
          graduateSchool: '',
          satisfaction: ''
        },
        dataRule: {
          name: [
            { required: true, message: '院校名称不能为空', trigger: 'blur' }
          ],
          tbProvinceId: [
            { required: true, message: '院校所在地不能为空', trigger: 'blur' }
          ],
          tbDepartmentId: [
            { required: true, message: '教育行政主管部门不能为空', trigger: 'blur' }
          ],
          tbTypeId: [
            { required: true, message: '院校类型不能为空', trigger: 'blur' }
          ],
          tbLevelsId: [
            { required: true, message: '学历层次不能为空', trigger: 'blur' }
          ],
          topUniversity: [
            { required: true, message: '一流大学建设高校不能为空', trigger: 'blur' }
          ],
          topDiscipline: [
            { required: true, message: '一流学科建设高校不能为空', trigger: 'blur' }
          ],
          graduateSchool: [
            { required: true, message: '研究生院不能为空', trigger: 'blur' }
          ],
          satisfaction: [
            { required: true, message: '满意度不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/generator/school/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.school.name
                this.dataForm.tbProvinceId = data.school.tbProvinceId
                this.dataForm.tbDepartmentId = data.school.tbDepartmentId
                this.dataForm.tbTypeId = data.school.tbTypeId
                this.dataForm.tbLevelsId = data.school.tbLevelsId
                this.dataForm.topUniversity = data.school.topUniversity
                this.dataForm.topDiscipline = data.school.topDiscipline
                this.dataForm.graduateSchool = data.school.graduateSchool
                this.dataForm.satisfaction = data.school.satisfaction
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/school/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'tbProvinceId': this.dataForm.tbProvinceId,
                'tbDepartmentId': this.dataForm.tbDepartmentId,
                'tbTypeId': this.dataForm.tbTypeId,
                'tbLevelsId': this.dataForm.tbLevelsId,
                'topUniversity': this.dataForm.topUniversity,
                'topDiscipline': this.dataForm.topDiscipline,
                'graduateSchool': this.dataForm.graduateSchool,
                'satisfaction': this.dataForm.satisfaction
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
