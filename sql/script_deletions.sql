USE university;

DELETE FROM Departments WHERE name='Psychology';

DELETE FROM Courses WHERE id=3;

DELETE FROM Exams WHERE Courses_id=3;

DELETE FROM Classes WHERE Courses_id=3;

DELETE FROM Students WHERE id=15;

DELETE FROM Students WHERE firstName='Isis' AND id > 14;

DELETE FROM Students WHERE firstName='Tamera' AND lastName='Frey';

DELETE FROM Grades WHERE grade < 4;




