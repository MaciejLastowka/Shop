--liquibase formatted sql

--changeset nvoxland:12

alter table if exists orders
  add column total_price numeric(19,2)

