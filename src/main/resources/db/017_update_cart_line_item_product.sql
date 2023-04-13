
--liquibase formatted sql

--changeset nvoxland:17

    alter table if exists cart_line_item
       add constraint FKdv9ak3oxi556vc1voyc2927na
       foreign key (product_id)
       references product