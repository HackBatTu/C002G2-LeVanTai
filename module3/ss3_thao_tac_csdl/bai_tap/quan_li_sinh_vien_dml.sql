use quan_li_sinh_vien;
select * from student
where studentname like 'H%';

select * from class
where month(startdate) =12;

select * from subjects
where Credit >= 3 and credit <=5;

set sql_safe_updates =0;
update student
set classid = 2
where studentname = 'hung' and studentid=2;
set sql_safe_updates =1;

select student.studentname,subjects.subname,marks.mark from student
inner join marks  on student.studentid = marks.studentid
inner join subjects on marks.subid = subjects.subid
order by mark desc, studentname asc