INSERT INTO `Artist` VALUES (1,'Radiohead'),(2,'Billie Eillish'),(3,'French Cowboy');
INSERT INTO `Customer` VALUES (1,'nicolas','herbaut','nicolas.herbaut@univ-paris1.fr');
INSERT INTO `Location` VALUES (1,'Bordeaux Akea Arena',0),(2,'Le Moulin (Marseille)',0),(3,'Espace 3000 (Hyères)',0);
INSERT INTO `Venue` VALUES (1,'2022-06-06',1),(2,'2022-07-06',1),(3,'2021-02-03',3),(4,'2022-01-03',2);
INSERT INTO `Seat` VALUES (1,'ABC-01',0),(2,'ABC-01',0),(1,'ABC-02',0),(2,'ABC-02',0),(1,'ABC-03',0),(2,'ABC-03',0),(1,'ABC-04',0),(2,'ABC-04',0),(1,'ABC-05',0),(2,'ABC-05',0),(1,'ABC-06',0),(2,'ABC-06',0),(1,'ABC-07',0),(2,'ABC-07',0),(1,'ABC-08',0),(2,'ABC-08',0),(1,'ABC-09',0),(2,'ABC-09',0),(1,'ABC-10',0),(2,'ABC-10',0),(1,'ABC-11',0),(2,'ABC-11',0),(1,'ABC-12',0),(2,'ABC-12',0),(1,'ABC-13',0),(2,'ABC-13',0),(1,'ABC-14',0),(2,'ABC-14',0),(1,'ABC-15',0),(2,'ABC-15',0);
INSERT INTO `Vendor` VALUES (1,'fnac'),(2,'ticket master');
INSERT INTO `Ticket` VALUES (1,NULL,1,2,1),(2,'ABC-01',1,2,1);
INSERT INTO `VenueLineUp` VALUES (1,'20:00',1),(1,'22:00',2),(2,'19:30',2),(3,'22:00',3);
INSERT INTO `VenueQuota` VALUES (1,10,1,1),(1,5,1,2),(2,15,2,1),(3,0,2,2);
