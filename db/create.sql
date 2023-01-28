create table role(
    id serial primary key,
    name varchar(250),
);

create table rules(
    id serial primary key,
    name varchar(250),
);

create table role_rules(
    id serial primary key,
    role int references role(id),
    rule int refereneces rules(id)
);

create table users(
    id serial primary key,
    name varchar(250),
    role int references role(id)
);

create table item(
    id serial primary key,
    name varchar(250),
    user_id int references users(id);
    description varchar(250),
    item_state int refereneces references state(status),
    item_category int refereneces references category(category)
);

create table comments(
    id serial primary key,
    text varchar(250),
    request_id int references item(id),
    user_id int references users(id)
);

create table attachs(
    id serial primary key,
    description varchar(250),
    item_id int references item(id)
);

create table category(
    id serial primary key,
    category varchar(250)
);

create table state(
    id serial primary key,
    status varchar(250)
);


