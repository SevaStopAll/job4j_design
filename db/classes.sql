create table classes(
    id serial primary key,
    name varchar(255),
    students int
);

create table pupils(
    id serial primary key,
    name varchar(255),
    class_id int references classes(id),
    awg_mark real
);

