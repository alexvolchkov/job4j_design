select m.name Машина, b.name Кузов, e.name Двигатель, g.name КоробкаПередач from machine m
left join bodies b on m.body_id = b.id
left join engines e on m.engine_id = e.id
left join gearboxes g on m.gearbox_id = g.id
;

select b.name from bodies b
left join machine m on b.id = m.body_id
where m.id is null
;

select e.name from engines e
left join machine m on e.id = m.engine_id
where m.id is null
;

select g.name from gearboxes g
left join machine m on g.id = m.gearbox_id
where m.id is null
;