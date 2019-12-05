CREATE DATABASE  IF NOT EXISTS `festa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `festa`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: festa
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `IdCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `telefone` varchar(13) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `cidade` varchar(20) DEFAULT NULL,
  `logradouro` varchar(50) DEFAULT NULL,
  `dataNascimento` date NOT NULL,
  `ativo` tinyint(4) NOT NULL,
  PRIMARY KEY (`IdCliente`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (15,'Ulysses Werlich Borges','089.260.049-70','48 984424614','werlichborgesulysses@gmail.com','SC','São José','Rua das Orquideas, 2010','1996-06-25',1),(16,'Cinthya Borges','047.774.579-23','48 991014041','schaffercinthya@hotmail.com','SC','São José','Rua Manoel Antonio Pereira, 110','1985-11-03',1),(17,'Priscila Schlemper','489.489.489-49','48 999131280','priscilaschlemper@gmail.com','SC','Florianópolis','Rua Ivo Reis Montenegro, 123','1999-06-07',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `festa`
--

DROP TABLE IF EXISTS `festa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `festa` (
  `idFesta` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(7,2) NOT NULL,
  `cpfCliente` varchar(14) NOT NULL,
  `idTema` int(11) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `cidade` varchar(20) NOT NULL,
  `logradouro` varchar(50) NOT NULL,
  `dataFesta` date NOT NULL,
  `matutino` tinyint(1) DEFAULT NULL,
  `vespertino` tinyint(1) DEFAULT NULL,
  `noturno` tinyint(1) DEFAULT NULL,
  `situacao` tinyint(1) NOT NULL,
  `comentario` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`idFesta`),
  UNIQUE KEY `idFesta` (`idFesta`),
  KEY `cpf_idx` (`cpfCliente`),
  KEY `idTema_idx` (`idTema`),
  CONSTRAINT `cpf` FOREIGN KEY (`cpfCliente`) REFERENCES `cliente` (`cpf`),
  CONSTRAINT `festa_ibfk_1` FOREIGN KEY (`idTema`) REFERENCES `tema` (`idtema`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `festa`
--

LOCK TABLES `festa` WRITE;
/*!40000 ALTER TABLE `festa` DISABLE KEYS */;
INSERT INTO `festa` VALUES (3,6000.00,'089.260.049-70',7,'SC','São José','Rua das Orquídeas, 123','2019-12-12',1,0,0,4,'\n\nUlysses Werlich Borges- ID: 10002:\n--- Finalizado Festa ----'),(4,7000.00,'489.489.489-49',6,'SC','Florianópolis','Rua Ivo Reis Montenegro','2019-12-12',0,1,1,5,'\n\nUlysses Werlich Borges- ID: 10002:\n--- Festa Cancelada ----'),(5,7000.00,'489.489.489-49',7,'SC','Florianópolis','Rua Ivo Reis Montenegro','2019-12-12',1,1,0,4,'Ulysses Werlich Borges - ID: 10002:\nEntrega as 12h\n\n\nUlysses Werlich Borges - ID: 10002:\n--- Feito Pagamento ----Ulysses Werlich Borges - ID: 10002:\n--- Feito Entrega ----\n\nUlysses Werlich Borges - ID: 10002:\n--- Finalizado Festa ----'),(6,8200.00,'489.489.489-49',8,'SC','São José','Avenida Presidente Kennedy, 142','2019-11-11',1,1,0,2,'Ulysses Werlich Borges - ID: 10002:\nNão definido local\n\nUlysses Werlich Borges - ID: 10002:\n--- Feito Pagamento ----\n\nUlysses Werlich Borges - ID: 10002:\nDefinido local da festa\n\n'),(7,5000.00,'489.489.489-49',8,'SC','São José','Rua Manoel da Silva, 13','2020-05-12',1,1,0,2,'Ulysses Werlich Borges - ID: 10002:\n--- Feito Pagamento ----\n\nUlysses Werlich Borges - ID: 10002:\nFesta pra mana\n\n');
/*!40000 ALTER TABLE `festa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `item` (
  `idItem` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `preco` decimal(6,2) NOT NULL,
  `descricao` varchar(300) DEFAULT NULL,
  `ativo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idItem`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (19,'Castelo Inflável',500.00,'Castelo inflável (M)',0),(20,'Castelo Inflável',550.00,'Castelo Inflável (G)',1),(21,'Pula Pula (P)',200.00,'Pula Pula 3x3m',1),(22,'Pula Pula (M)',350.00,'Pula Pula 4x4 m',1),(23,'Pula Pula (G)',500.00,'Pula Pula 5x5 m',1),(24,'Piscina de bolinhas circular (P)',150.00,'Piscina de bolinhas 3x3 metros circular',1),(25,'Piscina de bolinhas quadrado (P)',225.00,'Piscina de Bolinhas 3x3 m quadrado',1),(26,'Piscina de bolinhas quadrado (M) ',250.00,'Piscina de bolinhas quadrado 4x4 m',1),(27,'Piscina de bolinhas circular (G)',300.00,'Piscina de bolinhas circular 5x5 m',1),(28,'Piscina de bolinhas quadrado (G)',350.00,'Piscina de bolinhas circular 5x5 m',1),(29,'Piscina de bolinhas circular (M)',250.00,'Piscina de bolinhas 4x4m circular',1),(30,'Boneco Olaf',100.00,'Boneco 1m Olaf',1),(31,'Boneco Elsa',150.00,'Boneco 1,5m Elsa',1),(32,'Boneco Cavalo branco',150.00,'Boneco de cavalo branco montável',1),(33,'Fantasia Elsa',50.00,'Fantasia completa Elsa',1),(34,'Banner Rei Leão',70.00,'Banner Rei Leão 100cm x 70cm',1),(35,'Boneco Simba',150.00,'Boneco montável Simba 1m',1),(36,'Piscina de bolinhas Pequena Sereia',400.00,'Piscina de bolinhas Pequena Sereia 5x5',1),(37,'Fonte de Chocolate (P)',300.00,'Fonte de Chocolate 50cm altura por 30cm largura',1),(38,'Fonte de chocolate (M)',350.00,'Fonte de chocolate 75cm altura x 50cm largura',1),(39,'Fonte de Chocolate (G)',450.00,'Fonte de chocolate 100cm altura x 70cm largura',1),(40,'Boneco Timão e Pumba',150.00,'Boneco Timão e Pumba 1m',1),(41,'Gerador de bolha de sabão',300.00,'Gerador de bolhas de sabão',1),(42,'Boneco Nala (Rei Leão)',150.00,'Boneco Nala (Rei Leão) 1m',1),(43,'Carroça de brinquedo (P)',600.00,'Carroça de Brinquedo p/ 1 pessoa',1),(44,'Carroça de brinquedo (M)',680.00,'Carroça de Brinquedo p/ 2 pessoas',1),(45,'Carroça de Brinquedo (G)',750.00,'Carroça de Brinquedo p/ 4 pessoa',1),(46,'Escorregador inflável (P)',500.00,'Escorregador inflável 3m x 3m',1),(47,'Escorregador inflável (M)',650.00,'Escorregador inflável 4m x 4m',1),(48,'Escorregador inflável (G)',700.00,'Escorregador inflável 5m x 5m',1),(49,'Escorregador inflável Frozen (M)',700.00,'Escorregador inflável Frozen 4 x 4',1),(50,'Escorregador inflável Pequena Sereia (G)',750.00,'Escorregador inflável Pequena Sereia 5m x 5m',1),(51,'Pula Pula Rei Leão (G)',550.00,'Pula Pula Rei Leão 5m x 5m',1),(52,'Batalha de bastão Rei Leão',560.00,'Campo inflável p/ batalha de bastão 5m x 5m Rei Leão',1),(53,'Paredão escalada Rei Leão (P)',700.00,'Paredão de escalada Rei Leão 3m altura x 2 m largura',1),(54,'Paredão de escalada Rei Leão (G)',900.00,'Paredão de escalada Rei Leão 6m altura x 4 m largura',1),(55,'Fantasia Ariel Pequena Sereia',90.00,'Fantasia Ariel Pequena Sereia c/ vestido, tiara e sapato',1),(56,'Escorregador (P)',150.00,'Escorregador 1 metro',1);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tema`
--

DROP TABLE IF EXISTS `tema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tema` (
  `idTema` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `precoAluguel` decimal(7,2) NOT NULL,
  `descricao` varchar(300) DEFAULT NULL,
  `ativo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idTema`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tema`
--

LOCK TABLES `tema` WRITE;
/*!40000 ALTER TABLE `tema` DISABLE KEYS */;
INSERT INTO `tema` VALUES (5,'Rei Leão (P)',2000.00,'Tema Rei Leão',1),(6,'Rei Leão (G)',5000.00,'Tema festa aniversário Rei Leão',1),(7,'Pequena Sereia (G)',4500.00,'Tema festa aniversário Pequena Sereira',1),(8,'Frozen (G)',6000.00,'Tema Festa Aniversário Frozen',1);
/*!40000 ALTER TABLE `tema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temaitem`
--

DROP TABLE IF EXISTS `temaitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `temaitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idTema` int(11) NOT NULL,
  `idItem` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idTema_idx` (`idTema`),
  KEY `idItem_idx` (`idItem`),
  CONSTRAINT `idItem` FOREIGN KEY (`idItem`) REFERENCES `item` (`iditem`),
  CONSTRAINT `idTema` FOREIGN KEY (`idTema`) REFERENCES `tema` (`idtema`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temaitem`
--

LOCK TABLES `temaitem` WRITE;
/*!40000 ALTER TABLE `temaitem` DISABLE KEYS */;
INSERT INTO `temaitem` VALUES (125,5,25),(126,5,21),(127,5,34),(128,5,35),(129,5,42),(130,5,52),(131,6,34),(132,6,36),(133,6,42),(134,6,50),(135,6,51),(136,6,52),(137,6,54),(138,6,35),(139,6,40),(140,7,55),(141,7,50),(142,7,45),(143,7,43),(144,7,41),(145,7,39),(146,7,36),(147,7,20),(148,8,49),(149,8,20),(150,8,31),(151,8,33),(152,8,30),(153,8,45),(154,8,43),(155,8,39);
/*!40000 ALTER TABLE `temaitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `cargo` varchar(30) DEFAULT NULL,
  `dataNascimento` date NOT NULL,
  `telefone` varchar(13) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `cidade` varchar(20) DEFAULT NULL,
  `logradouro` varchar(50) DEFAULT NULL,
  `senha` varchar(12) NOT NULL,
  `cadastrarCliente` tinyint(1) DEFAULT NULL,
  `consultarCliente` tinyint(1) DEFAULT NULL,
  `cadastrarFesta` tinyint(1) DEFAULT NULL,
  `consultarFesta` tinyint(1) DEFAULT NULL,
  `cadastrarTema` tinyint(1) DEFAULT NULL,
  `consultarTema` tinyint(1) DEFAULT NULL,
  `cadastrarItem` tinyint(1) DEFAULT NULL,
  `consultarItem` tinyint(1) DEFAULT NULL,
  `cadastrarUsuario` tinyint(1) DEFAULT NULL,
  `consultarUsuario` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (10002,'Ulysses Werlich Borges','089.260.049-70','Gerente de desenvolvimento','1996-06-25','48 984424614','werlichborgesulysses@gmail.com','SC','São José','Rua das Orquideas, 2010','Joao0316',1,1,1,1,1,1,1,1,1,1),(10004,'Cinthya Borges Schaffer','047.774.579-23','Gerente de Vendas','1985-11-03','48 991014041','schaffercinthya@hotmail.com','SC','São José','Rua Manoel Antonio Pereira, 110','123456',0,1,1,1,1,1,0,1,0,1),(10005,'Mateus da Silva','089.467.840-84','Teste','1994-11-11','48 84684987','mateus.silva@gmail.com','SC','Biguaçu','Rua das Marías, 23','123456',1,1,1,1,1,1,1,1,0,0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-05 14:47:19
