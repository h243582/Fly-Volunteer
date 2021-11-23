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

alter table tb_city
    add constraint province_id_fk
        foreign key (province_id) references tb_province (id);

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


create table tb_school
(
   `id` int NOT NULL auto_increment COMMENT 'ID',
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
        foreign key (tb_province_id) references tb_province (id),
    add constraint tb_school_tb_type_id_fk
        foreign key (tb_type_id) references tb_type (id),
    add constraint tb_school_tb_department_id_fk
        foreign key (tb_department_id) references tb_department (id),
    add constraint tb_school_tb_levels_id_fk
        foreign key (tb_levels_id) references tb_levels (id);

create table tb_recruitment_brochure
(
    `id` int NOT NULL auto_increment COMMENT 'ID',
    `tb_school_id` int NOT NULL COMMENT '学校id',
    `name` varchar(30) DEFAULT '吉首大学2018年全日制本专科生招生章程' COMMENT '简章名',
    `release_time` datetime DEFAULT '2021-09-09 14:47:41' COMMENT '发布时间',
    `content` varchar(4096) DEFAULT '第一章 总则 第一条 根据《中华人民共和国教育法》《中华人民共和国高等教育法》的有关规定，按照教育部“依法治招”、推进高校招生“阳光工程”的要求，贯彻落实公平竞争、公正选拔的原则，进一步规范学校全日制普通本、专科招生工作（以下简称招生工作），确保招生工作顺利进行，特制定本章程。 第二条 学校中文名称为吉首大学（国标代码：10531），学校英文名称：Jishou University，注册地址：湖南省吉首市人民南路120号（邮政编码：416000）。 第三条 吉首大学是一所公办、全日制综合性大学，主管部门是湖南省教育厅。学校是国家民委与湖南省人民政府共建高校、国家“中西部高校基础能力建设工程”高校、“服务国家特殊需求博士人才培养项目”高校，学校具有博士、硕士和学士学位授予权，具有推荐优秀本科生免试攻读硕士学位研究生资格。 第四条 学校以普通本科教育为主，学生完成学业，达到毕业要求者，颁发吉首大学学历证书，符合学位授予条件者，授予吉首大学学位证书。学校兼有少量普通专科教育。 第二章 组织机构 第五条 学校成立由学校领导和相关部门负责人组成的学校招生工作领导小组，负责制定学校招生章程及有关规定、实施细则，领导、监督招生工作的具体实施，处理招生工作的重大问题。 第六条 学校招生工作领导小组设立办公室，办公室设在招生就业处，主要职责是执行学校制定的招生工作有关规定和实施细则，编制招生计划，组织招生宣传、招生考试和录取工作，开展招生工作的改革和科学研究。 第七条 学校成立由学校纪委书记和相关职能部门负责人组成的招生工作监察小组，负责学校招生工作的全程监督，确保学校招生政策的贯彻落实以及招生录取的公开、公平、公正，严格实施责任制和责任追究制，维护广大考生和学校的合法权益。 第三章 招生计划 第八条 根据教育部有关文件精神和学校实际办学条件，结合各省生源情况和各专业就业情况合理编制来源计划，具体分省分专业招生计划以各省（市、区）招生委员会办公室公布的招生计划为准。 第九条 在国家核定的年度招生规模内，学校预留少量计划，用于调节各省考生生源不平衡和专业生源不平衡。 第十条 学校实行专业招生计划动态平衡机制，对于社会需求量大且生源好的专业，可适当增加招生计划；对基础学科或就业形势好但报考人数少的专业，可采取一定措施予以扶持；对个别社会需求量小、学生报考人数少的专业、学校可调整其招生计划，对其采取减招、隔年招生或停招的办法。 第四章 录取规则 第十一条 学校严格遵循公平、公正、公开的原则，依据考生高考成绩，从德智体美各方面综合衡量，择优录取新生。 第十二条 学校根据各省（自治区、直辖市）生源情况确定提档比例，提档比例一般为：湖南省不超过105%，其他省份根据生源情况确定提档比例，但不超过110%。 第十三条 录取时，以考生所在省级招办投档分数为准，按照专业清原则，从高分到低分进行录取，不设分数级差。即优先满足考生的第一专业志愿，若第一志愿不能录取，将依次按其第二、第三……及服从调剂等专业志愿顺序择优录取。普通文史、理工考生分数相同时，按各省投档顺序录取；若某省无投档排序分，则依次按语、数、外单科成绩从高分到低分排序。当考生填报的专业志愿均未被录取时，对服从专业调剂者，在招生录取时加强与考生的联系和沟通，然后按照从高分到低分的顺序，调剂到未录满的专业，对不服从专业调剂者，予以退档处理。 第十四条 内蒙古自治区考生实行招生计划1：1范围内按专业志愿排队录取；江苏省考生按“先分数后等级”的原则安排专业，选测科目最低等级要求为BC，必测科目最低等级要求为4C1合格；实行高等学校考试招生综合改革的省（市、区），按该省（市、区）投档规则，择优录取。 第十五条 艺术类专业录取规则：湖南省的录取原则为文化和专业均达到本省相应批次的最低控制分数线，按照考生投档成绩从高到低排序，学校择优录取。湖南省外组织校考的艺术类专业，必须通过我校组织的专业测试并达到合格（部分省招办规定统考的美术设计类和音乐舞蹈类专业测试合格），依照文化成绩达到生源省招办划定的相应录取控制分数线后，按专业测试成绩从高分到低分排序录取；专业成绩相同时，按文化投档成绩排序，择优录取。湖南省外未组织校考的艺术类专业，执行该省的招生录取政策，学校择优录取。 第十六条 体育类专业录取规则：湖南省的录取原则为文化和专业均达到本省相应批次的最低控制分数线，按照考生投档成绩从高到低排序，学校择优录取。湖南省以外按各省招办投档的综合成绩择优录取；如果某省投档未计算综合分，对于文化、专业成绩均上线的进档考生，则按专业成绩从高到低的原则择优录取。 第十七条 武术与民族传统体育单独招生录取规则：考生须参加国家体育总局组织的体育专项技术测试和省级招生考试机构组织的文化测试，学校按照有关文件精神，划定录取分数线，确定录取考生名单，报教育部、国家体育总局和有关省（自治区、直辖市）的普通高校招生办公室备案。 第十八条 农村订单定向医学生招生录取规则：农村订单定向医学生招生录取设在提前批，单独划定录取控制线（不低于招生批次的录取控制分数线）。学校按照从高分到低分的顺序确定预录名单，并将预录名单及生源情况报省卫生计生委、省中医药管理局。由县（市、区）卫生计生委（局）通知预录考生在规定时间内签订定向就业协议，学校根据签订协议情况确定录取名单。 第十九条 新疆班高中毕业生计划、新疆协作计划预科班、支援吐鲁番地区定向计划、职高对口计划、少数民族预科班、港澳台联招生等招生录取工作，按照上级有关文件要求执行。 第二十条 学校严格执行各省（自治区、直辖市）的加分或降分政策。 第二十一条 各招生专业男女性别不限。舞蹈类专业建议男生身高不低于1.7米，女生身高不低于1.58米。 第二十二条 学校外语教学语种为英语。 第二十三条 体检按照教育部、卫生部、中国残疾人联合会联合颁发的《普通高等学校招生体检工作指导意见》执行。 第五章 新生入学及其它 第二十四条 学校严格按照湖南省物价局、财政厅和教育厅核定的各专业收费标准收费。 第二十五条 录取新生必须持录取通知书和身份证按时入学报到。对未经学校批准，在学校规定的报到截止日期15天内未到校报到者，视为自动放弃入学资格。 第二十六条 新生入校后，学校针对各类录取学生开展入学资格复查工作。凡不符合录取要求或弄虚作假的，取消入学资格。 第二十七条 学校建立奖、贷、助、勤、补等多渠道较完善的资助体系。对于家庭经济困难的学生，可申请生源地助学贷款，同时，学校根据有关政策、规定和程序，采取勤工助学、特困补助等措施予以资助。学校倡导学生德、智、体、美全面发展，鼓励学生通过获得各级各类奖、助学金完成学业。 第六章 附则 第二十八条 学校联系方式： 联系电话：0743-8564141 0743-8563838（传真）； 监督电话：0743-8564814； 招生网址：http://jsuzs.jysd.com/； 学校网址：http://www.jsu.edu.cn。 第二十九条 本章程适用于学校普通本、专科招生工作，本章程自公布之日起施行。学校以往有关招生工作的规定与本章程不一致的，以本章程为准。 第三十条 本章程由吉首大学招生就业处负责解释。' COMMENT '简章内容',
    primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='招生简章表';

alter table tb_recruitment_brochure
    add constraint tb_recruitment_brochure_tb_school_fk
        foreign key (tb_school_id) references tb_school (id);


create table tb_school_information
(
    `id` int NOT NULL auto_increment COMMENT 'ID',
    `tb_school_id` varchar(20) DEFAULT NULL COMMENT '学校id',
    `update_time` datetime DEFAULT '2021-09-09 14:47:41' COMMENT '学校信息更新时间',
    `leaders` varchar(2048) DEFAULT '周其凤 北京大学党委常委、校长

    周其凤，男，汉族，1947年10月出生，湖南浏阳人，中共党员，理学博士，教授，博士生导师，中国科学院院士。
    北京大学党委常委、校长。全面主持学校行政工作，主管发展规划部，兼管基金会工作。
    1965年入北京大学化学系学习，1970年留校任教。1978年考取北京大学化学系高分子化学专业研究生，1980年1月由国家公派到美国麻省大学高分子科学与工程系学习，1981年9月获硕士学位，1983年2月获博士学位，同年5月回北京大学任教。1986年被北京大学聘为副教授，1990年被北京大学聘为教授。1999年被增选为中国科学院院士。曾任北京大学化学学院高分子科学与工程系主任、高分子科学研究所所长、北京大学研究生院常务副院长、北京大学副教务长等职。2001年6月至2004年7月任国务院学位委员会办公室主任、教育部研究生工作办公室（学位管理与研究生教育司）主任、司长，2003年6月起任国务院学位委员会委员，2003年6月至2004年7月任国务院学位委员会副秘书长。从2001年6月起至2004年7月先后兼任教育部学位与研究生教育发展中心主任、“211工程”部际协调小组办公室主任、“教育部财政部985工程”办公室主任等职。2004年7月至2008年11月任吉林大学校长。2008年11月至今任北京大学党委常委、校长。
    国务院学位委员会委员，中国科学院化学部常委、副主任，教育部化学和化工专业教学指导委员会主任委员。


闵维方 北京大学党委书记、校务委员会主任

    闵维方，男，汉族，1950年10月出生，黑龙江齐齐哈尔人，中共党员，1968年8月参加工作，1987年6月美国斯坦福大学教育学院毕业，研究生学历，教授，博士生导师。
    北京大学党委书记、校务委员会主任，兼任教育学院院长、教育经济研究所所长。全面主持党委工作，主管统战工作，主管党办校办，兼管基金会工作。
1968年至1973年北京门头沟煤矿井下采掘工、矿团委干部。1973年至1978年北京团市委干部。1978年至1982年北京师范大学教育系学习。1982年至1983年教育部出国预备研究生班学习，并任党支部书记。1983年至1987年美国斯坦福大学学习，先后获高等教育学硕士学位、组织社会学第二硕士学位和哲学博士学位（教育经济与管理）。1987年至1988年在美国德克萨斯大学从事高等教育管理与教育财政博士后研究，兼任校长助理。1988年至今北京大学高等教育科学研究所副教授、教授（1991年）、博士生导师（1994年），副所长（1990年至1993年）、所长。1991年至1992年借调世界银行总部教育投资高级专家。1994年至2000年北京大学党委常委、校长助理（1994年至1995年）、副校长（1995年至1996年）、常务副校长。2000年至2002年北京大学党委常务副书记、常务副校长、教育学院院长。2002年至2004年北京大学党委书记、校务委员会主任、常务副校长、教育学院院长。2004年12月至今北京大学党委书记、校务委员会主任、教育学院院长。
    中共第十六届、十七届中央候补委员。' COMMENT '学校领导',
    `introduce` varchar(2048) DEFAULT '吉首大学创办于1958年9月，是湖南省属综合性大学。学校分吉首校区和张家界校区，校本部在湖南省吉首市。

学科专业：学校建有35个一级学科，80个本科专业，覆盖12大学科门类。有省重点学科5个；“服务国家特殊需求博士人才培养项目”1个，博士后科研流动站2个（民族学、工商管理）；“博士后科研流动站协作研发中心”1个；一级学科硕士点15个，专业硕士点13个;有国家级特色专业3个，国家级本科专业综合改革试点专业1个，“卓越医生教育培养计划”专业1个，“卓越农林人才教育培养计划”专业1个，省级重点专业、特色专业和综合改革试点专业12个。

平台建设：有院士工作站1个；有国家地方联合工程实验室1个，国家级实验教学示范中心1个，国家级工程实践教育中心1个；建有湖南省高校2011协同创新中心3个；建有部、省级研究基地、示范中心、重点实验室、工程实验室、虚拟仿真中心和大学生创新创业教育基地等70余个。学校还是教育部“教育装备国际交流实验园”。

师资力量：在职的教职员工近1500人，专任教师1000余人，有高级职称700余人，博士生导师27人，硕士生导师407余人，硕士以上学历占教师总数的70%。有“国务院政府特殊津贴”专家16人，“新世纪百千万人才工程”国家级人选1人，教育部“新世纪优秀人才支持计划”7人；有全国先进教育工作者1人，五一劳动奖章2人，全国优秀教师8人，曾宪梓教育基金奖获得者5人，宝钢教育基金奖获得者2人；有国家级教学团队2个，省级优秀教学团队3个，省级科技创新团队4个。

 人才培养：现有各类在籍学生3万余人，其中在校本专科生近2万人，博士生、硕士生、留学生千余人。学校设有国家奖学金、优秀学生奖学金和各类专项奖助学金。近年来，学校获国家教学成果奖2项，省教学成果奖26项，学生在中国“互联网+”大学生创新创业大赛、全国“挑战杯”大学生课外学术科技作品竞赛等各类比赛、竞赛中屡获特等奖、一等奖，累计获国家级奖项426项，省部级奖项1589项。

对外交流：拥有招收外国留学生及港澳台学生资格，先后与美国、英国、韩国、乌克兰、瑞典、印度、日本及我国香港、澳门、台湾地区20余所高校开展了合作交流。出国访学、参加学术会议、举办国际会议等国际学术交流活动频繁，学生可选择前往美国、澳大利亚、英国以及我国港澳台地区进行交换交流学习，学校少数民族艺术团曾应邀赴美国、香港等地演出，影响广泛。

科研服务：近五年来，先后承担省部级以上科研项目900余项,获国家级、省部级科研成果奖共29项，获国家自科基金项目123项，社科基金项目85项；国家社科基金重大招标项目2项。

学校坚持服务地方的办学宗旨，先后与武陵山片区政府部门、企事业单位开展了20多个实质性的产学研合作项目，承担的国家、省级科研项目中70%以上为研究地方特色资源、地方政府急需解决的实际问题。学校连续发布了连片特困区蓝皮书《中国连片特困区发展报告》。' COMMENT '学校简介',
    `environment` varchar(2048) DEFAULT '吉首大学创办于1958年9月，是位于湘鄂渝黔边区大湘西区域内一所具有地方性、民族性特色的省属综合性大学，是地处国家西部开发“10+3”范围民族地区的高校，是湖南省唯一进入国家西部大开发范围的高校，是国家《武陵山片区区域发展与扶贫攻坚规划》确定的重点建设高校，是国家民委与湖南省人民政府共建高校，是国家“中西部高校基础能力建设工程”高校，是国家“服务国家特殊需求博士人才培养项目”高校，是湖南省本科一批录取高校，具有博士、硕士学位授予权。学校办在湘西自治州和张家界市两地，本部设在湘西自治州首府——吉首市。学校所在区域内拥有世界自然遗产——张家界武陵源自然风景区、中国历史文化名城——凤凰。纵横湘西的5条高速公路、3条铁路和张家界荷花机场、铜仁·凤凰机场，使得湘西与周边各省市的交流更为顺畅便利。' COMMENT '周边环境',
    `postal_address` varchar(100) DEFAULT ' 416000 湖南省吉首市人民南路120号 吉首大学招生办' COMMENT '通讯地址',
    `telephone` varchar(100) DEFAULT '咨询热线：0743-8564141;　　　0743-8563838（传真） ' COMMENT '联系电话',
    `key_laboratory` varchar(520) DEFAULT '暂无！' COMMENT '重点实验室',
    `key_disciplines` varchar(520) DEFAULT '学科专业：学校建有50个一级学科，78个本科专业，覆盖13大学科门类。建有省重点学科5个（其中优势特色重点学科1个）；建有“服务国家特殊需求博士人才培养项目”1个，博士后科研流动站2个（民族学、工商管理）；建有“博士后科研流动站协作研发中心”1个；建有一级学科硕士点14个（涵盖70多个二级学科），二级学科硕士点3个，专业硕士点3个;建有国家级特色专业3个，本科专业综合改革试点专业1个，“卓越医生教育培养计划”专业1个，“卓越农林人才教育培养计划”专业1个，省级特色专业与重点专业11个。' COMMENT '重点学科',
    `conferable_degrees` varchar(25) DEFAULT '学士学位；硕士学位；博士学位' COMMENT '可授予的学位',
    `faculty` varchar(520) DEFAULT '师资队伍：现有教职员工1700余人，其中专任教师1100余人，博士生导师15人，硕士生导师200余人，专任教师中教授200余人，副教授490余人，硕士以上学历占专任教师总数的70%。有“国务院政府特殊津贴”专家16人，“新世纪百千万人才工程”国家级人选1人，教育部“新世纪优秀人才支持计划”7人；湖南省“百人计划”2人，湖南省“121人才工程”人22人,“湖南省政府特殊津贴”专家2人，湖湘青年英才、国家民委优秀中青年专家1人;有曾宪梓教育基金奖获得者4人，宝钢教育基金奖获得者1人，有全国先进工作者、优秀教师等13人；有国家级教学团队1个，省级优秀教学团队3个，省级科技创新团队4个。' COMMENT '师资力量',
    `students_number` varchar(520) DEFAULT '现有各类在籍学生3万余人，其中在校本专科生2万余人，博士生、硕士生、留学生近千人。' COMMENT '学生人数',
    `admission_batch` varchar(520) DEFAULT '   吉首大学招生录取工作：

湖南、甘肃：本科一批录取；

河北、河南、广西：部分专业本科一批录取；

其他省（市、区）：本科二批录取。


' COMMENT '录取批次',

    `art_enrollment` varchar(520) DEFAULT '艺术类专业录取规则：学校2019年不组织艺术校考，艺术类专业以各省（市、区）专业统考成绩和高考文化成绩为依据进行录取。有明确投档规则的省份，按该省投档成绩从高分到低分录取；没有明确投档规则的省份，按综合成绩从高分到低分录取（综合成绩=高考文化成绩×30%+专业统考成绩×70%）。投档成绩（综合成绩）同分情况下，专业统考成绩高者优先录取。

内蒙古自治区艺术类考生按专业统考（联考）成绩排序录取。' COMMENT '对艺术类招生的录取办法',
    `extra_points` varchar(200) DEFAULT '学校认可各省（市、区）的加分政策。' COMMENT '加分政策',
    `ethnic_minority` varchar(200) DEFAULT '暂无！' COMMENT '对少数民族考生的特殊政策',
    `previous_students` varchar(200) DEFAULT '对往届生一视同仁。' COMMENT '对往届生的录取政策',
    `transfer_major` varchar(200) DEFAULT '新生入学一学期后，根据学校学籍管理规定可以申请转专业。' COMMENT '转专业的实施办法',
    `other` varchar(200) DEFAULT '暂无。' COMMENT '其它',
    `scholarship` varchar(1024) DEFAULT '为了鼓励在校学生勤奋学习，报效国家，在政府和社会各界的大力支持下，学校有以下三类奖、助学金。

一、由中央政府及湖南省政府出资设立的奖、助学金

1.国家奖学金：奖励特别优秀的二年级(含二年级)的全日制本专科大学生，奖励标准为每人每年8000元，每学年评选一次；

2.国家励志奖学金：奖励资助品学兼优的二年级(含二年级)的家庭经济困难大学生，奖励标准为每人每年5000元，每学年评选一次；

3.国家助学金：资助家庭经济困难的全日制本专科在校学生，分为一、二、三等，资助标准平均每人每年3000元，每学年评选一次

二、学校自筹经费设立的奖、助学金

1.优秀学生奖学金：全日制本专科学生享受，每年奖励一次，奖励面25%，分为一、二、三等。

2.优秀学生干部：奖励表现优秀的学生干部，每年奖励一次，奖励面为4%。

3.三好学生：奖励德、智、体全面发展的本专科学生，每年奖励一次，奖励面为2%。

4.特优毕业生和优秀毕业生：奖励表现优秀的应届毕业生，奖励面分别为2%和8%。

三、由社会力量捐资助学设立的奖、助学金

1.南勋感恩奖学金：每年奖励品学兼优的本专科学生60名，奖励标准为每人每年5000元。

2.香港精进基金助学金：资助品学兼优的家庭经济困难大学生25名，奖励标准为每人每年5000元。

3.湖南宋祖英基金助学金：资助品学兼优的家庭经济困难大学生，奖励标准为每人每年2000元。' COMMENT '奖学金设置',

    `difficult_student` varchar(1024) DEFAULT '资助贫困大学生完成学业措施

吉首大学十分关心贫困生的学习和生活，千方百计采取各种有力措施帮助贫困生完成学业，主要措施有：
（一）充分贯彻执行和实施了国家助学贷款政策；
（二）国务院中国乡镇企业开发总公司设立了100万元“吉首大学光彩助学金”，每年提供十万元资助品学兼优的贫困学生；
（三）设立了“吉首大学扶贫助学金”，建立了吉首大学贫困生救助网站；（四）每年提供学生困难补助费几十万元，主要以发放“特别困难补助费”和设立勤工助学岗位等形式，资助校贫困生。' COMMENT '困难生资助办法',

    primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='学校具体信息';