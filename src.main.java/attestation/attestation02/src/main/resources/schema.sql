create table if not exists product
(
    id          bigserial
        primary key
        unique,
    description varchar,
    price       int,
    count       int
);

create table if not exists person
(
    id   bigserial
        primary key
        unique,
    name varchar
);

create table if not exists "order"
(
    date              date,
    count_of_products int,
    product_id        bigint
        constraint order_product_id_fk
            references product (id),
    person_id         bigint
        constraint order_person_id_fk
            references person (id)
);

comment on table product is 'Таблица со списком продуктов';
comment on table person is 'Таблица со списком покупателей';
comment on table "order" is 'Таблица со списком заказов';

insert  into product (description, price, count) values ('Молоко', 160, 50);
insert  into product (description, price, count) values ('Хлеб', 45, 20);
insert  into product (description, price, count) values ('Колбаса', 200, 17);
insert  into product (description, price, count) values ('Пельмени', 250, 10);
insert  into product (description, price, count) values ('Майонез', 125, 40);
insert  into product (description, price, count) values ('Сметана', 60, 15);
insert  into product (description, price, count) values ('Творог', 100, 20);
insert  into product (description, price, count) values ('Чай', 90, 30);
insert  into product (description, price, count) values ('Кофе', 180, 20);
insert  into product (description, price, count) values ('Сахар', 75, 10);

insert into person (name) values ('Владислав');
insert into person (name) values ('Алёна');
insert into person (name) values ('Игорь');
insert into person (name) values ('Дмитрий');
insert into person (name) values ('Олег');
insert into person (name) values ('Владимир');
insert into person (name) values ('Наталья');
insert into person (name) values ('Илья');
insert into person (name) values ('Марина');
insert into person (name) values ('Евгений');

insert into "order"(date, count_of_products, product_id, person_id) values (now(), 2, 1, 1);
insert into "order"(date, count_of_products, product_id, person_id) values (now(), 1, 2, 2);
insert into "order"(date, count_of_products, product_id, person_id) values (now(), 3, 3, 3);
insert into "order"(date, count_of_products, product_id, person_id) values (now(), 1, 4, 4);
insert into "order"(date, count_of_products, product_id, person_id) values (now(), 2, 5, 5);
insert into "order"(date, count_of_products, product_id, person_id) values (now(), 5, 7, 6);
insert into "order"(date, count_of_products, product_id, person_id) values (now(), 5, 8, 7);
insert into "order"(date, count_of_products, product_id, person_id) values (now(), 4, 6, 8);
insert into "order"(date, count_of_products, product_id, person_id) values (now(), 1, 10, 9);
insert into "order"(date, count_of_products, product_id, person_id) values (now(), 1, 9, 10);
