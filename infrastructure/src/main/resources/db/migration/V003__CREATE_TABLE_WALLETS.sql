CREATE TABLE IF NOT EXISTS wallets (
    wallets_id UUID NOT NULL PRIMARY KEY,
    transactions_pin_id UUID NOT NULL UNIQUE,
    balance NUMERIC(10, 2) NOT NULL,
    users_id UUID NOT NULL UNIQUE,
    createdAt DATE DEFAULT NOW(),
    updateAt DATE,
    FOREIGN KEY (transactions_pin_id) REFERENCES transactions_pin(transactions_pin_id),
    FOREIGN KEY (users_id) REFERENCES users(users_id)
);
