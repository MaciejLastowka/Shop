--liquibase formatted sql

--changeset nvoxland:7

create table orders (
       id int8 not null,
       total_price numeric(19, 2),
        account_id int8 not null,
        primary key (id)
    )