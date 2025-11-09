CREATE TABLE company_locations
(
    id             BIGSERIAL PRIMARY KEY,
    first_address  VARCHAR(255),
    second_address VARCHAR(255),
    city           VARCHAR(100),
    province       VARCHAR(100),
    country        VARCHAR(100),
    company_id     BIGINT,
    CONSTRAINT fk_company_locations_company
        FOREIGN KEY (company_id)
            REFERENCES company (id)
            ON DELETE CASCADE
);
