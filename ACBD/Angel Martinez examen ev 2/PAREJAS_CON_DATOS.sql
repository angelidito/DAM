CREATE DATABASE  IF NOT EXISTS `mujeres_hombres_matisse` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mujeres_hombres_matisse`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: mujeres_hombres_matisse
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
-- Table structure for table `hombre`
--

DROP TABLE IF EXISTS `hombre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hombre` (
  `id_hombre` int(11) NOT NULL,
  `nombre_hombre` varchar(255) DEFAULT NULL,
  `edad_hombre` int(11) DEFAULT NULL,
  `salario` int(11) DEFAULT NULL,
  `num_pagas` int(11) DEFAULT NULL,
  `retencion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_hombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hombre`
--

LOCK TABLES `hombre` WRITE;
/*!40000 ALTER TABLE `hombre` DISABLE KEYS */;
INSERT INTO `hombre` VALUES (1,'pabirtzen',46,3375,12,18),(2,'pacomi',44,3136,14,20),(3,'pakomi',60,2468,14,16),(4,'pakunda',59,2048,12,16),(5,'palgide',45,2840,14,17),(6,'palvi',35,2259,12,19),(7,'pancracio',54,1545,14,19),(8,'pancrac',55,2802,14,20),(9,'pandalone',20,2572,12,16),(10,'pangartzi',43,2534,12,20),(11,'pantaleo',45,3450,14,19),(12,'pantaleon',61,2936,14,19),(13,'paris',55,1447,14,13),(14,'pascoal',24,1456,12,20),(15,'pascual',37,2173,12,14),(16,'paskal',45,2626,12,17),(17,'paskasi',62,2472,14,12),(18,'pasqual',49,1706,14,18),(19,'patirki',37,1010,12,12),(20,'patrici',22,1570,12,15),(21,'patricio',53,3017,14,15),(22,'patxi',26,2964,14,19);
/*!40000 ALTER TABLE `hombre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mujer`
--

DROP TABLE IF EXISTS `mujer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mujer` (
  `id_mujer` int(11) NOT NULL,
  `nombre_mujer` varchar(255) DEFAULT NULL,
  `edad_mujer` int(11) DEFAULT NULL,
  `id_marido_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_mujer`),
  KEY `marido_fk_idx` (`id_marido_fk`),
  CONSTRAINT `marido_fk` FOREIGN KEY (`id_marido_fk`) REFERENCES `hombre` (`id_hombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mujer`
--

LOCK TABLES `mujer` WRITE;
/*!40000 ALTER TABLE `mujer` DISABLE KEYS */;
INSERT INTO `mujer` VALUES (1,'MARTA',33,13),(2,'MARÍA',59,9),(3,'MIRANDA',27,5),(4,'MACARENA',44,17),(5,'MADANELA',25,20),(6,'MARLEM',54,11),(7,'MADDI',30,2),(8,'MAFALDA',59,8),(9,'MAGALI',60,4),(10,'MAGDALENA',29,3),(11,'MAHETABEL',45,18),(12,'MIRIAM',47,7),(13,'MAIALEN',47,14),(14,'MALVINA',27,12),(15,'MIREIA',60,22),(16,'MERCE',51,6),(17,'MARGARITA',34,16),(18,'MELISA',46,15),(19,'MARTINA',55,21),(20,'MARICA',53,19),(21,'MARTE',38,10),(22,'MARLENA',31,1);
/*!40000 ALTER TABLE `mujer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-16 12:30:17
