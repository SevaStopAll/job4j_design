create table car_bodies(
	id serial primary key,
	name varchar(250)
);

create table car_engines(
	id serial primary key,
	name varchar(250)
);

create table car_transmissions(
	id serial primary key,
	name varchar(250)
);

create table cars(
	id serial primary key,
	name varchar(250),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values('Sedan'), ('Hatchback'), ('Coupee');

insert into car_engines(name) values('V4'), ('V8'), ('V12');

insert into car_transmissions(name) values('Mechanic'), ('Auto-Robot'), ('Auto-Classic');

insert into cars(name, body_id, engine_id, transmission_id) values('Kalina', 1, 1, 1), ('Granta', 2, 2, 2), ('Vesta', 1, 2, 1);

insert into cars(name, engine_id) values('UAZ', 2);

select cars.id, cars.name, car_bodies.name as body, car_engines.name as engine, car_transmissions.name as transmission from cars
left join car_bodies on cars.body_id = car_bodies.id
left join car_transmissions on cars.transmission_id = car_transmissions.id
left join car_engines on cars.engine_id = car_engines.id;

select b.name from car_bodies b
left join cars c
on b.id = c.body_id where c.body_id is null;

select e.name from car_engines e
left join cars c
on e.id = c.engine_id where c.engine_id is null;

select t.name from car_transmissions t
left join cars c
on t.id = c.transmission_id where c.transmission_id is null;



