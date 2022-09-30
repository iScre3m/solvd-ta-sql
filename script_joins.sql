USE university;

SELECT * FROM courses AS cour INNER JOIN exams AS ex ON cour.id = ex.Courses_id ORDER BY cour.startDate;
SELECT * FROM exams AS ex RIGHT JOIN subjects AS sub ON ex.Subjects_id = sub.id ORDER BY sub.name;
SELECT prof.firstName,prof.lastName,clas.date,clas.Subjects_id FROM professors AS prof LEFT JOIN classes AS clas ON prof.id = clas.Professors_id ORDER BY prof.firstName;
SELECT * FROM departments AS dep LEFT OUTER JOIN specialities as spe ON dep.id = spe.Departments_id WHERE spe.Departments_id IS NULL;
SELECT clasr.size,clas.date,clas.Subjects_id,clas.Professors_id FROM classes as clas RIGHT OUTER JOIN classrooms as clasr ON clas.Classrooms_id = clasr.id ORDER BY clas.date;