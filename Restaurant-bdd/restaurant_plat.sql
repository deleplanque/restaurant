-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurant
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Dumping data for table `plat`
--

LOCK TABLES `plat` WRITE;
/*!40000 ALTER TABLE `plat` DISABLE KEYS */;
INSERT INTO `plat` VALUES (1,'pizza','Marguerita','default.png',7,'grande'),(2,'entree','Bruschetta alla parmigiana','default.png',5.9,'chaude'),(3,'entree','Scampis à l\'ail','default.png',8.9,'chaude'),(4,'entree','Scampis crème tomate gratinés a la mozzarella','default.png',9.8,'chaude'),(5,'dessert','Dame blanche','dame-blanche.jpg',4,NULL),(6,'dessert','Dame noire','default.png',4,NULL),(7,'dessert','Coupe colonel','colonel.jpg',5.5,NULL),(8,'dessert','Sorbet mixte','sorbet.jpg',5,NULL),(9,'dessert','Coupe junior','coupe-junior.jpg',3,NULL),(10,'dessert','Café gourmand','cafe-gourmand.png',6.5,NULL),(11,'dessert','Fondant au chocolat','fondant-chocolat.jpg',5.5,NULL),(12,'dessert','Pizza nutellissima','pizza-nutella.png',6,NULL),(13,'pates','Pâtes Bolognaise','default.png',8.5,NULL),(14,'pates','Pâtes 4 Fromages','default.png',9.5,NULL),(15,'pates','Pâtes Maroilles','default.png',9,NULL),(16,'pates','Pâtes Saumon','default.png',9.5,NULL),(18,'pizza','Marguerita','default.png',5.9,'petite'),(19,'pizza','Bolognaise','default.png',6,'petite'),(20,'pizza','Bolognaise','default.png',8,'grande'),(21,'pizza','Jambon','default.png',6,'petite'),(22,'pizza','Jambon','default.png',8,'grande'),(23,'pizza','Pinnochio','default.png',6.2,'petite'),(24,'pizza','Pinnochio','default.png',8.2,'grande'),(25,'pizza','Hawaïenne','default.png',6.5,'petite'),(26,'pizza','Hawaïenne','default.png',8.5,'grande'),(27,'pizza','Capricciosa','default.png',6.5,'petite'),(28,'pizza','Capricciosa','default.png',8.5,'grande'),(29,'pizza','Napolitine','default.png',6.5,'petite'),(30,'pizza','Napolitine','default.png',8.5,'grande'),(31,'pizza','Parmigiana','default.png',7,'petite'),(32,'pizza','Parmigiana','default.png',9,'grande'),(33,'pizza','4 Saisons','default.png',7,'petite'),(34,'pizza','4 Saisons','default.png',9,'grande'),(35,'pizza','Cacciatore','default.png',7,'petite'),(36,'pizza','Cacciatore','default.png',9,'grande'),(37,'pizza','Calzone','default.png',9,'grande'),(38,'pizza','Sicilienne','default.png',7,'petite'),(39,'pizza','Sicilienne','default.png',9,'grande'),(40,'pizza','Kebab','default.png',7,'petite'),(41,'pizza','Kebab','default.png',9,'grande'),(42,'pizza','4 Fromages','default.png',7.5,'petite'),(43,'pizza','4 Fromages','default.png',9.5,'grande'),(44,'pizza','Diavoli','default.png',7.5,'petite'),(45,'pizza','Diavoli','default.png',9.5,'grande'),(46,'pizza','Etna','default.png',7.5,'petite'),(47,'pizza','Etna','default.png',9.5,'grande'),(48,'pizza','Arrabiata','default.png',8,'petite'),(49,'pizza','Arrabiata','default.png',10,'grande'),(50,'pizza','Pescatore','default.png',8,'petite'),(51,'pizza','Pescatore','default.png',10,'grande'),(52,'pizza','Mamma mia','default.png',8.5,'petite'),(53,'pizza','Mamma mia','default.png',10,'grande'),(54,'pizza','Savoyarde','default.png',8,'petite'),(55,'pizza','Savoyarde','default.png',10,'grande'),(56,'pizza','Ch\'ti bella','default.png',8.5,'petite'),(57,'pizza','Ch\'ti bella','default.png',10.9,'grande'),(58,'pizza','Capreta','default.png',8.5,'petite'),(59,'pizza','Capreta','default.png',10.9,'grande'),(60,'pizza','Orientale','default.png',8.5,'petite'),(61,'pizza','Orientale','default.png',10.9,'grande'),(62,'pizza','Chef','default.png',8.5,'petite'),(63,'pizza','Chef','default.png',11,'grande'),(64,'pizza','Cipolata','default.png',8.5,'petite'),(65,'pizza','Cipolata','default.png',11,'grande'),(66,'pizza','Vulcano','default.png',8.5,'petite'),(67,'pizza','Vulcano','default.png',11.3,'grande'),(68,'pizza','Norvegienne','default.png',8.9,'petite'),(69,'pizza','Norvegienne','default.png',11.5,'grande'),(70,'pizza','Jambon de parme','default.png',8.9,'petite'),(71,'pizza','Jambon de parme','default.png',11.8,'grande'),(72,'pizza','Scampis','default.png',9,'petite'),(73,'pizza','Scampis','default.png',12.5,'grande'),(74,'pizza','Di Salvo','default.png',9.2,'petite'),(75,'pizza','Di Salvo','default.png',12.8,'grande'),(76,'entree','Dégustation italienne','default.png',9.8,'froide');
/*!40000 ALTER TABLE `plat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-06 10:15:54