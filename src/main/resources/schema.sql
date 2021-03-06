DROP TABLE IF EXISTS CREDIT_CARD_ACCOUNTS;

CREATE TABLE CREDIT_CARD_ACCOUNTS(
    ID int not null AUTO_INCREMENT,
    ACCOUNT_ID varchar(255),
    ACCOUNT_NUMBER varchar(255),
    ACCOUNT_TYPE varchar(255),
    ACCOUNT_STATUS varchar(255),
    primary key (id)
)