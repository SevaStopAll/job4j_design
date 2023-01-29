create table projects(
    id serial primary key,
    name varchar(250),
    involved int
);

create table people(
    id serial primary key,
    name varchar(250),
    degree varchar(250)
);

create table projects_people(
    id serial primary key,
    project_id int references projects(id),
    worker_id int references people(id)
);