drop table if exists users_info;
CREATE TABLE users_info (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    date_of_birth DATE,
    weight DECIMAL(5,2),
    height DECIMAL(5,2),
    description TEXT
);


CREATE SEQUENCE users_info_seq START 1;
