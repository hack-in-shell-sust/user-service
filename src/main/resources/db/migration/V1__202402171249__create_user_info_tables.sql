
CREATE TABLE user_info (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    date_of_birth DATE,
    weight DECIMAL(5,2),
    height DECIMAL(5,2),
    description TEXT
);

CREATE SEQUENCE user_info_seq START 1;
