CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS photo (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    path TEXT
);
CREATE TABLE candidate (
    id SERIAL PRIMARY KEY,
    name TEXT,
    photo_id int references photo(id)
);