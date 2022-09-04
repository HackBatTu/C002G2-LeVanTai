create database shop_online;
use shop_online;
CREATE TABLE `app_role` (
  `id` int auto_increment primary key,
  `is_deleted` bit(1) default b'0',
  `role_name` varchar(255) not null
);

CREATE TABLE `app_user` (
  `id` int auto_increment primary key,
  `creation_date` date default null,
  `is_deleted` bit(1) default b'0',
  `password` varchar(255) not null,
  `user_name` varchar(255) not null 
);

CREATE TABLE `user_role` (
  `id` int auto_increment primary key,
  `is_deleted` bit(1) default b'0',
  `role_id` int default null,
  `user_id` int default null,
  foreign key (`user_id`) references `app_user` (`id`),
  foreign key (`role_id`) references `app_role` (`id`)
);

create table customer (
id int auto_increment primary key,
name varchar(255),
email varchar(255),
`is_deleted` bit(1) default b'0',
`user_id` int default null,
foreign key (`user_id`) references `app_user` (`id`)
);

create table category (
id int auto_increment primary key,
name varchar(255)
);

create table product (
id int auto_increment primary key,
name varchar(255),
image varchar(255),
description text,
price double,
`is_deleted` bit(1) default b'0',
`category_id` int default null,
foreign key (`category_id`) references `category` (`id`)
);

create table feedback (
id int auto_increment primary key,
content text,
feedback_date date,
rating int,
`is_deleted` bit(1) default b'0',
`customer_id` int default null,
foreign key (`customer_id`) references `customer` (`id`)
);

create table `order` (
id int auto_increment primary key,
creation_date date,
quantity int,
`is_deleted` bit(1) default b'0',
`product_id` int default null,
`customer_id` int default null,
foreign key (`product_id`) references `product` (`id`),
foreign key (`customer_id`) references `customer` (`id`)
);