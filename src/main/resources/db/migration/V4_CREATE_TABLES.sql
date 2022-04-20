create sequence hibernate_sequence start 1 increment 1;

create table exercises (
    exercise_id serial primary key,
    exercise_name varchar(150) unique not null,
    description text
);

create table events (
    event_id serial primary key,
    event_date date not null,
    cycle_start date,
    cycle_end date,
    day_repeat varchar(3),
    parent_event_id int,
    constraint parent_event_fk foreign key(parent_event_id) references events(event_id)
);

create table trainings (
    training_id serial primary key,
    training_info text
);

create table training_set(
    exercise_id int,
    training_id int,
    number_of_exercise int not null,
    constraint exercise_id_fk foreign key(exercise_id) references exercises(exercise_id),
    constraint events_training_id_fk foreign key(training_id) references trainings(training_id),
    constraint training_set_pk primary key(training_id,exercise_id)
);

create table user_event(
    user_id int not null,
    event_id int,
    constraint event_fk foreign key(event_id) references events(event_id),
    constraint user_event_pk primary key(user_id,event_id)
);

create table events_training_sets(
    training_id int,
    exercise_id int,
    events_event_id int,
    constraint training_exercise_fk foreign key(training_id, exercise_id)  references training_set(training_id, exercise_id),
    constraint events_event_id_fk foreign key(events_event_id)  references events(event_id)
)

create table dates_delete(
    dates_delete_id serial primary key,
    date_delete date not null,
    constraint event_fk foreign key(event_id) references events(event_id)
)