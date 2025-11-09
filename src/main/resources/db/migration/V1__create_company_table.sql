CREATE TABLE company
(
    id                             BIGSERIAL PRIMARY KEY,
    employer_identification_number VARCHAR(255),
    name                           VARCHAR(255) NOT NULL,
    structure                      VARCHAR(50),
    email                          VARCHAR(255),
    phone_number                   VARCHAR(50),
    is_active                      BOOLEAN      NOT NULL
);