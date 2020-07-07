/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : xk

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-06-15 21:31:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c
-- ----------------------------
DROP TABLE IF EXISTS `c`;
CREATE TABLE `c` (
  `kh` varchar(255) NOT NULL,
  `km` varchar(255) NOT NULL,
  `xf` int DEFAULT NULL,
  `xs` int DEFAULT NULL,
  `yxh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kh`),
  KEY `yxh` (`yxh`),
  CONSTRAINT `c_ibfk_1` FOREIGN KEY (`yxh`) REFERENCES `d` (`yxh`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of c
-- ----------------------------
INSERT INTO `c` VALUES ('c1', '大数据', '4', '40', '01');
INSERT INTO `c` VALUES ('c2', '数据库', '4', '40', '01');
INSERT INTO `c` VALUES ('c3', '电路分析', '5', '50', '02');
INSERT INTO `c` VALUES ('c4', '材料分析', '3', '30', '03');
INSERT INTO `c` VALUES ('c5', 'C++', '5', '50', '01');

-- ----------------------------
-- Table structure for d
-- ----------------------------
DROP TABLE IF EXISTS `d`;
CREATE TABLE `d` (
  `yxh` varchar(255) NOT NULL,
  `mc` varchar(255) NOT NULL,
  `dz` varchar(255) DEFAULT NULL,
  `lxdh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`yxh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of d
-- ----------------------------
INSERT INTO `d` VALUES ('01', '计算机学院', '上大东区三号楼', '65347567');
INSERT INTO `d` VALUES ('02', '通讯学院', '上大东区二号楼', '65341234');
INSERT INTO `d` VALUES ('03', '材料学院', '上大东区四号楼', '65347890');

-- ----------------------------
-- Table structure for e
-- ----------------------------
DROP TABLE IF EXISTS `e`;
CREATE TABLE `e` (
  `xh` varchar(255) NOT NULL,
  `xq` varchar(255) NOT NULL,
  `kh` varchar(255) NOT NULL,
  `gh` varchar(255) DEFAULT NULL,
  `pscj` float DEFAULT NULL,
  `kscj` float DEFAULT NULL,
  `zpcj` float DEFAULT NULL,
  PRIMARY KEY (`xh`,`xq`,`kh`),
  KEY `gh` (`gh`),
  KEY `kh` (`kh`),
  CONSTRAINT `e_ibfk_1` FOREIGN KEY (`xh`) REFERENCES `s` (`xh`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `e_ibfk_2` FOREIGN KEY (`gh`) REFERENCES `t` (`gh`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `e_ibfk_3` FOREIGN KEY (`kh`) REFERENCES `c` (`kh`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of e
-- ----------------------------
INSERT INTO `e` VALUES ('s1', '2020-2021秋季', 'c1', 't2', null, null, null);
INSERT INTO `e` VALUES ('s1', '2020-2021秋季', 'c2', 't5', null, null, null);
INSERT INTO `e` VALUES ('s1', '2020-2021秋季', 'c3', 't3', null, null, null);
INSERT INTO `e` VALUES ('s1', '2020-2021秋季', 'c5', 't6', null, null, null);

-- ----------------------------
-- Table structure for o
-- ----------------------------
DROP TABLE IF EXISTS `o`;
CREATE TABLE `o` (
  `xq` varchar(255) NOT NULL,
  `kh` varchar(255) NOT NULL,
  `gh` varchar(255) NOT NULL,
  `sksj` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`xq`,`kh`,`gh`),
  KEY `kh` (`kh`),
  KEY `gh` (`gh`),
  CONSTRAINT `o_ibfk_1` FOREIGN KEY (`kh`) REFERENCES `c` (`kh`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `o_ibfk_2` FOREIGN KEY (`gh`) REFERENCES `t` (`gh`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of o
-- ----------------------------
INSERT INTO `o` VALUES ('2020-2021秋季', 'c1', 't1', '周二7-10');
INSERT INTO `o` VALUES ('2020-2021秋季', 'c1', 't2', '周二7-10');
INSERT INTO `o` VALUES ('2020-2021秋季', 'c2', 't5', '周三1-4');
INSERT INTO `o` VALUES ('2020-2021秋季', 'c3', 't3', '周一1-3周三1-2');
INSERT INTO `o` VALUES ('2020-2021秋季', 'c5', 't6', '周一1-5');

-- ----------------------------
-- Table structure for s
-- ----------------------------
DROP TABLE IF EXISTS `s`;
CREATE TABLE `s` (
  `xh` varchar(255) NOT NULL,
  `xm` varchar(255) NOT NULL,
  `xb` varchar(2) DEFAULT NULL,
  `csrq` date DEFAULT NULL,
  `sjhm` varchar(255) DEFAULT NULL,
  `yxh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`xh`),
  KEY `syxh` (`yxh`),
  CONSTRAINT `syxh` FOREIGN KEY (`yxh`) REFERENCES `d` (`yxh`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of s
-- ----------------------------
INSERT INTO `s` VALUES ('s1', '李明', '男', '1998-03-06', '13613005486', '02');
INSERT INTO `s` VALUES ('s2', '刘晓明', '男', '1997-12-08', '18913457890', '01');
INSERT INTO `s` VALUES ('s3', '张颖', '女', '1999-01-05', '18826490423', '01');
INSERT INTO `s` VALUES ('s4', '刘晶晶', '女', '1996-11-06', '13331934111', '01');
INSERT INTO `s` VALUES ('s5', '刘成刚', '男', '1999-01-07', '18015872567', '01');
INSERT INTO `s` VALUES ('s6', '李二丽', '女', '2000-02-22', '18107620945', '03');
INSERT INTO `s` VALUES ('s7', '张晓峰', '男', '1998-08-16', '13912341078', '03');

-- ----------------------------
-- Table structure for t
-- ----------------------------
DROP TABLE IF EXISTS `t`;
CREATE TABLE `t` (
  `gh` varchar(255) NOT NULL,
  `xm` varchar(255) NOT NULL,
  `xb` varchar(2) DEFAULT NULL,
  `csrq` date DEFAULT NULL,
  `xl` varchar(255) DEFAULT NULL,
  `jbgz` float DEFAULT NULL,
  `yxh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gh`),
  KEY `yxh` (`yxh`),
  CONSTRAINT `yxh` FOREIGN KEY (`yxh`) REFERENCES `d` (`yxh`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t
-- ----------------------------
INSERT INTO `t` VALUES ('t1', '陈笛茂', '男', '1973-03-06', '副教授', '3567', '01');
INSERT INTO `t` VALUES ('t2', '马小红', '女', '1972-12-08', '讲师', '2845', '01');
INSERT INTO `t` VALUES ('t3', '张新颖', '女', '1960-01-05', '教授', '4200', '02');
INSERT INTO `t` VALUES ('t4', '吴宝刚', '男', '1965-08-06', '讲师', '2554', '03');
INSERT INTO `t` VALUES ('t5', '刘德明', '男', '1959-05-23', '教授', '4250', '01');
INSERT INTO `t` VALUES ('t6', '吴月', '女', '1980-02-13', '讲师', '2900', '01');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 's1', 's1', 'student');
INSERT INTO `user` VALUES ('2', 't1', 't1', 'teacher');
INSERT INTO `user` VALUES ('3', 'admin', 'admin', 'admin');
INSERT INTO `user` VALUES ('4', 's2', 's2', 'student');
