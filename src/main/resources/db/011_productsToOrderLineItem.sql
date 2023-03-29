   --liquibase formatted sql

   --changeset nvoxland:11

create table products (
       id int8 not null,
        created timestamp,
        description varchar(255),
        price numeric(19, 2),
        title varchar(255),
        updated timestamp,
        category_id int8 not null,
        order_line_item_id int8,
        primary key (id)
    )
