/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : ssm4

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-06-17 17:32:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for r_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `r_role_resource`;
CREATE TABLE `r_role_resource` (
  `role_id` bigint(20) DEFAULT NULL,
  `resource_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_role_resource
-- ----------------------------
INSERT INTO `r_role_resource` VALUES ('1', '1');
INSERT INTO `r_role_resource` VALUES ('1', '2');
INSERT INTO `r_role_resource` VALUES ('1', '5');
INSERT INTO `r_role_resource` VALUES ('1', '6');
INSERT INTO `r_role_resource` VALUES ('1', '7');
INSERT INTO `r_role_resource` VALUES ('1', '8');
INSERT INTO `r_role_resource` VALUES ('1', '3');
INSERT INTO `r_role_resource` VALUES ('1', '9');
INSERT INTO `r_role_resource` VALUES ('1', '10');
INSERT INTO `r_role_resource` VALUES ('1', '11');
INSERT INTO `r_role_resource` VALUES ('1', '12');
INSERT INTO `r_role_resource` VALUES ('1', '4');
INSERT INTO `r_role_resource` VALUES ('1', '13');
INSERT INTO `r_role_resource` VALUES ('1', '14');
INSERT INTO `r_role_resource` VALUES ('1', '15');
INSERT INTO `r_role_resource` VALUES ('1', '16');
INSERT INTO `r_role_resource` VALUES ('2', '2');
INSERT INTO `r_role_resource` VALUES ('2', '5');
INSERT INTO `r_role_resource` VALUES ('2', '6');
INSERT INTO `r_role_resource` VALUES ('2', '7');
INSERT INTO `r_role_resource` VALUES ('2', '8');
INSERT INTO `r_role_resource` VALUES ('2', '3');
INSERT INTO `r_role_resource` VALUES ('2', '9');
INSERT INTO `r_role_resource` VALUES ('2', '10');
INSERT INTO `r_role_resource` VALUES ('2', '11');
INSERT INTO `r_role_resource` VALUES ('2', '12');
INSERT INTO `r_role_resource` VALUES ('2', '4');
INSERT INTO `r_role_resource` VALUES ('2', '13');
INSERT INTO `r_role_resource` VALUES ('2', '14');
INSERT INTO `r_role_resource` VALUES ('2', '15');
INSERT INTO `r_role_resource` VALUES ('2', '16');
INSERT INTO `r_role_resource` VALUES ('2', '1');

-- ----------------------------
-- Table structure for r_user_role
-- ----------------------------
DROP TABLE IF EXISTS `r_user_role`;
CREATE TABLE `r_user_role` (
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_user_role
-- ----------------------------
INSERT INTO `r_user_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_sys_org_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  `weight` int(11) DEFAULT NULL,
  `icon` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_sys_resource_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '系统管理', 'menu', null, '0', null, '1', '1', 'fa fa-gear');
INSERT INTO `sys_resource` VALUES ('2', '用户管理', 'menu', '/user/list.t', '1', 'user:list', '1', '11', 'fa fa-users');
INSERT INTO `sys_resource` VALUES ('3', '角色管理', 'menu', '/role/list.t', '1', 'role:list', '1', '12', 'fa fa-lock');
INSERT INTO `sys_resource` VALUES ('4', '资源管理', 'menu', '/resource/list.t', '1', 'resource:list', '1', '13', 'fa fa-reorder');
INSERT INTO `sys_resource` VALUES ('5', '用户新增', 'btn', '/user/add.t', '2', 'user:add', '1', null, '');
INSERT INTO `sys_resource` VALUES ('6', '用户修改', 'btn', '/user/edit.t', '2', 'user:edit', '1', null, '');
INSERT INTO `sys_resource` VALUES ('7', '用户删除', 'btn', '/user/delete.t', '2', 'user:delete', '1', null, '');
INSERT INTO `sys_resource` VALUES ('8', '用户查看', 'btn', '/user/view.t', '2', 'user:view', '1', null, '');
INSERT INTO `sys_resource` VALUES ('9', '角色新增', 'btn', '/role/add.t', '3', 'role:add', '1', null, '');
INSERT INTO `sys_resource` VALUES ('10', '角色修改', 'btn', '/role/edit.t', '3', 'role:edit', '1', null, '');
INSERT INTO `sys_resource` VALUES ('11', '角色删除', 'btn', '/role/delete.t', '3', 'role:delete', '1', null, '');
INSERT INTO `sys_resource` VALUES ('12', '角色查看', 'btn', '/role/view.t', '3', 'user:view', '1', null, '');
INSERT INTO `sys_resource` VALUES ('13', '资源新增', 'btn', '/resource/add.t', '4', 'resource:add', '1', null, '');
INSERT INTO `sys_resource` VALUES ('14', '资源修改', 'btn', '/resource/edit.t', '4', 'resource:edit', '1', null, '');
INSERT INTO `sys_resource` VALUES ('15', '资源删除', 'btn', '/resource/delete.t', '4', 'resource:delete', '1', null, '');
INSERT INTO `sys_resource` VALUES ('16', '资源查看', 'btn', '/resource/view.t', '4', 'resource:view', '1', null, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(25) DEFAULT NULL,
  `role_cn` varchar(64) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员', '主要负责系统管理', '1');
INSERT INTO `sys_role` VALUES ('2', 'tester', '测试员', '用来测试系统功能模块', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `real_name` varchar(64) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  `email` varchar(100) DEFAULT NULL,
  `phone_no` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_user_username` (`user_name`),
  KEY `idx_sys_user_org_id` (`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, 'admin', '超管哥', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '0', 'supermanager@163.com', '15802703786');
