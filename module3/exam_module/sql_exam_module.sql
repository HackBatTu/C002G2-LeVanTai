-- drop database exam_module;
create database exam_module;
use exam_module;

create table exam_1(
id_exam_1 int auto_increment primary key,
name_exam varchar(55)
);

create table exam_2(
 id int auto_increment primary key,
 name_exam_2 varchar(55),
 id_exam_1 int,
 foreign key(id_exam_1) references exam_1(id_exam_1)
);

insert into exam_1 
value (1,'2'),(2,'3');

insert into exam_2
value (1,'ga',1),(2,'non',2);

