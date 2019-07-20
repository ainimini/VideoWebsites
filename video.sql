/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : video

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-03-26 19:54:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for video_info
-- ----------------------------
DROP TABLE IF EXISTS `video_info`;
CREATE TABLE `video_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键(自增长)',
  `video_name` varchar(150) DEFAULT NULL COMMENT '视频名称',
  `video_url` varchar(100) DEFAULT NULL COMMENT '封面图片',
  `video_html` varchar(500) DEFAULT NULL COMMENT '视频html执行元素',
  `video_type_id` int(11) DEFAULT NULL COMMENT '关联typeID',
  `video_del` int(11) DEFAULT '0' COMMENT '是否显示 0显示 1隐藏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video_info
-- ----------------------------
INSERT INTO `video_info` VALUES ('1', '1', '1.png', '1', '1', '1');
INSERT INTO `video_info` VALUES ('2', '2', '2.jpg', '2', '2', '2');
INSERT INTO `video_info` VALUES ('3', '3', '3.png', '3', '3', '3');
INSERT INTO `video_info` VALUES ('4', '123', '1552011939365', '123', '1', null);
INSERT INTO `video_info` VALUES ('5', '123', '1552012198723', '123', '2', null);
INSERT INTO `video_info` VALUES ('6', '123', '1552012429085', '123', '3', null);

-- ----------------------------
-- Table structure for video_type
-- ----------------------------
DROP TABLE IF EXISTS `video_type`;
CREATE TABLE `video_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键(自增长)',
  `type_name` varchar(30) DEFAULT NULL COMMENT '视频类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video_type
-- ----------------------------
INSERT INTO `video_type` VALUES ('1', '请问');
INSERT INTO `video_type` VALUES ('2', '的');
INSERT INTO `video_type` VALUES ('3', '4为');
