create table tb_school_major
(
    `id` int NOT NULL auto_increment COMMENT 'ID' ,
    `tb_school_id` int DEFAULT NULL COMMENT '学校id',
    `tb_major_id` int DEFAULT NULL COMMENT '专业id',

    primary key (`id`)
) engine =InnoDB DEFAULT CHARSET=utf8 COMMENT='学校和专业对应表';

alter table tb_school_major
    add constraint tb_school_id_fk
        foreign key (tb_school_id) references tb_school (id);

alter table tb_school_major
    add constraint tb_major_id_fk
        foreign key (tb_major_id) references tb_major (id);



insert into tb_major(name) values('本科（普通教育）');






