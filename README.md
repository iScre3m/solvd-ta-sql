# solvd-ta-sql
Nahuel Sanabria - University
Student is looking to get a speciality


The primary entities of the University are:

- Students:
  > (M:M) They can enroll to many courses through the enrollment.
  > (1:M) They have grades from the exams.

- Courses:
  > (M:1) Have the subject they belong to. 
  > (1:M) One course has multiple exams. 
  > (1:M) A course has multiple classes. 
 
- Classes:
  > (M:1) Are small parts that have to be attended to finish the courses. 
  > (1:1) Have classroms were they are given. 
  > (M:1) Have professors that dictate them. 
  
  
  
