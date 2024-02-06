/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.4.8-MariaDB : Database - projekat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`projekat` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `projekat`;

/*Table structure for table `automobil` */

DROP TABLE IF EXISTS `automobil`;

CREATE TABLE `automobil` (
  `automobilID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `marka` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `godiste` int(11) DEFAULT NULL,
  `tip` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dodaci` tinyint(1) DEFAULT NULL,
  `polovno` tinyint(1) DEFAULT NULL,
  `cenaBezPDV` double DEFAULT NULL,
  `cenaSaPDV` double DEFAULT NULL,
  PRIMARY KEY (`automobilID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `automobil` */

insert  into `automobil`(`automobilID`,`marka`,`godiste`,`tip`,`dodaci`,`polovno`,`cenaBezPDV`,`cenaSaPDV`) values 
(6,'BMW',2016,'Limuzina',1,0,15089,15109),
(7,'Reanult',2008,'Hatchback',1,1,3500,3520),
(8,'Mercedes Benz',2000,'Limuzina',0,1,2500,2520),
(9,'Fiat Punto Grande',2008,'Hatchback',0,1,3450,3470),
(10,'Pegeuot 208 1.6 HDI',2011,'Hatchback',1,1,4000,4020),
(11,'Citroen C3',2010,'Hatchback',1,1,3000,3020),
(14,'Golf 5',2016,'Hatchback',0,1,5040,5060),
(32,'Renault Clio',2010,'Hatchback',0,1,6500,6520),
(34,'Fiat',2016,'Limuzina',0,0,1500,1520);

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `korisnikID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `imeKorisnika` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezimeKorisnika` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `jmbg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`korisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `korisnik` */

insert  into `korisnik`(`korisnikID`,`imeKorisnika`,`prezimeKorisnika`,`jmbg`,`username`,`password`) values 
(5,'Mateja','Musa','0609000730089','mateja','mateja'),
(6,'Dusan','Milovanovic','2010000312643','dusan','dusan'),
(7,'Luka','Zivkovic','21019989746155','luka','luka'),
(8,'Neda','Vukovic','141098974147','neda','neda');
/*Table structure for table `kupac` */

DROP TABLE IF EXISTS `kupac`;

CREATE TABLE `kupac` (
  `kupacID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `imeKupca` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezimeKupca` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adresa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `brojTelefona` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`kupacID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `kupac` */

insert  into `kupac`(`kupacID`,`imeKupca`,`prezimeKupca`,`adresa`,`brojTelefona`,`email`) values 
(5,'Filip','Djordjevic','Glasinacka 47','063458911','filip@gmail.com'),
(6,'Dragoslav','Jankovic','Batajnicka 7','065477961','gagi@gmail.com'),
(7,'Petar','Janjusevic','Njegoseva 19','069784155','pidzej@gmail.com'),
(8,'Andjela','Nenadovic','Ustanicka 144','0654886370','andja@gmail.com'),
(10,'Nemanja','Pavlovic','Niska 7','069874152','neca@gmail.com'),
(11,'Veljko','Dimitrijevic','Glasinacka 12','064787142','velja@yahoo.com');

/*Table structure for table `narudzbina` */

DROP TABLE IF EXISTS `narudzbina`;

CREATE TABLE `narudzbina` (
  `narudzbinaID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `datumIzdavanja` date DEFAULT NULL,
  `ukupanIznosBezPDV` double DEFAULT NULL,
  `ukupanIznosSaPDV` double DEFAULT NULL,
  `kupacID` bigint(20) unsigned DEFAULT NULL,
  `korisnikID` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`narudzbinaID`),
  KEY `kupacID` (`kupacID`),
  KEY `korisnikID` (`korisnikID`),
  CONSTRAINT `narudzbina_ibfk_1` FOREIGN KEY (`kupacID`) REFERENCES `kupac` (`kupacID`),
  CONSTRAINT `narudzbina_ibfk_2` FOREIGN KEY (`korisnikID`) REFERENCES `korisnik` (`korisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `narudzbina` */

insert  into `narudzbina`(`narudzbinaID`,`datumIzdavanja`,`ukupanIznosBezPDV`,`ukupanIznosSaPDV`,`kupacID`,`korisnikID`) values 
(20,'2021-01-29',20589,20649,8,7),
(21,'2021-01-29',8000,8040,5,5),
(23,'2021-01-28',7450,7490,10,5),
(24,'2021-01-28',3500,3520,11,8);

/*Table structure for table `stavkanaruzbine` */

DROP TABLE IF EXISTS `stavkanaruzbine`;

CREATE TABLE `stavkanaruzbine` (
  `narudzbinaID` bigint(20) unsigned NOT NULL,
  `stavkaNarudzbineID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `iznosStavkiNarudzbineBezPDV` double DEFAULT NULL,
  `iznosStavkiNarudzbineSaPDV` double DEFAULT NULL,
  `automobilID` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`stavkaNarudzbineID`,`narudzbinaID`),
  KEY `automobilID` (`automobilID`),
  CONSTRAINT `stavkanaruzbine_ibfk_1` FOREIGN KEY (`automobilID`) REFERENCES `automobil` (`automobilID`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stavkanaruzbine` */

insert  into `stavkanaruzbine`(`narudzbinaID`,`stavkaNarudzbineID`,`iznosStavkiNarudzbineBezPDV`,`iznosStavkiNarudzbineSaPDV`,`automobilID`) values 
(23,54,4000,4020,10),
(23,55,3450,3470,9),
(24,57,3500,3520,7),
(20,59,15089,15109,6),
(20,60,3000,3020,11),
(20,61,2500,2520,8),
(21,62,6500,6520,32),
(21,63,1500,1520,34);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
