create table departments(
	id serial primary key,
	name varchar(255)
);

create table emploers(
	id serial primary key,
	name varchar(255),
	department_id int references departments(id)
);

insert into departments(name) values('Администрация');
insert into departments(name) values('Бухгалтерия');
insert into departments(name) values('IT');
insert into departments(name) values('Транспорт');
insert into departments(name) values('Склад');

insert into emploers(name, department_id) values('Иван Иванов', 1);
insert into emploers(name, department_id) values('Сергей Петров', 2);
insert into emploers(name, department_id) values('Мария Шишкина', 1);
insert into emploers(name, department_id) values('Александр Пушкин', 3);
insert into emploers(name, department_id) values('Алексей Симонов', 2);
insert into emploers(name, department_id) values('Евгения Волк', 1);
insert into emploers(name, department_id) values('Соня Карк', 5);
insert into emploers(name, department_id) values('Иван Сидоров', 5);
insert into emploers(name, department_id) values('Катя Катина', 2);