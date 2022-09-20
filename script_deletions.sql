USE university;

DELETE FROM Departments WHERE name='Psychology';

DELETE FROM Courses WHERE id=3;

DELETE FROM Exams WHERE Courses_id=3;

DELETE FROM Classes WHERE Courses_id=3;

