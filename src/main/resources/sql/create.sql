create table if not exists exercises(
    exercise_id serial primary key,
    exercise_name varchar(150) not null unique,
    description text
);

create table if not exists trainings(
    training_id serial primary key,
    training_info text
);

create table if not exists training_set(
    ts_id serial primary key,
    exercise_id int,
    training_id int,
    number_of_exercise int not null,
    foreign key(exercise_id) references exercises(exercise_id),
    foreign key(training_id) references trainings(training_id)
);

create table if not exists events(
    event_id serial primary key,
    event_date timestamp not null,
    cycle_start date,
    cycle_end date,
    day_shorts varchar(3)
);

create table if not exists event_set(
    es_id serial primary key,
    event_id int,
    ts_id int,
    foreign key(event_id) references events(event_id),
    foreign key(ts_id) references training_set(ts_id)
);

create table if not exists user_event(
    user_id int not null,
    es_id int,
    foreign key(es_id) references event_set(es_id),
    primary key(user_id, es_id)
);

