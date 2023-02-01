
create table devices(
    id serial primary key,
    name varchar(250),
    count int
);

insert into devices(name, count)
values('Xiaomi 12T', 10), ('Iphone 12', 7), ('Iphone 13 Pro', 5), ('Nokia 3310', 1), ('Honor 6a', 5);


begin transaction isolation level serializable;

select sum(count) from devices;

select sum(count) from devices;

update devices set count = 10 where name = 'Iphone 12';

update devices set count = 20 where name = 'Iphone 13 Pro';

commit;

commit;

