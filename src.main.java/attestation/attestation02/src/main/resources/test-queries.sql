select * from "order";
select * from person where name like 'В%';
select * from product where count > 20;
update person set name = 'Андрей' where id = 3
update product set count = 1000, price = 250 where description = 'Кофе';
update "order" set date = now() where person_id = 3;
delete from "order";
delete from person where id = 10;
delete from product where price = 45;
