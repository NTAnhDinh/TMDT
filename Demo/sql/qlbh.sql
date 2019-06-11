/*
 Navicat Premium Data Transfer

 Source Server         : DACNPM
 Source Server Type    : MySQL
 Source Server Version : 100131
 Source Host           : localhost:3306
 Source Schema         : qlbh

 Target Server Type    : MySQL
 Target Server Version : 100131
 File Encoding         : 65001

 Date: 11/06/2019 13:56:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category_product
-- ----------------------------
DROP TABLE IF EXISTS `category_product`;
CREATE TABLE `category_product`  (
  `id_category` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_category`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category_product
-- ----------------------------
INSERT INTO `category_product` VALUES ('1', 'apple');
INSERT INTO `category_product` VALUES ('2', 'nokia');
INSERT INTO `category_product` VALUES ('3', 'samsung');

-- ----------------------------
-- Table structure for deleted_invoice
-- ----------------------------
DROP TABLE IF EXISTS `deleted_invoice`;
CREATE TABLE `deleted_invoice`  (
  `id_invoice` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id_invoice`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of deleted_invoice
-- ----------------------------
INSERT INTO `deleted_invoice` VALUES ('8', 'lỗi', '2019-06-05');
INSERT INTO `deleted_invoice` VALUES ('IV02023001', 'Report customer complaints', '2019-06-10');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id_feedback` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `receiver` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_report` datetime(0) DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_feedback`) USING BTREE,
  INDEX `fk_user1`(`id_user`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (1, 'Report selling goods', 1, 'hang', '2019-06-13 00:00:00', 'Name of product :SamSung J7 , requested quantity : 2\n', 0);
INSERT INTO `feedback` VALUES (2, 'Customer complaints', 1, 'dinh', '2019-05-31 23:17:25', ' Lorem ipsum dolor sit amet, consectetur\r\n                                                                        adipiscing elit, sed do eiusmod tempor\r\n                                                                        incididunt ut labore et dolor', 1);
INSERT INTO `feedback` VALUES (4, 'Report selling goods', 1, 'hang', '2019-06-13 00:00:00', 'Name of product :Apple a10 , requested quantity : 2 \rName of product :SamSung J7 , requested quantity : 2 \r', 1);

-- ----------------------------
-- Table structure for info_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `info_warehouse`;
CREATE TABLE `info_warehouse`  (
  `id_warehouse` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_warehouse`) USING BTREE,
  INDEX `fk_user2`(`id_user`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of info_warehouse
-- ----------------------------
INSERT INTO `info_warehouse` VALUES (1, 'Kho Bình Duong', 1, 1);

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice`  (
  `id_invoice` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_user` int(11) NOT NULL,
  `total` bigint(11) DEFAULT NULL,
  `payment` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT 'status of invoice : 0-new, 1: processing, 2: delevering, 3: finish, 4: delete',
  `id_warehouse` int(255) DEFAULT NULL,
  PRIMARY KEY (`id_invoice`) USING BTREE,
  INDEX `fk_u`(`id_user`) USING BTREE,
  INDEX `fk_wa`(`id_warehouse`) USING BTREE,
  CONSTRAINT `fk_wa` FOREIGN KEY (`id_warehouse`) REFERENCES `info_warehouse` (`id_warehouse`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of invoice
-- ----------------------------
INSERT INTO `invoice` VALUES ('IV02023001', 1, 23456, 23000, '2019-05-12', 4, 1);
INSERT INTO `invoice` VALUES ('IV02023002', 1, 6666676, 0, '2019-05-12', 0, 1);
INSERT INTO `invoice` VALUES ('IV06090775', 1, 14400, 0, '2019-06-09', 0, 1);
INSERT INTO `invoice` VALUES ('IV06090939', 1, 6000, 0, '2019-06-09', 0, 1);
INSERT INTO `invoice` VALUES ('IV06091410', 1, 4800, 0, '2019-06-09', 0, 1);
INSERT INTO `invoice` VALUES ('IV06091531', 1, 1200, 0, '2019-06-09', 0, 1);

-- ----------------------------
-- Table structure for invoice_detail
-- ----------------------------
DROP TABLE IF EXISTS `invoice_detail`;
CREATE TABLE `invoice_detail`  (
  `id_invoice` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_product` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `quantity` int(11) DEFAULT NULL,
  `price` double(11, 0) DEFAULT NULL,
  `status` int(255) DEFAULT NULL COMMENT 'status of invoice detail: 1: da xuat kho, 0:chua',
  PRIMARY KEY (`id_invoice`, `id_product`) USING BTREE,
  INDEX `fk_pro`(`id_product`) USING BTREE,
  CONSTRAINT `fk_in3` FOREIGN KEY (`id_invoice`) REFERENCES `invoice` (`id_invoice`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pro` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of invoice_detail
-- ----------------------------
INSERT INTO `invoice_detail` VALUES ('IV02023001', 'P1102004', 3, 34567, 0);
INSERT INTO `invoice_detail` VALUES ('IV02023002', 'P1102002', 2, 3333333, 0);
INSERT INTO `invoice_detail` VALUES ('IV02023002', 'P1102003', 2, 123, 0);
INSERT INTO `invoice_detail` VALUES ('IV06090775', 'P1102002', 12, 1200, 0);
INSERT INTO `invoice_detail` VALUES ('IV06090939', 'P1102002', 5, 1200, 0);
INSERT INTO `invoice_detail` VALUES ('IV06091410', 'P1102002', 4, 1200, 0);
INSERT INTO `invoice_detail` VALUES ('IV06091531', 'P1102002', 1, 1200, 0);

-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege`  (
  `id` int(255) NOT NULL,
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `retrieve` int(255) DEFAULT NULL,
  `update` int(255) DEFAULT NULL,
  `delete` int(255) DEFAULT NULL,
  `insert` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_puser`(`id_user`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of privilege
-- ----------------------------
INSERT INTO `privilege` VALUES (1, 3, '/reportException', 1, 0, 0, 0);
INSERT INTO `privilege` VALUES (2, 2, '/createFeedback', 0, 0, 0, 0);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id_product` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_category` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `name_product` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `tag` int(255) DEFAULT NULL,
  `myfile` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id_product`) USING BTREE,
  INDEX `fk_f`(`id_category`) USING BTREE,
  CONSTRAINT `fk_f` FOREIGN KEY (`id_category`) REFERENCES `category_product` (`id_category`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('P0526236', '1', 'Apple watch 1 40mm', 'Anh Dinh', 13000, 0, NULL);
INSERT INTO `product` VALUES ('P0529497', '3', 'Xiaomi 4A', 'Anh Dinh', 0, 0, NULL);
INSERT INTO `product` VALUES ('P0606065', '2', 'Que Phuong', 'Anh Dinh', 3333333, 0, NULL);
INSERT INTO `product` VALUES ('P0606310', '2', 'ddd', 'Anh Dinh', 1300, 0, NULL);
INSERT INTO `product` VALUES ('P0606427', '2', 'Anh Dinh', 'Anh Dinh', 1300, 0, NULL);
INSERT INTO `product` VALUES ('P0606458', '2', 'dinh dinh', 'Anh Dinh', 1300, 0, '');
INSERT INTO `product` VALUES ('P1102002', '1', 'Apple a10', 'dfg', 1200, 10, NULL);
INSERT INTO `product` VALUES ('P1102003', '1', 'SamSung J7', 'sam sung', 5200, 21, NULL);
INSERT INTO `product` VALUES ('P1102004', '1', 'Nokia 6', 'Nokia', 567, 12, NULL);
INSERT INTO `product` VALUES ('P1102005', '2', 'Asus 34i', 'Ad', 0, 0, NULL);
INSERT INTO `product` VALUES ('P1102006', '2', 'Wio', 'Dinh', 0, 0, NULL);
INSERT INTO `product` VALUES ('P1102007', '2', 'Dell i5 560U', 'Dinh', 1, 0, NULL);
INSERT INTO `product` VALUES ('P1102008', '1', 'Apple watch 2 40mm', 'Dinh', 10000, 0, NULL);

-- ----------------------------
-- Table structure for receipt
-- ----------------------------
DROP TABLE IF EXISTS `receipt`;
CREATE TABLE `receipt`  (
  `id` int(11) NOT NULL,
  `id_invoice` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `name_customer` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `total_paid` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_i`(`id_invoice`) USING BTREE,
  CONSTRAINT `fk_i` FOREIGN KEY (`id_invoice`) REFERENCES `invoice` (`id_invoice`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of receipt
-- ----------------------------
INSERT INTO `receipt` VALUES (1, 'IV02023001', 'Tuan Anh', '012345678', 'error', 330000, '2019-06-06');

-- ----------------------------
-- Table structure for receipt_detail
-- ----------------------------
DROP TABLE IF EXISTS `receipt_detail`;
CREATE TABLE `receipt_detail`  (
  `id` int(11) NOT NULL,
  `id_product` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `money_paid` double DEFAULT NULL,
  PRIMARY KEY (`id`, `id_product`) USING BTREE,
  INDEX `fk_P`(`id_product`) USING BTREE,
  CONSTRAINT `fk_P` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id_role`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin');
INSERT INTO `role` VALUES (2, 'manager');
INSERT INTO `role` VALUES (3, 'saler');
INSERT INTO `role` VALUES (4, 'inventory');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL,
  `image` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`) USING BTREE,
  INDEX `fk_role`(`id_role`) USING BTREE,
  CONSTRAINT `fk_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'dinh', '{bcrypt}$2a$10$65Bvz4S.cE.dmg2VjTxTq.PVO/sB5PKQ6bQS8xFdJQBkwR8VA1Bd2', 1, NULL, 1);
INSERT INTO `user` VALUES (3, 'hang', '{bcrypt}$2a$10$Zff3gOOW/XRoPyBLPYzsSOH1Y8rYfdTx.hkX85a5kaaVVPMtgQb5y', 2, NULL, 1);
INSERT INTO `user` VALUES (4, 'loan', '{bcrypt}$2a$10$hff32g5aGolDenrOxMWLxewi5oPMaOT3CVv3QCi/.7mLpB8TgTy1m', 3, NULL, 0);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `id_warehouse` int(11) NOT NULL AUTO_INCREMENT,
  `id_product` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `real_price` int(20) DEFAULT NULL,
  `number_inventory` int(255) DEFAULT NULL,
  `defect_number` int(11) DEFAULT NULL,
  `solded_number` int(20) DEFAULT NULL,
  `date_update` datetime(0) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT 'status out of product: 1-yes',
  PRIMARY KEY (`id_product`, `id_warehouse`) USING BTREE,
  INDEX `id_warehouse`(`id_warehouse`) USING BTREE,
  CONSTRAINT `fk_product1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ware2` FOREIGN KEY (`id_warehouse`) REFERENCES `info_warehouse` (`id_warehouse`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (1, 'P1102002', 231, 0, 0, 100, '2019-05-21 21:38:04', 1);
INSERT INTO `warehouse` VALUES (1, 'P1102003', 234, 0, 0, 100, '2019-04-30 13:13:49', 1);
INSERT INTO `warehouse` VALUES (1, 'P1102004', 4444, 1, 0, 100, '2019-05-22 14:49:36', 1);

-- ----------------------------
-- View structure for testtrend
-- ----------------------------
DROP VIEW IF EXISTS `testtrend`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `testtrend` AS SELECT product.id_category, product.name_product, SUM(invoice_detail.quantity)as soluong, MONTH(invoice.date) AS thang
FROM invoice INNER JOIN invoice_detail  ON invoice.id_invoice = invoice_detail.id_invoice
							INNER JOIN product 				ON invoice_detail.id_product = product.id_product
WHERE YEAR(invoice.date) = 2019 AND product.id_category = 3
GROUP BY product.id_product, MONTH(invoice.date)
ORDER BY  MONTH(invoice.date) ASC, SUM(invoice_detail.quantity) DESC
LIMIT 24 ;

SET FOREIGN_KEY_CHECKS = 1;
