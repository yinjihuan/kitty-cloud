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
    update_time datetime not null comment '更新时间',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment='用户';

create table article(
    id bigint(20) not null auto_increment,
    type varchar(20) not null comment '文章类型(原创,转载,翻译)',
    title varchar(50) not null comment '标题',
    status tinyint(1) not null DEFAULT 1 comment '是否可见',
    visitCount int(11) not null DEFAULT 0 comment '访问次数',
    addTime datetime not null comment '添加时间',
    userId int(11) not null DEFAULT 0 comment '用户ID',
    tags varchar(100) not null comment 'tags',
    content text not null comment '内容',
    contentStr text not null comment '纯文字内容',
    webType varchar(10) not null DEFAULT 'web' comment '编辑器类型(web,markdown)',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='文章表';