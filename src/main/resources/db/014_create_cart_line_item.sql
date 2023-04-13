--liquibase formatted sql

--changeset nvoxland:14


    create table cart_line_item (
       id int8 not null,
        cart_index int4 not null,
        quantity int4 not null,
        cart_id int8,
        product_id int8,
        primary key (id)
    )