create table if not exists news
(
    id_news        SERIAL primary key,
    title          varchar(200),
    content        text,
    create_at      timestamp without time zone NOT NULL,
    id_user        int,
    link_a_source  varchar(500)
);
CREATE SEQUENCE news_id_seq START WITH 3 INCREMENT BY 1;

create table if not exists comment
(
    id_comment     int primary key,
    text           varchar(1000),
    create_at      date,
    id_news        int references news(id_news),
    id_user        int
);

create table if not exists grade
(
    id_news        int references news(id_news) NOT NULL,
    id_user        int NOT NULL,
    grade          int,
    PRIMARY KEY (id_news, id_user)
);

create table if not exists image
(
    name           varchar(255) primary key,
    id_news        int references news(id_news)
);

