INSERT INTO hotel (id, name) VALUES
                             (1,'Hotel A'),
                             (2,'Hotel B'),
                             (3,'Hotel C');
INSERT INTO location (id,address, city, zip_code, country, hotel_id) VALUES
                                                                      (1,'123 Main St', 'City1', 12345, 'Country1', 1),
                                                                      (2,'456 Oak St', 'City2', 67890, 'Country2', 2),
                                                                      (3,'789 Pine St', 'City3', 98765, 'Country3', 3);
INSERT INTO reservation (id,nbr_guest, user_id, room_id,  end_date, start_date) VALUES
                                                                           (1,2, 1, 1, '2024-01-10 12:00:00', '2024-01-05 14:00:00'),
                                                                           (2,3, 2, 2, '2024-02-15 10:00:00', '2024-02-10 08:00:00'),
                                                                           (3,1, 3, 1, '2024-03-20 18:00:00', '2024-03-15 16:00:00');
INSERT INTO reservation_options (id,price, reservation_id, description, name) VALUES
(1,50, 1, 'Option A Description', 'Option A'),
(2,30, 2, 'Option B Description', 'Option B'),
(3,25, 3, 'Option C Description', 'Option C');
INSERT INTO room (id,nbr_bed, price, reservation_id, hotel_id) VALUES
(1,2, 100.0, 1, 1),
(2,1, 75.0, 2, 2),
(3,3, 120.0, 3, 3);
INSERT INTO status (id,status) VALUES
                                (1,'created'),
                                (2,'payed'),
                                (3,'confirmed'),
                                (4,'canceled');
INSERT INTO user (id,phone_number, email, first_name, last_name) VALUES
(1,123456789, 'user1@example.com', 'John', 'Doe'),
(2,987654321, 'user2@example.com', 'Jane', 'Smith'),
(3,555555555, 'user3@example.com', 'Alice', 'Johnson');
