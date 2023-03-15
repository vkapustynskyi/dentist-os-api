--liquibase formatted sql
--changeset volodymyr.kapustynskyi:20230315221500-1

create table my_user
(
    id    bigserial   not null
        constraint my_user_pk primary key,
    uuid  varchar(32) not null unique default gen_random_uuid(),
    email text        not null
);
create unique index my_user_uuid_unique_idx
    on my_user (uuid);


create table my_user_localization
(
    id         bigserial   not null
        constraint my_user_localization_pk primary key,
    uuid       varchar(32) not null default gen_random_uuid(),
    locale     varchar(10),
    first_name text        not null,
    last_name  text        not null,
    patronymic text,
    user_id    bigint      not null,

    constraint my_user_localization_my_user_fk foreign key (user_id)
        references my_user (id)
);
create unique index my_user_localization_uuid_unique_idx
    on my_user_localization (uuid);
create index my_user_localization_my_user_idx
    on my_user_localization (user_id);


create table my_user_details
(
    id                     bigserial   not null
        constraint my_user_details_pk primary key,
    uuid                   varchar(32) not null default gen_random_uuid(),
    user_id                bigint      not null,
    password               text        not null,
    is_account_expired     boolean     not null,
    is_account_locked      boolean     not null,
    is_credentials_expired boolean     not null,
    is_enabled             boolean     not null,

    constraint my_user_details foreign key (user_id)
        references my_user (id)
);
create unique index my_user_details_uuid_unique_idx
    on my_user_details (uuid);
create index my_user_details_my_user_idx
    on my_user_details (user_id);


create table authority
(
    id       bigserial   not null
        constraint authority_pk primary key,
    uuid     varchar(32) not null default gen_random_uuid(),
    name     text        not null,
    icon_url text
);
create unique index authority_uuid_unique_idx
    on authority (uuid);


create table authority_localization
(
    id           bigserial   not null
        constraint authority_localization_pk primary key,
    uuid         varchar(32) not null default gen_random_uuid(),
    display_name text        not null,
    authority_id bigint      not null,

    constraint authority_localization_authority_fk foreign key (authority_id)
        references authority (id)
);
create unique index authority_localization_uuid_unique_idx
    on authority_localization (uuid);
create index authority_localization_authority_idx
    on authority_localization (authority_id);