USE university;

UPDATE Specialities
	SET name = REPLACE(name, 'Electrical Engineer','Electrical Engineering')
    WHERE name LIKE ('Electrical Engineer%');
    
UPDATE Specialities
	SET Departments_id = 2
    WHERE name LIKE ('%Engineering');
    
UPDATE Students
	SET lastName = REPLACE(lastName, 'Sanches', 'Sanchez');

UPDATE Students
	SET email = REPLACE(email, 'Sanches', 'Sanchez')
    WHERE email LIKE ('%Sanches%');
    
