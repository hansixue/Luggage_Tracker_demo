CREATE TABLE stuff (
    id INT UNSIGNED PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE location(
       id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
       storage enum("A","B","C","D","E","O","W","N","L") NOT NULL,
       place_number TINYINT UNSIGNED
);

CREATE TABLE guest_luggage (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tag_number INT UNSIGNED NOT NULL, -- The number written on a paper tag
    amount INT UNSIGNED DEFAULT 1, -- Amount of luggage (default is 1)
    kept_place INT UNSIGNED,
    kept_time DATETIME NOT NULL, -- When the luggage was kept
    kept_stuff_id INT UNSIGNED NOT NULL, -- The ID of the staff member who kept the luggage
    pickup_time DATETIME, -- When the luggage is scheduled for pick-up
    picked_up_time DATETIME, -- When the luggage was actually picked up
    passed_by_stuff_id INT UNSIGNED, -- The ID of the staff member who passed by the luggage
    FOREIGN KEY (kept_place) REFERENCES location(id),
    FOREIGN KEY (kept_stuff_id) REFERENCES stuff(id),
    FOREIGN KEY (passed_by_stuff_id) REFERENCES stuff(id)
);


insert into stuff (id, name) values (2020200199, hansixue);

insert into location(storage,place_number) values ("A",1),("A",2),("A",3),("L");