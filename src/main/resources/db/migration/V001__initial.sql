create table if not exists owner(
    owner_id bigint primary key,
    owner_last_name varchar(50),
    owner_first_name varchar(50),
    owner_email varchar(75)
);

create sequence owner_seq;

create table if not exists cat(
    cat_id bigint primary key,
    cat_name varchar(50),
    cat_breed varchar(100),
    cat_age int,
    cat_owner_id bigint
);

create sequence cat_seq;

create table if not exists profile(
    profile_id bigint primary key,
    profile_language varchar(50),
    profile_timezone varchar(25),
    profile_owner_id bigint
);

create sequence profile_seq;
