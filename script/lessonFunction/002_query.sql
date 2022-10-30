create or replace procedure delete_data(d_id int)
language 'plpgsql'
as $$
    BEGIN
        delete from products where id = d_id;
    END;
$$;

call delete_data(1);

create or replace function f_delete_data(d_id int)
returns int
language 'plpgsql'
as $$
    DECLARE
        result int;
    BEGIN
        select into result count(*) from products where id = d_id;
        delete from products where id = d_id;
        return result;
    END;
$$;

select f_delete_data(2);
