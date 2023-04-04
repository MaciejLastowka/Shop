   --liquibase formatted sql

   --changeset nvoxland:11

   alter table if exists orderlineitem
       add constraint FKb5028ommnx85ptyl5rvfhdcc5
       foreign key (product_id)
       references product

