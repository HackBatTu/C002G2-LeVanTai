create database case_study_3;
use case_study_3;
create table role(
role_id int auto_increment primary key,
role_name varchar(255),
`status` bit(1) default 0);
create table user(
username varchar(255) primary key ,
`password` varchar(255),
`status` bit(1) default 0);
create table user_role(
role_id int,
username varchar(255),
`status` bit(1) default 0 ,
foreign key(role_id) REFERENCES role(role_id),
foreign key(username) references user(username));
create table positions(
positions_id int auto_increment primary key,
positions_name varchar(45),
`status` bit(1) default 0);
create table education_degree (
education_degree_id int auto_increment primary key,
education_degree_name varchar(45),
`status` bit(1) default 0);
create table division (
division_id int auto_increment primary key,
division_name varchar(45),
`status` bit(1) default 0);
create table employee (
employee_id int auto_increment primary key,
employee_name varchar(255),
employee_birthday date,
employee_id_card varchar(255),
employee_salary double,
employee_phone varchar(255),
employee_email varchar(255),
employee_address varchar(255),
positions_id int,
education_degree_id int,
division_id int,
username varchar(255),
foreign key(positions_id) REFERENCES positions(positions_id),
foreign key(education_degree_id) references education_degree(education_degree_id),
foreign key (division_id) references division(division_id),
foreign key(username) references user(username),
`status` bit(1) default 0
);
create table customer_type(
customer_type_id int auto_increment primary key,
customer_type_name varchar(255),
`status` bit(1) default 0);
create table customer(
customer_id int auto_increment primary key,
customer_type_id int,
foreign key(customer_type_id) references customer_type(customer_type_id),
customer_name varchar(255),
customer_birthday date,
customer_gender bit(1),
customer_id_card varchar(255),
customer_phone varchar(255),
customer_email varchar(255),
customer_address varchar(255),
`status` bit(1) default 0);
create table rent_type(
rent_type_id int auto_increment primary key,
rent_type_name varchar(255),
`status` bit(1) default 0);
create table service_type(
service_type_id int auto_increment primary key,
service_type_name varchar(255),
`status` bit(1) default 0);
create table service(
service_id int auto_increment primary key,
service_name varchar(255),
service_area int,
service_cost double,
service_max_person int,
room_standard varchar(255),
another_convenient varchar(255),
pool_area double,
number_of_floors int,
rent_type_id int,
service_type_id int,
foreign key(rent_type_id) references rent_type(rent_type_id),
foreign key(service_type_id) references service_type(service_type_id),
`status` bit(1) default 0
);
create table attach_service(
attach_service_id int auto_increment primary key,
attach_service_name varchar(255),
attach_service_cost double,
attach_service_unit varchar(255),
attach_service_status varchar(255),
`status` bit(1) default 0);
create table contract (
contract_id int auto_increment primary key,
date_check_in datetime,
date_check_out datetime,
contract_depost double,
contract_total_money double,
employee_id int,
customer_id int,
service_id int,
foreign key(employee_id) references employee(employee_id),
foreign key(customer_id) references customer(customer_id),
foreign key(service_id) references service(service_id),
`status` bit(1) default 0);
create table details_contract(
details_contract_id int auto_increment primary key,
contract_id int,
attach_service_id int,
foreign key(contract_id) references contract(contract_id),
foreign key(attach_service_id) references attach_service(attach_service_id),
number_contract int,
`status` bit(1) default 0);
