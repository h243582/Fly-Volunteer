create table tb_major_levels_type
(
    `id` int NOT NULL auto_increment COMMENT 'ID' ,
    `name` varchar(30) DEFAULT NULL COMMENT '专业层次类型名',
    primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='专业层次类型表';

insert into tb_major_levels_type(name) values('本科（普通教育）');
insert into tb_major_levels_type(name) values('本科（职业教育）');
insert into tb_major_levels_type(name) values('高职（专科）');


create table tb_major_category
(
    `id` int NOT NULL auto_increment COMMENT 'ID' ,
    `name` varchar(30) DEFAULT NULL COMMENT '门类名',
    `tb_major_levels_type_id` int default 1 COMMENT '从属专业层次类型' ,
    primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='门类表';

alter table tb_major_category
    add constraint tb_major_category_tb_major_levels_type_fk
        foreign key (tb_major_levels_type_id) references tb_major_levels_type (id);

SET foreign_key_checks = 1;
DROP TABLE tb_major_professional_category ;


create table tb_major_professional_category
(
    `id` int NOT NULL auto_increment COMMENT 'ID' ,
    `name` varchar(30) DEFAULT NULL COMMENT '专业类名',
    `major_code` varchar(30) DEFAULT 0100 COMMENT '专业代码',
    `tb_major_category_id` int default 1 COMMENT '从属门类' ,
    primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='专业类表';

alter table tb_major_professional_category
    add constraint tb_major_category_tb_major_category_fk
        foreign key (tb_major_category_id) references tb_major_category (id);



create table tb_major
(
    `id` int NOT NULL auto_increment COMMENT 'ID' ,
    `name` varchar(30) DEFAULT '哲学' COMMENT '专业名',
    `major_code` varchar(30) DEFAULT 010000 COMMENT '专业代码',
    `satisfaction` decimal(2,1) DEFAULT 4.3 COMMENT '专业满意度',

    `tb_major_professional_category_id` int default 1 COMMENT '从属专业类' ,
    primary key (`id`)
) engine = InnoDB DEFAULT CHARSET=utf8 COMMENT='专业具体名称表';

alter table tb_major
    add constraint tb_major_tb_category_id_fk
        foreign key (tb_major_professional_category_id) references tb_major_professional_category (id);



insert into tb_major_category(name, tb_major_levels_type_id) values('哲学', 1);
insert into tb_major(name, major_code, satisfaction,tb_major_professional_category_id)values ('哲学', '010101', 4.3, 1);
insert into tb_major(name, major_code, satisfaction,tb_major_professional_category_id)values ('逻辑学', '010102', 3.5, 1);
insert into tb_major(name, major_code, satisfaction,tb_major_professional_category_id)values ('宗教学', '010104', 4.5, 1);
insert into tb_major(name, major_code, satisfaction,tb_major_professional_category_id)values ('伦理学', '010105', 5.0, 1);


insert into tb_major_category(name, tb_major_levels_type_id) values('经济学', 1);


insert into tb_major_category(name, tb_major_levels_type_id) values('法学', 1);
insert into tb_major_category(name, tb_major_levels_type_id) values('教育学', 1);
insert into tb_major_category(name, tb_major_levels_type_id) values('文学', 1);
insert into tb_major_category(name, tb_major_levels_type_id) values('历史学', 1);
insert into tb_major_category(name, tb_major_levels_type_id) values('理学', 1);
insert into tb_major_category(name, tb_major_levels_type_id) values('工学', 1);
insert into tb_major_category(name, tb_major_levels_type_id) values('农学', 1);
insert into tb_major_category(name, tb_major_levels_type_id) values('医学', 1);
insert into tb_major_category(name, tb_major_levels_type_id) values('管理学', 1);
insert into tb_major_category(name, tb_major_levels_type_id) values('艺术学', 1);

insert into tb_major_category(name, tb_major_levels_type_id) values('农林牧渔', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('资源环境与安全', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('能源动力与材料', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('土木建筑', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('水利', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('装备制造', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('生物与化工', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('轻工纺织', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('食品药品与粮食', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('交通运输', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('电子与信息', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('医药卫生', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('财经商贸', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('旅游', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('文化艺术', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('新闻传播', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('教育与体育', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('公安与司法', 2);
insert into tb_major_category(name, tb_major_levels_type_id) values('公共管理与服务', 2);

insert into tb_major_category(name, tb_major_levels_type_id) values('农林牧渔', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('资源环境与安全', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('能源动力与材料', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('土木建筑', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('水利', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('装备制造', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('生物与化工', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('轻工纺织', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('交通运输', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('电子与信息', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('医药卫生', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('财经商贸', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('旅游', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('文化艺术', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('新闻传播', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('教育与体育', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('公安与司法', 3);
insert into tb_major_category(name, tb_major_levels_type_id) values('公共管理与服务', 3);



insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('哲学类', '0101', 1);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('经济学类', '0201', 2);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('财政学类', '0202', 2);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('金融学类', '0203', 2);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('经济与贸易类', '0204', 2);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('法学类', '0301', 3);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('政治学类', '0302', 3);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('社会学类', '0303', 3);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('民族学类', '0304', 3);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('马克思主义理论类', '0305', 3);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('公安学类', '0306', 3);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('教育学类', '0401', 4);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('体育学类', '0402', 4);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('中国语言文学类', '0501', 5);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('外国语言文学类', '0502', 5);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('新闻传播学类', '0503', 5);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('历史学类', '0601', 6);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('数学类', '0701', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('物理学类', '0702', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('化学类', '0703', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('天文学类', '0704', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('地理科学类', '0705', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('大气科学类', '0706', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('海洋科学类', '0707', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('地球物理学类', '0708', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('地质学类', '0709', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('生物科学类', '0710', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('心理学类', '0711', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('统计学类', '0712', 7);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('力学类', '0801', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('机械类', '0802', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('仪器类', '0803', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('材料类', '0804', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('能源动力类', '0805', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('电气类', '0806', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('电子信息类', '0807', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('自动化类', '0808', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('计算机类', '0809', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('土木类', '0810', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('水利类', '0811', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('测绘类', '0812', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('化工与制药类', '0813', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('地质类', '0814', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('矿业类', '0815', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('纺织类', '0816', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('轻工类', '0817', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('交通运输类', '0818', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('海洋工程类', '0819', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('航空航天类', '0820', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('兵器类', '0821', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('核工程类', '0822', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('农业工程类', '0823', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('林业工程类', '0824', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('环境科学与工程类', '0825', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('生物医学工程类', '0826', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('食品科学与工程类', '0827', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('建筑类', '0828', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('安全科学与工程类', '0829', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('生物工程类', '0830', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('公安技术类', '0831', 8);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('植物生产类', '0901', 9);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('自然保护与环境生态类', '0902', 9);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('动物生产类', '0903', 9);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('动物医学类', '0904', 9);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('林学类', '0905', 9);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('水产类', '0906', 9);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('草学类', '0907', 9);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('基础医学类', '1001', 10);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('临床医学类', '1002', 10);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('口腔医学类', '1003', 10);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('公共卫生与预防医学类', '1004', 10);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('中医学类', '1005', 10);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('中西医结合类', '1006', 10);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('药学类', '1007', 10);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('中药学类', '1008', 10);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('法医学类', '1009', 10);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('医学技术类', '1010', 10);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('护理学类', '1011', 10);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('管理科学与工程类', '1201', 11);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('工商管理类', '1202', 11);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('农业经济管理类', '1203', 11);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('公共管理类', '1204', 11);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('图书情报与档案管理类', '1205', 11);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('物流管理与工程类', '1206', 11);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('工业工程类', '1207', 11);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('电子商务类', '1208', 11);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('旅游管理类', '1209', 11);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('艺术学理论类', '1301', 12);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('音乐与舞蹈学类', '1302', 12);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('戏剧与影视学类', '1303', 12);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('美术学类', '1304', 12);
insert into tb_major_professional_category(name, major_code, tb_major_category_id) values('设计学类', '1305', 12);

select *from tb_major_professional_category c left join tb_major_category m on c.tb_major_category_id=m.id;


insert into tb_major(name, major_code, tb_major_professional_category_id)values ('哲学', '010101', 1);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('逻辑学', '010102', 1);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('宗教学', '010103K', 1);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('经济学', '020101', 2);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('经济统计学', '020102', 2);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('财政学', '020201K', 3);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('税收学', '020202', 3);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('金融学', '020301K', 4);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('金融工程', '020302', 4);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('保险学', '020303', 4);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('投资学', '020304', 4);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('国际经济与贸易', '020401', 5);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('贸易经济', '020402', 5);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('法学', '030101K', 6);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('政治学与行政学', '030201', 7);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('国际政治', '030202', 7);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('外交学', '030203', 7);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('社会学', '030301', 8);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('社会工作', '030302', 8);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('民族学', '030401', 9);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('科学社会主义', '030501', 10);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('中国共产党历史', '030502', 10);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('思想政治教育', '030503', 10);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('治安学', '030601K', 11);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('侦查学', '030602K', 11);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('边防管理', '030603K', 11);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('教育学', '040101', 12);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('科学教育', '040102', 12);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('人文教育', '040103', 12);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('教育技术学（注：可授教育学或理学或工学学士学位）', '040104', 12);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('艺术教育（注：可授教育学或艺术学学士学位）', '040105', 12);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('学前教育', '040106', 12);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('小学教育', '040107', 12);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('特殊教育', '040108', 12);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('体育教育', '040201', 13);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('运动训练', '040202K', 13);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('社会体育指导与管理', '040203', 13);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('武术与民族传统体育', '040204K', 13);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('运动人体科学', '040205', 13);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('汉语言文学', '050101', 14);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('汉语言', '050102', 14);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('汉语国际教育', '050103', 14);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('中国少数民族语言文学', '050104', 14);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('古典文献学', '050105', 14);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('英语', '050201', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('俄语', '050202', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('德语', '050203', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('法语', '050204', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('西班牙语', '050205', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('阿拉伯语', '050206', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('日语', '050207', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('波斯语', '050208', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('朝鲜语', '050209', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('菲律宾语', '050210', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('梵语巴利语', '050211', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('印度尼西亚语', '050212', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('印地语', '050213', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('柬埔寨语', '050214', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('老挝语', '050215', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('缅甸语', '050216', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('马来语', '050217', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('蒙古语', '050218', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('僧伽罗语', '050219', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('泰语', '050220', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('乌尔都语', '050221', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('希伯来语', '050222', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('越南语', '050223', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('豪萨语', '050224', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('斯瓦希里语', '050225', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('阿尔巴尼亚语', '050226', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('保加利亚语', '050227', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('波兰语', '050228', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('捷克语', '050229', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('斯洛伐克语', '050230', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('罗马尼亚语', '050231', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('葡萄牙语', '050232', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('瑞典语', '050233', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('塞尔维亚语', '050234', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('土耳其语', '050235', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('希腊语', '050236', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('匈牙利语', '050237', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('意大利语', '050238', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('泰米尔语', '050239', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('普什图语', '050240', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('世界语', '050241', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('孟加拉语', '050242', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('尼泊尔语', '050243', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('克罗地亚语', '050244', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('荷兰语', '050245', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('芬兰语', '050246', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('乌克兰语', '050247', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('挪威语', '050248', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('丹麦语', '050249', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('冰岛语', '050250', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('爱尔兰语', '050251', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('拉脱维亚语', '050252', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('立陶宛语', '050253', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('斯洛文尼亚语', '050254', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('爱沙尼亚语', '050255', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('马耳他语', '050256', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('哈萨克语', '050257', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('乌兹别克语', '050258', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('祖鲁语', '050259', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('拉丁语', '050260', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('翻译', '050261', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('商务英语', '050262', 15);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('新闻学', '050301', 16);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('广播电视学', '050302', 16);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('广告学', '050303', 16);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('传播学', '050304', 16);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('编辑出版学', '050305', 16);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('历史学', '060101', 17);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('世界史', '060102', 17);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('考古学', '060103', 17);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('文物与博物馆学', '060104', 17);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('数学与应用数学', '070101', 18);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('信息与计算科学', '070102', 18);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('物理学', '070201', 19);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('应用物理学', '070202', 19);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('核物理', '070203', 19);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('化学', '070301', 20);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('应用化学（注：可授理学或工学学士学位）', '070302', 20);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('天文学', '070401', 21);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('地理科学', '070501', 22);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('自然地理与资源环境（注：可授理学或管理学学士学位）', '070502', 22);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('人文地理与城乡规划（注：可授理学或管理学学士学位）', '070503', 22);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('地理信息科学', '070504', 22);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('大气科学', '070601', 23);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('应用气象学', '070602', 23);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('海洋科学', '070701', 24);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('海洋技术(注：可授理学或工学学士学位)', '070702', 24);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('地球物理学', '070801', 25);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('空间科学与技术（注：可授理学或工学学士学位）', '070802', 25);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('地质学', '070901', 26);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('地球化学', '070902', 26);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('生物科学', '071001', 27);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('生物技术（注：可授理学或工学学士学位）', '071002', 27);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('生物信息学（注：可授理学或工学学士学位）', '071003', 27);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('生态学', '071004', 27);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('心理学（注：可授理学或教育学学士学位）', '071101', 28);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('应用心理学（注：可授理学或教育学学士学位）', '071102', 28);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('统计学', '071201', 29);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('应用统计学', '071202', 29);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('理论与应用力学（注：可授工学或理学学士学位）', '080101', 30);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('工程力学', '080102', 30);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('机械工程', '080201', 31);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('机械设计制造及其自动化', '080202', 31);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('材料成型及控制工程', '080203', 31);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('机械电子工程', '080204', 31);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('工业设计', '080205', 31);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('过程装备与控制工程', '080206', 31);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('车辆工程', '080207', 31);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('汽车服务工程', '080208', 31);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('测控技术与仪器', '080301', 32);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('材料科学与工程', '080401', 33);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('材料物理（注：可授工学或理学学士学位）', '080402', 33);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('材料化学（注：可授工学或理学学士学位）', '080403', 33);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('冶金工程', '080404', 33);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('金属材料工程', '080405', 33);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('无机非金属材料工程', '080406', 33);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('高分子材料与工程', '080407', 33);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('复合材料与工程', '080408', 33);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('能源与动力工程', '080501', 34);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('电气工程及其自动化', '080601', 35);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('电子信息工程（注：可授工学或理学学士学位）', '080701', 36);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('电子科学与技术（注：可授工学或理学学士学位）', '080702', 36);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('通信工程', '080703', 36);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('微电子科学与工程（注：可授工学或理学学士学位）', '080704', 36);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('光电信息科学与工程（注：可授工学或理学学士学位）', '080705', 36);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('信息工程', '080706', 36);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('自动化', '080801', 37);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('计算机科学与技术（注：可授工学或理学学士学位）', '080901', 38);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('软件工程', '080902', 38);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('网络工程', '080903', 38);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('信息安全（注：可授工学或理学或管理学学士学位）', '080904K', 38);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('物联网工程', '080905', 38);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('数字媒体技术', '080906', 38);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('土木工程', '081001', 39);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('建筑环境与能源应用工程', '081002', 39);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('给排水科学与工程', '081003', 39);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('建筑电气与智能化', '081004', 39);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('水利水电工程', '081101', 40);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('水文与水资源工程', '081102', 40);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('港口航道与海岸工程', '081103', 40);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('测绘工程', '081201', 41);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('遥感科学与技术', '081202', 41);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('化学工程与工艺', '081301', 42);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('制药工程', '081302', 42);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('地质工程', '081401', 43);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('勘查技术与工程', '081402', 43);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('资源勘查工程', '081403', 43);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('采矿工程', '081501', 44);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('石油工程', '081502', 44);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('矿物加工工程', '081503', 44);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('油气储运工程', '081504', 44);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('纺织工程', '081601', 45);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('服装设计与工程（注：可授工学或艺术学学士学位）', '081602', 45);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('轻化工程', '081701', 46);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('包装工程', '081702', 46);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('印刷工程', '081703', 46);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('交通运输', '081801', 47);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('交通工程', '081802', 47);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('航海技术', '081803K', 47);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('轮机工程', '081804K', 47);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('飞行技术', '081805K', 47);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('船舶与海洋工程', '081901', 48);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('航空航天工程', '082001', 49);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('飞行器设计与工程', '082002', 49);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('飞行器制造工程', '082003', 49);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('飞行器动力工程', '082004', 49);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('飞行器环境与生命保障工程', '082005', 49);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('武器系统与工程', '082101', 50);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('武器发射工程', '082102', 50);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('探测制导与控制技术', '082103', 50);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('弹药工程与爆炸技术', '082104', 50);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('特种能源技术与工程', '082105', 50);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('装甲车辆工程', '082106', 50);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('信息对抗技术', '082107', 50);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('核工程与核技术', '082201', 51);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('辐射防护与核安全', '082202', 51);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('工程物理', '082203', 51);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('核化工与核燃料工程', '082204', 51);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('农业工程', '082301', 52);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('农业机械化及其自动化', '082302', 52);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('农业电气化', '082303', 52);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('农业建筑环境与能源工程', '082304', 52);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('农业水利工程', '082305', 52);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('森林工程', '082401', 53);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('木材科学与工程', '082402', 53);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('林产化工', '082403', 53);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('环境科学与工程', '082501', 54);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('环境工程', '082502', 54);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('环境科学（注：可授工学或理学学士学位）', '082503', 54);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('环境生态工程', '082504', 54);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('生物医学工程（注：可授工学或理学学士学位）', '082601', 55);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('食品科学与工程（注：可授工学或农学学士学位）', '082701', 56);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('食品质量与安全', '082702', 56);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('粮食工程', '082703', 56);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('乳品工程', '082704', 56);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('酿酒工程', '082705', 56);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('建筑学', '082801', 57);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('城乡规划', '082802', 57);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('风景园林（注：可授工学或艺术学学士学位）', '082803', 57);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('安全工程', '082901', 58);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('生物工程', '083001', 59);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('刑事科学技术', '083101K', 60);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('消防工程', '083102K', 60);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('农学', '090101', 61);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('园艺', '090102', 61);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('植物保护', '090103', 61);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('植物科学与技术', '090104', 61);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('种子科学与工程', '090105', 61);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('设施农业科学与工程（注：可授农学或工学学士学位）', '090106', 61);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('农业资源与环境', '090201', 62);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('野生动物与自然保护区管理', '090202', 62);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('水土保持与荒漠化防治', '090203', 62);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('动物科学', '090301', 63);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('动物医学', '090401', 64);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('动物药学', '090402', 64);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('林学', '090501', 65);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('园林', '090502', 65);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('森林保护', '090503', 65);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('水产养殖学', '090601', 66);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('海洋渔业科学与技术', '090602', 66);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('草业科学', '090701', 67);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('基础医学', '100101K', 68);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('临床医学', '100201K', 69);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('口腔医学', '100301K', 70);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('预防医学', '100401K', 71);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('食品卫生与营养学（注：授予理学学士学位）', '100402', 71);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('中医学', '100501K', 72);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('针灸推拿学', '100502K', 72);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('藏医学', '100503K', 72);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('蒙医学', '100504K', 72);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('维医学', '100505K', 72);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('壮医学', '100506K', 72);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('哈医学', '100507K', 72);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('中西医临床医学', '100601K', 73);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('药学（注：授予理学学士学位）', '100701', 74);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('药物制剂（注：授予理学学士学位）', '100702', 74);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('中药学（注：授予理学学士学位）', '100801', 75);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('中药资源与开发（注：授予理学学士学位）', '100802', 75);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('法医学', '100901K', 76);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('医学检验技术（注：授予理学学士学位）', '101001', 77);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('医学实验技术（注：授予理学学士学位）', '101002', 77);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('医学影像技术（注：授予理学学士学位）', '101003', 77);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('眼视光学（注：授予理学学士学位）', '101004', 77);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('康复治疗学（注：授予理学学士学位）', '101005', 77);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('口腔医学技术（注：授予理学学士学位）', '101006', 77);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('卫生检验与检疫（注：授予理学学士学位）', '101007', 77);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('护理学（注：授予理学学士学位）', '101101', 78);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('管理科学（注：可授管理学或理学学士学位）', '120101', 79);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('信息管理与信息系统（注：可授管理学或工学学士学位）', '120102', 79);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('工程管理（注：可授管理学或工学学士学位）', '120103', 79);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('房地产开发与管理', '120104', 79);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('工程造价（注：可授管理学或工学学士学位）', '120105', 79);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('工商管理', '120201K', 80);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('市场营销', '120202', 80);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('会计学', '120203K', 80);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('财务管理', '120204', 80);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('国际商务', '120205', 80);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('人力资源管理', '120206', 80);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('审计学', '120207', 80);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('资产评估', '120208', 80);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('物业管理', '120209', 80);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('文化产业管理（注：可授管理学或艺术学学士学位）', '120210', 80);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('农林经济管理', '120301', 81);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('农村区域发展（注：可授管理学或农学学士学位）', '120302', 81);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('公共事业管理', '120401', 82);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('行政管理', '120402', 82);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('劳动与社会保障', '120403', 82);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('土地资源管理（注：可授管理学或工学学士学位）', '120404', 82);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('城市管理', '120405', 82);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('图书馆学', '120501', 83);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('档案学', '120502', 83);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('信息资源管理', '120503', 83);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('物流管理', '120601', 84);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('物流工程（注：可授管理学或工学学士学位）', '120602', 84);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('工业工程（注：可授管理学或工学学士学位）', '120701', 85);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('电子商务（注：可授管理学或经济学或工学学士学位）', '120801', 86);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('旅游管理', '120901K', 87);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('酒店管理', '120902', 87);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('会展经济与管理', '120903', 87);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('艺术史论', '130101', 88);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('音乐表演', '130201', 89);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('音乐学', '130202', 89);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('作曲与作曲技术理论', '130203', 89);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('舞蹈表演', '130204', 89);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('舞蹈学', '130205', 89);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('舞蹈编导', '130206', 89);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('表演', '130301', 90);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('戏剧学', '130302', 90);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('电影学', '130303', 90);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('戏剧影视文学', '130304', 90);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('广播电视编导', '130305', 90);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('戏剧影视导演', '130306', 90);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('戏剧影视美术设计', '130307', 90);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('录音艺术', '130308', 90);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('播音与主持艺术', '130309', 90);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('动画', '130310', 90);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('美术学', '130401', 91);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('绘画', '130402', 91);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('雕塑', '130403', 91);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('摄影', '130404', 91);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('艺术设计学', '130501', 92);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('视觉传达设计', '130502', 92);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('环境设计', '130503', 92);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('产品设计', '130504', 92);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('服装与服饰设计', '130505', 92);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('公共艺术', '130506', 92);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('工艺美术', '130507', 92);
insert into tb_major(name, major_code, tb_major_professional_category_id)values ('数字媒体艺术', '130508', 92);


select *from tb_major c left join tb_major_professional_category m on c.tb_major_professional_category_id=m.id;


