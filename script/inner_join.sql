select item.name as Заявка, users.name as Пользователь from item
join users on item.user_id=users.id
;

select role.name as Роль, rules.name as ПраваРолей from role_rules as rr
join role on rr.role_id = role.id
join rules on rr.rule_id = rules.id
;

select role.name as Роль, users.name as Пользователь from role
join users on role.id = users.role_id
;