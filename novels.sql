create database Novels;
use Novels;
create table novels(
书名 varchar(20) not null default '',
作者 varchar(20) not null default '',
简介 varchar(300) not null default '',
照片 varchar(300) not null default ''
)engine MyISAM char set utf8mb4;