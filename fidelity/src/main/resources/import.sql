REPLACE INTO `Account` (`account_id`, `total_points`) VALUES (1, 200), (2, 0), (3, 300);

/*
REPLACE INTO `Artist` (`idArtist`, `name`) VALUES (1,'Radiohead'),(2,'Billie Eillish'),(3,'French Cowboy');



REPLACE INTO `Customer` (`idCustomer`, `email`, `fname`, `lname`) VALUES (1,'nicolas.herbaut@univ-paris1.fr','nicolas','herbaut');


REPLACE INTO `Location` (`idLocation`, `name`, `standingGauge`) VALUES (1,'Bordeaux Akea Arena',2000),(2,'Le Moulin (Marseille)',800),(3,'Espace 3000 (Hyères)',200);


REPLACE INTO `Seat` (`idVenue`, `seatReference`, `sold`) VALUES (1,'ABC-01',_binary '\0'),(1,'ABC-02',_binary '\0'),(1,'ABC-03',_binary '\0'),(1,'ABC-04',_binary '\0'),(1,'ABC-05',_binary '\0'),(1,'ABC-06',_binary '\0'),(1,'ABC-07',_binary '\0'),(1,'ABC-08',_binary '\0'),(1,'ABC-09',_binary '\0'),(1,'ABC-10',_binary '\0'),(1,'ABC-11',_binary '\0'),(1,'ABC-12',_binary '\0'),(1,'ABC-13',_binary '\0'),(1,'ABC-14',_binary '\0'),(1,'ABC-15',_binary '\0'),(2,'ABC-01',_binary '\0'),(2,'ABC-02',_binary '\0'),(2,'ABC-03',_binary '\0'),(2,'ABC-04',_binary '\0'),(2,'ABC-05',_binary '\0'),(2,'ABC-06',_binary '\0'),(2,'ABC-07',_binary '\0'),(2,'ABC-08',_binary '\0'),(2,'ABC-09',_binary '\0'),(2,'ABC-10',_binary '\0'),(2,'ABC-11',_binary '\0'),(2,'ABC-12',_binary '\0'),(2,'ABC-13',_binary '\0'),(2,'ABC-14',_binary '\0'),(2,'ABC-15',_binary '\0');





REPLACE INTO `Vendor` (`idVendor`, `name`) VALUES (1,'fnac'),(2,'ticket master');


REPLACE INTO `Venue` (`idVenue`, `venueDate`, `idLocation`) VALUES (1,'2022-06-06',1),(2,'2022-06-06',1),(3,'2021-02-03',3),(4,'2022-01-03',2);


REPLACE INTO `VenueLineUp` (`idVenue`, `showTime`, `artist_idArtist`) VALUES (1,'20:00',1),(2,'22:00',1),(2,'19:30',2),(3,'22:00',3);


REPLACE INTO `VenueQuota` (`seatingQuota`, `standingQuota`, `vendor_idVendor`, `venue_idVenue`) VALUES (10,20,1,2),(15,50,2,1),(5,5,2,2),(0,0,2,3);


REPLACE INTO `Ticket` (`idTicket`, `seatReference`, `ticketKey`, `validUntil`, `idCustomer`, `idVendor`, `idVenue`) VALUES (1,NULL,'dummyKey',NULL,1,1,1),(2,'ABC-01','dummyKey',NULL,1,2,1);
*/