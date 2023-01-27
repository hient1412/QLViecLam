-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: tuyenvl
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `maAdmin` int NOT NULL AUTO_INCREMENT,
  `hoAdmin` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tenAdmin` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `soDT` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `maTK` int DEFAULT NULL,
  PRIMARY KEY (`maAdmin`),
  KEY `admin_tk_idx` (`maTK`),
  CONSTRAINT `admin_tk` FOREIGN KEY (`maTK`) REFERENCES `taikhoan` (`maTK`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Nguyen','Nhung','nhungN1@gmail.com','0254525632',75),(2,'Tran','Hiền','hient11@gmail.com','0582832145',2);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `binhluan`
--

DROP TABLE IF EXISTS `binhluan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `binhluan` (
  `maBinhLuan` int NOT NULL AUTO_INCREMENT,
  `binhLuan` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngayBinhLuan` datetime DEFAULT NULL,
  `maNTD` int DEFAULT NULL,
  `maTK` int DEFAULT NULL,
  PRIMARY KEY (`maBinhLuan`),
  KEY `bl_ntd_idx` (`maNTD`),
  KEY `bl_tk_idx` (`maTK`),
  CONSTRAINT `bl_ntd` FOREIGN KEY (`maNTD`) REFERENCES `nhatuyendung` (`maNTD`) ON DELETE CASCADE,
  CONSTRAINT `bl_tk` FOREIGN KEY (`maTK`) REFERENCES `taikhoan` (`maTK`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binhluan`
--

LOCK TABLES `binhluan` WRITE;
/*!40000 ALTER TABLE `binhluan` DISABLE KEYS */;
INSERT INTO `binhluan` VALUES (38,'Good','2022-09-03 03:41:41',1,4),(39,'Nice\n','2022-09-03 03:41:52',1,4),(40,'Wonderful','2022-09-03 03:42:08',2,4),(41,'Wonderful','2022-09-03 03:42:09',2,4),(42,'Hi','2022-09-03 03:42:19',2,4),(43,'test','2022-09-03 21:23:17',2,74),(44,'Hi\n','2022-09-04 05:48:47',2,73),(45,'1-2-3','2022-09-04 05:48:56',2,73),(46,'ntd\n','2022-09-04 05:57:07',1,73);
/*!40000 ALTER TABLE `binhluan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaivl`
--

DROP TABLE IF EXISTS `loaivl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaivl` (
  `maLoaiVL` int NOT NULL AUTO_INCREMENT,
  `tenLoaiVL` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`maLoaiVL`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaivl`
--

LOCK TABLES `loaivl` WRITE;
/*!40000 ALTER TABLE `loaivl` DISABLE KEYS */;
INSERT INTO `loaivl` VALUES (3,'Văn phòng'),(4,'Du lịch'),(7,'IT'),(8,'Kinh doanh'),(9,'Y tế'),(10,'Không phân loại'),(11,'Giáo dục');
/*!40000 ALTER TABLE `loaivl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhatuyendung`
--

DROP TABLE IF EXISTS `nhatuyendung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhatuyendung` (
  `maNTD` int NOT NULL AUTO_INCREMENT,
  `tenNTD` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `diaChi` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `soDT` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `moTaNTD` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `avatar` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `maTK` int DEFAULT NULL,
  PRIMARY KEY (`maNTD`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `TK_UV_idx` (`maTK`),
  CONSTRAINT `ntd_tk` FOREIGN KEY (`maTK`) REFERENCES `taikhoan` (`maTK`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhatuyendung`
--

LOCK TABLES `nhatuyendung` WRITE;
/*!40000 ALTER TABLE `nhatuyendung` DISABLE KEYS */;
INSERT INTO `nhatuyendung` VALUES (1,'CÔNG TY TNHH NHUNG KHA','12 nguyen chi thanh','025825632','nhung1@gmail.com','Trên đây là những nội dung chính về \"Chính sách Quản lý” của Công ty TNHH Một thành viên Bò sữa Việt Nam (Vietnam Dairy Cow One-Member Co., Ltd.). Công ty được thành lập vào thời điểm Vinamilk mua lại Trung tâm nhân giống Bò sữa - Bò thịt cao sản Phú Lâm do UBND tỉnh Tuyên Quang quản lý. Vinamilk ngay từ đầu đã xác định đây là đơn vị đóng vai trò trụ cột trong việc sản xuất cung ứng nguyên liệu sữa bò tươi để cung cấp cho các nhà máy chế biến.','https://res.cloudinary.com/dxs9d8uua/image/upload/v1661453159/urh0kmsgkxktheudu9m3.jpg',74),(2,'CÔNG TY TNHH MY THANH','45a nguyen truong to','0144568201','mythanh@gmail.com','Social media – Thống kê cho thấy rằng 500+ terabyte dữ liệu mới được đưa vào cơ sở dữ liệu của trang mạng xã hội Facebook mỗi ngày. Dữ liệu này chủ yếu được tạo về tải lên ảnh và video, trao đổi tin nhắn, bình luận','https://res.cloudinary.com/dxs9d8uua/image/upload/v1662294501/cldfpgqbmthjuu1fty6s.jpg',73);
/*!40000 ALTER TABLE `nhatuyendung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `maTK` int NOT NULL AUTO_INCREMENT,
  `taiKhoan` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `matKhau` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `loaiTK` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `trangThai` int DEFAULT '0',
  PRIMARY KEY (`maTK`),
  UNIQUE KEY `taiKhoan_UNIQUE` (`taiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (2,'hien','$2a$10$hfdLSVw3GbecILskhAjViOvSmEDAuZn8fmSy4g/7/gw3S1DdQmhLe','ROLE_ADMIN',1),(3,'dat','$2a$10$hfdLSVw3GbecILskhAjViOvSmEDAuZn8fmSy4g/7/gw3S1DdQmhLe','ROLE_UV',1),(4,'nguyen','$2a$10$hfdLSVw3GbecILskhAjViOvSmEDAuZn8fmSy4g/7/gw3S1DdQmhLe','ROLE_UV',1),(73,'ntd','$2a$10$hfdLSVw3GbecILskhAjViOvSmEDAuZn8fmSy4g/7/gw3S1DdQmhLe','ROLE_NTD',1),(74,'testntd','$2a$10$hfdLSVw3GbecILskhAjViOvSmEDAuZn8fmSy4g/7/gw3S1DdQmhLe','ROLE_NTD',1),(75,'nhung','$2a$10$hfdLSVw3GbecILskhAjViOvSmEDAuZn8fmSy4g/7/gw3S1DdQmhLe','ROLE_ADMIN',1);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tintuyendung`
--

DROP TABLE IF EXISTS `tintuyendung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tintuyendung` (
  `maTTD` int NOT NULL AUTO_INCREMENT,
  `tenTTD` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngayDang` datetime DEFAULT NULL,
  `ngayKT` datetime DEFAULT NULL,
  `trangThai` int DEFAULT NULL,
  `viTri` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `moTaTTD` text COLLATE utf8_unicode_ci,
  `soLuong` int DEFAULT NULL,
  `kinhNghiem` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `noiLamViec` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `luong` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `maNTD` int DEFAULT NULL,
  `maLoaiVL` int DEFAULT NULL,
  PRIMARY KEY (`maTTD`),
  KEY `ttd_ntd_idx` (`maNTD`),
  KEY `ttd_loaivl_idx` (`maLoaiVL`),
  CONSTRAINT `ttd_loaivl` FOREIGN KEY (`maLoaiVL`) REFERENCES `loaivl` (`maLoaiVL`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `ttd_ntd` FOREIGN KEY (`maNTD`) REFERENCES `nhatuyendung` (`maNTD`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tintuyendung`
--

LOCK TABLES `tintuyendung` WRITE;
/*!40000 ALTER TABLE `tintuyendung` DISABLE KEYS */;
INSERT INTO `tintuyendung` VALUES (1,'Tuyen IT Intern','2021-12-14 00:00:00','2021-12-21 00:00:00',1,'Trưởng phòng','Lũy tre làng in bóng trên nền trời thật bình dị. Phía phương Tây, bầu trời đỏ rực như lửa cháy. Ông mặt trời giống như một quả cầu khổng lồ đang nặng nhọc nhích từng bước xuống dưới mặt đất. Dường như ông đã quá mệt mỏi sau một ngày làm việc vất vả.',2,'Không kinh nghiệm','Hà nội','10000000',1,7),(2,'Tuyen Nhân Viên','2022-01-06 00:00:00','2022-02-07 00:00:00',1,'Quản lý',' Cái nóng oi ả của ngày hè không ngăn cản được niềm say mê và vui tươi khi lao động của họ. Em dạo chơi trên con đường ven cánh đồng. Ôi! Thật yên bình và dễ chịu! Em yêu biết bao quê hương của mình',3,'Không kinh nghiệm','Tiền Giang','12000000',1,10),(3,'Nhân viên kinh doanh','2022-01-06 00:00:00','2022-02-07 00:00:00',1,'Marketing','Bầu không khí trong lành khiến con người cảm thấy dễ chịu. Xa xa, cánh đồng lúa đã chín vàng. Con đường làng lúc này vẫn vắng vẻ. Trở về ngôi nhà của mình, phía sau nhà là khu vườn nhỏ của em lúc này trông tràn đầy sức sống.',2,'2 năm','Hồ Chí Minh','7500000',1,8),(4,'Nhân viên văn phòng','2022-01-06 00:00:00','2022-02-07 00:00:00',1,'Phó phòng','Ông mặt trời như một quả bóng khổng lồ tỏa ánh nắng chói chang xuống mọi nơi. Em cùng các anh chị thỏa thích vui đùa trên bãi cát, nghịch nước biển mát lạnh.',1,'1 năm','Hồ Chí Minh','6000000',1,3),(5,'Nhân viên kiểm thử','2022-01-07 00:00:00','2022-02-07 00:00:00',1,'Tester','Một vụ mùa bội thu hứa hẹn cho một năm sung túc, ấm no. Trẻ em đang chơi thả diều ở con đê đầu làng. Em dạo chơi cùng với bà nội trên đường. Ôi, quê hương! Thật tuyệt vời biết bao!',4,'Không kinh nghiệm','Hồ Chí Minh','13000000',2,7),(6,'Tuyen nhan vien phong ban','2022-01-06 00:00:00','2022-02-07 00:00:00',1,'Thiết kế','on người Hà Nội rất thanh lịch, hiếu khách. Mỗi mùa, Hà Nội lại mang một nét đẹp riêng. Nhưng em thích nhất là mùa thu Hà Nội. Mùa thu ở đây có hương hoa sữa nồng nàn, những con đường ngập lá vàng.',2,'1 năm','Hà nội','18000000',2,10),(7,'Du lich','2022-01-06 00:00:00','2022-02-07 00:00:00',1,'Hướng dẫn viên','Ở Hà Nội có nhiều điểm tham quan rất nổi tiếng như hồ Gươm, tháp Rùa, đền Ngọc Sơn, chùa Một Cột, Văn miếu Quốc Tử Giám, Hoàng Thành Thăng Long… thu hút nhiều khách du lịch. ',3,'3 năm','Hà nội','20000000',2,4),(22,'Nhân viên y tế','2022-02-06 00:00:00','2022-02-07 00:00:00',0,'Điều dưỡng','Làn khói bếp màu lam bay lên, quyện vào nhau trên không trung. Cánh đồng cũng tỉnh dậy sau một giấc ngủ dài. Ánh mặt trời chan hòa khắp muôn nơi',1,'2 năm','Long An','17600000',2,9),(23,'Nhân viên bảo trì','2022-02-06 00:00:00','2022-02-07 00:00:00',0,'Kỹ thuật viên','Từ khi còn rất nhỏ, hình ảnh cánh đồng lúa đã vô cùng thân thuộc với em. Cánh đồng lúa quê hương em đẹp như một tấm thảm khổng lồ.',2,'2 năm','Long An','9000000',2,9),(28,'Tuyen','2022-09-04 06:49:04','2022-01-17 00:09:00',1,'sdf','dffs',4,'sdf','Há» ChÃ­ Minh','50000000',2,3),(35,'Hiá»n','2022-09-04 08:47:09','2022-01-09 00:09:00',0,'sdfsdfsdf','fdsdff',4,'sdkjfdskjh','HÃÂ¡ÃÂ»ÃÂ ChÃÂÃÂ­ Minh','50000000',1,3);
/*!40000 ALTER TABLE `tintuyendung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ungtuyen`
--

DROP TABLE IF EXISTS `ungtuyen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ungtuyen` (
  `maUT` int NOT NULL AUTO_INCREMENT,
  `ngayUT` datetime DEFAULT NULL,
  `maTTD` int DEFAULT NULL,
  `maUV` int DEFAULT NULL,
  PRIMARY KEY (`maUT`),
  KEY `ut_uv_idx` (`maUV`),
  KEY `ut_ttd_idx` (`maTTD`),
  CONSTRAINT `ut_ttd` FOREIGN KEY (`maTTD`) REFERENCES `tintuyendung` (`maTTD`),
  CONSTRAINT `ut_uv` FOREIGN KEY (`maUV`) REFERENCES `ungvien` (`maUV`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ungtuyen`
--

LOCK TABLES `ungtuyen` WRITE;
/*!40000 ALTER TABLE `ungtuyen` DISABLE KEYS */;
INSERT INTO `ungtuyen` VALUES (1,'2022-09-04 00:00:00',1,3);
/*!40000 ALTER TABLE `ungtuyen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ungvien`
--

DROP TABLE IF EXISTS `ungvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ungvien` (
  `maUV` int NOT NULL AUTO_INCREMENT,
  `hoUV` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tenUV` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngaySinh` datetime DEFAULT NULL,
  `diaChi` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `queQuan` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `noiLamViec` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `moTaUV` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `gioiTinh` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `cv` text COLLATE utf8_unicode_ci,
  `maTK` int DEFAULT NULL,
  PRIMARY KEY (`maUV`),
  KEY `tk_uv_idx` (`maTK`),
  CONSTRAINT `uv_tk` FOREIGN KEY (`maTK`) REFERENCES `taikhoan` (`maTK`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ungvien`
--

LOCK TABLES `ungvien` WRITE;
/*!40000 ALTER TABLE `ungvien` DISABLE KEYS */;
INSERT INTO `ungvien` VALUES (3,'Le','Thanh','2001-01-30 00:00:00','112 Nguyen Trai','Dong Nai','dfgdfg@gmail.com','Ha tinh','Dữ liệu là một tập hợp các dữ kiện, chẳng hạn như số, từ, hình ảnh, nhằm đo lường, quan sát hoặc chỉ là mô tả về sự vật. Sự phát triển trong lĩnh vực công nghệ, đặc biệt là trong điện thoại thông minh đã dẫn đến việc văn bản, video và âm thanh được đưa vào dữ liệu cùng với nhật ký web. Hầu hết dữ liệu này là không có cấu trúc.','Nam','https://res.cloudinary.com/dxs9d8uua/image/upload/v1661453159/urh0kmsgkxktheudu9m3.jpg','https://res.cloudinary.com/dxs9d8uua/image/upload/v1662299200/arp7jeeirpl1hzydt8wd.jpg',3),(4,'Phan','Anh','2000-04-06 00:00:00','92 Nguyen Chi Thanh','Ha Noi','acvd@gmail.com','Hà nội','Với trình độ và kinh nghiệm hiện có, tôi tự tin có thể đảm nhiệm tốt vị trí ứng tuyển của Quý Công ty. Cảm ơn chị đã dành thời gian quý báu để xem xét bức thư này. Tôi rất mong chị có thể sắp xếp một cuộc phỏng vấn trực tiếp gần đây nhất để tôi có thể trình bày rõ hơn về bản thân.','Nam','https://res.cloudinary.com/dxs9d8uua/image/upload/v1661453159/urh0kmsgkxktheudu9m3.jpg','https://res.cloudinary.com/dxs9d8uua/image/upload/v1661453159/urh0kmsgkxktheudu9m3.jpg',4);
/*!40000 ALTER TABLE `ungvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-05  1:31:30
