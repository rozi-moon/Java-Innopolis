create table client
(
    id           bigserial primary key unique,
    name         varchar not null,
    birthday     date,
    email        varchar not null,
    password     varchar not null,
    phone_number varchar not null unique,
    deleted      boolean default false
);

comment on table client is 'Таблица пользователей';

create table card
(
    id          bigserial primary key unique,
    number      varchar               not null unique,
    card_type   varchar,
    expiry_date date                  not null,
    balance     bigint  default 0     not null,
    deleted     boolean default false not null,
    user_id     bigint                not null
        constraint "card_client_id_fk"
            references client
);

comment on table card is 'Таблица с банковскими картами';

create table operation
(
    id                 bigserial primary key unique,
    operation          varchar not null,
    transaction_amount bigint  not null,
    operation_date     timestamp not null,
    user_id            bigint  not null
        constraint "operation_client_id_fk"
            references client,
    card_id            bigint  not null
        constraint operation_card_id_fk
            references card
);

comment on table operation is 'Таблица с историей операций';

create sequence operation_seq increment by 50;
create sequence client_seq increment by 50;
create sequence card_seq increment by 50;