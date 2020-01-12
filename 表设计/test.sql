/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-01-11 19:43:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(11) NOT NULL,
  `bookname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `pic` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `summry` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `class` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `readcount` bigint(20) DEFAULT NULL,
  `updatatime` datetime DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of book
-- ----------------------------

-- ----------------------------
-- Table structure for bookcontent
-- ----------------------------
DROP TABLE IF EXISTS `bookcontent`;
CREATE TABLE `bookcontent` (
  `bookid` int(11) NOT NULL,
  `chapter` int(11) NOT NULL,
  `bookcontent` blob NOT NULL,
  PRIMARY KEY (`bookid`,`chapter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bookcontent
-- ----------------------------

-- ----------------------------
-- Table structure for bookshelf
-- ----------------------------
DROP TABLE IF EXISTS `bookshelf`;
CREATE TABLE `bookshelf` (
  `bookid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`bookid`,`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bookshelf
-- ----------------------------
INSERT INTO `bookshelf` VALUES ('1', '1');
INSERT INTO `bookshelf` VALUES ('2', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `account` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
