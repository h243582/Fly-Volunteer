create table tb_school_major
(
    `id`                  int NOT NULL auto_increment COMMENT 'ID',
    `tb_school_id`        int           DEFAULT NULL COMMENT '学校id',
    `tb_major_id`         int           DEFAULT NULL COMMENT '专业id',
    `educational_system`  varchar(30)   default '四年    授予工学学士学位' comment '学制',
    `training_objectives` varchar(520)  default '本专业培养掌握软件工程基础理论知识，精通软件开发技术，熟练使用软件开发工程化方法和工具，具备软件系统分析与设计、软件开发实践、软件项目工程管理的能力，具有国际视野、创新意识和团队合作精神，能在大型软件与服务外包企业、金融机构、通信行业、IT 相关行业、跨国公司、高新技术产业园区、政府部门等单位从事软件技术开发、信息技术外包与项目管理的国际化应用型高级软件专门人才。' comment '培养目标',

    `satisfaction`        decimal(2, 1) default 4.5 comment '推荐指数',
    `recommended_number`  int        default 789 comment '推荐人数',

    `comprehensive_satisfaction` decimal(2, 1) DEFAULT 4.1 COMMENT '综合满意度',
    `comprehensive_people`       int           DEFAULT 6352 COMMENT '综合满意度人数',

    `conditions_satisfaction`    decimal(2, 1) DEFAULT 4.3 COMMENT '办学条件满意度',
    `conditions_people`          int           DEFAULT 5599 COMMENT '办学条件满意度人数',

    `quality_satisfaction`       decimal(2, 1) DEFAULT 4.5 COMMENT '教学质量满意度',
    `quality_people`             int           DEFAULT 6210 COMMENT '教学质量满意度人数',

    `job_satisfaction`           decimal(2, 1) DEFAULT 4.2 COMMENT '就业满意度',
    `job_people`                 int           DEFAULT 6485 COMMENT '就业满意度人数',

    primary key (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='学校和专业对应表';


alter table tb_school_major
    add constraint tb_school_major_tb_school_id_fk
        foreign key (tb_school_id) references tb_school (id);

alter table tb_school_major
    add constraint tb_school_major_tb_major_id_fk
        foreign key (tb_major_id) references tb_major (id);

insert into tb_school_major(tb_school_id, tb_major_id, satisfaction, recommended_number)
values (1559, 173, 4.9, 653),
 (1559, 111, 4.5, 213),
 (1559, 12, 4.2, 213),
 (1559, 41, 4.3, 241),
 (1559, 213, 4.7, 234),
 (1559, 33, 4.6, 123),
 (1559, 34, 4.4, 231),
 (1559, 35, 4.2, 312),
 (1559, 36, 4.1, 541);

DELIMITER //
CREATE PROCEDURE callback()
BEGIN
    DECLARE num1 INT;
    DECLARE num2 INT;

    SET num1 = 2;
    SET num2 = 1;
    WHILE
            num1 <= 20
        DO
            insert into tb_school_major(tb_school_id, tb_major_id, satisfaction, recommended_number)
            values (1559, num1, cast(rand()*10%5 AS signed),  cast(rand()*1000 AS signed));
            SET num1 = num1 + 3;
        END WHILE;
END;
//
CALL callback();
DROP PROCEDURE callback;


create table tb_major_information
(
    `id`                         int NOT NULL auto_increment COMMENT 'ID',
    `tb_major_id`                int           DEFAULT NULL COMMENT '专业id',
    `introduce`                  varchar(520)  DEFAULT '软件工程是研究大规模软件开发方法、工具和管理的一门工程科学，其特点是按工程化的原则和方法来组织和规范软件开发过程，软件工程技术则主要研究与软件开发各个工作流程相关的、先进实用的软件开发方法、技术和工具；软件工程技术专业面向国民经济电子信息化建设和发展的需要，培养具有扎实的软件理论和知识基础，对整个软件过程有整体了解、掌握软件工程领域的前沿技术，具有国际竞争能力，能从事大型软件项目系统分析、设计、编程、测试和软件项目管理等工作的复合型、实用型的高层次软件工程技术人才；主要涵盖软件工程学科和计算机学科的基本理论、基础知识、基本技能的研究，软件的分析与开发，计算机应用系统、计算机网络系统的设计与开发等专业内容。 ' COMMENT '专业介绍',
    `people_min`                 bigint        DEFAULT 30000 COMMENT '毕业生规模低点',
    `people_max`                 bigint        DEFAULT 95000 COMMENT '毕业生规模高点',
    `boys_proportion`            decimal(3, 2) DEFAULT 0.78 COMMENT '男生比例占比',

    `comprehensive_satisfaction` decimal(2, 1) DEFAULT 4.1 COMMENT '综合满意度',
    `comprehensive_people`       int           DEFAULT 63520 COMMENT '综合满意度人数',

    `conditions_satisfaction`    decimal(2, 1) DEFAULT 4.1 COMMENT '办学条件满意度',
    `conditions_people`          int           DEFAULT 55990 COMMENT '办学条件满意度人数',

    `quality_satisfaction`       decimal(2, 1) DEFAULT 4.1 COMMENT '教学质量满意度',
    `quality_people`             int           DEFAULT 62100 COMMENT '教学质量满意度人数',

    `job_satisfaction`           decimal(2, 1) DEFAULT 4.1 COMMENT '就业满意度',
    `job_people`                 int           DEFAULT 64852 COMMENT '就业满意度人数',

    primary key (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='专业具体信息表';


alter table tb_major_information
    add constraint tb_major_information_fk
        foreign key (tb_major_id) references tb_major (id);

insert into tb_major_information(tb_major_id)
values (173);



create table tb_major_similar_major
(
    `id`                  int NOT NULL auto_increment COMMENT 'ID',
    `tb_major_id`         int DEFAULT NULL COMMENT '专业id',
    `tb_major_id_similar` int DEFAULT NULL COMMENT '相似专业id',

    primary key (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='相似专业表';

alter table tb_major_similar_major
    add constraint tb_major_id_similar1_fk
        foreign key (tb_major_id) references tb_major (id);

alter table tb_major_similar_major
    add constraint tb_major_id_similar2_fk
        foreign key (tb_major_id_similar) references tb_major (id);

insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 174);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 117);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 170);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 175);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 218);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 293);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 316);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 176);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 177);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 352);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 333);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 149);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 165);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 166);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 168);
insert into tb_major_similar_major(tb_major_id, tb_major_id_similar)
values (173, 320);



create table tb_major_province_money
(
    `id`             int NOT NULL auto_increment COMMENT 'ID',
    `tb_major_id`    int DEFAULT NULL COMMENT '专业id',
    `tb_province_id` int DEFAULT NULL COMMENT '省id',

    `money`          int default 15000 comment '月薪',
    primary key (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='各专业各省平均薪酬表';

alter table tb_major_province_money
    add constraint tb_major_province_money_tb_major_fk
        foreign key (tb_major_id) references tb_major (id);

alter table tb_major_province_money
    add constraint tb_major_province_money_tb_province_fk
        foreign key (tb_province_id) references tb_province (id);

DELIMITER //
CREATE PROCEDURE callback()
BEGIN
    DECLARE num INT;
    DECLARE money INT;
    SET num = 5;
    SET money = 11000;
    WHILE
        num < 35
        DO
            INSERT INTO tb_major_province_money(tb_major_id, tb_province_id, money) VALUES (173, num, money);
            SET num = num + 1;
            SET money = money + 2375;
        END WHILE;
END;
//

CALL callback();

DROP PROCEDURE callback;



create table tb_major_vocation
(
    `id` int NOT NULL auto_increment COMMENT 'ID',
    name varchar(50) DEFAULT NULL COMMENT '就业方向',

    primary key (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='就业方向表';

insert into tb_major_vocation(name)
values ('软件工程师')
     , ('公务员(中央国家机关)')
     , ('公务员(省级机关)')
     , ('公务员(地市级机关)')
     , ('公务员(区县级及以下机关)')
     , ('IT技术支持/维护工程师')
     , ('手机软件开发工程师')
     , ('考研')
     , ('软件测试')
     , ('银行会计/柜员')
     , ('事业单位人员')

;

create table tb_major_vocation_major
(
    `id` int NOT NULL auto_increment COMMENT 'ID',
    `tb_major_id` int NOT NULL COMMENT '专业表id',
    `tb_major_vocation_id` int NOT NULL COMMENT '就业职业表id',

    primary key (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='就业方向表';

alter table tb_major_vocation_major
    add constraint tb_major_vocation_major_tb_major_id_fk
        foreign key (tb_major_id) references tb_major (id),
    add constraint tb_major_vocation_major_tb_major_vocation_id_fk
        foreign key (tb_major_vocation_id) references tb_major_vocation (id);



DELIMITER //
CREATE PROCEDURE callback()
BEGIN
    DECLARE num INT;
    SET num = 1;
    WHILE
            num <= 11
        DO
            INSERT INTO tb_major_vocation_major(tb_major_id, tb_major_vocation_id) VALUES (173, num);
            SET num = num + 1;
        END WHILE;
END;
//
CALL callback();
DROP PROCEDURE callback;


create table tb_course
(
    `id` int NOT NULL auto_increment COMMENT 'ID',
    name varchar(50) DEFAULT NULL COMMENT '课程',

    primary key (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='课程表';


insert into tb_course(name)values ('面向对象程序设计'),
    ('软件质量保障与测试技术'),
    ('软件分析与设计'),
    ('软件工程和质量控制'),
    ('网络存储'),
    ('数字电路分析设计'),
    ('离散结构'),
    ('J2EE构架与程序设计'),
    ('分布式计算与实践'),
    ('软件测试技术及实践'),
    ('面向服务架构'),
                                  ('软件工程综合实践'),
                                  ('数据结构与算法综合实践'),
                                  ('随机数学'),
                                  ('计算机应用与编程综合实践'),
                                  ('计算机网络与信息安全'),
                                  ('分布式计算'),
                                  ('网络安全与网络管理'),
                                  ('Internet开发技术'),
                                  ('人工智能技术'),
                                  ('计算机网络测控技术'),
                                  ('传感网理论与互联网技术'),
                                  ('软件开发案例分析'),
                                  ('模拟与数字电路'),
                                  ('网络综合实验'),
                                  ('操作系统基础'),
                                  ('软件体系架构与设计模式'),
                                  ('嵌入式技术'),
                                  ('WEB技术与应用'),
                                  ('CMM/IS'),
                                  ('汇编语言与计算机组成原理'),
                                  ('程序设计基础及语言'),
                                  ('JSP课程设计'),
                                  ('PHP程序设计'),
                                  ('.NET构架与实践'),
                                  ('C/C++程序设计'),
                                  ('.NET程序设计与系统开发'),
                                  ('面向对象分析和设计'),
                                  ('WindowsServer应用'),
                                  ('数据库系统及其应用'),
                                  ('JAVA语言程序设计实践'),
                                  ('软件工程数学'),
                                  ('数据结构与算法'),
                                  ('计算机与软件工程概论'),
                                  ('软件需求分析设计与建模'),
                                  ('嵌入式软件项目实训'),
                                  ('计算模型与算法技术'),
                                  ('动画原理与设计'),
                                  ('Internet程序开发'),
                                  ('网络协议分析实验'),
                                  ('线性代数'),
                                  ('算法分析'),
                                  ('UNIX/LINUX操作系统'),
                                  ('Web编程技术'),
                                  ('网页制作工程实训'),
                                  ('软件工程经济学'),
                                  ('数据库开发技术'),
                                  ('高级算法与数据结构实践'),
                                  ('软件方法建模与验证'),
                                  ('嵌入式系统与开发'),
                                  ('TCP/IP协议详解'),
                                  ('概率统计和随机过程'),
                                  ('安全协议与标准'),
                                  ('软件工程'),
                                  ('数据仓库数据挖掘'),
                                  ('数字部件设计'),
                                  ('数字部件设计实验'),
                                  ('统一建模设计语言UML'),
                                  ('Windows操作系统'),
                                  ('Oracle数据库设计与开发'),
                                  ('游戏开发实践'),
                                  ('编译原理及应用'),
                                  ('UML及软件建模'),
                                  ('UNIX程序设计'),
                                  ('图形图像软件应用'),
                                  ('游戏架构与编程'),
                                  ('用户界面设计与测试'),
                                  ('网络及分布式计算'),
                                  ('网络工程与编程实践'),
                                  ('可视化编程'),
                                  ('计算机系统组装实习'),
                                  ('图论与代数系统'),
                                  ('人机交互工程'),
                                  ('电路与模拟电子技术'),
                                  ('操作系统设计与实现'),
                                  ('移动应用开发实验'),
                                  ('计算机语言及其处理实验'),
                                  ('通信原理与系统'),
                                  ('移动信息工程导论'),
                                  ('数字信号处理与控制'),
                                  ('网络计算编程'),
                                  ('面向对象的技术与UML'),
                                  ('网络布线系统'),
                                  ('ORACLE数据库系统管理与维护技'),
                                  ('Linux操作系统与网络编程'),
                                  ('电路与模拟电子技术实验'),
                                  ('.NET平台/J2EE平台综合实训'),
                                  ('关系数据库系统'),
                                  ('存贮技术'),
                                  ('J2EE平台技术'),
                                  ('网站设计与架构'),
                                  ('数字媒体处理技术'),
                                  ('单片机原理及系统设计'),
                                  ('机器人技术导论'),
                                  ('高级数据结构与算法分析'),
                                  ('电工电子基础实验'),
                                  ('计算机语言及其处理'),
                                  ('数字信号处理与控制实验'),
                                  ('软件设计综合实验'),
                                  ('计算机组成原理与接口技术'),
                                  ('设计模式与统一建模语言'),
                                  ('计算和信息系统导论'),
                                  ('通信原理与系统实验'),
                                  ('移动网络安全'),
                                  ('数据结构'),
                                  ('计算机导论'),
                                  ('JAVASCRIPT'),
                                  ('程序设计基础'),
                                  ('JAVAweb应用开发'),
                                  ('c++程序设计');




create table tb_course_major
(
    `id` int NOT NULL auto_increment COMMENT 'ID',
    `tb_course_id` int NOT NULL COMMENT '课程ID',
    `tb_major_id` int NOT NULL COMMENT '专业ID',
    `course_difficulty`           decimal(2, 1) DEFAULT 5 COMMENT '课程难易度',
    `course_practical`            decimal(2, 1) DEFAULT 4 COMMENT '课程实用性（于工作、个人成长) ',

    primary key (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='课程专业对照表';

alter table tb_course_major
    add constraint tb_course_major_tb_course_fk
        foreign key (tb_course_id) references tb_course (id),
    add constraint tb_course_major_tb_major_fk
        foreign key (tb_major_id) references tb_major (id);


DELIMITER //
CREATE PROCEDURE callback()
BEGIN
    DECLARE num INT;
    SET num = 1;
    WHILE
            num <= 120
        DO
            INSERT INTO tb_course_major(tb_major_id, tb_course_id) VALUES (173, num);
            SET num = num + 1;
        END WHILE;
END;
//
CALL callback();
DROP PROCEDURE callback;


