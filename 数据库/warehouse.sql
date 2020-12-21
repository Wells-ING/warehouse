/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : warehouse

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 20/12/2020 11:09:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for managers
-- ----------------------------
DROP TABLE IF EXISTS `managers`;
CREATE TABLE `managers` (
  `man_id` int(255) unsigned NOT NULL AUTO_INCREMENT,
  `man_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `man_password` varchar(255) COLLATE utf8_bin NOT NULL,
  `man_type` int(10) NOT NULL,
  PRIMARY KEY (`man_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of managers
-- ----------------------------
BEGIN;
INSERT INTO `managers` VALUES (1, 'Wells', '001005', 1);
INSERT INTO `managers` VALUES (2, 'Jack', '001005', 2);
INSERT INTO `managers` VALUES (3, 'Mary', '001005', 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
