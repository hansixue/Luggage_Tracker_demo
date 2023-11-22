CREATE TABLE stuff (
    id INT UNSIGNED PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE location(
       id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
       storage enum("A","B","C","D","E","O","W","N","L") NOT NULL,
       place_number TINYINT UNSIGNED,
       discribe VARCHAR(255)
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


insert into stuff (id, name) values (2020200199, 'hansixue');

insert into location(storage,place_number) values ("A",1),("A",2),("A",3),("L",null);

INSERT INTO guest_luggage (tag_number, amount, kept_place, kept_time, kept_stuff_id, pickup_time, picked_up_time, passed_by_stuff_id)
VALUES
    (800001, 1, 1, '2023-11-05 09:00:00', 2020200199, '2023-11-07 10:30:00', NULL, NULL),
    (800002, 2, 2, '2023-11-05 14:15:00', 2020200199, '2023-11-07 16:45:00', NULL, NULL),
    (800003, 1, 3, '2023-11-06 11:20:00', 2020200199, '2023-11-08 13:10:00', NULL, NULL),
    (800004, 1, 4, '2023-11-06 15:30:00', 2020200199, '2023-11-08 17:00:00', NULL, NULL),
    (800005, 1, 1, '2023-11-07 09:45:00', 2020200199, '2023-11-09 11:15:00', NULL, NULL),
    (800006, 2, 2, '2023-11-07 14:00:00', 2020200199, '2023-11-09 16:30:00', NULL, NULL),
    (800007, 1, 3, '2023-11-08 12:30:00', 2020200199, '2023-11-10 14:15:00', NULL, NULL),
    (800008, 1, 4, '2023-11-08 16:45:00', 2020200199, '2023-11-10 18:00:00', NULL, NULL),
    (800009, 1, 1, '2023-11-09 10:00:00', 2020200199, '2023-11-11 11:30:00', NULL, NULL),
    (800010, 2, 2, '2023-11-09 14:20:00', 2020200199, '2023-11-11 16:40:00', NULL, NULL);
