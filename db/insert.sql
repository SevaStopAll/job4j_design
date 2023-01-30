insert into role(name)
values('admin'), ('user');

insert into rules(name)
values('create items'),
('delete items'),
('watch items'),
('modify items'),
('make comments');


insert into role_rules(role, rule) values(13, 31);

insert into role_rules(role, rule) values(13, 32);

insert into role_rules(role, rule) values(13, 33);

insert into role_rules(role, rule) values(13, 34);

insert into role_rules(role, rule) values(13, 35);

insert into role_rules(role, rule) values(14, 31);

insert into role_rules(role, rule) values(14, 33);

insert into role_rules(role, rule) values(14, 35);

insert into state(status)
values('sent'), ('in work'), ('waiting for details'), ('done');

insert into category(category)
values('software'), ('hardware');

insert into users(name, role)
values('Alexey Ivanov', 13),
('Maxim Petrov', 14),
('Igor Vasiliev', 14);


insert into item(name, user_id, description, item_category, item_state)
values ('Micro does not work', 6, 'I can not turn on micro, i have a meet up in 1 hour', 6, 9);

insert into item(name, user_id, description, item_category, item_state)
values ('Cant login in mail', 7, 'My mail does not work correctly, my login is blocked mb', 5, 9);

insert into attachs(description, item_id)
values ('Here is what OS shows in sound menu. There is no micros at all', 8);

insert into comments(text, request_id)
values ('Did you connect your micro to the PC?', 8);

