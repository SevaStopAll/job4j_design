create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price)
values('Xiaomi 12T', 35000.00);

insert into devices(name, price)
values('Apple Macbook Air', 89000.00);

insert into devices(name, price)
values('Nolia 5530', 2350.00);

insert into devices(name, price)
values('Ipad Air 1', 5000.00);


insert into people(name)
values('Jeff');

insert into people(name)
values('Collin');

insert into people(name)
values('Arthur');

insert into people(name)
values('Linda');

insert into people(name)
values('Sarah');

insert into people(name)
values('Amanda');


insert into devices_people(device_id, people_id)
values(1, 1);

insert into devices_people(device_id, people_id)
values(3, 2);

insert into devices_people(device_id, people_id)
values(3, 3);

insert into devices_people(device_id, people_id)
values(1, 4);

insert into devices_people(device_id, people_id)
values(3, 5);

insert into devices_people(device_id, people_id)
values(3, 6);

insert into devices_people(device_id, people_id)
values(2, 1);

insert into devices_people(device_id, people_id)
values(4, 2);

insert into devices_people(device_id, people_id)
values(4, 3);

insert into devices_people(device_id, people_id)
values(2, 4);

insert into devices_people(device_id, people_id)
values(4, 5);

insert into devices_people(device_id, people_id)
values(2, 6);


select avg(price) from devices;

select people.name, avg(devices.price)
from devices_people
join devices
on devices.id = devices_people.device_id
join people
on people.id = devices_people.people_id
group by people.name;


select people.name, avg(devices.price)
from devices_people
join devices
on devices.id = devices_people.device_id
join people
on people.id = devices_people.people_id
group by people.name
having avg(devices.price) > 5000.00;