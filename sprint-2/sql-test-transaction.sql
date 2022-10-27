create database test;
use test;
CREATE TABLE bankaccounts(
accountno varchar(20) PRIMARY KEY NOT NULL,
 funds decimal(8,2));
 
INSERT INTO bankaccounts VALUES("ACC1", 1000);
INSERT INTO bankaccounts VALUES("ACC2", 1000);

START TRANSACTION;
UPDATE bankaccounts SET funds=funds-100 WHERE accountno='ACC1'; 
UPDATE bankaccounts SET funds=funds+100 WHERE accountno='ACC2'; 
COMMIT; 
select * from bankaccounts;

START TRANSACTION;
DELETE FROM bankaccounts
WHERE accountno='ACC1';
ROLLBACK;
select * from bankaccounts;

SAVEPOINT SP1;
Savepoint created;
DELETE FROM bankaccounts WHERE accountno='ACC1';

SAVEPOINT SP2;
Savepoint created;
DELETE FROM bankaccounts WHERE accountno='ACC2';

ROLLBACK TO SP2;
ROLLBACK TO SP1;


