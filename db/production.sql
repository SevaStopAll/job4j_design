create table departments(
	id serial primary key,
	name varchar(250)
);

create table employees(
	id serial primary key,
	name varchar(250),
	department_id int references departments(id)
);

insert into departments(name)
values('HR'), ('RnD'), ('SEC'), ('IT'), ('Prod');

insert into employees(name, department_id)
values('Alex', 1), ('Charlie', 2),
('Michelle', 3), ('Tailor', 4), ('Max', 5);

select * from employees e
left join departments d on e.department_id = d.id;

select * from departments d
right join employees e on d.id = e.department_id;

select * from departments d
full join employees e on d.id = e.department_id;

select * from departments d  cross join employees e;

select * from employees e
left join departments d
on d.id = e.department_id where e.department_id is null;

select d.name, e.name from employees e
left join departments d on e.department_id = d.id;

select d.name, e.name from departments d
right join employees e on d.id = e.department_id;

create table teens(
	id serial primary key,
	name varchar(250),
	gender varchar(1)
);

insert into teens(name, gender)
values('Max', 'M'), ('Marta', 'F'), ('Collin', 'M'),
('Nadya', 'F'), ('Nandor', 'M'), ('Giliermo', 'M');

select e.name, e.gender, a.gender, a.name from teens e
cross join teens a