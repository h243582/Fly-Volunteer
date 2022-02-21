<template>
  <div id="main">
    <div class="header-wrapper ch-simple">
      <div class="ch-header-second clearfix">
        <h1>院校库</h1>
      </div>
    </div>
    <form class="zx-search-yx" action="/sch/search.do" name="form1" id="form1">
      <div class="yxk-filter">
        <ul class="yxk-fliter-list">
          <li class="yxk-option-con search-bar clearfix">
            <div class="clearfix">
              <input class="ch-hide" name="searchType" value="1" type="hidden"/>
              <div class="item-inline js-yxmc ">
                <input class="ch-input" style="margin-left: 0;" type="text" maxlength="50" name="yxmc" id="yxmc"
                       placeholder="请输入院校名称"/>
              </div>

              <div class="item-inline">
                <input class="ch-btn ch-btn-big" type="submit" value="查询"/>
              </div>
            </div>
            <div style="color: #999999;margin-top: 5px;">（ 注：本名单未包含港澳台地区高等学校 ）</div>
          </li>
          <li class="yxk-option-con clearfix">
            <div class="list-th">院校所在地</div>
            <div class="list-td clearfix">
              <select class="ch-hide" name="ssdm" id="ssdm">
                <option value="">院校所在地</option>

                <option value="11"
                >
                  北京
                </option>

                <option value="12"
                >
                  天津
                </option>

                <option value="13"
                >
                  河北
                </option>

                <option value="14"
                >
                  山西
                </option>

                <option value="15"
                >
                  内蒙古
                </option>

                <option value="21"
                >
                  辽宁
                </option>

                <option value="22"
                >
                  吉林
                </option>

                <option value="23"
                >
                  黑龙江
                </option>

                <option value="31"
                >
                  上海
                </option>

                <option value="32"
                >
                  江苏
                </option>

                <option value="33"
                >
                  浙江
                </option>

                <option value="34"
                >
                  安徽
                </option>

                <option value="35"
                >
                  福建
                </option>

                <option value="36"
                >
                  江西
                </option>

                <option value="37"
                >
                  山东
                </option>

                <option value="41"
                >
                  河南
                </option>

                <option value="42"
                >
                  湖北
                </option>

                <option value="43"
                >
                  湖南
                </option>

                <option value="44"
                >
                  广东
                </option>

                <option value="45"
                >
                  广西
                </option>

                <option value="46"
                >
                  海南
                </option>

                <option value="50"
                >
                  重庆
                </option>

                <option value="51"
                >
                  四川
                </option>

                <option value="52"
                >
                  贵州
                </option>

                <option value="53"
                >
                  云南
                </option>

                <option value="54"
                >
                  西藏
                </option>

                <option value="61"
                >
                  陕西
                </option>

                <option value="62"
                >
                  甘肃
                </option>

                <option value="63"
                >
                  青海
                </option>

                <option value="64"
                >
                  宁夏
                </option>

                <option value="65"
                >
                  新疆
                </option>

              </select>
              <span class="yxk-option js-option selected" data-id="">全部</span>

              <span class="yxk-option js-option "
                    data-id="11">北京</span>

              <span class="yxk-option js-option "
                    data-id="12">天津</span>

              <span class="yxk-option js-option "
                    data-id="13">河北</span>

              <span class="yxk-option js-option "
                    data-id="14">山西</span>

              <span class="yxk-option js-option "
                    data-id="15">内蒙古</span>

              <span class="yxk-option js-option "
                    data-id="21">辽宁</span>

              <span class="yxk-option js-option "
                    data-id="22">吉林</span>

              <span class="yxk-option js-option "
                    data-id="23">黑龙江</span>

              <span class="yxk-option js-option "
                    data-id="31">上海</span>

              <span class="yxk-option js-option "
                    data-id="32">江苏</span>

              <span class="yxk-option js-option "
                    data-id="33">浙江</span>

              <span class="yxk-option js-option "
                    data-id="34">安徽</span>

              <span class="yxk-option js-option "
                    data-id="35">福建</span>

              <span class="yxk-option js-option "
                    data-id="36">江西</span>

              <span class="yxk-option js-option "
                    data-id="37">山东</span>

              <span class="yxk-option js-option "
                    data-id="41">河南</span>

              <span class="yxk-option js-option "
                    data-id="42">湖北</span>

              <span class="yxk-option js-option "
                    data-id="43">湖南</span>

              <span class="yxk-option js-option "
                    data-id="44">广东</span>

              <span class="yxk-option js-option "
                    data-id="45">广西</span>

              <span class="yxk-option js-option "
                    data-id="46">海南</span>

              <span class="yxk-option js-option "
                    data-id="50">重庆</span>

              <span class="yxk-option js-option "
                    data-id="51">四川</span>

              <span class="yxk-option js-option "
                    data-id="52">贵州</span>

              <span class="yxk-option js-option "
                    data-id="53">云南</span>

              <span class="yxk-option js-option "
                    data-id="54">西藏</span>

              <span class="yxk-option js-option "
                    data-id="61">陕西</span>

              <span class="yxk-option js-option "
                    data-id="62">甘肃</span>

              <span class="yxk-option js-option "
                    data-id="63">青海</span>

              <span class="yxk-option js-option "
                    data-id="64">宁夏</span>

              <span class="yxk-option js-option "
                    data-id="65">新疆</span>

            </div>
          </li>
          <li class="yxk-option-con clearfix">
            <div class="list-th">主管部门类别</div>
            <div class="list-td clearfix">
              <select class="ch-hide" name="yxls">
                <option value="" selected='selected'>全部</option>
                <option value="moe">教育部</option>
                <option value="min">其他部委</option>
                <option value="loc">地方</option>
                <option value="army">军校</option>
              </select>
              <span class="yxk-option js-option js-ls selected"
                    data-id="">全部</span>
              <span class="yxk-option js-option "
                    data-id="moe">教育部</span>
              <span class="yxk-option js-option "
                    data-id="min">其他部委</span>
              <span class="yxk-option js-option "
                    data-id="loc">地方</span>
              <span class="yxk-option js-option "
                    data-id="army">军校</span>
            </div>
          </li>
          <li class="yxk-option-con clearfix">
            <div class="list-th">学历层次</div>
            <div class="list-td clearfix">
              <select class="ch-hide" name="xlcc">
                <option value="" selected='selected'>全部</option>
                <option value="bk">本科</option>
                <option value="gzzk">高职(专科)</option>
              </select>
              <span class="yxk-option js-option js-ls selected"
                    data-id="">全部</span>
              <span class="yxk-option js-option " data-id="bk">本科</span>
              <span class="yxk-option js-option "
                    data-id="gzzk">高职(专科)</span>
            </div>
          </li>
          <li class="yxk-xz clearfix">
            <div class="list-th">院校特性</div>
            <div class="list-td">
              <label class="ch-check-label ">
                <input type="checkbox" name="zgsx" id="ylxx" value="ylxx"
                />一流大学建设高校
              </label>
              <label class="ch-check-label ">
                <input type="checkbox" name="zgsx" id="ylxk" value="ylxk"
                />一流学科建设高校
              </label>

              <label class="ch-check-label ">
                <input type="checkbox" name="zgsx" id="yjsy" value="yjsy"
                />研究生院
              </label>
              <a href="//yz.chsi.com.cn/kyzx/kp/201101/20110119/161300374.html" target="_blank"><i
                  class="iconfont" title="研究生院">&#xe67b;</i></a>
              <label class="ch-check-label ">
                <input type="radio" name="yxjbz" id="yxjbz" value="2"
                />民办高校
              </label>
              <a href="//gaokao.chsi.com.cn/gkxx/gkcs/201712/20171212/1644084026.html" target="_blank"><i
                  class="iconfont" title="民办高校">&#xe67b;</i></a>
              <label class="ch-check-label ">
                <input type="radio" name="yxjbz" id="yxjbz" value="3"
                />独立学院
              </label>
              <a href="//gaokao.chsi.com.cn/gkxx/zcdh/200803/20080307/3975622.html" target="_blank"><i
                  class="iconfont" title="独立学院">&#xe67b;</i></a>
              <label class="ch-check-label ">
                <input type="radio" name="yxjbz" id="yxjbz" value="4"
                />中外合作办学
              </label>
              <label class="ch-check-label ">
                <input type="radio" name="yxjbz" id="yxjbz" value="5"
                />内地与港澳台地区合作办学
              </label>
            </div>
          </li>
        </ul>
      </div>
    </form>
    <!--  表格  -->
    <div>
      <el-table
          :data="list"
          style="width: 100%">
        <el-table-column
            prop="name"
            label="院校名称"
            width="180">
        </el-table-column>
        <el-table-column
            prop="tb_province_id"
            label="院校所在地"
            width="180">
        </el-table-column>
        <el-table-column
            prop="tb_department_id"
            label="教育行政主管部门">
        </el-table-column>
        <el-table-column
            prop="tb_type_id"
            label="院校类型">
        </el-table-column>
        <el-table-column
            prop="tb_levels_id"
            label="学历层次">
        </el-table-column>
        <el-table-column
            prop="top_university"
            label="一流大学建设高校">
        </el-table-column>
        <el-table-column
            prop="top_discipline"
            label="一流学科建设高校">
        </el-table-column>
        <el-table-column
            prop="graduate_school"
            label="研究生院">
        </el-table-column>
        <el-table-column
            prop="satisfaction"
            label="满意度">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import schoolApi from '@/api/school'

export default {
  name: "index",
  data() {
    return {
      list: [],
      total: 0, // 总记录数
      currentPage: 1, // 当前页
      pageSize: 10, // 每页大小
      searchMap: {}, // 查询条件

    }
  },
  created() {
    this.fetchData()

  },
  methods: {
    //分页刷新列表
    fetchData() {
      schoolApi.search(this.currentPage, this.pageSize, this.searchMap).then(response => {
        this.list = response.data.data.rows
        this.total = response.data.data.total
      })
    },
  }
}
</script>

<style scoped>
#main {
  margin-left: 100px;
}

.sch-tab {
  height: 39px;
  margin-top: 10px;
  margin-bottom: 6px;
  border-color: #eaeaea;
}

.sch-tab .tab-item {
  border-width: 3px;
  margin-right: 20px;
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

.yxk-fliter-list .ch-select {
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