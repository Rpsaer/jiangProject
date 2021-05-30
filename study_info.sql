/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : study_info

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 30/05/2021 17:54:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '年级',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教工号',
  `stu_lesson` int(11) DEFAULT NULL COMMENT '教授课程号',
  `teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (2, '6', 202102, 2, 'Li');
INSERT INTO `grade` VALUES (3, '4', 202104, 4, 'Meng');
INSERT INTO `grade` VALUES (4, '4', 202001, 5, 'Da');
INSERT INTO `grade` VALUES (5, '6', 202002, 3, 'Zhou');
INSERT INTO `grade` VALUES (6, '5', 202101, 1, 'Wang');
INSERT INTO `grade` VALUES (7, '5', 202103, 3, 'Tian');
INSERT INTO `grade` VALUES (8, '5', 202105, 5, 'Sun');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL COMMENT '学号',
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生姓名',
  `stu_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生所在年级',
  `stu_sexy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生性别',
  `stu_lesson` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 2021001, 'xiaoming', '5', '男', 1);
INSERT INTO `student` VALUES (2, 2021002, 'xiaofei', '6', '女', 2);
INSERT INTO `student` VALUES (3, 2021003, 'xiaolv', '6', '男', 3);
INSERT INTO `student` VALUES (4, 2021004, 'xiaohong', '4', '女', 4);
INSERT INTO `student` VALUES (5, 2021005, 'xiaoxiao', '4', '女', 2);
INSERT INTO `student` VALUES (7, 2021007, 'xiaomei', '5', '男', 1);
INSERT INTO `student` VALUES (9, 2021008, 'xiaolan', '6', '男', 1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL COMMENT '教工号',
  `teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '教师名称',
  `stu_lesson` int(11) DEFAULT NULL COMMENT '课程名称',
  `stu_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在年级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 202101, 'Wang', 1, '5');
INSERT INTO `teacher` VALUES (2, 202102, 'Li', 2, '6');
INSERT INTO `teacher` VALUES (3, 202103, 'Tian', 3, '5');
INSERT INTO `teacher` VALUES (4, 202104, 'Meng', 4, '4');
INSERT INTO `teacher` VALUES (5, 202105, 'Sun', 5, '5');
INSERT INTO `teacher` VALUES (6, 202001, 'Da', 5, '4');
INSERT INTO `teacher` VALUES (7, 202002, 'Ze', 3, '6');

SET FOREIGN_KEY_CHECKS = 1;
