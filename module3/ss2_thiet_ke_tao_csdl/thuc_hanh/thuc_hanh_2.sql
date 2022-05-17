
create database quan_li_sinh_vien;
use quan_li_sinh_vien;
CREATE TABLE Class(
    classid   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    classname VARCHAR(60) NOT NULL,
    startdate DATETIME    NOT NULL,
    Statuss    BIT
);
CREATE TABLE Student(
    studentid   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    studentname VARCHAR(30) NOT NULL,
    address     VARCHAR(50),
    phone     VARCHAR(20),
    Statuss     BIT,
    classid    INT         NOT NULL,
    FOREIGN KEY (classid) REFERENCES Class (classid)
);
CREATE TABLE Subjects(
    SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    Status  BIT                  DEFAULT 1
);
CREATE TABLE Marks(
    markid    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subjects (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);