/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : lin

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-10-18 10:02:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for movieroom
-- ----------------------------
DROP TABLE IF EXISTS `movieroom`;
CREATE TABLE `movieroom` (
  `id` int(5) DEFAULT NULL,
  `film` varchar(20) DEFAULT NULL,
  `filmID` int(10) DEFAULT NULL,
  `cinema` varchar(10) DEFAULT NULL,
  `AffiliatedCinema` varchar(20) DEFAULT NULL,
  `PlayTime` time DEFAULT NULL,
  `PlayDate` date DEFAULT NULL,
  `MovieHall` varchar(10) DEFAULT NULL,
  `MovieHallID` varchar(20) DEFAULT NULL,
  `TicketPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of movieroom
-- ----------------------------
INSERT INTO `movieroom` VALUES ('101153051', '追龙', '1', '大地影院', '10115', '08:00:00', '2017-10-10', '305', '10115305', '60');
