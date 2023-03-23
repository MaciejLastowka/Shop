--liquibase formatted sql

--changeset nvoxland:4

    alter table product
       add constraint FK1mtsbur82frn64de7balymq9s
       foreign key (category_id)
       references category