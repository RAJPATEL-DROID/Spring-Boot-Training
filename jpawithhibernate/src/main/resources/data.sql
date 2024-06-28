insert into course_details(id,name,created_date,last_updated_date) values (10001,'JPA in 100 Steps',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP());
insert into course_details(id,name,created_date,last_updated_date) values (10002,'JDBC in 10 Steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course_details(id,name,created_date,last_updated_date) values (10003,'JUnit in 50 Steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());


insert into passport(id,passport_number) values (40001,'L1234F');
insert into passport(id,passport_number) values (40002,'L1244F');
insert into passport(id,passport_number) values (40003,'L1284F');

insert into student(id,name,passport_id) values (20003,'rAj',40001);
insert into student(id,name,passport_id) values (20004,'ravi',40002);
insert into student(id,name,passport_id) values (20005,'yash',40003);

insert into review(id,rating,description,course_id) values (30001,'5','Great course',10001);
insert into review(id,rating,description,course_id) values (30002,'4', 'Good Course',10002);
insert into review(id,rating,description,course_id) values (30003,'4', 'Good Course',10003);

insert into student_course(student_id,course_id)
values (20003,10001);

insert into student_course(student_id,course_id)
values (20003,10002);

insert into student_course(student_id,course_id)
values (20004,10001);