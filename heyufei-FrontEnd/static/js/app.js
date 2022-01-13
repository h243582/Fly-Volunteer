require.config({
    baseUrl: '//staticv3-pre.youzy.cn/ToC.PC/scripts_dist/0204_89r6yi20i8/static/',
    urlArgs: 'v=1612413623904',
    waitSeconds: 300,
    paths: {
        //===========libs
        'jquery': '//staticv3.youzy.cn/libs/jquery-1.7.2.min',
        'bootstrap': '//staticv3.youzy.cn/libs/bootstrap2.0/bootstrap.min',
        'underscore': '//staticv3.youzy.cn/libs/underscore/underscore-1.8.min',
        'handlebars': '//staticv3.youzy.cn/libs/handlebars/handlebars2',
        'json2': '//staticv3.youzy.cn/libs/json2',
        'json3': '//staticv3.youzy.cn/libs/json3',
        'cookie': '//staticv3.youzy.cn/libs/js.cookie.min',
        'ueditor/config': '/ueditor/ueditor.config', //ueditor
        'ueditor': '/ueditor/ueditor.all', //ueditor
        'md5': '//staticv3.youzy.cn/libs/cdn/md5/md5',

        //===========plugins
        'placeholder': '//staticv3.youzy.cn/libs/jquery.placeholder.min', //input textarea --placeholder
        'swfobject': '/content/lessons/swfobject.min', //swf object
        'easing1.3': '//staticv3.youzy.cn/libs/jquery.easing/jquery.easing.min-1.3', //jquery easing 圆形进度条依赖
        'easyPieChart': '//staticv3.youzy.cn/libs/easyPieChart/jquery.easypiechart.min', //圆形进度条主库
        'baiduMap': '//api.map.baidu.com/getscript?v=2.0&ak=Ql79AkVF6MapPGclflS8lxOB&services=&t=20181016102824', //baidu map api
        'slimScroll': '//staticv3.youzy.cn/libs/jquery.slimscroll.min', //漂亮滚动条
        'jqueryPagination': '//staticv3.youzy.cn/libs/jqueryPagination/pagination.min', //分页插件
        'jqueryFineuploader': '//staticv3.youzy.cn/libs/jquery.fineuploader/jquery.fineuploader-3.4.1.min', //上传图片插件
        'dragdealer': '//staticv3.youzy.cn/libs/dragdealer', //jq滑块拖动组件
        'superSlide': '//staticv3.youzy.cn/libs/jquery.SuperSlide', //超级切换
        'rangeSlider': '//staticv3.youzy.cn/libs/ion-rangeslider/js/ion.rangeSlider.min', //区域拖拉插件
        'qrcode': '//staticv3.youzy.cn/libs/qrcode/qrcode', //二维码js
        'qrcodeUtils': '//staticv3.youzy.cn/libs/qrcode/utils', //二维码工具类
        'suggest': '//staticv3.youzy.cn/libs/jquery.suggest/jquery.suggest', //智能填充组件
        'sweetalert2.1': '//staticv3.youzy.cn/libs/sweetalert2.1/sweetalert2.1.min', //友好弹框（PC暂未用到，用到请删除此句）
        'fancybox': '//staticv3.youzy.cn/libs/fancybox/jquery.fancybox',
        'fancyboxThumbs': '//staticv3.youzy.cn/libs/fancybox/helpers/jquery.fancybox-thumbs',
        'echarts': '//staticv3.youzy.cn/libs/echarts/echarts.min', //echarts
        'echartsMapChina': '//staticv3.youzy.cn/libs/echarts/china', //echarts
        'highlightRegex': '//staticv3.youzy.cn/libs/highlightRegex', //高亮显示当前页面关键词
        'highcharts5': '//staticv3.youzy.cn/libs/Highcharts-5.0.12/highcharts5.0.12', //hCharts图表渲染插件
        'highchartsMore5': '//staticv3.youzy.cn/libs/Highcharts-5.0.12/highcharts-more5.0.12',
        'highChartsExporting5': '//staticv3.youzy.cn/libs/Highcharts-5.0.12/exporting5.0.12',
        'fineUploader2': '//staticv3.youzy.cn/libs/fineuploader/fineuploader-3.8.0.min',
        'raty': '//staticv3.youzy.cn/libs/jquery-raty/jquery.raty', //打星插件
        'umpplayer': '/content/tv/ump.player_v1.min', //Ucloud直播插件
        'jwplayer': '//staticv3.youzy.cn/libs/jwplayer/jwplayer', //录播插件
        'extensions': '//staticv3.youzy.cn/scripts/extensions',
        'nicescroll': '//staticv3.youzy.cn/libs/jquery.nicescroll/jquery.nicescroll.min',
        'dragula': '//staticv3.youzy.cn/libs/dragula-master/dist/dragula.min', //拖动插件
        'cropper': '//staticv3.youzy.cn/libs/cropper/cropper.min', //图片裁剪,
        //'barrage': '//staticv3.youzy.cn/libs/barrage/barrage',
        'gtLibs': '//staticv3.youzy.cn/libs/gt/gt',
        'moment': '//staticv3.youzy.cn/libs/moment/moment.min',
        'datetimepicker': '//staticv3.youzy.cn/libs/datetimepicker/jquery.datetimepicker.full', //日历控件
        'bootstrap-datetimepicker': '//staticv3.youzy.cn/libs/bootstrap-datetimepicker/bootstrap-datetimepicker.min', //时间空间-纯日期
        'datetimepickerMonth': '//staticv3.youzy.cn/libs/bootstrap-datetimepicker/bootstrap-datetimepicker.zh-CN', //时间控件-纯日期 中文包 通过调用该组件来唤起日历控件
        'dateRangePicker': '//staticv3.youzy.cn/libs/bootstrap-daterangepicker/daterangepicker', //时间空间 区间选择
        'swiper3': '//staticv3.youzy.cn/libs/swiper3.4/swiper.jquery.min', //轮播图
        'aliplayer': '//g.alicdn.com/de/prismplayer/2.8.8/aliplayer-min', //阿里播放代码插件
        'aliplayerComponent': '//staticv3.youzy.cn/libs/aliplayercomponents-1.0.5.min', //阿里播放代码组件
        'bodymovin': '//staticv3-pre.youzy.cn/libs/lottie/bodymovin', //lottie

        //===========dialogs start
        //common
        'dialogs/loading': 'scripts/dialogs/common/loading.dialog', //通用loading
        'dialogs/autosaveloading': 'scripts/dialogs/common/autosave.dialog', //通用自动保存中loading
        'dialogs/message': 'scripts/dialogs/common/message.dialog', //通用消息
        'dialogs/uploadImage': 'scripts/dialogs/common/uploadImage.dialog', //上传
        'dialogs/expertPhoto': 'scripts/dialogs/common/expertPhoto.dialog', //专家上传图片
        'dialogs/useFuntionLogs': 'scripts/dialogs/common/useFunctionLogs.dialog', //非VIP用户能免费查看的次数
        //users
        'dialogs/users/userLogin': 'scripts/dialogs/users/userLogin.dialog', //用户登录
        'dialogs/users/perfectInfo': 'scripts/dialogs/users/perfectInfo.dialog', //用户完善信息
        'dialogs/users/perfectCourseType': 'scripts/dialogs/users/perfectCourseType.dialog', //完善文理科信息
        'dialogs/users/perfectGender': 'scripts/dialogs/users/perfectGender.dialog', //完善性别信息
        'dialogs/users/perfectMobile': 'scripts/dialogs/users/perfectMobile.dialog', //完善手机绑定
        'dialogs/openAuth/weixinLogin': 'scripts/dialogs/openAuth/weixinLogin.dialog', //三方登录 - 微信

        //选科
        'dialogs/profession': 'scripts/dialogs/newGaoKaoChooseSubject/profession.dialog',
        'dialogs/college': 'scripts/dialogs/newGaoKaoChooseSubject/college.dialog',
        //payment
        'dialogs/paymentDialog': 'scripts/dialogs/pay/payment.dialog', //通用支付
        'dialogs/paymentPacksDialog': 'scripts/dialogs/pay/paymentPacks.dialog', //购买课程

        //创建成绩
        'dialogs/users/scoreCountLimit': 'scripts/dialogs/users/scores/scoreCountLimit.dialog', //创建成绩总入口
        'dialogs/users/createScoreIndex': 'scripts/dialogs/users/scores/createScoreIndex.dialog', //创建成绩总入口
        'dialogs/users/createScorePutong': 'scripts/dialogs/users/scores/createScorePutong.dialog', //创建成绩-传统
        'dialogs/users/createScoreJiangsu': 'scripts/dialogs/users/scores/createScoreJiangsu.dialog', //创建成绩-江苏
        'dialogs/users/createScoreZhejiang': 'scripts/dialogs/users/scores/createScoreZhejiang.dialog', //创建成绩-浙江
        'dialogs/users/createScoreShanghai': 'scripts/dialogs/users/scores/createScoreShanghai.dialog', //创建成绩-上海
        'dialogs/users/createScoreShandong': 'scripts/dialogs/users/scores/createScoreShandong.dialog', //创建成绩-山东
        'dialogs/users/createScoreBeijing': 'scripts/dialogs/users/scores/createScoreBeijing.dialog', //创建成绩-新高考//北京
        'dialogs/users/createScoreTianJin': 'scripts/dialogs/users/scores/createScoreTianJin.dialog', //创建成绩-新高考//天津
        'dialogs/users/createScoreHaiNan': 'scripts/dialogs/users/scores/createScoreHaiNan.dialog', //创建成绩-新高考//海南
        //v2
        'dialogs/users/scoreCountLimit': 'scripts/dialogs/users/scores/scoreCountLimit.dialog', //创建成绩总入口
        'dialogs/users/createScoreIndex': 'scripts/dialogs/users/scores/createScoreIndex.dialog', //创建成绩总入口
        'dialogs/users/createScorePuTong/v2': 'scripts/dialogs/users/scores/v2/createScorePuTong.dialog', //创建成绩-传统
        'dialogs/users/createScoreJiangSu/v2': 'scripts/dialogs/users/scores/v2/createScoreJiangSu.dialog', //创建成绩-江苏
        'dialogs/users/createScoreNewGaoKao': 'scripts/dialogs/users/scores/v2/createScoreNewGaoKao.dialog', //创建成绩-浙江
        'dialogs/users/createScoreNewGaoKao312': 'scripts/dialogs/users/scores/v2/createScoreNewGaoKao312.dialog', //创建成绩-3+1+2

        //创建成绩 高考版
        'dialogs/users/createScoreGKPutong': 'scripts/dialogs/users/scores/createScoreGKPutong.dialog', //传统
        'dialogs/users/createScoreGKJiangsu': 'scripts/dialogs/users/scores/createScoreGKJiangsu.dialog', //江苏
        'dialogs/users/createScoreGKZhejiang': 'scripts/dialogs/users/scores/createScoreGKZhejiang.dialog', //浙江
        'dialogs/users/createScoreGKShanghai': 'scripts/dialogs/users/scores/createScoreGKShanghai.dialog', //上海
        'dialogs/users/createScoreGKShandong': 'scripts/dialogs/users/scores/createScoreGKShandong.dialog', //山东
        'dialogs/users/createScoreGKBeijing': 'scripts/dialogs/users/scores/createScoreGKBeijing.dialog', //北京
        'dialogs/users/createScoreGKTianjin': 'scripts/dialogs/users/scores/createScoreGKTianjin.dialog', //天津
        'dialogs/users/createScoreGKHainan': 'scripts/dialogs/users/scores/createScoreGKHainan.dialog', //海南
        //v2
        'dialogs/users/createScoreGKPuTong/v2': 'scripts/dialogs/users/scores/v2/createScoreGKPuTong.dialog', //创建成绩-传统
        'dialogs/users/createScoreGKJiangSu/v2': 'scripts/dialogs/users/scores/v2/createScoreGKJiangSu.dialog', //创建成绩-江苏
        'dialogs/users/createScoreGKNewGaoKao': 'scripts/dialogs/users/scores/v2/createScoreGKNewGaoKao.dialog', //创建成绩-浙江

        //tzy
        'dialogs/tzy': 'scripts/dialogs/tzy/tzy.dialog', //传统
        'dialogs/tzy/pfraction': 'scripts/dialogs/tzy/pfraction.dialog', //填志愿专业分数线
        'dialogs/tzy/replaceCollege': 'scripts/dialogs/tzy/replaceCollege.dialog', //相同志愿院校替换
        'dialogs/tzy/tzyMessage': 'scripts/dialogs/tzy/tzyMessage.dialog',
        'services/tzy/dataTransformation': 'scripts/controllers/tzy/chuanTongOrJiangSu/dataTransformation.controller',
        'services/tzy/sessionStorage': 'scripts/controllers/tzy/tianZy/chuanTong/sessionStorage.controller', //职业优先填报 - 院校优先 - 专业优先之间的购物车值保存
        'tzy/chuanTong/common': 'scripts/controllers/tzy/tianZy/chuanTong/common.controller', //填志愿-传统版和江苏版-通用JS

        //===========main services start
        'services/base': 'scripts/services/base.service', //所有调用数据服务基类
        'services/config': 'scripts/services/config',
        'services/common/youzyEpt': 'scripts/services/common/youzyEpt.service',
        'services/workContext': 'scripts/services/workContext.service',
        'services/common/gtCaptcha': 'scripts/services/common/gtCaptcha.service',
        'services/common/aes': 'scripts/services/common/aes.service',
        'services/common/aesHelp': 'scripts/services/common/aeshelp.service',
        'services/common/common': 'scripts/services/common/common.service', //业务通用service 例 获取高考年
        'services/common/areas': 'scripts/services/common/areas.service',
        'services/common/sessionStorage': 'scripts/services/common/sessionStorage.controller',
        'services/common/tools': 'scripts/services/common/tools.service',
        'services/common/paging': 'scripts/services/common/paging.service',
        'services/common/pagingChooseSubject': 'scripts/services/common/pagingChooseSubject.service', //选科弹框里的分页专供
        'services/common/handlebarsHelper': 'scripts/services/common/handlebarsHelper.service', //通用helper
        'services/iframe': 'scripts/services/common/iframe.service',
        'services/ares': 'scripts/services/ares/ares.service', //ares埋点
        'services/ub4y': 'scripts/services/ub4y/track.service', //ub4y埋点

        //===========business services start
        'services/openAuth': 'scripts/services/openAuth/openAuth.service', //三方登录
        'services/payment/order': 'scripts/services/payment/order.service', //支付服务
        'services/aboutUs': 'scripts/services/aboutUs/aboutUs.service', //优志愿 关于我们
        'services/lessons': 'scripts/services/lessons/lessons.service', //课堂-课程服务-德智
        'services/examination': 'scripts/services/examination/examination.service', //课堂-试卷服务
        'services/classrooms': 'scripts/services/classrooms/classrooms.service', //课堂-讲堂服务
        'services/experts': 'scripts/services/experts/experts.service', //专家服务
        'services/expertsOP': 'scripts/services/experts/expertsOP.service', //开放服务-专家服务
        'services/helpCenter': 'scripts/services/helpCenter/helpCenter.service', //帮助中心
        'services/studyTour': 'scripts/services/studyTour/studyTour.service', //留学
        'services/tzy/evaluation/download': 'scripts/services/tzy/evaluation/download.service', //测评-下载服务
        'services/tzy/evaluation/questions': 'scripts/services/tzy//evaluation/questions.service', //测评-获取题库服务
        'services/tzy/evaluation/results': 'scripts/services/tzy/evaluation/results.service', //测评-获取题库结果服务
        'services/tzy/evaluation/scores': 'scripts/services/tzy/evaluation/scores.service', //测评-提交测评结果服务
        'services/tzy/evaluation': 'scripts/services/tzy/evaluation/evaluation.service', //测评服务
        'services/tzy/evaluation/tips': 'scripts/services/tzy/evaluation/tips.service', //测评-提示文字
        'services/colleges': 'scripts/services/colleges/colleges.service', //找大学、大学详情页模块
        'services/majors': 'scripts/services/majors/majors.service', //专业服务
        'services/scoreLines': 'scripts/services/scoreLines/scoreLines.service', //分数线、招生计划等模块
        'services/configuration': 'scripts/services/configuration/configuration.service', //配置服务-获取分数线等各种
        'services/zyRule': 'scripts/services/configuration/zyRule.service', //志愿配置服务
        'services/gaokao': 'scripts/services/configuration/gaokao.service', //新高考配置服务
        'services/configuration/scoreLine': 'scripts/services/configuration/scoreLines.service', //分数线等模块配置信息
        'services/careers': 'scripts/services/careers/careers.service', //职业库
        'services/cards': 'scripts/services/cards/cards.service', //会员卡服务
        'services/users': 'scripts/services/users/users.service', //用户服务
        'services/users/chooseSubjectsSolution': 'scripts/services/users/chooseSubjectsSolution.service', //用户选科服务
        'services/users/zyTable': 'scripts/services/users/zyTable.service', //智能填报-志愿表服务
        'services/users/sms': 'scripts/services/users/sms.service', //用户sms服务
        'services/users/socials': 'scripts/services/users/socials.service', //用户三方服务
        'services/users/scores': 'scripts/services/users/scores.service', //用户成绩服务
        'services/users/logs': 'scripts/services/users/logs.service', //用户日志服务
        'services/users/useFunctionLogs': 'scripts/services/users/useFunctionLogs.service', //用户使用日志
        'services/users/searchKeywords': 'scripts/services/users/searchKeywords.service', //用户搜索记录
        'services/collection': 'scripts/services/users/collection.service', //用户关注服务
        'services/students/expertFillin': 'scripts/services/students/expertFillin.service', //专家一对一服务
        'services/students/zyTable': 'scripts/services/students/zyTable.service', //智能填报-志愿表服务
        'services/users/scores': 'scripts/services/users/scores.service', //用户成绩服务
        'services/chooseSubjects': 'scripts/services/chooseSubjects/chooseSubjects.service', //选科服务
        'services/chooseSubjects/colleges': 'scripts/services/chooseSubjects/colleges.service', //选科-院校服务
        'services/chooseSubjects/majors': 'scripts/services/chooseSubjects/majors.service', //选科-专业服务
        'services/students/favoriteTag': 'scripts/services/students/favoriteTag.service', //选科服务
        'services/tzy/collegeEnroll': 'scripts/services/tzy/collegeEnroll.service', //填志愿模块招生服务
        'services/tzy/preFraction': 'scripts/services/tzy/preFraction.service', //填志愿提前批
        'services/tzy/func': 'scripts/services/tzy/func.service', //成绩查询服务
        'services/tzyCdiData': 'scripts/services/tzy/expertTzyConditionData.service', //智能推荐通用数据
        'services/tzy/recommendation': 'scripts/services/tzy/recommendation.service', //智能推荐服务
        'services/tzy/tzyCollegeFirst': 'scripts/services/tzy/tzyCollegeFirst.service', //智能推荐-院校优先
        'services/tzy/tzyMajorFirst': 'scripts/services/tzy/tzyMajorFirst.service', //智能推荐-专业优先
        'services/tzy/tzyManualFill': 'scripts/services/tzy/tzyManualFill.service', //智能推荐-职业优先填报
        'services/tzy/chooseSubject': 'scripts/services/tzy/chooseSubject.service', //选科服务
        'services/tzy/zhiYuanTable': 'scripts/services/tzy/zhiYuanTable.servie', //新版智能填报
        'services/payments': 'scripts/services/payments/payments.service', //支付服务
        'services/order/zyTables': 'scripts/services/order/zyTables.service', //专家志愿表服务
        'services/news': 'scripts/services/news/news.service', //新闻服务
        'services/activities/chuCaiBei': 'scripts/services/activities/chuCaiBei.service', //楚才杯服务
        'services/activities/studyAbroad': 'scripts/services/activities/studyAbroad.service', //留学预约服务
        'services/openPlatform': 'scripts/services/openPlatform/openPlatform.service', //开发平台
        'services/notification': 'scripts/services/notification/notification.service', //小优快讯
        'services/homepage': 'scripts/services/homepage/homepage.service',
        'services/dataCenter': 'scripts/services/dataCenter/dataCenter.service',
        'services/community': 'scripts/services/community/comment.service',
        'services/stores': 'scripts/services/stores/stores.service', //机构服务
        'services/aliyun': 'scripts/services/aliyun/aliyun.service', //阿里云服务
        'services/live': 'scripts/services/live/live.service', //直播
        //defy
        'services/defy/search': 'scripts/services/defy/search.service', //搜索服务


        //===========business controllers start
        'controllers/tzy/tianZy/shanDong/shopingCar': 'scripts/controllers/tzy/tianZy/shanDong/shopingCar.controller', //山东购物车
        'controllers/tzy/tianZy/zheJiang/shopingCar': 'scripts/controllers/tzy/tianZy/zheJiang/shopingCar.controller', //浙江购物车
        'controllers/tzy/tianZy/beiJing/shopingCar': 'scripts/controllers/tzy/tianZy/beiJing/shopingCar.controller', //北京购物车
        'controllers/tzy/tianZy/tianJin/shopingCar': 'scripts/controllers/tzy/tianZy/tianJin/shopingCar.controller', //天津购物车
        'controllers/tzy/tianZy/haiNan/shopingCar': 'scripts/controllers/tzy/tianZy/haiNan/shopingCar.controller', //海南购物车
        'controllers/tzy/tianZy/shangHai/shopingCar': 'scripts/controllers/tzy/tianZy/shangHai/shopingCar.controller', //上海购物车
    },
    shim: {
        'ueditor/config': {
            deps: ['jquery']
        },
        'ueditor': {
            deps: ['ueditor/config']
        },
        'bootstrap': {
            deps: ['jquery']
        },
        'handlebars': {
            exports: 'Handlebars'
        },
        'easyPieChart': {
            deps: ['jquery', 'easing1.3']
        },
        'highlightRegex': {
            deps: ['jquery']
        },
        'highcharts': {
            deps: ['jquery']
        },
        'highcharts5': {
            deps: ['jquery']
        },
        'highchartsMore5': {
            deps: ['jquery', 'highcharts5']
        },
        'tmpl': {
            deps: ['jquery']
        },
        'baiduMap': {
            deps: ['jquery']
        },
        'dragdealer': {
            deps: ['jquery']
        },
        'jqueryPagination': {
            deps: ['jquery']
        },
        'fancybox': {
            deps: ['jquery']
        },
        'fancyboxThumbs': {
            deps: ['jquery']
        },
        'superSlide': {
            deps: ['jquery']
        },
        'placeholder': {
            deps: ['jquery']
        },
        'json2': {
            deps: ['jquery']
        },
        'json3': {
            deps: ['jquery']
        },
        'qrcode': {
            deps: ['jquery', 'qrcodeUtils']
        },
        'suggest': {
            deps: ['jquery']
        },
        'datetimepickers-zh': {
            deps: ['jquery', 'datetimepickers']
        },
        'raty': {
            deps: ['jquery']
        },
        'slimScroll': {
            deps: ['jquery']
        },
        'umpplayer': {
            deps: ['jquery']
        },
        'jwplayer': {
            deps: ['jquery']
        },
        datetimepicker: {
            deps: ['jquery']
        },
        'bootstrap-datetimepicker': {
            deps: ['jquery']
        },
        'datetimepickerMonth': {
            deps: ['jquery', 'bootstrap-datetimepicker']
        },
        'dateRangePicker': {
            deps: ['jquery', 'moment']
        },
        'aliplayerComponent': {
            deps: ['aliplayer']
        }
    }

});

require.onError = function (err) {
    console.log(err.requireType);
    if (err.requireType === 'timeout') {
        console.log('modules: ' + err.requireModules);
    }
    throw err;
};

//初始化方法
require(['jquery', 'services/config', 'services/workContext', 'services/users', 'services/common/tools',
        'dialogs/users/userLogin', 'dialogs/openAuth/weixinLogin', 'dialogs/users/perfectMobile',
        'dialogs/users/perfectCourseType', 'dialogs/users/perfectInfo', 'services/configuration/scoreLine',
        'placeholder', 'bootstrap'
    ],
    function ($, configService, workContext, userService, tools,
              userLoginDialog, weixinLoginDialog, userPerfectMobileDialog,
              userPerfectCourseTypeDialog, userPerfectInfoDialog, scoreLineService) {

        if (configService.isRelease == false) {
            console.log(workContext.currentProvince)
            console.log(workContext.currentLoginUser)
            console.log(workContext.currentScore)
            console.log(workContext.ufs)
            console.log(workContext.TempScore)
        }

        if (workContext.currentLoginUser.numId > 0) {
            //登录后，并且没有绑定手机的用户，需要绑定手机
            if (workContext.currentLoginUser.mobilePhone == '' || workContext.currentLoginUser.mobilePhone == null) {
                userPerfectMobileDialog.open(0);
            }
        }

        //三方登录后，需要绑定手机
        if (workContext.openUser != '') {
            if (workContext.currentLoginUser.mobilePhone == '' || workContext.currentLoginUser.mobilePhone == null) {
                userPerfectMobileDialog.open(1);
            }
        }

        //根据条件判断需要完善的资料
        if (workContext.currentLoginUser.numId > 0) {

            if (workContext.currentLoginUser.provinceId == '' || workContext.currentLoginUser.provinceId == 0) {
                if (window.location.href.indexOf('set-token') === -1) {
                    userPerfectInfoDialog.open();
                }
            } else {
                scoreLineService.getByProvinceNumId(workContext.currentLoginUser.provinceId).done(function (res) {
                    switch (workContext.currentLoginUser.provinceId) {
                        case 1:
                        case 839:
                        case 845:
                        case 850:
                        case 851:
                        case 849:
                        case 850:
                        case 854:
                        case 1128:
                            res.result.isOpenNewVersion = true
                            break;

                        default:
                            break;
                    }
                    // if (!res.result.isOpenNewVersion && workContext.currentLoginUser.courseType != 0 && workContext.currentLoginUser.courseType != 1) {
                    //     userPerfectCourseTypeDialog.open();

                    // }
                })
            }

            // if (workContext.currentLoginUser.provinceId != 843 && workContext.currentLoginUser.provinceId != 842 && workContext.currentLoginUser.provinceId != 847 && workContext.currentLoginUser.courseType == -1) {
            //     // 完善文理科
            //     userPerfectCourseTypeDialog.open();
            // }
        }

        $(window).scroll(function () {
            //回到顶部按钮显示隐藏
            if ($(window).scrollTop() > 400) {
                $("#onlineTop").show(400);
            } else {
                $("#onlineTop").hide(400);
            }
        });

        var rightWidgets = function () {
            if ($(window).width() <= 1400) {
                $('.right-widgets').css('display', 'none');
            } else {
                $('.right-widgets').css('display', 'block');
            };
        }
        rightWidgets();
        window.onresize = function () {
            rightWidgets();
        }

        //回到顶部按钮
        $("body").delegate(".right-widgets .t3", "click", function () {
            $('body,html').animate({
                scrollTop: 0
            }, 300);
            return false;
        })

        //顶部通用搜索
        $('#btntopSearch').on('click', function () {
            var keywords = $("#searchwd").val().trim();
            if (keywords.length >= 2) {
                var reg = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
                if (reg.test(keywords) == false) {
                    tools.alert.warning("提醒", "仅支持汉字、英文、数字，请重新输入关键字进行搜索")
                } else {
                    window.location.href = '/search/articleList?wd=' + keywords;
                }
            } else {
                tools.alert.warning("提醒", "请输入至少2个汉字、英文或数字进行搜索")
            }

        });
        $("#searchwd").keyup(function () {
            if (event.keyCode == 13) {
                //这里写你要执行的事件;
                var keywords = $("#searchwd").val().trim();
                if (keywords.length >= 2) {
                    var reg = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
                    if (reg.test(keywords) == false) {
                        tools.alert.warning("提醒", "仅支持汉字、英文、数字，请重新输入关键字进行搜索")
                    } else {
                        window.location.href = '/search/articleList?wd=' + keywords;
                    }
                } else {
                    tools.alert.warning("提醒", "请输入至少2个汉字、英文或数字进行搜索")
                }
            }
        });

        //登录
        $("#divLogin").on("click", function () {
            userLoginDialog.open();
        });

        //微信登录
        $('.js-weixinLogin').on("click", function () {
            weixinLoginDialog.open();
        });

        //体验VIP领取
        $('.scan-btn').mouseenter(function () {
            $(this).siblings('.scan-ewm-box').addClass('active')
        })
        $('.scan-btn').mouseleave(function () {
            $(this).siblings('.scan-ewm-box').removeClass('active')
        })


    });
