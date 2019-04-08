create database if not exists tang_poem;

use tang_poem;

create table if not exists tang_poem_info(
    Title varchar(64) not null,
    Dynasty varchar(32) not null,
    Author varchar(32) not null,
    Content varchar(1024) not null
);