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

 Date: 21/12/2020 16:31:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bads
-- ----------------------------
DROP TABLE IF EXISTS `bads`;
CREATE TABLE `bads` (
  `bad_id` int(255) NOT NULL,
  `order_id` int(255) NOT NULL,
  `man_id` int(255) NOT NULL,
  `bad_boxNumber` int(255) NOT NULL,
  `bad_decoration` varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`bad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_sku` varchar(255) COLLATE utf8_bin NOT NULL,
  `goods_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `goods_numberEachBox` int(10) NOT NULL,
  `goods_boxNumber` int(255) NOT NULL,
  `goods_eachPrice` decimal(10,2) NOT NULL,
  `goods_eachWeight` decimal(10,2) NOT NULL,
  `goods_material` varchar(255) COLLATE utf8_bin NOT NULL,
  `box_length` decimal(10,2) NOT NULL,
  `box_width` decimal(10,2) NOT NULL,
  `box_height` decimal(10,2) NOT NULL,
  `goods_barCode` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`goods_sku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for managers
-- ----------------------------
DROP TABLE IF EXISTS `managers`;
CREATE TABLE `managers` (
  `man_id` int(255) NOT NULL,
  `man_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `man_password` varchar(255) COLLATE utf8_bin NOT NULL,
  `man_type` int(10) NOT NULL,
  PRIMARY KEY (`man_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of managers
-- ----------------------------
BEGIN;
INSERT INTO `managers` VALUES (1, 'Wells', '001005', 1);
INSERT INTO `managers` VALUES (2, 'Jack', '001005', 2);
INSERT INTO `managers` VALUES (3, 'Mary', '001005', 3);
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `man_id` int(255) NOT NULL,
  `supplier_id` int(255) NOT NULL,
  `goods_sku` varchar(255) COLLATE utf8_bin NOT NULL,
  `order_boxNumber` int(11) NOT NULL,
  `order_freight` decimal(10,2) NOT NULL,
  `order_deposit` decimal(10,2) NOT NULL,
  `order_time` datetime NOT NULL,
  `order_status` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_orders_goods` (`goods_sku`),
  KEY `fk_orders_suppliers` (`supplier_id`),
  KEY `fk_orders_managers` (`man_id`),
  CONSTRAINT `fk_orders_goods` FOREIGN KEY (`goods_sku`) REFERENCES `goods` (`goods_sku`),
  CONSTRAINT `fk_orders_managers` FOREIGN KEY (`man_id`) REFERENCES `managers` (`man_id`),
  CONSTRAINT `fk_orders_suppliers` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for records
-- ----------------------------
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records` (
  `record_id` int(255) NOT NULL,
  `man_id` int(255) NOT NULL,
  `goods_sku` varchar(255) COLLATE utf8_bin NOT NULL,
  `supplier_id` int(255) NOT NULL,
  `goods_number` int(255) NOT NULL,
  `record_type` int(11) NOT NULL,
  `record_time` datetime NOT NULL,
  PRIMARY KEY (`record_id`),
  KEY `fk_records_managers` (`man_id`),
  KEY `fk_records_goods` (`goods_sku`),
  KEY `fk_records_suppliers` (`supplier_id`),
  CONSTRAINT `fk_records_goods` FOREIGN KEY (`goods_sku`) REFERENCES `goods` (`goods_sku`),
  CONSTRAINT `fk_records_managers` FOREIGN KEY (`man_id`) REFERENCES `managers` (`man_id`),
  CONSTRAINT `fk_records_suppliers` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for suppliers
-- ----------------------------
DROP TABLE IF EXISTS `suppliers`;
CREATE TABLE `suppliers` (
  `supplier_id` int(255) NOT NULL,
  `supplier_name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
