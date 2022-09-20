USE university;

INSERT INTO Departments (name)
VALUES
	('Economic Sciences'),
    ('Engineering'),
    ('Health Sciences'),
    ('Law'),
    ('Psychology');

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
    ('Robbin','Williams','Bachelor'),
    ('Charles','Smith','Apprentice'),
    ('Edgar','Fields','Head of the department');
    
INSERT INTO Classrooms(size)
VALUES
	(10),
    (5),
    (15),
    (8),
    (12);
    
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
    
INSERT INTO Students(firstName,lastName,email)
VALUES
	('Victoria','Reid','Victoria.Reid@gmail.com'),
	('Isis','Chang','Isis.Chang@gmail.com'),
	('Lila','Beil','Lila.Beil@gmail.com'),
	('Azra','Mata','Azra.Mata@gmail.com'),
	('Klay','Welsh','Klay.Welsh@gmail.com'),
	('Cooper','Finley','Cooper.Finley@gmail.com'),
	('Hammad','Hays','Hammad.Hays@gmail.com'),
	('Lorenzo','Copeland','Lorenzo.Copeland@gmail.com'),
	('Fabien','Lord','Fabien.Lord@gmail.com'),
	('Katy','Deleon','Katy.Deleon@gmail.com'),
	('Aila','Blair','Aila.Blair@gmail.com'),
	('Ellis','Bassett','Ellis.Bassett@gmail.com'),
	('Ishmael','Carter','Ishmael.Carter@gmail.com'),
	('Tamera','Frey','Tamera.Frey@gmail.com');
	
INSERT INTO Grades(Students_id,Exams_id,grade)
VALUES
	(1,1,4),
	(1,2,5),
	(2,1,6),
	(2,2,7),
	(3,3,8),
	(3,10,5),
	(3,3,6),
	(4,11,4),
	(5,10,7),
	(5,3,8),
	(6,6,9),
	(6,7,10),
	(6,9,5),
	(7,6,6),
	(7,7,7),
	(7,9,7),
	(8,8,8),
	(9,8,8),
	(10,8,9),
	(11,3,7);
    
INSERT INTO Enrollments(Courses_id,Students_id)
VALUES
	(1,1),
    (2,1),
    (1,2),
    (2,2),
    (5,3),
    (6,3),
    (9,4),
    (5,5),
    (6,5),
    (7,6),
    (8,6),
    (7,7),
    (8,7),
    (4,8),
    (4,9),
    (4,10),
    (5,11);

INSERT INTO Classes(Professors_id,Courses_id,date,Classrooms_id,Subjects_id)
VALUES
    (1,1,'2022-10-7',1,8),
    (1,1,'2022-9-30',1,8),
    (1,1,'2022-9-27',1,8),
    (1,1,'2022-10-14',1,8),
    (1,2,'2022-10-15',2,8),
    (1,2,'2022-10-8',2,8),
    (1,2,'2022-10-1',2,8),
    (2,5,'2022-10-25',3,11),
    (2,5,'2022-10-18',3,11),
    (2,5,'2022-10-11',3,11),
    (3,4,'2022-05-21',4,7),
    (3,4,'2022-05-14',4,7),
    (3,4,'2022-05-7',4,7),
    (4,3,'2022-09-15',5,9),
    (4,3,'2022-09-8',5,9),
    (4,3,'2022-09-1',5,9),
    (5,6,'2022-03-21',1,11),
    (5,6,'2022-03-14',1,11),
    (5,6,'2022-03-7',1,11),
    (6,7,'2022-03-21',2,10),
    (6,7,'2022-03-14',2,10),
    (6,7,'2022-03-7',2,10),
    (6,8,'2022-03-21',3,10),
    (6,8,'2022-03-14',3,10),
    (6,8,'2022-03-7',3,10),
    (7,9,'2022-03-21',4,3),
    (7,9,'2022-03-14',4,3),
    (7,9,'2022-03-7',4,3);

INSERT INTO Group_of_Students(Classes_id,Students_id)
VALUES
	(1,1),
    (2,1),
    (3,1),
    (4,1),
    (1,2),
    (2,2),
    (3,2),
    (4,2),
    (5,1),
    (6,1),
    (7,1),
    (5,2),
    (6,2),
    (7,2),
    (8,3),
    (9,3),
    (10,3),
    (8,5),
    (9,5),
    (10,5),
    (8,11),
    (9,11),
    (10,11),
    (11,8),
    (12,8),
    (13,8),
    (11,9),
    (12,9),
    (13,9),
    (11,10),
    (12,10),
    (13,10),
    (17,3),
    (18,3),
    (19,3),
    (17,5),
    (18,5),
    (19,5),
    (20,),
    (21,),
    (22,),
    (20,),
    (21,),
    (22,),
    (,),
    ;

