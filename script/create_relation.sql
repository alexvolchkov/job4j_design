create table accounts(
    id serial primary key,
    login varchar(255)
);

create table customers(
    id serial primary key,
    name varchar(255),
    account_id int references accounts(id) unique
);

create table items(
    id serial primary key,
    name varchar(255)
);

create table orders(
    id serial primary key,
    customer_id int references customers(id),
    item_id int references items(id)	
);