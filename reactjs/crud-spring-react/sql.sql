create database employee_management;
use employee_management;
create table employee(
id bigint primary key auto_increment,
email varchar(255),
first_name varchar(255),
last_name varchar(255)
);
INSERT INTO `employee_management`.`employee` (`id`, `email`, `first_name`, `last_name`) VALUES (1, 'levantai1496@gmail.com', 'Lê Văn', 'Tài');
INSERT INTO `employee_management`.`employee` (`id`, `email`, `first_name`, `last_name`) VALUES (2, 'hackbattu', 'HACK', 'BẤT TỬ');


drop table employee;