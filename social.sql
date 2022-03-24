-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: social
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `es_activity`
--

DROP TABLE IF EXISTS `es_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_activity` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动标题',
  `thumb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '缩略图',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动内容',
  `place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动地点',
  `begin_time` int unsigned DEFAULT NULL COMMENT '活动开始时间',
  `end_time` int unsigned DEFAULT NULL COMMENT '活动截止时间',
  `sponsor_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '举办单位',
  `status` tinyint unsigned DEFAULT NULL COMMENT '状态 0 无效 1 有效',
  `create_time` int unsigned DEFAULT NULL COMMENT '添加时间',
  `update_time` int unsigned DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='小区活动信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_activity`
--

LOCK TABLES `es_activity` WRITE;
/*!40000 ALTER TABLE `es_activity` DISABLE KEYS */;
INSERT INTO `es_activity` VALUES (1,'CM2020011400001','佳兆业深圳区域社区生活节火爆 启动八城联动数千人参与','/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial; white-space: normal; background-color: rgb(255, 255, 255);\"><span class=\"bjh-p\">继3月16日，佳兆业深圳区域第一届社区生活节第一季度 “佳人徒步，乐享健康”主题活动在深圳、惠州、重庆、武汉率先启动后，3月23日，活动在中山、珠海、长沙、成都继续火爆上演。8城联动，数千名佳兆业业主在本次活动中欢乐相聚，徒步踏青，乐享幸福生活理念。<span class=\"bjh-br\"></span></span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial; white-space: normal; background-color: rgb(255, 255, 255);\"><span class=\"bjh-p\">精心组织策划获广泛好评</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial; white-space: normal; background-color: rgb(255, 255, 255);\"><span class=\"bjh-p\">本次活动覆盖了佳兆业深圳区域（深圳、惠州、中山、珠海、武汉、长沙、重庆、成都）所辖八大城市，吸引数千名佳兆业业主踊跃参与。</span></p><p><br/></p>','深圳湾',1592987820,1593765420,'佳兆业',1,1593246903,1593310057),(2,'CM2020011400001','2018首届佳兆业杯粤港澳儿童平衡车大赛火热开赛','/uploads/20200627/f4155c580dc4a0544609211b1680118f.jpg','<p><span style=\"color: rgb(102, 102, 102); font-family: 微软雅黑; background-color: rgb(255, 255, 255);\">继3月16日，佳兆业深圳区域第一届社区生活节第一季度 “佳人徒步，乐享健康”主题活动在深圳、惠州、重庆、武汉率先启动后，3月23日，活动在中山、珠海、长沙、成都继续火爆上演。8城联动，数千名佳兆业业主在本次活动中欢乐相聚，徒步踏青，乐享幸福生活理念。</span></p>','深圳湾',1592383140,1593333540,'佳兆业001',1,1593247013,1593310048),(3,'CM2020011400002','2018深圳潮酷慢跑公益行登陆大鹏玫瑰海岸','/uploads/20200628/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','<p style=\"padding: 0px 0px 8px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; color: rgb(76, 76, 76); line-height: 30px; text-align: justify; font-family: SiyuanNormal, &quot;Microsoft Yahei&quot;, Arial, Simsun; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">你知道吗？每分钟，全球就会卖出约100万个塑料瓶；每年，有1300万吨塑料垃圾流入海洋。在客流量极大的海边沙滩，就是垃圾流入海洋的重灾区。</p><p style=\"padding: 0px 0px 8px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; color: rgb(76, 76, 76); line-height: 30px; text-align: justify; font-family: SiyuanNormal, &quot;Microsoft Yahei&quot;, Arial, Simsun; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">10月27日，一种起源于瑞典的新潮公益运动，来到深圳大鹏玫瑰海岸。“2018深圳大鹏国际户外嘉年华”之“Dapeng Plogging”2018深圳潮酷慢跑公益行活动温情启幕，200位市民在海滩慢跑的同时，随手拾起垃圾，并通过活动设置的打卡游戏完成环保公益任务，赢取最终的惊喜奖品。</p><p style=\"padding: 0px 0px 8px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; color: rgb(76, 76, 76); line-height: 30px; text-align: justify; font-family: SiyuanNormal, &quot;Microsoft Yahei&quot;, Arial, Simsun; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">据了解，本次活动是国内最大户外运动节——“2018深圳大鹏国际户外嘉年华”的重要活动之一。本届嘉年华是在深圳市文体旅游局、深圳市大鹏新区管理委员会的指导下，在深圳市大鹏新区文体旅游局的支持下，由佳兆业集团控股有限公司主办，佳兆业文体集团、佳兆业国际乐园集团承办的大文旅IP落地实践项目，受到各界高度关注。</p><p style=\"padding: 0px 0px 8px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; color: rgb(76, 76, 76); line-height: 30px; text-align: justify; font-family: SiyuanNormal, &quot;Microsoft Yahei&quot;, Arial, Simsun; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">这次由佳兆业集团与深圳报业集团深圳都市报联合推出的“Dapeng Plogging”2018年深圳潮酷慢跑公益行，结合了目前国内外社交网络爆红的“Plogging”慢跑捡垃圾形式，将“公益”“环保”“健身”合而为一，在运动的同时释放深圳市民的公益热情。活动从报名开始起，即得到了广大市民的积极响应，出于环保因素的考虑，最终从1000组家庭中随机抽选了100组家庭参加。</p><p style=\"padding: 0px 0px 8px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; color: rgb(76, 76, 76); line-height: 30px; text-align: justify; font-family: SiyuanNormal, &quot;Microsoft Yahei&quot;, Arial, Simsun; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">活动当日清晨，这100组队伍从深圳福田区出发，乘坐统一大巴来到大鹏玫瑰海岸。“我们有幸生活在一个有海的城市，海洋对我们都生活很重要。”活动启动仪式上，深圳报业集团深圳都市报总编辑表示，本次活动选址美丽的玫瑰海岸，以家庭为单位参与，就是希望通过这种“公益+环保+健身”的形式，“给孩子们的心里种下一颗公益心。”</p><p><br/></p>','佳兆业深圳区域',1592383200,1594370400,'佳兆业',1,1593247078,1593310039);
/*!40000 ALTER TABLE `es_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_admin`
--

DROP TABLE IF EXISTS `es_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_admin` (
  `id` int unsigned NOT NULL COMMENT 'ID',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '密码盐',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '电子邮箱',
  `login_failure` tinyint unsigned NOT NULL COMMENT '失败次数',
  `login_time` int unsigned NOT NULL COMMENT '登录时间',
  `create_time` int unsigned NOT NULL COMMENT '创建时间',
  `update_time` int unsigned NOT NULL COMMENT '更新时间',
  `token` varchar(59) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'Session标识',
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'normal' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_admin`
--

LOCK TABLES `es_admin` WRITE;
/*!40000 ALTER TABLE `es_admin` DISABLE KEYS */;
INSERT INTO `es_admin` VALUES (2,'yuncopy','yuncopy1','941886aa280b4190d0fe4c44bc8e61cc','goHRFu','/assets/img/avatar.png','yuncopy@qq.com',3,1578993981,1578993820,1593067853,'9be68cc0-1002-48ec-9171-8df1aca4cc32','normal'),(3,'yun','yun','ccbe761361a23eaf55ba77b9c6b9a3e6','eWpMzT','/assets/img/avatar.png','yuncopy@qq.com',0,1579175454,1579175434,1579175454,'d1a9df15-9493-43b0-a163-38b7d7ba4325','normal'),(4,'admin','admin123','admin','eWpMzT','admin','admin@163.com',0,1579175454,1579175454,1579175454,'123','normal');
/*!40000 ALTER TABLE `es_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_admin_log`
--

DROP TABLE IF EXISTS `es_admin_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_admin_log` (
  `id` int unsigned NOT NULL COMMENT 'ID',
  `admin_id` int unsigned NOT NULL COMMENT '管理员ID',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '管理员名字',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '操作页面',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '日志标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'IP',
  `useragent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'User-Agent',
  `create_time` int unsigned NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `name` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='管理员日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_admin_log`
--

LOCK TABLES `es_admin_log` WRITE;
/*!40000 ALTER TABLE `es_admin_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `es_admin_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_article`
--

DROP TABLE IF EXISTS `es_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_article` (
  `id` int unsigned NOT NULL COMMENT '文章ID',
  `cid` int unsigned NOT NULL COMMENT '分类ID',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '简介',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '内容',
  `author` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '作者',
  `status` tinyint unsigned NOT NULL COMMENT '状态 0 待审核  1 审核',
  `reading` int unsigned NOT NULL COMMENT '阅读量',
  `thumb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '缩略图',
  `photo` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '图集',
  `is_top` tinyint unsigned NOT NULL COMMENT '是否置顶  0 不置顶  1 置顶',
  `is_recommend` tinyint unsigned NOT NULL COMMENT '是否推荐  0 不推荐  1 推荐',
  `sort` tinyint unsigned NOT NULL COMMENT '排序',
  `create_time` int unsigned NOT NULL COMMENT '创建时间',
  `publish_time` int unsigned NOT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='文章表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_article`
--

LOCK TABLES `es_article` WRITE;
/*!40000 ALTER TABLE `es_article` DISABLE KEYS */;
INSERT INTO `es_article` VALUES (1,1,'[公告]黑猫投诉：因疫情原因没收入','黑猫投诉：因疫情原因没收入','<p><span style=\"color: rgb(51, 51, 51); font-family: 宋体; text-indent: 32px; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;交通运输部日前发布通知，明确端午节期间和今后一段时期，各地交通运输主管部门要严格落实中央应对新冠肺炎疫情工作领导小组有关部署，</span><span style=\"margin: 0px; padding: 0px; list-style: none; color: rgb(51, 51, 51); font-family: 宋体; text-indent: 32px; background-color: rgb(255, 255, 255); font-weight: bold;\">继续暂停省际旅游客运</span><span style=\"color: rgb(51, 51, 51); font-family: 宋体; text-indent: 32px; background-color: rgb(255, 255, 255);\">，不得开放办理包车客运管理信息系统省际旅游客运业务备案。北京市和环京“护城河”地区等交通运输主管部门要</span><span style=\"margin: 0px; padding: 0px; list-style: none; color: rgb(51, 51, 51); font-family: 宋体; text-indent: 32px; background-color: rgb(255, 255, 255); font-weight: bold;\">继续暂停出租汽车、顺风车进出京业务</span><span style=\"color: rgb(51, 51, 51); font-family: 宋体; text-indent: 32px; background-color: rgb(255, 255, 255);\">，</span><span style=\"margin: 0px; padding: 0px; list-style: none; color: rgb(51, 51, 51); font-family: 宋体; text-indent: 32px; background-color: rgb(255, 255, 255); font-weight: bold;\">进出京省际客运班线和跨省公交尚未恢复运营的，暂不恢复</span><span style=\"color: rgb(51, 51, 51); font-family: 宋体; text-indent: 32px; background-color: rgb(255, 255, 255);\">。</span></p>','文章管理员',1,5,'/uploads/20200601/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','',1,0,0,1590940929,1593306625),(2,1,'[公告]扎实做好常态化疫情防控','6月15日，省民政厅印发《河南省民政厅关于强化疫情防控措施坚决防止疫情反弹的紧急通知》，要求全省民政系统提高思想认识，慎终如初做好民政系统疫情防控，时刻紧绷防范疫情风险这根弦，落细各项常态化防控措施。','<p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: notoRegular; text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">6月15日，省民政厅印发《河南省民政厅关于强化疫情防控措施坚决防止疫情反弹的紧急通知》，要求全省民政系统提高思想认识，慎终如初做好民政系统疫情防控，时刻紧绷防范疫情风险这根弦，落细各项常态化防控措施。</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: notoRegular; text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">《通知》强调各地民政部门要健全常态化精准防控和应急处置相结合的机制，坚决筑牢民政服务机构疫情防线，并分门别类对养老服务机构、儿童福利机构、救助管理和托养、殡葬服务、婚姻登记、残疾人康复等机构提出具体指导意见，采取有力措施做好联防联控工作。压实“属地、部门、单位、个人”四方责任，要求全省各级民政部门对防止疫情反弹的措施进行全面评估，对本地防控漏洞再排查，对防控重点再加固，对防控要求再落实。</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: notoRegular; text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">自新冠肺炎疫情发生以来，驻省民政厅纪检监察组始终紧绷疫情防控“监督弦”，以及时精准监督保障监督有力有效。针对近期部分地区出现零星散发病例和聚集性疫情，驻省民政厅纪检监察组还将继续与党组同向发力，结合工作实际采取突击抽查、查看实情、约谈督促、专项督查等方式，全程跟进监督，切实推动人员思想不麻痹、责任不松懈、各项措施不放松、工作不懈怠，共同守护好人民群众生命安全。（驻省民政厅纪检监察组）</p><p><br/></p>','超级管理员',1,4,'/uploads/20200601/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','',0,0,0,1590942195,1593306620),(3,1,'[公告]疫情期间，北京丰台社区新闻发声人做了什么？','疫情期间，北京丰台社区新闻发声人做了什么？','<p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial; white-space: normal; background-color: rgb(255, 255, 255);\"><span class=\"bjh-p\">为社区工作者发声，是我身为社区新闻发声人的责任，也是我作为社区居民一分子特别乐于做的事情，尤其在疫情防控这一段特别的日子里。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial; white-space: normal; background-color: rgb(255, 255, 255);\"><span class=\"bjh-p\">疫情严峻的2月14日，一场突降的大雪令京城气温大降，第二天清晨我到小区门口取快递。雪后的大风摧毁了社区工作者的临时帐篷，年轻的值守者冻得瑟瑟发抖却依然一丝不苟地检查出入证、测量体温；为居家观察的返京人员倒垃圾、送外卖；帮行动不便的老人送快递、扛水桶……</span></p><p><br/></p>','超级管理员',1,2,'/uploads/20200601/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','',0,0,0,1591466418,1593306609),(4,3,'[故事]弘扬真善美传播好家风','弘扬真善美传播好家风','<p><span style=\"color: rgb(102, 102, 102); font-family: 宋体; font-size: 14px;\">西樵镇家庭教育指导中心联合樵江社区党总支举办“智慧家教·和美家”项目启动仪式暨“品味端午‘放粽’说爱”——美好家庭养成计划系列活动</span></p>','超级管理员',1,0,'/assets/img/qrcode.png','',0,0,0,1591718338,1593306678),(5,3,'[故事]为义务替居民跑腿配药的曾医生点赞','[故事]为义务替居民跑腿配药的曾医生点赞','<p style=\"box-sizing: border-box; margin-top: 20px; margin-bottom: 20px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &quot;Microsoft YaHei&quot;, 微软雅黑, 宋体; white-space: normal; background-color: rgb(255, 255, 255);\">乐颖智报道 “小陈，还能帮忙配药吗？”</p><p style=\"box-sizing: border-box; margin-top: 20px; margin-bottom: 20px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &quot;Microsoft YaHei&quot;, 微软雅黑, 宋体; white-space: normal; background-color: rgb(255, 255, 255);\">“金大伯，我帮您和曾医生联系下哦。”</p><p style=\"box-sizing: border-box; margin-top: 20px; margin-bottom: 20px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &quot;Microsoft YaHei&quot;, 微软雅黑, 宋体; white-space: normal; background-color: rgb(255, 255, 255);\">近日，金大伯联系社区工作人员小陈帮忙配药。小陈口中的曾医生，叫曾贵平，是浙江省医疗健康集团杭州医院的医生，也是金大伯所在小区的居民。平时社区的流动医疗服务多由他们单位承担。疫情防控期间，这项服务暂停了，曾医生考虑到许多年纪大、出行有困难的居民配药不方便，就主动承担起替居民配药的工作。晚上下班，他到社区拿走居民的病例、医保卡、药品清单等，白天上班他替居民配好药，再带回。有好几次，他还自掏腰包替居民垫付医药费。金大伯就是曾医生的服务对象之一。</p><p style=\"box-sizing: border-box; margin-top: 20px; margin-bottom: 20px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &quot;Microsoft YaHei&quot;, 微软雅黑, 宋体; white-space: normal; background-color: rgb(255, 255, 255);\">如今疫情转好，可是像金大伯这样行动不便的居民，配药依旧是个难题。社区联系曾医生询问他是否愿意继续帮忙配药，没想到曾医生二话不说就答应了。</p><p style=\"box-sizing: border-box; margin-top: 20px; margin-bottom: 20px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &quot;Microsoft YaHei&quot;, 微软雅黑, 宋体; white-space: normal; background-color: rgb(255, 255, 255);\">曾医生说，“虽然不能像一线的医护工作人员那样在前线与病毒厮杀，但作为一名医务工作者，只要患者有需要，我责无旁贷。”</p><p><br/></p>','超级管理员',1,0,'','',0,1,0,1591718356,1593306670),(6,3,'[故事]四季青运新社区入选省级文化示范社区','四季青运新社区入选省级文化示范社区','<p style=\"box-sizing: border-box; margin-top: 20px; margin-bottom: 20px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &quot;Microsoft YaHei&quot;, 微软雅黑, 宋体; white-space: normal; background-color: rgb(255, 255, 255);\">通讯员报道 近日，省文旅厅公布了最新一期获评省文化强镇和文化示范村（社区）的名单，我区四季青街道运新社区榜上有名。</p><p style=\"box-sizing: border-box; margin-top: 20px; margin-bottom: 20px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &quot;Microsoft YaHei&quot;, 微软雅黑, 宋体; white-space: normal; background-color: rgb(255, 255, 255);\">近年来，随着运新社区入住率的不断攀升，居民对文化活动的需求日益强烈。为了让居民有更多的文化活动场地，享受更完善的文化设施，社区于2017年建成“三园三中心”，总面积约350平方米。</p><p style=\"box-sizing: border-box; margin-top: 20px; margin-bottom: 20px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &quot;Microsoft YaHei&quot;, 微软雅黑, 宋体; white-space: normal; background-color: rgb(255, 255, 255);\">社区发挥各团队与志愿者作用，定期开展“和风韵、熏风韵、金风韵、朔风韵”四季之韵主题活动，积极开展“福聚韵新 和在社区”文化公益行广场活动，促进居民安在社区、居在社区、学在社区、美在社区、乐在社区的“和”文化氛围。</p><p style=\"box-sizing: border-box; margin-top: 20px; margin-bottom: 20px; text-indent: 2em; color: rgb(51, 51, 51); font-family: &quot;Microsoft YaHei&quot;, 微软雅黑, 宋体; white-space: normal; background-color: rgb(255, 255, 255);\">运新社区还组建江畔书画院、快乐之声合唱队等文体团队，开展小班化培训及各类文化活动，培养社区群众文艺骨干，发挥文化队伍的引领作用。</p><p><br/></p>','超级管理员',1,2,'','',0,1,0,1591718372,1593306656),(7,2,'[新闻]志愿者进养老院 给45位老人免费修脚','志愿者进养老院 给45位老人免费修脚','<p style=\"margin-top: 0px; margin-bottom: 14px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); line-height: 1.7; font-size: 14px; font-family: &quot;Microsoft Yahei&quot;, &quot;Hiragino Sans GB&quot;, &quot;Helvetica Neue&quot;, Helvetica, tahoma, arial, Verdana, sans-serif, &quot;WenQuanYi Micro Hei&quot;, 宋体; white-space: normal; background-color: rgb(255, 255, 255);\">本报讯（记者邹前俊 通讯员牟立寅）帮老人脱下袜子、耐心地磨掉脚上的老茧、小心地剪掉厚厚的趾甲……10月30日上午，5名志愿者走进汉宜南山养老院，为这里的45位老人免费修脚。</p><p style=\"margin-top: 0px; margin-bottom: 14px; padding: 0px; text-indent: 2em; color: rgb(51, 51, 51); line-height: 1.7; font-size: 14px; font-family: &quot;Microsoft Yahei&quot;, &quot;Hiragino Sans GB&quot;, &quot;Helvetica Neue&quot;, Helvetica, tahoma, arial, Verdana, sans-serif, &quot;WenQuanYi Micro Hei&quot;, 宋体; white-space: normal; background-color: rgb(255, 255, 255);\">上午9时30分许，记者看到，在该老年公寓院落的凉棚下，老人们坐在板凳上排成排，每人跟前放个冒着热气腾腾的盆子泡着脚，来自朋朋爱心服务队的5名志愿者正在为老人洗脚、修脚。“奶奶，平时泡脚可以在温水中加入一小杯米醋，泡上20分钟……”一位志愿者正用专业工具仔细小心地为老人清理脚垢，边教老人日常护脚方法。记者发现，在修脚过程中志愿者非常细心，会先询问老人的身体情况，然后再用专业工具修剪嵌在肉里的指甲、刮掉脚底多余的角质层以及修复脚跟干裂的裂口，修完脚还涂抹一种药膏。而行动不便的老人，他们还走进房间内进行服务。</p><p><br/></p>','超级管理员',1,5,'/uploads/20200601/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','/uploads/20200601/abc5bb17ade50895b6a9cc4fa3929349.jpg,/uploads/20200601/7cd29c3d7f4ae61b8075b7fbad48a1d1.png',1,0,0,1591718446,1593306715),(8,3,'[故事]佳兆业集团与深圳报业集团深圳都市报联合','佳兆业集团与深圳报业集团深圳都市报联合','<p style=\"padding: 0px 0px 8px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; color: rgb(76, 76, 76); line-height: 30px; text-align: justify; font-family: SiyuanNormal, &quot;Microsoft Yahei&quot;, Arial, Simsun; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">这次由佳兆业集团与深圳报业集团深圳都市报联合推出的“Dapeng Plogging”2018年深圳潮酷慢跑公益行，结合了目前国内外社交网络爆红的“Plogging”慢跑捡垃圾形式，将“公益”“环保”“健身”合而为一，在运动的同时释放深圳市民的公益热情。活动从报名开始起，即得到了广大市民的积极响应，出于环保因素的考虑，最终从1000组家庭中随机抽选了100组家庭参加。</p><p style=\"padding: 0px 0px 8px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; color: rgb(76, 76, 76); line-height: 30px; text-align: justify; font-family: SiyuanNormal, &quot;Microsoft Yahei&quot;, Arial, Simsun; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">活动当日清晨，这100组队伍从深圳福田区出发，乘坐统一大巴来到大鹏玫瑰海岸。“我们有幸生活在一个有海的城市，海洋对我们都生活很重要。”活动启动仪式上，深圳报业集团深圳都市报总编辑表示，本次活动选址美丽的玫瑰海岸，以家庭为单位参与，就是希望通过这种“公益+环保+健身”的形式，“给孩子们的心里种下一颗公益心。”</p><p><br/></p>','超级管理员',1,1,'/uploads/20200601/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','',1,0,0,1591718472,1593306727),(9,2,'[新闻]重温红色经典 弘扬爱国精神','“这个是王泽英他们院子发生的事，居然都演到电影上了……”4月19日晚，由跳伞塔街道新南路社区居民自编自导的微电影《我们社区的故事》在辖区大学路举行首映，通过30分钟的影像直观地展现了社区日新月异的变化和居民们的真实生活，赢得了观众们热烈的掌声。','<p class=\"detail-text\" style=\"margin-top: 0px; margin-bottom: 0px; padding: 20px 0px 0px; list-style: none; border: 0px; line-height: 30px; font-family: &quot;Microsoft Yahei&quot;; white-space: normal; background-color: rgb(255, 255, 255);\">“这个是王泽英他们院子发生的事，居然都演到电影上了……”4月19日晚，由跳伞塔街道新南路社区居民自编自导的微电影《我们社区的故事》在辖区大学路举行首映，通过30分钟的影像直观地展现了社区日新月异的变化和居民们的真实生活，赢得了观众们热烈的掌声。<br/></p><h6 style=\"margin: 0px; padding: 20px 0px 0px; list-style: none; border: 0px; font-size: 18px; font-family: &quot;Microsoft Yahei&quot;; white-space: normal; background-color: rgb(255, 255, 255);\">想法源自社区需要<br/></h6><p class=\"detail-text\" style=\"margin-top: 0px; margin-bottom: 0px; padding: 20px 0px 0px; list-style: none; border: 0px; line-height: 30px; font-family: &quot;Microsoft Yahei&quot;; white-space: normal; background-color: rgb(255, 255, 255);\">　　把社区生活用影像记录下来的想法最开始来源于新南路社区的“现实需要”。因为工作忙碌，社区工作人员和家人的联系更多的是通过手机，推己及人，大家想到社区当中有很多家庭都面临着沟通不足的问题。<br/>　　2018年，在社区主任陈均的牵头下，新南路社区筹划了“亲子演播厅”文化项目。“社区中有很多老年人不会使用智能手机，也有很多人没有用手机记录生活的意识。为了让居民有能力接受、有意识接受，社区将工作分为教学与实践两个方面。一方面对社区中的居民进行手机拍摄教学，让不会拍的学会拍摄，让会拍摄的拍得更好。”陈均说，通过鼓励居民善于发现生活中的大小事，来记录社区的新生活。社区哪里的花开了、出了什么新举措，这些生活中的点点滴滴都在居民的手机中得到记录。<br/>　　用影像表达的方式服务社区，提升居民对社区的认同感、归属感，促进社区融合，陈均说：“要让每个人在社区都能获得自己的归属感。”<br/></p><h6 style=\"margin: 0px; padding: 20px 0px 0px; list-style: none; border: 0px; font-size: 18px; font-family: &quot;Microsoft Yahei&quot;; white-space: normal; background-color: rgb(255, 255, 255);\">社区牵头组织拍摄<br/></h6><p class=\"detail-text\" style=\"margin-top: 0px; margin-bottom: 0px; padding: 20px 0px 0px; list-style: none; border: 0px; line-height: 30px; font-family: &quot;Microsoft Yahei&quot;; white-space: normal; background-color: rgb(255, 255, 255);\">　　2018年底，社区着手准备微电影筹备事宜。为了影片呈现效果更加精致，社区找到专业的社会组织承接微电影项目，形成社区牵头、组织操作、居民参与的合作模式。<br/>　　剧本是拍摄计划的第一步，为了还原社区真实生活，社会组织负责人王利带领团队深入社区听居民讲述自己的故事。“艺术来源于生活，我们要拍真正的社区故事。这个剧本要由居民自己写。”深入调研社区情况后，社区和王利商量将剧本分成7个主题：革命军人、院落管家、志愿队、茶文化、声乐、剪纸和书法。<br/>　　参与院落管家拍摄部分的王泽英说：“我管理的院落是老院坝，问题多不好管。”王泽英把院落当中遇到的困难和问题讲给王利听，这些情况都写进了剧本里。<br/>　　敲定了剧本，接下来就是拍摄工作。不好拍是王利一开始就有的感觉，首先是时间上的冲突，参与拍摄的居民时间各异，为了将居民们的时间协调到一起，只能在周末拍摄。其次，镜头对于居民来说很陌生，原来用手机拍别人，现在是自己出现在屏幕上。第一次面对镜头，王泽英坦言：“心头慌，一对着镜头就说不出来。”为此，社区和社会组织经过商量，对居民进行基本的培训。<br/>　　从筹备到拍摄，共计花费4个月。首映那天，退伍老兵的浓浓爱国情，院落管家的默默付出，志愿队一次次不辞辛劳的服务，社区书法、声乐、茶艺、剪纸等自组织开展的精彩活动……这些平常小事打动着每位观影居民的心。“都是身边发生的人和事，看着就有感情。社区现在真的像家，我们都希望它变得更好。”居民刘晓华感慨道。<br/>　　华西社区报记者沈悦<br/>　　实习生王珊珊摄影报道</p><p><br/></p>','超级管理员',1,20,'/uploads/20200627/f4155c580dc4a0544609211b1680118f.jpg','',1,0,0,1591718486,1593307903),(10,2,'[新闻]社区故事汇 讲述身边的“老北京”','社区故事汇 讲述身边的“老北京”','<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial; white-space: normal; background-color: rgb(255, 255, 255);\"><span class=\"bjh-p\">时光中谈风物 胡同里述人情</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial; white-space: normal; background-color: rgb(255, 255, 255);\"><span class=\"bjh-p\">社区故事汇 讲述身边的“老北京”</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial; white-space: normal; background-color: rgb(255, 255, 255);\"><span class=\"bjh-p\">一品香澡堂承载着老北京人怎样的情怀？丰泽园的滋味如何几十年来让人念念不忘？“四大名旦”之师王瑶卿有哪些动人传说？每年一本，每本10个故事。数年下来，大栅栏街道石头社区的“胡同故事汇”已经出到了第三本。老字号变迁、历史知名人物、居民身边的凡人善举，这些充满京味底蕴的生动故事，都在“故事汇”中被挖掘、记录、保存并传扬。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial; white-space: normal; background-color: rgb(255, 255, 255);\"><span class=\"bjh-p\">忆</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial; white-space: normal; background-color: rgb(255, 255, 255);\"><span class=\"bjh-p\">一顿“丰泽园” 好吃的感觉记了60年</span></p><p><br/></p>','超级管理员',1,2,'/uploads/20200626/91280c434dd39b1af6144d55f3afd959.jpeg','',0,0,0,1591718502,1593307944),(11,1,'[公告]2018深圳潮酷慢跑公益行登陆大鹏玫瑰海岸','你知道吗？每分钟','<p style=\"padding: 0px 0px 8px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; color: rgb(76, 76, 76); line-height: 30px; text-align: justify; font-family: SiyuanNormal, &quot;Microsoft Yahei&quot;, Arial, Simsun; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">你知道吗？每分钟，全球就会卖出约100万个塑料瓶；每年，有1300万吨塑料垃圾流入海洋。在客流量极大的海边沙滩，就是垃圾流入海洋的重灾区。</p><p style=\"padding: 0px 0px 8px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; color: rgb(76, 76, 76); line-height: 30px; text-align: justify; font-family: SiyuanNormal, &quot;Microsoft Yahei&quot;, Arial, Simsun; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">10月27日，一种起源于瑞典的新潮公益运动，来到深圳大鹏玫瑰海岸。“2018深圳大鹏国际户外嘉年华”之“Dapeng Plogging”2018深圳潮酷慢跑公益行活动温情启幕，200位市民在海滩慢跑的同时，随手拾起垃圾，并通过活动设置的打卡游戏完成环保公益任务，赢取最终的惊喜奖品。</p><p style=\"padding: 0px 0px 8px; margin-top: 0px; margin-bottom: 0px; font-size: 14px; color: rgb(76, 76, 76); line-height: 30px; text-align: justify; font-family: SiyuanNormal, &quot;Microsoft Yahei&quot;, Arial, Simsun; text-indent: 28px; white-space: normal; background-color: rgb(255, 255, 255);\">据了解，本次活动是国内最大户外运动节——“2018深圳大鹏国际户外嘉年华”的重要活动之一。本届嘉年华是在深圳市文体旅游局、深圳市大鹏新区管理委员会的指导下，在深圳市大鹏新区文体旅游局的支持下，由佳兆业集团控股有限公司主办，佳兆业文体集团、佳兆业国际乐园集团承办的大文旅IP落地实践项目，受到各界高度关注。</p><p><br/></p>','超级管理员',1,1,'','',0,0,0,1593264922,1593306601),(12,3,'[故事]老百姓的事，再小都是大事','他是社区群众的“贴心人”，是同事眼中的“工作狂”。高高大大的小伙子，被大家亲切地称为“小王警官”','<p><span style=\"color: rgb(25, 25, 25); font-family: &quot;PingFang SC&quot;, Arial, 微软雅黑, 宋体, simsun, sans-serif; background-color: rgb(255, 255, 255);\">他是社区群众的“贴心人”，是同事眼中的“工作狂”。高高大大的小伙子，被大家亲切地称为“小王警官”</span></p>','超级管理员',1,8,'','',1,1,0,1593265394,1593306642),(13,2,'[新闻]俄媒：世界经济在疫情中转型','俄媒：世界经济在疫情中转型','<p style=\"margin-top: 0px; margin-bottom: 18px; padding: 0px; color: rgb(77, 79, 83); font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;\\\\5FAE软雅黑&quot;, SimSun, &quot;\\\\5B8B体&quot;, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal; background-color: rgb(255, 255, 255);\">原标题：俄媒：世界经济在疫情中转型</p><p style=\"margin-top: 0px; margin-bottom: 18px; padding: 0px; font-size: 18px; color: rgb(77, 79, 83); font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;\\\\5FAE软雅黑&quot;, SimSun, &quot;\\\\5B8B体&quot;, Arial; letter-spacing: 1px; white-space: normal; background-color: rgb(255, 255, 255);\">　　<span style=\"\">参考消息网6月28日报道</span>&nbsp;俄罗斯今日经济网6月18日的报道称，第二波新冠疫情将导致世界经济转型。</p><p style=\"margin-top: 0px; margin-bottom: 18px; padding: 0px; font-size: 18px; color: rgb(77, 79, 83); font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;\\\\5FAE软雅黑&quot;, SimSun, &quot;\\\\5B8B体&quot;, Arial; letter-spacing: 1px; white-space: normal; background-color: rgb(255, 255, 255);\">　　俄罗斯普列汉诺夫经济大学金融管理教研室教授康斯坦丁·奥尔多夫对今日经济网表示，世界经济数字化转型——转而采用新的技术、工业和商业模式——的过程中少不了一场大灾难。</p><p style=\"margin-top: 0px; margin-bottom: 18px; padding: 0px; font-size: 18px; color: rgb(77, 79, 83); font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;\\\\5FAE软雅黑&quot;, SimSun, &quot;\\\\5B8B体&quot;, Arial; letter-spacing: 1px; white-space: normal; background-color: rgb(255, 255, 255);\">　　奥尔多夫在谈到全球新一波新冠疫情的威胁时指出，在油价跌到负数之后，很难再有什么事能吓到各国了。</p><p style=\"margin-top: 0px; margin-bottom: 18px; padding: 0px; font-size: 18px; color: rgb(77, 79, 83); font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;\\\\5FAE软雅黑&quot;, SimSun, &quot;\\\\5B8B体&quot;, Arial; letter-spacing: 1px; white-space: normal; background-color: rgb(255, 255, 255);\">　　这位专家发表评论说：“当然，新冠病毒再度传播首先将对世界经济产生负面影响。如今，我们看到没有任何担保的股票增发活动和证券市场的不良现状。公司虽然市值很高，但大家都清楚上一波疫情对现金流和利润造成的影响，对未来的冲击也心里有数。准确结果将在财报发布期见分晓。”</p><p><br/></p>','超级管理员',1,2,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','',0,0,0,1593326351,1593326385),(14,2,'[新闻]北京本轮疫情排除动物病毒外溢','北京本轮疫情排除动物病毒外溢','<p><span style=\"font-family: &quot;Microsoft Yahei&quot;, 微软雅黑, &quot;STHeiti Light&quot;, 华文细黑, SimSun, 宋体, Arial, sans-serif; font-size: 18px; letter-spacing: 1px;\">&nbsp;本报讯（记者刘欢）中国疾病预防控制中心昨天公布了《2020年6月北京新型冠状病毒肺炎疫情进展》，其中病毒来源分析中指出，从2例确诊病例及北京新发地批发市场环境采集的标本中获得的3株病毒基因分析显示，北京本次疫情流行的新冠病毒为L基因型欧洲家系分支Ⅰ，该毒株比当前欧洲流行同型毒株更“老”；可以排除由动物病毒外溢传染人，也排除今年4月前北京本地传播毒株或武汉流行毒株导致本次疫情。</span></p>','超级管理员',1,0,'/uploads/20200628/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','',0,0,0,1593326420,1593326441),(15,2,'[新闻]美国号称“医疗领先” 缘何疫情反加重?','美国号称“医疗领先” 缘何疫情反加重?','<p><span style=\"color: rgb(51, 51, 51); font-family: PingFangSC-Regular, Helvetica, Arial, &quot;Microsoft Yahei&quot;, sans-serif; font-size: 18px; text-indent: 36px; background-color: rgb(255, 255, 255);\">画面中的女孩是卡森·戴维斯，上周日她被送进了重症监护室，这一天她刚满17岁。她的姐妹写道：“卡森可怜的身体已经没有抗争的能力了。”最终，她死于新冠病毒感染引发的并发症，有着类似遭遇的美国年轻人正越来越多。</span></p>','超级管理员',1,1,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','',0,0,0,1593326502,1593326525),(16,2,'[新闻]微信小程序图片上传组件','微信小程序图片上传组件','<p>根据已选择的图片临时路径数组展示图片<code>wx:for=&quot;{{uploaderList}}&quot;</code><br/>删除icon上挂载data数据用来删除指定图片<code>data-index=&quot;{{index}}&quot;</code><br/>图片上挂载data数据用来点击放大展示图片<code>data-index=&quot;{{index}}&quot;</code><br/>根据已选图片个数判断是否可继续上传<code>wx:if=&quot;{{showUpload}}&quot;</code></p><p><br/></p>','超级管理员',1,1,'/uploads/20200628/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','',0,0,0,1593326557,1593326568),(17,2,'[新闻]page方法主要用于分页查询','page方法主要用于分页查询','<p><span style=\"color: rgb(82, 82, 82); font-family: &quot;Helvetica Neue&quot;, NotoSansHans-Regular, AvenirNext-Regular, arial, &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;WenQuanYi Micro Hei&quot;, serif; font-size: 15px; background-color: rgb(255, 255, 255);\">我们在前面已经了解了关于limit方法用于</span><span class=\"highlight\" style=\"box-sizing: inherit; -webkit-tap-highlight-color: transparent; text-size-adjust: none; -webkit-font-smoothing: antialiased; background-color: rgb(255, 255, 0); color: rgb(82, 82, 82); font-family: &quot;Helvetica Neue&quot;, NotoSansHans-Regular, AvenirNext-Regular, arial, &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;WenQuanYi Micro Hei&quot;, serif; font-size: 15px;\">分页</span><span style=\"color: rgb(82, 82, 82); font-family: &quot;Helvetica Neue&quot;, NotoSansHans-Regular, AvenirNext-Regular, arial, &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;WenQuanYi Micro Hei&quot;, serif; font-size: 15px; background-color: rgb(255, 255, 255);\">查询的情况，而page方法则是更人性化的进行</span><span class=\"highlight\" style=\"box-sizing: inherit; -webkit-tap-highlight-color: transparent; text-size-adjust: none; -webkit-font-smoothing: antialiased; background-color: rgb(255, 255, 0); color: rgb(82, 82, 82); font-family: &quot;Helvetica Neue&quot;, NotoSansHans-Regular, AvenirNext-Regular, arial, &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;WenQuanYi Micro Hei&quot;, serif; font-size: 15px;\">分页</span><span style=\"color: rgb(82, 82, 82); font-family: &quot;Helvetica Neue&quot;, NotoSansHans-Regular, AvenirNext-Regular, arial, &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;WenQuanYi Micro Hei&quot;, serif; font-size: 15px; background-color: rgb(255, 255, 255);\">查询的方法，例如还是以文章列表</span><span class=\"highlight\" style=\"box-sizing: inherit; -webkit-tap-highlight-color: transparent; text-size-adjust: none; -webkit-font-smoothing: antialiased; background-color: rgb(255, 255, 0); color: rgb(82, 82, 82); font-family: &quot;Helvetica Neue&quot;, NotoSansHans-Regular, AvenirNext-Regular, arial, &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;WenQuanYi Micro Hei&quot;, serif; font-size: 15px;\">分页</span><span style=\"color: rgb(82, 82, 82); font-family: &quot;Helvetica Neue&quot;, NotoSansHans-Regular, AvenirNext-Regular, arial, &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, &quot;WenQuanYi Micro Hei&quot;, serif; font-size: 15px; background-color: rgb(255, 255, 255);\">为例来说，如果使用limit方法，我们要查询第一页和第二页（假设我们每页输出10条数据）写法如下：</span></p>','超级管理员',1,0,'/uploads/20200626/3337b4af9ba2a8738c9d6aceac9d6f4a.jpg','',0,0,0,1593327943,1593327953),(18,2,'[新闻]模型查询page怎么获取总页数或者记录数呢','模型查询page怎么获取总页数或者记录数呢','<p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(77, 77, 77); line-height: 26px; overflow-x: auto; overflow-wrap: break-word; white-space: normal; background-color: rgb(255, 255, 255);\">page方法也是模型的连贯操作方法之一，是完全为<span class=\"highlight\" style=\"box-sizing: border-box; outline: 0px; margin: 0px; padding: 0px; overflow-wrap: break-word;\">分页</span>查询而诞生的一个人性化操作方法。</p><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(77, 77, 77); line-height: 26px; overflow-x: auto; overflow-wrap: break-word; white-space: normal; background-color: rgb(255, 255, 255);\">我们在前面已经了解了关于limit方法用于<span class=\"highlight\" style=\"box-sizing: border-box; outline: 0px; margin: 0px; padding: 0px; overflow-wrap: break-word;\">分页</span>查询的情况，而page方法则是更人性化的进行<span class=\"highlight\" style=\"box-sizing: border-box; outline: 0px; margin: 0px; padding: 0px; overflow-wrap: break-word;\">分页</span>查询的方法，例如还是以文章列表<span class=\"highlight\" style=\"box-sizing: border-box; outline: 0px; margin: 0px; padding: 0px; overflow-wrap: break-word;\">分页</span>为例来说，如果使用limit方法，我们要查询第一页和第二页（假设我们每页输出10条数据）写法如下：</p><pre style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 24px; padding: 8px; position: relative; font-family: Consolas, Inconsolata, Courier, monospace; white-space: pre-wrap; overflow-wrap: break-word; overflow-x: auto; font-size: 14px; line-height: 22px; background-image: none; background-position: 0% 0%; background-repeat: repeat; background-attachment: scroll; background-color: rgb(249, 250, 250); border: 1px solid rgb(222, 217, 217);\">//&nbsp;查询第一页数据Db::table(&#39;think_article&#39;)-&gt;limit(&#39;0,10&#39;)-&gt;select();//&nbsp;查询第二页数据Db::table(&#39;think_article&#39;)-&gt;limit(&#39;10,10&#39;)-&gt;select();</pre><p style=\"box-sizing: border-box; outline: 0px; margin-top: 0px; margin-bottom: 16px; padding: 0px; font-family: &quot;Microsoft YaHei&quot;, &quot;SF Pro Display&quot;, Roboto, Noto, Arial, &quot;PingFang SC&quot;, sans-serif; color: rgb(77, 77, 77); line-height: 26px; overflow-x: auto; overflow-wrap: break-word; white-space: normal; background-color: rgb(255, 255, 255);\">虽然利用扩展类库中的<span class=\"highlight\" style=\"box-sizing: border-box; outline: 0px; margin: 0px; padding: 0px; overflow-wrap: break-word;\">分页</span>类Page可以自动计算出每个<span class=\"highlight\" style=\"box-sizing: border-box; outline: 0px; margin: 0px; padding: 0px; overflow-wrap: break-word;\">分页</span>的limit参数，但是如果要自己写就比较费力了，如果用page方法来写则简单多了，例如：</p><p><br/></p>','超级管理员',1,5,'/uploads/20200626/3337b4af9ba2a8738c9d6aceac9d6f4a.jpg','/uploads/20200626/1f0ab8e428b0fd113cf8f8bdc8ef4d7a.png',1,0,0,1593331943,1593332037);
/*!40000 ALTER TABLE `es_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_attachment`
--

DROP TABLE IF EXISTS `es_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_attachment` (
  `id` int unsigned NOT NULL COMMENT 'ID',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '物理路径',
  `imagewidth` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '宽度',
  `imageheight` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '宽度',
  `imagetype` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片类型',
  `imageframes` int unsigned NOT NULL COMMENT '图片帧数',
  `filesize` int unsigned NOT NULL COMMENT '文件大小',
  `mimetype` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'mime类型',
  `extparam` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '透传数据',
  `create_time` int unsigned NOT NULL COMMENT '创建日期',
  `update_time` int unsigned NOT NULL COMMENT '更新时间',
  `upload_time` int unsigned NOT NULL COMMENT '上传时间',
  `storage` enum('local','upyun','qiniu') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'local' COMMENT '存储位置',
  `sha1` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '文件 sha1编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='附件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_attachment`
--

LOCK TABLES `es_attachment` WRITE;
/*!40000 ALTER TABLE `es_attachment` DISABLE KEYS */;
INSERT INTO `es_attachment` VALUES (1,'/assets/img/qrcode.png','150','150','png',0,21859,'image/png','',1499681848,1499681848,1499681848,'local','17163603d0263e4838b9387ff2cd4877e8b018f6'),(2,'/uploads/20200114/3cf138b9a018232d4f4a0cb04ce5331d.png','1317','744','png',0,176364,'image/png','',1578994299,1578994299,1578994299,'local','9b07a44dbf2a7f24d93a187093d1e7e08c4236f8'),(3,'/uploads/20200601/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','144','144','png',0,5739,'image/png','',1590940940,1590940940,1590940940,'local','9bb50dccbc0b26292516451a0bc75a87e20d1030'),(4,'/uploads/20200601/abc5bb17ade50895b6a9cc4fa3929349.jpg','750','1204','jpg',0,172379,'image/jpeg','',1591026780,1591026780,1591026780,'local','9c972ab9ac13f5fb70fb10a3ae38f306ae4c9356'),(5,'/uploads/20200625/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','144','144','png',0,5739,'image/png','',1593071520,1593071520,1593071520,'local','9bb50dccbc0b26292516451a0bc75a87e20d1030'),(6,'/uploads/20200625/91280c434dd39b1af6144d55f3afd959.jpeg','1006','1790','jpeg',0,356165,'image/jpeg','',1593071801,1593071801,1593071801,'local','6fedaf71e1dda566d262e7c09328c8776db9e5f4'),(7,'/uploads/20200626/91280c434dd39b1af6144d55f3afd959.jpeg','1006','1790','jpeg',0,356165,'image/jpeg','',1593158321,1593158321,1593158321,'local','6fedaf71e1dda566d262e7c09328c8776db9e5f4'),(8,'/uploads/20200626/d0227b2e390cae6314838f5f520fd2b1.jpg','288','180','jpg',0,73802,'image/jpeg','',1593163895,1593163895,1593163895,'local','5deb80d17eac60b2f2087da4d886a32b06846098'),(9,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','200','200','jpg',0,13867,'image/jpeg','',1593163930,1593163930,1593163930,'local','ff910d71a25aca1959cf35543a865ce34de77851'),(10,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','200','200','jpg',0,13867,'image/jpeg','',1593164227,1593164227,1593164227,'local','ff910d71a25aca1959cf35543a865ce34de77851'),(11,'/uploads/20200626/23151eec6fb4be1d8edfefb8df697e2f.png','210','210','png',0,3720,'image/png','',1593164884,1593164884,1593164884,'local','bd605666032dcc8cbe4f59836bd4a9fc0250ff08'),(12,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','200','200','jpg',0,13867,'image/jpeg','',1593165270,1593165270,1593165270,'local','ff910d71a25aca1959cf35543a865ce34de77851'),(13,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','200','200','jpg',0,13867,'image/jpeg','',1593165495,1593165495,1593165495,'local','ff910d71a25aca1959cf35543a865ce34de77851'),(14,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','200','200','jpg',0,13867,'image/jpeg','',1593165638,1593165638,1593165638,'local','ff910d71a25aca1959cf35543a865ce34de77851'),(15,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','200','200','jpg',0,13867,'image/jpeg','',1593166552,1593166552,1593166552,'local','ff910d71a25aca1959cf35543a865ce34de77851'),(16,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','200','200','jpg',0,13867,'image/jpeg','',1593168563,1593168563,1593168563,'local','ff910d71a25aca1959cf35543a865ce34de77851'),(17,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','200','200','jpg',0,13867,'image/jpeg','',1593168574,1593168574,1593168574,'local','ff910d71a25aca1959cf35543a865ce34de77851'),(18,'/uploads/20200626/3337b4af9ba2a8738c9d6aceac9d6f4a.jpg','210','210','jpg',0,20730,'image/jpeg','',1593168632,1593168632,1593168632,'local','f3039faaf47a1d39d9cd74434a52f43c4fa28df9'),(19,'/uploads/20200626/d460b0839dc67ad78f003443fc5fe2fd.png','26','24','png',0,589,'image/png','',1593168722,1593168722,1593168722,'local','3845c68450dc27a5e42e0b88979d3c945c776099'),(20,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','200','200','jpg',0,13867,'image/jpeg','',1593168761,1593168761,1593168761,'local','ff910d71a25aca1959cf35543a865ce34de77851'),(21,'/uploads/20200626/f4155c580dc4a0544609211b1680118f.jpg','80','80','jpg',0,22071,'image/jpeg','',1593168833,1593168833,1593168833,'local','c254d4acfbe7017e87f9a310001f07b1346e7996'),(22,'/uploads/20200626/1f0ab8e428b0fd113cf8f8bdc8ef4d7a.png','26','24','png',0,558,'image/png','',1593168883,1593168883,1593168883,'local','cdb50597620a7348c56a5a8f848d9d5a89bad3bb'),(23,'/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg','200','200','jpg',0,13867,'image/jpeg','',1593169053,1593169053,1593169053,'local','ff910d71a25aca1959cf35543a865ce34de77851'),(24,'/uploads/20200626/1f0ab8e428b0fd113cf8f8bdc8ef4d7a.png','26','24','png',0,558,'image/png','',1593169161,1593169161,1593169161,'local','cdb50597620a7348c56a5a8f848d9d5a89bad3bb'),(25,'/uploads/20200626/001f7faf2ead8b1e4c67cf983b9c5eb0.png','25','25','png',0,653,'image/png','',1593169201,1593169201,1593169201,'local','b7c9f8a7d23ffd60d73f0294aa4e051014d2a1df'),(26,'/uploads/20200626/3337b4af9ba2a8738c9d6aceac9d6f4a.jpg','210','210','jpg',0,20730,'image/jpeg','',1593171600,1593171600,1593171600,'local','f3039faaf47a1d39d9cd74434a52f43c4fa28df9'),(27,'/uploads/20200627/f4155c580dc4a0544609211b1680118f.jpg','80','80','jpg',0,22071,'image/jpeg','',1593239767,1593239767,1593239767,'local','c254d4acfbe7017e87f9a310001f07b1346e7996'),(28,'/uploads/20200628/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','144','144','png',0,5739,'image/png','',1593310036,1593310036,1593310036,'local','9bb50dccbc0b26292516451a0bc75a87e20d1030'),(29,'/uploads/20210201/d0227b2e390cae6314838f5f520fd2b1.jpg','288','180','jpg',0,73802,'image/jpeg','',1612189656,1612189656,1612189656,'local','5deb80d17eac60b2f2087da4d886a32b06846098');
/*!40000 ALTER TABLE `es_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_auth_group`
--

DROP TABLE IF EXISTS `es_auth_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_auth_group` (
  `id` int unsigned NOT NULL,
  `pid` int unsigned NOT NULL COMMENT '父组别',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '组名',
  `rules` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '规则ID',
  `createtime` int unsigned NOT NULL COMMENT '创建时间',
  `updatetime` int unsigned NOT NULL COMMENT '更新时间',
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='分组表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_auth_group`
--

LOCK TABLES `es_auth_group` WRITE;
/*!40000 ALTER TABLE `es_auth_group` DISABLE KEYS */;
INSERT INTO `es_auth_group` VALUES (1,0,'超级管理员','*',1490883540,149088354,'normal'),(2,1,'小区管理员','13,14,16,15,17,582,583,584,585,586,600,601,602,603,605,606,607,608,611,612,613,614,616,617,618,619,621,622,623,624,627,628,629,630,632,633,634,635,660,661,662,663,664,666,667,668,669,670,672,673,674,675,676,678,679,680,681,682,684,685,686,687,688,589,590,591,592,594,595,596,597,690,691,692,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,105,106,107,108,109,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,3,1,9,10,11,12,5,7,6,8,4,581,588,593,587,599,604,598,610,615,104,2,620,609,626,631,625,659,665,671,677,658,683,689',1490883540,1578993943,'normal'),(3,2,'小区普通员工','',1509948028,1509948028,'normal'),(4,2,'业主','658,659,660,664,665,666,667,668,669,670,671,672,673,674,675,676,677,678,679,680,681,682',1510275700,1510797745,'normal');
/*!40000 ALTER TABLE `es_auth_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_auth_group_access`
--

DROP TABLE IF EXISTS `es_auth_group_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_auth_group_access` (
  `uid` int unsigned NOT NULL COMMENT '会员ID',
  `group_id` int unsigned NOT NULL COMMENT '级别ID',
  UNIQUE KEY `uid_group_id` (`uid`,`group_id`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE,
  KEY `group_id` (`group_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='权限分组表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_auth_group_access`
--

LOCK TABLES `es_auth_group_access` WRITE;
/*!40000 ALTER TABLE `es_auth_group_access` DISABLE KEYS */;
INSERT INTO `es_auth_group_access` VALUES (1,1),(2,2),(3,4);
/*!40000 ALTER TABLE `es_auth_group_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_auth_rule`
--

DROP TABLE IF EXISTS `es_auth_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_auth_rule` (
  `id` int unsigned NOT NULL,
  `type` enum('menu','file') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'file' COMMENT 'menu为菜单,file为权限节点',
  `pid` int unsigned NOT NULL COMMENT '父ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '规则名称',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '规则名称',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图标',
  `condition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '条件',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `ismenu` tinyint unsigned NOT NULL COMMENT '是否为菜单',
  `createtime` int unsigned NOT NULL COMMENT '创建时间',
  `updatetime` int unsigned NOT NULL COMMENT '更新时间',
  `weigh` int NOT NULL DEFAULT '0' COMMENT '权重',
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE,
  KEY `pid` (`pid`) USING BTREE,
  KEY `weigh` (`weigh`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='节点表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_auth_rule`
--

LOCK TABLES `es_auth_rule` WRITE;
/*!40000 ALTER TABLE `es_auth_rule` DISABLE KEYS */;
INSERT INTO `es_auth_rule` VALUES (1,'file',0,'dashboard','Dashboard','fa fa-dashboard\r','','Dashboard tips',1,1497429920,1497429920,201,'normal'),(2,'file',0,'general','General','fa fa-cogs','','',1,1497429920,1497430169,137,'normal'),(3,'file',0,'category','Category','fa fa-list','','Category tips',1,1497429920,1578994071,119,'normal'),(4,'file',0,'addon','Addon','fa fa-rocket','','Addon tips',1,1502035509,1578994078,0,'normal'),(5,'file',0,'auth','Auth','fa fa-group','','',1,1497429920,1497430092,99,'normal'),(6,'file',2,'general/config','Config','fa fa-cog','','Config tips',1,1497429920,1497430683,60,'normal'),(7,'file',2,'general/attachment','Attachment','fa fa-file-image-o','','Attachment tips',1,1497429920,1497430699,53,'normal'),(8,'file',2,'general/profile','Profile','fa fa-user\r','','',1,1497429920,1497429920,34,'normal'),(9,'file',5,'auth/admin','Operator','fa fa-user','','Admin tips',1,1497429920,1497430320,118,'normal'),(10,'file',5,'auth/adminlog','Operator log','fa fa-list-alt','','Admin log tips',1,1497429920,1497430307,113,'normal'),(11,'file',5,'auth/group','Group','fa fa-group','','Group tips',1,1497429920,1497429920,109,'normal'),(12,'file',5,'auth/rule','Rule','fa fa-bars','','Rule tips',1,1497429920,1497430581,104,'normal'),(13,'file',1,'dashboard/index','View','fa fa-circle-o','','',0,1497429920,1497429920,136,'normal'),(14,'file',1,'dashboard/add','Add','fa fa-circle-o','','',0,1497429920,1497429920,135,'normal'),(15,'file',1,'dashboard/del','Delete','fa fa-circle-o','','',0,1497429920,1497429920,133,'normal'),(16,'file',1,'dashboard/edit','Edit','fa fa-circle-o','','',0,1497429920,1497429920,134,'normal'),(17,'file',1,'dashboard/multi','Multi','fa fa-circle-o','','',0,1497429920,1497429920,132,'normal'),(18,'file',6,'general/config/index','View','fa fa-circle-o','','',0,1497429920,1497429920,52,'normal'),(19,'file',6,'general/config/add','Add','fa fa-circle-o','','',0,1497429920,1497429920,51,'normal'),(20,'file',6,'general/config/edit','Edit','fa fa-circle-o','','',0,1497429920,1497429920,50,'normal'),(21,'file',6,'general/config/del','Delete','fa fa-circle-o','','',0,1497429920,1497429920,49,'normal'),(22,'file',6,'general/config/multi','Multi','fa fa-circle-o','','',0,1497429920,1497429920,48,'normal'),(23,'file',7,'general/attachment/index','View','fa fa-circle-o','','',0,1497429920,1497429920,59,'normal'),(24,'file',7,'general/attachment/select','Select attachment','fa fa-circle-o','','',0,1497429920,1497429920,58,'normal'),(25,'file',7,'general/attachment/add','Add','fa fa-circle-o','','',0,1497429920,1497429920,57,'normal'),(26,'file',7,'general/attachment/edit','Edit','fa fa-circle-o','','',0,1497429920,1497429920,56,'normal'),(27,'file',7,'general/attachment/del','Delete','fa fa-circle-o','','',0,1497429920,1497429920,55,'normal'),(28,'file',7,'general/attachment/multi','Multi','fa fa-circle-o','','',0,1497429920,1497429920,54,'normal'),(29,'file',8,'general/profile/index','View','fa fa-circle-o','','',0,1497429920,1497429920,33,'normal'),(30,'file',8,'general/profile/update','Update profile','fa fa-circle-o','','',0,1497429920,1497429920,32,'normal'),(31,'file',8,'general/profile/add','Add','fa fa-circle-o','','',0,1497429920,1497429920,31,'normal'),(32,'file',8,'general/profile/edit','Edit','fa fa-circle-o','','',0,1497429920,1497429920,30,'normal'),(33,'file',8,'general/profile/del','Delete','fa fa-circle-o','','',0,1497429920,1497429920,29,'normal'),(34,'file',8,'general/profile/multi','Multi','fa fa-circle-o','','',0,1497429920,1497429920,28,'normal'),(35,'file',3,'category/index','View','fa fa-circle-o','','',0,1497429920,1497429920,142,'hidden'),(36,'file',3,'category/add','Add','fa fa-circle-o','','',0,1497429920,1497429920,141,'hidden'),(37,'file',3,'category/edit','Edit','fa fa-circle-o','','',0,1497429920,1497429920,140,'hidden'),(38,'file',3,'category/del','Delete','fa fa-circle-o','','',0,1497429920,1497429920,139,'hidden'),(39,'file',3,'category/multi','Multi','fa fa-circle-o','','',0,1497429920,1497429920,138,'hidden'),(40,'file',9,'auth/admin/index','View','fa fa-circle-o','','',0,1497429920,1497429920,117,'normal'),(41,'file',9,'auth/admin/add','Add','fa fa-circle-o','','',0,1497429920,1497429920,116,'normal'),(42,'file',9,'auth/admin/edit','Edit','fa fa-circle-o','','',0,1497429920,1497429920,115,'normal'),(43,'file',9,'auth/admin/del','Delete','fa fa-circle-o','','',0,1497429920,1497429920,114,'normal'),(44,'file',10,'auth/adminlog/index','View','fa fa-circle-o','','',0,1497429920,1497429920,112,'normal'),(45,'file',10,'auth/adminlog/detail','Detail','fa fa-circle-o','','',0,1497429920,1497429920,111,'normal'),(46,'file',10,'auth/adminlog/del','Delete','fa fa-circle-o','','',0,1497429920,1497429920,110,'normal'),(47,'file',11,'auth/group/index','View','fa fa-circle-o','','',0,1497429920,1497429920,108,'normal'),(48,'file',11,'auth/group/add','Add','fa fa-circle-o','','',0,1497429920,1497429920,107,'normal'),(49,'file',11,'auth/group/edit','Edit','fa fa-circle-o','','',0,1497429920,1497429920,106,'normal'),(50,'file',11,'auth/group/del','Delete','fa fa-circle-o','','',0,1497429920,1497429920,105,'normal'),(51,'file',12,'auth/rule/index','View','fa fa-circle-o','','',0,1497429920,1497429920,103,'normal'),(52,'file',12,'auth/rule/add','Add','fa fa-circle-o','','',0,1497429920,1497429920,102,'normal'),(53,'file',12,'auth/rule/edit','Edit','fa fa-circle-o','','',0,1497429920,1497429920,101,'normal'),(54,'file',12,'auth/rule/del','Delete','fa fa-circle-o','','',0,1497429920,1497429920,100,'normal'),(55,'file',4,'addon/index','View','fa fa-circle-o','','',0,1502035509,1502035509,0,'normal'),(56,'file',4,'addon/add','Add','fa fa-circle-o','','',0,1502035509,1502035509,0,'normal'),(57,'file',4,'addon/edit','Edit','fa fa-circle-o','','',0,1502035509,1502035509,0,'normal'),(58,'file',4,'addon/del','Delete','fa fa-circle-o','','',0,1502035509,1502035509,0,'normal'),(59,'file',4,'addon/local','Local install','fa fa-circle-o','','',0,1502035509,1502035509,0,'normal'),(60,'file',4,'addon/state','Update state','fa fa-circle-o','','',0,1502035509,1502035509,0,'normal'),(61,'file',4,'addon/install','Install','fa fa-circle-o','','',0,1502035509,1502035509,0,'normal'),(62,'file',4,'addon/uninstall','Uninstall','fa fa-circle-o','','',0,1502035509,1502035509,0,'normal'),(63,'file',4,'addon/config','Setting','fa fa-circle-o','','',0,1502035509,1502035509,0,'normal'),(64,'file',4,'addon/refresh','Refresh','fa fa-circle-o','','',0,1502035509,1502035509,0,'normal'),(65,'file',4,'addon/multi','Multi','fa fa-circle-o','','',0,1502035509,1502035509,0,'normal'),(104,'file',2,'general/crontab','定时任务','fa fa-tasks','','类似于Linux的Crontab定时任务,可以按照设定的时间进行任务的执行,目前仅支持三种任务:请求URL、执行SQL、执行Shell',1,1505542785,1505542785,0,'normal'),(105,'file',104,'general/crontab/index','查看','fa fa-circle-o','','',0,1505542785,1505542785,0,'normal'),(106,'file',104,'general/crontab/add','添加','fa fa-circle-o','','',0,1505542785,1505542785,0,'normal'),(107,'file',104,'general/crontab/edit','编辑 ','fa fa-circle-o','','',0,1505542785,1505542785,0,'normal'),(108,'file',104,'general/crontab/del','删除','fa fa-circle-o','','',0,1505542785,1505542785,0,'normal'),(109,'file',104,'general/crontab/multi','批量更新','fa fa-circle-o','','',0,1505542785,1505542785,0,'normal'),(581,'file',0,'community/index','小区管理','fa fa-list-alt','','用于展示小区列表信息，以及增加、修改、删除等操作',1,1509669650,1509669650,200,'normal'),(582,'file',581,'community/index/index','查看','fa fa-circle-o','','',0,1509669650,1509669650,0,'normal'),(583,'file',581,'community/index/detail','详情','fa fa-circle-o','','',0,1509669650,1509669650,0,'normal'),(584,'file',581,'community/index/add','添加','fa fa-circle-o','','',0,1509669650,1509669650,0,'normal'),(585,'file',581,'community/index/edit','修改','fa fa-circle-o','','',0,1509669650,1509669650,0,'normal'),(586,'file',581,'community/index/del','删除','fa fa-circle-o','','',0,1509669650,1509669650,0,'normal'),(587,'file',0,'expenses','收费管理','fa fa-usd','','',1,1509669659,1509669659,194,'normal'),(588,'file',587,'expenses/index','收费明细管理','fa fa-list-alt','','用于展示物业收费明细列表信息，以及增加、修改、删除等操作',1,1509669659,1509669659,2,'normal'),(589,'file',588,'expenses/index/index','查看','fa fa-circle-o','','',0,1509669659,1509669659,0,'normal'),(590,'file',588,'expenses/index/add','添加','fa fa-circle-o','','',0,1509669659,1509669659,0,'normal'),(591,'file',588,'expenses/index/edit','修改','fa fa-circle-o','','',0,1509669659,1509669659,0,'normal'),(592,'file',588,'expenses/index/del','删除','fa fa-circle-o','','',0,1509669659,1509669659,0,'normal'),(593,'file',587,'expenses/project','收费项目管理','fa fa-list-alt','','用于展示收费项目列表信息，以及增加、修改、删除等操作',1,1509669659,1509669659,1,'normal'),(594,'file',593,'expenses/project/index','查看','fa fa-circle-o','','',0,1509669659,1509669659,0,'normal'),(595,'file',593,'expenses/project/add','添加','fa fa-circle-o','','',0,1509669659,1509669659,0,'normal'),(596,'file',593,'expenses/project/edit','修改','fa fa-circle-o','','',0,1509669659,1509669659,0,'normal'),(597,'file',593,'expenses/project/del','删除','fa fa-circle-o','','',0,1509669659,1509669659,0,'normal'),(598,'file',0,'house','房产管理','fa fa-home','','',1,1509669664,1509669664,199,'normal'),(599,'file',598,'house/index','房产管理','fa fa-list-alt','','用于展示房产列表信息，以户为单位',1,1509669664,1509669664,2,'normal'),(600,'file',599,'house/index/index','查看','fa fa-circle-o','','',0,1509669664,1509669664,0,'normal'),(601,'file',599,'house/index/add','添加','fa fa-circle-o','','',0,1509669664,1509669664,0,'normal'),(602,'file',599,'house/index/edit','修改','fa fa-circle-o','','',0,1509669664,1509669664,0,'normal'),(603,'file',599,'house/index/del','删除','fa fa-circle-o','','',0,1509669664,1509669664,0,'normal'),(604,'file',598,'house/building','栋数管理','fa fa-list-alt','','用于展示小区里每一栋的基础信息',1,1509669664,1509669664,1,'normal'),(605,'file',604,'house/building/index','查看','fa fa-circle-o','','',0,1509669664,1509669664,0,'normal'),(606,'file',604,'house/building/add','添加','fa fa-circle-o','','',0,1509669664,1509669664,0,'normal'),(607,'file',604,'house/building/edit','修改','fa fa-circle-o','','',0,1509669664,1509669664,0,'normal'),(608,'file',604,'house/building/del','删除','fa fa-circle-o','','',0,1509669664,1509669664,0,'normal'),(609,'file',0,'owners','业主管理','fa fa-user','','',1,1509688838,1590937150,198,'normal'),(610,'file',609,'owners/index','人员管理','fa fa-list-alt','','用于管理小区里每个住户的基本信息，包括业主、家庭成员及租户等信息',1,1509688838,1509688838,3,'normal'),(611,'file',610,'owners/index/index','查看','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(612,'file',610,'owners/index/add','添加','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(613,'file',610,'owners/index/edit','修改','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(614,'file',610,'owners/index/del','删除','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(615,'file',609,'owners/vehicle','车辆管理','fa fa-list-alt','','用于管理小区里的车辆信息，包括业主、家庭成员及租户的车辆',1,1509688838,1509688838,2,'normal'),(616,'file',615,'owners/vehicle/index','查看','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(617,'file',615,'owners/vehicle/add','添加','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(618,'file',615,'owners/vehicle/edit','修改','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(619,'file',615,'owners/vehicle/del','删除','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(620,'file',609,'owners/pet','宠物管理','fa fa-list-alt','','用于管理小区里的宠物信息，包括业主、家庭成员及租户饲养的宠物',1,1509688838,1509688838,1,'normal'),(621,'file',620,'owners/pet/index','查看','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(622,'file',620,'owners/pet/add','添加','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(623,'file',620,'owners/pet/edit','修改','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(624,'file',620,'owners/pet/del','删除','fa fa-circle-o','','',0,1509688838,1509688838,0,'normal'),(625,'file',0,'parking','停车位管理','fa fa-film','','',1,1509934859,1509934859,197,'normal'),(626,'file',625,'parking/index','车位管理','fa fa-list-alt','','用于管理小区里每一个停车位的基本信息',1,1509934859,1509934859,2,'normal'),(627,'file',626,'parking/index/index','查看','fa fa-circle-o','','',0,1509934859,1509934859,0,'normal'),(628,'file',626,'parking/index/add','添加','fa fa-circle-o','','',0,1509934859,1509934859,0,'normal'),(629,'file',626,'parking/index/edit','修改','fa fa-circle-o','','',0,1509934859,1509934859,0,'normal'),(630,'file',626,'parking/index/del','删除','fa fa-circle-o','','',0,1509934859,1509934859,0,'normal'),(631,'file',625,'parking/usage','车位使用管理','fa fa-list-alt','','用于管理小区里每一个停车位的使用情况',1,1509934859,1509934859,1,'normal'),(632,'file',631,'parking/usage/index','查看','fa fa-circle-o','','',0,1509934859,1509934859,0,'normal'),(633,'file',631,'parking/usage/add','添加','fa fa-circle-o','','',0,1509934859,1509934859,0,'normal'),(634,'file',631,'parking/usage/edit','修改','fa fa-circle-o','','',0,1509934859,1509934859,0,'normal'),(635,'file',631,'parking/usage/del','删除','fa fa-circle-o','','',0,1509934859,1509934859,0,'normal'),(658,'file',0,'service','服务管理','fa fa-coffee','','',1,1509958393,1509958393,196,'normal'),(659,'file',658,'service/activity','活动管理','fa fa-list-alt','','用于管理小区里不定期举办的各种活动',1,1509958393,1509958393,4,'normal'),(660,'file',659,'service/activity/index','查看','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(661,'file',659,'service/activity/add','添加','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(662,'file',659,'service/activity/edit','修改','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(663,'file',659,'service/activity/del','删除','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(664,'file',659,'service/activity/detail','查看详情','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(665,'file',658,'service/repair','报修管理','fa fa-list-alt','','用于管理小区里业主的报修信息',1,1509958393,1509958393,3,'normal'),(666,'file',665,'service/repair/index','查看','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(667,'file',665,'service/repair/add','添加','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(668,'file',665,'service/repair/edit','修改','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(669,'file',665,'service/repair/del','删除','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(670,'file',665,'service/repair/detail','查看详情','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(671,'file',658,'service/complain','投诉管理','fa fa-list-alt','','用于管理小区里业主的投诉信息',1,1509958393,1509958393,2,'normal'),(672,'file',671,'service/complain/index','查看','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(673,'file',671,'service/complain/add','添加','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(674,'file',671,'service/complain/edit','修改','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(675,'file',671,'service/complain/del','删除','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(676,'file',671,'service/complain/detail','查看详情','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(677,'file',658,'service/mailbox','信箱管理','fa fa-list-alt','','用于管理小区里业主的信箱信息，包括工作建议，意见反馈等。',1,1509958393,1509958393,1,'normal'),(678,'file',677,'service/mailbox/index','查看','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(679,'file',677,'service/mailbox/add','添加','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(680,'file',677,'service/mailbox/edit','修改','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(681,'file',677,'service/mailbox/del','删除','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(682,'file',677,'service/mailbox/detail','查看详情','fa fa-circle-o','','',0,1509958393,1509958393,0,'normal'),(683,'file',0,'device/index','资产设备管理','fa fa-legal','','用于管理小区里的公共设备，比如电梯，路灯，垃圾桶，配电箱等',1,1510019471,1510019471,195,'normal'),(684,'file',683,'device/index/index','查看','fa fa-circle-o','','',0,1510019471,1510019471,0,'normal'),(685,'file',683,'device/index/add','添加','fa fa-circle-o','','',0,1510019471,1510019471,0,'normal'),(686,'file',683,'device/index/edit','修改','fa fa-circle-o','','',0,1510019471,1510019471,0,'normal'),(687,'file',683,'device/index/del','删除','fa fa-circle-o','','',0,1510019471,1510019471,0,'normal'),(688,'file',683,'device/index/detail','查看详情','fa fa-circle-o','','',0,1510019471,1510019471,0,'normal'),(689,'file',0,'duty/index','值班管理','fa fa-calendar','','用于管理小区物业的员工值班情况',1,1510212847,1510212847,193,'normal'),(690,'file',689,'duty/index/index','查看','fa fa-circle-o','','',0,1510212847,1510212847,0,'normal'),(691,'file',689,'duty/index/add','添加','fa fa-circle-o','','',0,1510212847,1510212847,0,'normal'),(692,'file',689,'duty/index/edit','修改','fa fa-circle-o','','',0,1510212847,1510212847,0,'normal'),(693,'file',2,'general/database','数据库管理','fa fa-database','','可在线进行一些简单的数据库表优化或修复,查看表结构和数据。也可以进行SQL语句的操作',1,1578995839,1578996017,0,'normal'),(694,'file',693,'general/database/index','查看','fa fa-circle-o','','',0,1578995839,1578995839,0,'normal'),(695,'file',693,'general/database/query','查询','fa fa-circle-o','','',0,1578995839,1578995839,0,'normal'),(696,'file',609,'owners/user','会员管理','fa fa-users','','用于展示微信授权列表信息，以及增加、修改、删除等操作',1,1590937323,1590938430,0,'normal'),(697,'file',696,'owners/user/index','查看','fa fa-circle-o','','',0,1590938219,1590938219,0,'normal'),(698,'file',0,'frontendnav','前台导航管理','fa fa-compass','','',1,1590938839,1590938839,118,'normal'),(699,'file',698,'frontendnav/navcate','导航分类管理','fa fa-align-justify','','用于设置导航的类别',1,1590938839,1590938839,1,'normal'),(700,'file',699,'frontendnav/navcate/index','查看','fa fa-circle-o','','',0,1590938839,1590938839,0,'normal'),(701,'file',699,'frontendnav/navcate/add','添加','fa fa-circle-o','','',0,1590938839,1590938839,0,'normal'),(702,'file',699,'frontendnav/navcate/edit','修改','fa fa-circle-o','','',0,1590938839,1590938839,0,'normal'),(703,'file',699,'frontendnav/navcate/del','删除','fa fa-circle-o','','',0,1590938839,1590938839,0,'normal'),(704,'file',698,'frontendnav/nav','导航管理','fa fa-desktop','','用于设置导航信息',1,1590938839,1590938839,2,'normal'),(705,'file',704,'frontendnav/nav/index','查看','fa fa-circle-o','','',0,1590938839,1590938839,0,'normal'),(706,'file',704,'frontendnav/nav/add','添加','fa fa-circle-o','','',0,1590938839,1590938839,0,'normal'),(707,'file',704,'frontendnav/nav/edit','修改','fa fa-circle-o','','',0,1590938839,1590938839,0,'normal'),(708,'file',704,'frontendnav/nav/del','删除','fa fa-circle-o','','',0,1590938839,1590938839,0,'normal'),(709,'file',0,'article/index','文章管理','fa fa-list-alt','','用于通用内容管理',1,1590940323,1591466159,120,'normal'),(710,'file',709,'article/index/index','查看','fa fa-circle-o','','',0,1590940323,1590940323,0,'normal'),(711,'file',709,'article/index/add','添加','fa fa-circle-o','','',0,1590940323,1590940323,0,'normal'),(712,'file',709,'article/index/edit','修改','fa fa-circle-o','','',0,1590940323,1590940323,0,'normal'),(713,'file',709,'article/index/del','删除','fa fa-circle-o','','',0,1590940323,1590940323,0,'normal'),(714,'file',0,'article','商品管理','fa fa-th-list','','文章管理',1,1590940819,1593244958,0,'normal');
/*!40000 ALTER TABLE `es_auth_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_building`
--

DROP TABLE IF EXISTS `es_building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_building` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '栋数编号，建议BD开头',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '栋数名称',
  `house` int NOT NULL COMMENT '总户数',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `lift` int DEFAULT NULL COMMENT '电梯数',
  `is_del` smallint(1) unsigned zerofill NOT NULL COMMENT '逻辑删除，0未删除，1删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='栋数信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_building`
--

LOCK TABLES `es_building` WRITE;
/*!40000 ALTER TABLE `es_building` DISABLE KEYS */;
INSERT INTO `es_building` VALUES (1,'CM2020011400001','BD2020061300001','2栋',300,'步步高升',NULL,NULL,NULL,0),(2,'CM2020011400001','BD2020061300002','1栋',200,'风水宝地',NULL,NULL,NULL,0),(3,'string','string','阿萨大',100,'string','2022-02-21 16:00:00','2022-02-23 05:10:30',0,1),(4,'asdasd','qwe','是asdasd',100,'string','2022-02-22 16:00:00','2022-02-23 05:13:07',0,1),(5,'asdasd','BD20220223145310','阿萨大三',123,'   Date date = new Date();\n   ','2022-02-23 06:53:10',NULL,NULL,0),(6,'asdasd','BD20220223145349','阿瑟东',123,'12312321','2022-02-23 06:53:49',NULL,NULL,0),(7,'asdasd','BD20220223145406','日日日',123,'日日日','2022-02-23 06:54:06',NULL,NULL,0),(8,'asdasd','BD20220223145525','权威',213,'日日日','2022-02-23 06:55:25',NULL,NULL,0),(9,'CM20220224161956','BD20220225140937','string',0,'string','2022-02-25 06:09:37',NULL,0,0),(10,'CM20220224161956','BD20220225140948','123asd',0,'string','2022-02-25 06:09:49',NULL,0,0);
/*!40000 ALTER TABLE `es_building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_category`
--

DROP TABLE IF EXISTS `es_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_category` (
  `id` int unsigned NOT NULL,
  `pid` int unsigned NOT NULL COMMENT '父ID',
  `type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '栏目类型',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `flag` set('hot','index','recommend','repair') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '关键字',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `weigh` int NOT NULL DEFAULT '0' COMMENT '权重',
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '状态',
  `is_del` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `weigh` (`weigh`,`id`) USING BTREE,
  KEY `pid` (`pid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_category`
--

LOCK TABLES `es_category` WRITE;
/*!40000 ALTER TABLE `es_category` DISABLE KEYS */;
INSERT INTO `es_category` VALUES (1,0,'article','公告快讯','社区公告快讯','index','/assets/img/qrcode.png','公告快讯','公告快讯',NULL,NULL,1,'normal',0),(2,0,'article','社区新闻','社区新闻报道','index','/assets/img/qrcode.png','社区活动','社区活动',NULL,NULL,2,'normal',0),(3,0,'article','社区故事','社区感人故事','index','/uploads/20200601/7cd29c3d7f4ae61b8075b7fbad48a1d1.png','社区新闻','社区新闻',NULL,NULL,3,'normal',0),(4,0,'repair','天然气','天然气','repair','/assets/img/qrcode.png','天然气','',NULL,NULL,4,'normal',0),(5,0,'repair','空调','空调','repair','/assets/img/qrcode.png','空调','',NULL,NULL,5,'normal',0),(6,0,'repair','冰箱','冰箱','repair','/assets/img/qrcode.png','冰箱','',NULL,NULL,6,'normal',0),(7,0,'repair','路灯','路灯','repair','/assets/img/qrcode.png','路灯','路灯',NULL,NULL,7,'normal',0),(8,0,'default','道路','道路','index','/uploads/20200626/1f0ab8e428b0fd113cf8f8bdc8ef4d7a.png','道路','道路',NULL,NULL,8,'normal',0),(9,0,'default','窗户','窗户','index','/uploads/20200626/001f7faf2ead8b1e4c67cf983b9c5eb0.png','窗户','业主窗户',NULL,NULL,9,'normal',0);
/*!40000 ALTER TABLE `es_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_community`
--

DROP TABLE IF EXISTS `es_community`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_community` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小区编号，建议CM开头',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小区名称',
  `introduction` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '简介',
  `thumb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '缩略图',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '坐落地址',
  `area` decimal(15,2) NOT NULL COMMENT '占地面积，单位：平米',
  `developer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开发商名称',
  `estate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物业公司名称',
  `greening_rate` decimal(10,2) NOT NULL COMMENT '绿化率，单位：百分比',
  `total_building` int NOT NULL COMMENT '总栋数',
  `total_owner` int NOT NULL COMMENT '总户数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_del` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='小区信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_community`
--

LOCK TABLES `es_community` WRITE;
/*!40000 ALTER TABLE `es_community` DISABLE KEYS */;
INSERT INTO `es_community` VALUES (1,'CM2020011400001','江东壹号小区','<p>金盾小区</p>','/uploads/20200114/3cf138b9a018232d4f4a0cb04ce5331d.png','江东壹号',200.00,'恒大','恒大',300.00,12,12,NULL,NULL,0),(2,'CM2020011400002','阳光城小区','<p>阳光城小区业主委员会阳光城小区业主委员会</p>','','阳光城小区业主委员会',1233.00,'阳光城小区业主委员会','阳光城小区业主委员会',100.00,11,24,NULL,NULL,0),(3,'string','string','string','string','string',0.00,'string','string',0.00,0,0,NULL,NULL,0),(5,'asdasdas','123','string','string','string',0.00,'string','string',0.00,0,0,'2022-02-21 09:48:49','2022-02-21 10:04:41',1),(6,'asdasd','5656','string','string','string',100.00,'555','555',11.00,11,111,'2022-02-21 09:52:14','2022-02-24 06:16:32',0),(7,'CM20220224143127','addC','addCaddC','','addC',123.00,'addC','addC',213.00,123,123,'2022-02-24 06:31:28',NULL,1),(8,'CM20220224143310','qweee','qweee','','qweee',123.00,'qweee','qweee',123.00,123,123,'2022-02-24 06:33:11',NULL,1),(9,'CM20220224161956','com','communityListcommunityListcommunityList','','123',123.00,'com','123',123.00,123,123,'2022-02-24 08:19:59',NULL,0);
/*!40000 ALTER TABLE `es_community` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_community_admin`
--

DROP TABLE IF EXISTS `es_community_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_community_admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小区编号，建议CM开头',
  `admin_id` int unsigned NOT NULL COMMENT '管理员id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `cm_admin_id` (`community_code`,`admin_id`) USING BTREE,
  KEY `community_code` (`community_code`) USING BTREE,
  KEY `admin_id` (`admin_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='小区管理员关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_community_admin`
--

LOCK TABLES `es_community_admin` WRITE;
/*!40000 ALTER TABLE `es_community_admin` DISABLE KEYS */;
INSERT INTO `es_community_admin` VALUES (1,'CM2020011400001',2),(2,'CM2020011400001',3),(3,'CM2020011400002',2);
/*!40000 ALTER TABLE `es_community_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_community_users`
--

DROP TABLE IF EXISTS `es_community_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_community_users` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表ID',
  `community_id` int NOT NULL COMMENT '绑定校区ID',
  `user_id` int unsigned NOT NULL COMMENT '授权用户id',
  `bind_count` int NOT NULL DEFAULT '0' COMMENT '绑定次数',
  `bind_time` int NOT NULL DEFAULT '0' COMMENT '绑定时间',
  `update_time` int NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='小区管理员关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_community_users`
--

LOCK TABLES `es_community_users` WRITE;
/*!40000 ALTER TABLE `es_community_users` DISABLE KEYS */;
INSERT INTO `es_community_users` VALUES (7,1,1,43,1611983346,1612190008);
/*!40000 ALTER TABLE `es_community_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_complain`
--

DROP TABLE IF EXISTS `es_complain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_complain` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `member_id` int NOT NULL COMMENT '投诉成员id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '投诉名称',
  `reason` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '投诉事由',
  `is_anonymity` tinyint unsigned DEFAULT NULL COMMENT '是否匿名 0 不匿名 1 匿名',
  `create_time` int unsigned DEFAULT NULL COMMENT '添加时间',
  `update_time` int unsigned DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='业主投诉信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_complain`
--

LOCK TABLES `es_complain` WRITE;
/*!40000 ALTER TABLE `es_complain` DISABLE KEYS */;
INSERT INTO `es_complain` VALUES (1,'CM2020011400001',1,'可以','可以',0,1578996365,1578996374);
/*!40000 ALTER TABLE `es_complain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_config`
--

DROP TABLE IF EXISTS `es_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_config` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '变量名',
  `config_group` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '分组',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '变量标题',
  `tip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '变量描述',
  `config_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类型:string,text,int,bool,array,datetime,date,file',
  `value` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '变量值',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '变量字典数据',
  `rule` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '验证规则',
  `extend` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '扩展属性',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_del` bigint NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='系统配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_config`
--

LOCK TABLES `es_config` WRITE;
/*!40000 ALTER TABLE `es_config` DISABLE KEYS */;
INSERT INTO `es_config` VALUES (1,'name','basic','Site name','请填写站点名称','string','至简物业管理系统','','required','',NULL,NULL,0),(2,'beian','basic','Beian','粤ICP备15054802号-4','string','粤ICP备15054802号-4','','','',NULL,NULL,0),(3,'cdnurl','basic','Cdn url','如果使用CDN云储存请配置该值，谨慎配置','string','','','','',NULL,NULL,0),(4,'version','basic','Version','如果静态资源有变动请重新配置该值','string','1.0.1','','required','',NULL,NULL,0),(5,'timezone','basic','Timezone','','string','Asia/Shanghai','','required','',NULL,NULL,0),(6,'forbiddenip','basic','Forbidden ip','一行一条记录','text','192.168.1.1\r\n192.168.1.2','','','',NULL,NULL,0),(7,'languages','basic','Languages','','array','{\"backend\":\"zh-cn\",\"frontend\":\"zh-cn\"}','','required','',NULL,NULL,0),(8,'fixedpage','basic','Fixed page','请尽量输入左侧菜单栏存在的链接','string','dashboard','','required','',NULL,NULL,0),(9,'categorytype','dictionary','Cateogry type','','array','{\"default\":\"Default\",\"page\":\"Page\",\"article\":\"Article\",\"test\":\"Test\",\"repair\":\"Repair\"}','','','',NULL,NULL,0),(10,'configgroup','dictionary','Config group','','array','{\"basic\":\"Basic\",\"email\":\"Email\",\"dictionary\":\"Dictionary\",\"user\":\"User\",\"example\":\"Example\",\"system\":\"System\"}','','','',NULL,NULL,0),(11,'mail_type','email','Mail type','选择邮件发送方式','select','1','[\"Please select\",\"SMTP\",\"Mail\"]','','',NULL,NULL,0),(12,'mail_smtp_host','email','Mail smtp host','错误的配置发送邮件会导致服务器超时','string','smtp.qq.com','','','',NULL,NULL,0),(13,'mail_smtp_port','email','Mail smtp port','(不加密默认25,SSL默认465,TLS默认587)','string','465','','','',NULL,NULL,0),(14,'mail_smtp_user','email','Mail smtp user','（填写完整用户名）','string','10000','','','',NULL,NULL,0),(15,'mail_smtp_pass','email','Mail smtp password','（填写您的密码）','string','password','','','',NULL,NULL,0),(16,'mail_verify_type','email','Mail vertify type','（SMTP验证方式[推荐SSL]）','select','2','[\"None\",\"TLS\",\"SSL\"]','','',NULL,NULL,0),(17,'mail_from','email','Mail from','','string','10000@qq.com','','','',NULL,NULL,0),(18,'system_name','system','System name','请输入小程序名称','string','业主事 安心办','','required','',NULL,NULL,0),(19,'system_title','system','System title','请输入小程序标题','string','安泰小区物业','','required','',NULL,NULL,0),(20,'system_desc','system','System desc','请输入小程序描述','string','简单购物 美好生活 由你开始','','required','',NULL,NULL,0),(21,'system_background','system','System background','请选择小程序启动背景图','image','/uploads/20200601/abc5bb17ade50895b6a9cc4fa3929349.jpg','','required','',NULL,NULL,0),(22,'system_phone','system','System phone','请输入联系电话','string','13298343199','','required','',NULL,NULL,0),(23,'system_qq','system','System qq','请输入QQ','string','1027249011','','required','',NULL,NULL,0),(24,'system_hot','system','System hot','请输入热搜索词','string','商品热搜词语配置','','required','',NULL,NULL,0),(25,'system_model','system','System model','请选择模式','radio','2','{\"1\":\"关闭游客模式\",\"2\":\"开启游客模式\"}','required','',NULL,NULL,0);
/*!40000 ALTER TABLE `es_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_crontab`
--

DROP TABLE IF EXISTS `es_crontab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_crontab` (
  `id` int unsigned NOT NULL COMMENT 'ID',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '事件类型',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '事件标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '事件内容',
  `schedule` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'Crontab格式',
  `sleep` tinyint unsigned NOT NULL COMMENT '延迟秒数执行',
  `maximums` int unsigned NOT NULL COMMENT '最大执行次数 0为不限',
  `executes` int unsigned NOT NULL COMMENT '已经执行的次数',
  `createtime` int unsigned NOT NULL COMMENT '创建时间',
  `updatetime` int unsigned NOT NULL COMMENT '更新时间',
  `begintime` int NOT NULL DEFAULT '0' COMMENT '开始时间',
  `endtime` int unsigned NOT NULL COMMENT '结束时间',
  `executetime` int unsigned NOT NULL COMMENT '最后执行时间',
  `weigh` int NOT NULL DEFAULT '0' COMMENT '权重',
  `status` enum('completed','expired','hidden','normal') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'normal' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='定时任务表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_crontab`
--

LOCK TABLES `es_crontab` WRITE;
/*!40000 ALTER TABLE `es_crontab` DISABLE KEYS */;
/*!40000 ALTER TABLE `es_crontab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_device`
--

DROP TABLE IF EXISTS `es_device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_device` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备编号，建议DV开头',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备名称',
  `brand` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌',
  `price` decimal(10,2) NOT NULL COMMENT '购买价格（单价）',
  `quantity` int unsigned DEFAULT NULL COMMENT '购买数量',
  `buy_time` datetime DEFAULT NULL COMMENT '购买时间',
  `durable_years` int unsigned DEFAULT NULL COMMENT '预计使用年限',
  `is_del` int NOT NULL COMMENT '逻辑删除，0未删除，1删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='资产设备信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_device`
--

LOCK TABLES `es_device` WRITE;
/*!40000 ALTER TABLE `es_device` DISABLE KEYS */;
INSERT INTO `es_device` VALUES (1,'CM20220224161956','string','string','string',123.00,999,'2022-02-27 01:36:36',12,0,'2022-02-26 16:00:00','2022-03-02 12:42:12'),(2,'CM20220224161956','DV20220302210326','123','12',12.00,12,'2022-03-01 16:00:00',12,1,'2022-03-02 13:03:27',NULL);
/*!40000 ALTER TABLE `es_device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_device_maintain`
--

DROP TABLE IF EXISTS `es_device_maintain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_device_maintain` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `device_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备编号，建议DV开头',
  `unit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '维修单位名称',
  `contacts` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '维修人名称',
  `contacts_tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '维修人联系方式',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `last_maintain_time` int unsigned DEFAULT NULL COMMENT '最后一次维护时间',
  `next_maintain_time` int unsigned DEFAULT NULL COMMENT '下次维护时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='资产设备维修记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_device_maintain`
--

LOCK TABLES `es_device_maintain` WRITE;
/*!40000 ALTER TABLE `es_device_maintain` DISABLE KEYS */;
/*!40000 ALTER TABLE `es_device_maintain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_duty`
--

DROP TABLE IF EXISTS `es_duty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_duty` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '值班人名称，多个值班人用英文逗号隔开',
  `start_time` int unsigned DEFAULT NULL COMMENT '值班开始时间',
  `end_time` int unsigned DEFAULT NULL COMMENT '值班结束时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='物业员工值班信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_duty`
--

LOCK TABLES `es_duty` WRITE;
/*!40000 ALTER TABLE `es_duty` DISABLE KEYS */;
INSERT INTO `es_duty` VALUES (1,'CM2020011400001','yuncopy',1578960000,1579305600,'值班');
/*!40000 ALTER TABLE `es_duty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_expenses`
--

DROP TABLE IF EXISTS `es_expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_expenses` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `house_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '缴费人，即房产编号，建议HS开头',
  `project_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '缴费项目编号，建议EP开头',
  `amount_total` decimal(10,2) NOT NULL COMMENT '应收金额',
  `amount_paid` decimal(10,2) NOT NULL COMMENT '实收金额',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '缴费时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_del` smallint(1) unsigned zerofill NOT NULL COMMENT '逻辑删除，0未删除，1删除',
  PRIMARY KEY (`id`,`project_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='费用信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_expenses`
--

LOCK TABLES `es_expenses` WRITE;
/*!40000 ALTER TABLE `es_expenses` DISABLE KEYS */;
INSERT INTO `es_expenses` VALUES (1,'CM20220224161956','HS20220224164758','EP2017110100008',123.00,123.00,'string','2022-03-01 12:37:50',NULL,0),(2,'CM20220224161956','HS2020061300001','EP2017110100003',111.00,111.00,'add','2022-03-03 13:15:47',NULL,1);
/*!40000 ALTER TABLE `es_expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_expenses_project`
--

DROP TABLE IF EXISTS `es_expenses_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_expenses_project` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目编号，建议EP开头',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_del` smallint(1) unsigned zerofill NOT NULL COMMENT '逻辑删除，0未删除，1已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='收费项目信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_expenses_project`
--

LOCK TABLES `es_expenses_project` WRITE;
/*!40000 ALTER TABLE `es_expenses_project` DISABLE KEYS */;
INSERT INTO `es_expenses_project` VALUES (1,'CM20220224161956','EP2017110100001','清洁卫生费用123',NULL,NULL,1),(2,'CM20220224161956','EP2017110100002','绿化养护费用',NULL,NULL,1),(3,'CM20220224161956','EP2017110100003','机动车停车费用',NULL,NULL,0),(4,'CM20220224161956','EP2017110100004','房屋共用部位维修费用',NULL,NULL,0),(5,'CM20220224161956','EP2017110100005','小区共用设施维修费用',NULL,NULL,0),(6,'CM20220224161956','EP2017110100006','绿化养护费用',NULL,NULL,0),(7,'CM20220224161956','EP2017110100007','清洁卫生费用',NULL,NULL,0),(8,'CM20220224161956','EP2017110100008','机动车停车费用',NULL,NULL,0),(9,'CM20220224161956','EP2017110100009','房屋共用部位维修费用',NULL,NULL,0),(10,'CM20220224161956','EP2017110100010','小区共用设施维修费用',NULL,NULL,0),(11,'CM20220224143310','EP20220302222618','55111','2022-03-02 14:26:18',NULL,1);
/*!40000 ALTER TABLE `es_expenses_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_front_nav`
--

DROP TABLE IF EXISTS `es_front_nav`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_front_nav` (
  `id` int unsigned NOT NULL,
  `cate_id` int NOT NULL COMMENT '导航分类id',
  `pid` int NOT NULL COMMENT '父级导航id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '菜单名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '链接',
  `target` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '_self' COMMENT '打开方式，可选值：_self，_blank',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '图标',
  `status` tinyint unsigned NOT NULL COMMENT '状态;1:显示;0:隐藏',
  `sort` int DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='前台导航菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_front_nav`
--

LOCK TABLES `es_front_nav` WRITE;
/*!40000 ALTER TABLE `es_front_nav` DISABLE KEYS */;
/*!40000 ALTER TABLE `es_front_nav` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_front_nav_cate`
--

DROP TABLE IF EXISTS `es_front_nav_cate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_front_nav_cate` (
  `id` int unsigned NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '导航分类名称',
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '导航分类标识，必须保证唯一性',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='前台导航分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_front_nav_cate`
--

LOCK TABLES `es_front_nav_cate` WRITE;
/*!40000 ALTER TABLE `es_front_nav_cate` DISABLE KEYS */;
/*!40000 ALTER TABLE `es_front_nav_cate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_house`
--

DROP TABLE IF EXISTS `es_house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_house` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `building_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '栋数编号，建议BD开头',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房产编号，建议HS开头',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房产名称',
  `owner_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '户主姓名',
  `owner_tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '户主联系方式',
  `rooms` int NOT NULL COMMENT '房间数',
  `unit` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单元信息',
  `floor` int NOT NULL COMMENT '楼层信息',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '房产描述',
  `enter_time` datetime DEFAULT NULL COMMENT '入住时间',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` smallint(1) unsigned zerofill NOT NULL COMMENT '逻辑删除，0未删除，1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='房产信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_house`
--

LOCK TABLES `es_house` WRITE;
/*!40000 ALTER TABLE `es_house` DISABLE KEYS */;
INSERT INTO `es_house` VALUES (1,'CM20220224161956','BD2020061300001','HS2020061300001','金盾小区3层','陈会安','18834564344',5,'1',34,'步步高升',NULL,'2022-03-02 22:56:55','2022-03-02 22:56:55',0),(2,'CM20220224161956','string','string','asd','string','string',0,'string',0,'string','2022-02-21 16:00:00','2022-03-02 22:56:56','2022-03-02 22:56:56',1),(3,'CM20220224161956','string','123','string','string','string',1,'2',3,'string','2022-02-21 23:07:27','2022-03-02 22:56:58','2022-03-02 22:56:58',1),(4,'CM20220224161956','BD20220223145525','1234','string','string','string',1,'2',3,'string','2022-02-21 23:07:27','2022-03-02 22:56:59','2022-03-02 22:56:59',0),(5,'CM20220224161956','BD20220223145525','12345','string','string','string',1,'2',4,'string','2022-02-21 23:07:27','2022-03-02 22:57:00','2022-03-02 22:57:00',0),(6,'CM20220224161956','BD20220223145525','HS20220223165635','string','string','string',0,'string',0,'string',NULL,'2022-03-02 22:57:01','2022-03-02 22:57:01',0),(7,'CM20220224161956','BD20220223145525','HS20220223165703','123','string','string',0,'string',0,'string',NULL,'2022-03-02 22:57:02','2022-03-02 22:57:02',0),(8,'CM20220224161956','BD20220223145525','HS20220223165706','1234','string','string',0,'string',0,'string',NULL,'2022-03-02 22:57:03','2022-03-02 22:57:03',0),(9,'CM20220224161956','BD20220223145525','HS20220223165708','12345','string','string',10,'1',23,'string','2022-02-25 16:00:00','2022-03-02 22:57:04','2022-03-02 22:57:04',0),(10,'CM20220224161956','BD20220223145525','HS20220223165711','123457','string','string',1,'1',2,'string','2022-02-16 16:00:00','2022-03-02 22:57:06','2022-03-02 22:57:06',0),(11,'CM20220224161956','BD20220223145525','HS20220223165713','123458','string','string',1,'2',2,'string','2022-02-24 16:00:00','2022-03-02 22:57:07','2022-03-02 22:57:07',0),(12,'CM20220224161956','BD20220223145525','HS20220223215002','12312','123123','11111111111',11,'11',11,'1prop=\"description\"','2022-02-22 16:00:00','2022-03-02 22:57:08','2022-03-02 22:57:08',0),(13,'CM20220224161956','BD20220223145525','HS20220223215034','22','22','22222222222',22,'22',22,'22prop=\"description\"','2022-02-22 16:00:00','2022-03-02 22:57:10','2022-03-02 22:57:10',0),(14,'CM20220224161956','BD20220223145349','HS20220224131329','啊飒飒的','string','string',0,'string',0,'string',NULL,'2022-03-02 22:57:11','2022-03-02 22:57:11',0),(15,'CM20220224161956','BD20220223145310','HS20220224164758','12312','123123','123123',12,'1',2,'buildingList','2022-02-23 16:00:00','2022-03-02 22:57:13','2022-03-02 22:57:13',0);
/*!40000 ALTER TABLE `es_house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_mailbox`
--

DROP TABLE IF EXISTS `es_mailbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_mailbox` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '信件标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '信件内容',
  `member_id` int NOT NULL COMMENT '成员id',
  `status` tinyint unsigned DEFAULT NULL COMMENT '状态 0 未读 1 已读',
  `create_time` int unsigned DEFAULT NULL COMMENT '添加时间',
  `update_time` int unsigned DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='业主信箱信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_mailbox`
--

LOCK TABLES `es_mailbox` WRITE;
/*!40000 ALTER TABLE `es_mailbox` DISABLE KEYS */;
/*!40000 ALTER TABLE `es_mailbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_member`
--

DROP TABLE IF EXISTS `es_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_member` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `house_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房产编号，建议HS开头',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '成员姓名',
  `identity_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `occupation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职业',
  `birth` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出生日期',
  `gender` tinyint(1) NOT NULL COMMENT '性别 0 女 1 男',
  `owner_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '成员类型 1 户主 2 家庭成员，3 租户',
  `create_time` int unsigned DEFAULT NULL COMMENT '添加时间',
  `update_time` int unsigned DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `photo` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '成员照片，拍照上传即可',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='小区成员信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_member`
--

LOCK TABLES `es_member` WRITE;
/*!40000 ALTER TABLE `es_member` DISABLE KEYS */;
INSERT INTO `es_member` VALUES (1,'CM2020011400001','HS2020061300001','帅哥','460200199011084690','18676787657','程序员','2020-06-25',1,2,1593066571,1593066571,'你很美','/assets/img/qrcode.png');
/*!40000 ALTER TABLE `es_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_parking_space`
--

DROP TABLE IF EXISTS `es_parking_space`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_parking_space` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车位编号，建议PK开头',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车位名称',
  `status` tinyint unsigned DEFAULT NULL COMMENT '状态 0 闲置中 1 使用中',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_del` tinyint(1) unsigned zerofill NOT NULL COMMENT '逻辑删除，0未删除，1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='停车位基本信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_parking_space`
--

LOCK TABLES `es_parking_space` WRITE;
/*!40000 ALTER TABLE `es_parking_space` DISABLE KEYS */;
INSERT INTO `es_parking_space` VALUES (1,'CM2020011400001','PK2020061300001','哈哈哈',1,NULL,NULL,0),(2,'CM2020011400001','PK2020061300002','很好',1,NULL,NULL,0),(3,'CM20220224161956','PK20220225140239','string',1,'2022-02-25 06:02:40','2022-02-27 05:24:03',0),(4,'CM20220224161956','PK20220225141302','a2',0,'2022-02-24 16:00:00','2022-02-27 05:23:41',0),(5,'CM20220224161956','PK20220225141314','b',0,'2022-02-25 06:13:15',NULL,0),(6,'asdasd','PK20220225141317','c',0,'2022-02-24 16:00:00','2022-02-27 05:23:45',0),(7,'CM20220224161956','PK20220225141321','string',0,'2022-02-25 06:13:21','2022-02-25 06:23:42',1),(8,'asdasd','PK20220225141341','de',0,'2022-02-24 16:00:00','2022-02-25 10:38:01',0),(9,'asdasd','PK20220225185716','pa2',0,'2022-02-25 10:57:17',NULL,0);
/*!40000 ALTER TABLE `es_parking_space` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_parking_space_use`
--

DROP TABLE IF EXISTS `es_parking_space_use`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_parking_space_use` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `pk_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车位编号，建议PK开头',
  `license_plate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆牌照',
  `owner` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆所有人',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '截止时间',
  `type` tinyint unsigned NOT NULL COMMENT '使用性质 1 租 2 买',
  `cost` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '费用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_del` tinyint(1) unsigned zerofill NOT NULL COMMENT '逻辑删除，1删除，0未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='停车位使用记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_parking_space_use`
--

LOCK TABLES `es_parking_space_use` WRITE;
/*!40000 ALTER TABLE `es_parking_space_use` DISABLE KEYS */;
INSERT INTO `es_parking_space_use` VALUES (1,'CM2020011400001','PK2020061300002','粤B1243434','陈会安','18888778766',NULL,NULL,1,'100.00',NULL,NULL,0),(2,'CM20220224161956','PK20220225141317','string','123','string',NULL,'2022-02-24 16:00:00',0,'string','2022-02-25 06:28:35','2022-02-24 16:00:00',0),(3,'CM20220224161956','PK20220225141317','string','asd','string',NULL,'2022-02-24 16:00:00',0,'string','2022-02-25 06:28:52','2022-02-24 16:00:00',0),(4,'CM20220224161956','PK20220225141317','string','ZX','string',NULL,'2022-02-24 16:00:00',0,'string','2022-02-25 06:28:55','2022-02-24 16:00:00',0),(5,'CM20220224161956','PK20220225141317','string','ccc','string',NULL,'2022-02-24 16:00:00',0,'string','2022-02-25 06:28:58','2022-02-24 16:00:00',0),(6,'CM20220224161956','PK20220225141317','string','aaa','string','2022-02-24 16:00:00','2022-02-24 16:00:00',0,'1234','2022-02-25 12:57:29',NULL,0),(7,'CM20220224161956','PK20220225141317','string','bbb','string','2022-02-24 16:00:00','2022-02-24 16:00:00',0,'1234','2022-02-25 12:57:51',NULL,0),(8,'CM20220224161956','PK20220225141317','string','ccc','string','2022-02-24 16:00:00','2022-02-24 16:00:00',0,'1234','2022-02-25 12:57:54',NULL,0),(9,'CM20220224161956','PK20220225141317','string','ddd','string','2022-02-24 16:00:00','2022-02-24 16:00:00',0,'1234','2022-02-25 12:57:56',NULL,0),(10,'CM20220224161956','PK20220225141317','string','eee','11111111111','2022-02-24 16:00:00','2022-02-24 16:00:00',0,'1234','2022-02-24 16:00:00',NULL,0),(11,'CM20220224161956','PK20220225141317','string','fff','string','2022-02-24 16:00:00','2022-02-24 16:00:00',0,'1234','2022-02-25 12:58:00',NULL,0),(12,'CM20220224161956','PK20220225185716','string','gggg','11111111111','2022-02-26 16:00:00','2022-02-24 16:00:00',0,'1234','2022-02-24 16:00:00',NULL,0);
/*!40000 ALTER TABLE `es_parking_space_use` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_pet`
--

DROP TABLE IF EXISTS `es_pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_pet` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `user_id` int NOT NULL COMMENT '家庭成员id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宠物名称',
  `color` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '宠物颜色',
  `photo` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '宠物照片，拍照上传即可',
  `adopt_time` datetime DEFAULT NULL COMMENT '收养时间',
  `create_time` datetime NOT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `is_del` int NOT NULL COMMENT '逻辑删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='宠物信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_pet`
--

LOCK TABLES `es_pet` WRITE;
/*!40000 ALTER TABLE `es_pet` DISABLE KEYS */;
INSERT INTO `es_pet` VALUES (1,36,'string','string','string',NULL,'2022-01-24 08:56:13',NULL,'string',1,NULL),(2,38,'string','string','string','2022-01-24 01:14:22','2022-01-24 08:59:50','2022-01-24 09:14:59','string',1,'2022-01-24 09:14:59'),(3,36,'123','red','https://xwe666.oss-cn-guangzhou.aliyuncs.com/user/petImage/2022/01/25/0cb256209d9e4c5e9c6735b3e570dd84file.png','2022-01-25 00:40:47','2022-01-25 08:41:43','2022-01-25 13:09:41','string',0,'2022-01-25 13:09:41'),(4,38,'addPetForm','addPetForm','https://xwe666.oss-cn-guangzhou.aliyuncs.com/user/carImage/2022/01/25/9786ae015b884becbc718cef8a8ecfc6file.png','2022-01-24 16:00:00','2022-01-25 13:48:25',NULL,'addPetForm',0,NULL);
/*!40000 ALTER TABLE `es_pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_repair`
--

DROP TABLE IF EXISTS `es_repair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_repair` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属小区编号，建议CM开头',
  `member_id` int NOT NULL DEFAULT '0' COMMENT '报修成员id',
  `consignee_id` int NOT NULL COMMENT '地址ID',
  `device_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报修设备名称',
  `device_id` int NOT NULL DEFAULT '0' COMMENT '报修设备id',
  `desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报修描述',
  `thumb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '缩略图',
  `status` tinyint unsigned NOT NULL COMMENT '状态 0 待受理 1 已受理 2 已维修  3 确认维修',
  `from` tinyint unsigned NOT NULL COMMENT '报修来源 0 后台管理人员 1 前端业主',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `id_del` int NOT NULL DEFAULT '0' COMMENT '逻辑删除0未删除，1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='业主报修信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_repair`
--

LOCK TABLES `es_repair` WRITE;
/*!40000 ALTER TABLE `es_repair` DISABLE KEYS */;
INSERT INTO `es_repair` VALUES (1,'CM2020011400001',1,7,'灯光',7,'灯光','/uploads/20200601/7cd29c3d7f4ae61b8075b7fbad48a1d1.png',0,0,NULL,NULL,0),(2,'CM2020011400001',3,7,'灯光',7,'12','/uploads/20200601/7cd29c3d7f4ae61b8075b7fbad48a1d1.png',0,0,NULL,NULL,0),(3,'CM2020011400001',1,7,'灯光',7,'灯光','/uploads/20200625/91280c434dd39b1af6144d55f3afd959.jpeg',0,0,NULL,NULL,0),(4,'CM2020011400001',1,7,'路灯',7,'222','/uploads/20200626/bbef87c2ee4103a54400cdc0cc5c49f1.jpg',1,1,NULL,NULL,0),(5,'CM2020011400001',1,7,'路灯',7,'哈哈哈','/uploads/20200626/1f0ab8e428b0fd113cf8f8bdc8ef4d7a.png',2,1,NULL,NULL,0),(6,'CM2020011400001',1,8,'天然气',4,'哈哈哈哈哈哈哈哈哈哈哈哈','/uploads/20200626/001f7faf2ead8b1e4c67cf983b9c5eb0.png',2,1,NULL,NULL,0),(7,'CM2020011400001',1,14,'冰箱',6,'哈哈哈','/uploads/20200626/3337b4af9ba2a8738c9d6aceac9d6f4a.jpg',3,1,NULL,NULL,0),(8,'CM2020011400001',1,12,'空调',5,'制冷效果不好','/uploads/20200627/f4155c580dc4a0544609211b1680118f.jpg',3,1,NULL,NULL,0),(9,'CM2020011400001',1,8,'路灯',7,'你在描述一下问题','/uploads/20210201/d0227b2e390cae6314838f5f520fd2b1.jpg',0,1,NULL,NULL,0);
/*!40000 ALTER TABLE `es_repair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_test`
--

DROP TABLE IF EXISTS `es_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_test` (
  `id` int unsigned NOT NULL COMMENT 'ID',
  `admin_id` int NOT NULL COMMENT '管理员ID',
  `category_id` int unsigned NOT NULL COMMENT '分类ID(单选)',
  `category_ids` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类ID(多选)',
  `week` enum('monday','tuesday','wednesday') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '星期(单选):monday=星期一,tuesday=星期二,wednesday=星期三',
  `flag` set('hot','index','recommend') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标志(多选):hot=热门,index=首页,recommend=推荐',
  `genderdata` enum('male','female') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'male' COMMENT '性别(单选):male=男,female=女',
  `hobbydata` set('music','reading','swimming') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '爱好(多选):music=音乐,reading=读书,swimming=游泳',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `images` varchar(1500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片组',
  `attachfile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '附件',
  `keywords` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '关键字',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `city` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '省市',
  `price` float(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '价格',
  `views` int unsigned NOT NULL COMMENT '点击',
  `startdate` date DEFAULT NULL COMMENT '开始日期',
  `activitytime` datetime DEFAULT NULL COMMENT '活动时间(datetime)',
  `year` year DEFAULT NULL COMMENT '年',
  `times` time DEFAULT NULL COMMENT '时间',
  `refreshtime` int unsigned NOT NULL COMMENT '刷新时间(int)',
  `createtime` int unsigned NOT NULL COMMENT '创建时间',
  `updatetime` int unsigned NOT NULL COMMENT '更新时间',
  `weigh` int NOT NULL DEFAULT '0' COMMENT '权重',
  `switch` tinyint(1) NOT NULL DEFAULT '0' COMMENT '开关',
  `status` enum('normal','hidden') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'normal' COMMENT '状态',
  `state` enum('0','1','2') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1' COMMENT '状态值:0=禁用,1=正常,2=推荐',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='测试表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_test`
--

LOCK TABLES `es_test` WRITE;
/*!40000 ALTER TABLE `es_test` DISABLE KEYS */;
/*!40000 ALTER TABLE `es_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_user_info`
--

DROP TABLE IF EXISTS `es_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_user_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '表ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `house_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '房产编号，建议HS开头',
  `community_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '所属社区,建议CM开头',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '市',
  `country` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '区',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '详细地址',
  `user_id` int DEFAULT NULL COMMENT '外键',
  `is_default` int NOT NULL DEFAULT '0' COMMENT '是否为默认地址',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '新建时间',
  `is_del` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `identity_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `birth` datetime(6) DEFAULT NULL COMMENT '生日',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '照片',
  `owner_type` tinyint(1) NOT NULL COMMENT '成员类型 1 户主 2 家庭成员，3 租户',
  `occupation` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职业',
  `vehicle_id` int DEFAULT NULL COMMENT '车辆id',
  `gender` int DEFAULT NULL COMMENT '性别，1男，2女',
  `openid` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_user_info`
--

LOCK TABLES `es_user_info` WRITE;
/*!40000 ALTER TABLE `es_user_info` DISABLE KEYS */;
INSERT INTO `es_user_info` VALUES (7,'陈小安1','18874564322','1','2','','','','哈哈哈小区2层',1,0,NULL,NULL,NULL,0,'0',NULL,NULL,NULL,0,NULL,NULL,0,''),(8,'英女1','18745434566','1','1','','','','哈哈哈',1,1,NULL,NULL,NULL,0,'0',NULL,NULL,NULL,0,NULL,NULL,0,''),(9,'哈哈哈','18876746344','1','1','','','','24提问',1,0,NULL,NULL,NULL,0,'0',NULL,NULL,NULL,0,NULL,NULL,0,''),(10,'哈哈哈','18876765466','1','1','','','','1232人',1,0,NULL,NULL,NULL,0,'0',NULL,NULL,NULL,0,NULL,NULL,0,''),(11,'张三','18881167888','1','2','','','','广东省-广州市-海珠区-新港中路397号',1,0,NULL,NULL,NULL,0,'0',NULL,NULL,NULL,0,NULL,NULL,0,''),(12,'哈哈哈','18767656543','1','1','','','','你好',1,0,NULL,NULL,NULL,0,'0',NULL,NULL,NULL,0,NULL,NULL,0,''),(14,'张三','020-81167888','1','1','','','','广东省-广州市-海珠区-新港中路397号',1,0,NULL,NULL,NULL,0,'0',NULL,NULL,NULL,0,NULL,NULL,0,''),(15,'张三','020-81167888','1','2','','','','广东省-广州市-海珠区-新港中路397号',1,0,NULL,NULL,NULL,0,'0',NULL,NULL,NULL,0,NULL,NULL,0,''),(16,'张三','020-81167888','1','1','','','','广东省-广州市-海珠区',1,0,NULL,NULL,NULL,0,'0',NULL,NULL,NULL,0,NULL,NULL,0,''),(17,'1232222224','string','string','string','string','string','string','string',0,0,NULL,'2022-01-15 07:35:25','2022-01-15 07:20:34',1,'440','string','2022-01-14 23:10:37.000000','string',1,'string',0,0,''),(18,'1234','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-15 07:25:08',1,'440','string','2022-01-14 23:10:37.000000','string',1,'string',0,0,''),(19,'1234','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-15 07:31:14',1,'440','string','2022-01-14 23:10:37.000000','string',1,'string',0,0,''),(20,'string','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-16 02:28:38',0,'string','string','2022-01-15 18:24:16.000000','string',1,'string',0,0,''),(21,'string','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-16 02:29:09',0,'string','string','2022-01-15 18:24:16.000000','string',1,'string',0,0,''),(22,'string','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-16 02:29:55',0,'string','string','2022-01-15 18:24:16.000000','string',1,'string',0,0,''),(23,'string','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-16 02:31:48',1,'string','string','2022-01-15 18:24:16.000000','string',1,'string',0,0,''),(24,'string','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-16 02:33:57',1,'string','string','2022-01-15 18:24:16.000000','string',1,'string',0,0,''),(25,'string','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-16 02:33:58',1,'string','string','2022-01-15 18:24:16.000000','string',1,'string',0,0,''),(26,'string','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-16 02:33:59',0,'string','string','2022-01-15 18:24:16.000000','string',1,'string',0,0,''),(27,'string','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-16 02:33:59',0,'string','string','2022-01-15 18:24:16.000000','string',1,'string',0,0,''),(28,'string','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-16 02:34:00',0,'string','string','2022-01-15 18:24:16.000000','string',1,'string',0,0,''),(29,'string','string','string','string','string','string','string','string',0,0,NULL,NULL,'2022-01-16 02:34:01',0,'string','string','2022-01-15 18:24:16.000000','string',1,'string',0,0,''),(30,'zhangsan','13316715954','HS12345678','CM12345678','GD','广州','CN','广东广州',0,0,NULL,NULL,'2022-01-16 02:45:12',0,'440123199911241234','哈哈哈哈哈哈哈哈哈哈哈哈哈','2022-01-16 02:46:15.000000','string',1,'学生',0,0,''),(31,'lisi','15800271293','HS12345678','CM12345678','GD','广州','CN','广东广州',0,0,NULL,NULL,'2022-01-16 02:46:26',0,'123456789110245654','哈哈哈哈哈哈哈哈哈哈哈哈哈','2022-01-16 02:46:15.000000','string',1,'学生',0,0,''),(32,'王五','15812432561','HS12345678','CM12345678','GD','广州','CN','广东广州',0,0,NULL,NULL,'2022-01-16 02:46:45',0,'123456789110245654','哈哈哈哈哈哈哈哈哈哈哈哈哈','2022-01-16 02:46:15.000000','string',1,'学生',0,0,''),(33,'string','15812432561','string','string','string','string','string','string',0,0,NULL,'2022-01-16 12:27:32','2022-01-16 11:51:17',0,'string','string','2022-01-15 16:00:00.000000','string',1,'string',0,0,''),(34,'zs1','13250238283',NULL,'0','','','','',NULL,0,NULL,NULL,'2022-01-23 05:23:51',0,'440183199911241710','租户','2022-01-21 16:00:00.000000',NULL,1,'student',NULL,NULL,''),(35,'213','11111111111','shanghai','biguiy','','','','',NULL,0,NULL,NULL,'2022-01-23 05:26:49',0,'440183133311241710','','2022-01-22 16:00:00.000000',NULL,1,'asd',NULL,NULL,''),(36,'ls','11111111111','shanghai','biguiy','','','','',NULL,0,NULL,'2022-01-24 06:16:24','2022-01-23 05:32:21',0,'440183133311241710','212155555','2022-01-22 16:00:00.000000',NULL,2,'asd',NULL,2,''),(38,'zs','13250238283','shanghai','biguiy','','','','',NULL,0,NULL,'2022-01-25 12:42:58','2022-01-24 05:30:14',0,'440183199911241710','CM2020011400001','2022-01-23 16:00:00.000000','https://xwe666.oss-cn-guangzhou.aliyuncs.com/user/userPhoto/2022/01/25/e929edd455ad4ea0b6c8ac054d21c74efile.png',3,' 学生',NULL,1,''),(39,'ww','12346678911','shanghai','biguiy','','','','',NULL,0,NULL,'2022-01-25 12:41:22','2022-01-24 06:32:14',0,'440183199911241710','15imagecropperShow2','2022-01-29 16:00:00.000000','https://xwe666.oss-cn-guangzhou.aliyuncs.com/user/userPhoto/2022/01/25/f769f03a249f44229f461bdda8a6dd39file.png',1,'ssss',NULL,1,''),(40,'123','13316715954','shanghai','biguiy','','','','',NULL,0,NULL,'2022-01-25 12:24:57','2022-01-25 12:08:27',0,'440183199911241710','ossService','2022-01-10 16:00:00.000000','https://xwe666.oss-cn-guangzhou.aliyuncs.com/user/userPhoto/2022/01/25/6d59ccc96bcf4403b930ca368fc8ce1cfile.png',1,'学生',NULL,1,''),(41,'子萧炽','1111111111','shanghai','biguiy','','','','',NULL,0,NULL,NULL,'2022-01-25 12:12:41',0,'440183199911241711','image','2022-01-17 16:00:00.000000','https://xwe666.oss-cn-guangzhou.aliyuncs.com/user/userPhoto/2022/01/25/821c3aeed46a45b4a26913f37113fc57file.png',2,'希望',NULL,1,''),(42,'宠物名称','11111111111','shanghai','biguiy','','','','',NULL,0,NULL,NULL,'2022-01-25 13:45:20',0,'444444444444444444','宠物名称','2022-01-23 16:00:00.000000','https://xwe666.oss-cn-guangzhou.aliyuncs.com/user/userPhoto/2022/01/25/dba843b48162460d8f8d2d9f378caf1afile.png',3,'宠物名称',NULL,1,'');
/*!40000 ALTER TABLE `es_user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_users`
--

DROP TABLE IF EXISTS `es_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_users` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `openid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户身份唯一标记',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '微信昵称',
  `userphoto` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '微信头像',
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '微信城市',
  `country` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '微信国家',
  `language` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '微信语言',
  `gender` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '微信性别',
  `province` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '微信省份',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `delete_time` datetime(6) DEFAULT NULL COMMENT '删除时间',
  `create_time` datetime(6) NOT NULL COMMENT '注册时间',
  `update_time` datetime(6) DEFAULT NULL COMMENT '更新时间',
  `is_del` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `openid` (`openid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='微信信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_users`
--

LOCK TABLES `es_users` WRITE;
/*!40000 ALTER TABLE `es_users` DISABLE KEYS */;
INSERT INTO `es_users` VALUES (1,'olhVX49f5TlNppojlX_m0YQ1q8Ns','在七月jackin.chen','https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKqOFpImvl0tw5f5fNeh20bV94Hgvs2OAd8QTScEqdeg1LYm0zs66E5SbRtfia5iblibOvG4YF01uZ6g/132','Shenzhen','China','zh_CN','1','Guangdong','','2019-11-12 00:00:00.000000','2019-11-12 00:00:00.000000','2017-12-11 00:00:00.000000',0),(2,'123','1asdas3','123qw3e','string123','123g','123','123','123','123','2022-01-12 00:00:00.000000','2022-01-13 07:33:49.654000','2022-01-13 07:39:21.822000',1),(3,'1234','string','string','string','string','string','string','string','string',NULL,'2022-01-13 07:41:10.322000',NULL,1);
/*!40000 ALTER TABLE `es_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_vehicle`
--

DROP TABLE IF EXISTS `es_vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `es_vehicle` (
  `id` int unsigned NOT NULL COMMENT '主键id',
  `user_id` int NOT NULL COMMENT '家庭成员id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆名称',
  `license_plate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆牌照',
  `color` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '车辆颜色',
  `photo` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '车辆照片，拍照上传即可',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '备注',
  `is_del` tinyint(1) NOT NULL COMMENT '逻辑删除，0未删除，1已删除',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='车辆信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_vehicle`
--

LOCK TABLES `es_vehicle` WRITE;
/*!40000 ALTER TABLE `es_vehicle` DISABLE KEYS */;
INSERT INTO `es_vehicle` VALUES (1,36,'string','string','string','string',NULL,NULL,'string',1,NULL),(2,36,'string','string1','string','string','2022-01-16 13:49:57','2022-01-24 04:56:43','string',1,'2022-01-24 04:56:43'),(3,36,'string','123','string','string','2022-01-16 13:51:05','2022-01-24 04:58:24','string',1,'2022-01-24 04:58:24'),(4,38,'str','string123','string','https://xwe666.oss-cn-guangzhou.aliyuncs.com/user/carImage/2022/01/25/f3956120cfe44be3a757e3e8a9fcfd12file.png','2022-01-16 13:55:06','2022-01-25 12:54:13','string',0,'2022-01-25 12:54:13'),(5,38,'string','string','123','string','2022-01-16 13:55:09','2022-01-24 07:37:21','stringasdasdasd',0,'2022-01-24 07:37:21'),(6,38,'string','asd','string','string','2022-01-16 13:55:12','2022-01-24 07:36:19','string',0,'2022-01-24 07:36:19'),(7,36,'str','asd','string','https://xwe666.oss-cn-guangzhou.aliyuncs.com/user/carImage/2022/01/25/842743208ee84a7da0d293a3e88a5c1cfile.png','2022-01-16 13:55:19','2022-01-25 12:55:50','string',0,'2022-01-25 12:55:50'),(8,38,'benci','123456','123',NULL,'2022-01-24 07:39:26',NULL,'21312',0,NULL),(9,38,'fll','133456','red',NULL,'2022-01-24 07:41:36',NULL,'/userInfo/car/list/',0,NULL),(10,38,'zxc','zxc','eds','https://xwe666.oss-cn-guangzhou.aliyuncs.com/user/carImage/2022/01/25/7131cd5a4e244de789673e28ee81e0edfile.png','2022-01-25 13:02:25',NULL,'\"https://xwe666.oss-cn-guangzhou.aliyuncs.com/user/carImage/2022/01/25/9786ae015b884becbc718cef8a8ecfc6file.png\"',1,NULL);
/*!40000 ALTER TABLE `es_vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'social'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-24  9:04:19
