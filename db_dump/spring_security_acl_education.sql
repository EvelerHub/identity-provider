/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : spring_security_acl_education

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-18 21:40:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for acl_class
-- ----------------------------
DROP TABLE IF EXISTS `acl_class`;
CREATE TABLE `acl_class` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `class` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_acl_class` (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for acl_entry
-- ----------------------------
DROP TABLE IF EXISTS `acl_entry`;
CREATE TABLE `acl_entry` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ace_order` int(11) NOT NULL,
  `audit_failure` tinyint(1) NOT NULL,
  `audit_success` tinyint(1) NOT NULL,
  `granting` tinyint(1) NOT NULL,
  `mask` int(10) unsigned NOT NULL,
  `acl_object_identity` bigint(20) unsigned NOT NULL,
  `sid` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_acl_entry` (`acl_object_identity`,`ace_order`),
  KEY `fk_acl_entry_acl` (`sid`),
  CONSTRAINT `fk_acl_entry_acl` FOREIGN KEY (`sid`) REFERENCES `acl_sid` (`id`),
  CONSTRAINT `fk_acl_entry_object` FOREIGN KEY (`acl_object_identity`) REFERENCES `acl_object_identity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for acl_object_identity
-- ----------------------------
DROP TABLE IF EXISTS `acl_object_identity`;
CREATE TABLE `acl_object_identity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `entries_inheriting` tinyint(1) NOT NULL,
  `object_id_identity` bigint(20) NOT NULL,
  `object_id_class` bigint(20) unsigned NOT NULL,
  `owner_sid` bigint(20) unsigned DEFAULT NULL,
  `parent_object` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_acl_object_identity` (`object_id_class`,`object_id_identity`),
  KEY `fk_acl_object_identity_owner` (`owner_sid`),
  KEY `fk_acl_object_identity_parent` (`parent_object`),
  CONSTRAINT `fk_acl_object_identity_class` FOREIGN KEY (`object_id_class`) REFERENCES `acl_class` (`id`),
  CONSTRAINT `fk_acl_object_identity_owner` FOREIGN KEY (`owner_sid`) REFERENCES `acl_sid` (`id`),
  CONSTRAINT `fk_acl_object_identity_parent` FOREIGN KEY (`parent_object`) REFERENCES `acl_object_identity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for acl_sid
-- ----------------------------
DROP TABLE IF EXISTS `acl_sid`;
CREATE TABLE `acl_sid` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `principal` tinyint(1) NOT NULL,
  `sid` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_acl_sid` (`sid`,`principal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for grid
-- ----------------------------
DROP TABLE IF EXISTS `grid`;
CREATE TABLE `grid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `grid_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgnlqboe3xl07n5qx2o0kfya0u` (`grid_id`),
  CONSTRAINT `FKgnlqboe3xl07n5qx2o0kfya0u` FOREIGN KEY (`grid_id`) REFERENCES `grid` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
