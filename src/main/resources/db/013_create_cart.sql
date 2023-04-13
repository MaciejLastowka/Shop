
--liquibase formatted sql

--changeset nvoxland:13


    create table cart (
       id int8 not null,
        total_amount numeric(19, 2),
        account_id int8,
        primary key (id)
    )