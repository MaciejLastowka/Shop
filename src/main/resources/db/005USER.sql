--liquibase formatted sql

--changeset nvoxland:5

    create table account (
       id int8 not null,
       category_id int8 not null,
       description varchar(255),
       price numeric(19, 2),
       title varchar(255),
       created timestamp,
       updated timestamp,
       primary key (id)
    )

