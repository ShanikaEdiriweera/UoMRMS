INSERT INTO `faculty` (`ID`, `name`) VALUES
(1, 'Engineering'),
(2, 'IT'),
(3, 'Architecture');

INSERT INTO `department` (`ID`, `name`, `Faculty_ID`) VALUES
(1, 'Computer Science & Engineering', 1),
(2, 'Electronic & Telecommunication Engineering', 1),
(3, 'Civil Engineering', 1),
(4, 'Mechanical Engineering', 1),
(5, 'Electrical Engineering', 1),
(6, 'Chemical & Process Engineering', 1),
(7, 'Biomedical Engineering', 1),
(8, 'Material Science Engineering', 1);


INSERT INTO `grade` (`grade`, `mark`) VALUES
('A+', '4.2'),
('A', '4.0'),
('A-', '3.7'),
('B+', '3.3'),
('B', '3.0'),
('B-', '2.7'),
('C+', '2.3'),
('C', '2.0'),
('C-', '1.5'),
('D', '1.0'),
('F', '0.0'),
('I-we', '0.0'),
('I-ca', '0.0'),
('ab', '0.0');


INSERT INTO `semester` (`ID`, `name`) VALUES
(1, 'Semester 1'),
(2, 'Semester 2'),
(3, 'Semester 3'),
(4, 'Semester 4'),
(5, 'Semester 5'),
(6, 'Semester 6'),
(7, 'Semester 7'),
(8, 'Semester 8');



INSERT INTO `module` (`code`, `title`, `credits`, `gpa`, `Semester_ID`) VALUES
('CS-2022', 'OOP', '3.0', 1, 2),
('CS-2032', 'OOSD', '3.0', 1, 3);