   --liquibase formatted sql

   --changeset nvoxland:12

alter table if exists products
       add constraint FKak0nhkem4wfrvo4c7lv2iq5jf
       foreign key (order_line_item_id)
       references orderlineitem