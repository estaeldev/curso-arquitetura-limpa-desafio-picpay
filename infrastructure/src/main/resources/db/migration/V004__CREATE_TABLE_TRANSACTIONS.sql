CREATE TABLE IF NOT EXISTS transactions (
    transaction_id UUID NOT NULL PRIMARY KEY,
    from_wallet_id UUID NOT NULL,
    to_wallet_id UUID NOT NULL,
    transaction_value NUMERIC(10, 2) NOT NULL,
    status VARCHAR CHECK(status in ('CREATED', 'SUCCESS', 'CANCELED')) NOT NULL,
    createdAt DATE DEFAULT NOW(),
    updatedAt DATE,
    FOREIGN KEY (from_wallet_id) REFERENCES wallets(wallet_id),
    FOREIGN KEY (to_wallet_id) REFERENCES wallets(wallet_id)
);
