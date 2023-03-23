--liquibase formatted sql

--changeset nvoxland:2
    INSERT INTO category (id, name) VALUES (1, 'MOTO');
    INSERT INTO category (id, name) VALUES (2, 'ELEKTRO');
    INSERT INTO category (id, name) VALUES (3, 'DOM');

