 --liquibase formatted sql

 --changeset nvoxland:9

create table orderlineitem (
       id int8 not null,
        amount int8,
        product_id int8,
        order_id int8 not null,
        primary key (id)
    )