create database  fly_school  default character set utf8 COLLATE utf8_general_ci;


create table tb_province(
   `id` int NOT NULL COMMENT 'ID',
   `name` varchar(30) DEFAULT NULL COMMENT '省份名',
   primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='省份';


insert into tb_province values(1,'北京市');
insert into tb_province values(2,'天津市');
insert into tb_province values(3,'上海市');
insert into tb_province values(4,'重庆市');
insert into tb_province values(5,'河北省');
insert into tb_province values(6,'山西省');
insert into tb_province values(7,'台湾省');
insert into tb_province values(8,'辽宁省');
insert into tb_province values(9,'吉林省');
insert into tb_province values(10,'黑龙江省');
insert into tb_province values(11,'江苏省');
insert into tb_province values(12,'浙江省');
insert into tb_province values(13,'安徽省');
insert into tb_province values(14,'福建省');
insert into tb_province values(15,'江西省');
insert into tb_province values(16,'山东省');
insert into tb_province values(17,'河南省');
insert into tb_province values(18,'湖北省');
insert into tb_province values(19,'湖南省');
insert into tb_province values(20,'广东省');
insert into tb_province values(21,'甘肃省');
insert into tb_province values(22,'四川省');
insert into tb_province values(23,'贵州省');
insert into tb_province values(24,'海南省');
insert into tb_province values(25,'云南省');
insert into tb_province values(26,'青海省');
insert into tb_province values(27,'陕西省');
insert into tb_province values(28,'广西壮族自治区');
insert into tb_province values(29,'西藏自治区');
insert into tb_province values(30,'宁夏回族自治区');
insert into tb_province values(31,'新疆维吾尔自治区');
insert into tb_province values(32,'内蒙古自治区');
insert into tb_province values(33,'澳门特别行政区');
insert into tb_province values(34,'香港特别行政区');

create table tb_city(
    `id` int NOT NULL auto_increment COMMENT 'ID' ,
    name varchar(50) DEFAULT NULL COMMENT '市名',
    province_id int DEFAULT NULL COMMENT '省份id',
    primary key (`id`)
)engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='市级';

-- 添加市区
-- 城市 tb_city
-- 4个直辖市
insert into tb_city(name,province_id) values('北京市',1);
insert into tb_city(name,province_id) values('天津市',2);
insert into tb_city(name,province_id) values('上海市',3);
insert into tb_city(name,province_id) values('重庆市',4);

-- 5河北省 11个地级市
insert into tb_city(name,province_id) values('石家庄市',5);
insert into tb_city(name,province_id) values('唐山市',5);
insert into tb_city(name,province_id) values('秦皇岛市',5);
insert into tb_city(name,province_id) values('邯郸市',5);
insert into tb_city(name,province_id) values('邢台市',5);
insert into tb_city(name,province_id) values('保定市',5);
insert into tb_city(name,province_id) values('张家口市',5);
insert into tb_city(name,province_id) values('承德市',5);
insert into tb_city(name,province_id) values('沧州市',5);
insert into tb_city(name,province_id) values('廊坊市',5);
insert into tb_city(name,province_id) values('衡水市',5);

-- 6山西省 11个城市
insert into tb_city(name,province_id) values('太原市',6);
insert into tb_city(name,province_id) values('大同市',6);
insert into tb_city(name,province_id) values('阳泉市',6);
insert into tb_city(name,province_id) values('长治市',6);
insert into tb_city(name,province_id) values('晋城市',6);
insert into tb_city(name,province_id) values('朔州市',6);
insert into tb_city(name,province_id) values('晋中市',6);
insert into tb_city(name,province_id) values('运城市',6);
insert into tb_city(name,province_id) values('忻州市',6);
insert into tb_city(name,province_id) values('临汾市',6);
insert into tb_city(name,province_id) values('吕梁市',6);

-- 7台湾省(台湾本岛和澎湖共设7市、16县，其中台北市和高雄市为“院辖市”，直属“行政院”，其余属台湾省；市下设区，县下设市（县辖市）、镇、乡，合称区市镇乡。)
insert into tb_city(name,province_id) values('台北市',7);
insert into tb_city(name,province_id) values('高雄市',7);
insert into tb_city(name,province_id) values('基隆市',7);
insert into tb_city(name,province_id) values('台中市',7);
insert into tb_city(name,province_id) values('台南市',7);
insert into tb_city(name,province_id) values('新竹市',7);
insert into tb_city(name,province_id) values('嘉义市',7);
insert into tb_city(name,province_id) values('台北县',7);
insert into tb_city(name,province_id) values('宜兰县',7);
insert into tb_city(name,province_id) values('桃园县',7);
insert into tb_city(name,province_id) values('新竹县',7);
insert into tb_city(name,province_id) values('苗栗县',7);
insert into tb_city(name,province_id) values('台中县',7);
insert into tb_city(name,province_id) values('彰化县',7);
insert into tb_city(name,province_id) values('南投县',7);
insert into tb_city(name,province_id) values('云林县',7);
insert into tb_city(name,province_id) values('嘉义县',7);
insert into tb_city(name,province_id) values('台南县',7);
insert into tb_city(name,province_id) values('屏东县',7);
insert into tb_city(name,province_id) values('澎湖县',7);
insert into tb_city(name,province_id) values('台东县',7);
insert into tb_city(name,province_id) values('花莲县',7);

-- 8辽宁省 14个地级市
insert into tb_city(name,province_id) values('沈阳市',8);
insert into tb_city(name,province_id) values('大连市',8);
insert into tb_city(name,province_id) values('鞍山市',8);
insert into tb_city(name,province_id) values('抚顺市',8);
insert into tb_city(name,province_id) values('本溪市',8);
insert into tb_city(name,province_id) values('丹东市',8);
insert into tb_city(name,province_id) values('锦州市',8);
insert into tb_city(name,province_id) values('营口市',8);
insert into tb_city(name,province_id) values('阜新市',8);
insert into tb_city(name,province_id) values('辽阳市',8);
insert into tb_city(name,province_id) values('盘锦市',8);
insert into tb_city(name,province_id) values('铁岭市',8);
insert into tb_city(name,province_id) values('朝阳市',8);
insert into tb_city(name,province_id) values('葫芦岛市',8);

-- 9吉林省(2006年，辖：8个地级市、1个自治州；20个市辖区、20个县级市、17个县、3个自治县。)
insert into tb_city(name,province_id) values('长春市',9);
insert into tb_city(name,province_id) values('吉林市',9);
insert into tb_city(name,province_id) values('四平市',9);
insert into tb_city(name,province_id) values('辽源市',9);
insert into tb_city(name,province_id) values('通化市',9);
insert into tb_city(name,province_id) values('白山市',9);
insert into tb_city(name,province_id) values('松原市',9);
insert into tb_city(name,province_id) values('白城市',9);
insert into tb_city(name,province_id) values('延边朝鲜族自治州',9);

-- 10黑龙江省(2006年，辖：12地级市、1地区；64市辖区、18县级市、45县、1自治县)
insert into tb_city(name,province_id) values('哈尔滨市',10);
insert into tb_city(name,province_id) values('齐齐哈尔市',10);
insert into tb_city(name,province_id) values('鹤 岗 市',10);
insert into tb_city(name,province_id) values('双鸭山市',10);
insert into tb_city(name,province_id) values('鸡 西 市',10);
insert into tb_city(name,province_id) values('大 庆 市',10);
insert into tb_city(name,province_id) values('伊 春 市',10);
insert into tb_city(name,province_id) values('牡丹江市',10);
insert into tb_city(name,province_id) values('佳木斯市',10);
insert into tb_city(name,province_id) values('七台河市',10);
insert into tb_city(name,province_id) values('黑 河 市',10);
insert into tb_city(name,province_id) values('绥 化 市',10);
insert into tb_city(name,province_id) values('大兴安岭地区',10);

-- 11江苏省(2005年辖：13个地级市；54个市辖区、27个县级市、25个县)
insert into tb_city(name,province_id) values('南京市',11);
insert into tb_city(name,province_id) values('无锡市',11);
insert into tb_city(name,province_id) values('徐州市',11);
insert into tb_city(name,province_id) values('常州市',11);
insert into tb_city(name,province_id) values('苏州市',11);
insert into tb_city(name,province_id) values('南通市',11);
insert into tb_city(name,province_id) values('连云港市',11);
insert into tb_city(name,province_id) values('淮安市',11);
insert into tb_city(name,province_id) values('盐城市',11);
insert into tb_city(name,province_id) values('扬州市',11);
insert into tb_city(name,province_id) values('镇江市',11);
insert into tb_city(name,province_id) values('泰州市',11);
insert into tb_city(name,province_id) values('宿迁市',11);

-- 12浙江省(2006年，辖：11个地级市；32个市辖区、22个县级市、35个县、1个自治县。)
insert into tb_city(name,province_id) values('杭州市',12);
insert into tb_city(name,province_id) values('宁波市',12);
insert into tb_city(name,province_id) values('温州市',12);
insert into tb_city(name,province_id) values('嘉兴市',12);
insert into tb_city(name,province_id) values('湖州市',12);
insert into tb_city(name,province_id) values('绍兴市',12);
insert into tb_city(name,province_id) values('金华市',12);
insert into tb_city(name,province_id) values('衢州市',12);
insert into tb_city(name,province_id) values('舟山市',12);
insert into tb_city(name,province_id) values('台州市',12);
insert into tb_city(name,province_id) values('丽水市',12);

-- 13安徽省(2005年辖：17个地级市；44个市辖区、5县个级市、56个县。)
insert into tb_city(name,province_id) values('合肥市',13);
insert into tb_city(name,province_id) values('芜湖市',13);
insert into tb_city(name,province_id) values('蚌埠市',13);
insert into tb_city(name,province_id) values('淮南市',13);
insert into tb_city(name,province_id) values('马鞍山市',13);
insert into tb_city(name,province_id) values('淮北市',13);
insert into tb_city(name,province_id) values('铜陵市',13);
insert into tb_city(name,province_id) values('安庆市',13);
insert into tb_city(name,province_id) values('黄山市',13);
insert into tb_city(name,province_id) values('滁州市',13);
insert into tb_city(name,province_id) values('阜阳市',13);
insert into tb_city(name,province_id) values('宿州市',13);
insert into tb_city(name,province_id) values('巢湖市',13);
insert into tb_city(name,province_id) values('六安市',13);
insert into tb_city(name,province_id) values('亳州市',13);
insert into tb_city(name,province_id) values('池州市',13);
insert into tb_city(name,province_id) values('宣城市',13);

-- 14福建省(2006年辖：9个地级市；26个市辖区、14个县级市、45个县。)
insert into tb_city(name,province_id) values('福州市',14);
insert into tb_city(name,province_id) values('厦门市',14);
insert into tb_city(name,province_id) values('莆田市',14);
insert into tb_city(name,province_id) values('三明市',14);
insert into tb_city(name,province_id) values('泉州市',14);
insert into tb_city(name,province_id) values('漳州市',14);
insert into tb_city(name,province_id) values('南平市',14);
insert into tb_city(name,province_id) values('龙岩市',14);
insert into tb_city(name,province_id) values('宁德市',14);

-- 15江西省(2006年全省辖：11个地级市；19个市辖区、10个县级市、70个县。)
insert into tb_city(name,province_id) values('南昌市',15);
insert into tb_city(name,province_id) values('景德镇市',15);
insert into tb_city(name,province_id) values('萍乡市',15);
insert into tb_city(name,province_id) values('九江市',15);
insert into tb_city(name,province_id) values('新余市',15);
insert into tb_city(name,province_id) values('鹰潭市',15);
insert into tb_city(name,province_id) values('赣州市',15);
insert into tb_city(name,province_id) values('吉安市',15);
insert into tb_city(name,province_id) values('宜春市',15);
insert into tb_city(name,province_id) values('抚州市',15);
insert into tb_city(name,province_id) values('上饶市',15);

-- 16山东省(2005年，辖：17个地级市；49个市辖区、31个县级市、60个县。)
insert into tb_city(name,province_id) values('济南市',16);
insert into tb_city(name,province_id) values('青岛市',16);
insert into tb_city(name,province_id) values('淄博市',16);
insert into tb_city(name,province_id) values('枣庄市',16);
insert into tb_city(name,province_id) values('东营市',16);
insert into tb_city(name,province_id) values('烟台市',16);
insert into tb_city(name,province_id) values('潍坊市',16);
insert into tb_city(name,province_id) values('济宁市',16);
insert into tb_city(name,province_id) values('泰安市',16);
insert into tb_city(name,province_id) values('威海市',16);
insert into tb_city(name,province_id) values('日照市',16);
insert into tb_city(name,province_id) values('莱芜市',16);
insert into tb_city(name,province_id) values('临沂市',16);
insert into tb_city(name,province_id) values('德州市',16);
insert into tb_city(name,province_id) values('聊城市',16);
insert into tb_city(name,province_id) values('滨州市',16);
insert into tb_city(name,province_id) values('菏泽市',16);

-- 17河南省 17个地级市
insert into tb_city(name,province_id) values('郑州市',17);
insert into tb_city(name,province_id) values('开封市',17);
insert into tb_city(name,province_id) values('洛阳市',17);
insert into tb_city(name,province_id) values('平顶山市',17);
insert into tb_city(name,province_id) values('安阳市',17);
insert into tb_city(name,province_id) values('鹤壁市',17);
insert into tb_city(name,province_id) values('新乡市',17);
insert into tb_city(name,province_id) values('焦作市',17);
insert into tb_city(name,province_id) values('濮阳市',17);
insert into tb_city(name,province_id) values('许昌市',17);
insert into tb_city(name,province_id) values('漯河市',17);
insert into tb_city(name,province_id) values('三门峡市',17);
insert into tb_city(name,province_id) values('南阳市',17);
insert into tb_city(name,province_id) values('商丘市',17);
insert into tb_city(name,province_id) values('信阳市',17);
insert into tb_city(name,province_id) values('周口市',17);
insert into tb_city(name,province_id) values('驻马店市',17);
insert into tb_city(name,province_id) values('济源市',17);

-- 18湖北省（截至2005年12月31日，全省辖13个地级单位（12个地级市、1个自治州）；102县级单位（38个市辖区、24个县级市、37个县、2个自治县、1个林区），共有1220个乡级单位（277个街道、733个镇、210个乡）。）
insert into tb_city(name,province_id) values('武汉市',18);
insert into tb_city(name,province_id) values('黄石市',18);
insert into tb_city(name,province_id) values('十堰市',18);
insert into tb_city(name,province_id) values('荆州市',18);
insert into tb_city(name,province_id) values('宜昌市',18);
insert into tb_city(name,province_id) values('襄樊市',18);
insert into tb_city(name,province_id) values('鄂州市',18);
insert into tb_city(name,province_id) values('荆门市',18);
insert into tb_city(name,province_id) values('孝感市',18);
insert into tb_city(name,province_id) values('黄冈市',18);
insert into tb_city(name,province_id) values('咸宁市',18);
insert into tb_city(name,province_id) values('随州市',18);
insert into tb_city(name,province_id) values('仙桃市',18);
insert into tb_city(name,province_id) values('天门市',18);
insert into tb_city(name,province_id) values('潜江市',18);
insert into tb_city(name,province_id) values('神农架林区',18);
insert into tb_city(name,province_id) values('恩施土家族苗族自治州',18);

-- 19湖南省（2005年辖：13个地级市、1个自治州；34个市辖区、16个县级市、65个县、7个自治县。）
insert into tb_city(name,province_id) values('长沙市',19);
insert into tb_city(name,province_id) values('株洲市',19);
insert into tb_city(name,province_id) values('湘潭市',19);
insert into tb_city(name,province_id) values('衡阳市',19);
insert into tb_city(name,province_id) values('邵阳市',19);
insert into tb_city(name,province_id) values('岳阳市',19);
insert into tb_city(name,province_id) values('常德市',19);
insert into tb_city(name,province_id) values('张家界市',19);
insert into tb_city(name,province_id) values('益阳市',19);
insert into tb_city(name,province_id) values('郴州市',19);
insert into tb_city(name,province_id) values('永州市',19);
insert into tb_city(name,province_id) values('怀化市',19);
insert into tb_city(name,province_id) values('娄底市',19);
insert into tb_city(name,province_id) values('湘西土家族苗族自治州',19);

-- 20广东省（截至2005年12月31日，广东省辖：21个地级市，54个市辖区、23个县级市、41个县、3个自治县，429个街道办事处、1145个镇、4个乡、7个民族乡。）
insert into tb_city(name,province_id) values('广州市',20);
insert into tb_city(name,province_id) values('深圳市',20);
insert into tb_city(name,province_id) values('珠海市',20);
insert into tb_city(name,province_id) values('汕头市',20);
insert into tb_city(name,province_id) values('韶关市',20);
insert into tb_city(name,province_id) values('佛山市',20);
insert into tb_city(name,province_id) values('江门市',20);
insert into tb_city(name,province_id) values('湛江市',20);
insert into tb_city(name,province_id) values('茂名市',20);
insert into tb_city(name,province_id) values('肇庆市',20);
insert into tb_city(name,province_id) values('惠州市',20);
insert into tb_city(name,province_id) values('梅州市',20);
insert into tb_city(name,province_id) values('汕尾市',20);
insert into tb_city(name,province_id) values('河源市',20);
insert into tb_city(name,province_id) values('阳江市',20);
insert into tb_city(name,province_id) values('清远市',20);
insert into tb_city(name,province_id) values('东莞市',20);
insert into tb_city(name,province_id) values('中山市',20);
insert into tb_city(name,province_id) values('潮州市',20);
insert into tb_city(name,province_id) values('揭阳市',20);
insert into tb_city(name,province_id) values('云浮市',20);

-- 21甘肃省 12个地级市、2个自治州
insert into tb_city(name,province_id) values('兰州市',21);
insert into tb_city(name,province_id) values('金昌市',21);
insert into tb_city(name,province_id) values('白银市',21);
insert into tb_city(name,province_id) values('天水市',21);
insert into tb_city(name,province_id) values('嘉峪关市',21);
insert into tb_city(name,province_id) values('武威市',21);
insert into tb_city(name,province_id) values('张掖市',21);
insert into tb_city(name,province_id) values('平凉市',21);
insert into tb_city(name,province_id) values('酒泉市',21);
insert into tb_city(name,province_id) values('庆阳市',21);
insert into tb_city(name,province_id) values('定西市',21);
insert into tb_city(name,province_id) values('陇南市',21);
insert into tb_city(name,province_id) values('临夏回族自治州',21);
insert into tb_city(name,province_id) values('甘南藏族自治州',21);

-- 22四川省18个地级市、3个自治州;
insert into tb_city(name,province_id) values('成都市',22);
insert into tb_city(name,province_id) values('自贡市',22);
insert into tb_city(name,province_id) values('攀枝花市',22);
insert into tb_city(name,province_id) values('泸州市',22);
insert into tb_city(name,province_id) values('德阳市',22);
insert into tb_city(name,province_id) values('绵阳市',22);
insert into tb_city(name,province_id) values('广元市',22);
insert into tb_city(name,province_id) values('遂宁市',22);
insert into tb_city(name,province_id) values('内江市',22);
insert into tb_city(name,province_id) values('乐山市',22);
insert into tb_city(name,province_id) values('南充市',22);
insert into tb_city(name,province_id) values('眉山市',22);
insert into tb_city(name,province_id) values('宜宾市',22);
insert into tb_city(name,province_id) values('广安市',22);
insert into tb_city(name,province_id) values('达州市',22);
insert into tb_city(name,province_id) values('雅安市',22);
insert into tb_city(name,province_id) values('巴中市',22);
insert into tb_city(name,province_id) values('资阳市',22);
insert into tb_city(name,province_id) values('阿坝藏族羌族自治州',22);
insert into tb_city(name,province_id) values('甘孜藏族自治州',22);
insert into tb_city(name,province_id) values('凉山彝族自治州',22);

-- 23贵州省(2006年辖：4个地级市、2个地区、3个自治州；10个市辖区、9个县级市、56个县、11个自治县、2个特区。)
insert into tb_city(name,province_id) values('贵阳市',23);
insert into tb_city(name,province_id) values('六盘水市',23);
insert into tb_city(name,province_id) values('遵义市',23);
insert into tb_city(name,province_id) values('安顺市',23);
insert into tb_city(name,province_id) values('铜仁地区',23);
insert into tb_city(name,province_id) values('毕节地区',23);
insert into tb_city(name,province_id) values('黔西南布依族苗族自治州',23);
insert into tb_city(name,province_id) values('黔东南苗族侗族自治州',23);
insert into tb_city(name,province_id) values('黔南布依族苗族自治州',23);

-- 24海南省全省有2个地级市，6个县级市，4个县，6个民族自治县，4个市辖区，1个办事处（西南中沙群岛办事处 ，县级）。)
insert into tb_city(name,province_id) values('海口市',24);
insert into tb_city(name,province_id) values('三亚市',24);
insert into tb_city(name,province_id) values('五指山市',24);
insert into tb_city(name,province_id) values('琼海市',24);
insert into tb_city(name,province_id) values('儋州市',24);
insert into tb_city(name,province_id) values('文昌市',24);
insert into tb_city(name,province_id) values('万宁市',24);
insert into tb_city(name,province_id) values('东方市',24);
insert into tb_city(name,province_id) values('澄迈县',24);
insert into tb_city(name,province_id) values('定安县',24);
insert into tb_city(name,province_id) values('屯昌县',24);
insert into tb_city(name,province_id) values('临高县',24);
insert into tb_city(name,province_id) values('白沙黎族自治县',24);
insert into tb_city(name,province_id) values('昌江黎族自治县',24);
insert into tb_city(name,province_id) values('乐东黎族自治县',24);
insert into tb_city(name,province_id) values('陵水黎族自治县',24);
insert into tb_city(name,province_id) values('保亭黎族苗族自治县',24);
insert into tb_city(name,province_id) values('琼中黎族苗族自治县',24);

-- 25云南省(2006年辖：8个地级市、8个自治州；12个市辖区、9个县级市、79个县、29个自治县。)
insert into tb_city(name,province_id) values('昆明市',25);
insert into tb_city(name,province_id) values('曲靖市',25);
insert into tb_city(name,province_id) values('玉溪市',25);
insert into tb_city(name,province_id) values('保山市',25);
insert into tb_city(name,province_id) values('昭通市',25);
insert into tb_city(name,province_id) values('丽江市',25);
insert into tb_city(name,province_id) values('思茅市',25);
insert into tb_city(name,province_id) values('临沧市',25);
insert into tb_city(name,province_id) values('文山壮族苗族自治州',25);
insert into tb_city(name,province_id) values('红河哈尼族彝族自治州',25);
insert into tb_city(name,province_id) values('西双版纳傣族自治州',25);
insert into tb_city(name,province_id) values('楚雄彝族自治州',25);
insert into tb_city(name,province_id) values('大理白族自治州',25);
insert into tb_city(name,province_id) values('德宏傣族景颇族自治州',25);
insert into tb_city(name,province_id) values('怒江傈傈族自治州',25);
insert into tb_city(name,province_id) values('迪庆藏族自治州',25);

-- 26青海省(2006年辖：1个地级市、1个地区、6个自治州；4个市辖区、2个县级市、30个县、7个自治县。)
insert into tb_city(name,province_id) values('西宁市',26);
insert into tb_city(name,province_id) values('海东地区',26);
insert into tb_city(name,province_id) values('海北藏族自治州',26);
insert into tb_city(name,province_id) values('黄南藏族自治州',26);
insert into tb_city(name,province_id) values('海南藏族自治州',26);
insert into tb_city(name,province_id) values('果洛藏族自治州',26);
insert into tb_city(name,province_id) values('玉树藏族自治州',26);
insert into tb_city(name,province_id) values('海西蒙古族藏族自治州',26);

-- 27陕西省(2006年辖：10个地级市；24个市辖区、3个县级市、80个县。)
insert into tb_city(name,province_id) values('西安市',27);
insert into tb_city(name,province_id) values('铜川市',27);
insert into tb_city(name,province_id) values('宝鸡市',27);
insert into tb_city(name,province_id) values('咸阳市',27);
insert into tb_city(name,province_id) values('渭南市',27);
insert into tb_city(name,province_id) values('延安市',27);
insert into tb_city(name,province_id) values('汉中市',27);
insert into tb_city(name,province_id) values('榆林市',27);
insert into tb_city(name,province_id) values('安康市',27);
insert into tb_city(name,province_id) values('商洛市',27);

-- 28广西壮族自治区(2005年辖：14个地级市；34个市辖区、7个县级市、56个县、12个自治县。)
insert into tb_city(name,province_id) values('南宁市',28);
insert into tb_city(name,province_id) values('柳州市',28);
insert into tb_city(name,province_id) values('桂林市',28);
insert into tb_city(name,province_id) values('梧州市',28);
insert into tb_city(name,province_id) values('北海市',28);
insert into tb_city(name,province_id) values('防城港市',28);
insert into tb_city(name,province_id) values('钦州市',28);
insert into tb_city(name,province_id) values('贵港市',28);
insert into tb_city(name,province_id) values('玉林市',28);
insert into tb_city(name,province_id) values('百色市',28);
insert into tb_city(name,province_id) values('贺州市',28);
insert into tb_city(name,province_id) values('河池市',28);
insert into tb_city(name,province_id) values('来宾市',28);
insert into tb_city(name,province_id) values('崇左市',28);

-- 29西藏自治区(2005年辖：1个地级市、6个地区；1个市辖区、1个县级市、71个县。)
insert into tb_city(name,province_id) values('拉萨市',29);
insert into tb_city(name,province_id) values('那曲地区',29);
insert into tb_city(name,province_id) values('昌都地区',29);
insert into tb_city(name,province_id) values('山南地区',29);
insert into tb_city(name,province_id) values('日喀则地区',29);
insert into tb_city(name,province_id) values('阿里地区',29);
insert into tb_city(name,province_id) values('林芝地区',29);

-- 30宁夏回族自治区
insert into tb_city(name,province_id) values('银川市',30);
insert into tb_city(name,province_id) values('石嘴山市',30);
insert into tb_city(name,province_id) values('吴忠市',30);
insert into tb_city(name,province_id) values('固原市',30);
insert into tb_city(name,province_id) values('中卫市',30);

-- 31新疆维吾尔自治区(2005年辖：2个地级市、7个地区、5个自治州；11个市辖区、20个县级市、62个县、6个自治县)
insert into tb_city(name,province_id) values('乌鲁木齐市',31);
insert into tb_city(name,province_id) values('克拉玛依市',31);
insert into tb_city(name,province_id) values('石河子市　',31);
insert into tb_city(name,province_id) values('阿拉尔市',31);
insert into tb_city(name,province_id) values('图木舒克市',31);
insert into tb_city(name,province_id) values('五家渠市',31);
insert into tb_city(name,province_id) values('吐鲁番市',31);
insert into tb_city(name,province_id) values('阿克苏市',31);
insert into tb_city(name,province_id) values('喀什市',31);
insert into tb_city(name,province_id) values('哈密市',31);
insert into tb_city(name,province_id) values('和田市',31);
insert into tb_city(name,province_id) values('阿图什市',31);
insert into tb_city(name,province_id) values('库尔勒市',31);
insert into tb_city(name,province_id) values('昌吉市　',31);
insert into tb_city(name,province_id) values('阜康市',31);
insert into tb_city(name,province_id) values('米泉市',31);
insert into tb_city(name,province_id) values('博乐市',31);
insert into tb_city(name,province_id) values('伊宁市',31);
insert into tb_city(name,province_id) values('奎屯市',31);
insert into tb_city(name,province_id) values('塔城市',31);
insert into tb_city(name,province_id) values('乌苏市',31);
insert into tb_city(name,province_id) values('阿勒泰市',31);

-- 32内蒙古自治区(2006年，辖：9个地级市、3个盟；21个市辖区、11个县级市、17个县、49个旗、3个自治旗。)
insert into tb_city(name,province_id) values('呼和浩特市',32);
insert into tb_city(name,province_id) values('包头市',32);
insert into tb_city(name,province_id) values('乌海市',32);
insert into tb_city(name,province_id) values('赤峰市',32);
insert into tb_city(name,province_id) values('通辽市',32);
insert into tb_city(name,province_id) values('鄂尔多斯市',32);
insert into tb_city(name,province_id) values('呼伦贝尔市',32);
insert into tb_city(name,province_id) values('巴彦淖尔市',32);
insert into tb_city(name,province_id) values('乌兰察布市',32);
insert into tb_city(name,province_id) values('锡林郭勒盟',32);
insert into tb_city(name,province_id) values('兴安盟',32);
insert into tb_city(name,province_id) values('阿拉善盟',32);

-- 33澳门特别行政区
insert into tb_city(name,province_id) values('澳门特别行政区',33);

-- 34香港特别行政区
insert into tb_city(name,province_id) values('香港特别行政区',34);

create table tb_department_type(
   `id` int NOT NULL auto_increment COMMENT 'ID',
   `name` varchar(30) DEFAULT NULL COMMENT '主管部门类别',
   primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='教育主管部门类别表';

insert into tb_department_type(name) values('教育部');
insert into tb_department_type(name) values('其他部委');
insert into tb_department_type(name) values('地方');
insert into tb_department_type(name) values('军校');


create table tb_department(
   `id` int NOT NULL auto_increment COMMENT 'ID',
   `name` varchar(30) DEFAULT NULL COMMENT '部门名',
   department_type_id int DEFAULT NULL COMMENT '主管部门类别',
   primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='教育主管部门表';

insert into tb_department(name,tb_department_type_id) values('教育部',1);
insert into tb_department(name,tb_department_type_id) values('北京市教育委员会',3);
insert into tb_department(name,tb_department_type_id) values('工业和信息化部',2);
insert into tb_department(name,tb_department_type_id) values('国家卫生健康委员会',2);
insert into tb_department(name,tb_department_type_id) values('其他主管部门',2);
insert into tb_department(name,tb_department_type_id) values('国家体育总局',2);
insert into tb_department(name,tb_department_type_id) values('外交部',2);
insert into tb_department(name,tb_department_type_id) values('公安部',2);
insert into tb_department(name,tb_department_type_id) values('应急管理部',2);
insert into tb_department(name,tb_department_type_id) values('中华全国妇女联合会',2);
insert into tb_department(name,tb_department_type_id) values('国家民族事务委员会',2);
insert into tb_department(name,tb_department_type_id) values('中华全国总工会',2);
insert into tb_department(name,tb_department_type_id) values('中国科学院',2);
insert into tb_department(name,tb_department_type_id) values('中国社会科学院',2);
insert into tb_department(name,tb_department_type_id) values('中央军委训练管理部',4);
insert into tb_department(name,tb_department_type_id) values('天津市教育委员会',3);
insert into tb_department(name,tb_department_type_id) values('中国民用航空局',2);
insert into tb_department(name,tb_department_type_id) values('湖南省教育厅',3);
insert into tb_department(name,tb_department_type_id) values('中央军委装备发展部',2);



create table tb_type(
    `id` int NOT NULL auto_increment COMMENT 'ID',
    `name` varchar(30) DEFAULT NULL COMMENT '院校类型名',
    primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='院校类型';


insert into tb_type(name) values('师范');
insert into tb_type(name) values('综合');
insert into tb_type(name) values('工科');
insert into tb_type(name) values('农业');
insert into tb_type(name) values('林业');
insert into tb_type(name) values('语言');
insert into tb_type(name) values('财经');
insert into tb_type(name) values('政法');
insert into tb_type(name) values('体育');
insert into tb_type(name) values('艺术');
insert into tb_type(name) values('民族');


create table tb_levels(
  `id` int NOT NULL auto_increment COMMENT 'ID',
  `name` varchar(30) DEFAULT NULL COMMENT '学历层次名',
  primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='学历层次';

insert into tb_levels(name) values('本科');
insert into tb_levels(name) values('高职(专科)');
insert into tb_levels(name) values('本科/高职(专科)');


create table tb_school(
   `id` int NOT NULL COMMENT 'ID',
   `name` varchar(30) DEFAULT NULL COMMENT '院校名称',
   `address_id` varchar(20) DEFAULT NULL COMMENT '院校所在地',
   `department_id` varchar(20) DEFAULT '地方教育部' COMMENT '教育行政主管部门',
   `type_id` varchar(20) DEFAULT 2 COMMENT '院校类型',
   `levels_id` varchar(20) DEFAULT 3 COMMENT '学历层次',
   `top_university` boolean DEFAULT false COMMENT '一流大学建设高校',
   `top_discipline` boolean DEFAULT false COMMENT '一流学科建设高校',
   `graduate_school` boolean DEFAULT false COMMENT '研究生院',
   `satisfaction` decimal(2,1) DEFAULT 4.0 COMMENT '满意度',
   primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='大学学校';


alter table tb_school
    add constraint tb_school_tb_province_id_fk
        foreign key (tb_province_id) references tb_province (id);

alter table tb_school
    add constraint tb_school_tb_type_id_fk
        foreign key (tb_type_id) references tb_type (id);

alter table tb_school
    add constraint tb_school_tb_department_id_fk
        foreign key (tb_department_id) references tb_department (id);

alter table tb_school
    add constraint tb_school_tb_levels_id_fk
        foreign key (tb_levels_id) references tb_levels (id);