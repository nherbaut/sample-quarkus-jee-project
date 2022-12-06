REPLACE INTO `Product` (`product_id`, `product_name`, `product_price`, `product_type`) VALUES (0, 'TOASTÉ GRILLED CHEESE', 5.0, 'SANDWICH'), (1, 'TOASTÉ POULET RACLETTE', 5.0, 'SANDWICH'), (2, 'CUISINÉ SAUMON AVOCAT', 6.0, 'SANDWICH'), (3, 'AUTHENTIQUE THON CRUDITÉS', 5.0, 'SANDWICH'), (4, 'FUSETTE AUX FRAMBOISES', 5.0, 'DESSERT'), (5, 'FUSETTE CHOCOLAT BANANE', 5.50, 'DESSERT'), (6, 'PEPSI 50cl', 1.50, 'BOISSON');

REPLACE INTO `Client` (`client_id`, `clientFirstName`, `clientLastName`) VALUES (0, 'Max', 'Verstappen'), (1, 'Nico', 'Roseberg'), (2, 'Lewis', 'Hamilton'), (3, 'Sebastien', 'Vettel');

REPLACE INTO `Employee` (`employee_id`, `firstName`, `lastName`) VALUES (0, 'Liza', 'Watson'), (1, 'Florent', 'Lousy');

/*REPLACE INTO `productOrder` (Product_ID, Order_ID) VALUES (1, 1), (2, 1), (3, 1);*/

/*REPLACE INTO `Order` (`order_id`, `order_date`, `order_price`, `order_content`, `employee_id`, `employee_id`) VALUES (1, "2022-09-12", 12.3, , 1, 1)*/

/*

REPLACE INTO `Product` (`product_name`, `product_type`, `product_price`) VALUES ('frites', 'accompagnement', 3.5),('poulet frit', 'plat', 7.5);

REPLACE INTO `Venue` (`idVenue`, `venueDate`, `idLocation`) VALUES (1,'2022-06-06',1),(2,'2022-06-06',1),(3,'2021-02-03',3),(4,'2022-01-03',2);

REPLACE INTO `VenueLineUp` (`idVenue`, `showTime`, `artist_idArtist`) VALUES (1,'20:00',1),(2,'22:00',1),(2,'19:30',2),(3,'22:00',3);

*/