create table countries(
    id serial primary key,
    name varchar(250),
    population int
);

create table capitals(
    id serial primary key,
    name varchar(250),
    country_id references countries(id) unique
);