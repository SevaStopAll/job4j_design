create table students(id serial primary key, name varchar(255),	surname varchar(255), age smallint );
insert into students(name, surname, age) values ('Alex', 'Smith', 25);
select * from students;
update students set name = 'Nick';
delete from students;