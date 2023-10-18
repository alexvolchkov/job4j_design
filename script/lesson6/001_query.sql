
create table people(
                       id serial primary key,
                       first_name VARCHAR(50),
                       last_name VARCHAR(50),
                       phone VARCHAR(50)
);

create index people_last_name on people (last_name desc);
alter index people_last_name rename to people_last_name_desc;
drop index people_last_name_desc;

insert into products (name, count, price) VALUES ('product_1', 1, 5);
insert into products (name, count, price) VALUES ('product_2', 2, 10);
insert into products (name, count, price) VALUES ('product_3', 3, 15);
insert into products (name, count, price) VALUES ('product_4', 4, 20);
insert into products (name, count, price) VALUES ('product_5', 5, 25);
insert into products (name, count, price) VALUES ('product_6', 6, 30);
insert into products (name, count, price) VALUES ('product_7', 7, 35);
insert into products (name, count, price) VALUES ('product_8', 8, 40);
insert into products (name, count, price) VALUES ('product_9', 9, 45);
insert into products (name, count, price) VALUES ('product_10', 10, 50);
insert into products (name, count, price) VALUES ('product_11', 11, 55);
insert into products (name, count, price) VALUES ('product_12', 12, 60);
insert into products (name, count, price) VALUES ('product_13', 13, 65);
insert into products (name, count, price) VALUES ('product_14', 14, 70);
insert into products (name, count, price) VALUES ('product_15', 15, 75);
insert into products (name, count, price) VALUES ('product_16', 16, 80);
insert into products (name, count, price) VALUES ('product_17', 17, 85);
insert into products (name, count, price) VALUES ('product_18', 18, 90);
insert into products (name, count, price) VALUES ('product_19', 19, 95);
insert into products (name, count, price) VALUES ('product_20', 20, 100);

select * from products;

begin;
DECLARE
    cursor_products cursor for
select * from products;

FETCH 10 FROM cursor_products;
FETCH FROM cursor_products;
FETCH FROM cursor_products;

MOVE FORWARD 2 FROM cursor_products;

FETCH NEXT FROM cursor_products;

CLOSE cursor_products;

COMMIT;

BEGIN;

DECLARE
    cursor_products SCROLL CURSOR FOR
    select *
    from products;

FETCH FROM cursor_products;

FETCH NEXT FROM cursor_products;
FETCH PRIOR FROM cursor_products;
FETCH FIRST FROM cursor_products;
FETCH LAST FROM cursor_products;
FETCH ABSOLUTE 10 FROM cursor_products;
FETCH RELATIVE 7 FROM cursor_products;
FETCH FORWARD FROM cursor_products;
FETCH BACKWARD FROM cursor_products;
MOVE BACKWARD 2 FROM cursor_products;
FETCH FROM cursor_products;

close cursor_products;

commit;

BEGIN;

DECLARE
    cursor_products SCROLL CURSOR FOR
    select *
    from products;

FETCH LAST FROM cursor_products;
FETCH RELATIVE -7 FROM cursor_products;
FETCH BACKWARD FROM cursor_products;
MOVE BACKWARD 2 FROM cursor_products;
FETCH BACKWARD FROM cursor_products;

close cursor_products;

commit;




