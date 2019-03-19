--create database if not exists everything;
drop table if exists Everything_index;
create table if not  exists Everything_index
(
name varchar (256) not null comment '文件名称',
path varchar(1024) not null comment '文件路径',
depth int not null comment'文件深度',
file_type varchar (32) not null  comment'文件类型'
);
