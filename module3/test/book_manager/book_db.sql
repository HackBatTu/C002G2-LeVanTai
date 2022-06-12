drop database if exists `exam_module_3`;
create database if not exists `exam_module_3`;
use `exam_module_3`;

create table `author` (
`author_id` int auto_increment,
`author_name` varchar(255),
primary key (`author_id`)
);

create table `book` (
`book_id` int auto_increment,
`book_name` varchar(255),
`author_id` int,
`amount` int,
`description` text,
primary key (`book_id`),
foreign key (`author_id`) references `author` (`author_id`)
);

create table `class` (
`class_id` int auto_increment,
`class_name` varchar(255),
primary key (`class_id`)
);

create table `student` (
`student_id` int auto_increment,
`student_name` varchar(255),
`class_id` int,
primary key (`student_id`),
foreign key (`class_id`) references `class` (`class_id`)
);

create table `book_card` (
`book_card_id` varchar(255),
`book_id` int,
`student_id` int,
`status` bit(1) default 1,
`day_borrow` varchar(255),
`day_return` varchar(255),
primary key (`book_card_id`),
foreign key (`book_id`) references `book` (`book_id`),
foreign key (`student_id`) references `student`(`student_id`)
);

INSERT INTO `author` (`author_name`)
value ('Dennis Culver'),
('Margaret Stohl'),
('Greg Pak'),
('Alex Ross'),
('Jeff Lemire'),
('Adam Bray'),
('Stuart Moore'),
('Dan Slott'),
('Cullen Bunn'),
('Matthew Rosenberg'),
('Margaret Stohl'),
('Jeff Lemire'),
('Sean Howe'),
('Jed MacKay'),
('Peter Sanderson'),
('Brandon T. Snider'),
('Adam Bray'),
('Michael Mallory');

INSERT INTO `book` (`book_name`, `author_id`, `amount`, `description`) 
VALUES ('Black Panther: The Illustrated History of a King', 1, 0,'This is Black Panther: The Illustrated History of a King description'),
('The Mighty Captain Marvel', 2, 0,'This is The Mighty Captain Marvel description'),
('Return to Planet Hulk', 3, 10,'This is Return to Planet Hulk description'),
('Marvelocity', 4, 3,'This is Marvelocity: The Marvel Comics Art of Alex Ross description'),
('Stan Lee Marvel Treasury Edition', 5, 2,'This is Stan Lee Marvel Treasury Edition description'),
('Thanos Vol. 2: The God Quarry', 6, 5,'This is Thanos Vol. 2: The God Quarry description'),
('Marvel Studios Character Encyclopedia', 7, 6,'This is Marvel Studios Character Encyclopedia description'),
('Civil War', 8, 20,'This is Civil War description'),
('Civil War: Marvel Universe', 9, 1,'This is Civil War: Marvel Universe description'),
('Deadpool Kills the Marvel Universe Again', 10, 8,'This is Deadpool Kills the Marvel Universe Again description'),
('Phoenix Resurrection: The Return Of Jean Grey', 11, 9,'This is Phoenix Resurrection: The Return Of Jean Grey description'),
('The Mighty Captain Marvel Vol. 3: Dark Origins', 12, 1,'This is The Mighty Captain Marvel Vol. 3: Dark Origins description'),
('Thanos Vol. 1: Thanos Returns', 2, 12,'This is Thanos Vol. 1: Thanos Returns description'),
('Marvel Comics: The Untold Story', 3, 13,'This is arvel Comics: The Untold Story description'),
('Death Of Doctor Strange', 4, 28,'This is Death Of Doctor Strange description'),
('The Marvel Vault: A Visual History', 5, 6,'This is The Marvel Vault: A Visual History description'),
('Spider-Man Doodles', 6, 45,'This is Spider-Man Doodles description'),
('Marvel Studios 101: All Your Questions Answered', 2, 22,'This is Marvel Studios 101: All Your Questions Answered description'),
('Marvel The Black Widow', 4, 3,'This is Marvel The Black Widow description'),
('Captain Marvel: Dark Origins', 5, 5,'This is Captain Marvel: Dark Origins description'),
('Who Is the Black Panther', 6, 3,'This is Who Is the Black Panther description'),
('Obsessed With Marvel', 2, 5,'This is Obsessed With Marvel description');

INSERT INTO `class` (`class_name`)
value ('10A1'),
('10B1'),
('11A1'),
('11B1'),
('12A1'),
('12B1');

INSERT INTO `student` (`student_name`, `class_id`) 
VALUES ('Scarlett Johansson', 1),
('Robert Downey Jr', 2),
('Chris Evans', 3),
('Chris Hemsworth', 4),
('Mark Ruffalo', 5),
('Jeremy Renner', 6),
('Don Cheadle', 1),
('Stan Lee', 2),
('Gwyneth Paltrow', 3),
('Tom Hiddleston', 4),
('Samuel L. Jackson', 5),
('Cobie Smulders', 6),
('Paul Bettany', 1),
('Brent McGee', 2);

use `exam_module_3`;