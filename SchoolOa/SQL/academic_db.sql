CREAT DATABASE `academic_cb`;
USE `academic_cb`;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123321');
INSERT INTO `admin` VALUES (2, 'yan', 'yan123');
INSERT INTO `admin` VALUES (3, 'jane', 'password1');
INSERT INTO `admin` VALUES (4, 'john', 'password2');
INSERT INTO `admin` VALUES (5, 'alice', 'password3');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (1, '工程学院');
INSERT INTO `college` VALUES (2, '文学院');
INSERT INTO `college` VALUES (3, '理学院');
INSERT INTO `college` VALUES (4, '管理学院');
INSERT INTO `college` VALUES (5, '艺术学院');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '数据结构', '工程学院');
INSERT INTO `course` VALUES (2, '机械设计', '工程学院');
INSERT INTO `course` VALUES (3, '现代文学', '文学院');
INSERT INTO `course` VALUES (4, '量子力学', '理学院');
INSERT INTO `course` VALUES (5, '管理学原理', '管理学院');
INSERT INTO `course` VALUES (6, '油画技巧', '艺术学院');
INSERT INTO `course` VALUES (7, '线性代数', '理学院');
INSERT INTO `course` VALUES (8, '市场营销', '管理学院');
INSERT INTO `course` VALUES (9, '编程基础', '工程学院');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, '计算机科学', '工程学院');
INSERT INTO `major` VALUES (2, '机械工程', '工程学院');
INSERT INTO `major` VALUES (3, '文学', '文学院');
INSERT INTO `major` VALUES (4, '物理', '理学院');
INSERT INTO `major` VALUES (5, '市场营销', '管理学院');
INSERT INTO `major` VALUES (6, '绘画', '艺术学院');
INSERT INTO `major` VALUES (7, '电子工程', '工程学院');
INSERT INTO `major` VALUES (8, '数学', '理学院');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三', '计算机科学', '工程学院');
INSERT INTO `student` VALUES (2, '李四', '机械工程', '工程学院');
INSERT INTO `student` VALUES (3, '王五', '文学', '文学院');
INSERT INTO `student` VALUES (4, '赵六', '物理', '理学院');
INSERT INTO `student` VALUES (5, '小明', '市场营销', '管理学院');
INSERT INTO `student` VALUES (6, '小红', '绘画', '艺术学院');
INSERT INTO `student` VALUES (7, '小强', '电子工程', '工程学院');
INSERT INTO `student` VALUES (8, '小华', '数学', '理学院');
INSERT INTO `student` VALUES (9, '小东', '文学', '文学院');
INSERT INTO `student` VALUES (10, '小兰', '计算机科学', '工程学院');

SET FOREIGN_KEY_CHECKS = 1;
