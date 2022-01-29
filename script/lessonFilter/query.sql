select p.name, p.expired_date , p.price from product as p
join type on type.id = p.type_id
where type.name = 'СЫР'
;

select p.name, p.expired_date , p.price from product as p
where lower(p.name) like '%мороженое%'
; 

select p.name, p.expired_date , p.price from product as p
where expired_date < current_date
; 

select p.name, p.expired_date , p.price from product as p
where p.price in (
select max(product.price) from product
)
;  

select type.name, count(p.id) from type
join product as p on type.id = p.type_id
group by type.name
;

select p.name, p.expired_date , p.price from product as p
join type on type.id = p.type_id
where type.name = 'СЫР' or type.name = 'МОЛОКО'
;

select type.name, count(p.id) from type
join product as p on type.id = p.type_id
group by type.name
having count(p.id) < 10
;

select p.name, p.expired_date , p.price, type.name from product as p
join type on type.id = p.type_id
;