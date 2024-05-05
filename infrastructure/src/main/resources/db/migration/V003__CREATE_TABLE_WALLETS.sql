CREATE TABLE IF NOT EXISTS wallets (
    wallet_id UUID NOT NULL PRIMARY KEY,
    transaction_pin_id UUID NOT NULL UNIQUE,
    balance NUMERIC(10, 2) NOT NULL,
    user_id UUID NOT NULL UNIQUE,
    createdAt DATE DEFAULT NOW(),
    updatedAt DATE,
    FOREIGN KEY (transaction_pin_id) REFERENCES transactions_pin(transaction_pin_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
