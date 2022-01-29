select * from departments as d
left join emploers as e on d.id = e.department_id;

select * from departments as d
right join emploers as e on d.id = e.department_id;

select * from departments as d
full join emploers as e on d.id = e.department_id;

select * from departments as d
cross join emploers as e;

select d.name from departments as d
left join emploers as e on d.id = e.department_id
where e.id is null
;

select d.name, e.name from departments as d
left join emploers as e on d.id = e.department_id
order by d.id, e.id;

select d.name, e.name from emploers as e
right join departments as d on d.id = e.department_id
order by d.id, e.id;

select e.name, d.name from emploers as e
left join departments as d on d.id = e.department_id
order by e.id, d.id;

select e.name, d.name from departments as d
right join emploers as e on d.id = e.department_id
order by e.id, d.id;

