create database if not exists tang_poem;

use tang_poem;

create table if not exists tang_poem_info(
    title varchar(64) not null,
    dynasty varchar(32) not null,
    author varchar(32) not null,
    content varchar(1024) not null
);