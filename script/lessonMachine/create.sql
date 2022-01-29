create table bodies(
	id serial primary key,
	name varchar(255)
);

create table engines(
	id serial primary key,
	name varchar(255)
);

create table gearboxes(
	id serial primary key,
	name varchar(255)
);

create table machine(
	id serial primary key,
	name varchar(255),
	body_id int references bodies(id),
	engine_id int references engines(id),
	gearbox_id int references gearboxes(id)
);

insert into bodies (name) values('Кузов 1');
insert into bodies (name) values('Кузов 2');
insert into bodies (name) values('Кузов 3');
insert into bodies (name) values('Кузов 4');
insert into bodies (name) values('Кузов 5');

insert into engines (name) values('Двигатель 1');
insert into engines (name) values('Двигатель 2');
insert into engines (name) values('Двигатель 3');
insert into engines (name) values('Двигатель 4');
insert into engines (name) values('Двигатель 5');

insert into gearboxes (name) values('Коробка передач 1');
insert into gearboxes (name) values('Коробка передач 2');
insert into gearboxes (name) values('Коробка передач 3');
insert into gearboxes (name) values('Коробка передач 4');
insert into gearboxes (name) values('Коробка передач 5');

insert into machine (name, body_id, engine_id, gearbox_id) values('Машина 1', 1, 2, 3);
insert into machine (name, body_id, engine_id, gearbox_id) values('Машина 2', 2, 3, 4);
insert into machine (name, body_id, engine_id, gearbox_id) values('Машина 3', 3, 3, 3);
insert into machine (name, body_id, engine_id, gearbox_id) values('Машина 4', 4, 1, 1);
insert into machine (name, body_id, engine_id, gearbox_id) values('Машина 5', 3, 2, 1);
insert into machine (name, body_id, engine_id, gearbox_id) values('Машина 6', 4, 1, 4);
insert into machine (name, body_id, engine_id, gearbox_id) values('Машина 7', 3, 4, 1);
insert into machine (name, body_id, engine_id, gearbox_id) values('Машина 8', 4, 2, 1);
insert into machine (name, body_id, engine_id, gearbox_id) values('Машина 9', 1, 1, 1);
