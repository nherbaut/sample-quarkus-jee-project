-- Insert data into the hotel table
INSERT INTO hotel (id, name) VALUES
                                 (1, 'Hotel X'),
                                 (2, 'Hotel Y'),
                                 (3, 'Hotel Z');

-- Insert data into the location table
INSERT INTO location (id, address, city, zip_code, country, hotel_id) VALUES
                                                                          (1, '456 Maple St', 'CityX', 54321, 'CountryX', 1),
                                                                          (2, '789 Birch St', 'CityY', 87654, 'CountryY', 2),
                                                                          (3, '012 Pine St', 'CityZ', 21098, 'CountryZ', 3);

-- Insert data into the reservation table
INSERT INTO reservation (id, nbr_guest, user_id, room_id, end_date, start_date) VALUES
                                                                           (1, 3, 2, 1,'2024-01-15 12:00:00', '2024-01-10 14:00:00'),
                                                                           (2, 4, 3, 2,'2024-02-20 10:00:00', '2024-02-15 08:00:00'),
                                                                           (3, 2, 1, 1,'2024-03-25 18:00:00', '2024-03-20 16:00:00');

-- Insert data into the reservation_options table
INSERT INTO reservation_options (id, price, reservation_id, description, name) VALUES
                                                                                   (1, 60, 1, 'Option X Description', 'Option X'),
                                                                                   (2, 40, 2, 'Option Y Description', 'Option Y'),
                                                                                   (3, 35, 3, 'Option Z Description', 'Option Z');

-- Insert data into the room table
INSERT INTO room (id, nbr_bed, price, reservation_id, hotel_id) VALUES
                                                                    (1, 3, 150.0, 1, 1),
                                                                    (2, 2, 120.0, 2, 2),
                                                                    (3, 1, 90.0, 3, 3);

-- Insert data into the status table
INSERT INTO status (id, status) VALUES
                                    (1,'created'),
                                    (2,'payed'),
                                    (3,'confirmed'),
                                    (4,'canceled');

-- Insert data into the user table
INSERT INTO user (id, phone_number, email, first_name, last_name) VALUES
                                                                      (1, 111222333, 'userX@example.com', 'Alex', 'Williams'),
                                                                      (2, 444555666, 'userY@example.com', 'Sam', 'Taylor'),
                                                                      (3, 777888999, 'userZ@example.com', 'Eva', 'Brown');
