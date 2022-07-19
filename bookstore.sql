/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 80027
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 80027
File Encoding         : 65001

Date: 2022-06-13 20:55:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_admin
-- ----------------------------
DROP TABLE IF EXISTS `tbl_admin`;
CREATE TABLE `tbl_admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员账户',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `balance` double DEFAULT NULL COMMENT '账户余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tbl_admin
-- ----------------------------
INSERT INTO `tbl_admin` VALUES ('1', 'admin', 'admin', '1000');

-- ----------------------------
-- Table structure for tbl_book
-- ----------------------------
DROP TABLE IF EXISTS `tbl_book`;
CREATE TABLE `tbl_book` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `book_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '书名',
  `author` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作者',
  `isbn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'isbn',
  `publish` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出版社',
  `type_id` int DEFAULT NULL COMMENT '图书类型id',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图书介绍',
  `price` double DEFAULT NULL COMMENT '价格',
  `amount` int DEFAULT NULL COMMENT '图书数量',
  `shelf_time` datetime DEFAULT NULL COMMENT '上架时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tbl_book
-- ----------------------------
INSERT INTO `tbl_book` VALUES ('1', '西游记', '吴承恩', '1001', '中国人民出版社', '1', '唐僧师徒四人西天取经', '45', '4', '2022-04-05 15:28:15', '2022-06-06 16:58:14');
INSERT INTO `tbl_book` VALUES ('2', '三国演义', '罗贯中', '1002', '清华大学版社', '1', '东汉末年群雄割据发生的故事', '50', '2', '2022-04-05 15:29:11', '2022-06-06 13:18:27');
INSERT INTO `tbl_book` VALUES ('3', '红楼梦', '曹雪芹', '1003', '清华大学出版社', '1', '宝玉与众多男女之间的故事', '43', '2', '2022-04-05 15:30:15', '2022-06-06 16:45:50');
INSERT INTO `tbl_book` VALUES ('6', '大变局下的中国法治', '李卫东', '1006', '北京大学出版社', '4', '十大经典法学著作之一', '49', '3', '2022-04-05 15:32:54', '2022-05-18 15:44:13');
INSERT INTO `tbl_book` VALUES ('7', '水浒传', '施耐庵', '1007', '中国人民出版社', '1', '一百零八将的故事', '42', '2', '2022-04-05 18:43:24', '2022-04-28 20:49:48');
INSERT INTO `tbl_book` VALUES ('8', '大话数据结构', '程杰', '1007', '中国人民出版社', '3', '让数据结构不再无聊', '45', '2', '2022-04-06 17:01:18', '2022-06-06 15:16:59');
INSERT INTO `tbl_book` VALUES ('9', '史记', '司马迁', '1008', '中国人民出版社', '2', '记载了上至上古传说中的黄帝时代，下至汉武帝太初四年间共3000多年的历史', '50', '4', '2022-04-12 19:32:53', '2022-04-22 16:53:05');
INSERT INTO `tbl_book` VALUES ('10', '概率论与数理统计', '王信峰', '1010', '清华大学出版社', '3', '高等院校理工类、经管类的重要课程之一', '30', '2', '2022-04-14 16:33:56', '2022-06-06 16:46:22');
INSERT INTO `tbl_book` VALUES ('11', '计算机网络', '谢希仁', '1011', '电子工业出版社', '3', '该教材可供电气信息类和计算机类专业的大学本科生和研究生使用，也可供从事计算机网络工作的工程技术人员使用', '45', '3', '2022-04-18 20:42:22', '2022-06-06 16:58:38');
INSERT INTO `tbl_book` VALUES ('12', '数据库系统概论', '王珊', '1012', '高等教育出版社', '3', '可以作为高等学校计算机类专业、信息管理与信息系统等相关专业数据库课程的教材，也可供从事数据库系统研究、开发和应用的研究人员和工程技术人员参考', '42.5', '3', '2022-04-18 20:52:10', '2022-05-20 20:00:31');
INSERT INTO `tbl_book` VALUES ('13', '算法设计与分析基础', '莱维汀', '1013', '清华大学出版社', '3', '作者基于丰富的教学经验，开发了一套全新的算法分类方法。该分类法站在通用问题求解策略的高度，对现有大多数算法准确分类，从而引领读者沿着一条清晰、一致、连贯的思路来探索算法设计与分析这一迷人领域', '49', '4', '2022-04-18 20:59:04', '2022-06-06 15:57:47');
INSERT INTO `tbl_book` VALUES ('14', '理想国', '柏拉图', '1014', '江苏译林出版社', '13', '主要论述了柏拉图心中理想国的构建、治理和正义，主题是关于国家的管理', '30', '2', '2022-04-27 14:49:26', '2022-05-19 14:50:03');
INSERT INTO `tbl_book` VALUES ('15', '作为意志和表象的世界', '叔本华', '1015', '商务印书馆', '13', '叔本华思想发展的顶点。叔本华思想主要受柏拉图、康德和印度佛学的影响。书中叔本华认为“理性”不过是意志的派生物，意志具有决定性。', '48', '5', '2022-04-27 14:53:55', '2022-06-06 16:47:49');
INSERT INTO `tbl_book` VALUES ('16', '伤寒杂病论', '张仲景', '1016', '中医古籍出版社', '16', '中国传统医学著作之一，是一部论述外感病与内科杂病为主要内容的医学典籍', '35', '3', '2022-04-27 14:57:49', '2022-05-20 16:02:37');
INSERT INTO `tbl_book` VALUES ('17', '黄帝内经珍藏版', '赵文博', '1017', '辽海出版社', '16', '奠定了人体生理、病理、诊断以及治疗的认识基础，是中国影响极大的一部医学著作，被称为医之始祖', '55', '3', '2022-04-27 15:03:26', '2022-06-06 15:57:54');
INSERT INTO `tbl_book` VALUES ('18', '齐民要术', '贾思勰', '1018', '中华书局', '17', '系统地总结了六世纪以前黄河中下游地区劳动人民农牧业生产经验、食品的加工与贮藏、野生植物的利用，以及治荒的方法，详细介绍了季节、气候，和不同土壤与不同农作物的关系，被誉为“中国古代农业百科全书”', '45', '2', '2022-04-27 15:05:49', '2022-05-20 20:39:05');
INSERT INTO `tbl_book` VALUES ('19', '农政全书', '徐光启', '1019', '上海古籍出版社', '17', '基本上囊括了中国明代农业生产和人民生活的各个方面，而其中又贯穿着一个基本思想，即徐光启的治国治民的“农政”思想', '66', '3', '2022-04-27 15:07:32', '2022-05-20 20:39:59');
INSERT INTO `tbl_book` VALUES ('20', '资治通鉴', '司马光', '1020', '光明日报出版社', '2', '由北宋史学家司马光主编的一部多卷本编年体史书，共294卷，历时十九年完成。主要以时间为纲，事件为目，从周威烈王二十三年（公元前403年）写起，到五代后周世宗显德六年（公元959年）征淮南停笔，涵盖十六朝1362年的历史。', '55', '2', '2022-04-27 15:09:04', '2022-04-27 16:04:38');
INSERT INTO `tbl_book` VALUES ('21', '法治的细节', '罗翔', '1021', ' 云南人民出版社', '4', '中国政法大学法学教授罗翔全新的法学随笔，面向大众读者，从热点案件解读、法学理念科普、经典名著讲解等6大板块，普及法律常识与法治观念', '49', '2', '2022-04-27 15:11:10', '2022-05-20 18:38:28');
INSERT INTO `tbl_book` VALUES ('22', '刑法学讲义', '罗翔', '1022', '云南人民出版社', '4', '全书通过分析真实刑法案件、张三的犯罪行为，激发读者用独立、睿智的法学思维去看待生活，提高法律感知能力。', '69', '2', '2022-04-27 15:11:55', '2022-05-20 16:02:15');
INSERT INTO `tbl_book` VALUES ('23', '资本论', '马克思', '1023', '中华工商联合出版社', '5', '马克思在《资本论》中以唯物史观的基本思想作为指导，通过深刻分析资本主义生产方式，揭示了资本主义社会发展的规律，并使唯物史观得到科学验证和进一步的丰富发展。《资本论》跨越了经济、政治、哲学等多个领域，是全世界无产阶级运动的思想指导。', '39', '2', '2022-04-27 15:13:45', '2022-04-27 16:05:18');
INSERT INTO `tbl_book` VALUES ('24', '经济学原理', 'N.格里高利·曼昆', '1024', '北京大学出版社', '5', '主要介绍了经济学十大原理，这十大原理贯穿于书中始末，并运用它们对贸易，供求关系，销量与生产，企业行为和行业组织，劳动力市场以及宏观经济学理论进行阐述。该书分微观经济学和宏观经济学上、下两分册，上册为《微观经济学分册》，下册为《宏观经济学分册》，遵循了从微观到宏观的叙述线路', '69', '2', '2022-04-27 15:15:43', '2022-05-20 20:38:46');
INSERT INTO `tbl_book` VALUES ('25', '卓有成效的管理者', '[美] 彼得·德鲁克', '1025', '机械工业出版社', '12', '每一位知识工作者其实都是管理者，而且卓有成效是每个管理者必须做到的事。书中认为所有负责行动和决策而且能够提高机构工作效率的人，都应该像管理者一样工作和思考。', '46', '1', '2022-04-27 15:17:43', '2022-05-20 18:38:54');
INSERT INTO `tbl_book` VALUES ('26', '管理学', '斯蒂芬·罗宾斯', '1026', '中国人民大学出版社', '12', '全书以管理过程为框架，按照计划、组织、领导和控制四种基本管理职能，对管理的各个方面进行了详尽的阐述。', '48', '1', '2022-04-27 15:19:06', '2022-05-20 18:38:07');
INSERT INTO `tbl_book` VALUES ('27', '艺术概论', '黄柏青', '1027', '人民邮电出版社', '14', '本书结构合理，重点突出，文例新颖，叙述清晰，文笔流畅，既可作为艺术院校各专业和普通高校各艺术专业的教材，也可作为普通高等学校非艺术专业开设公共艺术课程的教材，还可作为广大社会青年的自学用书。', '38', '2', '2022-04-27 15:21:12', '2022-05-20 16:01:52');
INSERT INTO `tbl_book` VALUES ('28', '教育学', '王道俊', '1028', '人民教育出版社', '15', '该书系受教育部委托编写、全国通用的高校教育学公共课教材，而且是全国的一本持续畅销近40年的教育学教材', '30', '2', '2022-04-27 15:34:12', '2022-04-27 16:06:40');
INSERT INTO `tbl_book` VALUES ('29', '教育学原理', '柳海民', '1029', ' 高等教育出版社', '15', '全书由教育学概述、教育及其产生与发展、教育与社会发展、教育与人的发展、教育目的与培养目标、教育制度、课程、教学、德育、教师与学生等内容构成。', '40', '2', '2022-04-27 15:35:24', '2022-05-20 20:37:54');

-- ----------------------------
-- Table structure for tbl_book_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_book_type`;
CREATE TABLE `tbl_book_type` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `book_type` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图书类型',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图书类型描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tbl_book_type
-- ----------------------------
INSERT INTO `tbl_book_type` VALUES ('1', '文学类', '陶冶情操', '2022-05-18 16:15:03', '2022-06-06 13:49:42');
INSERT INTO `tbl_book_type` VALUES ('2', '历史类', '了解历史文化，铭记历史', '2022-05-18 16:15:06', '2022-05-18 16:15:43');
INSERT INTO `tbl_book_type` VALUES ('3', '工学类', '学习工学知识，为国家基建建设助力', '2022-05-18 16:15:09', '2022-05-18 16:15:46');
INSERT INTO `tbl_book_type` VALUES ('4', '法学类', '学习法律知识，用法律武装自己', '2022-05-18 16:15:12', '2022-05-18 16:15:48');
INSERT INTO `tbl_book_type` VALUES ('5', '经济学类', '经济发展的基础', '2022-05-18 16:15:17', '2022-05-18 16:15:51');
INSERT INTO `tbl_book_type` VALUES ('12', '管理学类', '研究管理规律、探讨管理方法、建构管理模式、取得最大管理效益的学科', '2022-05-18 16:15:20', '2022-05-18 16:15:54');
INSERT INTO `tbl_book_type` VALUES ('13', '哲学类', '对世界基本和普遍的问题研究的学科，是关于世界观的理论体系', '2022-05-18 16:15:23', '2022-05-18 16:15:58');
INSERT INTO `tbl_book_type` VALUES ('14', '艺术类', '研究艺术整体的科学', '2022-05-18 16:15:26', '2022-05-18 16:16:00');
INSERT INTO `tbl_book_type` VALUES ('15', '教育学类', '通过对教育现象、教育问题的研究来揭示教育的一般规律', '2022-05-18 16:15:30', '2022-05-18 16:16:03');
INSERT INTO `tbl_book_type` VALUES ('16', '医学类', '处理生命的各种疾病或病变的一种学科，促进病患恢复健康的一种专业', '2022-05-18 16:15:33', '2022-05-18 16:16:06');
INSERT INTO `tbl_book_type` VALUES ('17', '农学类', '研究农业发展的自然规律和经济规律的科学', '2022-05-18 16:15:36', '2022-05-18 16:16:09');

-- ----------------------------
-- Table structure for tbl_donate_record
-- ----------------------------
DROP TABLE IF EXISTS `tbl_donate_record`;
CREATE TABLE `tbl_donate_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `book_id` int DEFAULT NULL COMMENT '图书id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `donate_amount` int DEFAULT NULL COMMENT '捐赠数量',
  `repay_point` int DEFAULT NULL COMMENT '用来感谢捐赠的借阅点',
  `donate_time` datetime DEFAULT NULL COMMENT '捐赠时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tbl_donate_record
-- ----------------------------
INSERT INTO `tbl_donate_record` VALUES ('2', '1', '2', '1', '10', '2022-03-23 17:44:50');
INSERT INTO `tbl_donate_record` VALUES ('3', '1', '1', '1', '10', '2022-04-20 20:21:19');
INSERT INTO `tbl_donate_record` VALUES ('4', '13', '1', '1', '10', '2022-04-22 16:52:28');
INSERT INTO `tbl_donate_record` VALUES ('5', '12', '2', '1', '10', '2022-04-22 16:52:39');
INSERT INTO `tbl_donate_record` VALUES ('6', '10', '3', '1', '10', '2022-04-22 16:52:52');
INSERT INTO `tbl_donate_record` VALUES ('8', '7', '4', '1', '11', '2022-04-27 17:08:20');
INSERT INTO `tbl_donate_record` VALUES ('9', '6', '1', '1', '8', '2022-04-27 17:10:13');
INSERT INTO `tbl_donate_record` VALUES ('10', '7', '1', '1', '10', '2022-04-28 20:49:48');
INSERT INTO `tbl_donate_record` VALUES ('11', '16', '5', '1', '5', '2022-05-20 15:59:01');
INSERT INTO `tbl_donate_record` VALUES ('12', '15', '3', '1', '4', '2022-05-20 15:59:39');
INSERT INTO `tbl_donate_record` VALUES ('13', '26', '4', '1', '4', '2022-05-20 16:00:09');
INSERT INTO `tbl_donate_record` VALUES ('14', '21', '9', '1', '5', '2022-05-20 16:01:34');
INSERT INTO `tbl_donate_record` VALUES ('15', '27', '10', '1', '5', '2022-05-20 16:01:52');
INSERT INTO `tbl_donate_record` VALUES ('16', '22', '11', '1', '5', '2022-05-20 16:02:16');
INSERT INTO `tbl_donate_record` VALUES ('17', '16', '12', '1', '5', '2022-05-20 16:02:37');
INSERT INTO `tbl_donate_record` VALUES ('18', '8', '7', '1', '2', '2022-05-20 16:03:40');
INSERT INTO `tbl_donate_record` VALUES ('19', '13', '7', '1', '5', '2022-05-20 16:05:12');
INSERT INTO `tbl_donate_record` VALUES ('20', '17', '8', '1', '5', '2022-05-20 16:05:54');
INSERT INTO `tbl_donate_record` VALUES ('21', '1', '7', '1', '5', '2022-05-20 17:29:30');
INSERT INTO `tbl_donate_record` VALUES ('22', '29', '8', '1', '5', '2022-05-20 20:37:55');
INSERT INTO `tbl_donate_record` VALUES ('23', '24', '9', '1', '5', '2022-05-20 20:38:46');
INSERT INTO `tbl_donate_record` VALUES ('24', '18', '10', '1', '5', '2022-05-20 20:39:05');
INSERT INTO `tbl_donate_record` VALUES ('25', '19', '11', '2', '15', '2022-05-20 20:40:00');
INSERT INTO `tbl_donate_record` VALUES ('26', '13', '7', '1', '5', '2022-05-21 21:37:23');
INSERT INTO `tbl_donate_record` VALUES ('27', '13', '1', '1', '15', '2022-06-06 12:46:00');
INSERT INTO `tbl_donate_record` VALUES ('28', '15', '5', '1', '15', '2022-06-06 12:47:35');
INSERT INTO `tbl_donate_record` VALUES ('29', '13', '7', '1', '10', '2022-06-06 12:48:00');
INSERT INTO `tbl_donate_record` VALUES ('30', '15', '7', '1', '10', '2022-06-06 12:49:17');
INSERT INTO `tbl_donate_record` VALUES ('31', '3', '11', '1', '20', '2022-06-06 13:51:53');
INSERT INTO `tbl_donate_record` VALUES ('32', '1', '3', '2', '30', '2022-06-06 15:17:25');
INSERT INTO `tbl_donate_record` VALUES ('33', '13', '9', '1', '20', '2022-06-06 15:48:52');
INSERT INTO `tbl_donate_record` VALUES ('34', '15', '3', '1', '20', '2022-06-06 16:47:49');
INSERT INTO `tbl_donate_record` VALUES ('35', '11', '9', '1', '20', '2022-06-06 16:58:38');

-- ----------------------------
-- Table structure for tbl_lend_record
-- ----------------------------
DROP TABLE IF EXISTS `tbl_lend_record`;
CREATE TABLE `tbl_lend_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `book_id` int DEFAULT NULL COMMENT '图书id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `back_type` int DEFAULT NULL COMMENT '还书类型（0：在借中、1：正常还书、2：延迟还书、3：破损还书、4：图书丢失）',
  `lend_time` datetime DEFAULT NULL COMMENT '借阅时间',
  `back_time` datetime DEFAULT NULL COMMENT '还书时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tbl_lend_record
-- ----------------------------
INSERT INTO `tbl_lend_record` VALUES ('1', '1', '1', '1', '2022-04-19 15:03:23', '2022-04-19 16:13:01');
INSERT INTO `tbl_lend_record` VALUES ('2', '2', '1', '2', '2022-04-19 15:04:29', '2022-04-19 16:13:03');
INSERT INTO `tbl_lend_record` VALUES ('3', '3', '2', '3', '2022-04-19 15:04:48', '2022-04-19 16:13:08');
INSERT INTO `tbl_lend_record` VALUES ('6', '13', '1', '2', '2022-04-19 21:15:19', '2022-04-19 22:21:04');
INSERT INTO `tbl_lend_record` VALUES ('7', '9', '2', '2', '2022-04-19 21:16:58', '2022-04-20 12:51:10');
INSERT INTO `tbl_lend_record` VALUES ('10', '1', '2', '1', '2022-04-20 15:18:12', '2022-04-20 15:18:32');
INSERT INTO `tbl_lend_record` VALUES ('12', '3', '1', '2', '2022-04-21 17:06:03', '2022-05-08 17:07:22');
INSERT INTO `tbl_lend_record` VALUES ('13', '1', '2', '1', '2022-04-27 16:57:11', '2022-04-27 16:57:58');
INSERT INTO `tbl_lend_record` VALUES ('14', '16', '7', '1', '2022-04-27 16:58:52', '2022-05-08 17:11:14');
INSERT INTO `tbl_lend_record` VALUES ('15', '17', '5', '1', '2022-04-27 16:59:51', '2022-04-27 17:32:30');
INSERT INTO `tbl_lend_record` VALUES ('16', '12', '4', '1', '2022-04-27 17:28:43', '2022-05-07 22:57:07');
INSERT INTO `tbl_lend_record` VALUES ('17', '13', '7', '4', '2022-04-27 17:32:11', '2022-05-07 22:57:14');
INSERT INTO `tbl_lend_record` VALUES ('18', '12', '1', '0', '2022-05-12 11:12:02', '2022-05-20 20:56:29');
INSERT INTO `tbl_lend_record` VALUES ('19', '1', '7', '0', '2022-05-18 15:42:11', null);
INSERT INTO `tbl_lend_record` VALUES ('20', '6', '8', '1', '2022-05-18 15:42:41', '2022-05-18 15:44:13');
INSERT INTO `tbl_lend_record` VALUES ('21', '1', '3', '0', '2022-05-20 18:34:59', null);
INSERT INTO `tbl_lend_record` VALUES ('22', '13', '4', '1', '2022-05-20 18:35:27', '2022-06-06 15:57:43');
INSERT INTO `tbl_lend_record` VALUES ('23', '13', '9', '1', '2022-05-20 18:36:19', '2022-06-06 15:57:47');
INSERT INTO `tbl_lend_record` VALUES ('24', '15', '8', '1', '2022-05-20 18:37:03', '2022-06-06 15:57:51');
INSERT INTO `tbl_lend_record` VALUES ('25', '17', '9', '1', '2022-05-20 18:37:26', '2022-06-06 15:57:54');
INSERT INTO `tbl_lend_record` VALUES ('26', '26', '10', '0', '2022-05-20 18:38:08', null);
INSERT INTO `tbl_lend_record` VALUES ('27', '21', '11', '0', '2022-05-20 18:38:28', null);
INSERT INTO `tbl_lend_record` VALUES ('28', '18', '11', '0', '2022-05-20 18:38:38', null);
INSERT INTO `tbl_lend_record` VALUES ('29', '25', '12', '0', '2022-05-20 18:38:54', null);
INSERT INTO `tbl_lend_record` VALUES ('30', '15', '1', '0', '2022-06-06 12:49:51', null);
INSERT INTO `tbl_lend_record` VALUES ('31', '15', '8', '0', '2022-06-06 12:50:10', null);
INSERT INTO `tbl_lend_record` VALUES ('32', '13', '7', '0', '2022-06-06 12:51:11', null);
INSERT INTO `tbl_lend_record` VALUES ('33', '15', '11', '1', '2022-06-06 13:19:41', '2022-06-06 13:49:53');
INSERT INTO `tbl_lend_record` VALUES ('34', '1', '1', '2', '2022-06-06 13:50:13', '2022-06-06 15:47:06');
INSERT INTO `tbl_lend_record` VALUES ('35', '1', '1', '1', '2022-06-06 15:15:44', '2022-06-06 16:46:09');
INSERT INTO `tbl_lend_record` VALUES ('36', '3', '7', '0', '2022-06-06 15:47:20', null);
INSERT INTO `tbl_lend_record` VALUES ('37', '10', '8', '0', '2022-06-06 16:46:22', null);
INSERT INTO `tbl_lend_record` VALUES ('38', '1', '9', '0', '2022-06-06 16:57:16', null);

-- ----------------------------
-- Table structure for tbl_order_record
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order_record`;
CREATE TABLE `tbl_order_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `book_id` int DEFAULT NULL COMMENT '图书id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `order_status` int DEFAULT NULL COMMENT '预约状态 0：预约中 1：已处理',
  `order_time` datetime DEFAULT NULL COMMENT '预约时间',
  `update_time` datetime DEFAULT NULL COMMENT '预约记录更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tbl_order_record
-- ----------------------------
INSERT INTO `tbl_order_record` VALUES ('1', '2', '1', '1', '2022-04-20 21:50:35', '2022-04-21 13:18:23');
INSERT INTO `tbl_order_record` VALUES ('3', '2', '2', '1', '2022-04-20 21:50:57', '2022-04-20 21:51:00');
INSERT INTO `tbl_order_record` VALUES ('9', '1', '1', '0', '2022-05-12 19:57:17', '2022-06-06 12:22:56');
INSERT INTO `tbl_order_record` VALUES ('10', '2', '1', '1', '2022-06-06 13:47:36', '2022-06-06 15:15:58');
INSERT INTO `tbl_order_record` VALUES ('11', '2', '1', '1', '2022-06-06 13:47:36', '2022-06-06 13:50:29');
INSERT INTO `tbl_order_record` VALUES ('13', '3', '1', '0', '2022-06-06 15:34:06', '2022-06-06 15:34:06');
INSERT INTO `tbl_order_record` VALUES ('15', '2', '1', '1', '2022-06-06 15:45:54', '2022-06-06 15:47:32');
INSERT INTO `tbl_order_record` VALUES ('16', '1', '1', '0', '2022-06-06 16:12:47', '2022-06-06 16:12:47');
INSERT INTO `tbl_order_record` VALUES ('18', '1', '1', '1', '2022-06-06 16:44:51', '2022-06-06 16:46:32');
INSERT INTO `tbl_order_record` VALUES ('19', '1', '1', '0', '2022-06-06 16:44:51', '2022-06-06 16:44:51');
INSERT INTO `tbl_order_record` VALUES ('20', '1', '1', '0', '2022-06-06 16:55:54', '2022-06-06 16:55:54');
INSERT INTO `tbl_order_record` VALUES ('21', '1', '1', '1', '2022-06-06 16:55:54', '2022-06-06 16:57:27');

-- ----------------------------
-- Table structure for tbl_purchase_record
-- ----------------------------
DROP TABLE IF EXISTS `tbl_purchase_record`;
CREATE TABLE `tbl_purchase_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `book_id` int DEFAULT NULL COMMENT '图书id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `purchase_amount` int DEFAULT NULL COMMENT '购买数量',
  `total` double DEFAULT NULL COMMENT '支付金额',
  `purchase_time` datetime DEFAULT NULL COMMENT '购买时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tbl_purchase_record
-- ----------------------------
INSERT INTO `tbl_purchase_record` VALUES ('2', '2', '1', '1', '50', '2022-04-20 13:56:17');
INSERT INTO `tbl_purchase_record` VALUES ('3', '2', '2', '1', '50', '2022-04-20 13:56:32');
INSERT INTO `tbl_purchase_record` VALUES ('4', '1', '1', '1', '45', '2022-04-20 15:19:48');
INSERT INTO `tbl_purchase_record` VALUES ('5', '1', '7', '1', '45', '2022-04-22 16:24:44');
INSERT INTO `tbl_purchase_record` VALUES ('6', '2', '2', '1', '50', '2022-04-22 16:25:27');
INSERT INTO `tbl_purchase_record` VALUES ('7', '9', '3', '1', '50', '2022-04-22 16:26:29');
INSERT INTO `tbl_purchase_record` VALUES ('8', '11', '3', '1', '45', '2022-04-27 17:06:58');
INSERT INTO `tbl_purchase_record` VALUES ('9', '14', '1', '1', '30', '2022-04-27 17:12:49');
INSERT INTO `tbl_purchase_record` VALUES ('10', '1', '5', '2', '90', '2022-04-27 17:18:47');
INSERT INTO `tbl_purchase_record` VALUES ('11', '7', '7', '2', '84', '2022-04-27 17:22:27');
INSERT INTO `tbl_purchase_record` VALUES ('13', '12', '8', '1', '42.5', '2022-05-20 20:00:31');
INSERT INTO `tbl_purchase_record` VALUES ('14', '11', '9', '1', '45', '2022-05-20 20:00:59');
INSERT INTO `tbl_purchase_record` VALUES ('15', '1', '1', '1', '45', '2022-06-06 12:20:44');
INSERT INTO `tbl_purchase_record` VALUES ('16', '10', '5', '1', '30', '2022-06-06 12:46:42');
INSERT INTO `tbl_purchase_record` VALUES ('17', '2', '1', '1', '50', '2022-06-06 13:16:11');
INSERT INTO `tbl_purchase_record` VALUES ('18', '3', '1', '1', '43', '2022-06-06 13:16:20');
INSERT INTO `tbl_purchase_record` VALUES ('19', '13', '4', '1', '49', '2022-06-06 13:16:34');
INSERT INTO `tbl_purchase_record` VALUES ('20', '13', '5', '1', '49', '2022-06-06 13:16:46');
INSERT INTO `tbl_purchase_record` VALUES ('21', '13', '10', '1', '49', '2022-06-06 13:18:07');
INSERT INTO `tbl_purchase_record` VALUES ('22', '2', '11', '1', '50', '2022-06-06 13:18:27');
INSERT INTO `tbl_purchase_record` VALUES ('23', '3', '2', '1', '43', '2022-06-06 13:19:03');
INSERT INTO `tbl_purchase_record` VALUES ('24', '8', '7', '1', '45', '2022-06-06 15:17:00');
INSERT INTO `tbl_purchase_record` VALUES ('25', '1', '9', '1', '45', '2022-06-06 15:48:24');
INSERT INTO `tbl_purchase_record` VALUES ('26', '1', '11', '1', '45', '2022-06-06 16:47:29');
INSERT INTO `tbl_purchase_record` VALUES ('27', '1', '9', '1', '45', '2022-06-06 16:58:14');

-- ----------------------------
-- Table structure for tbl_put_record
-- ----------------------------
DROP TABLE IF EXISTS `tbl_put_record`;
CREATE TABLE `tbl_put_record` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `book_id` int DEFAULT NULL COMMENT '入库图书id',
  `put_amount` int DEFAULT NULL COMMENT '入库数量',
  `total` double(10,2) DEFAULT NULL COMMENT '入库花费金额',
  `put_time` datetime DEFAULT NULL COMMENT '入库时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tbl_put_record
-- ----------------------------
INSERT INTO `tbl_put_record` VALUES ('1', '7', '1', '20.00', '2022-05-18 22:28:06');
INSERT INTO `tbl_put_record` VALUES ('2', '7', '2', '30.00', '2022-05-18 22:28:28');
INSERT INTO `tbl_put_record` VALUES ('3', '14', '1', '20.00', '2022-05-19 14:50:04');
INSERT INTO `tbl_put_record` VALUES ('4', '2', '1', '20.00', '2022-05-19 14:55:53');
INSERT INTO `tbl_put_record` VALUES ('5', '1', '1', '20.00', '2022-06-06 13:49:29');
INSERT INTO `tbl_put_record` VALUES ('6', '1', '1', '20.00', '2022-06-06 15:15:19');
INSERT INTO `tbl_put_record` VALUES ('7', '1', '1', '20.00', '2022-06-06 15:46:46');
INSERT INTO `tbl_put_record` VALUES ('8', '3', '1', '20.00', '2022-06-06 16:45:50');
INSERT INTO `tbl_put_record` VALUES ('9', '1', '1', '20.00', '2022-06-06 16:56:54');

-- ----------------------------
-- Table structure for tbl_recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `tbl_recharge_record`;
CREATE TABLE `tbl_recharge_record` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `recharge_type` int DEFAULT NULL COMMENT '充值类型(0：充值余额 、1：充值借阅点)',
  `recharge_amount` double DEFAULT NULL COMMENT '充值金额',
  `recharge_time` datetime DEFAULT NULL COMMENT '充值时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tbl_recharge_record
-- ----------------------------
INSERT INTO `tbl_recharge_record` VALUES ('1', '1', '0', '10', '2022-05-18 22:30:41');
INSERT INTO `tbl_recharge_record` VALUES ('2', '2', '1', '20', '2022-05-18 22:39:33');
INSERT INTO `tbl_recharge_record` VALUES ('3', '5', '0', '10', '2022-05-19 14:56:15');
INSERT INTO `tbl_recharge_record` VALUES ('4', '3', '0', '20', '2022-05-19 14:56:30');
INSERT INTO `tbl_recharge_record` VALUES ('5', '1', '1', '10', '2022-05-19 14:57:02');
INSERT INTO `tbl_recharge_record` VALUES ('6', '9', '0', '20', '2022-05-20 15:56:10');
INSERT INTO `tbl_recharge_record` VALUES ('7', '10', '1', '10', '2022-05-20 15:56:21');
INSERT INTO `tbl_recharge_record` VALUES ('8', '11', '0', '10', '2022-05-20 15:56:34');
INSERT INTO `tbl_recharge_record` VALUES ('9', '12', '0', '15', '2022-05-20 15:56:45');
INSERT INTO `tbl_recharge_record` VALUES ('10', '1', '0', '30', '2022-05-20 15:57:22');
INSERT INTO `tbl_recharge_record` VALUES ('11', '4', '1', '15', '2022-05-20 15:57:39');
INSERT INTO `tbl_recharge_record` VALUES ('12', '2', '1', '5', '2022-05-20 15:57:50');
INSERT INTO `tbl_recharge_record` VALUES ('13', '9', '0', '5', '2022-05-20 18:46:00');
INSERT INTO `tbl_recharge_record` VALUES ('14', '1', '0', '20', '2022-06-06 13:52:19');
INSERT INTO `tbl_recharge_record` VALUES ('15', '1', '0', '10', '2022-06-06 15:49:09');
INSERT INTO `tbl_recharge_record` VALUES ('16', '1', '0', '5', '2022-06-06 15:50:04');
INSERT INTO `tbl_recharge_record` VALUES ('17', '2', '0', '10', '2022-06-06 16:48:07');
INSERT INTO `tbl_recharge_record` VALUES ('18', '1', '1', '10', '2022-06-06 16:59:00');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `real_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户姓名',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `balance` double DEFAULT NULL COMMENT '余额',
  `borrow_point` double DEFAULT NULL COMMENT '借阅点数',
  `user_role` int DEFAULT NULL COMMENT '用户类型（0：普通学生 1：贫困生）',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `update_time` datetime DEFAULT NULL COMMENT '用户信息更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '刘三', '2018001', '12345', '男', '2000-01-01', '15212345248', '2724862926@qq.com', '42', '66', '0', '2022-04-05 15:19:32', '2022-06-06 16:59:00');
INSERT INTO `tbl_user` VALUES ('2', '李四', '2018002', '12345', '男', '2002-03-05', '12352452548', '15845624@qq.com', '67', '25', '1', '2022-04-05 15:20:27', '2022-06-06 16:48:07');
INSERT INTO `tbl_user` VALUES ('3', '赵武', '2018003', '12345', '男', '2016-04-16', '12367458761', '2313112@qq.com', '100', '69', '0', '2022-04-16 18:49:28', '2022-06-06 16:47:49');
INSERT INTO `tbl_user` VALUES ('4', '周六', '2018004', '12345', '男', '2022-04-16', '14567891234', '23124412@qq.com', '51', '15', '0', '2022-04-16 18:50:51', '2022-06-06 13:16:34');
INSERT INTO `tbl_user` VALUES ('5', '田天涯', '2018005', '12345', '男', '2007-04-05', '17656782345', '14523521@qq.com', '51', '38', '0', '2022-04-16 18:58:39', '2022-06-06 13:16:46');
INSERT INTO `tbl_user` VALUES ('7', '刘说', '2018007', '12345', '女', '2006-02-18', '18765436785', '5243758@qq.om', '26', '31', '0', '2022-04-18 19:50:33', '2022-06-06 15:47:20');
INSERT INTO `tbl_user` VALUES ('8', '赵文', '2018008', '12345', '男', '2007-02-27', '15582761442', '4151351@qq.com', '100', '20', '1', '2022-04-27 17:11:28', '2022-05-20 20:37:54');
INSERT INTO `tbl_user` VALUES ('9', '徐达', '2018009', '12345', '男', '2022-05-20', '13441877123', '42523454@qq.com', '10', '60', '1', '2022-05-20 15:52:59', '2022-06-06 16:58:38');
INSERT INTO `tbl_user` VALUES ('10', '朱东', '2018010', '12345', '男', '2022-02-20', '18743242232', '855245234@qq.com', '51', '25', '0', '2022-05-20 15:54:07', '2022-06-06 13:18:07');
INSERT INTO `tbl_user` VALUES ('11', '蒋九', '2018011', '12345', '男', '2016-02-20', '19878654578', '4236743@qq.com', '5', '35', '0', '2022-05-20 15:55:04', '2022-06-06 16:47:29');
INSERT INTO `tbl_user` VALUES ('12', '刘涵', '2018012', '12345', '女', '2014-12-29', '17867542345', '353763463@qq.com', '15', '10', '0', '2022-05-20 15:55:54', '2022-05-20 18:38:54');
INSERT INTO `tbl_user` VALUES ('13', '张员', '2018013', '12345', '男', '2022-06-06', '15310354321', '42423532@qq.com', '0', '10', '0', '2022-06-06 16:49:01', '2022-06-06 16:49:01');
INSERT INTO `tbl_user` VALUES ('14', '徐梦达', '2018014', '12345', '女', '2021-05-06', '15336489875', '46464818@qq.com', '0', '10', '0', '2022-06-06 16:59:44', '2022-06-06 16:59:44');
