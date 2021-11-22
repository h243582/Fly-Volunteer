create table tb_user
(
    `id` int NOT NULL auto_increment COMMENT 'ID',
    `username` varchar(16) NOT NULL COMMENT '用户名',
    `password` varchar(16) NOT NULL COMMENT '密码',
    `nickname`    varchar(100)  null comment '昵称',
    `phone` varchar(100)  NULL COMMENT '电话',
    `is_vip` boolean  default false COMMENT '是否会员',

    primary key (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';


create table tb_year
(
    `id` int NOT NULL auto_increment COMMENT 'ID',
    `year` int NOT NULL COMMENT '年份',

    primary key (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='年份表';

DELIMITER //
CREATE PROCEDURE callback()
BEGIN
    DECLARE num INT;
    SET num = 2017;
    WHILE
            num <= 2022
        DO
            INSERT INTO tb_year(year) VALUES (num);
            SET num = num + 1;
        END WHILE;
END;
//
CALL callback();
DROP PROCEDURE callback;





create table tb_grade_school_major_year
(
    `id` int NOT NULL auto_increment COMMENT 'ID',
    `tb_school_major_id` int NOT NULL COMMENT '学校专业对应表id',
    `tb_year_id` int NOT NULL COMMENT '年份表id',

    `grade` int NOT NULL COMMENT '分数',
    primary key (`id`)
) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='历年录取分数线表';

alter table tb_grade_school_major_year
    add constraint tb_grade_school_major_year_tb_school_major_fk
        foreign key (tb_school_major_id) references tb_school_major (id),
    add constraint tb_grade_major_school_year_tb_year_fk
        foreign key (tb_year_id) references tb_year (id);


DELIMITER //
CREATE PROCEDURE callback()
BEGIN
    DECLARE num1 INT;
    DECLARE num2 INT;

    SET num1 = 1;
    SET num2 = 1;
    WHILE
            num1 <= 35
        DO
            SET num2 = 1;
            WHILE
                    num2 <= 6
                DO

                    INSERT INTO tb_grade_school_major_year(tb_school_major_id,tb_year_id,grade)
                    VALUES (num1,num2,cast(rand()*1000%700 AS signed));
                    SET num2 = num2 + 1;
                END WHILE;
            SET num1 = num1 + 1;
        END WHILE;
END;
//
CALL callback();
DROP PROCEDURE callback;