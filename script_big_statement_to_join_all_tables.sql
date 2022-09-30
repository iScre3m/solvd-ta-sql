SELECT dep.name AS 'Departament', spe.name AS 'Speciality', sub.name AS 'Subject',  ex.date AS 'Examen', classes.date AS 'Class', prof.lastName AS 'Professor', clasr.id AS 'Classroom', cour.name AS 'Course', grades.grade AS 'Grade', stu.email AS 'Student', enr.id AS 'Enrollment', grp.id AS 'Group of students'
FROM departments AS dep 
INNER JOIN specialities AS spe ON dep.id = spe.departments_id
INNER JOIN subjects AS sub ON spe.id = sub.specialities_id
INNER JOIN exams AS ex ON sub.id = ex.subjects_id
INNER JOIN classes ON sub.id = classes.subjects_id
INNER JOIN professors AS prof ON prof.id = classes.professors_id
INNER JOIN classrooms AS clasr ON clasr.id = classes.classrooms_id
INNER JOIN courses AS cour ON cour.id = ex.courses_id
INNER JOIN grades ON grades.exams_id = ex.id
INNER JOIN students AS stu ON stu.id = grades.students_id
INNER JOIN enrollments AS enr ON enr.students_id = stu.id
INNER JOIN group_of_students AS grp ON grp.students_id = stu.id
ORDER BY grp.id;