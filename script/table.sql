create table `user`(
    id bigint(20) not null,
    nickname varchar(20) not null comment '昵称',
    pass varchar(200) not null comment '密码',
    status tinyint(1) not null comment '状态',
    mobile varchar(11) null comment '手机',
    email varchar(30) not null comment '邮箱',
    sex tinyint(1) not null comment '性别',
    age int(11) not null comment '年龄',
    sign varchar(100) null comment '个性签名',
    head_photo_url varchar(100) null comment '头像',
    add_time datetime not null comment '添加时间',
    update_time datetime not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment='用户';

create table article(
    id bigint(20) not null auto_increment,
    type varchar(20) not null comment '文章类型(原创,转载,翻译)',
    title varchar(50) not null comment '标题',
    status tinyint(1) not null DEFAULT 1 comment '是否可见',
    visit_count int(11) not null DEFAULT 0 comment '访问次数',
    userId bigint(20) not null comment '用户ID',
    tags varchar(100) not null comment '标签',
    content longtext not null comment '内容（包含HTML）',
    text_content text not null comment '文本内容',
    heat int(11) not null comment '热度值（点赞数+评论数+访问数）',
    add_time datetime not null comment '添加时间',
    update_time datetime not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='文章表';