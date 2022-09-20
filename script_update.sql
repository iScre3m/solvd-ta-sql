USE university;

UPDATE Specialities
	SET name = REPLACE(name, 'Electrical Engineer','Electrical Engineering')
    WHERE name LIKE ('Electrical Engineer%');
    
UPDATE Specialities
	SET Departments_id = 2
    WHERE name LIKE ('%Engineering');
    
