-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.14


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema aadd_jpa
--

CREATE DATABASE IF NOT EXISTS aadd_jpa;
USE aadd_jpa;

--
-- Definition of table `catalogo`
--

DROP TABLE IF EXISTS `catalogo`;
CREATE TABLE `catalogo` (
  `NOMBRE` varchar(255) NOT NULL,
  `FECHA` datetime DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `WEB` varchar(255) DEFAULT NULL,
  `USUARIO_USUARIO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`NOMBRE`),
  KEY `FK_CATALOGO_USUARIO_USUARIO` (`USUARIO_USUARIO`),
  CONSTRAINT `FK_CATALOGO_USUARIO_USUARIO` FOREIGN KEY (`USUARIO_USUARIO`) REFERENCES `usuario` (`USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catalogo`
--

/*!40000 ALTER TABLE `catalogo` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalogo` ENABLE KEYS */;


--
-- Definition of table `catalogo_categoria`
--

DROP TABLE IF EXISTS `catalogo_categoria`;
CREATE TABLE `catalogo_categoria` (
  `Catalogo_NOMBRE` varchar(255) NOT NULL,
  `categorias_CODIGO` int(11) NOT NULL,
  PRIMARY KEY (`Catalogo_NOMBRE`,`categorias_CODIGO`),
  KEY `FK_CATALOGO_CATEGORIA_categorias_CODIGO` (`categorias_CODIGO`),
  CONSTRAINT `FK_CATALOGO_CATEGORIA_categorias_CODIGO` FOREIGN KEY (`categorias_CODIGO`) REFERENCES `categoria` (`CODIGO`),
  CONSTRAINT `FK_CATALOGO_CATEGORIA_Catalogo_NOMBRE` FOREIGN KEY (`Catalogo_NOMBRE`) REFERENCES `catalogo` (`NOMBRE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catalogo_categoria`
--

/*!40000 ALTER TABLE `catalogo_categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalogo_categoria` ENABLE KEYS */;


--
-- Definition of table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `CODIGO` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categoria`
--

/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;


--
-- Definition of table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequence`
--

/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` (`SEQ_NAME`,`SEQ_COUNT`) VALUES 
 ('SEQ_GEN','0');
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `USUARIO` varchar(255) NOT NULL,
  `CLAVE` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NIF` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`USUARIO`,`CLAVE`,`EMAIL`,`NIF`,`NOMBRE`) VALUES 
 ('admin','admin','admin@admin.ad','5555555H','adminName');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
