CREATE TABLE IF NOT EXISTS Transaction (
    id INT NOT NULL,
    transaction_type VARCHAR(50) NOT NULL,
    transaction_category VARCHAR(50) NOT NULL,
    amount DOUBLE NOT NULL,
    date DATE NOT NULL,
    PRIMARY KEY (id)
    );