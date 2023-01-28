insert into roles(name) values('admin');
insert into roles(name) values('user');

insert into rules(name) values('create items');
insert into rules(name) values('delete items');
insert into rules(name) values('watch items');
insert into rules(name) values('modify items');
insert into rules(name) values('make comments');

insert into role_rules(role, rule) values(1, 1);
insert into role_rules(role, rule) values(1, 2);
insert into role_rules(role, rule) values(1, 3);
insert into role_rules(role, rule) values(1, 4);
insert into role_rules(role, rule) values(1, 5);
insert into role_rules(role, rule) values(1, 1);
insert into role_rules(role, rule) values(1, 3);
insert into role_rules(role, rule) values(1, 5);

insert into state(status) values('sent');
insert into state(status) values('in work');
insert into state(status) values('waiting for details');
insert into state(status) values('done');

insert into category(category) values('software');
insert into category(category) values('hardware');

insert into users(name, role) values('Alexey Ivanov', 1);
insert into users(name, role) values('Maxim Petrov', 2);
insert into users(name, role) values('Igor Vasiliev', 2);

insert into item(name, user_id, description, item_category, item_state) values ('Micro does not work', 2, 'I can not turn on micro, i have a meet up in 1 hour', 2, 1);
insert into item(name, user_id, description, item_category, item_state) values ('Cant login in mail', 3, 'My mail does not work correctly, my login is blocked mb', 1, 1);
insert into attachs(description, item_id) values ('Here is what OS shows in sound menu. There is no micros at all', 1);
insert into comments(text, request_id, user_id) values ('Did you connect your micro to the PC?', 1, 1);

