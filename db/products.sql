create table type(
	id serial primary key,
	name varchar(250)
);

create table product(
	id serial primary key,
	name varchar(250),
	expired_date date,
	price float,
	type_id int references type(id)
);

insert into type(name)
values('СЫР'), ('МОЛОКО'), ('МЯСО');

insert into product(name, expired_date, price, type_id)
values('Сыр Костромской', '20-12-2023', 400.00, 1);

insert into product(name, expired_date, price, type_id)
values('Сыр Плавленный', '28-01-2023', 160.00, 1);

insert into product(name, expired_date, price, type_id)
values('Молоко 3.2%', '10-02-2023', 135.00, 2);

insert into product(name, expired_date, price, type_id)
values('Молоко 2.5%', '10-02-2023', 117.00, 2);

insert into product(name, expired_date, price, type_id)
values('Молоко Отборное 4%', '10-02-2023', 180.00, 2);

insert into product(name, expired_date, price, type_id)
values('Мясо мороженое Говядина', '03-02-2023', 400.00, 3);

insert into product(name, expired_date, price, type_id)
values('Мясо мороженое Свинина', '03-02-2023', 359.00, 3);

insert into product(name, expired_date, price, type_id)
values('Мясо мороженое Телятина', '03-02-2023', 547.00, 3);

insert into product(name, expired_date, price, type_id)
values('Мясо мороженое Курица истекает', '27-01-2023', 230.00, 3);

SELECT *
FROM type
JOIN product
ON type.id  = product.type_id
WHERE type.name = 'СЫР';

SELECT * from type
JOIN product
ON type.id  = product.type_id
WHERE product.name LIKE '%мороженое%';

SELECT * from product
WHERE expired_date < current_date;

SELECT p.name, p.price, p.expired_date, t.name
FROM product as p
JOIN type as t
ON p.type_id= t.id
WHERE p.price = (select max(price) from product)
GROUP BY p.name, p.price, p.expired_date, t.name;

SELECT t.name, count(t.name)
FROM product as p
JOIN type as t
ON p.type_id= t.id
GROUP BY t.name;

SELECT type.name, product.name from type
JOIN product
ON type.id  = product.type_id
WHERE type.name = 'СЫР' or type.name = 'МОЛОКО';

SELECT t.name, count(t.name)
FROM product as p
JOIN type as t
ON p.type_id= t.id
GROUP BY t.name
HAVING count(t.name) < 10;

SELECT p.name, t.name
FROM product as p
JOIN type as t
ON p.type_id= t.id
GROUP BY p.name, t.name;



