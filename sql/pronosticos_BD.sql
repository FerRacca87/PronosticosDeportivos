/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 8.0.18 : Database - pronosticos_deportivos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pronosticos_deportivos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `pronosticos_deportivos`;

/*Table structure for table `pronosticos` */

DROP TABLE IF EXISTS `pronosticos`;

CREATE TABLE `pronosticos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `participante` varchar(45) DEFAULT NULL,
  `equipo1` varchar(45) DEFAULT NULL,
  `gana_equipo1` char(1) DEFAULT NULL,
  `empate` char(1) DEFAULT NULL,
  `gana_equipo2` char(1) DEFAULT NULL,
  `equipo2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `pronosticos` */

insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (1,'Mariana','Argentina','X','-','-','Arabia Saudita');
insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (2,'Mariana','Polonia','-','X','-','Mexico');
insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (3,'Mariana','Argentina','X','-','-','Mexico');
insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (4,'Mariana','Polonia','X','-','-','Arabia Saudita');
insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (5,'Mariana','Arabia Saudita','-','-','X','Mexico');
insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (6,'Mariana','Polonia','-','X','-','Argentina');
insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (7,'Pedro','Argentina','X','-','-','Arabia Saudita');
insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (8,'Pedro','Polonia','X','-','-','Mexico');
insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (9,'Pedro','Argentina','X','-','-','Mexico');
insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (10,'Pedro','Polonia','X','-','-','Arabia Saudita');
insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (11,'Pedro','Arabia Saudita','-','X','-','Mexico');
insert  into `pronosticos`(`id`,`participante`,`equipo1`,`gana_equipo1`,`empate`,`gana_equipo2`,`equipo2`) values (12,'Pedro','Polonia','-','-','X','Argentina');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
