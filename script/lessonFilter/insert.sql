insert into type (name) values ('Сыр');
insert into type (name) values ('Молоко');
insert into type (name) values ('Хлеб');
insert into type (name) values ('Мороженое');

insert into product (name, type_id, expired_date, price) values ('Сыр Российский', 1, '2022-1-28', 300);
insert into product (name, type_id, expired_date, price) values ('Сыр Костромской', 1, '2022-2-28', 400);
insert into product (name, type_id, expired_date, price) values ('Сыр Моцарелла', 1, '2021-12-28', 500);
insert into product (name, type_id, expired_date, price) values ('Сыр Гауда', 1, '2022-3-10', 450);
insert into product (name, type_id, expired_date, price) values ('Молоко Простоквашино', 2, '2022-1-25', 60);
insert into product (name, type_id, expired_date, price) values ('Молоко Домик в деревне',2, '2022-2-12', 70);
insert into product (name, type_id, expired_date, price) values ('Молоко Зеленое село', 2, '2022-1-31', 50);

insert into product (name, type_id, expired_date, price) values ('Хлеб Даниловский', 3, '2022-1-28', 50);
insert into product (name, type_id, expired_date, price) values ('Хлеб Дарницкий', 3, '2022-1-10', 40);
insert into product (name, type_id, expired_date, price) values ('Хлеб Советский', 3, '2022-1-31', 40);
insert into product (name, type_id, expired_date, price) values ('Хлеб Нарезной', 3, '2022-1-31', 50);

insert into product (name, type_id, expired_date, price) values ('Мороженое Ванильное', 4, '2021-12-28', 50);
insert into product (name, type_id, expired_date, price) values ('Мороженое Шоколадное', 4, '2022-5-10', 70);
insert into product (name, type_id, expired_date, price) values ('Мороженое Клубничное', 4, '2022-10-30', 80);