SELECT * FROM CATEGORY
INSERT INTO `category` (categoryId, createOn, isDisabled, name) VALUES (1,now(),false,'电脑配件');
INSERT INTO `category` (categoryId, createOn, isDisabled, name) VALUES (2,now(),false,'办公设备');
INSERT INTO `category` (categoryId, createOn, isDisabled, name) VALUES (3,now(),false,'手机数码');
INSERT INTO `category` (categoryId, createOn, isDisabled, name) VALUES (4,now(),false,'电脑整机');
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'影视', 1);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'外语', 1);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'小说', 1);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'音乐', 1);

INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'动漫', 1);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'少儿', 1);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'羽绒服', 2);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'数码相机', 2);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'运动鞋', 2);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'笔记本', 2);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'秋冬靴', 2);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'家纺用品', 3);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'婴幼奶粉', 3);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'美容护肤', 3);
INSERT INTO `category` (createOn, isDisabled, name ,categoryFatherId) VALUES (now(),false,'饰品', 4);
