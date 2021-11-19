create table tb_school_major
(
    `id` int NOT NULL auto_increment COMMENT 'ID' ,
    `tb_school_id` int DEFAULT NULL COMMENT '学校id',
    `tb_major_id` int DEFAULT NULL COMMENT '专业id',
    `satisfaction` decimal(2,1) default 4.2 comment '学校对应专业满意度',
    `recommended_number` bigint default 888 comment '推荐人数',
    `educational_system` varchar(30) default '四年    授予工学学士学位'  comment '学制',
    `training_objectives` varchar(520) default '本专业培养掌握软件工程基础理论知识，精通软件开发技术，熟练使用软件开发工程化方法和工具，具备软件系统分析与设计、软件开发实践、软件项目工程管理的能力，具有国际视野、创新意识和团队合作精神，能在大型软件与服务外包企业、金融机构、通信行业、IT 相关行业、跨国公司、高新技术产业园区、政府部门等单位从事软件技术开发、信息技术外包与项目管理的国际化应用型高级软件专门人才。'  comment '培养目标',
primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='学校和专业对应表';



alter table tb_school_major
    add constraint tb_school_id_fk
        foreign key (tb_school_id) references tb_school (id);

alter table tb_school_major
    add constraint tb_major_id_fk
        foreign key (tb_major_id) references tb_major (id);

insert into tb_school_major(tb_school_id,tb_major_id,satisfaction,recommended_number) values(1559,173,4.9,653);
insert into tb_school_major(tb_school_id,tb_major_id,satisfaction,recommended_number) values(1559,111,4.5,213);
insert into tb_school_major(tb_school_id,tb_major_id,satisfaction,recommended_number) values(1559,12,4.2,213);
insert into tb_school_major(tb_school_id,tb_major_id,satisfaction,recommended_number) values(1559,41,4.3,241);
insert into tb_school_major(tb_school_id,tb_major_id,satisfaction,recommended_number) values(1559,213,4.7,234);
insert into tb_school_major(tb_school_id,tb_major_id,satisfaction,recommended_number) values(1559,33,4.6,123);
insert into tb_school_major(tb_school_id,tb_major_id,satisfaction,recommended_number) values(1559,34,4.4,231);
insert into tb_school_major(tb_school_id,tb_major_id,satisfaction,recommended_number) values(1559,35,4.2,312);
insert into tb_school_major(tb_school_id,tb_major_id,satisfaction,recommended_number) values(1559,36,4.1,541);




create table tb_major_information
(
    `id` int NOT NULL auto_increment COMMENT 'ID' ,
    `tb_major_id` int DEFAULT NULL COMMENT '专业id',
    `introduce` varchar(520) DEFAULT '软件工程是研究大规模软件开发方法、工具和管理的一门工程科学，其特点是按工程化的原则和方法来组织和规范软件开发过程，软件工程技术则主要研究与软件开发各个工作流程相关的、先进实用的软件开发方法、技术和工具；软件工程技术专业面向国民经济电子信息化建设和发展的需要，培养具有扎实的软件理论和知识基础，对整个软件过程有整体了解、掌握软件工程领域的前沿技术，具有国际竞争能力，能从事大型软件项目系统分析、设计、编程、测试和软件项目管理等工作的复合型、实用型的高层次软件工程技术人才；主要涵盖软件工程学科和计算机学科的基本理论、基础知识、基本技能的研究，软件的分析与开发，计算机应用系统、计算机网络系统的设计与开发等专业内容。 ' COMMENT '专业介绍',
    `people_min` bigint DEFAULT 30000 COMMENT '毕业生规模低点',
    `people_max` bigint DEFAULT 95000 COMMENT '毕业生规模高点',
    `boys_proportion` decimal(3,2) DEFAULT 0.78 COMMENT '男生比例占比',

    `comprehensive_satisfaction` decimal(2, 1) DEFAULT 4.1 COMMENT '综合满意度',
    `comprehensive_people` int DEFAULT 63520 COMMENT '综合满意度人数',

    `conditions_satisfaction` decimal(2,1) DEFAULT 4.1 COMMENT '办学条件满意度',
    `conditions_people` int DEFAULT 55990 COMMENT '办学条件满意度人数',

    `quality_satisfaction` decimal(2,1) DEFAULT 4.1 COMMENT '教学质量满意度',
    `quality_people` int DEFAULT 62100 COMMENT '教学质量满意度人数',

    `job_satisfaction` decimal(2,1) DEFAULT 4.1 COMMENT '就业满意度',
    `job_people` int DEFAULT 64852 COMMENT '就业满意度人数',

    primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='专业具体信息表';


alter table tb_major_information
    add constraint tb_major_information_fk
        foreign key (tb_major_id) references tb_major (id);

insert into tb_major_information(tb_major_id) values (173);




create table tb_major_similar_major
(
    `id` int NOT NULL auto_increment COMMENT 'ID' ,
    `tb_major_id` int DEFAULT NULL COMMENT '专业id',
    `tb_major_id_similar` int DEFAULT NULL COMMENT '相似专业id',

    primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='相似专业表';

alter table tb_major_similar_major
    add constraint tb_major_id_similar1_fk
        foreign key (tb_major_id) references tb_major (id);

alter table tb_major_similar_major
    add constraint tb_major_id_similar2_fk
        foreign key (tb_major_id_similar) references tb_major (id);

insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,174);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,117);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,170);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,175);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,218);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,293);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,316);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,176);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,177);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,352);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,333);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,149);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,165);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,166);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,168);
insert into tb_major_similar_major(tb_major_id,tb_major_id_similar) values (173,320);




create table tb_major_province_money
(
    `id` int NOT NULL auto_increment COMMENT 'ID' ,
    `tb_major_id` int DEFAULT NULL COMMENT '专业id',
    `tb_province_id` int DEFAULT NULL COMMENT '省id',

    `money` int default 15000 comment '月薪',
    primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='各专业各省平均薪酬表';

alter table tb_major_province_money
    add constraint tb_major_province_money_tb_major_fk
        foreign key (tb_major_id) references tb_major (id);

alter table tb_major_province_money
    add constraint tb_major_province_money_tb_province_fk
        foreign key (tb_province_id) references tb_province (id);

insert into tb_major_province_money(tb_major_id,tb_province_id,money) values (173,19,);

