/*
SQLyog Community v12.2.5 (64 bit)
MySQL - 8.0.18 : Database - db_demo_shoppingmall_clinetside
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_demo_shoppingmall_clinetside` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `db_demo_shoppingmall_clinetside`;

/*Table structure for table `shop_address` */

DROP TABLE IF EXISTS `shop_address`;

CREATE TABLE `shop_address` (
  `id` char(32) NOT NULL COMMENT 'id',
  `userID` char(32) NOT NULL COMMENT '會員ID',
  `accept` varchar(20) DEFAULT NULL COMMENT '收貨人',
  `zip` char(6) DEFAULT NULL COMMENT '郵遞區號',
  `phoneNum` char(10) NOT NULL COMMENT '手機',
  `city` varchar(20) NOT NULL COMMENT '城市',
  `area` varchar(20) NOT NULL COMMENT '地區',
  `address` varchar(30) NOT NULL COMMENT '地址',
  `isdefault` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否為默認地址,1為默認2為非默認',
  PRIMARY KEY (`id`),
  KEY `FK_shopuser_01` (`userID`),
  CONSTRAINT `FK_shopuser_01` FOREIGN KEY (`userID`) REFERENCES `shop_user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_address` */

insert  into `shop_address`(`id`,`userID`,`accept`,`zip`,`phoneNum`,`city`,`area`,`address`,`isdefault`) values 
('0e6b19a82e8c4dcb9d585d282df8b2cf','92d6fa5b7e854e9792ba60c9b84687bf','al','5#978','5225','嘉義市','東區','布袋','1'),
('3244c08acc52496e9b860f0488e2b8df','e23a5b094e8b43eb98bc6fd4c6ace7ec','eason','#3301','661','新北市','萬里區','new york','2'),
('6b09a238b6a74d65bdbb784ababbbf75','92d6fa5b7e854e9792ba60c9b84687bf','lee','110','921373','tainan','daiwan','#209','2'),
('d1a3030a3b984fb2a161788e5ac66bcd','92d6fa5b7e854e9792ba60c9b84687bf','Qaeda','185','0456880','桃園市','大溪區','690','2');

/*Table structure for table `shop_category` */

DROP TABLE IF EXISTS `shop_category`;

CREATE TABLE `shop_category` (
  `id` char(32) NOT NULL,
  `name` varchar(10) NOT NULL,
  `goodsNum` int(11) DEFAULT NULL COMMENT '商品數量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_category` */

insert  into `shop_category`(`id`,`name`,`goodsNum`) values 
('95a9df910cce4082ad8f773d326e712c','男裝',4),
('ad5176ba46c84111acc1c29e6e8456f5','女裝',3),
('cc871e93b1ae46f098c314b142f3423b','配件',0);

/*Table structure for table `shop_goods` */

DROP TABLE IF EXISTS `shop_goods`;

CREATE TABLE `shop_goods` (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  `goodsNo` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品編號',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名稱',
  `categoryid` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品分類',
  `price1` float NOT NULL COMMENT '市場價格',
  `price2` float NOT NULL COMMENT '價格',
  `stock` int(11) NOT NULL COMMENT '庫存',
  `thumbnail` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '縮圖',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '描述',
  PRIMARY KEY (`id`),
  KEY `FK_shopcategory_01` (`categoryid`),
  CONSTRAINT `FK_shopcategory_01` FOREIGN KEY (`categoryid`) REFERENCES `shop_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_goods` */

insert  into `shop_goods`(`id`,`goodsNo`,`name`,`categoryid`,`price1`,`price2`,`stock`,`thumbnail`,`description`) values 
('071708f906d44a8e9451971f7330680f','Happy20200718121101111','男牛津布襯衫-灰藍色','95a9df910cce4082ad8f773d326e712c',5.5,6.5,15,'goodsImages/',''),
('0900dd9c48ba4b479848b2a82f4e1463','Happy202007181214541454','男素面繡花短袖襯衫-淺藍色','95a9df910cce4082ad8f773d326e712c',5.5,6.5,15,'goodsImages/',''),
('5ee54269ccc746a486de1d93628d726c','Happy202007181216321632','仿天絲素面短袖襯衫(白)','95a9df910cce4082ad8f773d326e712c',5.5,6.5,15,'goodsImages/',''),
('975e2aafaf5646fb8aea777c1c263a99','Happy202007181359235923','女長版下擺剪接網紗短袖T恤-黑色','ad5176ba46c84111acc1c29e6e8456f5',10,15,11,'goodsImages/',''),
('cb73d15776904d3fa31345ee076ddfcd','Happy202007181212501250','短袖男仕吸濕排汗襯衫 藍色(台灣製造)','95a9df910cce4082ad8f773d326e712c',5.5,6.5,15,'goodsImages/',''),
('d1c7e77fd5b04e44874307117c9bfa3b','Happy20200718140139139','寬肩迷彩短袖上衣','ad5176ba46c84111acc1c29e6e8456f5',13,18,21,'goodsImages/',''),
('ee927f34827c4367a320e1062510fe4d','Happy20200718140056056','輕薄涼感造型短袖條紋上衣(黑/桔/藍)','ad5176ba46c84111acc1c29e6e8456f5',13,18,8,'goodsImages/','');

/*Table structure for table `shop_user` */

DROP TABLE IF EXISTS `shop_user`;

CREATE TABLE `shop_user` (
  `ID` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密碼',
  `phoneNum` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手機號碼',
  `money` float DEFAULT NULL COMMENT '金額',
  `avatar` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '頭像',
  `regTime` varchar(20) NOT NULL COMMENT '註冊時間',
  `role` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_user` */

insert  into `shop_user`(`ID`,`name`,`password`,`phoneNum`,`money`,`avatar`,`regTime`,`role`) values 
('0bf565fcf2224051b028d49878c1607e','8','8','8',0,NULL,'2020-07-20 00:16:00','u'),
('7dfa9d47208543d58fe6df3a54e7725d','2','2','2',0,NULL,'2020-07-13 16:45:01','a'),
('92d6fa5b7e854e9792ba60c9b84687bf','1','1','1',0,'useravatar/92d6fa5b7e854e9792ba60c9b84687bf.jpg','2020-07-12 23:27:40','u'),
('92d6fa5b7e854e9792ba6c9b8468asdv','admin','a','71247',0,NULL,'2020-07-11 0000000','a'),
('e23a5b094e8b43eb98bc6fd4c6ace7ec','lee','lee','lee',0,'useravatar/e23a5b094e8b43eb98bc6fd4c6ace7ec.jpg','2020-07-17 02:56:21','u');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
