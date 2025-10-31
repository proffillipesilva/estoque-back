-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: estoque
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` binary(16) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `nome_da_empresa` varchar(255) DEFAULT NULL,
  `ramo_atuacao` varchar(255) DEFAULT NULL,
  `user_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKhawikyhwwfvbnog5byokutpff` (`user_id`),
  CONSTRAINT `FK8ahhk8vqegfrt6pd1p9i03aej` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (_binary 'l\ o \ O  x .>H,','12.345.678/0001-90','Empresa Ltda.','Tecnologia',_binary '     Oߺ g\ ');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest`
--

DROP TABLE IF EXISTS `guest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guest` (
  `id` binary(16) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `cpf_or_cnpj` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `user_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKchdaocwoknpkpjjcb6dyv8os8` (`user_id`),
  CONSTRAINT `FKake2867xxr6o753o6kqc4rott` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest`
--

LOCK TABLES `guest` WRITE;
/*!40000 ALTER TABLE `guest` DISABLE KEYS */;
/*!40000 ALTER TABLE `guest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest_admin_relationship`
--

DROP TABLE IF EXISTS `guest_admin_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guest_admin_relationship` (
  `admin_id` binary(16) NOT NULL,
  `guest_id` binary(16) NOT NULL,
  KEY `FKbefuj2q9jnpk9medc806ds0l1` (`guest_id`),
  KEY `FKfv0f282v5dhklwsvg5hn4kjsd` (`admin_id`),
  CONSTRAINT `FKbefuj2q9jnpk9medc806ds0l1` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`id`),
  CONSTRAINT `FKfv0f282v5dhklwsvg5hn4kjsd` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest_admin_relationship`
--

LOCK TABLES `guest_admin_relationship` WRITE;
/*!40000 ALTER TABLE `guest_admin_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `guest_admin_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest_admins`
--

DROP TABLE IF EXISTS `guest_admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guest_admins` (
  `guest_id` binary(16) NOT NULL,
  `admins_id` binary(16) NOT NULL,
  KEY `FKatw4ucso7pcannwdxmxbr87c7` (`admins_id`),
  KEY `FKqc90cq08uaql3e0b04p4r69cb` (`guest_id`),
  CONSTRAINT `FKatw4ucso7pcannwdxmxbr87c7` FOREIGN KEY (`admins_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `FKqc90cq08uaql3e0b04p4r69cb` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest_admins`
--

LOCK TABLES `guest_admins` WRITE;
/*!40000 ALTER TABLE `guest_admins` DISABLE KEYS */;
/*!40000 ALTER TABLE `guest_admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` binary(16) NOT NULL,
  `guest_id` binary(16) DEFAULT NULL,
  `data_de_criacao` datetime(6) DEFAULT NULL,
  `data_de_submissao` datetime(6) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `guest_name` varchar(255) DEFAULT NULL,
  `imagem` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `quantidade` double DEFAULT NULL,
  `tipo_medida` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK52kejbuoua3mnkemg7e6f9ywr` (`guest_id`),
  CONSTRAINT `FK52kejbuoua3mnkemg7e6f9ywr` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (_binary '/ c <䗗\0PV w;',NULL,NULL,NULL,NULL,NULL,'https://m.media-amazon.com/images/I/51qH44JtGtL.jpg','Lucas',4900,2,5),(_binary '? c <䗗\0PV w?',NULL,NULL,NULL,NULL,NULL,'https://m.media-amazon.com/images/I/51qH44JtGtL.jpg','Joao Pedro',5499.9,3,5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `standard`
--

DROP TABLE IF EXISTS `standard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `standard` (
  `id` binary(16) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `nome_da_empresa` varchar(255) DEFAULT NULL,
  `ramo_atuacao` varchar(255) DEFAULT NULL,
  `user_id` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKn1v3sniq4mupsct1e8q1ddtau` (`user_id`),
  CONSTRAINT `FKf1rijpklvcopt67ytyp4ay77h` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standard`
--

LOCK TABLES `standard` WRITE;
/*!40000 ALTER TABLE `standard` DISABLE KEYS */;
INSERT INTO `standard` VALUES (_binary ' \ {\ \ 2L   p yH ;','12.345.678/0001-90',NULL,'Tecnologia',_binary 'w^  \ CޣF\ ֘[\ '),(_binary '$  u\"\0M  m3 R\ \n ','12.345.678/0001-90',NULL,'Tecnologia',_binary '6g\ \ \ L  p8J\ ϡB'),(_binary '0(තE   Xk','12.345.678/0001-90',NULL,'Tecnologia',_binary '|\ \ \ dB    1ҩh'),(_binary '1[\ \ 	 O  sq\ \n ','12.345.678/0001-90',NULL,'Tecnologia',_binary '  \"  @6 l ݩ!\ '),(_binary '^\'\ c :E`  K#\ U .','12.345.678/0001-90',NULL,'Tecnologia',_binary '	 a\ 8A꿋  v `|'),(_binary '_\n\ \ #GV  \ \ KU|','12.345.678/0001-90',NULL,'Tecnologia',_binary 'F ^ \ N҅\\\'Ⱥ9D\\'),(_binary 't  B @ 3X\ ,(','12.345.678/0001-90',NULL,'Tecnologia',_binary 'c!![\ \ Ha H t  \ '),(_binary '{n    A\
F0    ','12.345.678/0001-90',NULL,'Tecnologia',_binary 'e> \0  D  \"\ \  u '),(_binary '|&ES  \ Ʋ  ','12.345.678/0001-90',NULL,'Tecnologia',_binary '  @ wGӸź @23'),(_binary '    0IB  釬 | \ ','12.345.678/0001-90',NULL,'Tecnologia',_binary '\  lL BU \ \
 \ \ ');
/*!40000 ALTER TABLE `standard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_admin_relationship`
--

DROP TABLE IF EXISTS `supplier_admin_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier_admin_relationship` (
  `admin_id` binary(16) NOT NULL,
  `supplier_id` binary(16) NOT NULL,
  KEY `FKsvvok7s4nvpqiq8du23841346` (`supplier_id`),
  KEY `FK75gu7460hvkggd6965sf958fd` (`admin_id`),
  CONSTRAINT `FK75gu7460hvkggd6965sf958fd` FOREIGN KEY (`admin_id`) REFERENCES `standard` (`id`),
  CONSTRAINT `FKsvvok7s4nvpqiq8du23841346` FOREIGN KEY (`supplier_id`) REFERENCES `guest` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_admin_relationship`
--

LOCK TABLES `supplier_admin_relationship` WRITE;
/*!40000 ALTER TABLE `supplier_admin_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier_admin_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` binary(16) NOT NULL,
  `access_level` enum('ROLE_ADMIN','ROLE_GUEST','ROLE_STANDARD') NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `fcm_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (_binary '	 a\ 8A꿋  v `|','ROLE_STANDARD','standard10@exemplo.com',NULL,'$2a$10$3MyX3YoLhPCagcVYzKh.x.xl.K50/W0hOf.BDiCnskUC34yEt4s3a','ea04fb3e-a797-46b5-b8b4-a4dbf1d66960.jpg',2,'dDL2xag2ryhMA0IVOvRiob:APA91bGcdk98BuSzey7bAdf3tLTaBHSBMvfJzY7bkFEaHEKOTHlrbfWheRAsdhUncmzHt-YN4OIhzSy2rf1ekRHhheHnTqdvj_64qJT4k6HKchnbwJnm8-c'),(_binary '  @ wGӸź @23','ROLE_STANDARD','standard5@exemplo.com',NULL,'$2a$10$1LwR4jjBpbogjNi6Jh6euuwE1LFB7guC2t/f72NyKBUa51m.bWyWy',NULL,0,NULL),(_binary '6g\ \ \ L  p8J\ ϡB','ROLE_STANDARD','standard9@exemplo.com',NULL,'Fiec@2025',NULL,0,NULL),(_binary 'F ^ \ N҅\\\'Ⱥ9D\\','ROLE_STANDARD','standard7@exemplo.com',NULL,'$2a$10$3i5Qe.ZHqUMEIY6PqP3L7eIWUfVX4HPT8kNcW0P0MZydD3sUr06FW',NULL,0,NULL),(_binary 'c!![\ \ Ha H t  \ ','ROLE_STANDARD','standard8@exemplo.com',NULL,'$2a$10$n75dR75fbQBpFD2P4VpdyOWsTjGG2Bm5efgSQVQIl7ektBIyFqRiS','85004b7f-8882-4c72-9e35-1c1e6350c987.jpg',0,NULL),(_binary 'e> \0  D  \"\ \  u ','ROLE_STANDARD','standard1@exemplo.com',NULL,'$2a$10$kbRpiKsRE41TOQsA7r4GJeStVqs/oPM8xKqhWtNq/i8cfi4Yy1MSS','58b5d241-ae22-43eb-b554-cc9ca223f85a.jpg',0,NULL),(_binary 'w^  \ CޣF\ ֘[\ ','ROLE_STANDARD','standard3@exemplo.com',NULL,'$2a$10$VeLe2XCldjXgcU3qqj4ox.rAaVHX0YOWi3KH4Os5cL4iBCN.W0n8m',NULL,0,NULL),(_binary '|\ \ \ dB    1ҩh','ROLE_STANDARD','standard6@exemplo.com',NULL,'$2a$10$UJX2lCGQ1zgU7YrohKlREekZdw2hUbviHbGoWngmfoqhe5vpJqbzW',NULL,0,NULL),(_binary '     Oߺ g\ ','ROLE_ADMIN','usuario@exemplo.com',NULL,'$2a$10$KBHxdUhcpp1lWUbYgOSN4ejaJmqC6JcKlb16rE1yxtavwaPq33Yr6',NULL,0,NULL),(_binary '\  lL BU \ \
 \ \ ','ROLE_STANDARD','standard11@exemplo.com',NULL,'$2a$10$q0TGt85pcTEahGwbyosUp.F8.q3LD/dQ4zBElQhHYgEFvEgeNSBfu','b3843691-d2a1-4c6b-b8a5-70106487e837.jpg',2,NULL),(_binary '  \"  @6 l ݩ!\ ','ROLE_STANDARD','standard2@exemplo.com',NULL,'$2a$10$9Wt6wkewoAy0GBCaYRS0bucU45Tm9LEuIJk0dWwuYLdqehCOVeKNu',NULL,0,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-30 19:38:25
