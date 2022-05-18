use quan_li_sinh_vien;
SELECT address, COUNT(StudentId) AS 'Số lượng học viên'
FROM student
GROUP BY address;

#Tính điểm trung bình các môn học của mỗi học viên
SELECT s.studentId, s.studentname, AVG(Mark)
FROM student s
join marks m on s.studentid = m.studentid
GROUP BY s.studentid, s.studentname
HAVING AVG(Mark) > 15;

#Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
SELECT s.studentId, s.studentname, AVG(mark)
FROM student s join marks m on s.studentId = m.studentId
GROUP BY s.studentId, s.studentname
HAVING AVG(mark) >= ALL (SELECT AVG(mark) FROM Marks GROUP BY marks.studentid);
