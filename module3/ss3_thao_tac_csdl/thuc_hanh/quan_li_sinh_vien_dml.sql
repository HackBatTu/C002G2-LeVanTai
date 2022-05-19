use quan_li_sinh_vien;
SELECT * FROM Student;
SELECT * FROM Subjects
WHERE Credit < 10;
SELECT S.student_id, S.student_name, C.class_name
FROM student S join class C on S.class_id = C.class_id;
SELECT S.student_id, S.student_name, C.class_name
FROM student S join class C on S.class_id = C.class_id
WHERE C.class_name = 'A1';
SELECT S.student_id, S.student_name, Sub.sub_name, M.Mark
FROM Student S join Marks M on S.StudentId = M.student_id join Subjects Sub on M.sub_id = Sub.sub_id;
SELECT S.student_id, S.student_name, Sub.sub_name, M.Mark
FROM Student S join Marks M on S.student_id = M.student_id join Subjects Sub on M.sub_id = Sub.sub_id
WHERE Sub.SubName = 'CF';