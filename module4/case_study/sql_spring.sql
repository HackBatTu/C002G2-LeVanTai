use case_study_spring;
 insert into rent_type(id,name)
value (1,'year'),(2,'month'),(3,'day'),(4,'hour');

insert into facility_type(id,name)
value (1,'Villa'),(2,'House'),(3,'Room');

insert into customer_type(id,name)
value (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');

insert into employee_position(id,name)
value (1,'Quản Lí'),(2,'Nhân Viên');

insert into education_degree(id,name)
value (1,'Trung Cấp'),(2,'Cao Đẳng'),(3,'Đại Học'),(4,'Sau Đại Học');

insert into division(id,name)
value (1,'Sale-Marketing'),(2,'Hành Chính'),(3,'Phục vụ'),(4,'Quản lý');

insert into facility_attach(id,name,cost,unit,status)
value (1,'Karaoke',10000,'giờ','tiện nghi,hiện tại'),
	(2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
	(3,'Thuê xe đạp',20000,'chiếc','tốt'),
	(4,'Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn,tráng miệng'),
	(5,'Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn,tráng miệng'),
	(6,'Buffet buổi tối',16000,'suất','đầy đủ đồ ăn,tráng miệng');