create table devices(
    id serial primary key,
    name varchar(250),
    price int,
    count int
 );

insert into devices(name, price, count) values('Iphone 12 mini', 300, 10), ('Iphone 13', 450, 8);

insert into devices(name, price, count) values('Samsung S22', 650, 6), ('Samsung S21FE', 420, 15);

insert into devices(name, price, count) values('Xiaomi 12 Ultra', 660, 5), ('Xiaomi Redmi 12 Note', 11, 160);

start transaction;

savepoint first;

drop table devices;

rollback to savepoint first;

select * from devices;

insert into devices(name, price, count) values('Iphone 14 mini', 470, 10), ('Iphone 14', 550, 8);

commit;
