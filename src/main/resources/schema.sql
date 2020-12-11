CREATE TABLE cars
(
    id      INTEGER PRIMARY KEY AUTO_INCREMENT,
    owner_id INTEGER NOT NULL,
    name    TEXT    NOT NULL,
    city    TEXT    NOT NULL,
    price   INTEGER NOT NULL CHECK ( price > 0 )
);

CREATE TABLE owners
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);
