-- drop database case_study_module3;
create database case_study_module3;
use case_study_module3;
create table vi_tri (
id int auto_increment primary key,
name_vi_tri varchar(255));
create table trinh_do (
id int auto_increment primary key,
name_trinh_do varchar(255));
create table bo_phan(
id int auto_increment primary key,
name_bo_phan varchar(255));
create table employee (
id_employee int auto_increment primary key,
name_employee varchar(255),
date_employee date,
id_card varchar(255),
salary double,
phone varchar(255),
email varchar(255),
address varchar(255),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
foreign key(id_bo_phan) REFERENCES bo_phan(id),
foreign key(id_trinh_do) references trinh_do(id),
foreign key (id_vi_tri) references vi_tri(id)
);
create table customer_type(
id int auto_increment primary key,
name_customer_type varchar(255));
create table customer(
id_customer int auto_increment primary key,
id_customer_type int,
foreign key(id_customer_type) references customer_type(id),
name_customer varchar(255),
date_customer date,
gender bit(1),
id_card varchar(255),
phone varchar(255),
email varchar(255),
address varchar(255));
create table kieu_thue(
id int auto_increment primary key,
name varchar(255));
create table type_service(
id int auto_increment primary key,
name_type varchar(255));
create table service(
id_service int auto_increment primary key,
name_service varchar(255),
area_service int,
cost double,
max_person int,
tieu_chuan_phong varchar(255),
mo_ta_tien_nghi_khac varchar(255),
pool_area double,
number_of_floors int,
id_kieu_thue int,
foreign key(id_kieu_thue) references kieu_thue(id),
id_type_service int,
foreign key(id_type_service) references type_service(id)
);
create table service_di_kem(
id int auto_increment primary key,
name_service varchar(255),
prince double,
don_vi varchar(255),
trang_thai varchar(255));
create table promotion (
id_promotion int auto_increment primary key,
date_now datetime,
date_end datetime,
money_checkin double,
id_employee int,
id_customer int,
id_service int,
foreign key(id_employee) references employee(id_employee),
foreign key(id_customer) references customer(id_customer),
foreign key(id_service) references service(id_service));
create table promotion_chi_tiet(
id_promotion_lock int auto_increment primary key,
id_promotion int,
foreign key(id_promotion) references promotion(id_promotion),
id_service_kem int,
foreign key(id_service_kem) references service_di_kem(id),
number_promotion int);
insert into vi_tri
value (1,'Quản Lí'),(2,'Nhân Viên');
insert into trinh_do
value (1,'Trung Cấp'),(2,'Cao Đẳng'),(3,'Đại Học'),(4,'Sau Đại Học');
insert into bo_phan
value (1,'Sale-Marketing'),(2,'Hành Chính'),(3,'Phục vụ'),(4,'Quản lý');
insert into employee
value 
(1,'Nguyễn Văn An','1970-11-07','456231786',10000000,0901234121,'annguyen@gmail.com','295 Nguyễn Tất Thành,Đà Nẵng',1,3,1),
(2,'Lê Văn Bình','1997-04-09','654231234',7000000,0934212314,'binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
(3,'Hồ Thị Yến','1995-12-12','999231723',14000000,0412352315,'thiyen@gmail.com','K234/11 Điện Biên Phủ,Gia Lai',1,3,2),
(4,'Võ Công Toản','1980-04-04','123231365',17000000,0374443232,'toan0404@gmail.com','77 Hoàng Diệu,Quảng Trị',1,4,4),
(5,'Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,0902341231,'phatphat@gmail.com','43 Yên Bái,Đà Nẵng',2,1,1),
(6,'Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,0978653213,'annghi20@gmail.com','294 Nguyễn Tất Thành,Đà Nẵng',2,2,3),
(7,'Nguyễn Hữu Hà','1993-01-01','534323231',8000000,0941234553,'nhh0101@gmail.com','4 Nguyễn Chí Thanh,Huế',2,3,2),
(8,'Nguyễn Hà Đông','1989-09-03','234414123',9000000,0642123111,'donghanguyen@gmail.com','111 Hùng Vương,Hà Nội',2,4,4),
(9,'Tòng Hoang','1982-09-03','256781231',6000000,0245144444,'hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
(10,'Nguyễn Công Đạo','1994-01-08','755434343',8000000,0988767111,'nguyencongdao12@gmail.com','6 Hoà Khánh,Đồng Nai',2,3,2);
insert into customer_type
value (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');
insert into customer
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
insert into kieu_thue
value (1,'year'),(2,'month'),(3,'day'),(4,'hour');
insert into type_service
value (1,'Villa'),(2,'House'),(3,'Room');
insert into service
value (	1,'Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,3,1),
	(2,'House Princess 01',	14000,5000000,7,'vip','Có thêm bếp nướng',null,3,2,2),
	(3,'Room Twin 01',5000,1000000,2,'normal','Có tivi',null,null,4,3),
	(4,'Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,3,1),
	(5,'House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',null,2,3,2),
	(6,'Room Twin 02',3000,900000,2,'normal','Có tivi',null,null,4,3);
insert into service_di_kem
value (1,'Karaoke',10000,'giờ','tiện nghi,hiện tại'),
	(2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
	(3,'Thuê xe đạp',20000,'chiếc','tốt'),
	(4,'Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn,tráng miệng'),
	(5,'Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn,tráng miệng'),
	(6,'Buffet buổi tối',16000,'suất','đầy đủ đồ ăn,tráng miệng');
insert into promotion
value (1,'2020-12-08','2020-12-08',0,3,1,3),
(2,'2020-07-14','2020-07-21',200000,7,3,1),
(3,'2021-03-15','2021-03-17',50000,3,4,2),
(4,'2021-01-14','2021-01-18',100000,7,5,5),
(5,'2021-07-14','2021-07-15',0,7,2,6),
(6,'2021-06-01','2021-06-03',0,7,7,6),
(7,'2021-09-02','2021-09-05',100000,7,4,4),
(8,'2021-06-17','2021-06-18',150000,3,4,1),
(9,'2020-11-19','2020-11-19',0,3,4,3),
(10,'2021-04-12','2021-04-14',0,10,3,5),
(11,'2021-04-25','2021-04-25',0,2,2,1),
(12,'2021-05-25','2021-05-27',0,7,10,1);
insert into promotion_chi_tiet
value (1,2,4,5),(2,2,5,8),(3,2,6,15),(4,3,1,1),
(5,3,2,11),(6,3,1,1),(7,1,2,2),(8,12,2,2);