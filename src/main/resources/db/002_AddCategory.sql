--liquibase formatted sql

--changeset nvoxland:2
    INSERT INTO category (id, title) VALUES (1, 'MOTORYZACJA');
    INSERT INTO category (id, title) VALUES (2, 'ELEKTRO');
    INSERT INTO category (id, title) VALUES (3, 'DOM');

