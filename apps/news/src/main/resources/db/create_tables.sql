create table news
(
    id_news       serial
        primary key,
    content       varchar(255),
    create_at     timestamp,
    id_author     bigint,
    link_a_source varchar(255),
    title         varchar(255)
);

alter table news
    owner to postgresuser;

create table comment
(
    id_comment serial
        primary key,
    create_at  timestamp,
    id_user    bigint,
    id_news    integer
        constraint fkbptqmm7bn3alb6htitgfrlt95
            references news,
    text       varchar(255)
);

alter table comment
    owner to postgresuser;

create table grade
(
    id_news integer not null
        constraint fkou3r4pxgpp34utm7t48jg7slw
            references news,
    id_user integer not null,
    grade   boolean,
    primary key (id_news, id_user)
);

alter table grade
    owner to postgresuser;

create table image
(
    name    varchar(255) not null
        primary key,
    id_news integer
        constraint fknkilp3hduuv9n2ihwglasla3f
            references news
);

alter table image
    owner to postgresuser;


