-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: quanlybansach
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `idBill` int(11) NOT NULL,
  `idCustomer` varchar(20) NOT NULL,
  `idEmployee` varchar(20) NOT NULL,
  `dateBill` date NOT NULL,
  `sumMoney` float NOT NULL,
  `typePayment` varchar(20) NOT NULL,
  `discountMoney` float DEFAULT NULL,
  `moneyPayment` float NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`idBill`),
  KEY `fk_customer` (`idCustomer`),
  KEY `fk_employee` (`idEmployee`),
  CONSTRAINT `fk_customer` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`idCustomer`),
  CONSTRAINT `fk_employee` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`idEmployee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billdetail`
--

DROP TABLE IF EXISTS `billdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billdetail` (
  `idBill` int(11) NOT NULL,
  `idBook` varchar(20) NOT NULL,
  `quantityBook` int(11) NOT NULL,
  `unitPrice` float NOT NULL,
  `intoMoney` float NOT NULL,
  `idPromotion` varchar(20) NOT NULL,
  `moneyDown` float NOT NULL,
  PRIMARY KEY (`idBill`,`idBook`),
  KEY `fk_bookdt` (`idBook`),
  KEY `fk_promotiondt` (`idPromotion`),
  CONSTRAINT `fk_billdt` FOREIGN KEY (`idBill`) REFERENCES `bill` (`idBill`),
  CONSTRAINT `fk_bookdt` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`),
  CONSTRAINT `fk_promotiondt` FOREIGN KEY (`idPromotion`) REFERENCES `promotions` (`idPromotion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billdetail`
--

LOCK TABLES `billdetail` WRITE;
/*!40000 ALTER TABLE `billdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `billdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `idBook` varchar(20) NOT NULL,
  `nameBook` varchar(30) DEFAULT NULL,
  `unitPrice` float DEFAULT NULL,
  `datePublishing` date DEFAULT NULL,
  `quantityBook` int(11) NOT NULL,
  `idTypeBook` varchar(20) NOT NULL,
  `idPublishingCompany` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`idBook`),
  KEY `fk_typeBook` (`idTypeBook`),
  KEY `fk_publishingCompany` (`idPublishingCompany`),
  CONSTRAINT `fk_publishingCompany` FOREIGN KEY (`idPublishingCompany`) REFERENCES `publishingcompany` (`idPublishingCompany`),
  CONSTRAINT `fk_typeBook` FOREIGN KEY (`idTypeBook`) REFERENCES `typebook` (`idTypeBook`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('01','01',10000,'1900-12-01',10,'Truyen','KimDong','');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookdistributor`
--

DROP TABLE IF EXISTS `bookdistributor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookdistributor` (
  `idBookDistributor` varchar(20) NOT NULL,
  `nameDistributor` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(10) DEFAULT NULL,
  `addressDistributor` varchar(100) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idBookDistributor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookdistributor`
--

LOCK TABLES `bookdistributor` WRITE;
/*!40000 ALTER TABLE `bookdistributor` DISABLE KEYS */;
INSERT INTO `bookdistributor` VALUES ('a','b','c','d','e');
/*!40000 ALTER TABLE `bookdistributor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon` (
  `idCoupon` int(11) NOT NULL,
  `dateAdded` date DEFAULT NULL,
  `intoMoney` int(11) DEFAULT NULL,
  `idBookDistributor` varchar(20) NOT NULL,
  PRIMARY KEY (`idCoupon`),
  KEY `fk_BookDistribute` (`idBookDistributor`),
  CONSTRAINT `fk_BookDistribute` FOREIGN KEY (`idBookDistributor`) REFERENCES `bookdistributor` (`idBookDistributor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
INSERT INTO `coupon` VALUES (0,'1900-12-10',0,'a');
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `idCustomer` varchar(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `phoneNumber` varchar(10) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `typeCustomer` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idCustomer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('trong','tien','trong','trong','trong');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailcoupon`
--

DROP TABLE IF EXISTS `detailcoupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailcoupon` (
  `idBook` varchar(20) NOT NULL,
  `quantityImport` int(11) NOT NULL,
  `unitPrice` float NOT NULL,
  `intoMoney` float NOT NULL,
  `idCoupon` int(11) NOT NULL,
  PRIMARY KEY (`idCoupon`,`idBook`),
  KEY `fk_book` (`idBook`),
  CONSTRAINT `fk_book` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`),
  CONSTRAINT `fk_coupon` FOREIGN KEY (`idCoupon`) REFERENCES `coupon` (`idCoupon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailcoupon`
--

LOCK TABLES `detailcoupon` WRITE;
/*!40000 ALTER TABLE `detailcoupon` DISABLE KEYS */;
INSERT INTO `detailcoupon` VALUES ('01',20,10000,1100,0);
/*!40000 ALTER TABLE `detailcoupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailpromotion`
--

DROP TABLE IF EXISTS `detailpromotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailpromotion` (
  `idPromotion` varchar(20) NOT NULL,
  `idBook` varchar(20) NOT NULL,
  `discount` int(11) NOT NULL,
  PRIMARY KEY (`idPromotion`,`idBook`),
  KEY `fk_detailPromotion_book` (`idBook`),
  CONSTRAINT `fk_detaiPromotiondt` FOREIGN KEY (`idPromotion`) REFERENCES `promotions` (`idPromotion`),
  CONSTRAINT `fk_detailPromotion_book` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailpromotion`
--

LOCK TABLES `detailpromotion` WRITE;
/*!40000 ALTER TABLE `detailpromotion` DISABLE KEYS */;
INSERT INTO `detailpromotion` VALUES ('1','01',1);
/*!40000 ALTER TABLE `detailpromotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `idEmployee` varchar(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `turnover` float DEFAULT NULL,
  `totalSales` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEmployee`),
  KEY `fk_employee_email` (`email`),
  CONSTRAINT `fk_employee_email` FOREIGN KEY (`email`) REFERENCES `users` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotions`
--

DROP TABLE IF EXISTS `promotions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotions` (
  `idPromotion` varchar(20) NOT NULL,
  `namePromotions` varchar(30) DEFAULT NULL,
  `dateStart` date DEFAULT NULL,
  `dateEnd` date DEFAULT NULL,
  PRIMARY KEY (`idPromotion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotions`
--

LOCK TABLES `promotions` WRITE;
/*!40000 ALTER TABLE `promotions` DISABLE KEYS */;
INSERT INTO `promotions` VALUES ('1','a','1900-10-10','1900-10-10');
/*!40000 ALTER TABLE `promotions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publishingcompany`
--

DROP TABLE IF EXISTS `publishingcompany`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publishingcompany` (
  `idPublishingCompany` varchar(20) NOT NULL,
  `namePublishingCompany` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idPublishingCompany`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publishingcompany`
--

LOCK TABLES `publishingcompany` WRITE;
/*!40000 ALTER TABLE `publishingcompany` DISABLE KEYS */;
INSERT INTO `publishingcompany` VALUES ('KimDong','111');
/*!40000 ALTER TABLE `publishingcompany` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typebook`
--

DROP TABLE IF EXISTS `typebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typebook` (
  `idTypeBook` varchar(20) NOT NULL,
  `nameTypeBook` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idTypeBook`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typebook`
--

LOCK TABLES `typebook` WRITE;
/*!40000 ALTER TABLE `typebook` DISABLE KEYS */;
INSERT INTO `typebook` VALUES ('Truyen','Truyen');
/*!40000 ALTER TABLE `typebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('tien','456',NULL),('trong','123',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-01 22:03:36
