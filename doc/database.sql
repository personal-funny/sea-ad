CREATE TABLE `sea_ad_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `login_name` VARCHAR(64) NOT NULL COMMENT '用户登录名',
  `password` VARCHAR(128) NOT NULL COMMENT '用户密码',
  `salt` VARCHAR(128) NOT NULL COMMENT '用户盐',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_name` (`login_name`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
COMMENT '用户表，主要用于存储用户的安全认证信息';

CREATE TABLE `sea_ad_user_info` (
  `user_id` BIGINT(20) NOT NULL COMMENT '用户ID',
  `user_name` VARCHAR(64) NOT NULL COMMENT '用户姓名',
  `phone` VARCHAR(16) NOT NULL COMMENT '用户手机号码',
  PRIMARY KEY (`user_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
COMMENT '用户表，主要用于存储用户的详情信息';