create table doctors(
    id serial primary key,
    name varchar(250),
    age int
);

create table patients(
    id serial primary key,
    name varchar(255),
    age int,
    doctor_id int references doctors(id)
);

insert into doctors(name, age) values('Ivan Ivanovich', 49);
insert into doctors(name, age) values('Eugene Sergeevich', 30);
insert into doctors(name, age) values('Alla Petrovna', 25);
insert into doctors(name, age) values('Oleg Vasilievich', 35);

insert into patients(name, age, doctor_id) values ('Anna', 21, 1);
insert into patients(name, age, doctor_id) values ('Dima', 12, 2);
insert into patients(name, age, doctor_id) values ('Nastya', 33, 3);
insert into patients(name, age, doctor_id)values ('Nikolay', 17, 4);
insert into patients(name, age, doctor_id) values ('Lena', 55, 3);
insert into patients(name, age, doctor_id) values ('Vova', 12, 1);
insert into patients(name, age, doctor_id) values ('Kate', 5, 2);

select p.name as FirstName
from patients as p join doctors as d on p.doctor_id = d.id;

select pat.age as "Возраст пациента"
from patients as pat join doctors as docs on pat.doctor_id = docs.id;

select patient.age as "Возраст пациента", patient.doctor_id as "Идентификатор доктора"
from patients as patient join doctors as docs on patient.doctor_id = docs.id;





