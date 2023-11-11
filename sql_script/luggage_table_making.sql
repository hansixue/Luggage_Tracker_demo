CREATE TABLE stuff (
    id INT UNSIGNED PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);



CREATE TABLE guest_luggage (
    id INT UNSIGNED PRIMARY KEY,
    tag_number INT UNSIGNED NOT NULL, -- The number written on a paper tag
    amount INT UNSIGNED DEFAULT 1, -- Amount of luggage (default is 1)
    kept_time DATETIME NOT NULL, -- When the luggage was kept
    kept_stuff_id INT UNSIGNED NOT NULL, -- The ID of the staff member who kept the luggage
    pickup_time DATETIME, -- When the luggage is scheduled for pick-up
    picked_up_time DATETIME, -- When the luggage was actually picked up
    passed_by_stuff_id INT UNSIGNED, -- The ID of the staff member who passed by the luggage
    FOREIGN KEY (kept_stuff_id) REFERENCES stuff(id), -- Assuming you have a 'staff' table
    FOREIGN KEY (passed_by_stuff_id) REFERENCES stuff(id)
);
