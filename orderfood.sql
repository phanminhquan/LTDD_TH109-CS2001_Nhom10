-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: orderfood
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `chitietdonhang`
--

DROP TABLE IF EXISTS `chitietdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietdonhang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_don_hang` int DEFAULT NULL,
  `id_nha_hang_food` int DEFAULT NULL,
  `so_luong` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK79urdjkhkcgbljvmcngnuwltd` (`id_don_hang`),
  KEY `FK2f3c9cnx97pyo6jkdmhce6loh` (`id_nha_hang_food`),
  CONSTRAINT `FK2f3c9cnx97pyo6jkdmhce6loh` FOREIGN KEY (`id_nha_hang_food`) REFERENCES `nhahang_food` (`id`),
  CONSTRAINT `FK79urdjkhkcgbljvmcngnuwltd` FOREIGN KEY (`id_don_hang`) REFERENCES `donhang` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdonhang`
--

LOCK TABLES `chitietdonhang` WRITE;
/*!40000 ALTER TABLE `chitietdonhang` DISABLE KEYS */;
INSERT INTO `chitietdonhang` VALUES (1,1,1,2),(2,1,1,2),(3,1,1,2),(4,50,1,2),(5,50,2,1),(6,51,6,2),(7,52,7,5),(8,53,1,2),(9,54,1,6),(10,55,1,2),(11,56,1,2),(12,57,1,2),(13,58,1,1),(14,59,13,1),(15,60,12,4),(16,61,1,2),(17,61,2,2);
/*!40000 ALTER TABLE `chitietdonhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhgia`
--

DROP TABLE IF EXISTS `danhgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhgia` (
  `gia_tien` double DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `id_nha_hang_food` int DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  `rate` int DEFAULT NULL,
  `noi_dung` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjnpid3d6tk6dsnb9a072570gu` (`id_nha_hang_food`),
  KEY `FKbltj6xuakh3eb1f1bm79yw0k5` (`id_user`),
  CONSTRAINT `FKbltj6xuakh3eb1f1bm79yw0k5` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjnpid3d6tk6dsnb9a072570gu` FOREIGN KEY (`id_nha_hang_food`) REFERENCES `nhahang_food` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhgia`
--

LOCK TABLES `danhgia` WRITE;
/*!40000 ALTER TABLE `danhgia` DISABLE KEYS */;
INSERT INTO `danhgia` VALUES (NULL,1,1,1,4,'tuyet lam'),(NULL,2,1,6,4,'kikk'),(NULL,3,1,6,4,'hhh'),(NULL,4,2,6,5,'nha hang nay dc do'),(NULL,5,2,6,4,'khong co cho che'),(NULL,6,2,6,4,'avc'),(NULL,7,2,6,4,'s'),(NULL,8,2,6,4,'e'),(NULL,9,2,6,2,'te'),(NULL,10,1,6,4,'sss'),(NULL,11,1,6,3,'ttt'),(NULL,12,1,6,3,'ttt'),(NULL,13,1,6,4,'ttt'),(NULL,14,1,6,4,'ass'),(NULL,15,2,6,3,''),(NULL,16,2,6,5,''),(NULL,17,2,6,4,''),(NULL,18,2,6,3,''),(NULL,19,2,6,5,''),(NULL,20,2,6,5,''),(NULL,21,2,6,5,''),(NULL,22,2,6,5,''),(NULL,23,2,6,5,''),(NULL,24,2,6,5,''),(NULL,25,2,6,5,''),(NULL,26,2,6,5,''),(NULL,27,2,6,5,''),(NULL,28,2,6,5,''),(NULL,29,2,6,4,''),(NULL,30,2,6,4,'asdasd'),(NULL,31,2,6,4,''),(NULL,32,2,6,4,''),(NULL,33,2,6,5,''),(NULL,34,2,6,5,'test'),(NULL,35,2,6,1,'123123'),(NULL,36,2,6,5,'hieu dep trai'),(NULL,37,1,6,5,'code hay qua'),(NULL,38,1,6,4,'fgdfg');
/*!40000 ALTER TABLE `danhgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donhang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int DEFAULT NULL,
  `tong_tien` double DEFAULT NULL,
  `trang_thai` int DEFAULT NULL,
  `ngay_gio` datetime(6) DEFAULT NULL,
  `ghi_chu` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtiw5qt064wjx6cfeesghl43v1` (`id_user`),
  CONSTRAINT `FKtiw5qt064wjx6cfeesghl43v1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
INSERT INTO `donhang` VALUES (1,1,11111,1,'2023-07-25 23:05:52.204000','cho'),(2,1,11111,3,'2023-07-25 23:05:52.204000','cho'),(3,1,0,3,'2023-07-25 07:00:00.000000','Đang giao'),(4,3,0,3,'2023-07-25 23:05:52.204000','Đang giao'),(5,3,0,3,'2023-07-25 23:05:52.204000','Đang giao'),(6,3,0,3,'2023-07-25 14:00:00.000000','Đang giao'),(7,3,0,3,'2023-07-26 17:21:46.803000','Đang giao'),(8,3,0,3,'2023-07-26 13:55:33.398000','Đang giao'),(9,3,175,3,'2023-07-26 14:14:06.032000','Đang giao'),(10,3,95000,3,'2023-07-26 14:18:42.531000','Đang giao'),(11,3,55000,3,'2023-07-26 14:33:46.845000','Đang giao'),(12,3,75000,3,'2023-07-26 14:35:02.790000','Đang giao'),(13,3,35000,3,'2023-07-26 14:36:33.272000','Đang giao'),(14,3,55000,3,'2023-07-26 14:41:36.820000','Đang giao'),(15,3,35000,3,'2023-07-26 14:42:11.480000','Đang giao'),(16,3,35000,3,'2023-07-26 14:56:02.469000','Đang giao'),(17,3,55000,3,'2023-07-26 15:04:07.557000','Đang giao'),(18,3,35000,3,'2023-07-26 15:05:16.275000','Đang giao'),(19,3,55000,3,'2023-07-26 15:06:09.419000','Đang giao'),(20,3,135000,4,'2023-07-26 15:07:34.539000','Đang giao'),(21,3,55000,3,'2023-07-26 15:08:37.318000','Đang giao'),(22,NULL,75000,3,'2023-07-26 20:47:03.591000','Đang giao'),(23,NULL,55000,3,'2023-07-26 20:47:36.620000','Đang giao'),(24,6,55000,3,'2023-07-26 20:48:47.292000','Đang giao'),(25,6,35000,4,'2023-07-26 20:50:02.359000','Đang giao'),(26,6,95000,3,'2023-07-26 20:50:14.315000','Đang giao'),(27,6,75000,3,'2023-07-26 20:55:50.268000','Đang giao'),(28,6,35000,3,'2023-07-26 20:58:42.478000','Đang giao'),(29,NULL,55000,3,'2023-07-26 21:21:01.072000','Đang giao'),(30,6,55000,3,'2023-07-26 22:05:10.674000','Đang giao'),(31,6,55000,3,'2023-07-26 22:07:37.453000','Đang giao'),(32,6,55000,3,'2023-07-26 22:13:03.780000','Đang giao'),(33,6,35000,3,'2023-07-26 22:14:07.811000','Đang giao'),(34,6,35000,3,'2023-07-26 22:18:00.915000','Đang giao'),(35,6,55000,3,'2023-07-26 22:20:03.415000','Đang giao'),(36,6,55000,3,'2023-07-26 22:21:38.875000','Đang giao'),(37,6,55000,3,'2023-07-26 22:23:04.622000','Đang giao'),(38,6,55000,4,'2023-07-26 22:23:56.199000','Đang giao'),(39,6,55000,4,'2023-07-26 22:25:49.584000','Đang giao'),(40,6,55000,4,'2023-07-26 22:27:11.070000','Đang giao'),(41,6,135000,3,'2023-07-28 20:02:52.291000','Đang giao'),(42,6,85000,3,'2023-07-28 20:03:23.788000','Đang giao'),(43,6,85000,3,'2023-07-28 20:05:58.169000','Đang giao'),(44,6,85000,3,'2023-07-28 20:08:08.448000','Đang giao'),(45,6,155000,3,'2023-07-28 20:33:20.224000','Đang giao'),(46,6,495000,3,'2023-07-28 21:20:04.631000','Đang giao'),(47,6,495000,3,'2023-07-28 21:22:33.687000','Đang giao'),(48,6,175000,3,'2023-07-28 21:23:19.198000','Đang giao'),(49,6,205000,3,'2023-07-28 21:25:52.814000','Đang giao'),(50,6,245000,3,'2023-07-28 21:28:16.120000','Đang giao'),(51,6,195000,4,'2023-07-29 22:51:39.034000','Đang giao'),(52,6,615000,4,'2023-07-29 22:53:02.553000','Đang giao'),(53,1,155000,3,'2023-07-31 10:55:07.708000','Đang giao'),(54,6,435000,4,'2023-07-31 11:06:04.733000','Đang giao'),(55,1,155000,4,'2023-07-31 19:40:30.810000','Đang giao'),(56,6,155000,4,'2023-08-01 20:15:14.479000','Đang giao'),(57,6,155000,4,'2023-08-07 21:17:58.540000','Đang giao'),(58,6,85000,4,'2023-08-07 21:49:20.028000','Đang giao'),(59,6,35000,4,'2023-08-07 21:52:24.312000','Đang giao'),(60,6,215000,4,'2023-08-07 21:54:06.534000','Đang giao'),(61,6,335000,4,'2023-08-07 22:19:24.372000','Đang giao');
/*!40000 ALTER TABLE `donhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `gia_tien` double DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `id_loai` int DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ten` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKocw20ivjwa8mj7j30dyqg556s` (`id_loai`),
  CONSTRAINT `FKocw20ivjwa8mj7j30dyqg556s` FOREIGN KEY (`id_loai`) REFERENCES `loaifood` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (70000,1,1,'https://alltop.vn/backend/media/images/posts/2141/Com_Que_Muoi_Kho-122611.jpg','Cơm gà xối mỡ'),(90000,2,1,'https://cdn.tgdd.vn/2020/08/CookProduct/ava-1200x676-38.jpg','Cơm cá hồi phi lê áp chảo'),(350000,3,1,'https://images.baoquangnam.vn/Storage/NewsPortal/2022/6/24/128812/TNB-52627.jpg','Cơm phần cho gia đình'),(120000,4,1,'https://www.hoidaubepaau.com/wp-content/uploads/2016/04/cach-lam-com-chien-hai-san.jpg','Cơm chiên hải sản'),(110000,5,1,'http://www.monngon.tv/uploads/images/images/com-chien-ca-man-5(1).jpg','Cơm chiên cá mặn'),(90000,6,1,'https://baomoi-photo-fbcrawler.zadn.vn/w720x480/2019_07_21_180_31546126/6b7c0a264d66a438fd77.jpg','Cơm sườn bì chả'),(120000,7,1,'https://thongcaobaochi.net/wp-content/uploads/2022/06/pncn22-sai-gon-an-vat-dam-_231654187753.jpg','Cơm sườn cộng bì chả'),(90000,8,1,'https://i.ytimg.com/vi/S2bfZr2s-1g/maxresdefault.jpg','Cơm gà chiên nước mắm'),(70000,9,1,'https://blog.beemart.vn/wp-content/uploads/2018/10/cach-lam-com-han-quoc-90.jpg','Cơm trộn hàn quốc'),(20000,10,1,'https://product.hstatic.net/200000523823/product/cha_them_74a11d5827534d6995ab6404710ebb4e_large.jpg','Chả trưng thêm'),(10000,11,1,'https://poongsankorea.vn/medias/e51/images/2022/05/trung-op-la-bao-nhieu-calo-2.jpg','Trứng thêm'),(50000,12,1,'https://cdn.tgdd.vn/2021/03/CookProduct/CookyVN-CachlamSUONNUONGNGUVIsieungonchobuacomnhadamda-CookyTV1-14screenshot(1)-1200x676.jpg','Sườn thêm'),(20000,13,1,'https://cdn.tgdd.vn/2021/02/content/lap3-800x450.jpg','Lạp xưởng thêm');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaifood`
--

DROP TABLE IF EXISTS `loaifood`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaifood` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaifood`
--

LOCK TABLES `loaifood` WRITE;
/*!40000 ALTER TABLE `loaifood` DISABLE KEYS */;
INSERT INTO `loaifood` VALUES (1,'cơm'),(2,'cà phê'),(3,'mì'),(4,'fast food'),(5,'trà sữa'),(6,'snack'),(7,'đặc trưng'),(8,'healthy');
/*!40000 ALTER TABLE `loaifood` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhahang`
--

DROP TABLE IF EXISTS `nhahang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhahang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dia_chi` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `so_dien_thoai` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ten` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhahang`
--

LOCK TABLES `nhahang` WRITE;
/*!40000 ALTER TABLE `nhahang` DISABLE KEYS */;
INSERT INTO `nhahang` VALUES (1,'https://pasgo.vn/Upload/anh-chi-tiet/nha-hang-com-que-muoi-kho-nguyen-van-troi-10-normal-1778524648730.jpg','27 Trần Quốc Thảo, Phường 6, Quận 3 Thành phố Hồ Chí Minh','muoikho87@gmail.com','0922237577','Cơm Quê Mười Khó'),(2,'https://icolor.vn/wp-content/uploads/2021/06/sa-bi-chuong.jpg','179 Trần Bình Trọng, Phường 3, Quận 5 Thành phố Hồ Chí Minh 700000','sabichuong87@gmail.com','0555554544','Sà Bì Chưởng');
/*!40000 ALTER TABLE `nhahang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhahang_food`
--

DROP TABLE IF EXISTS `nhahang_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhahang_food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_food` int DEFAULT NULL,
  `id_nha_hang` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6qduxegxh1jsgeartvk941aud` (`id_food`),
  KEY `FKbuvfes10kuar9xohxsslff906` (`id_nha_hang`),
  CONSTRAINT `FK6qduxegxh1jsgeartvk941aud` FOREIGN KEY (`id_food`) REFERENCES `food` (`id`),
  CONSTRAINT `FKbuvfes10kuar9xohxsslff906` FOREIGN KEY (`id_nha_hang`) REFERENCES `nhahang` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhahang_food`
--

LOCK TABLES `nhahang_food` WRITE;
/*!40000 ALTER TABLE `nhahang_food` DISABLE KEYS */;
INSERT INTO `nhahang_food` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,2),(7,7,2),(8,8,2),(9,9,2),(10,10,2),(11,11,2),(12,12,2),(13,13,2);
/*!40000 ALTER TABLE `nhahang_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quyen` int DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dia_chi` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mat_khau` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `so_dien_thoai` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tai_khoan` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ten` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'123','th nhat ngu','th nhat ngu','$2a$10$HLZ7Is3F0pvGnE7p3es9PuXsxv95RtkCxcYEFYiH6X.rrXIJF7MHy','th nhat ngu','th nhat ngu','th nhat ngu 1234'),(2,1,'123','abc','123','$2a$10$M0rxdLZTsYqjWZzLQYguruYGgdndEEA0P9NmsTfIB1UytG.kIBlqG','123','nhaasasdasdt',NULL),(3,NULL,NULL,'','',NULL,'','example',''),(4,NULL,NULL,'123','pmquan176@gmail.com',NULL,'0788363329','quan','phan minh quan'),(5,NULL,NULL,'abc','123@gmail.com','$2a$10$yjTeNOOHgtwwzHmfzggwLuXTukHTJSAHdS/tjh43/qPMpujx00sZ2','0788363329','quanphan','phan minh quan'),(6,NULL,NULL,'123','123','$2a$10$DumEYyVvmglu7VUc6pzWweMeoW3FZak.f.LM77ZPkEn0sVsa6kTj.','123','example123','examplegi do'),(7,NULL,NULL,'222','111','$2a$10$HFMUuX77OmksPFmHNEbBZeTXVZ1x8utN9v2lgTtJRlaQKCNjX.5cu','121','example44','11'),(8,NULL,NULL,'sss','sss','$2a$10$AufdBE.9dZ4V6rq/odo47eHm8dDmgdjnsbdCONc3nw9wvNcuYoEDa','34554','example333','dsfgd'),(9,NULL,NULL,'a','a','$2a$10$pHaUfrDiK41ec/UlgPiiC.KNhifMilz6DcAhkIXW2fmo5/LAOR2au','12312312312','example1313','a'),(10,NULL,NULL,'ddddd','dddd','$2a$10$jp0SghkyM/kIHZ5eWuxFfu.IQJV04ypC2J3dWbOZJVc3uwrQDTUXG','07886666666','example12345','quaaaan'),(11,NULL,NULL,'abcv','quan@gmail.com','$2a$10$hStc200UGYXP4D1K6bLq9.BX7ApLhqokI2E23BBO2oU3xK6QPcelW','0788362232','quanphan333','phan minh quan'),(12,NULL,NULL,'aaa','abc','$2a$10$XQ9tkJBMg0IQDZibFz6bburXZQYfnTxy7OnwwYJZHJwXTNfOB6xzy','0123456789','nhatnguyen','nhat nguyen ');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_uudai`
--

DROP TABLE IF EXISTS `user_uudai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_uudai` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int DEFAULT NULL,
  `id_uu_dai` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm1f9wy5h064mru1tkp98xjo6j` (`id_user`),
  KEY `FKs920mv003f59ekv8rq721llni` (`id_uu_dai`),
  CONSTRAINT `FKm1f9wy5h064mru1tkp98xjo6j` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKs920mv003f59ekv8rq721llni` FOREIGN KEY (`id_uu_dai`) REFERENCES `uudai` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_uudai`
--

LOCK TABLES `user_uudai` WRITE;
/*!40000 ALTER TABLE `user_uudai` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_uudai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uudai`
--

DROP TABLE IF EXISTS `uudai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uudai` (
  `gia_tri` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `id_nha_hang_food` int DEFAULT NULL,
  `ngay_batdau` datetime(6) DEFAULT NULL,
  `ngay_ket_thuc` datetime(6) DEFAULT NULL,
  `hinh_anh` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `loai` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `noi_dung` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp1po27njurs7b3jt03usu4eyv` (`id_nha_hang_food`),
  CONSTRAINT `FKp1po27njurs7b3jt03usu4eyv` FOREIGN KEY (`id_nha_hang_food`) REFERENCES `nhahang_food` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uudai`
--

LOCK TABLES `uudai` WRITE;
/*!40000 ALTER TABLE `uudai` DISABLE KEYS */;
/*!40000 ALTER TABLE `uudai` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-16 14:08:05
