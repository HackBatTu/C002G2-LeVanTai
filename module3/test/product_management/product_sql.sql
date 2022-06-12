create database product_management;
use product_management;
-- drop database product_management;
create table category(
category_id int auto_increment primary key,
category_name varchar(45),
status bit(1) default 0);

create table product(
product_id int auto_increment primary key,
product_name varchar(45),
price double,
quantity int,
color varchar(255),
category_id int ,
foreign key(category_id) references category(category_id),
status bit(1) default 0) ;

insert into category(category_id,category_name)
value (1,'phone'),(2,'television');

insert into product(product_id,product_name,price,quantity,color,category_id)
value
(1,'iPhone 11',799.0,12,'Green, Yellow, Purple',1),
(2,'iPhone 11 Pro',1100.0,12,'Green, Black, white',1),
(3,'iPhone X',749.0,13,'Coral,black,blue',1),
(4,'Smart TV 4K UHD 49in',10000000,5,'black',2),
(5,'Samsung Galaxy s10 E',420.0,10,'Prism White,Ceramic Black',1);
