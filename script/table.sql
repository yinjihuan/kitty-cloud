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