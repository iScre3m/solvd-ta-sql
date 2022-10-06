SELECT Subjects_id, count(*) from Exams GROUP BY Subjects_id HAVING count(*)>1 ORDER BY count(*) DESC;

Select name, cost from Courses GROUP BY name HAVING MAX(cost) > 100;

Select name, cost from Courses GROUP BY name HAVING MIN(cost) < 55;

Select name, Departments_id from Specialities GROUP BY Departments_id HAVING COUNT(Departments_id) > 1;

Select name, Specialities_id from Subjects GROUP BY Specialities_id HAVING COUNT(Specialities_id) = 1;
