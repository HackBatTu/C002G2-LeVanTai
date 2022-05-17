use quan_li_sinh_vien;
SELECT * FROM Student;
SELECT * FROM Subjects
WHERE Credit < 10;
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID;
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Marks M on S.StudentId = M.StudentId join Subjects Sub on M.SubId = Sub.SubId;
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Marks M on S.StudentId = M.StudentId join Subjects Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';