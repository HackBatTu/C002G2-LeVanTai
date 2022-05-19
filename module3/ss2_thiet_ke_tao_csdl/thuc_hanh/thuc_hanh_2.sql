-- drop database quan_li_sinh_vien;
create database quan_li_sinh_vien;
use quan_li_sinh_vien;
CREATE TABLE Class(
    class_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(60) NOT NULL,
    start_date DATETIME    NOT NULL,
    Statuss    BIT
);
CREATE TABLE Student(
    student_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(30) NOT NULL,
    address     VARCHAR(50),
    phone     VARCHAR(20),
    Statuss     BIT,
    class_id    INT         NOT NULL,
    FOREIGN KEY (class_id) REFERENCES Class (class_id)
);
CREATE TABLE Subjects(
    sub_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_name VARCHAR(30) NOT NULL,
    credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( credit >= 1 ),
    Status  BIT                  DEFAULT 1
);
CREATE TABLE Marks(
    mark_id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_id     INT NOT NULL,
    student_id INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    exam_times TINYINT DEFAULT 1,
    UNIQUE (sub_id, student_id),
    FOREIGN KEY (sub_id) REFERENCES Subjects (sub_id),
    FOREIGN KEY (student_id) REFERENCES Student (student_id)
);