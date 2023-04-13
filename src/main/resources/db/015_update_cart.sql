--liquibase formatted sql

--changeset nvoxland:15

 alter table if exists cart
       add constraint FK4pljlvncf45mr98etwpubxvbt
       foreign key (account_id)
       references account
