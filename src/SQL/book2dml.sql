-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` (`ID`, `USER_NAME`, `USER_PASSWORD`,`CREATE_BY`) VALUES ('1', 'admin', 'admin','1');
INSERT INTO `t_user` (`ID`, `USER_NAME`, `USER_PASSWORD`,`CREATE_BY`) VALUES ('2', 'user', 'user','1');


-- ----------------------------
-- Records of t_publisher
-- ----------------------------
INSERT INTO `t_publisher` (`ID`, `PUB_NAME`, `PUB_TEL`, `PUB_LINK_MAN`, `PUB_INTRO`,`CREATE_BY`) VALUES ('1', '机械工业出版社', '13812345678', '张三', '经典出版社','1');
INSERT INTO `t_publisher` (`ID`, `PUB_NAME`, `PUB_TEL`, `PUB_LINK_MAN`, `PUB_INTRO`,`CREATE_BY`) VALUES ('2', '电子工业出版社', '13012345678', '李四', '一般口水书出版社','1');
INSERT INTO `t_publisher` (`ID`, `PUB_NAME`, `PUB_TEL`, `PUB_LINK_MAN`, `PUB_INTRO`,`CREATE_BY`) VALUES ('3', '清华大学出版社', '16888888888', '王五', '老牌大学出版社','1');


-- ----------------------------
-- Records of t_book_type
-- ----------------------------
INSERT INTO `t_book_type` (`ID`, `TYPE_NAME`, `TYPE_INTRO`,`CREATE_BY`) VALUES ('1', '开发', '开发工程师使用、参考书籍','1');
INSERT INTO `t_book_type` (`ID`, `TYPE_NAME`, `TYPE_INTRO`,`CREATE_BY`) VALUES ('2', '测试', '测试方面的图书','1');

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` (`ID`, `BOOK_NAME`, `BOOK_INTRO`, `BOOK_PRICE`, `PUB_ID`, `TYPE_ID`, `IMAGE_URL`, `AUTHOR`, `REPERTORY_SIZE`,`CREATE_BY`) VALUES ('1', 'Java程序设计与计算思维', '程序设计的过程就是一种计算思维的表现，本书结合Java程序设计语言的教学特点，遵循计算思维的方式，图解重要概念，通过大量的范例程序讲解和上机编程实践来指导读者活用Java程序语法，兼顾培养计算思维和学习面向对象程序设计的双目标。', '69.3', '1', '1', 'upload/e56c371e-e31b-4686-a78f-38d8470f4021.jpg', '赵军', '1','1');
INSERT INTO `t_book` (`ID`, `BOOK_NAME`, `BOOK_INTRO`, `BOOK_PRICE`, `PUB_ID`, `TYPE_ID`, `IMAGE_URL`, `AUTHOR`, `REPERTORY_SIZE`,`CREATE_BY`) VALUES ('2', '微服务架构设计模式', '涵盖44个架构设计模式，系统解决服务拆分、事务管理、查询和跨服务通信等难题', '97.3', '1', '1', 'upload/03499c25-8d21-469d-8e17-5e56c8867476.jpg', '[美]克里斯·理查森', '2','1');
INSERT INTO `t_book` (`ID`, `BOOK_NAME`, `BOOK_INTRO`, `BOOK_PRICE`, `PUB_ID`, `TYPE_ID`, `IMAGE_URL`, `AUTHOR`, `REPERTORY_SIZE`,`CREATE_BY`) VALUES ('3', '软件测试（原书第2版）', '本书涵盖了软件测试的方方面面:软件测试如何适应软件开发过程，基本的和高级的软件测试技术，在常见的测试任务中运用测试技能，使用自动化提高测试的效率，测试工作的计划和文档化，有效地报告发现的问题，衡量测试工作的成效和产品的改进，\n测试和质量保证的区别，寻求软件测试员的工作。', '41.3', '1', '2', 'upload/56221c9a-0c90-4b37-8ca0-ff3080505076.jpg', '[美]罗恩·佩腾', '2','1');
INSERT INTO `t_book` (`ID`, `BOOK_NAME`, `BOOK_INTRO`, `BOOK_PRICE`, `PUB_ID`, `TYPE_ID`, `IMAGE_URL`, `AUTHOR`, `REPERTORY_SIZE`,`CREATE_BY`) VALUES ('4', 'MongoDB从入门到商业实战', '从零学MongoDB，并希望可以在企业中真正应用的读者', '89.25', '2', '1', 'upload/de9d5318-123d-4e96-9c1e-28c70f7e7483.jpg', '张雯杰', '15','1');

-- ----------------------------
-- Records of t_in_record
-- ----------------------------
INSERT INTO `t_in_record` (`ID`, `RECORD_DATE`,`CREATE_BY`) VALUES ('9', '2019-10-02 11:20:16','1');
INSERT INTO `t_in_record` (`ID`, `RECORD_DATE`,`CREATE_BY`) VALUES ('10', '2019-10-02 12:27:38','1');
INSERT INTO `t_in_record` (`ID`, `RECORD_DATE`,`CREATE_BY`) VALUES ('11', '2019-10-02 20:27:53','1');


-- ----------------------------
-- Records of t_book_in_record
-- ----------------------------
INSERT INTO `t_book_in_record` (`ID`, `BOOK_ID`, `IN_RECORD_ID`, `IN_SUM`,`CREATE_BY`) VALUES ('9', '1', '9', '10','1');
INSERT INTO `t_book_in_record` (`ID`, `BOOK_ID`, `IN_RECORD_ID`, `IN_SUM`,`CREATE_BY`) VALUES ('10', '2', '10', '10','1');
INSERT INTO `t_book_in_record` (`ID`, `BOOK_ID`, `IN_RECORD_ID`, `IN_SUM`,`CREATE_BY`) VALUES ('11', '3', '10', '10','1');
INSERT INTO `t_book_in_record` (`ID`, `BOOK_ID`, `IN_RECORD_ID`, `IN_SUM`,`CREATE_BY`) VALUES ('12', '4', '10', '10','1');
INSERT INTO `t_book_in_record` (`ID`, `BOOK_ID`, `IN_RECORD_ID`, `IN_SUM`,`CREATE_BY`) VALUES ('13', '4', '11', '10','1');


-- ----------------------------
-- Records of t_sale_record
-- ----------------------------
INSERT INTO `t_sale_record` (`ID`, `RECORD_DATE`,`CREATE_BY`) VALUES ('3', '2019-10-02 14:52:01','1');
INSERT INTO `t_sale_record` (`ID`, `RECORD_DATE`,`CREATE_BY`) VALUES ('4', '2019-10-02 14:52:18','1');
INSERT INTO `t_sale_record` (`ID`, `RECORD_DATE`,`CREATE_BY`) VALUES ('5', '2019-10-02 14:52:29','1');
INSERT INTO `t_sale_record` (`ID`, `RECORD_DATE`,`CREATE_BY`) VALUES ('6', '2019-10-02 14:52:34','1');
INSERT INTO `t_sale_record` (`ID`, `RECORD_DATE`,`CREATE_BY`) VALUES ('7', '2019-10-02 14:52:39','1');


-- ----------------------------
-- Records of t_book_sale_record
-- ----------------------------
INSERT INTO `t_book_sale_record` (`ID`, `BOOK_ID`, `SALE_RECORD_ID`, `TRADE_SUM`,`CREATE_BY`) VALUES ('3', '2', '3', '1','1');
INSERT INTO `t_book_sale_record` (`ID`, `BOOK_ID`, `SALE_RECORD_ID`, `TRADE_SUM`,`CREATE_BY`) VALUES ('4', '2', '4', '2','1');
INSERT INTO `t_book_sale_record` (`ID`, `BOOK_ID`, `SALE_RECORD_ID`, `TRADE_SUM`,`CREATE_BY`) VALUES ('5', '3', '5', '3','1');
INSERT INTO `t_book_sale_record` (`ID`, `BOOK_ID`, `SALE_RECORD_ID`, `TRADE_SUM`,`CREATE_BY`) VALUES ('6', '1', '6', '4','1');
INSERT INTO `t_book_sale_record` (`ID`, `BOOK_ID`, `SALE_RECORD_ID`, `TRADE_SUM`,`CREATE_BY`) VALUES ('7', '1', '7', '5','1');
INSERT INTO `t_book_sale_record` (`ID`, `BOOK_ID`, `SALE_RECORD_ID`, `TRADE_SUM`,`CREATE_BY`) VALUES ('8', '2', '7', '5','1');
INSERT INTO `t_book_sale_record` (`ID`, `BOOK_ID`, `SALE_RECORD_ID`, `TRADE_SUM`,`CREATE_BY`) VALUES ('9', '3', '7', '5','1');
INSERT INTO `t_book_sale_record` (`ID`, `BOOK_ID`, `SALE_RECORD_ID`, `TRADE_SUM`,`CREATE_BY`) VALUES ('10', '4', '7', '5','1');
