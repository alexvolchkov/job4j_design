
create table customers (
                           id serial primary key,
                           first_name text,
                           last_name text,
                           age int,
                           country text
);

CREATE TABLE orders(
                       id serial primary key,
                       amount int,
                       customer_id int references customers(id)
);

insert into customers (first_name, last_name, age, country)
VALUES ('Ivan', 'Ivanov', 25, 'Moscow'),
       ('Sergey', 'Petrov', 20, 'Moscow'),
       ('Alex', 'Volk', 18, 'Tver'),
       ('Olga', 'Sidorova', 25, 'Kaluga'),
       ('Inga', 'Ivanova', 20, 'Moscow');

insert into orders (amount, customer_id)
VALUES (1000, 1),
       (500, 2),
       (300, 4);

SELECT * from customers;
SELECT * from orders;

SELECT * FROM customers WHERE id NOT IN (SELECT customer_id from orders);





