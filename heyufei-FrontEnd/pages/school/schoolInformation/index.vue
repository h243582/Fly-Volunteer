<template>
  <div>
    <div class="container">
      <div class="yxk-col yxk-yxmsg clearfix">
        <div class="left"><img :src="this.schoolInformation.avatar" width="135" height="135"/></div>
        <div class="right">
          <div class="yxk-myd">
            <ul class="clearfix">
              <li>
                <div class="yxk-myd-name">综合满意度</div>
                <div class="yxk-myd-num">（1420人投票）</div>
                <div class="yxk-myd-echarts" data-id="4.2">
                  <el-progress type="circle" :percentage=84 :width=95 color="#FFCA3A" :format="format(4.2)"
                               :stroke-width=10></el-progress>
                </div>
              </li>
              <li>
                <div class="yxk-myd-name">环境满意度</div>
                <div class="yxk-myd-num">（1506人投票）</div>
                <div class="yxk-myd-echarts" data-id="4.0">
                  <el-progress type="circle" :percentage=80 :width=95 color="#61ABED" :format="format(4.1)"
                               :stroke-width=10></el-progress>
                </div>
              </li>
              <li>
                <div class="yxk-myd-name">生活满意度</div>
                <div class="yxk-myd-num">（1363人投票）</div>
                <div class="yxk-myd-echarts" data-id="4.3">
                  <el-progress type="circle" :percentage=86 :width=95 color="#1DB278" :format="format(4.3)"
                               :stroke-width=10></el-progress>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <!--  专业满意度排名    -->
      <div class="yxk-col yxk-zypm clearfix">
        <div class="col-list">

          <!--  专业满意度标题    -->
          <h3 class="yxk-col-title">
            <span class="h3-border"></span>专业满意度<i class="em">Top10</i>
            <span class="state">说明</span>
            <span class="tip-contain">
            <i class="el-icon-s-opportunity"></i>
            <div class="tip-con">
                <i class="arrow"></i>
                <span class="title">专业满意度说明：</span><br>
                <p><span class="tip-point">1. </span>由普通本专科学生对本校本专业的办学条件、教学质量、就业情况以及综合情况进行实名投票得出（通过实名注册的学生才具有投票资格）。</p>
                <p><span class="tip-point">2. </span>投票结果仅代表学生对本专业的个人意见。</p>
                <p><span class="tip-point">3. </span>系统自动显示投票数较多的部分专业，投票人数较少的专业暂时不显示。</p>
            </div>
        </span>
            <a class="more" href="" target="_blank">更多</a>
          </h3>

          <!--  专业满意度列表    -->
          <table class="zy-lsit">
            <tr>
              <td width="30"><span class="index ">1</span></td>
              <td width="150" title='学前教育'>
                <div class="overf">学前教育</div>
              </td>
              <td>

                <div class="ratings_green" rank="4.8">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.8</span>
                <span class="grey">(<span class="vote_num_detail">12</span>人)</span>
              </td>
            </tr>
            <tr>
              <td width="30"><span class="index ">2</span></td>
              <td width="150" title='土木工程'>
                <div class="overf">土木工程</div>
              </td>
              <td>

                <div class="ratings_green" rank="4.7">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.7</span>
                <span class="grey">(<span class="vote_num_detail">33</span>人)</span>
              </td>
            </tr>
            <tr>
              <td width="30"><span class="index ">3</span></td>
              <td width="150" title='表演'>
                <div class="overf">表演</div>
              </td>
              <td>

                <div class="ratings_green" rank="4.7">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.7</span>
                <span class="grey">(<span class="vote_num_detail">22</span>人)</span>
              </td>
            </tr>
            <tr>
              <td width="30"><span class="index index-grey">4</span></td>
              <td width="150" title='艺术设计'>
                <div class="overf">艺术设计</div>
              </td>
              <td>

                <div class="ratings_green" rank="4.6">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.6</span>
                <span class="grey">(<span class="vote_num_detail">36</span>人)</span>
              </td>
            </tr>
            <tr>
              <td width="30"><span class="index index-grey">5</span></td>
              <td width="150" title='国际经济与贸易'>
                <div class="overf">国际经济与贸易</div>
              </td>
              <td>

                <div class="ratings_green" rank="4.6">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.6</span>
                <span class="grey">(<span class="vote_num_detail">20</span>人)</span>
              </td>
            </tr>
            <tr>
              <td width="30"><span class="index index-grey">6</span></td>
              <td width="150" title='信息管理与信息系统'>
                <div class="overf">信息管理与信息系统</div>
              </td>
              <td>

                <div class="ratings_green" rank="4.5">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.5</span>
                <span class="grey">(<span class="vote_num_detail">13</span>人)</span>
              </td>
            </tr>
            <tr>
              <td width="30"><span class="index index-grey">7</span></td>
              <td width="150" title='大数据与会计'>
                <div class="overf">大数据与会计</div>
              </td>
              <td>

                <div class="ratings_green" rank="4.4">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.4</span>
                <span class="grey">(<span class="vote_num_detail">20</span>人)</span>
              </td>
            </tr>
            <tr>
              <td width="30"><span class="index index-grey">8</span></td>
              <td width="150" title='计算机科学与技术'>
                <div class="overf">计算机科学与技术</div>
              </td>
              <td>

                <div class="ratings_green" rank="4.3">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.3</span>
                <span class="grey">(<span class="vote_num_detail">16</span>人)</span>
              </td>
            </tr>
            <tr>
              <td width="30"><span class="index index-grey">9</span></td>
              <td width="150" title='旅游管理'>
                <div class="overf">旅游管理</div>
              </td>
              <td>

                <div class="ratings_green" rank="4.3">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.3</span>
                <span class="grey">(<span class="vote_num_detail">15</span>人)</span>
              </td>
            </tr>
            <tr>
              <td width="30"><span class="index index-grey">10</span></td>
              <td width="150" title='金融学'>
                <div class="overf">金融学</div>
              </td>
              <td>

                <div class="ratings_green" rank="4.2">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.2</span>
                <span class="grey">(<span class="vote_num_detail">31</span>人)</span>
              </td>
            </tr>
          </table>

        </div>
        <div class="col-list">

          <h3 class="yxk-col-title">
            <span class="h3-border"></span>专业推荐指数<i class="em">Top10</i>
            <span class="state">说明</span>
            <span class="tip-contain">
            <i class="el-icon-s-opportunity"></i>
            <div class="tip-con">
                <i class="arrow"></i>
                <span class="title">专业推荐说明：</span><br>
                <p><span class="tip_point">1. </span>由普通本专科学生根据本校各专业办学情况，推荐优势专业或特色专业（通过实名注册的学生才具有推荐资格）。</p>
                <p><span class="tip_point">2. </span>推荐结果仅代表学生对本校相关专业的推荐意见，不代表官方的专业排名，不同学校间不宜做直接比较。</p>
                <p><span class="tip_point">3. </span>推荐的专业范围包括所有在校学生所学专业和上年度新增的招生专业。</p>
                <p><span class="tip_point">4. </span>系统自动显示推荐票数较多且推荐指数较高的部分专业，投票人数较少的高校暂时不显示或只显示少量专业。</p>
            </div>
        </span>
            <a class="more" href="" target="_blank">更多</a>
          </h3>

          <table class="zy-lsit">

            <tr>
              <td width="30"><span class="index ">1</span></td>
              <td width="150" title='中药学'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73385192" target="_blank">中药学</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="5.0">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">5.0</span>
                <span class="grey">(<span class="vote_num_detail">19</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index ">2</span></td>
              <td width="150" title='人力资源管理'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73385292" target="_blank">人力资源管理</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="5.0">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">5.0</span>
                <span class="grey">(<span class="vote_num_detail">14</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index ">3</span></td>
              <td width="150" title='信息管理与信息系统'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73385240" target="_blank">信息管理与信息系统</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="5.0">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">5.0</span>
                <span class="grey">(<span class="vote_num_detail">10</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">4</span></td>
              <td width="150" title='药学'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73385188" target="_blank">药学</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="5.0">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">5.0</span>
                <span class="grey">(<span class="vote_num_detail">7</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">5</span></td>
              <td width="150" title='影视摄影与制作'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=433435840" target="_blank">影视摄影与制作</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="5.0">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">5.0</span>
                <span class="grey">(<span class="vote_num_detail">7</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">6</span></td>
              <td width="150" title='护理学'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73385172" target="_blank">护理学</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="5.0">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">5.0</span>
                <span class="grey">(<span class="vote_num_detail">7</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">7</span></td>
              <td width="150" title='通信工程'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73384332" target="_blank">通信工程</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="5.0">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">5.0</span>
                <span class="grey">(<span class="vote_num_detail">6</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">8</span></td>
              <td width="150" title='服装与服饰设计'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=421209031" target="_blank">服装与服饰设计</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="5.0">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">5.0</span>
                <span class="grey">(<span class="vote_num_detail">5</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">9</span></td>
              <td width="150" title='软件工程'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73384356" target="_blank">软件工程</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.9">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.9</span>
                <span class="grey">(<span class="vote_num_detail">26</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">10</span></td>
              <td width="150" title='城乡规划'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73384464" target="_blank">城乡规划</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.9">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.9</span>
                <span class="grey">(<span class="vote_num_detail">18</span>人)</span>
              </td>
            </tr>
          </table>

        </div>
        <div class="col-list last-list">
          <h3 class="yxk-col-title">
            <span class="h3-border"></span>专业推荐人数<i class="em">Top10</i>
            <span class="state">说明</span>
            <span class="tip-contain">
            <i class="el-icon-s-opportunity"></i>
            <div class="tip-con">
                <i class="arrow"></i>
                <span class="title">专业推荐说明：</span><br>
                <p><span class="tip_point">1. </span>由普通本专科学生根据本校各专业办学情况，推荐优势专业或特色专业（通过实名注册的学生才具有推荐资格）。</p>
                <p><span class="tip_point">2. </span>推荐结果仅代表学生对本校相关专业的推荐意见，不代表官方的专业排名，不同学校间不宜做直接比较。</p>
                <p><span class="tip_point">3. </span>推荐的专业范围包括所有在校学生所学专业和上年度新增的招生专业。</p>
                <p><span class="tip_point">4. </span>系统自动显示推荐票数较多且推荐指数较高的部分专业，投票人数较少的高校暂时不显示或只显示少量专业。</p>
            </div>
        </span>
            <a class="more" href="/zyk/pub/zytj/recommendTop.action" target="_blank">更多</a>
          </h3>
          <table class="zy-lsit">

            <tr>
              <td width="30"><span class="index ">1</span></td>
              <td width="150" title='金融学'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73381091" target="_blank">金融学</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.6">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.6</span>
                <span class="grey">(<span class="vote_num_detail">69</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index ">2</span></td>
              <td width="150" title='国际经济与贸易'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73381083" target="_blank">国际经济与贸易</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.3">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.3</span>
                <span class="grey">(<span class="vote_num_detail">53</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index ">3</span></td>
              <td width="150" title='艺术设计'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73383655" target="_blank">艺术设计</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.7">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.7</span>
                <span class="grey">(<span class="vote_num_detail">48</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">4</span></td>
              <td width="150" title='工商管理'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73385276" target="_blank">工商管理</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.5">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.5</span>
                <span class="grey">(<span class="vote_num_detail">45</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">5</span></td>
              <td width="150" title='会计学'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73385284" target="_blank">会计学</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.8">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.8</span>
                <span class="grey">(<span class="vote_num_detail">44</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">6</span></td>
              <td width="150" title='计算机科学与技术'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73384336" target="_blank">计算机科学与技术</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.8">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.8</span>
                <span class="grey">(<span class="vote_num_detail">43</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">7</span></td>
              <td width="150" title='土木工程'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73384468" target="_blank">土木工程</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.4">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.4</span>
                <span class="grey">(<span class="vote_num_detail">38</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">8</span></td>
              <td width="150" title='电子信息工程'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73384328" target="_blank">电子信息工程</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.6">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.6</span>
                <span class="grey">(<span class="vote_num_detail">35</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">9</span></td>
              <td width="150" title='法学'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73381155" target="_blank">法学</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.7">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.7</span>
                <span class="grey">(<span class="vote_num_detail">33</span>人)</span>
              </td>
            </tr>

            <tr>
              <td width="30"><span class="index index-grey">10</span></td>
              <td width="150" title='表演'>
                <div class="overf">
                  <a href="/sch/zyk/view.do?schId=73397478&specId=73383671" target="_blank">表演</a>

                </div>
              </td>
              <td>
                <div class="ratings_green" rank="4.5">
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                  <div class="ratings_green_empty ratings_green_display"></div>
                </div>
                <span class="avg_rank">4.5</span>
                <span class="grey">(<span class="vote_num_detail">32</span>人)</span>
              </td>
            </tr>
          </table>

        </div>
      </div>
      <div class="yxk-col yxk-zxdy">
        <h3 class="yxk-col-title">
          <span class="h3-border"></span>精彩问答
          <a class="more" href="/zxdy/forum--method-listDefault,year-2019,start-0,forumid-1257875.dhtml"
             target="_blank">更多</a>
        </h3>
        <table class="ch-table zx-table">

          <tr>
            <td width="20" class="normal-icon"><i class="el-icon-s-opportunity">&#xe635;</i></td>
            <td width="780" class="question_t">
              <a href="###" class="question_t_txt">
                您好
              </a>
            </td>
            <td width="200" class="question_t">
              <i class="iconfont" title="提问人">&#xe6b5;</i>&ensp;18***27 (北京)
            </td>
            <td width="140" class='question_t ch-table-center'>
              2021-06-28 16:55
            </td>
          </tr>
          <tr class="question_cnt_tr ">
            <td>&nbsp;</td>
            <td colspan="4">
              <div class="question_cnt">
                <div class="question">
                  您好，想问一下，专业组录取的时候是从专业1开始看到专业6，看哪个专业还有计划就录取到那个专业吗？
                </div>
                <div class="question_a">
                  <i class="el-icon-s-opportunity">&#xe63c;</i>[ 回复 ]
                  进档后专业志愿优先
                </div>
              </div>
            </td>
          </tr>

          <tr>
            <td width="20" class="normal-icon"><i class="el-icon-s-opportunity">&#xe635;</i></td>
            <td width="780" class="question_t">
              <a href="###" class="question_t_txt">
                往年录取分数线
              </a>
            </td>
            <td width="200" class="question_t">
              <i class="iconfont" title="提问人">&#xe6b5;</i>&ensp;13***98 (河北)
            </td>
            <td width="140" class='question_t ch-table-center'>
              2021-06-28 16:31
            </td>
          </tr>
          <tr class="question_cnt_tr ch-hide">
            <td>&nbsp;</td>
            <td colspan="4">
              <div class="question_cnt">
                <div class="question">
                  高考播音主持专业考生，
                </div>
                <div class="question_a">
                  <i class="el-icon-s-opportunity">&#xe63c;</i>[ 回复 ]
                  河北播音往年是校考，今年使用联考成绩，没有参考的分值，
                </div>
              </div>
            </td>
          </tr>

          <tr>
            <td width="20" class="normal-icon"><i class="el-icon-s-opportunity">&#xe635;</i></td>
            <td width="780" class="question_t">
              <a href="###" class="question_t_txt">
                北京考生
              </a>
            </td>
            <td width="200" class="question_t">
              <i class="iconfont" title="提问人">&#xe6b5;</i>&ensp;15***38 (北京)
            </td>
            <td width="140" class='question_t ch-table-center'>
              2021-06-28 15:54
            </td>
          </tr>
          <tr class="question_cnt_tr ch-hide">
            <td>&nbsp;</td>
            <td colspan="4">
              <div class="question_cnt">
                <div class="question">
                  总分403，报贵校有机会录取吗？
                </div>
                <div class="question_a">
                  <i class="el-icon-s-opportunity">&#xe63c;</i>[ 回复 ]
                  大平行可以报上
                </div>
              </div>
            </td>
          </tr>

          <tr>
            <td width="20" class="normal-icon"><i class="el-icon-s-opportunity">&#xe635;</i></td>
            <td width="780" class="question_t">
              <a href="###" class="question_t_txt">
                录取
              </a>
            </td>
            <td width="200" class="question_t">
              <i class="iconfont" title="提问人">&#xe6b5;</i>&ensp;19***13 (河南)
            </td>
            <td width="140" class='question_t ch-table-center'>
              2021-06-28 15:53
            </td>
          </tr>
          <tr class="question_cnt_tr ch-hide">
            <td>&nbsp;</td>
            <td colspan="4">
              <div class="question_cnt">
                <div class="question">
                  老师，您好！河南理科考生460，位次205000，有机会被贵校录取嘛
                </div>
                <div class="question_a">
                  <i class="el-icon-s-opportunity">&#xe63c;</i>[ 回复 ]
                  可以在大平行上报一下，是否会录取要看报考情况
                </div>
              </div>
            </td>
          </tr>

          <tr>
            <td width="20" class="normal-icon"><i class="el-icon-s-opportunity">&#xe635;</i></td>
            <td width="780" class="question_t">
              <a href="###" class="question_t_txt">
                上海美术生录取咨询
              </a>
            </td>
            <td width="200" class="question_t">
              <i class="iconfont" title="提问人">&#xe6b5;</i>&ensp;13***77 (上海)
            </td>
            <td width="140" class='question_t ch-table-center'>
              2021-06-28 15:41
            </td>
          </tr>
          <tr class="question_cnt_tr ch-hide">
            <td>&nbsp;</td>
            <td colspan="4">
              <div class="question_cnt">
                <div class="question">
                  上海美术生403分 录取可能性大吗
                </div>
                <div class="question_a">
                  <i class="el-icon-s-opportunity">&#xe63c;</i>[ 回复 ]
                  文化课和专业课均过线可以报考
                </div>
              </div>
            </td>
          </tr>

        </table>
      </div>
    </div>

  </div>
</template>

<script>
import schoolInformationApi from '@/api/school-schoolInformation'
import schoolMajorApi from '@/api/school-schoolMajor'
import Cookie from "js-cookie";

export default {
  layout: 'schoolInformation',
  data() {
    return {
      id: 1,
      schoolInformation: {},
      school: {
        department: "",
        hasGraduateSchool: "",
        id: "",
        isTopDiscipline: "",
        isTopUniversity: "",
        level: "",
        province: "",
        satisfaction: "",
        schoolName: "",
        schoolType: ""
      },
      schoolMajor:{},

    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      var schoolInformation = Cookie.get("schoolInformation");

      if (schoolInformation !== undefined) {
        this.school = JSON.parse(schoolInformation);
      }
      schoolInformationApi.findById(this.school.id).then((response) => {
        this.schoolInformation = response.data.data
      })
      schoolMajorApi.findById(this.school.id).then((response) => {
        this.schoolMajor = response.data.data
        console.log(this.schoolMajor)
      })
    },
    format(index) {
      return () => {
        return index
      }
    },


  },
}
</script>

<style scoped>

</style>
