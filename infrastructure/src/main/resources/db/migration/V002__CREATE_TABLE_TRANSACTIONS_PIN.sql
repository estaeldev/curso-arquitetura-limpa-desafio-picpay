CREATE TABLE IF NOT EXISTS transactions_pin (
    transaction_pin_id UUID NOT NULL PRIMARY KEY,
    pin VARCHAR NOT NULL,
    attempt INT NOT NULL,
    blocked BOOLEAN NOT NULL,
    createdAt DATE DEFAULT NOW(),
    updatedAt DATE
);
