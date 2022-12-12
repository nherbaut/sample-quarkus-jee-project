REPLACE INTO `OrderItem` (`ITEM_TYPE`, `item_id`, `item_name`, `item_price`) VALUES ('Sandwich', 0, 'TOASTÉ GRILLED CHEESE', 5.0), ('Sandwich', 1, 'TOASTÉ POULET RACLETTE', 5.0), ('Sandwich', 2, 'CUISINÉ SAUMON AVOCAT', 6.0), ('Sandwich', 3, 'AUTHENTIQUE THON CRUDITÉS', 5.0), ('Dessert', 4, 'FUSETTE AUX FRAMBOISES', 5.0), ('Dessert', 5, 'FUSETTE CHOCOLAT BANANE', 5.50), ('Drink' , 6, 'PEPSI 50cl', 1.50);

REPLACE INTO `Client` (`client_id`, `clientFirstName`, `clientLastName`) VALUES (0, 'Max', 'Verstappen'), (1, 'Nico', 'Roseberg'), (2, 'Lewis', 'Hamilton'), (3, 'Sebastien', 'Vettel');

REPLACE INTO `Employee` (`employee_id`, `firstName`, `lastName`) VALUES (0, 'Liza', 'Watson'), (1, 'Florentino', 'Perez');


/*
REPLACE INTO `Venue` (`idVenue`, `venueDate`, `idLocation`) VALUES (1,'2022-06-06',1),(2,'2022-06-06',1),(3,'2021-02-03',3),(4,'2022-01-03',2);

REPLACE INTO `VenueLineUp` (`idVenue`, `showTime`, `artist_idArtist`) VALUES (1,'20:00',1),(2,'22:00',1),(2,'19:30',2),(3,'22:00',3);

*/