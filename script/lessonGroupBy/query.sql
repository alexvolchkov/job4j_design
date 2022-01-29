select avg(d.price) as СредняяЦена from devices as d;

select p.name, avg(d.price) as СредняяЦена from devices_people as dp
join people as p on p.id = dp.people_id
join devices as d on d.id = dp.device_id
group by p.name
;

select p.name, avg(d.price) as СредняяЦена from devices_people as dp
join people as p on p.id = dp.people_id
join devices as d on d.id = dp.device_id
group by p.name
having avg(d.price) > 5000
;