CREATE TABLE IF NOT EXISTS users (
    users_id UUID NOT NULL PRIMARY KEY,
    email VARCHAR NOT NULL UNIQUE,
    taxnumber VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    fullname VARCHAR NOT NULL,
    type VARCHAR CHECK(type in ('USER', 'SHOPKEEPER')) NOT NULL,
    transactions_pin_id UUID NOT NULL,
    createdAt DATE DEFAULT NOW(),
    updateAt DATE,
    FOREIGN KEY (transactions_pin_id) REFERENCES transactions_pin(transactions_pin_id)
);
