--liquibase formatted sql

--changeset nvoxland:1
create table category (
    id int primary key,
    name varchar(255)
);