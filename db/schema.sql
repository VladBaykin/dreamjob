CREATE TABLE IF NOT EXISTS city(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS photo (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    path TEXT
);

CREATE TABLE IF NOT EXISTS candidate (
    id SERIAL PRIMARY KEY,
    name TEXT,
    memo TEXT,
    photo_id INT REFERENCES photo(id),
    city_id INT REFERENCES city(id)
);

INSERT INTO city(name) VALUES('Moscow');
INSERT INTO city(name) VALUES('St. Petersburg');
INSERT INTO city(name) VALUES('Ufa');
INSERT INTO city(name) VALUES('Kazan');
INSERT INTO city(name) VALUES('N. Novgorod');
INSERT INTO city(name) VALUES('Volgograd');
INSERT INTO city(name) VALUES('Krasnodar');

CREATE TABLE IF NOT EXISTS post (
    id SERIAL PRIMARY KEY,
    name TEXT,
    description TEXT
);

CREATE TABLE IF NOT EXISTS _user(
    id SERIAL PRIMARY KEY,
    name VARCHAR(511),
    email VARCHAR(255),
    password VARCHAR(255)
);