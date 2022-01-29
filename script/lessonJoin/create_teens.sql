create table teens (
	id serial primary key,
	name varchar(255),
	gender boolean
);

insert into teens(name, gender) values ('Alex', true);
insert into teens(name, gender) values ('Petr', true);
insert into teens(name, gender) values ('Ivan', true);
insert into teens(name, gender) values ('Oleg', true);
insert into teens(name, gender) values ('Olga', false);
insert into teens(name, gender) values ('Irina', false);
insert into teens(name, gender) values ('Natalia', false);
insert into teens(name, gender) values ('Maria', false);
