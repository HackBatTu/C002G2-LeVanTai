-- drop database exam_module;
create database exam_module;
use exam_module;
create table trang_thai(
id_trang_thai int auto_increment primary key,
name_trang_thai varchar(45),
`status` bit(1) default 0);

create table loai_van_phong(
id_loai_van_phong int auto_increment primary key,
name_loai_van_phong varchar(45),
`status` bit(1) default 0);

create table mat_bang(
ma_mat_bang varchar(45) primary key,
dien_tich double,
id_trang_thai int,
foreign key(id_trang_thai) references trang_thai(id_trang_thai),
tang int,
id_loai_van_phong int,
foreign key(id_loai_van_phong) references loai_van_phong(id_loai_van_phong),
mo_ta varchar(255),
gia double,
ngay_bat_dau varchar(45),
ngay_ket_thuc varchar(45),
`status` bit(1) default 0
);

insert into trang_thai(id_trang_thai,name_trang_thai)
value (1,'Trống'),(2,'Hạ Tầng'),(3,'Đầy đủ');

insert into loai_van_phong(id_loai_van_phong,name_loai_van_phong)
value (1,'chia sẻ'),(2,'trọn gói');

insert into mat_bang(ma_mat_bang,dien_tich,id_trang_thai,tang,id_loai_van_phong,mo_ta,gia,ngay_bat_dau,ngay_ket_thuc)
value 
('MB1-01-01',20.0,1,1,1,'mát mẻ,sạch đẹp',100000,'20-02-2021','20-02-2022'),
('MB2-01-01',30.0,2,4,2,'thoáng mát , hướng mặt trời',500000,'21-02-2021','21-02-2022'),
('MB3-01-01',40.0,3,6,1,'tiêu chuẩn 5s',300000,'22-02-2021','22-02-2022'),
('MB4-01-01',50.0,1,1,2,'mát mẻ,sạch đẹp',100000,'23-02-2021','23-02-2022');




