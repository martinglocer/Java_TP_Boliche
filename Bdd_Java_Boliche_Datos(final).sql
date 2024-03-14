-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: boliche_java
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `asistente`
--

LOCK TABLES `asistente` WRITE;
/*!40000 ALTER TABLE `asistente` DISABLE KEYS */;
INSERT INTO `asistente` VALUES ('dni',12345678,'John','Doe','johndoe@gmail.com','3417692314','2001-02-12',3000,'P@ssword',1),('dni',38214678,'Julia','Roberts','juliarob@gmail.com','3413805555','1970-03-01',200000,'julia123',2),('dni',38976231,'Leo','Di Caprio','leo123','3415629809','1996-12-25',100000,'leo123',2),('dni',40897343,'Pepe','Mujica','pepemujica@gmail.com','3412560934','1999-04-03',0,'pepe123',2),('dni',44624123,'Pedro','Calabrese','pecalabrese@gamil.com','3412314567','2003-01-28',70000,'pedro123',2),('dni',44630606,'Santiago','Spini','santiagospini@gmail.com','3413206430','2003-01-23',10000,'santi123',1),('dni',353469090,'Bill','Gates','bill123','3415690231','1972-09-15',1000000,'bill123',2),('dni',416572309,'Avril','Del Prado','avrudelprado@gmail.com','3412769812','2003-02-10',5000,'avril123',2),('dni',423901234,'Julia','Diaz','juliadiaz@gmail.com','3412318365','2000-12-09',7000,'julia123',2),('dni ',43216980,'Lourdes','Gomez','lougom@gmail.com','3412314507','2002-06-09',4000,'lourdes123',2);
/*!40000 ALTER TABLE `asistente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bebidas`
--

LOCK TABLES `bebidas` WRITE;
/*!40000 ALTER TABLE `bebidas` DISABLE KEYS */;
INSERT INTO `bebidas` VALUES (1,'Vodka','Sky vodka con sprite'),(2,'Fernet','Fernet Branca con Coca-Cola'),(3,'Gin','Gin Heredero con agua tónica'),(4,'Champán','Combo de champán Barón B con 4 redbull');
/*!40000 ALTER TABLE `bebidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bebidas_historico`
--

LOCK TABLES `bebidas_historico` WRITE;
/*!40000 ALTER TABLE `bebidas_historico` DISABLE KEYS */;
INSERT INTO `bebidas_historico` VALUES (1,'2023-11-12 00:00:00',3000),(2,'2023-11-12 00:00:00',3000),(3,'2023-11-12 00:00:00',3000),(4,'2023-11-12 00:00:00',10000);
/*!40000 ALTER TABLE `bebidas_historico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `consumicion`
--

LOCK TABLES `consumicion` WRITE;
/*!40000 ALTER TABLE `consumicion` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (2,'dni ',38214678,1,1,'2023-11-11','13:00:00','2023-11-07','13:24:54'),(3,'dni ',38976231,1,1,'2023-11-11','13:00:00','2023-11-07','17:04:45'),(5,'dni ',12345678,4,4,'2023-12-16','14:00:00','2023-11-06','16:12:04'),(8,'dni ',44630606,2,1,'2023-11-18','15:00:00','2023-11-02','11:54:07');
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `fiesta`
--

LOCK TABLES `fiesta` WRITE;
/*!40000 ALTER TABLE `fiesta` DISABLE KEYS */;
INSERT INTO `fiesta` VALUES (1,'Crean','Fiesta Crean primavera-verano desde las 13 hs hasta las 23 hs'),(2,'Coco','Fiesta Coco primavera-verano desde las 16 hs hasta la 1 hs'),(3,'Lova','Fiesta boliche Lova de 23 hs a 5 hs'),(4,'Plumazo','Fiesta del Seven Plumazo en club CAE, Santa Fe');
/*!40000 ALTER TABLE `fiesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `fiesta_lugar`
--

LOCK TABLES `fiesta_lugar` WRITE;
/*!40000 ALTER TABLE `fiesta_lugar` DISABLE KEYS */;
INSERT INTO `fiesta_lugar` VALUES (1,1,'2023-11-11','13:00:00'),(2,1,'2023-11-18','15:00:00'),(2,2,'2023-11-25','15:00:00'),(3,3,'2023-11-25','23:00:00'),(1,4,'2023-12-09','13:00:00'),(4,4,'2023-12-16','14:00:00'),(2,3,'2023-12-20','18:00:00'),(4,1,'2023-12-27','20:30:00'),(4,4,'2024-01-07','23:00:00'),(2,4,'2024-01-23','16:00:00'),(2,4,'2024-01-27','17:00:00');
/*!40000 ALTER TABLE `fiesta_lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,'Isla','Isla Rio 2431',1500,'Rosario'),(2,'Tierra de Sueños','Funes 5437',1000,'Rosario'),(3,'Metropolitano ','Junín 501',800,'Rosario'),(4,'Club CAE','3 de febrero 608',2000,'Santa Fe');
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `precios_fiestas_historicos`
--

LOCK TABLES `precios_fiestas_historicos` WRITE;
/*!40000 ALTER TABLE `precios_fiestas_historicos` DISABLE KEYS */;
INSERT INTO `precios_fiestas_historicos` VALUES (1,'2023-11-12 00:00:00',3500),(2,'2023-11-12 00:00:00',3000),(3,'2023-11-12 00:00:00',3500),(4,'2023-11-12 00:00:00',8000);
/*!40000 ALTER TABLE `precios_fiestas_historicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'admin'),(2,'usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-14 11:51:18
