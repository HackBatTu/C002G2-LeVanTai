create database student;
use student;
create table student(
id int auto_increment primary key,
name varchar(255),
point double,
gender bit(1),
ranks varchar(255));
insert into student
value (1,'Tài',9.0,1,'giỏi'),(2,'Tài1',5.0,1,'trung bình')
