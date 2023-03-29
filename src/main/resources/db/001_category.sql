--liquibase formatted sql

--changeset nvoxland:1
create table category (
    id int primary key,
    title varchar(255),
    created timestamp,
    updated timestamp
);

