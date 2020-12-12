CREATE TABLE cars
(
    id    INTEGER PRIMARY KEY AUTO_INCREMENT,
    model  TEXT    NOT NULL,
    city  TEXT    NOT NULL,
    price INTEGER NOT NULL CHECK ( price > 0 )
);


