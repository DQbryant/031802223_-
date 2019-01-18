drop database users;
drop database test;
use ceshi;
create table user(
id int primary key auto_increment,
username varchar(10) not null default '',
password varchar(15) not null default '',
name char(4) not null,
gender char(1) not null default '男'，
phone varchar(15) not null default ''
)charset u