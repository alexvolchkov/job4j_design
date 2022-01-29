insert into category(name) values('Общие');
insert into category(name) values('Срочные');

insert into state(name) values('В работе');
insert into state(name) values('Выполнен');
insert into state(name) values('Отменен');

insert into role(name) values('Пользователь');
insert into role(name) values('Администратор');

insert into rules(name) values('Чтение заявок');
insert into rules(name) values('Редактирование заявок');
insert into rules(name) values('Создание пользователей');

insert into role_rules(role_id,  rule_id) values(1, 1);
insert into role_rules(role_id,  rule_id) values(1, 2);
insert into role_rules(role_id,  rule_id) values(2, 1);
insert into role_rules(role_id,  rule_id) values(2, 2);
insert into role_rules(role_id,  rule_id) values(2, 3);

insert into users(name, role_id) values('Alex', 1);
insert into users(name, role_id) values('Ivan', 1);
insert into users(name, role_id) values('Oleg', 2);

insert into item(name,  user_id, category_id, state_id) values('item 1', 1, 1, 1);
insert into item(name,  user_id, category_id, state_id) values('item 2', 1, 2, 1);
insert into item(name,  user_id, category_id, state_id) values('item 3', 2, 1, 1);
insert into item(name,  user_id, category_id, state_id) values('item 4', 3, 2, 2);

insert into comments(description,  item_id) values('comment 1', 1);
insert into comments(description,  item_id) values('comment 2', 2);
insert into comments(description,  item_id) values('comment 3', 1);

insert into attachs(name,  item_id) values('attach 1', 1);
insert into attachs(name,  item_id) values('attach 2', 3);
insert into attachs(name,  item_id) values('attach 3', 4);