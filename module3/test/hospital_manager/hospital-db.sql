drop database if exists `hospital_manager`;
create database if not exists `hospital_manager`;
use `hospital_manager`;

create table `patient` (
`patient_id` varchar(255),
`patient_name` varchar(255),
`status` bit(1) default 0,
primary key (`patient_id`)
);

create table `medical_record` (
`medical_record_id` varchar(255),
`patient_id` varchar(255),
`hospitalized_day` date,
`discharge_day` date,
`hospitalized_reason` text,
`status` bit(1) default 0,
primary key (`medical_record_id`),
foreign key (`patient_id`) references `patient` (`patient_id`)
);

INSERT INTO `patient` (`patient_id`, `patient_name`) 
VALUES ('BN-123', 'Robert Downey Jr'),
('BN-124', 'Scarlett Johansson'),
('BN-125', 'Chris Evans'),
('BN-126', 'Chris Hemsworth'),
('BN-127', 'Mark Ruffalo'),
('BN-128', 'Jeremy Renner'),
('BN-129', 'Don Cheadle'),
('BN-131', 'Stan Lee'),
('BN-132', 'Gwyneth Paltrow'),
('BN-133', 'Tom Hiddleston'),
('BN-134', 'Samuel L. Jackson'),
('BN-135', 'Cobie Smulders');

INSERT INTO `medical_record` (`medical_record_id`, `patient_id`, `hospitalized_day`, `discharge_day`, `hospitalized_reason`) 
VALUES ('BA-123', 'BN-123', '2022-06-09', '2022-06-12', 'Ung thư'),
('BA-124', 'BN-124', '2022-05-08', '2022-07-11', 'Viêm gan'),
('BA-125', 'BN-125', '2022-04-07', '2022-08-10', 'Suy thận'),
('BA-126', 'BN-126', '2022-03-06', '2022-09-9', 'Suy tim'),
('BA-127', 'BN-127', '2022-02-05', '2022-10-8', 'Lao'),
('BA-128', 'BN-128', '2022-01-04', '2022-11-7', 'Tiểu đường'),
('BA-129', 'BN-129', '2022-07-03', '2022-12-6', 'Trầm cảm'),
('BA-130', 'BN-131', '2022-08-02', '2022-1-5', 'Suy hô hấp');



use `hospital_manager`;