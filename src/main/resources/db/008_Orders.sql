--liquibase formatted sql

--changeset nvoxland:8

    alter table if exists orders
        add constraint FK3c7gbsfawn58r27cf5b2km72f
        foreign key (account_id)
        references account