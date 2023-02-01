CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers(first_name, last_name, age, country) values('Irina', 'Maratova', 22, 'Russia');
insert into customers(first_name, last_name, age, country) values('Olga', 'Marutova', 40, 'Russia');
insert into customers(first_name, last_name, age, country) values('Karina', 'Lisina', 18, 'Russia');

SELECT first_name, last_name, (SELECT MIN(age) from customers) as min_age from customers;

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

insert into orders(amount, customer_id) values(5, 1);

insert into orders(amount, customer_id) values(5, 2);

SELECT first_name, last_name from customers
where id not in (SELECT customer_id from orders);