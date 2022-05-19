create database demo;
-- drop database demo;
use demo;
create table products(
id int primary key,
product_code int,
product_name varchar(20),
product_prince double,
product_amount int,
product_description varchar(55),
product_status bit(1) default 0);

insert into products(id,product_code,product_name,product_prince,product_amount,product_description)
value 
(1,11,'xe đạp',10000,5,'màu hồng'),
(2,21,'xe máy',20000,5,'màu trắng'),
(3,31,'moto',30000,5,'màu hồng'),
(4,41,'tàu thủy',40000,5,'màu trắng'),
(5,51,'máy bay',50000,5,'màu hồng');

-- 1.index
explain select * from products ;
create unique index unique_index on products(product_code);
create index composite_index on products(product_name,product_prince);
-- drop index unique_index ;
-- drop index composite_index ;
explain select * from products ;

-- 2.view
create view view_products as
select product_code,product_name,product_prince,product_status from products;

SELECT * FROM view_products ;

update view_products
set product_name = 'xxx'
where product_code = 0;

delete from view_products
where product_code = 0;

drop view view_products;

-- 3.store procedure
delimiter //
create procedure procedure_products()
begin 
	select * from products;
end //
delimiter ;
call procedure_products();

insert into products
value (6,61,'tên lửa',100000,5,'màu đỏ',0);

update products
set product_name = 'xe đạp'
where id = 2;

delete from products
where id = 3;

