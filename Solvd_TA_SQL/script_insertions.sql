USE university;

INSERT INTO Departments (name)
VALUES
	('Economic Sciences'),
    ('Engineering'),
    ('Health Sciences'),
    ('Law');

INSERT INTO Specialities (name,Departments_id)
VALUES
	('Informatics Engineering', 1),
    ('Accountant',1),
    ('Electrical Engineer',2),
    ('Nurse',3),
    ('Doctor',3),
	('Lawyer',4);

INSERT INTO Subjects (name,Specialities_id)
VALUES
	('Mathematics',1),
    ('Physics',3),
    ('Biochemistry',4),
    ('Theory of the State',6),
    ('Human rights',6),
    ('Neurology',5),
    ('Administration',2),
    ('Marketing',2),
    ('Statistics',2),
    ('Circuit Analysis',3),
    ('Computing',1);
    
INSERT INTO Professors(firstName,lastName,degree)
VALUES
	('Dominika',' Woodard','Technician'),
    ('Arun','Allan','Bachelor'),
    ('Safaa','Cash','Doctorate'),
    ('Rianna','Brook','Apprentice'),
    ('Edgar','Fields','Head of the department');
    
INSERT INTO Classrooms(size)
VALUES
	(20),
    (25),
    (30),
    (40);
    
INSERT INTO Courses(startDate,name,cost)
VALUES
	('2022-09-14','Marketing 1-N',50.50),
    ('2022-09-15','Marketing 2-T',110.21),
    ('2022-08-15','Statistics 1-M',100.00),
    ('2022-05-01','Administration 1-T',150.00),
    ('2022-09-25','Computing 1-N',36.30),
    ('2022-02-21','Computing 3-N',88.60);
    
INSERT INTO Courses(startDate,name,cost)
VALUES
	('2022-02-21','Circuit Analysis 1-N',55.30),
    ('2022-02-21','Circuit Analysis 1-T',50.60),
    ('2022-02-21','Biochemistry 3-M',55.60);
    
INSERT INTO Exams(date,Courses_id,Subjects_id)
VALUES
	('2022-10-14',1,8),
    ('2022-10-15',2,8),
    ('2022-10-25',5,11),
    ('2022-09-15',3,9),
    ('2022-10-15',3,9),
    ('2022-03-21',7,10),
    ('2022-03-21',8,10),
    ('2022-05-21',4,7),
    ('2022-05-21',8,10),
    ('2022-03-21',6,11),
    ('2022-03-21',9,3);
    
    
    