# solvd-ta-sql
Nahuel Sanabria - University
Student is looking to get a speciality


The primary entities of the University are:

- Students:
  They can enroll to many courses through the enrollment. (M:M)
  They have grades from the exams (1:M)

- Courses:
	Have the subject they belong to. (M:1)
  One course has multiple exams. (1:M)
  A course has multiple classes. (1:M)
 
- Classes:
  Are small parts that have to be attended to finish the courses. (M:1)
  Have classroms were they are given. (1:1)
  Have professors that dictate them. (M:1)
  
  
  
