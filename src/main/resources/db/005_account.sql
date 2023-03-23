 --liquibase formatted sql

 --changeset nvoxland:5

 create table account (
       id int8 not null,
        created timestamp,
        name varchar(255),
        updated timestamp,
        primary key (id)
    )