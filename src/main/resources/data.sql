-- CREATE TABLE person
-- (
--     id         INTEGER      NOT NULL,
--     name       VARCHAR(255) NOT NULL,
--     location   VARCHAR(255),
--     birth_date TIMESTAMP,
--     PRIMARY KEY (id)
-- );

INSERT INTO person (id, name, location, birth_date)
VALUES (10001, 'Ranga', 'Hyderabad', sysdate()),
       (10002, 'James', 'New York', sysdate()),
       (10003, 'Pieter', 'Amsterdam', sysdate());

