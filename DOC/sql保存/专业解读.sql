create table tb_major_interpretation
(
    `id`                int NOT NULL auto_increment COMMENT 'ID',
    `tb_major_id`       int         default 173 comment '专业id',
    `title2`            varchar(50) DEFAULT '玩“积木”的高手' COMMENT '标题题解',
    `from`              varchar(20) DEFAULT '阳光高考信息平台' COMMENT '来自的平台',
    `author`            varchar(20) DEFAULT '何昱飞' COMMENT '作者',
    `detail`            varchar(2048)       default '在这个信息爆炸的时代，计算机软件正悄悄地应用于各个领域，深刻地影响着我们的日常生活。例如，典型的软件有如QQ、微信等聊天软件，腾讯视频、暴风影音等视频软件，酷狗音乐、多米音乐等音乐软件，word、ppt等办公软件。这些软件应用促进了经济和社会的发展，也提高了工作效率和生活质量。而这些软件的应用与软件工程是须臾不可分离的，如果把软件比作积木，软件工程则相当于玩积木的高手。那么，什么是软件工程，软件工程学什么，就业前景怎样呢？为帮助考生及家长了解该专业，本文就带领大家一探究竟。' comment '详细说明',
    `sponsor`           varchar(2048)       default '什么是软件工程？

完整的计算机系统由两部分组成，即计算机的硬件系统和软件系统。而计算机软件是指计算机系统中除硬件以外的所有事物，一般包括计算机程序、程序说明以及其他资料等。

软件工程专业是2002年国家教育部新增专业，随着计算机应用领域的拓展及中国经济建设的不断发展，软件工程专业已成为一个热门专业。

软件工程是采用工程的概念、原理、技术和方法来开发、维护软件，把管理技术与开发技术有效地结合起来，以计算机科学与技术学科为基础，强调软件开发的工程性，培养能够从事软件开发、测试、维护和软件项目管理的高级专门人才的一门学科。

如果把计算机软件比作积木，那么软件工程则相当于玩积木的高手。
软件工程学什么？

以浙江大学为例，软件工程专业的核心课程有：离散数学及其应用、数据结构基础、高级数据结构与算法分析、面向对象程序设计、计算机系统原理、数据库系统原理、操作系统原理、操作系统分析与实验、软件工程基础、计算机网络基础项目管理与案例分析、软件需求分析与设计、软件体系结构、人机交互工程。

除此之外，浙大软件工程专业还结合学院的科研和应用特色，开设了软件开发技术、金融信息技术、信息安全技术三个应用领域方向课程。各校软件工程专业根据培养体系、专业侧重等不同情况，课程设置也有所差异，考生可具体查看各校详细专业和课程设置情况。
计算机科学与技术专业与软件工程专业的区别

这两个专业都需要掌握计算机科学的基础知识及编程的基本功，但是这两个专业的关注点有很大不同。计算机专业学习技术，是为了改进技术，提高技术，研究出更好的理论。扎实地知道计算机底层是怎么工作的，才能研究出更好的计算机；而软件工程专业学习技术，是为了知道在什么情况下应该用什么样的技术可以最好地解决问题，更关注开发大型软件系统的组织方法和流程。

用建筑行业打比方：计算机专业研究物理、力学理论，研究新型材料；而软件工程专业则听取客户的盖房要求，选择合适的材料和技术，组织成百上千的工人把房子盖起来。两者工作的难度和重心是不同的。从同学们熟知的偶像角度打个比方，计算机专业仰慕图灵，而软件工程专业则仰慕盖茨和乔布斯。
社会上对这个专业的认识误区

有些人认为，学计算机相关的专业是青春饭，到了30多岁后就没有发展前途了，总不能一辈子就当个程序员吧？这是一个很大的认识误区。实际上，软件工程专业更关注开发大型软件系统的组织方法和流程，培养学生掌握大型软件开发和管理的能力，随着经验和能力的增长，他们更能胜任越来越大的项目的组织和管理，成为千百程序员的管理者。

还有人认为，现在懂编程的人太多了，凡是理工专业都学过编程，抓来就能用。但是，软件工程专业所掌握的大型软件开发的组织、设计和管理技术，不是普通的编程技术可以比拟的。打个比方说，普通的工人稍微训练一下，让他盖个猪圈、砌堵墙没问题，但是让他去造一个摩天大楼就不行了。而软件工程培养的是有能力设计和制造摩天大楼的人才。' comment '主办方',
    `prospects`         varchar(2048)       default '就业前景广阔

据阳光高考信息平台最新数据显示，软件工程专业的全国普通高校毕业生规模在55000人至60000人。最近三年，该专业的全国本科生就业率逐年递增，由80%增至95%，属于就业情况很好的专业。

软件产业作为信息产业的核心是国民经济信息化的基础，已经涉足工业、农业、商业、金融、科教文卫、国防和百姓生活等各个领域。采用先进的工程化方法进行软件开发和生产是实现软件产业化的关键技术手段。因此，为积极促进我国软件产业发展，加速我国信息化建设，增强其国际竞争力，急需培养大批软件工程领域的实用型、复合型软件工程技术人才和软件工程管理人才。

“相关数据显示，到2020年，整个中国新一代信息技术人才的需求，一年的缺口是750万人，而整个中国每年的大学毕业生也不过这个数字，但是其中计算机类专业的一共才30多万人。到2025年，这个缺口数字将达到950万。”东软睿道总裁李印杲在接受新商报记者采访时表示，目前，国内计算机软件类相关人才的需求非常巨大，随之产生的人才缺口也令人吃惊。

随着第五届世界互联网大会的召开，《世界互联网发展报告2018》《中国互联网发展报告2018》正式发布，报告显示，美国、中国、英国互联网发展名列全球前三名。从目前的形势来看，软件工程专业在未来多年内仍将是就业形势看好的专业。' comment '就业前景',
    `direction`         varchar(2048)    default '两大就业方向

软件工程专业的毕业生主要面向两类就业岗位：一类是各种规模的IT企业，从事项目管理、软件设计、软件开发和质量保证等相关岗位；另一类是进入到对IT技术依赖度很高的金融、电信等行业的IT部门，从事这些行业的业务软件的开发、测试、维护等相关工作。

例如，南京大学软件学院就业率连续多年100%，位居各院系前列，就业单位主要有Microsoft、Intel、百度、腾迅、阿里巴巴、华为、摩根士丹利等知名IT企业和金融类企业。85%以上的学生在上海、杭州、南京、苏州、深圳、北京等地就业。本科生平均入职年薪近20万。' comment '就业方向',
    `application_guide` varchar(2048)       default '招生院校多 看清培养目标

据统计，目前开设软件工程专业的院校580多所，分布在不同层次。在这些招生院校中，既有综合性大学，也有理工类院校，还有师范类院校。

不同院校软件工程专业方向有所不同，例如，华东师范大学软件工程专业有四个学习方向，分别为软件科学与技术方向、嵌入式软件与系统方向、数据科学与工程方向、密码与网络安全方向。这四个方向培养侧重点是不一样的，软件科学与技术方向旨在培养具有良好的软件科学与工程素养和开阔的国际视野，以及扎实的软件理论基础和软件设计与开发综合能力的高层次软件人才；数据科学与工程方向旨在培养具有服务国家基础战略研究事业胸怀、独立的研究创新能力和专业可持续发展潜力、参与国际学术竞争能力的、社会培养急需的“数据科学家”专业人才。再如，东南大学软件工程一级学科主要包括软件工程的理论与实践、可信软件、软件智能化、软件自动化、软件服务工程和软件建模与分析等六个主要学科方向。
按大类招生 分清专业方向

除了单独的专业招生形式以外，很多院校都以“计算机类”、“软件工程”的大类形式招生。按照计算机类大类招生的院校，如中央民族大学、北京理工大学、北京信息科技大学等；按照软件工程大类招生的院校，如南京大学、厦门大学、武汉大学、湖南大学等。考生报考时，最好看一下大类包含的专业方向再填报。

例如，北京理工大学“计算机类”包含计算机科学与技术、物联网工程、软件工程三个专业方向；厦门大学“软件工程”包含软件工程、数字媒体技术两个专业方向。

考生在选择时，一定要根据自己的爱好和需求，看清各高校的招生章程要求和专业设置情况。
什么样的学生适合学软件工程

据浙江大学计算机科学与技术学院蔡亮副教授介绍，从技术和兴趣的角度上看，如果喜欢搭积木（组装产品），但对于做积木块本身不是很有兴趣，那么会对软件工程专业很有兴趣。从个性和人生规划的角度上看，如果喜欢在商界叱咤风云的感觉，喜欢跟着一批志同道合的伙伴一起创业，喜欢与人沟通，那么会对软件工程专业很有兴趣。' comment '报考指南',

    primary key (`id`)

) engine = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='专业解读表';

alter table tb_major_interpretation
    add constraint tb_major_interpretation_tb_major_id_fk
        foreign key (tb_major_id) references tb_major (id);

DELIMITER //
CREATE PROCEDURE callback()
BEGIN
    DECLARE num INT;
    SET num = 2;
    WHILE
            num <= 200
        DO
            INSERT INTO tb_major_interpretation(tb_major_id) VALUES (num);
            SET num = num + 4;
        END WHILE;
END;
//
CALL callback();
DROP PROCEDURE callback;
