/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.5.27 : Database - mall
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mall` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `mall`;

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `staff_id` INT(30) UNSIGNED NOT NULL AUTO_INCREMENT,
  `staff_name` VARCHAR(255) NOT NULL,
  `staff_age` INT(30) NOT NULL,
  `staff_sex` VARCHAR(15) NOT NULL,
  `staff_phone` VARCHAR(255) NOT NULL,
  `staff_note` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=INNODB AUTO_INCREMENT=1018 DEFAULT CHARSET=utf8mb4;

/*Data for the table `staff` */

INSERT  INTO `staff`(`staff_id`,`staff_name`,`staff_age`,`staff_sex`,`staff_phone`,`staff_note`) VALUES 
(1001,'向玉',24,'男','12345678911',''),
(1002,'孔弘济',26,'男','12345678912',''),
(1003,'高新瑶',27,'女','12345678913',''),
(1004,'邱迎海',29,'女','12345678915',''),
(1005,'赵弘新',30,'男','12345678916',''),
(1006,'白香彤 ',31,'女','12345678917',''),
(1007,'杜力强',32,'男','12345678918',''),
(1008,'张元彤',33,'女','12345678919',''),
(1009,'董华采',34,'男','12345678910',''),
(1011,'刘含灵',11,'女','12345678923',''),
(1012,'金丹琴 ',14,'女','12345666664',''),
(1013,'万明辉',11,'男','15728111111',''),
(1014,'石初曼 ',22,'女','12345678915','');

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `stock_id` INT(30) NOT NULL AUTO_INCREMENT,
  `stock_name` VARCHAR(255) NOT NULL,
  `costprice` DOUBLE NOT NULL,
  `stock_standard` VARCHAR(255) NOT NULL,
  `stock_qty` INT(30) NOT NULL,
  PRIMARY KEY (`stock_id`)
) ENGINE=INNODB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4;

/*Data for the table `stock` */

INSERT  INTO `stock`(`stock_id`,`stock_name`,`costprice`,`stock_standard`,`stock_qty`) VALUES 
(100,'百事可乐',2,'500ml',4000),
(101,'可口可乐',2.5,'400ml',3000),
(102,'芬达',2.6,'400ml',2000),
(103,'雪碧',2.7,'410ml',1000),
(104,'美年达',2.8,'420ml',1002),
(105,'七喜',2.9,'100ml',1111),
(106,'橙汁',4,'200ml',2223);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` INT(30) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=INNODB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

INSERT  INTO `user`(`uid`,`username`,`password`) VALUES 
(1,'admin','admin'),
(2,'xiaoming','12345'),
(3,'xiaohong','12345'),
(4,'xiaogang','123'),
(6,'xiaoxiao','123'),
(14,'xiaoyu','12345');

/*Table structure for table `vip` */

DROP TABLE IF EXISTS `vip`;

CREATE TABLE `vip` (
  `vip_id` INT(30) NOT NULL AUTO_INCREMENT,
  `vip_name` VARCHAR(765) DEFAULT NULL,
  `vip_age` INT(100) DEFAULT NULL,
  `vip_sex` VARCHAR(300) DEFAULT NULL,
  `vip_phone` VARCHAR(300) DEFAULT NULL,
  `vip_address` VARCHAR(765) DEFAULT NULL,
  `vip_grade` INT(100) DEFAULT NULL,
  `vip_integral` INT(100) DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

/*Data for the table `vip` */

INSERT  INTO `vip`(`vip_id`,`vip_name`,`vip_age`,`vip_sex`,`vip_phone`,`vip_address`,`vip_grade`,`vip_integral`) VALUES 
(1002,'王五',25,'男','12345655678','广东海洋大学',1,345),
(1003,'王二',33,'女','15728111111','科技学院',2,678),
(1005,'李五',25,'男','13539555701','哈哈哈',1,24);

/*Table structure for table `wages` */

DROP TABLE IF EXISTS `wages`;

CREATE TABLE `wages` (
  `wages_id` INT(30) UNSIGNED NOT NULL AUTO_INCREMENT,
  `wages_job` VARCHAR(255) DEFAULT NULL,
  `wages_basepay` INT(30) DEFAULT NULL,
  `wages_subsidy` INT(30) DEFAULT NULL,
  `wages_reward` INT(30) DEFAULT NULL,
  `wages_note` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`wages_id`)
) ENGINE=INNODB AUTO_INCREMENT=1018 DEFAULT CHARSET=utf8mb4;

/*Data for the table `wages` */

INSERT  INTO `wages`(`wages_id`,`wages_job`,`wages_basepay`,`wages_subsidy`,`wages_reward`,`wages_note`) VALUES 
(1001,'销售',3000,300,180,'测试'),
(1002,'销售',4000,200,190,NULL),
(1003,'销售组员',3500,400,500,NULL),
(1004,'保洁组长',3600,400,240,NULL),
(1005,'销售',4000,500,322,NULL),
(1006,'业务组长',4599,433,233,NULL),
(1007,'业务组长',5000,488,444,NULL),
(1008,'仓库管理员',5000,400,333,NULL),
(1009,'仓库管理员',4556,233,555,NULL),
(1011,'保洁组长',7000,500,600,NULL),
(1012,'销售组长',10000,443,454,NULL),
(1013,'业务组长',11443,3222,3333,NULL),
(1014,'销售组长',12000,3300,200,'新增员工');

/*Table structure for table `ware` */

DROP TABLE IF EXISTS `ware`;

CREATE TABLE `ware` (
  `ware_id` INT(30) NOT NULL AUTO_INCREMENT,
  `ware_name` VARCHAR(100) NOT NULL,
  `retailprice` DOUBLE NOT NULL,
  PRIMARY KEY (`ware_id`)
) ENGINE=INNODB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4;

/*Data for the table `ware` */

INSERT  INTO `ware`(`ware_id`,`ware_name`,`retailprice`) VALUES 
(100,'百事可乐',9),
(101,'可口可乐',4),
(102,'芬达',5),
(103,'雪碧',5),
(104,'美年达',4),
(105,'七喜',5),
(106,'橙汁',5);

/*Table structure for table `ware_img` */

DROP TABLE IF EXISTS `ware_img`;

CREATE TABLE `ware_img` (
  `img_id` INT(30) NOT NULL AUTO_INCREMENT,
  `img_src` VARCHAR(255) DEFAULT '../images/stock/default.png',
  PRIMARY KEY (`img_id`)
) ENGINE=INNODB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8mb4;

/*Data for the table `ware_img` */

INSERT  INTO `ware_img`(`img_id`,`img_src`) VALUES 
(100,'../images/stock/baishikele.jpg'),
(101,'../images/stock/kekoukele.jpg'),
(102,'../images/stock/fenda.jpg'),
(103,'../images/stock/xuebi.jpg'),
(104,'../images/stock/meinianda.jpg'),
(105,'../images/stock/qixi.jpg'),
(106,'../images/stock/baishikele.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
