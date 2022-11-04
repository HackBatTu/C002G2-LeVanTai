drop database if exists c0222g2_coffee;
create database c0222g2_coffee;
use c0222g2_coffee;

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
CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL UNIQUE,
  `creation_date` date DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
);
CREATE TABLE `coffee_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL UNIQUE,
  `is_deleted` bit(1) DEFAULT b'0',
  `is_empty` bit(1) DEFAULT b'0',
  `status` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
);
CREATE TABLE `dish_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL UNIQUE,
  `is_deleted` bit(1) DEFAULT b'0',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `dish` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL UNIQUE,
  `creation_date` date DEFAULT NULL,
  `image` text,
  `is_deleted` bit(1) DEFAULT b'0',
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `dish_type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`dish_type_id`) REFERENCES `dish_type` (`id`)
);
CREATE TABLE `position` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `image` text,
  `is_deleted` bit(1) DEFAULT b'0',
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL UNIQUE,
  `salary` double DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  FOREIGN KEY (`position_id`) REFERENCES `position` (`id`)
);
CREATE TABLE `dish_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `quantity` int DEFAULT NULL,
  `bill_id` int DEFAULT NULL,
  `coffee_table_id` int DEFAULT NULL,
  `dish_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`),
  FOREIGN KEY (`dish_id`) REFERENCES `dish` (`id`),
  FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  FOREIGN KEY (`coffee_table_id`) REFERENCES `coffee_table` (`id`)
);
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `content` text,
  `creator` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `feedback_date` varchar(255) DEFAULT NULL,
  `image` text,
  `is_deleted` int DEFAULT '0',
  `rating` int NOT NULL,
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


