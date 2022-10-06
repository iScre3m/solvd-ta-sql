SELECT Students_id, grade from Grades WHERE grade > (SELECT AVG(grade) FROM Grades) GROUP BY Students_id;

SELECT Subjects_id, count(*) from Exams GROUP BY Subjects_id ORDER BY count(*) DESC;

Select startDate, name, cost from Courses WHERE name LIKE '%-N' AND cost>(SELECT AVG(cost) FROM Courses) GROUP BY name;

Select startDate, name, cost from Courses WHERE cost<(SELECT AVG(cost) FROM Courses) GROUP BY name;

Select name, startDate, cost from Courses WHERE cost = (SELECT MIN(cost) from Courses) GROUP BY startDate;

