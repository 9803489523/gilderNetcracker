CREATE SCHEMA challenge;

CREATE TABLE challenge.challenge_record
(
    id                SERIAL PRIMARY KEY,
    text_of_challenge VARCHAR(500) NOT NULL,
    amount_of_points  INTEGER NOT NULL,
    attacker_id       INTEGER NOT NULL,
    catcher_id        INTEGER NOT NULL,
    deadline          TIMESTAMPTZ NOT NULL,
    is_completed      BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE challenge.voting
(
    id             SERIAL PRIMARY KEY,
    challenge_id   INTEGER REFERENCES challenge.challenge_record (id) ON DELETE CASCADE NOT NULL,
    start_datetime TIMESTAMPTZ NOT NULL,
    end_datetime   TIMESTAMPTZ NOT NULL
);

CREATE TABLE challenge.vote
(
    voting_id INTEGER REFERENCES challenge.voting (id) ON DELETE CASCADE NOT NULL,
    user_id   INTEGER NOT NULL,
    PRIMARY KEY (voting_id, user_id)
);
