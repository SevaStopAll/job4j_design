create table devices(
    id serial primary key,
    name varchar(250),
    count int
);

insert into devices(name, count)
values('Xiaomi 12T', 10), ('Iphone 12', 7), ('Iphone 13 Pro', 5), ('Nokia 3310', 1), ('Honor 6a', 5);

insert into devices(name, count)
values('Xiaomi Redmi Note 9', 10), ('Ihone 11', 7), ('Realme Narzo 9', 5), ('Samsung S22', 1), ('Samsung Galaxy Fold', 5);

insert into devices(name, count)
values('One Plus Ace', 10), ('One Plus Nord 2', 7), ('One Plus 10T', 5), ('Realme C3', 1), ('Realme GT', 5);

insert into devices(name, count)
values('Huawei P50', 10), ('Huawey P40', 7), ('Redmi Pad 5', 5), ('Infinix X2', 1), ('Techno Canon', 5);

begin transaction;

declare
    cursor_count SCROLL cursor for
            select * from devices;

fetch last from cursor_count;

MOVE BACKWARD 6 from cursor_count;

fetch next from cursor_count;

MOVE BACKWARD 9 from cursor_count;

fetch next from cursor_count;

MOVE BACKWARD 6 from cursor_count;

fetch next from cursor_count;

fetch prior from cursor_count;

close cursor_count;

commit;
