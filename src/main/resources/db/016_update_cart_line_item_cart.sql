--liquibase formatted sql

--changeset nvoxland:16

    alter table if exists cart_line_item
       add constraint FKc81uybcncl96vet9380wa6y5
       foreign key (cart_id)
       references cart