CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    version INT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS transactions (
    id INT NOT NULL,
    user_id INT NOT NULL,
    transaction_type VARCHAR(50) NOT NULL,
    transaction_category VARCHAR(50) NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    date DATE NOT NULL,
    version INT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
    );