CREATE DATABASE  IF NOT EXISTS `boliche_java` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `boliche_java`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: boliche_java
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `asistente`
--

DROP TABLE IF EXISTS `asistente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asistente` (
  `idasistente` int NOT NULL AUTO_INCREMENT,
  `tipo_doc` varchar(20) NOT NULL,
  `nro_doc` varchar(25) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `email` varchar(65) NOT NULL,
  `celular` varchar(25) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `saldo` float DEFAULT '0',
  `password` varchar(30) NOT NULL,
  `idrol` int unsigned NOT NULL,
  PRIMARY KEY (`idasistente`),
  UNIQUE KEY `uc_tipo_nro_doc` (`tipo_doc`,`nro_doc`) /*!80000 INVISIBLE */,
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `celular_UNIQUE` (`celular`),
  KEY `fk_asisf_rol_idx` (`idrol`),
  CONSTRAINT `fk_asisf_rol` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='									';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistente`
--

LOCK TABLES `asistente` WRITE;
/*!40000 ALTER TABLE `asistente` DISABLE KEYS */;
INSERT INTO `asistente` VALUES (18,'dni','12333','ale','glocer','aleglocer@gmail.com','34119','1998-06-19',5000,'3210',2),(19,'dni','12345678','John','Doe','johndoe@gmail.com','3417692314','2001-02-12',3000,'P@ssword',1),(20,'dni','38214678','Julia','Roberts','juliarob@gmail.com','3413805555','1970-03-01',200000,'julia123',2),(21,'dni','38976231','Leo','Di Caprio','leo123','3415629809','1996-12-25',100000,'leo123',2),(22,'dni','40897343','Pepe','Mujica','pepemujica@gmail.com','3412560934','1999-04-03',0,'pepe123',2),(23,'dni','43378974','Martin','Glocer','martinglocer@gmail.com','3415069505','2001-05-12',0,'martin123',1),(24,'dni','44624123','Pedro','Calabrese','pecalabrese@gamil.com','3412314567','2003-01-28',70000,'pedro123',2),(25,'dni','44630606','Santiago','Spini','santiagospini@gmail.com','3413206430','2003-01-23',10000,'santi123',1),(26,'DNI','78945612','Cristiano','Ronaldo','cr7@gg.com','852147','1985-10-17',7500,'cr777',1),(27,'dni','111222333','zeide','kuschner','zeide@gt.com','998877','1943-02-16',1500,'1221',2),(28,'dni','353469090','Bill','Gates','bill123','3415690231','1972-09-15',1000000,'bill123',2),(29,'dni','416572309','Avril','Del Prado','avrudelprado@gmail.com','3412769812','2003-02-10',5000,'avril123',2),(30,'dni','423901234','Julia','Diaz','juliadiazzzz@gmail.com','3412318365','2000-12-09',7000,'julia123',2),(31,'dni ','43216980','Lourdes','Gomez','lougom@gmail.com','3412314507','2002-06-09',4000,'lourdes123',2);
/*!40000 ALTER TABLE `asistente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bebidas`
--

DROP TABLE IF EXISTS `bebidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebidas` (
  `idbebida` int NOT NULL AUTO_INCREMENT,
  `nombre_bebida` varchar(45) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idbebida`),
  UNIQUE KEY `nombre_bebida_UNIQUE` (`nombre_bebida`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebidas`
--

LOCK TABLES `bebidas` WRITE;
/*!40000 ALTER TABLE `bebidas` DISABLE KEYS */;
INSERT INTO `bebidas` VALUES (1,'Vodka','Sky vodka con sprite'),(2,'Fernet','Fernet Branca con Coca-Cola'),(3,'Gin','Gin Heredero con agua tónica'),(4,'Champán','Combo de champán Barón B con 4 redbull');
/*!40000 ALTER TABLE `bebidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bebidas_historico`
--

DROP TABLE IF EXISTS `bebidas_historico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebidas_historico` (
  `idbebida` int NOT NULL,
  `fecha_desde` datetime NOT NULL,
  `valor` float NOT NULL,
  PRIMARY KEY (`idbebida`,`fecha_desde`),
  CONSTRAINT `idbebida` FOREIGN KEY (`idbebida`) REFERENCES `bebidas` (`idbebida`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebidas_historico`
--

LOCK TABLES `bebidas_historico` WRITE;
/*!40000 ALTER TABLE `bebidas_historico` DISABLE KEYS */;
INSERT INTO `bebidas_historico` VALUES (1,'2023-11-12 00:00:00',3000),(2,'2023-11-12 00:00:00',3000),(3,'2023-11-12 00:00:00',3000),(4,'2023-11-12 00:00:00',10000);
/*!40000 ALTER TABLE `bebidas_historico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `cod_postal` int NOT NULL,
  `nombre_ciudad` varchar(60) NOT NULL,
  PRIMARY KEY (`cod_postal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentario` (
  `idcomentario` int NOT NULL AUTO_INCREMENT,
  `texto` text NOT NULL,
  `fechahora` datetime NOT NULL,
  `idasistente` int DEFAULT NULL,
  `idfiesta` int DEFAULT NULL,
  `idlugar` int DEFAULT NULL,
  `fecha_evento` date DEFAULT NULL,
  `hora_evento` time DEFAULT NULL,
  PRIMARY KEY (`idcomentario`),
  KEY `idasistente` (`idasistente`),
  KEY `idfiesta` (`idfiesta`,`idlugar`,`fecha_evento`,`hora_evento`),
  CONSTRAINT `comentario_ibfk_1` FOREIGN KEY (`idasistente`) REFERENCES `asistente` (`idasistente`),
  CONSTRAINT `comentario_ibfk_2` FOREIGN KEY (`idfiesta`, `idlugar`, `fecha_evento`, `hora_evento`) REFERENCES `fiesta_lugar` (`idfiesta`, `idlugar`, `fecha_evento`, `hora_evento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` VALUES (1,'Con muchas ganas de asistir a este nuevo plumazo! Tengo la sensación de que va a estar muy bueno.','2024-11-20 12:53:20',18,4,2,'2025-01-25','18:00:00'),(2,'Para mí no debería ser en Tierra de Sueños.','2024-11-20 13:34:30',20,4,2,'2025-01-25','18:00:00');
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumicion`
--

DROP TABLE IF EXISTS `consumicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumicion` (
  `idconsumicion` int NOT NULL AUTO_INCREMENT,
  `idasistente` int NOT NULL,
  `idbebida` int NOT NULL,
  `fecha_hora_compra` datetime NOT NULL,
  PRIMARY KEY (`idconsumicion`),
  KEY `fk_con_beb_idx` (`idbebida`),
  KEY `fk_con_asisf` (`idasistente`),
  CONSTRAINT `fk_con_asisf` FOREIGN KEY (`idasistente`) REFERENCES `asistente` (`idasistente`),
  CONSTRAINT `fk_con_beb` FOREIGN KEY (`idbebida`) REFERENCES `bebidas` (`idbebida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumicion`
--

LOCK TABLES `consumicion` WRITE;
/*!40000 ALTER TABLE `consumicion` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrada` (
  `identrada` int NOT NULL AUTO_INCREMENT,
  `idasistente` int NOT NULL,
  `idfiesta` int NOT NULL,
  `idlugar` int NOT NULL,
  `fecha_evento` date NOT NULL,
  `hora_evento` time NOT NULL,
  `fecha_compra` date DEFAULT NULL,
  `hora_compra` time DEFAULT NULL,
  PRIMARY KEY (`identrada`),
  KEY `fk_entf_fl_idx` (`idfiesta`,`idlugar`,`fecha_evento`,`hora_evento`),
  KEY `fk_entrada_asistente` (`idasistente`),
  CONSTRAINT `fk_entf_fl` FOREIGN KEY (`idfiesta`, `idlugar`, `fecha_evento`, `hora_evento`) REFERENCES `fiesta_lugar` (`idfiesta`, `idlugar`, `fecha_evento`, `hora_evento`),
  CONSTRAINT `fk_entrada_asistente` FOREIGN KEY (`idasistente`) REFERENCES `asistente` (`idasistente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,25,4,2,'2025-01-25','18:00:00','2024-11-20','11:37:46');
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fiesta`
--

DROP TABLE IF EXISTS `fiesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fiesta` (
  `idfiesta` int NOT NULL AUTO_INCREMENT,
  `nombre_fiesta` varchar(50) NOT NULL,
  `descripcion` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`idfiesta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fiesta`
--

LOCK TABLES `fiesta` WRITE;
/*!40000 ALTER TABLE `fiesta` DISABLE KEYS */;
INSERT INTO `fiesta` VALUES (1,'Crean','Fiesta Crean primavera-verano desde las 13 hs hasta las 23 hs'),(2,'Coco','Fiesta Coco primavera-verano desde las 16 hs hasta la 1 hs'),(3,'Lova','Fiesta boliche Lova de 23 hs a 5 hs'),(4,'Plumazo','Fiesta del Seven Plumazo en club CAE, Santa Fe');
/*!40000 ALTER TABLE `fiesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fiesta_lugar`
--

DROP TABLE IF EXISTS `fiesta_lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fiesta_lugar` (
  `idfiesta` int NOT NULL,
  `idlugar` int NOT NULL,
  `fecha_evento` date NOT NULL,
  `hora_evento` time NOT NULL,
  PRIMARY KEY (`idfiesta`,`idlugar`,`fecha_evento`,`hora_evento`),
  KEY `id_lugar_idx` (`idlugar`),
  KEY `idx_fecha_evento` (`fecha_evento`),
  KEY `idx_hora_evento` (`hora_evento`),
  CONSTRAINT `id_fiesta` FOREIGN KEY (`idfiesta`) REFERENCES `fiesta` (`idfiesta`),
  CONSTRAINT `id_lugar` FOREIGN KEY (`idlugar`) REFERENCES `lugar` (`idlugar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fiesta_lugar`
--

LOCK TABLES `fiesta_lugar` WRITE;
/*!40000 ALTER TABLE `fiesta_lugar` DISABLE KEYS */;
INSERT INTO `fiesta_lugar` VALUES (1,1,'2023-11-11','13:00:00'),(2,1,'2023-11-18','15:00:00'),(2,2,'2023-11-25','15:00:00'),(3,3,'2023-11-25','23:00:00'),(1,4,'2023-12-09','13:00:00'),(4,4,'2023-12-16','14:00:00'),(2,3,'2023-12-20','18:00:00'),(4,1,'2023-12-27','20:30:00'),(4,4,'2024-01-07','23:00:00'),(2,4,'2024-01-23','16:00:00'),(2,4,'2024-01-27','17:00:00'),(4,1,'2024-11-09','23:00:00'),(4,2,'2025-01-25','18:00:00'),(3,1,'2025-02-12','23:00:00');
/*!40000 ALTER TABLE `fiesta_lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugar`
--

DROP TABLE IF EXISTS `lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugar` (
  `idlugar` int NOT NULL AUTO_INCREMENT,
  `nombre_lugar` varchar(60) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `capacidad` int DEFAULT NULL,
  `ciudad` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`idlugar`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,'Isla','Isla Rio 2431',1500,'Rosario'),(2,'Tierra de Sueños','Funes 5437',1000,'Rosario'),(3,'Metropolitano ','Junín 501',800,'Rosario'),(4,'Club CAE','3 de febrero 608',2000,'Santa Fe');
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precios_fiestas_historicos`
--

DROP TABLE IF EXISTS `precios_fiestas_historicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `precios_fiestas_historicos` (
  `idfiesta` int NOT NULL,
  `fecha_desde` datetime NOT NULL,
  `valor` float NOT NULL,
  PRIMARY KEY (`idfiesta`,`fecha_desde`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precios_fiestas_historicos`
--

LOCK TABLES `precios_fiestas_historicos` WRITE;
/*!40000 ALTER TABLE `precios_fiestas_historicos` DISABLE KEYS */;
INSERT INTO `precios_fiestas_historicos` VALUES (1,'2023-11-12 00:00:00',3500),(2,'2023-11-12 00:00:00',3000),(3,'2023-11-12 00:00:00',3500),(4,'2023-11-12 00:00:00',8000);
/*!40000 ALTER TABLE `precios_fiestas_historicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idrol` int unsigned NOT NULL,
  `nombre_rol` varchar(45) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'admin','Puede manipular todas las funcionalidades de la aplicación.'),(2,'usuario','Se limita a comprar entradas y ver eventos futuros.');
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

-- Dump completed on 2024-11-20 13:41:11
