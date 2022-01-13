require(['jquery', 'underscore', 'handlebars', 'services/common/tools', 'dialogs/paymentDialog', 'superSlide',
        'fancyboxThumbs'
    ],
    function ($, _, handlebars, tools, paymentDialog) {

        var vc = {};
        vc.modules = {};

        var $container = $(".card-info");
        var $orderName = '升学卡在线购买';
        var $yearNum = $('.card-year');

        var $type1Text = $(".type1"); //志愿卡
        var $type2Text = $(".type2"); //升学卡
        var $type3Text = $(".type3"); //职业招生宝典
        var $type4Text = $(".type4"); //职业招生宝典和卡

        var priceContext = {
            type: 1,
            year: 1,
            num: 1,
            price: '0',
            productType: 4,
            title: '',
            detail: '请选择卡类型'
        }

        var cartInfo = {
            bussType: 0,
            productName: '',
            orderPrice: 0
        }


        vc.modules.render = function () {
            var _renderUsersSay = function () {
                //服务用户评价
                var cDate = new Date();
                var arr = [{
                    "userName": "135****598",
                    "appraise": "数据比较准，有高考课堂可以看免费看老师们的视频和大学学姐学长讲专业，服务不贵好用推荐大家哦！",
                    time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                        .getDate()
                },
                    {
                        "userName": "小*天",
                        "appraise": "拿到了张体验卡，开始很抵触，因为免费试用了一下，体验下来真不错，服务的价格也不贵关键是实用，所以就升级开通了服务啦！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "159****9182",
                        "appraise": "高考是人生的一次重大的转折，志愿报名更是重要，优志愿上的学校信息都非常全面并且信息专业靠谱，开通服务后畅通无阻，特别喜欢一键填报，直接推荐4套志愿方案，省时省力，赞赞赞！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "张*辉",
                        "appraise": "女儿快要考了，家长就关注高考的各种动态咨询，特别推荐其他家长看下讲堂那个板块，开通服务后几乎每个专家的视频都看过，从专业到心理调整很全面受益匪浅。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "有**你",
                        "appraise": "作为家长现在也没办法在学习上帮她太多了，只有在后期好好支持支持她，现在多看看学校专业介绍、志愿模拟填报，以后就不会迷茫了。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "灭**魔",
                        "appraise": "好用，特别喜欢一键填报功能，适合我这种懒人，哈哈喜欢！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "L****p",
                        "appraise": "这个网站还真的很实用的说，只要把分数地区文理等相关信息输进去就可以显示出自己适合什么学校，服务内容丰富价格实在，现在我妈手机下载了app看的可勤快了。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "清**杯",
                        "appraise": "推荐和我一样奋战在高考前线的同志们，优志愿服务靠谱、有效、便捷、精准！哈哈我好像水军哦！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "M****y",
                        "appraise": "优志愿讲堂内容丰富，上千位在校学长讲自己大学的专业，超级牛，果断服务，这样就可以随便看啦！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "C******g",
                        "appraise": "总结一下服务滴优点：功能强大，课程丰富，数据权威，使用方便。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "侧**听",
                        "appraise": "与其他同类型网站相比，价格算良心的，实用型的网站，蛮好的告别翻书。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "王*乐",
                        "appraise": "优志愿，很棒的网站！会及时通知与高考相关的事情，网站的内容都很有价值。这个服务值得购买。点个赞！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "為**鈊",
                        "appraise": "很多实时的高考资讯、学校的招生等等都更新很快，报考指南、专业的学习辅导都很实用，模拟填报功能的数据也准确！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "郭*浩",
                        "appraise": "强烈推荐大家使用测录取概率功能，我把想上的学校都测了个遍，感觉又好玩又实用。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "宝**曦",
                        "appraise": "表扬下优志愿app，真的好用，信息量很强大不亚于网站，作为高三学生的家长这个app点击量是最高的，开通服务后一直看老师们的课程，对我们帮助非常大。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "T**p",
                        "appraise": "很好用的志愿填报网站，这段时间孩子们很辛苦，可是我们家长也要在后面多学习点专业、学校、志愿填报方面的知识，不要等到填志愿的时候没有头绪，准备考试结束后再预约个专家。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "洪*睿",
                        "appraise": "花小钱大回报，开通了服务功能，内容丰富，一键填报方案也很合理，现在考虑预约个专家团。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "186****8737",
                        "appraise": "作为一个第二次参加高考的考生真觉得这个网站很全面，去年我全靠翻书填报的志愿，二本线过了，可是最后只能读专科，果断复读，接触到优志愿这个网站后果断购买了服务，因为我不想再填志愿上面重蹈覆辙。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "12****12",
                        "appraise": "马上就要参加高考了，一直都没想好想去哪里读大学，连专业都没有方向，偶尔碰到了优志愿这个志愿模拟系统，可真方便，信息也准确的，推荐开通服务，用起来更不受限制。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "x*****e",
                        "appraise": "填志愿的好助手啊！不错不错哦！给妈妈手机下载了优志愿软件，现在看的比我还勤快！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "郁*容",
                        "appraise": "网站关于高考的内容还是比较全面的，功能性很强，信息的更新也很快，服务功能也算合理，特别推荐大家看下几位专家专题视频，个人觉得很受用。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "183****2867",
                        "appraise": "对即将高考的考生和家长来说很不错，能够了解高考的最新消息与动态，推荐大家使用模拟填报，不要等真天志愿了无从下手。总的来说网站的服务权限很强大，值得大家一看。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "彩**文",
                        "appraise": "这个服务性价比还挺高的，特别推荐高中的同学一开始就使用，可以为自己定一个目标院校，有了目标才有动力，现在这个目标已经离我越来越近了。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "L******Z",
                        "appraise": "强推优志愿服务功能哦！可以提供很多和高考择校相关的有用信息，和避免志愿填报上面的盲区。超级赞！！！！！！！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "E****O",
                        "appraise": "优志愿讲堂内容好丰富，好多在校学长讲自己大学的专业，对很多专业有了新的了解，只可惜很多专家课程需要购买才能看到，所以干脆开通了服务功能，发现还是很实用的。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "陈*云",
                        "appraise": "刚开通了服务功能，给孩子做一个高考目标定位，看看孩子现在的成绩到底能上到哪些大学，院校优先填报、一键填报和模拟填报都非常给力，数据靠谱推荐给高三的家长们！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "心**水",
                        "appraise": "这个系统可以用分数来进行分析可以上哪所大学，特别是靠谱率感觉很神奇啊！还能通过性格等测试推荐就读的专业系别，挺好用的。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "雨**落",
                        "appraise": "整个网站感觉都蛮靠谱的，数据信息都很全面，功能性也强，开通服务的价格也算得上是业界良心了，对比了很多家才选择开通优志愿。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "157****1351",
                        "appraise": "这个网站使用还是很方便的，作为一个高三学生家长，看了好多好多这类网站，感觉都好复杂有点晕菜啊！这里的一键填报真的是很方便，志愿填报感觉也没那么复杂。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "天****手",
                        "appraise": "拿到优志愿的体验卡，开始没在意，最近偶然发现，登录后发现感觉不错，涨姿势了，用了几天发现服务权限更大，关键是价格不贵，很好！赞！推荐！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "路***猪",
                        "appraise": "不错不错不错，重要的事情说三遍。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "b***2",
                        "appraise": "挺好的，开通了服务，现在每天都会上来测测录取概率，模拟填报，提前为孩子填志愿做准备。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "荆***约",
                        "appraise": "这家的志愿填报是我用到现在数据最准确的，推的学校也很靠谱",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "神***丶",
                        "appraise": "推荐给高三的学子和家长们，本人鉴定过了，很靠谱的网站。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "j***6",
                        "appraise": "内容全，功能强，信息更新额也很快，蛮好的。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "像***红",
                        "appraise": "因为看了李老师的直播，讲的很有道理，给我们家长很多帮助，所以开通了服务，觉得这个网站蛮好的，孩子忙着备考，家长也要早做准备。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "y***3",
                        "appraise": "开通了服务，发现预约专家团是赠送服务功能的，早知道就先预约专家团了，孩子就那么一次高考，还是准备预约个专家帮我们分析下很有必要的。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "159****7822",
                        "appraise": "我今年才高二，提早做准备，哈哈哈！还过一年我也要参加高考了，但是我已经锁定目标学校了，还有1年多，为了目标，我要努力努力。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "喊***哥",
                        "appraise": "别人送的服务卡，反正免费的登录看看，没想到发现新大陆啊，院校优先的那个功能推荐的学校大多数都是我喜欢的学校，真心好用哦！推荐！！！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "赵***5",
                        "appraise": "作为苦逼高三党，强推优志愿的服务功能，操作方便，速度快，哦对了！我说的是app，哈哈哈！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "s***8",
                        "appraise": "为了看视频才开通的服务，没想到还有直播了，问的问题李老师解答的好清楚，真的对我们家长的帮助很大啊，用孩子模考成绩模拟填报，发现离目标学校还有点距离，这么点时间了，只能靠孩子自己用功了。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "酱***7",
                        "appraise": "恩！可以！现在家长比孩子紧张啊！希望对孩子有帮助。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "x****l",
                        "appraise": "优志愿关注蛮久了，老实说之前大多数功能都可以用的，现在都要开通服务了，好在价格不贵，性价比还算可以。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "龙***人",
                        "appraise": "用同学账号做了测录取概率的测试，感觉蛮方便的，所以自己也开通了服务功能，因为太坏了还有次数限制55555.....",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "阿***脑",
                        "appraise": "别人帮我开通的服务卡，看了下感觉网站还不错，准备研究研究怎么玩法。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "上*****花",
                        "appraise": "学校发的体验卡，试用了下，很有针对性，所以毫不犹豫的开通了服务功能，试用很方便，特别是手机上，使用方便，赞！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "刘***4",
                        "appraise": "好用、推荐、可怜的高三党们！当然我也是其中一位啦！为自己目标努力！！！！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "1***k",
                        "appraise": "朋友推荐优志愿的，使用下来觉得还是很方便的，不管是在电脑上还是手机上，就是大多数功能都需要服务权限，胜在价格不贵，总体还是值得推荐的。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "妮*",
                        "appraise": "好用！！方便！！全面！！靠谱！！使用方便！哈哈哈!我不是托~~~",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "可*多",
                        "appraise": "家长群里其他家长推荐的网站，最近这种类型网站是在看的太多了，综合看下来还是优志愿推荐的学校比较靠谱！这个服务的钱没白花！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "心***星",
                        "appraise": "了能进入梦想的大学，享受那种氛围，我不停努力，早早为自己的未来做规划，因为我今年高二，看到学姐学长么那么认真的学习，我也要不停加油！加油！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "s***p",
                        "appraise": "刚开始我是排斥收费的，但是使用后我觉得开通服务还是和值得的，现在就是我的志愿小助手！啦啦啦啦~~~",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "吴*少",
                        "appraise": "读书不好今年估计也就上个专科，所以准备复读了，感觉怎么都得混个本科学历吧！这学校信息很强啊！分数线都很全，提前先了解哪些学校我考得上的，北大清华什么的就膜拜膜拜吧！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "O**7",
                        "appraise": "临近考试，作为家长越来越紧张，但是又不能让儿子看出来，哎~高三的孩子辛苦，家长也辛苦啊！还好马上就要熬出头了，最近每天都会上这里看看咨询、或是老师们的视频，特别推荐专业解读这个版块，孩子们讲的都很好很用心，几乎所有学校专业都看过了！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "177****8954",
                        "appraise": "马上就要高考啦！高三苦逼的孩子们一起加油吧！我们大学见！！！！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "a****8",
                        "appraise": "好喜欢一键填报功能，帮我推荐的所有地区的学校，太有参考价值了，我妈也说推荐的几所学校都不错，就是还不知道到低选哪个专业，她说干脆预约个老师帮我参考参考。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "8***j",
                        "appraise": "这个服务权限还是很良心的，价格不贵，功能也蛮多的，关键是信息比较准确，对孩子填志愿能起到一定的作用。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "179****487",
                        "appraise": "在线开通服务功能很方便啊，支付宝扫一扫就好了，就是能有点折扣什么的就好了。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "万*宇",
                        "appraise": "分想预约个专家团试试看啊！但毕竟价格不便宜，所以先开通了服务试试水，使用下来整个网站有些功能有点复杂啊！不过还好都有提示稍微摸索下就了解了，如果预约专家团能优惠就好了，哈哈哈哈！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    }
                ];

                var round = _.sample(arr, 30);

            }
            var _renderPhotos = function () {
                //购买幻灯图片
                $(".card-show .photes-box li").eq(0).show();
                $(".card-show .nail li").mouseenter(function () {
                    var index = $(".card-show .nail li").index(this);
                    $(".card-show .nail li").removeClass("active");
                    $(this).addClass("active");
                    $(".card-show .photes-box li").hide();
                    $(".card-show .photes-box li").eq(index).show();
                });

                //会议幻灯片
                $(".picScroll-left").slide({
                    titCell: ".hd ul",
                    mainCell: ".bd ul",
                    effect: "left",
                    autoPlay: true,
                    trigger: "click"
                });
            }
            var _renderSecret = function () {
                //展开秘密
                $('.secret .unfold').on('click', function () {
                    $(this).addClass('hide');
                    $('.secret-txt').removeClass('hide');
                })
                $('.secret .fold').on('click', function () {
                    $('.secret .unfold').removeClass('hide');
                    $('.secret-txt').addClass('hide');
                })
            }
            var _renderVipTip = function () {
                //查看VIP特权
                $('.card-buy-v3 .vip-tip').on('mouseenter', function () {
                    $('.card-buy-v3 .vip-tip-table').css('display', 'block');
                })
                $('.card-buy-v3 .vip-tip').on('mouseleave', function () {
                    $('.card-buy-v3 .vip-tip-table').css('display', 'none');
                })
            }
            var _renderVipContent = function () {
                $(window).scroll(function () {
                    var $scroll = $(document).scrollTop();

                    //vip
                    //part1
                    if ($scroll >= 0) {
                        $('.part1-1').removeClass('hide').addClass('fadeIn')
                        $('.part1-2').removeClass('hide').addClass('fadeIn')
                        $('.part1-3').removeClass('hide').addClass('fadeInUp')
                        $('.part1-4').removeClass('hide').addClass('fadeInUp')
                        $('.part1-5').removeClass('hide').addClass('fadeInUp')
                        $('.part1-6').removeClass('hide').addClass('fadeInUp')
                        $('.part1-7').removeClass('hide').addClass('fadeInRight')
                    }

                    //part2
                    if ($scroll >= 800) {
                        $('.part2-1').removeClass('hide').addClass('fadeInUp')
                        $('.part2-4').removeClass('hide').addClass('fadeInDown')
                        $('.part2-2').removeClass('hide').addClass('fadeInUp')
                        $('.part2-3').removeClass('hide').addClass('fadeInUp')
                    }

                    //part3
                    if ($scroll >= 1200) {
                        $('.part3-1').removeClass('hide').addClass('fadeInUp')
                        $('.part3-2').removeClass('hide').addClass('fadeInLeft')
                        $('.part3-3').removeClass('hide').addClass('fadeInUp')
                        $('.part3-4').removeClass('hide').addClass('fadeInRight')
                    }

                    //part4
                    if ($scroll >= 1800) {
                        $('.part4-1').removeClass('hide').addClass('fadeInUp')
                        $('.part4-2').removeClass('hide').addClass('fadeInLeft')
                        $('.part4-3').removeClass('hide').addClass('fadeInUp')
                        $('.part4-4').removeClass('hide').addClass('fadeInDown')
                        $('.part4-5').removeClass('hide').addClass('fadeInUp')
                        $('.part4-6').removeClass('hide').addClass('fadeInDown')
                    }

                    //part5
                    if ($scroll >= 2300) {
                        $('.part5-1').removeClass('hide').addClass('fadeInUp')
                        $('.part5-2').removeClass('hide').addClass('fadeInUp')
                        $('.part5-3').removeClass('hide').addClass('fadeInRight')
                        $('.part5-4').delay(1000).removeClass('hide').addClass('zoomIn')
                        $('.part5-5').delay(2000).removeClass('hide').addClass('zoomIn')
                        $('.part5-6').delay(3000).removeClass('hide').addClass('zoomIn')
                        $('.part5-7').delay(4000).removeClass('hide').addClass('zoomIn')
                    }

                    //part6
                    if ($scroll >= 2800) {
                        $('.part6-1').removeClass('hide').addClass('fadeInUp')
                        $('.part6-2').removeClass('hide').addClass('fadeInUp')
                        $('.part6-3').removeClass('hide').addClass('fadeInLeft')
                        $('.part6-4').removeClass('hide').addClass('fadeInUp')
                        $('.part6-5').removeClass('hide').addClass('fadeInDown')
                        $('.part6-6').removeClass('hide').addClass('fadeInUp')
                    }
                })
            }
            var _renderSxkContent = function () {
                $(window).scroll(function () {
                    var $scroll = $(document).scrollTop();

                    //shengxueka
                    //part2
                    if ($scroll >= 800) {
                        $('.partb2-1').removeClass('hide').addClass('fadeInUp')
                        $('.partb2-2').removeClass('hide').addClass('fadeInDown')
                        $('.partb2-3').removeClass('hide').addClass('fadeInDown')
                        $('.partb2-4').removeClass('hide').addClass('zoomIn')
                    }

                    //part3
                    if ($scroll >= 900) {
                        $('.partb3-1').removeClass('hide').addClass('fadeInDown')
                        $('.partb3-2').removeClass('hide').addClass('fadeInDown')
                        $('.partb3-3').removeClass('hide').addClass('fadeInUp')
                    }

                    //part4
                    if ($scroll >= 1100) {
                        $('.partb4-1').removeClass('hide').addClass('fadeInUp')
                        $('.partb4-2').removeClass('hide').addClass('fadeInDown')
                        $('.partb4-3').removeClass('hide').addClass('fadeInUp')
                        $('.partb4-4').removeClass('hide').addClass('fadeInUp')
                    }

                })
            }
            return {
                renderUsersSay: _renderUsersSay,
                renderPhotos: _renderPhotos,
                renderSecret: _renderSecret,
                renderVipTip: _renderVipTip,
                renderVipContent: _renderVipContent,
                renderSxkContent: _renderSxkContent
            }
        }()

        vc.modules.service = function () {
            //根据参数显示价格
            var _changePrice = function () {
                $('#now-price').html('￥' + priceContext.price);

                $('#base-price').html('原价：￥' + priceContext.detail);
                if (priceContext.type == 3)
                    $('#base-price').addClass('hide');
                else
                    $('#base-price').removeClass('hide');
                $('#card-title').html(priceContext.title);
            }
            //判断是否需要改动价格
            var _checkPrice = function () {
                if (priceContext.type == 1) {
                    priceContext.price = '360';
                    priceContext.detail = '698';
                    priceContext.title = '志愿卡（VIP）';
                    priceContext.productType = 4;
                    return false;
                }
                if (priceContext.type == 2) {
                    priceContext.price = '460';
                    priceContext.detail = '1098';
                    priceContext.title = '升学卡（VIP+全科提分）';
                    priceContext.productType = 23;
                    return false;
                }
                if (priceContext.type == 3) {
                    priceContext.price = '200';
                    priceContext.detail = '598';
                    priceContext.title = '职业招生卡（送自招宝典）'
                    priceContext.productType = 26;
                    return false;
                }
                if (priceContext.type == 4) {
                    priceContext.price = '560';
                    priceContext.detail = '1298';
                    priceContext.title = '升学卡+职业招生卡（送自招宝典）'
                    priceContext.productType = 27;
                    return false;
                }
                return true;
            }
            return {
                changePrice: _changePrice,
                checkPrice: _checkPrice
            }
        }()

        vc.modules.bindEvent = function () {
            //选择类型
            var _chooseType = function () {
                $('.card-type a').on('click', function () {
                    $(this).addClass('choosed');
                    $(this).siblings().removeClass('choosed');
                    var _type = $(this).data('type');
                    switch (_type) {
                        case 1:
                            priceContext.type = 1;
                            $yearNum.addClass('hide');
                            vc.modules.service.checkPrice();
                            vc.modules.render.renderVipContent();
                            $type1Text.removeClass("hide");
                            $type2Text.addClass("hide");
                            $type3Text.addClass("hide");
                            $type4Text.addClass("hide");
                            break;
                        case 2:
                            priceContext.type = 2;
                            $yearNum.removeClass('hide');
                            vc.modules.service.checkPrice();
                            vc.modules.render.renderSxkContent();
                            $type2Text.removeClass("hide");
                            $type1Text.addClass("hide");
                            $type3Text.addClass("hide");
                            $type4Text.addClass("hide");
                            break;
                        case 3:
                            priceContext.type = 3;
                            $type3Text.removeClass("hide");
                            $type1Text.addClass("hide");
                            $type2Text.addClass("hide");
                            $type4Text.addClass("hide");
                            vc.modules.service.checkPrice();
                            break;
                        case 4:
                            priceContext.type = 4;
                            $type4Text.removeClass("hide");
                            $type1Text.addClass("hide");
                            $type2Text.addClass("hide");
                            $type3Text.addClass("hide");
                            vc.modules.service.checkPrice();
                            break;
                    }
                    $(".card-show" + _type).slide({
                        mainCell: ".photes-box ul",
                        effect: "fold",
                        autoPlay: true,
                        triggerTime: 0,
                        pnLoop: true,
                        defaultPlay: true
                    });


                    //针对上海版做特殊处理
                    try {
                        if ($type1Text.find("p")[4].innerHTML.indexOf("上海不提供普通类") != -1) {
                            $type1Text.find("p")[5].innerHTML = $type1Text.find("p")[5].innerHTML.replace("6", "5")
                            $($type1Text.find("p")[4]).addClass("hide")

                            $type2Text.find("p")[5].innerHTML = $type1Text.find("p")[5].innerHTML.replace("6", "5")
                            $($type2Text.find("p")[4]).addClass("hide")
                        } else {
                        }

                        // $type2Text
                    } catch (error) {

                    }


                    vc.modules.service.changePrice();
                })
            }
            //购买记录切换卡
            var _chooseTab = function () {
                //VIP购买记录切换卡
                $(".privilege-up .nav a").click(function () {
                    var index = $(".privilege-up .nav a").index(this);
                    $(".privilege-up .nav a").removeClass("active");
                    $(this).addClass("active");
                    $(this).parent().siblings(".privilege-list").addClass("hide");
                    $(this).parent().siblings(".privilege-list").eq(index).removeClass("hide");
                })
            }
            //购买
            var _jsOnlineBuy = function () {
                $('.js-onlineBuy').on('click', function () {
                    if (parseInt(priceContext.price) == 0) {
                        vc.modules.service.checkPrice();
                    }
                    if (priceContext.type == 0 || priceContext.year == 0 || priceContext.type ==
                        undefined || priceContext.year == undefined) {
                        error.html("请选择类型、周期");
                        error.removeClass('hide');
                        return false;
                    }

                    cartInfo.bussType = priceContext.productType;
                    cartInfo.productName = priceContext.title;
                    cartInfo.orderPrice = priceContext.price;

                    paymentDialog.open(cartInfo);

                })
            }
            return {
                chooseType: _chooseType,
                chooseTab: _chooseTab,
                jsOnlineBuy: _jsOnlineBuy
            }
        }()

        var init = function () {

            //右侧专家相册大图浏览
            $(".fancybox-thumbs-right").fancybox({
                prevEffect: "none",
                nextEffect: "none",
                closeBtn: false,
                helpers: {
                    title: {
                        type: "inside"
                    },
                    buttons: {}
                }
            });

            vc.modules.render.renderUsersSay();
            vc.modules.render.renderPhotos();
            vc.modules.render.renderSecret();
            //vc.modules.render.renderVipTip();

            vc.modules.bindEvent.chooseType();
            vc.modules.bindEvent.chooseTab();

            vc.modules.bindEvent.jsOnlineBuy();

            var typeId = tools.getQueryStr('type') || 1;
            $('#type' + typeId).click();

        }

        init();

    })
