-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ecommerce
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `prodotti`
--

DROP TABLE IF EXISTS `prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prodotti` (
  `idprodotti` int(11) NOT NULL,
  `nome` varchar(15) NOT NULL,
  `descrizione` varchar(60) DEFAULT NULL,
  `tipo` varchar(15) NOT NULL,
  `quantita` int(3) DEFAULT '0',
  `prezzo` float DEFAULT '19.9',
  `taglia` varchar(3) NOT NULL,
  `colore` varchar(45) NOT NULL DEFAULT 'nero',
  PRIMARY KEY (`idprodotti`),
  UNIQUE KEY `idprodotti_UNIQUE` (`idprodotti`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotti`
--

LOCK TABLES `prodotti` WRITE;
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;
INSERT INTO `prodotti` VALUES (1,'T-SHIRT CLFN','T-shirt in morbido cotone sfoggia un design bicolore','Maglietta',15,15,'UN','Rosso'),(2,'T-SHIRT HIVERN','T-shirt in lana sfoggia un design unicolor bianco','Maglietta',10,50,'UN','Giallo'),(3,'T-SHIRT ZZLP','T-shirt in morbido cotone con decorazioni di vario genere','Maglietta',10,20,'UN','Bianco'),(4,'T-SHIRT SHOCK','T-shirt in morbido cotone con LOGO SHOCK','Maglietta',15,25,'UN','Verde'),(5,'T-SHIRT EAZY','T-shirt in morbido cotone con  LOGO EZY','Maglietta',15,10,'M','Viola'),(6,'T-SHIRT GOSH','T-shirt in morbido cotone con LOGO FIZAR','Maglietta',10,1,'UN','BLUE');
/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-01 16:19:57
