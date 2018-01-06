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
-- Dumping data for table `boisson`
--

LOCK TABLES `boisson` WRITE;
/*!40000 ALTER TABLE `boisson` DISABLE KEYS */;
INSERT INTO `boisson` VALUES (1,'aperitif','Nikka','',7.5,NULL),(2,'vin','1 Litre','pichet.jpg',14,'patron'),(3,'vin','1/2','pichet.jpg',7.5,'patron'),(4,'vin','1/4','pichet.jpg',4,'patron'),(5,'digestif','Amaretto','amaretto.jpg',4,NULL),(6,'aperitif','Amaretto coca','amaretto.jpg',4,NULL),(7,'aperitif','Amaretto orange','amaretto.jpg',4,NULL),(8,'aperitif','Bacardi coca','bacardi.jpg',3.8,NULL),(9,'vin','Bardolino','bardolino.jpg',15.9,'rose'),(10,'vin','Barolo','barolo.jpg',36,'rouge'),(11,'chaude','Café long','cafe.png',2,NULL),(12,'digestif','Calvados','calvados.jpg',5.5,NULL),(13,'chaude','Cappuccino','Cappuccino.jpg',2.6,NULL),(14,'vin','Chianti','chianti.jpg',16.8,'rouge'),(15,'soft','Coca cola','coca.png',2.6,NULL),(16,'soft','Coca cola light','coca-light.png',2.6,NULL),(17,'soft','Coca cola zéro','coca_zero.png',2.6,NULL),(18,'digestif','Cognac','cognac.jpg',5,NULL),(19,'biere','Desperados','Desperados.jpg',3.2,'bouteille'),(20,'chaude','Expresso à l\'italienne','express.png',1.9,NULL),(21,'soft','Fanta','fanta.jpg',2.2,NULL),(22,'digestif','Get 27','get27.jpg',3.5,NULL),(23,'aperitif','Get27','get27.jpg',3.5,NULL),(24,'digestif','Grappa','grappa.jpg',4,NULL),(25,'biere','Heineken','heineken.jpg',3,'bouteille'),(26,'soft','Ice tea','ice-tea.jpg',2.2,NULL),(27,'aperitif','Jack Daniels','jack-daniels.jpg',7,NULL),(28,'aperitif','JB','jb.jpg',4.5,NULL),(29,'aperitif','Kin vin blanc','kir_vin_vlanc.jpg',3,NULL),(30,'aperitif','Kir pétillant','Kir_petillant.jpg',4,NULL),(31,'biere','Kriek','kriek.jpg',2.8,'boueille'),(32,'vin','La verre','verre.jpg',2.2,'patron'),(33,'vin','Lambrusco','lambrusco.jpg',10.9,'rouge'),(34,'vin','Lambrusco rose','lambrusco_rose.jpg',10.9,'rose'),(35,'biere','Leffe 15cl','leff_pression.jpg',1.8,'pression'),(36,'biere','Leffe 25cl','leff_pression.jpg',3.2,'pression'),(37,'biere','Leffe 33cl','leff_pression.jpg',4,'pression'),(38,'biere','Leffe 50cl','leff_pression.jpg',5.9,'pression'),(39,'vin','Les Hauts de Goelane','chateau-les-hauts-de-goelane.jpg',5.9,'petiteBouteille'),(40,'digestif','Limoncello','limoncello.jpg',4,NULL),(41,'digestif','Marsala','marsala.jpg',3,NULL),(42,'aperitif','Marsala 8cl ','marsala.jpg',3,NULL),(43,'aperitif','Martini blanc','martini-blanc.jpg',3,NULL),(44,'aperitif','Martini rouge','martini-rouge.jpg',3,NULL),(45,'soft','Minute maid orange','minute-maid-orange.jpg',2.2,NULL),(46,'vin','Montepulciano','montepulciano.jpg',17.9,'rouge'),(47,'biere','Moretti','moretti.jpg',4,'bouteille'),(48,'biere','Nastra azzuro','nastra-azzuro.jpg',4,'bouteille'),(49,'vin','Nero d\'Avola','nerodavola.jpg',15.9,'rouge'),(50,'soft','Oasis tropical','oasis-tropical.jpg',2.2,NULL),(51,'biere','Pelforth brune','pelforth-brune.jpg',2.8,'bouteille'),(52,'soft','Perrier','perrier.jpg',2.2,NULL),(53,'vin','Pinot Grigio','pinot-grigio.jpg',15.8,'blanc'),(54,'aperitif','Porto blanc','porto_blanc.jpg',3,NULL),(55,'aperitif','Porto rouge','porto_rouge.jpg',3,NULL),(56,'aperitif','Ricard','ricard.jpg',4,NULL),(57,'biere','Rince cochon','Rince_Cochon.jpg',4.5,'bouteille'),(58,'vin','Rochemazet','roche-mazet.jpg',4.9,'petiteBouteille'),(59,'digestif','Sambuca','sambuca.jpg',4,NULL),(60,'soft','San pellegrino 1L','san-pellegrino.jpg',5,NULL),(61,'soft','San pellegrino 50cl','san-pellegrino.jpg',3,NULL),(62,'soft','Schweppes','schweppes-agrumes.jpg',2.2,NULL),(63,'soft','Sprite','sprite.jpg',2.2,NULL),(64,'chaude','Thé','tea.jpg',1.9,NULL),(65,'biere','Tripel karmeliet','tripel-karmeliet.jpg',4.5,'bouteille'),(66,'vin','Verdicchio','Verdicchio.jpg',11.9,'blanc'),(67,'soft','Vittel 1L','vittel_50_cl.jpg',5,NULL),(68,'soft','Vittel 50cl','vittel_50_cl.jpg',3,NULL),(69,'aperitif','Vodka','vodka.jpg',4,NULL);
/*!40000 ALTER TABLE `boisson` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-06 10:15:55
