CREATE DATABASE  IF NOT EXISTS `bd` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: bd
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
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal` (
  `id_animal` int(11) NOT NULL AUTO_INCREMENT,
  `nome_animal` varchar(45) NOT NULL,
  `nascimento_animal` varchar(45) NOT NULL,
  `peso_animal` double NOT NULL,
  `origem_animal` varchar(45) NOT NULL,
  `especie_animal` varchar(45) NOT NULL,
  `tratador_animal` varchar(45) NOT NULL,
  PRIMARY KEY (`id_animal`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (9,'Girafa','05-05-2000',100,'Africa','Mamífero','3'),(10,'Zebra','05-02-2001',50,'Africa','Mamífero','4'),(11,'Leão','25-05-1990',150,'America do Sul','Felino','3'),(12,'Macaco','05-02-2011',30,'Africa','Mamífero','5');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletimdiario`
--

DROP TABLE IF EXISTS `boletimdiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletimdiario` (
  `idboletimdiario` int(11) NOT NULL AUTO_INCREMENT,
  `dataatual` varchar(45) NOT NULL,
  `diagnostico` varchar(45) NOT NULL,
  `estadoanimal` varchar(45) DEFAULT NULL,
  `observacoes` varchar(45) NOT NULL,
  `nomeanimal` varchar(45) NOT NULL,
  PRIMARY KEY (`idboletimdiario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletimdiario`
--

LOCK TABLES `boletimdiario` WRITE;
/*!40000 ALTER TABLE `boletimdiario` DISABLE KEYS */;
INSERT INTO `boletimdiario` VALUES (1,'25-05-2018','htrhdfghdgs','Morto','hfdshdfhfd','Girafa');
/*!40000 ALTER TABLE `boletimdiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chechlist`
--

DROP TABLE IF EXISTS `chechlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chechlist` (
  `id_rotinaCK` int(11) NOT NULL AUTO_INCREMENT,
  `data_realizada` varchar(45) DEFAULT NULL,
  `Tarefa_rotina` int(11) DEFAULT NULL,
  `Tratador_rotinaCK` int(11) DEFAULT NULL,
  `Animal_rotinaCK` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_rotinaCK`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chechlist`
--

LOCK TABLES `chechlist` WRITE;
/*!40000 ALTER TABLE `chechlist` DISABLE KEYS */;
INSERT INTO `chechlist` VALUES (10,'13-02-2015',6,4,9),(11,'24-02-2017',6,3,10);
/*!40000 ALTER TABLE `chechlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipe` (
  `id_equipe` int(11) NOT NULL AUTO_INCREMENT,
  `tratador_principal` int(11) NOT NULL,
  `tratador_1` int(11) DEFAULT NULL,
  `tratador_2` int(11) DEFAULT NULL,
  `tratador_3` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_equipe`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES (4,4,6,5,4),(7,3,5,4,4),(8,5,4,6,3);
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receita`
--

DROP TABLE IF EXISTS `receita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receita` (
  `idreceita` int(11) NOT NULL AUTO_INCREMENT,
  `dataaviada` varchar(45) NOT NULL,
  `observacoes` varchar(45) NOT NULL,
  `nomemedicamento` varchar(15) NOT NULL,
  `dose` varchar(15) NOT NULL,
  `frequencia` varchar(15) NOT NULL,
  `Nomeanimal` varchar(45) NOT NULL,
  `veterinario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idreceita`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receita`
--

LOCK TABLES `receita` WRITE;
/*!40000 ALTER TABLE `receita` DISABLE KEYS */;
INSERT INTO `receita` VALUES (4,'05-02-2012','Pucas listras pretas','Tinta preta','50MG','4/4 horas','Zebra',2),(6,'25-05-2012','Muita juba','Tesoura','10MG','12/12 horas','Leão',2);
/*!40000 ALTER TABLE `receita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registroclinico`
--

DROP TABLE IF EXISTS `registroclinico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registroclinico` (
  `idregistroclinico` int(11) NOT NULL AUTO_INCREMENT,
  `diagnostico` varchar(45) NOT NULL,
  `tipoatendimento` varchar(45) NOT NULL,
  `observacoes` varchar(45) NOT NULL,
  PRIMARY KEY (`idregistroclinico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registroclinico`
--

LOCK TABLES `registroclinico` WRITE;
/*!40000 ALTER TABLE `registroclinico` DISABLE KEYS */;
/*!40000 ALTER TABLE `registroclinico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rotina_tratamento`
--

DROP TABLE IF EXISTS `rotina_tratamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rotina_tratamento` (
  `id_rotina` int(11) NOT NULL AUTO_INCREMENT,
  `data_validade` varchar(45) DEFAULT NULL,
  `Tarefa_rotina` int(11) NOT NULL,
  `Tratador_rotina` int(11) NOT NULL,
  `Animal_rotina` int(11) NOT NULL,
  PRIMARY KEY (`id_rotina`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotina_tratamento`
--

LOCK TABLES `rotina_tratamento` WRITE;
/*!40000 ALTER TABLE `rotina_tratamento` DISABLE KEYS */;
INSERT INTO `rotina_tratamento` VALUES (12,'25-05-1900',5,4,4),(13,'25-05-2018',6,3,10),(14,'22-02-2019',6,4,9),(15,'25-05-2018',6,3,9);
/*!40000 ALTER TABLE `rotina_tratamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarefa`
--

DROP TABLE IF EXISTS `tarefa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarefa` (
  `idtarefa` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(65) NOT NULL,
  PRIMARY KEY (`idtarefa`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarefa`
--

LOCK TABLES `tarefa` WRITE;
/*!40000 ALTER TABLE `tarefa` DISABLE KEYS */;
INSERT INTO `tarefa` VALUES (5,'Dar banho'),(6,'Dar remédio');
/*!40000 ALTER TABLE `tarefa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratador`
--

DROP TABLE IF EXISTS `tratador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratador` (
  `id_tratador` int(11) NOT NULL AUTO_INCREMENT,
  `nome_tratador` varchar(45) NOT NULL,
  `telefone_tratador` varchar(45) NOT NULL,
  `endereco_tratador` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tratador`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratador`
--

LOCK TABLES `tratador` WRITE;
/*!40000 ALTER TABLE `tratador` DISABLE KEYS */;
INSERT INTO `tratador` VALUES (3,'Victor','(32) 32186-2362','Fausto Machado'),(4,'Marcos','(32) 89515-2212','Rua B'),(5,'Adilson','(32) 55656-5656','Rua H'),(6,'Carlos','(54) 54551-1121','Rua y');
/*!40000 ALTER TABLE `tratador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `tipousuario` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (5,'','adilson','123',1),(11,'','victor','123',3),(12,'','manoel','123',2),(13,'','Daves','123',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacina`
--

DROP TABLE IF EXISTS `vacina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacina` (
  `idvacina` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idvacina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina`
--

LOCK TABLES `vacina` WRITE;
/*!40000 ALTER TABLE `vacina` DISABLE KEYS */;
/*!40000 ALTER TABLE `vacina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veterinario`
--

DROP TABLE IF EXISTS `veterinario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veterinario` (
  `id_veterinario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_veterinario` varchar(45) NOT NULL,
  `telefone_veterinario` varchar(45) NOT NULL,
  `endereco_veterinario` varchar(45) NOT NULL,
  `data_emissao` varchar(45) NOT NULL,
  `num_conselho` int(11) NOT NULL,
  PRIMARY KEY (`id_veterinario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veterinario`
--

LOCK TABLES `veterinario` WRITE;
/*!40000 ALTER TABLE `veterinario` DISABLE KEYS */;
INSERT INTO `veterinario` VALUES (1,'Matheus','(32) 99151-5359','José antonio','01/01/2016',10),(2,'Adilson','(32) 98856-5616','Ademar Ferreira Leite','03/02/2001',20),(3,'Victor','(32) 21154-1418','Rua s','02/05/2010',15);
/*!40000 ALTER TABLE `veterinario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-01 13:01:53
