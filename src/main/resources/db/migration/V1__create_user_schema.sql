create table privilege
(
    id   bigserial
        primary key,
    name varchar(255)
);

create table "user"
(
    id            bigserial
        primary key,
    country       varchar(255),
    date_of_birth date         not null,
    email         varchar(255),
    gender        varchar(255) not null,
    name          varchar(255),
    password      varchar(255),
    surname       varchar(255),
    enabled       boolean
);

create table user_privilege
(
    user_id      bigint not null
        constraint fk29dor3ienqj1pqs32nt4gqy1
            references "user",
    privilage_id bigint not null
        constraint fk8cn0w4s3ki313fi9vmt27w3oe
            references privilege,
    primary key (user_id, privilage_id)
);

INSERT INTO privilege
VALUES (1, 'DEFAULT');