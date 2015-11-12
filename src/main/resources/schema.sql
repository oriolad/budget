CREATE TABLE BUDGET_TRANSACTION (
    BUDGET_ID INT PRIMARY KEY  NOT NULL,
    TRANSACTION_DATE DATE NOT NULL,
    PAYEE CHAR(50) NOT NULL,
    MEMO CHAR(50),
    TRANSACTION_AMT REAL NOT NULL,
    TRANSACTION_TYPE CHAR(6) NOT NULL
);

