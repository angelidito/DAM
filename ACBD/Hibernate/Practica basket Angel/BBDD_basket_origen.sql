CREATE DATABASE  IF NOT EXISTS `basket_origen` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `basket_origen`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: basket_origen
-- ------------------------------------------------------
-- Server version	5.5.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipos` (
  `id_equipo` int(9) NOT NULL AUTO_INCREMENT,
  `nombre_equipo` varchar(30) NOT NULL,
  `ciudad` varchar(30) NOT NULL,
  `web` varchar(50) DEFAULT NULL,
  `puntos` int(3) DEFAULT '0',
  PRIMARY KEY (`id_equipo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
INSERT INTO `equipos` VALUES (1,'Regal Barcelona','Barcelona','http://www.fcbarcelona.com',10),(2,'Real Madrid','Madrid','http://www.realmadrid.com',9),(3,'P.E. Valencia','Valencia','http://www.valenciabasket.com',11),(4,'Caja Laboral','Vitoria','http://www.baskonia.com',22),(5,'Gran Canaria','Las Palmas','http://www.acb.com',14),(6,'CAI Zaragoza','Zaragoza','http://basketzaragoza.net',23);
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jugadores` (
  `id_jugador` int(9) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `puesto` varchar(30) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `salario` int(9) unsigned DEFAULT NULL,
  `num_equipo` int(9) DEFAULT NULL,
  `altura` int(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_jugador`),
  KEY `equipo_fk_idx` (`num_equipo`),
  CONSTRAINT `equipo_fk` FOREIGN KEY (`num_equipo`) REFERENCES `equipos` (`id_equipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,'Juan Carlos','Navarro','escolta','2010-01-10',130000,1,202),(2,'Felipe','Reyes','pivot','2009-02-20',120000,2,204),(3,'Victor','Claver','alero','2009-03-08',90000,3,208),(4,'Rafa','Martinez','escolta','2010-11-11',51000,3,191),(5,'Fernando','San Emeterio','alero','2008-09-22',60000,4,199),(6,'Mirza','Teletovic','pivot','2010-05-13',70000,4,206),(7,'Sergio','Llull','escolta','2011-10-29',100000,2,190),(8,'Victor','Sada','base','2012-01-01',80000,1,192),(9,'Carlos','Suarez','alero','2011-02-19',60000,2,203),(10,'Xavi','Rey','pivot','2008-10-12',95000,5,209),(11,'Carlos','Cabezas','base','2012-01-21',105000,6,186),(12,'Pablo','Aguilar','alero','2011-06-14',47000,6,203),(13,'Rafa','Hettsheimeir','pivot','2008-04-15',53000,6,208),(14,'Sitapha','Savané','pivot','2011-07-27',60000,5,201);
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidos`
--

DROP TABLE IF EXISTS `partidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partidos` (
  `elocal` int(9) NOT NULL DEFAULT '0',
  `evisitante` int(9) NOT NULL DEFAULT '0',
  `resultado` varchar(7) DEFAULT NULL,
  `resultadolocal` int(3) DEFAULT '0',
  `resultadovisitante` int(3) DEFAULT '0',
  `fecha` date NOT NULL DEFAULT '0000-00-00',
  `arbitro` int(9) DEFAULT NULL,
  PRIMARY KEY (`elocal`,`evisitante`,`fecha`),
  KEY `elocal_fk_idx` (`elocal`),
  KEY `evisitante_fk_idx` (`evisitante`),
  CONSTRAINT `elocal_fk` FOREIGN KEY (`elocal`) REFERENCES `equipos` (`id_equipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `evisitante_fk` FOREIGN KEY (`evisitante`) REFERENCES `equipos` (`id_equipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidos`
--

LOCK TABLES `partidos` WRITE;
/*!40000 ALTER TABLE `partidos` DISABLE KEYS */;
INSERT INTO `partidos` VALUES (1,2,'100-100',100,100,'2011-10-10',4),(1,6,'66-78',66,78,'2011-11-30',6),(2,3,'90-91',90,91,'2011-11-17',5),(2,4,'90-90',90,90,'2012-01-12',7),(3,4,'88-77',88,77,'2011-11-23',6),(3,6,'91-88',91,88,'2012-02-22',3),(4,5,'79-83',79,83,'2012-01-19',3),(5,4,'90-66',90,66,'2012-04-27',2),(6,5,'110-70',110,70,'2012-05-30',1);
/*!40000 ALTER TABLE `partidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vista_1_al_3`
--

DROP TABLE IF EXISTS `vista_1_al_3`;
/*!50001 DROP VIEW IF EXISTS `vista_1_al_3`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vista_1_al_3` (
  `id_jugador` int(9),
  `nombre` varchar(30),
  `apellido` varchar(30)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vista_4_al_6`
--

DROP TABLE IF EXISTS `vista_4_al_6`;
/*!50001 DROP VIEW IF EXISTS `vista_4_al_6`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vista_4_al_6` (
  `altura` int(3) unsigned,
  `salario` int(9) unsigned,
  `num_equipo` int(9)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vista_1_al_3`
--

/*!50001 DROP TABLE IF EXISTS `vista_1_al_3`*/;
/*!50001 DROP VIEW IF EXISTS `vista_1_al_3`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_1_al_3` AS select `jugadores`.`id_jugador` AS `id_jugador`,`jugadores`.`nombre` AS `nombre`,`jugadores`.`apellido` AS `apellido` from `jugadores` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_4_al_6`
--

/*!50001 DROP TABLE IF EXISTS `vista_4_al_6`*/;
/*!50001 DROP VIEW IF EXISTS `vista_4_al_6`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_4_al_6` AS select `jugadores`.`altura` AS `altura`,`jugadores`.`salario` AS `salario`,`jugadores`.`num_equipo` AS `num_equipo` from `jugadores` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-31  9:39:37
