create database demos;
-- drop database users;
use demos;
create table users(
id int(3) auto_increment primary key,
name varchar(255) not null,
email varchar(255) not null,
country varchar(255)
);
insert into users(name, email, country) 
value('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) 
value('Kante','kante@che.uk','Kenia');