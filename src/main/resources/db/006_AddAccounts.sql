--liquibase formatted sql

--changeset nvoxland:6
    INSERT INTO Account (id, name) VALUES (1, 'Bartek');
    INSERT INTO Account (id, name) VALUES (2, 'Maciek');
    INSERT INTO Account (id, name) VALUES (3, 'Paweł');