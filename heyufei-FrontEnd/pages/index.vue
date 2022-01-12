<template>
  <div>

<!--    <div class="uzy-gaokao-date applyFor-vip" onclick="location.href='/'">-->
<!--      开通VIP-->
<!--      <div class="lighting"></div>-->
<!--    </div>-->

<!--    <div class="xxgk-index" style="margin-bottom:20px;">-->
<!--      <div v-if="user.isvip === '0'">-->
<!--        <a href="/" >开通VIP</a>-->
<!--        <div class="lighting"></div>-->

<!--      </div>-->
<!--    </div>-->


    <div class="main-wrapper">
      <div class="container">

        <!-- 轮播和 轮播 右边 -->
        <div class="index-row part01 clearfix">
          <!--轮播和右边按钮-->
          <div class="gk-main">
            <div class="block">
              <el-carousel height="600px">
                <el-carousel-item v-for="item in rotation" :key="item">
                  <el-image class="small" :src="item" style="height: 100%"/>
                </el-carousel-item>
              </el-carousel>
            </div>
          </div>
          <div class="gk-right">
            <div class="part01-right">



              <div class="xxgk-index" style="margin-bottom:20px;">
                <div v-if="user.isvip === '0'">
                  <a href="/" >
                    开通VIP
                    <div class="lighting"></div>
                  </a>

                </div>
                <div v-if="user.isvip === '1'">
                  <a href="/">
                    VIP有效期至：2022-01-17
                    <div class="lighting"></div>
                  </a>

                </div>
              </div>

              <div class="index-long-enter">
                <a href="https://bm.chsi.com.cn/" class="index-long-btn" target="_blank"
                   style="margin-bottom: 28px;">特殊类型招生信息服务平台</a>
              </div>
              <!-- 特别推荐 -->
              <div class="tbtj-bl">
                <div class="side-head">
                  <span class="icon-sp"><img src="//t3.chei.com.cn/gaokao/assets/src/images/tbtj.svg"></span>
                  <span class="tbtj-title">特别推荐</span>
                </div>
                <div class="tbtj-box">
                  <table>
                    <tbody>
                    <tr>
                      <td align="center"><img src="//t3.chei.com.cn/gaokao/assets/src/images/weixin.jpg"/><br>官方微信
                      </td>
                      <td align="center"><img
                          src="//t4.chei.com.cn/gaokao/assets/src/images/weibo.jpg"/><br>官方微博
                      </td>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <div class="side-body" style="height:201px; overflow:hidden;">
                  <ul class="index-list list-paddingleft-2">
                    <li>
                      <p><a href="/z/gkbmfslq/index.jsp" target="_blank">2022年高考报名分数录取查询</a>&nbsp;<span
                          class="r_new_icon">&nbsp;</span></p>
                    </li>
                    <li>
                      <p><a href="/gkzt/ysl2022" target="_blank">2022年艺术类报考指南</a>&nbsp;<span
                          class="r_new_icon">&nbsp;</span></p>
                    </li>
                    <li>
                      <p><a href="/gkzt/mhzf" target="_blank">2022年民航招飞报考指南</a>&nbsp;<span
                          class="r_new_icon">&nbsp;</span></p>
                    </li>
                    <li>
                      <p><a href="/gkzt/hjzf" target="_blank">2022年海军招飞报考指南</a></p>
                    </li>
                    <li>
                      <p><a href="/gkxx/zt/gkgg2021.shtml" target="_blank">七省高考改革实施方案汇总</a>&nbsp;<span
                          class="r_new_icon">&nbsp;</span></p>
                    </li>
                    <li>
                      <p><a href="/gkzt/kjzf" target="_blank">2022年空军招飞报考指南</a>&nbsp;<span
                          class="r_new_icon">&nbsp;</span></p>
                    </li>
                  </ul>
                </div>
              </div>
              <div style="overflow:hidden;">
                <router-link to="/login">
                  <img src="~/assets/img/报考查询.png" alt="">
                </router-link>
              </div>
            </div>
          </div>
        </div>

        <!-- 招生政策和省市新闻 -->
        <div class="index-row part02 clearfix" style="margin-top: 5px;">
          <div class="part-body clearfix">

            <!-- 招生政策和省市新闻  -->
            <div class="gk-main">
              <div class="ch-list mb13">
                <div class="list-head clearfix">
                  <div class="list-title">招生政策</div>
                  <div class="list-more"><a href="/gkxx/zc/ss/" target="_blank">更多 &gt;</a></div>
                </div>
                <ul class="list-content">
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/zc/ss/202111/20211115/2131063234.html' target="_blank"
                      title="辽宁：2021年高职扩招专项考试招生第二次补报名工作的通知">辽宁：2021年高职扩招专项考试招生第二次补报名工作的通知</a></span></li>
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/zc/ss/202111/20211115/2130936816.html' target="_blank"
                      title="湖南：2022年普通高校招生艺术类专业全省统一考试考生防疫须知">湖南：2022年普通高校招生艺术类专业全省统一考试考生防疫须知</a></span>
                  </li>
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/zc/ss/202111/20211115/2130925230.html' target="_blank"
                      title="山东省教育厅关于印发《山东省2022年普通高等学校艺术类专业招生工作实施方案》的通知">山东省教育厅关于印发《山东省2022年普通高等学校艺术类专业招生...</a></span>
                  </li>
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/zc/ss/202111/20211115/2130925090.html' target="_blank"
                      title="山东：2022年普通高等学校艺术类专业招生工作实施方案政策解读">山东：2022年普通高等学校艺术类专业招生工作实施方案政策解读</a></span>
                  </li>
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/zc/ss/202111/20211115/2130911683.html' target="_blank"
                      title="内蒙古：关于做好2022年普通高等学校艺术类专业考试招生工作的通知">内蒙古：关于做好2022年普通高等学校艺术类专业考试招生工作的通...</a></span>
                  </li>
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/zc/ss/202111/20211112/2130911694.html' target="_blank"
                      title="山西：关于我省2022年普通高考补报名的公告">山西：关于我省2022年普通高考补报名的公告</a></span></li>
                </ul>
              </div>
              <div class="ch-list">
                <div class="list-head clearfix">
                  <div class="list-title">省市新闻</div>
                  <div class="list-more"><a href="/gkxx/ss/" target="_blank">更多 &gt;</a></div>
                </div>
                <ul class="list-content">
                  <li class="clearfix">
<span class="news-title"><a href='/gkxx/ss/202111/20211112/2130608528.html'
                            target="_blank" title="江苏：2022年普通高中学业水平合格性考试报名今日开始">江苏：2022年普通高中学业水平合格性考试报名今日开始</a></span>
                  </li>
                  <li class="clearfix">
<span class="news-title"><a href='/gkxx/ss/202111/20211111/2130255849.html'
                            target="_blank"
                            title="北京：体育专业考试明年4月9日开考">北京：体育专业考试明年4月9日开考</a></span></li>
                  <li class="clearfix">
<span class="news-title"><a href='/gkxx/ss/202111/20211111/2130270856.html'
                            target="_blank" title="上海：2022年普通高校招生艺术类专业统一考试日程安排">上海：2022年普通高校招生艺术类专业统一考试日程安排</a></span>
                  </li>
                  <li class="clearfix">
<span class="news-title"><a href='/gkxx/ss/202111/20211111/2130255171.html'
                            target="_blank"
                            title="浙江：网上信息确认将启！完成这步，2022高考报名才算成功">浙江：网上信息确认将启！完成这步，2022高考报名才算成功</a></span>
                  </li>
                  <li class="clearfix">
<span class="news-title"><a href='/gkxx/ss/202111/20211111/2129944977.html'
                            target="_blank"
                            title="湖南：2022年高考报名成功后，你需要做什么？特别是....">湖南：2022年高考报名成功后，你需要做什么？特别是....</a></span>
                  </li>
                  <li class="clearfix">
<span class="news-title"><a href='/gkxx/ss/202111/20211111/2129839331.html'
                            target="_blank" title="@山东考生，高考报名今日开始！">@山东考生，高考报名今日开始！</a></span>
                  </li>
                </ul>
              </div>
            </div>

            <!-- 招生政策和省市新闻 的 地方站 -->
            <div class="gk-right">
              <div class="side-head">
                <span class="i-title">地方站</span>
              </div>
              <div class="side-body mb13">
                <ul class="area_sites clearfix">
                  <li><a href="/beijing/" target="_blank">北京</a></li>
                  　
                  <li><a href="/tianjin/" target="_blank">天津</a></li>
                  　
                  <li><a href="/hebei/" target="_blank">河北</a></li>
                  　
                  <li><a href="/shanxi/" target="_blank">山西</a></li>
                  　
                  <li><a href="/neimenggu/" target="_blank">内蒙古</a></li>
                  <li><a href="/liaoning/" target="_blank">辽宁</a></li>
                  　
                  <li><a href="/jilin/" target="_blank">吉林</a></li>
                  <li><a href="/heilongjiang/" target="_blank">黑龙江</a></li>
                  <li><a href="/shanghai/" target="_blank">上海</a></li>
                  　
                  <li><a href="/jiangsu/" target="_blank">江苏</a></li>
                  　
                  <li><a href="/zhejiang/" target="_blank">浙江</a></li>
                  　
                  <li><a href="/anhui/" target="_blank">安徽</a></li>
                  　
                  <li><a href="/fujian/" target="_blank">福建</a></li>
                  　
                  <li><a href="/jiangxi/" target="_blank">江西</a></li>
                  　
                  <li><a href="/shandong/" target="_blank">山东</a></li>
                  <li><a href="/henan/" target="_blank">河南</a></li>
                  　
                  <li><a href="/hubei/" target="_blank">湖北</a></li>
                  <li><a href="/hunan/" target="_blank">湖南</a></li>
                  　
                  <li><a href="/guangdong/" target="_blank">广东</a></li>
                  　
                  <li><a href="/guangxi/" target="_blank">广西</a></li>
                  　
                  <li><a href="/hainan/" target="_blank">海南</a></li>
                  <li><a href="/chongqing/" target="_blank">重庆</a></li>
                  　
                  <li><a href="/sichuan/" target="_blank">四川</a></li>
                  　
                  <li><a href="/guizhou/" target="_blank">贵州</a></li>
                  　
                  <li><a href="/yunnan/" target="_blank">云南</a></li>
                  　
                  <li><a href="/xizang/" target="_blank">西藏</a></li>
                  <li><a href="/shaanxi/" target="_blank">陕西</a></li>
                  　
                  <li><a href="/gansu/" target="_blank">甘肃</a></li>
                  <li><a href="/qinghai/" target="_blank">青海</a></li>
                  　
                  <li><a href="/ningxia/" target="_blank">宁夏</a></li>
                  　
                  <li><a href="/xinjiang/" target="_blank">新疆</a></li>
                </ul>
              </div>
              <div style="overflow:hidden;">
                <router-link to="/login">
                  <img src="~/assets/img/中国科技大学.jpg" alt="">
                </router-link>
              </div>
              <div style="overflow:hidden;">
                <router-link to="/login">
                  <img src="~/assets/img/体育类报考指南.jpg" alt="">
                </router-link>
              </div>
              <div style="overflow:hidden;">
                <router-link to="/login">
                  <img src="~/assets/img/专业知识库.png" alt="">
                </router-link>
              </div>
              <div style="overflow:hidden;">
                <router-link to="/login">
                  <img src="~/assets/img/报考查询.png" alt="">
                </router-link>
              </div>
            </div>
          </div>
        </div>

        <!-- 大学 · 专业 -->
        <div class="index-row part03 clearfix">
          <div class="part-head clearfix">
            <h3><span class="part-thbg"><img src="//t2.chei.com.cn/gaokao/assets/src/images/dxzy.svg"></span>大学 · 专业
            </h3>
          </div>
          <div class="gk-main">
            <!-- 院校招生  高校动态 -->
            <div class="index-tab-container" style="margin-bottom:30px;">
              <div class="index-tab clearfix">
                <div class="tab-item left-t js-tab selected"><a href="javascript:void(0)">院校招生</a></div>
                <div class="tab-item right-t js-tab"><a href="javascript:void(0)">高校动态</a></div>
                <span class="more"><a href="/gkxx/yxzs/" target="_blank">更多&ensp;&gt;</a></span>
                <span class="more ch-hide"><a href="/sch/" target="_blank">更多&ensp;&gt;</a></span>
              </div>
              <div class="tab-content clearfix">
                <div class="item-content active">
                  <div class="list-content" style="overflow: hidden; height: 255px;">
                    <ul>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/yxzs/202111/20211111/2130344451.html' target="_blank"
                          title="清华大学2022年“丘成桐数学英才班”招生办法">清华大学2022年“丘成桐数学英才班”招生办法</a></span></li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/yxzs/202111/20211109/2128535685.html' target="_blank"
                          title="西安石油大学举行建校70周年暨“双一流”建设发展大会"><a
                          href='http://www.xsyu.edu.cn/info/1071/25810.htm'
                          target='_blank'>西安石油大学举行建校70周年暨“双一流”建设发展大会</a></a></span>
                      </li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/yxzs/202110/20211014/2118407624.html' target="_blank"
                          title="南方科技大学2021年“优秀中学生科技创新体验营”报名通知"><a
                          href='https://mp.weixin.qq.com/s/9WDwmNsdZDUw35ilfIO6sg'
                          target='_blank'>南方科技大学2021年“优秀中学生科技创新体验营”报名通知</a></a></span></li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/yxzs/202110/20211013/2117425309.html' target="_blank"
                          title="西安石油大学喜迎70周年校庆！"><a
                          href='https://mp.weixin.qq.com/s/VyWoxBgYUyxfAguOU1QP-A'
                          target='_blank'>西安石油大学喜迎70周年校庆！</a></a></span></li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/yxzs/202108/20210827/2102759255.html' target="_blank"
                          title="首批未来技术学院9月迎来新生 专访教育部高等教育司及北京大学、天津大学未来技术学院负责人 未来技术学院如何引领未来">首批未来技术学院9月迎来新生 专访教育部高等教育司及北京大学、...</a></span>
                      </li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/yxzs/202106/20210628/2082025879.html' target="_blank"
                          title="深圳大学2021年本科招生计划6950人，招生模式改革可更好满足考生需求">深圳大学2021年本科招生计划6950人，招生模式改革可更好满足考生...</a></span>
                      </li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/yxzs/202106/20210625/2081271788.html' target="_blank"
                          title="2021校友会重庆市一流专业排名中重庆城科位居前五">2021校友会重庆市一流专业排名中重庆城科位居前五</a></span>
                      </li>
                    </ul>
                  </div>
                </div>
                <div class="item-content">
                  <div class="list-content" style="overflow: hidden; height: 255px;">
                    <ul>
                      <li class="clearfix"><span class="news-title"><span>[<a
                          href="/sch/listBulletin--schId-1869,categoryId-51989.dhtml"
                          target="_blank" title="泰山科技学院">泰山科技学院</a>]</span>&nbsp;<a
                          href="/sch/viewBulletin--schId-1869,infoId-3283970464,categoryId-51989.dhtml"
                          target="_blank" title="我校2021年山东省专科征集计划">我校2021年山东省专科征集计划</a></span>
                      </li>
                      <li class="clearfix"><span class="news-title"><span>[<a
                          href="/sch/listBulletin--schId-1807,categoryId-37840.dhtml"
                          target="_blank" title="重庆人文科技学院">重庆人文科技学院</a>]</span>&nbsp;<a
                          href="/sch/viewBulletin--schId-1807,infoId-3275305049,categoryId-37840.dhtml"
                          target="_blank" title="我校师生喜获第七届全国大学生工程训练综合能力竞赛重庆赛区一等奖等多个奖项">我校师生喜获第七届全国大学生工程训练综合能力竞赛重庆赛区一等奖等多个奖项</a></span>
                      </li>
                      <li class="clearfix"><span class="news-title"><span>[<a
                          href="/sch/listBulletin--schId-1574,categoryId-5584234.dhtml"
                          target="_blank" title="大连科技学院">大连科技学院</a>]</span>&nbsp;<a
                          href="/sch/viewBulletin--schId-1574,infoId-3227355650,categoryId-5584234.dhtml"
                          target="_blank" title="大连科技学院2021年招生章程">大连科技学院2021年招生章程</a></span></li>
                      <li class="clearfix"><span class="news-title"><span>[<a
                          href="/sch/listBulletin--schId-616825988,categoryId-616826077.dhtml"
                          target="_blank" title="巴中职业技术学院">巴中职业技术学院</a>]</span>&nbsp;<a
                          href="/sch/viewBulletin--schId-616825988,infoId-3235600371,categoryId-616826077.dhtml"
                          target="_blank" title="巴中职业技术学院2021年省内外招生联系人">巴中职业技术学院2021年省内外招生联系人</a></span>
                      </li>
                      <li class="clearfix"><span class="news-title"><span>[<a
                          href="/sch/listBulletin--schId-1870,categoryId-47312.dhtml"
                          target="_blank" title="重庆移通学院">重庆移通学院</a>]</span>&nbsp;<a
                          href="/sch/viewBulletin--schId-1870,infoId-3234286431,categoryId-47312.dhtml"
                          target="_blank" title="我校通信工程专业获批2021年重庆市级一流本科专业建设点">我校通信工程专业获批2021年重庆市级一流本科专业建设点</a></span>
                      </li>
                      <li class="clearfix"><span class="news-title"><span>[<a
                          href="/sch/listBulletin--schId-402800,categoryId-402849.dhtml"
                          target="_blank" title="三亚学院">三亚学院</a>]</span>&nbsp;<a
                          href="/sch/viewBulletin--schId-402800,infoId-3231698925,categoryId-402849.dhtml"
                          target="_blank"
                          title="学校办学快速发展 多次获省市领导肯定支持">学校办学快速发展 多次获省市领导肯定支持</a></span></li>
                      <li class="clearfix"><span class="news-title"><span>[<a
                          href="/sch/listBulletin--schId-1826,categoryId-57961.dhtml"
                          target="_blank" title="海南外国语职业学院">海南外国语职业学院</a>]</span>&nbsp;<a
                          href="/sch/viewBulletin--schId-1826,infoId-3226090546,categoryId-57961.dhtml"
                          target="_blank" title="海南外国语职业学院2021年招生章程">海南外国语职业学院2021年招生章程</a></span>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <!-- 专业百科  专业与就业 -->
            <div class="index-tab-container" style="margin-bottom:30px;">
              <div class="index-tab clearfix">
                <div class="tab-item left-t  js-tab selected"><a href="javascript:void(0)">专业百科</a></div>
                <div class="tab-item right-t js-tab"><a href="javascript:void(0)">专业与就业</a></div>
                <span class="more"><a href="/gkxx/zybk/" target="_blank">更多&ensp;&gt;</a></span>
                <span class="more ch-hide"><a href="/gkxx/zybk/zyyjy/"
                                              target="_blank">更多&ensp;&gt;</a></span>
              </div>
              <!-- 用AI -->
              <div class="tab-content clearfix">
                <div class="item-content active">
                  <ul class="list-content" style="overflow: hidden; height: 255px;">
                    <li class="clearfix"><span class="news-title"><a
                        href='/gkxx/zybk/202111/20211115/2131450857.html' target="_blank"
                        title="用AI技术对老动画施展时间“魔法”">用AI技术对老动画施展时间“魔法”</a></span></li>
                    <li class="clearfix"><span class="news-title"><a
                        href='/gkxx/zybk/202111/20211108/2128106338.html' target="_blank"
                        title="2021年度人类社会发展十大科学问题发布——哪些科技难题影响人类未来">2021年度人类社会发展十大科学问题发布——哪些科技难题影响人类...</a></span>
                    </li>
                    <li class="clearfix"><span class="news-title"><a
                        href='/gkxx/zybk/202111/20211104/2127188646.html' target="_blank"
                        title="满满成果，展现创新无限魅力——2020年度国家科学技术奖获奖项目亮点解读">满满成果，展现创新无限魅力——2020年度国家科学技术奖获奖项目...</a></span>
                    </li>
                    <li class="clearfix"><span class="news-title"><a
                        href='/gkxx/zybk/202110/20211021/2120608095.html' target="_blank"
                        title="逐日未来时">逐日未来时</a></span></li>
                    <li class="clearfix"><span class="news-title"><a
                        href='/gkxx/zcdh/202110/20211011/2122126580.html' target="_blank"
                        title="教育部办公厅关于公布2021年通过普通高等学校师范类专业认证专业名单的通知">教育部办公厅关于公布2021年通过普通高等学校师范类专业认证专业...</a></span>
                    </li>
                    <li class="clearfix"><span class="news-title"><a
                        href='/gkxx/zybk/202109/20210913/2107633956.html' target="_blank"
                        title="【图解专业】环境科学与工程类专业：以所学守护绿水青山">【图解专业】环境科学与工程类专业：以所学守护绿水青山</a></span>
                    </li>
                    <li class="clearfix"><span class="news-title"><a
                        href='/gkxx/zybk/202109/20210913/2107676787.html' target="_blank"
                        title="菌草科学：机会蕴含其中">菌草科学：机会蕴含其中</a></span></li>
                  </ul>
                </div>
              </div>
            </div>
            <!-- 强基计划  艺考招生 -->
            <div class="index-tab-container">
              <div class="index-tab clearfix">
                <div class="tab-item left-t  js-tab selected"><a href="javascript:void(0)">强基计划</a></div>
                <div class="tab-item right-t js-tab"><a href="javascript:void(0)">艺考招生</a></div>
                <span class="more"><a href="/gkxx/qjjh/" target="_blank">更多&ensp;&gt;</a></span>
                <span class="more ch-hide"><a href="/gkxx/yszy/dt" target="_blank">更多&ensp;&gt;</a></span>
              </div>
              <div class="tab-content clearfix">
                <div class="item-content active">
                  <div class="list-content" style="overflow: hidden; height: 255px;">
                    <ul>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/qjjh/202106/20210615/2077582795.html' target="_blank"
                          title="同济大学：2021年强基计划重要事项通知">同济大学：2021年强基计划重要事项通知</a></span></li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/qjjh/202106/20210611/2076374584.html' target="_blank"
                          title="上海交通大学：强基计划6月10日开始确认">上海交通大学：强基计划6月10日开始确认</a></span></li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/qjjh/202106/20210610/2076044951.html' target="_blank"
                          title="中国人民大学：关于提醒强基计划考生校考相关环节要求的公告">中国人民大学：关于提醒强基计划考生校考相关环节要求的公告</a></span>
                      </li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/qjjh/202105/20210508/2066652661.html' target="_blank"
                          title="“强基计划”：拔尖创新人才培养新路径">“强基计划”：拔尖创新人才培养新路径</a></span></li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/qjjh/202104/20210416/2059185880.html' target="_blank"
                          title="对话招办主任：上海交大强基计划答疑！">对话招办主任：上海交大强基计划答疑！</a></span></li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/qjjh/202104/20210415/2058586273.html' target="_blank"
                          title="清华大学强基计划报名相关问答">清华大学强基计划报名相关问答</a></span></li>
                      <li class="clearfix"><span class="news-title"><a
                          href='/gkxx/qjjh/202104/20210413/2058148322.html' target="_blank"
                          title="详解北大强基计划！">详解北大强基计划！</a></span></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- 大学 · 专业 的右边 -->
          <div class="gk-right">
            <div class="side-head">
              <span class="i-title">专业解读</span>
              <span class="more"><a href="/zyk/zybk/zyjd/listPage" target="_blank">更多 &gt;</a></span>
            </div>
            <div class="side-body zyjd-img-list">
              <div class="thumbs-box">
                <div class="imgs-panel">
                  <img border="0" height="100%" width="100%" src="~/assets/img/核工程与核技术.jpg"/></div>

                <div class="tips-panel">
                  <div class="tips-mask">&nbsp;</div>
                  <div class="tips-text"><a href="/zyk/zybk/zyjd/viewPage/9mg32kkl7ngzl3nd"
                                            target="_blank">核工程与核技术：变&ldquo;辐&rdquo;为&ldquo;福&rdquo;，让核更多地造福人类</a>
                  </div>
                </div>
              </div>
              <ul class="img-txt-list clearfix list-paddingleft-2">
                <li class="img-txt-box clearfix">
                  <div class="img-wrapper"><img alt="" border="0"
                                                src="https://t3.chei.com.cn/news/img/2084811781.jpg"
                                                title=""/></div>
                  <p class="info"><a href="/zyk/zybk/zyjd/viewPage/tcl1qp6hpacg3a9m"
                                     target="_blank"><span>金融工程：广受青睐，被戏称为最赚钱的专业</span></a></p>
                </li>
                <li class="img-txt-box clearfix">
                  <div class="img-wrapper"><img alt="" border="0"
                                                src="https://t3.chei.com.cn/news/img/2084811782.jpg"
                                                title=""/></div>
                  <p class="info"><a href="/zyk/zybk/zyjd/viewPage/hgf23tzpjvgidvfv"
                                     target="_blank"><span>环境科学与工程类专业：以所学守护绿水青山</span></a></p>
                </li>
                <li class="img-txt-box clearfix">
                  <div class="img-wrapper"><img alt="" border="0"
                                                src="https://t4.chei.com.cn/news/img/2070983194.jpg"
                                                title=""/></div>
                  <p class="info"><a href="/zyk/zybk/zyjd/viewPage/uuyy97wfxgponupu"
                                     target="_blank"><span>信息与计算科学：&ldquo;数学+计算机&rdquo;挖掘数据开发新高地</span></a>
                  </p>
                </li>
              </ul>
            </div>
            <div class="side-head" style="margin-top: 19px;">
              <span class="i-title">港澳高校招生</span>
              <span class="more"><a href="/gkxx/hkzs" target="_blank">更多 &gt;</a></span>
            </div>
            <div class="side-body" style="overflow: hidden; height: 170px; width:280px;">
              <ul class="index-list hotnew-list">
                <li><a href="/gkxx/hkzs/201912/20191202/1790939120.html" target="_blank"
                       title="2021年港澳高校内地招生报考指南"><a href="https://gaokao.chsi.com.cn/gkzt/gagx"
                                                    target="_blank">2021年港澳高校内地招生报考指南</a></a></li>
                <li><a href="/gkxx/hkzs/202108/20210809/2096127552.html" target="_blank"
                       title="“2021学在港澳”说明会 期待你的参与！">“2021学在港澳”说明会 期待你的参与...</a></li>
                <li><a href="/gkxx/yxzs/202106/20210607/2075031407.html" target="_blank"
                       title="香港中文大学为高考同学加油">香港中文大学为高考同学加油</a></li>
                <li><a href="/gkxx/yxzs/202106/20210604/2074656096.html" target="_blank"
                       title="澳门大学六月份一系列内地本科入学及学院说明会约定您在线见！">澳门大学六月份一系列内地本科入学及学...</a></li>
                <li><a href="/gkxx/zbzrft/zx/202106/20210601/2073364944.html" target="_blank"
                       title="澳门理工学院：内地招生约200人 6月30日报名截止">澳门理工学院：内地招生约200人 6月30...</a></li>
              </ul>
            </div>
            <div style="height: 262px; margin-top: 16px; overflow:hidden;">
              <div style="overflow:hidden;">
                <router-link to="/login">
                  <img src="~/assets/img/中国科技大学.jpg" alt="">
                </router-link>
              </div>
              <div style="overflow:hidden;">
                <router-link to="/login">
                  <img src="~/assets/img/体育类报考指南.jpg" alt="">
                </router-link>
              </div>
              <div style="overflow:hidden;">
                <router-link to="/login">
                  <img src="~/assets/img/专业知识库.png" alt="">
                </router-link>
              </div>
              <div style="overflow:hidden;">
                <router-link to="/login">
                  <img src="~/assets/img/报考查询.png" alt="">
                </router-link>
              </div>
            </div>
          </div>
        </div>


        <!-- 志愿 -->
        <div class="index-row part04 clearfix">
          <div class="part-head clearfix">
            <h3><span class="part-thbg"><img src="//t3.chei.com.cn/gaokao/assets/src/images/zy.svg"></span>志愿</h3>
          </div>
          <div class="part-body">
            <div class="gk-main">
              <div class="index-tab-container">
                <div class="index-tab clearfix">
                  <div class="tab-item left-t  js-tab selected"><a href="javascript:void(0)">报考指南</a></div>
                  <div class="tab-item right-t js-tab"><a href="javascript:void(0)">政策解读</a></div>
                  <span class="more"><a href="/gkxx/zytb/" target="_blank">更多&ensp;&gt;</a></span>
                  <span class="more ch-hide"><a href="/gkxx/zjsd/zcjd/"
                                                target="_blank">更多&ensp;&gt;</a></span>
                </div>
                <div class="tab-content clearfix">
                  <div class="item-content active">
                    <div class="list-content" style="overflow: hidden; height: 255px;">
                      <ul>
                        <li class="clearfix"><span class="news-title"><a
                            href='/gkxx/ss/202108/20210805/2094746918.html' target="_blank"
                            title="江苏：征求志愿怎样设置？如何填报征求志愿？">江苏：征求志愿怎样设置？如何填报征求志愿？</a></span></li>
                        <li class="clearfix"><span class="news-title"><a
                            href='/gkxx/zytb/202108/20210804/2094287928.html' target="_blank"
                            title="填报高职专科志愿，4个事项请特别注意！">填报高职专科志愿，4个事项请特别注意！</a></span></li>
                        <li class="clearfix"><span class="news-title"><a
                            href='/gkxx/ss/202108/20210804/2094243254.html' target="_blank"
                            title="沪考心语 | 尽早酝酿专科志愿填报">沪考心语 | 尽早酝酿专科志愿填报</a></span></li>
                        <li class="clearfix"><span class="news-title"><a
                            href='/gkxx/zc/ss/202108/20210804/2094243252.html' target="_blank"
                            title="山西：2021年普通高校招生网上填报志愿（第四段）公告">山西：2021年普通高校招生网上填报志愿（第四段）公告</a></span>
                        </li>
                        <li class="clearfix"><span class="news-title"><a
                            href='/gkxx/zc/ss/202108/20210803/2094243248.html' target="_blank"
                            title="山西：2021年全国普通高校招生《填报志愿指南》更正说明">山西：2021年全国普通高校招生《填报志愿指南》更正说明</a></span>
                        </li>
                        <li class="clearfix"><span class="news-title"><a
                            href='/gkxx/zc/ss/202108/20210803/2094081984.html' target="_blank"
                            title="四川：录取到哪个专业？录取规则说了算">四川：录取到哪个专业？录取规则说了算</a></span></li>
                        <li class="clearfix"><span class="news-title"><a
                            href='/gkxx/zc/ss/202108/20210802/2093433200.html' target="_blank"
                            title="上海：2021年普通高校招生专科阶段志愿填报及录取问答">上海：2021年普通高校招生专科阶段志愿填报及录取问答</a></span>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
              <div class="ch-list clearfix">
                <div class="list-head clearfix">
                  <div class="list-title">考生必读</div>
                  <div class="list-more"><a href="/gkxx/ksbd/" target="_blank">更多 &gt;</a></div>
                </div>
                <ul class="list-content">
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/ss/202111/20211111/2129944977.html' target="_blank"
                      title="湖南：2022年高考报名成功后，你需要做什么？特别是....">湖南：2022年高考报名成功后，你需要做什么？特别是....</a></span>
                  </li>
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/ksbd/202109/20210917/2109593063.html' target="_blank"
                      title="专家解读｜3+1+2新高考模式怎么分班？历史+物理不行吗？">专家解读｜3+1+2新高考模式怎么分班？历史+物理不行吗？</a></span></li>
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/ksbd/202109/20210910/2107337149.html' target="_blank"
                      title="高考经验分享丨理科综合备考全集">高考经验分享丨理科综合备考全集</a></span></li>
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/ksbd/202109/20210910/2107184060.html' target="_blank"
                      title="新高三生如何调好学习节奏？心理专家来支招">新高三生如何调好学习节奏？心理专家来支招</a></span></li>
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/ksbd/202109/20210909/2106979158.html' target="_blank"
                      title="高三备考丨化学：立足基础 提升能力">高三备考丨化学：立足基础 提升能力</a></span></li>
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/ksbd/202109/20210909/2106979061.html' target="_blank"
                      title="高三备考丨英语：三轮复习 步步为营">高三备考丨英语：三轮复习 步步为营</a></span></li>
                  <li class="clearfix"><span class="news-title"><a
                      href='/gkxx/ksbd/202109/20210909/2106978608.html' target="_blank"
                      title="高三备考丨语文：本立道生 循道优术">高三备考丨语文：本立道生 循道优术</a></span></li>
                </ul>
              </div>
            </div>
            <div class="gk-right">
              <div class="side-head">
                <span class="i-title">志愿参考系统</span>
              </div>
              <div class="side-body">
                <a href="/zyck/" target="_blank">
                  <img src="//t2.chei.com.cn/gaokao/assets/src/images/zyck.png?201905" alt="志愿填报参考系统"/>
                </a>
              </div>
              <div class="side-head" style="margin-top: 2px;">
                <span class="i-title">全国各省市招办</span>
              </div>
              <div class="side-body">
                <ul class="area_sites clearfix">
                  <li><a target="_blank" href="http://www.bjeea.cn/">北京</a></li>
                  <li><a target="_blank" href="http://www.zhaokao.net/">天津</a></li>
                  <li><a target="_blank" href="http://www.hebeea.edu.cn/">河北</a></li>
                  <li><a target="_blank" href="http://www.sxkszx.cn/">山西</a></li>
                  <li><a target="_blank" href="http://www.nm.zsks.cn/">内蒙古</a></li>
                  <li><a target="_blank" href="http://www.lnzsks.com/">辽宁</a></li>
                  <li><a target="_blank" href="http://www.jleea.edu.cn/">吉林</a></li>
                  <li><a target="_blank" href="http://www.lzk.hl.cn/">黑龙江</a></li>
                  <li><a target="_blank" href="http://www.shmeea.edu.cn">上海</a></li>
                  <li><a target="_blank" href="http://www.jseea.cn/index.html">江苏</a></li>
                  <li><a target="_blank" href="http://www.zjzs.net/">浙江</a></li>
                  <li><a target="_blank" href="http://www.ahzsks.cn/">安徽</a></li>
                  <li><a target="_blank" href="http://www.eeafj.cn/">福建</a></li>
                  <li><a target="_blank" href="http://www.jxeea.cn/">江西</a></li>
                  <li><a target="_blank" href="http://www.sdzk.cn/">山东</a></li>
                  <li><a target="_blank" href="http://www.heao.gov.cn/">河南</a></li>
                  <li><a target="_blank" href="http://zsxx.e21.cn/">湖北</a></li>
                  <li><a target="_blank" href="http://jyt.hunan.gov.cn/jyt/sjyt/hnsjyksy/">湖南</a></li>
                  <li><a target="_blank" href="http://eea.gd.gov.cn/">广东</a></li>
                  <li><a target="_blank" href="http://www.gxeea.cn/">广西</a></li>
                  <li><a target="_blank" href="http://ea.hainan.gov.cn/">海南</a></li>
                  <li><a target="_blank" href="http://www.cqksy.cn/">重庆</a></li>
                  <li><a target="_blank" href="http://www.sceea.cn/">四川</a></li>
                  <li><a target="_blank" href="http://zsksy.guizhou.gov.cn/">贵州</a></li>
                  <li><a target="_blank" href="http://www.ynzs.cn/">云南</a></li>
                  <li><a target="_blank" href="http://zsks.edu.xizang.gov.cn/">西藏</a></li>
                  <li><a target="_blank" href="http://www.sneac.com/">陕西</a></li>
                  <li><a target="_blank" href="http://www.ganseea.cn/ ">甘肃</a></li>
                  <li><a target="_blank" href="http://www.qhjyks.com/">青海</a></li>
                  <li><a target="_blank" href="http://www.nxjyks.cn/">宁夏</a></li>
                  <li><a target="_blank" href="http://www.xjzk.gov.cn/">新疆</a></li>
                </ul>
              </div>
              <div class="side-head" style="margin-top:0;">
                <span class="i-title">友情链接</span>
              </div>
              <div class="side-body clearfix" style="margin-top: 14px;">
                <ul class="index-links fl">
                  <li><a href="http://www.moe.gov.cn/" target="_blank">中华人民共和国教育部</a></li>
                  <li><a href="http://www.moe.gov.cn/s78/A15/" target="_blank">教育部高校学生司</a></li>
                  <li><a href="http://www.xszz.cee.edu.cn/" target="_blank">全国学生资助管理中心</a></li>
                </ul>
                <ul class="index-links fr">
                  <li><a href="http://www.kjzfw.mil.cn/" target="_blank">空军招飞网</a></li>
                  <li><a href="http://www.hjzf.mil.cn/" target="_blank">海军招飞网</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import '~/assets/css/index.css'
import '~/assets/css/vip.css'
import {getUser} from "@/utils/auth";

export default {
  data() {
    return {
      rotation: [
        require('~/assets/img/banner1.png'),
        require('~/assets/img/banner2.png'),
        require('~/assets/img/banner3.png'),
        require('~/assets/img/banner4.png'),
        require('~/assets/img/banner5.png'),
      ],
      user: {},
    }
  },
  created() {
    this.user = getUser()
    console.log(this.user)
  },
  methods: {}
}
</script>
