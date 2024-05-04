CREATE TABLE IF NOT EXISTS transactions (
    transactions_id UUID NOT NULL PRIMARY KEY,
    fromWallet_id UUID NOT NULL,
    toWallet_id UUID NOT NULL,
    transactionValue NUMERIC(10, 2) NOT NULL,
    status VARCHAR CHECK(status in ('CREATED', 'SUCCESS', 'CANCELED')) NOT NULL,
    createdAt DATE DEFAULT NOW(),
    updateAt DATE,
    FOREIGN KEY (fromWallet_id) REFERENCES wallets(wallets_id),
    FOREIGN KEY (toWallet_id) REFERENCES wallets(wallets_id)
);
