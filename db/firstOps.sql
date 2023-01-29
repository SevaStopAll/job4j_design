create table students(
id serial primary key,
    name varchar(255),
 	surname varchar(255),
 	age smallint,
    count numeric);

insert into students
(name, surname, age)
values ('Alex', 'Smith', 25, 2200.0);

select * from students;

update students set name = 'Nick';

delete from students;