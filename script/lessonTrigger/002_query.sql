create or replace function add_tax()
returns trigger as
    $$
    BEGIN
        update products
        set price = price + price * 0.2
        where id in (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create or replace trigger add_tax_triger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure add_tax();

insert into products (name, producer, count, price)
VALUES
    ('product_4', 'producer_4', 1, 10),
    ('product_5', 'producer_5', 1, 10);

drop trigger add_tax_triger on products;
drop function add_tax();

create or replace function all_tax()
returns trigger as
    $$
    BEGIN
        new.price = new.price - new.price *0.2;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create or replace trigger all_tax_trigger
    before insert on products
    for each row
    execute procedure all_tax();

insert into products (name, producer, count, price)
VALUES
    ('product_6', 'producer_6', 1, 10),
    ('product_7', 'producer_7', 1, 10);

drop trigger all_tax_trigger on products;
drop function all_tax();

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price int,
    date timestamp
);

create or replace function add_history_product()
returns trigger as
    $$
    BEGIN
        insert into history_of_price (name, price, date)
        VALUES (new.name, new.price, now());
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create or replace trigger add_history_product_trigger
    after insert on products
    for each row
    execute procedure add_history_product();

insert into products (name, producer, count, price)
VALUES
    ('product_8', 'producer_8', 1, 10),
    ('product_9', 'producer_9', 1, 20);

