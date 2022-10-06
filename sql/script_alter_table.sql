USE university;

ALTER TABLE Classes MODIFY date DATE NOT NULL;

ALTER TABLE Classrooms MODIFY size int NOT NULL;

ALTER TABLE Professors MODIFY degree VARCHAR(15);