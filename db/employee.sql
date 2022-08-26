/*
 Navicat MySQL Data Transfer

 Source Server         : springboot
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : reggie

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 26/08/2022 21:44:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '姓名',
  `username` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '手机号',
  `sex` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '性别',
  `id_number` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '身份证号',
  `status` int NOT NULL DEFAULT 1 COMMENT '状态 0:禁用，1:正常',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` bigint NOT NULL COMMENT '创建人',
  `update_user` bigint NOT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_username`(`username` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '员工信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '管理员', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '13812312312', '1', '110101199001010047', 1, '2021-05-06 17:20:07', '2021-05-10 02:24:09', 1, 1);
INSERT INTO `employee` VALUES (1557370858426126337, 'zs', 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', '17812321231', '1', '122112112211221122', 1, '2022-08-10 22:18:42', '2022-08-10 22:18:42', 1, 1);
INSERT INTO `employee` VALUES (1559165879034937345, '李四', 'lisi', 'e10adc3949ba59abbe56e057f20f883e', '17288628234', '1', '172398651829442143', 1, '2022-08-15 21:11:28', '2022-08-15 21:11:28', 1, 1);
INSERT INTO `employee` VALUES (1559166660974837762, '王五', 'wangwu', 'e10adc3949ba59abbe56e057f20f883e', '15538303927', '0', '173937282946184642', 1, '2022-08-16 20:22:03', '2022-08-16 20:22:03', 1, 2);
INSERT INTO `employee` VALUES (1559521808116989953, '老刘', 'laoliu', 'e10adc3949ba59abbe56e057f20f883e', '13455467834', '0', '123456789876543222', 1, '2022-08-16 20:45:48', '2022-08-16 20:46:33', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
