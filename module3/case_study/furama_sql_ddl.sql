create database case_study_3;
-- drop database case_study_3;
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
foreign key(role_id) REFERENCES role(role_id),
foreign key(username) references user(username),
`status` bit(1) default 0);
create table employee_position(
employee_position_id int auto_increment primary key,
employee_position_name varchar(45),
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
employee_position_id int,
education_degree_id int,
division_id int,
username varchar(255),
foreign key(employee_position_id) REFERENCES employee_position(employee_position_id),
foreign key(education_degree_id) references education_degree(education_degree_id),
foreign key (division_id) references division(division_id),
foreign key(username) references user(username),
`status` bit(1) default 0
);
create table customer_type(
customer_type_id int auto_increment primary key,
customer_type_name varchar(255),
`status` bit(1) default 0
);
create table customer(
customer_id int auto_increment primary key,
customer_type_id int,
foreign key(customer_type_id) references customer_type(customer_type_id),
customer_name varchar(255),
customer_birthday date,
customer_gender int,
customer_id_card varchar(255),
customer_phone varchar(255),
customer_email varchar(255),
customer_address varchar(255),
`status` bit(1) default 0
);
create table rent_type(
rent_type_id int auto_increment primary key,
rent_type_name varchar(255),
`status` bit(1) default 0
);
create table service_type(
service_type_id int auto_increment primary key,
service_type_name varchar(255),
`status` bit(1) default 0
);
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
`status` bit(1) default 0
);
create table contract (
contract_id int auto_increment primary key,
date_check_in datetime,
date_check_out datetime,
contract_deposit double,
contract_total_money double,
employee_id int,
customer_id int,
service_id int,
foreign key(employee_id) references employee(employee_id),
foreign key(customer_id) references customer(customer_id),
foreign key(service_id) references service(service_id),
`status` bit(1) default 0
);
create table details_contract(
details_contract_id int auto_increment primary key,
number_contract int,
contract_id int,
attach_service_id int,
foreign key(contract_id) references contract(contract_id),
foreign key(attach_service_id) references attach_service(attach_service_id),
`status` bit(1) default 0
);

-- insert table
insert into role(role_id,role_name) value (1,'admin'),(2,'member');
insert into user(username,password) value ('admin','admin'),('member','member');
insert into user_role(role_id,username) value (1,'admin'),(2,'member');
insert into employee_position(employee_position_id,employee_position_name)
value (1,'Quản Lí'),(2,'Nhân Viên');

insert into education_degree(education_degree_id,education_degree_name)
value (1,'Trung Cấp'),(2,'Cao Đẳng'),(3,'Đại Học'),(4,'Sau Đại Học');

insert into division(division_id,division_name)
value (1,'Sale-Marketing'),(2,'Hành Chính'),(3,'Phục vụ'),(4,'Quản lý');

insert into employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,employee_position_id,education_degree_id,division_id,username)
value 
(1,'Nguyễn Văn An','1970-11-07','456231786',10000000,0901234121,'annguyen@gmail.com','295 Nguyễn Tất Thành,Đà Nẵng',1,3,1,'admin'),
(2,'Lê Văn Bình','1997-04-09','654231234',7000000,0934212314,'binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2,'member'),
(3,'Hồ Thị Yến','1995-12-12','999231723',14000000,0412352315,'thiyen@gmail.com','K234/11 Điện Biên Phủ,Gia Lai',1,3,2,'admin'),
(4,'Võ Công Toản','1980-04-04','123231365',17000000,0374443232,'toan0404@gmail.com','77 Hoàng Diệu,Quảng Trị',1,4,4,'member'),
(5,'Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,0902341231,'phatphat@gmail.com','43 Yên Bái,Đà Nẵng',2,1,1,'member'),
(6,'Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,0978653213,'annghi20@gmail.com','294 Nguyễn Tất Thành,Đà Nẵng',2,2,3,'member'),
(7,'Nguyễn Hữu Hà','1993-01-01','534323231',8000000,0941234553,'nhh0101@gmail.com','4 Nguyễn Chí Thanh,Huế',2,3,2,'admin'),
(8,'Nguyễn Hà Đông','1989-09-03','234414123',9000000,0642123111,'donghanguyen@gmail.com','111 Hùng Vương,Hà Nội',2,4,4,'member'),
(9,'Tòng Hoang','1982-09-03','256781231',6000000,0245144444,'hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4,'member'),
(10,'Nguyễn Công Đạo','1994-01-08','755434343',8000000,0988767111,'nguyencongdao12@gmail.com','6 Hoà Khánh,Đồng Nai',2,3,2,'admin');

insert into customer_type(customer_type_id,customer_type_name)
value (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');

insert into customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)
value (1,5,'Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng,Đà Nẵng'),	
	(2,3,'Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên,Quảng Trị'),
	(3,1,'Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh'),
	(4,1,'Dương Văn Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng'),
	(5,4,'Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ,Gia Lai'),
	(6,4,'Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế,Đà Nẵng'),
	(7,1,'Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi,Hồ Chí Minh'),
	(8,3,'Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh,Kon Tum'),
	(9,1,'Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt Quảng Ngãi'),
	(10,2,'Nguyễn Tâm Đắc','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng');
    
insert into rent_type(rent_type_id,rent_type_name)
value (1,'year'),(2,'month'),(3,'day'),(4,'hour');

insert into service_type(service_type_id,service_type_name)
value (1,'Villa'),(2,'House'),(3,'Room');

insert into service(service_id,service_name,service_area,service_cost,service_max_person,room_standard,another_convenient,pool_area,number_of_floors,rent_type_id,service_type_id)
value (	1,'Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,3,1),
	(2,'House Princess 01',	14000,5000000,7,'vip','Có thêm bếp nướng',null,3,2,2),
	(3,'Room Twin 01',5000,1000000,2,'normal','Có tivi',null,null,4,3),
	(4,'Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,3,1),
	(5,'House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',null,2,3,2),
	(6,'Room Twin 02',3000,900000,2,'normal','Có tivi',null,null,4,3);
    
insert into attach_service(attach_service_id,attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)
value (1,'Karaoke',10000,'giờ','tiện nghi,hiện tại'),
	(2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
	(3,'Thuê xe đạp',20000,'chiếc','tốt'),
	(4,'Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn,tráng miệng'),
	(5,'Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn,tráng miệng'),
	(6,'Buffet buổi tối',16000,'suất','đầy đủ đồ ăn,tráng miệng');
    
insert into contract(contract_id,date_check_in,date_check_out,contract_deposit,contract_total_money,employee_id,customer_id,service_id)
value (1,'2020-12-08','2020-12-08',10.0,0,3,1,3),
(2,'2020-07-14','2020-07-21',20.0,200000,7,3,1),
(3,'2021-03-15','2021-03-17',30.0,50000,3,4,2),
(4,'2021-01-14','2021-01-18',15.0,100000,7,5,5),
(5,'2021-07-14','2021-07-15',12,0,7,2,6),
(6,'2021-06-01','2021-06-03',10,0,7,7,6),
(7,'2021-09-02','2021-09-05',8,100000,7,4,4),
(8,'2021-06-17','2021-06-18',7,150000,3,4,1),
(9,'2020-11-19','2020-11-19',15,0,3,4,3),
(10,'2021-04-12','2021-04-14',18,0,10,3,5),
(11,'2021-04-25','2021-04-25',22,0,2,2,1),
(12,'2021-05-25','2021-05-27',24,0,7,10,1);

insert into details_contract(details_contract_id,number_contract,contract_id,attach_service_id)
value (1,5,2,4),(2,8,2,5),(3,15,2,6),(4,1,3,1),
(5,11,3,2),(6,1,3,1),(7,2,1,2),(8,2,12,2);