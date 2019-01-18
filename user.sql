create database user;
use user;
create table user(
id smallint,
name char(4) not null,
gender char(1) not null default '男',
username varchar(10) not null default '',
password varchar(15) not null default '',
phone varchar(15) not null default ''
)engine MyISAM char set utf8mb4;
insert into user value
(1,'用户1','男','root1','root1','110'),
(2,'用户2','女','toot2','root2','119');