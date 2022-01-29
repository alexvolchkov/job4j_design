select t1.name as man, t2.name as woman from teens t1
cross join teens t2 
where t1.gender != t2.gender and t1.gender
order by t1.id, t2.id
;
