
create table devices(
    id serial primary key,
    name varchar(250),
    count int
);

postgres=# insert into devices(name, count)
values('Xiaomi 12T', 10), ('Iphone 12', 7), ('Iphone 13 Pro', 5), ('Nokia 3310', 1), ('Honor 6a', 5);


begin transaction isolation level serializable;

update products set count = 10 where name = 'Iphone 12';

update products set count = 20 where name = 'Iphone 13 Pro';

commit;

commit;

