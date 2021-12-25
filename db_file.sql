/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : db_file

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 24/12/2021 21:07:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件名',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件类型',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '存储位置',
  `size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件大小（字节）',
  `time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('5c531f63-5d23-440f-925e-a0c1333c8129', 'test.txt', '.txt', 'upload\\20211224\\5c531f63-5d23-440f-925e-a0c1333c8129', '14B', '2021-12-24 17:26:52');
INSERT INTO `file` VALUES ('b7307fab-1c98-48d0-a81c-b90d37c3912b', 'test.txt', '.txt', 'upload\\20211224\\b7307fab-1c98-48d0-a81c-b90d37c3912b', '14B', '2021-12-24 20:59:58');
INSERT INTO `file` VALUES ('fdf8b656-46b8-4e1e-9ab5-73914f9912e2', 'test.txt', '.txt', 'upload\\20211224\\fdf8b656-46b8-4e1e-9ab5-73914f9912e2', '14B', '2021-12-24 13:14:37');

SET FOREIGN_KEY_CHECKS = 1;
