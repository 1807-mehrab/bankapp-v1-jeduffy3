CREATE TABLE account (
    account_id INTEGER PRIMARY KEY,
    account_balance VARCHAR2(10),
    first_name VARCHAR2(20),
    last_name VARCHAR2(20)
);

SELECT * FROM ACCOUNT;
/*
CREATE TABLE account_user (
    user_id INTEGER PRIMARY KEY,
    first_name VARCHAR2(20),
    last_name VARCHAR2(20),
    address_id INTEGER
);

CREATE TABLE account_address (
    address_id INTEGER PRIMARY KEY,
    street VARCHAR2(20),
    city VARCHAR2(20),
    state VARCHAR2(20),
    zip VARCHAR2(5)
);

ALTER TABLE account ADD CONSTRAINT FK_user_id
FOREIGN KEY (user_id)
REFERENCES account_user (user_id);

ALTER TABLE account_user ADD CONSTRAINT FK_address_id
FOREIGN KEY (address_id)
REFERENCES account_address (address_id); */

-- Sequence
CREATE SEQUENCE SQ_ACCOUNT_PK START WITH 3 INCREMENT BY 1;
/*
CREATE SEQUENCE SQ_USER_PK START WITH 3 INCREMENT BY 1;
CREATE SEQUENCE SQ_ADDRESS_PK START WITH 3 INCREMENT BY 1;
*/
-- Trigger (before insert, use sequence)
CREATE OR REPLACE TRIGGER TR_INSERT_ACCOUNT
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
    SELECT SQ_ACCOUNT_PK.NEXTVAL INTO :NEW.account_id FROM DUAL;
END;
/
/*
CREATE OR REPLACE TRIGGER TR_INSERT_USER
BEFORE INSERT ON account_user
FOR EACH ROW
BEGIN
    SELECT SQ_USER_PK.NEXTVAL INTO :NEW.user_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_ADDRESS
BEFORE INSERT ON account_address
FOR EACH ROW
BEGIN
    SELECT SQ_ADDRESS_PK.NEXTVAL INTO :NEW.address_id FROM DUAL;
END;
/

INSERT INTO account_address (address_id, street, city, state, zip)
VALUES (1, '815 Bering Street', 'Arlington', 'Texas', '64548');
INSERT INTO account_address (address_id, street, city, state, zip)
VALUES (2, '555 Fake Drive', 'Miami', 'Florida', '26457');

INSERT INTO account_user (user_id, first_name, last_name, address_id)
VALUES (1, 'John', 'Doe', 1);
INSERT INTO account_user (user_id, first_name, last_name, address_id)
VALUES (2, 'Jane', 'Smith', 2);
*/

INSERT INTO account (account_id, account_balance, first_name, last_name)
VALUES (1, '150.00', 'Joe', 'Smith');
INSERT INTO account (account_id, account_balance, first_name, last_name)
VALUES (2, '150.00', 'John', 'Doe');

SELECT * FROM ACCOUNT;


COMMIT;