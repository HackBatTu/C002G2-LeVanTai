use quan_li_sinh_vien;
select * from student
where studentname like 'H%';

select * from class
where month(startdate) =12;

select * from subjects
where Credit >= 3 and credit <=5;

set sql_safe_updates =0;
update student
set class_id = 2
where student_name = 'hung' and student_id=2;
set sql_safe_updates =1;

select student.student_name,subjects.subname,marks.mark from student
inner join marks  on student.student_id = marks.student_id
inner join subjects on marks.sub_id = subjects.sub_id
order by mark desc, studentname asc