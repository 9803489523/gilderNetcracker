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
    foreign key(parent_event_id) references events(event_id)
);

create table trainings (
    training_id serial primary key,
    training_info text
);

create table training_set(
    exercise_id int,
    training_id int,
    number_of_exercise int not null,
    foreign key(exercise_id) references exercises(exercise_id),
    foreign key(training_id) references trainings(training_id),
    primary key(training_id,exercise_id)
);

create table user_event(
    user_id int not null,
    event_id int,
    foreign key(event_id) references events(event_id),
    primary key(user_id,event_id)
);

create table events_training_sets(
    training_id int,
    exercise_id int,
    events_event_id int,
    foreign key(training_id, exercise_id)  references training_set(training_id, exercise_id),
    foreign key(events_event_id)  references events(event_id)
)