drop database if exists shop_online1;
create database if not exists shop_online1;
use shop_online1;

CREATE TABLE `app_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_deleted` bit(1) DEFAULT b'0',
  `role_name` varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
);
CREATE TABLE `app_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL ,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_deleted` bit(1) DEFAULT b'0',
  `role_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  FOREIGN KEY (`role_id`) REFERENCES `app_role` (`id`)
);

CREATE TABLE `category` (
	`id` int not null auto_increment,
    `is_deleted` bit(1) DEFAULT b'0',
    `name` varchar(255),
	PRIMARY KEY (`id`)
);

CREATE TABLE `customer` (
	`id` int not null auto_increment,
    `is_deleted` bit(1) DEFAULT b'0',
    `name` varchar(255),
    `phone_number` varchar(255),
    `address` text,
    `image` text,
    `status` bit(1) DEFAULT b'0',
    `email` varchar(255),
    `user_id` int unique,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`)
);

CREATE TABLE `promotion` (
	`id` int not null auto_increment,
    `is_deleted` bit(1) DEFAULT b'0',
    `name` varchar(255),
	PRIMARY KEY (`id`)
);

CREATE TABLE `product` (
	`id` int not null auto_increment,
    `is_deleted` bit(1) DEFAULT b'0',
    `name` varchar(255),
    `operating_system` varchar(255),
    `cpu` varchar(255),
    `ram` varchar(255),
    `camera` varchar(255),
    `screen_resolution` varchar(255),
    `release_time` date,
    `graphic_card` varchar(255),
    `price` double,
    `real_price` double,
    `description` text,
    `image` text,
    `category_id` int,
    `promotion_id` int,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
    FOREIGN KEY (`promotion_id`) REFERENCES `promotion` (`id`)
);

CREATE TABLE `coupon` (
	`id` int not null auto_increment,
    `is_deleted` bit(1) DEFAULT b'0',
    `name` varchar(255),
    `discount_percent` int,
    `product_id` int,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
);

CREATE TABLE `bill` (
	`id` int not null auto_increment,
    `is_deleted` bit(1) DEFAULT b'0',
    `name` varchar(255),
	PRIMARY KEY (`id`)
);

CREATE TABLE `feedback` (
	`id` int not null auto_increment,
    `is_deleted` bit(1) DEFAULT b'0',
    `content` varchar(255),
    `feedback_date` date,
    `image` text,
    `rate` int,
    `bill_id` int,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`)
);

CREATE TABLE `order` (
	`id` int not null auto_increment,
    `is_deleted` bit(1) DEFAULT b'0',
    `quantity` int,
    `customer_id` int,
    `product_id` int,
    `bill_id` int,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
    FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
    FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`)
);


use shop_online;

INSERT INTO `app_role` (`role_name`) VALUES ('ROLE_ADMIN');
INSERT INTO `app_role` (`role_name`) VALUES ('ROLE_USER');

INSERT INTO `app_user` (`password`, `user_name`) VALUES ('$2a$10$CqdLCRz4f8HGTqmChZQ9q.5brX6Ry.If8q8D9dYS1gOF1rnUSCmiq', 'admin');
INSERT INTO `app_user` (`password`, `user_name`) VALUES ('$2a$10$CqdLCRz4f8HGTqmChZQ9q.5brX6Ry.If8q8D9dYS1gOF1rnUSCmiq', 'user');

INSERT INTO `user_role` (`role_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `user_role` (`role_id`, `user_id`) VALUES ('2', '2');

INSERT INTO `category` (`name`, `image`) VALUES ('Điện thoại', 'https://firebasestorage.googleapis.com/v0/b/marine-equinox-236204.appspot.com/o/xiaomi.jpg?alt=media&token=f34e8328-18e0-4d5f-8406-b32f8e929b97');
INSERT INTO `category` (`name`, `image`) VALUES ('Xe điện', 'https://firebasestorage.googleapis.com/v0/b/marine-equinox-236204.appspot.com/o/xedien.jpg?alt=media&token=89a76d60-3304-4ad0-a1a5-a1e49fc9148e');
INSERT INTO `category` (`name`, `image`) VALUES ('Robot hút bụi', 'https://firebasestorage.googleapis.com/v0/b/marine-equinox-236204.appspot.com/o/robothutbui.jpg?alt=media&token=b9f160e9-5f0e-4451-a3da-865f3b5a5489');
INSERT INTO `category` (`name`, `image`) VALUES ('Máy lọc không khí', 'https://firebasestorage.googleapis.com/v0/b/marine-equinox-236204.appspot.com/o/may-loc-khong-khi-xiaomi-1.jpg?alt=media&token=5700a66e-a773-423c-9dc8-d49a40af6670');
INSERT INTO `category` (`name`, `image`) VALUES ('Camera an ninh', 'https://firebasestorage.googleapis.com/v0/b/marine-equinox-236204.appspot.com/o/cameraanninh.jpg?alt=media&token=f0b8881f-c9ab-44ea-91c2-25ee1b87de80');
INSERT INTO `category` (`name`, `image`) VALUES ('Máy lọc nước', 'https://firebasestorage.googleapis.com/v0/b/marine-equinox-236204.appspot.com/o/maylocnuoc.jpg?alt=media&token=24fb9459-d366-4e87-8440-c80cfbc0af84');
