drop database quan_li_ban_hang;
create database quan_li_ban_hang;
use quan_li_ban_hang;
create table customer(
customer_id int primary key,
customer_name varchar(255),
customer_age int);
create table orders(
order_id int primary key,
customer_id int,
foreign key (customer_id) references customer(customer_id),
date_order date,
order_total_price double
);
create table product(
product_id int primary key,
product_name varchar(255),
product_prince double);
create table order_detail(
order_id int,
product_id int,
primary key ( order_id,product_id),
foreign key (order_id) references orders(order_id),
foreign key (product_id) references product(product_id),
order_qty int);