CREATE TABLE IF NOT EXISTS users (
    user_id UUID NOT NULL PRIMARY KEY,
    email VARCHAR NOT NULL UNIQUE,
    taxnumber VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    fullname VARCHAR NOT NULL,
    type VARCHAR CHECK(type in ('USER', 'SHOPKEEPER')) NOT NULL,
    createdAt DATE DEFAULT NOW(),
    updatedAt DATE
);
