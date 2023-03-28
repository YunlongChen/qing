/*
 * Copyright (c) 2019-2023  YunLong Chen
 * Project Qing is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 *
 */

use qing;


insert into sys_job
values (1, '系统默认（无参）', 'DEFAULT', 'zhangliTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', sysdate(),
        '', null, '');
insert into sys_job
values (2, '系统默认（有参）', 'DEFAULT', 'zhangliTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin',
        sysdate(), '', null, '');
insert into sys_job
values (3, '系统默认（多参）', 'DEFAULT', 'zhangliTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)',
        '0/20 * * * * ?', '3', '1', '1', 'admin', sysdate(), '', null, '');
insert into sys_job
values (4, '系统默认（多参）', 'DEFAULT', 'zhangliTask.syncAnimeList', '0/10 * * * * ?', '3', '1', '1', 'admin',
        sysdate(), '', null, '');


INSERT INTO `anime_info`(`id`, `name`, `district_name`, `cover_url`, `type_name`, `instruction`, `other_name`, `author`,
                         `premiere_date`, `company`,
                         `play_status`, `plot_type`, `tags`, `official_website`, `play_heat`, `original_name`)
VALUES (20000001, '海贼王', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/H6eec4b52f5ed449b8583e5ab518e7849p.jpg', 'TV',
        '电视动画《航海王》改编自尾田荣一郎创作的同名长篇少年漫画，动画由东映动画制作。\n\n海贼王哥尔·D·罗杰在临死前曾留下了关于其毕生的财富“One Piece”的消息，由此引得群雄并起，众海盗们为了这笔传说中的巨额财富展开争夺，各种势力、政权不断交替，整个世界进入了动荡混乱的“大海贼时代”。\n\n生长在东海某小村庄的路飞受到海贼香克斯的精神指引，决定成为一名出色的海盗。为了达成这个目标，并找到万众瞩目的One Piece，路飞踏上艰苦的旅程。一路上他遇到了无数磨难，也结识了索隆、娜美、山治、乌索普、罗宾等一众性格各异的好友。他们携手一同展开充满传奇色彩的大冒险。',
        '航海王 / ワンピース', NULL, '1999-10-20', '東映動画', '连载', '搞笑 冒险 热血 励志', '搞笑 冒险 热血 励志', NULL,
        '10000', 'ONE PIECE'),
       (20000002, '咕噜咕噜魔法阵', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/Hd1ff36ef90754441862bbbde8365b978K.jpg', 'TV',
        '电视动画《咕噜咕噜魔法阵》改编自改编自卫藤浩幸原作的同名漫画，动画由日本动画公司负责制作。\n\n第1期于1994年10月13日起在朝日电视台系列首播，全45话。\n\n剧场版于1996年4月20日在日本上映，同时上映的《罗德的纹章》、《魔法提琴手》是根据原作的构思完全原创的短篇。故事是第1期之后的内容。\n\n第2期《咕噜咕噜魔法阵 心跳传说》于2000年4月4日起在东京电视台系列首播，全38话。\n\n300 年前被封印的魔王吉利再次复活，主角 勇者尼克和 柯柯丽须合力再次把吉利封印。\n\n沿途上二人路经不同的村落，接触不同的人，并透过修行提升等级，展开了充满趣味欢乐的冒险旅程。',
        '魔法陣天使', NULL, '1994-10-13', 'Nippon Animation', '完结', '奇幻 搞笑 亲子', '奇幻 搞笑 亲子', NULL, '10000',
        '魔法陣グルグル'),
       (20000003, '咕噜咕噜魔法阵 第二季', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/H017513ae6d294369bcc5ab4b43bcd17eL.jpg', 'TV',
        '电视动画《咕噜咕噜魔法阵》改编自改编自卫藤浩幸原作的同名漫画，动画由日本动画公司负责制作。\n\n第1期于1994年10月13日起在朝日电视台系列首播，全45话。\n\n剧场版于1996年4月20日在日本上映，同时上映的《罗德的纹章》、《魔法提琴手》是根据原作的构思完全原创的短篇。故事是第1期之后的内容。\n\n第2期《咕噜咕噜魔法阵 心跳传说》于2000年4月4日起在东京电视台系列首播，全38话。\n\n300 年前被封印的魔王吉利再次复活，主角 勇者尼克和 柯柯丽须合力再次把吉利封印。\n\n沿途上二人路经不同的村落，接触不同的人，并透过修行提升等级，展开了充满趣味欢乐的冒险旅程。',
        '咕噜咕噜魔法阵 心跳传说', NULL, '2000-04-04', 'Nippon Animation', '完结', '奇幻 搞笑 亲子', '奇幻 搞笑 亲子',
        NULL, '10000',
        'ドキドキ♡伝説 魔法陣グルグル'),
       (20000004, '樱桃小丸子 第二季', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/H116c9440ffd34dc5afa09afc3afb9c104.jpg', 'TV',
        '故事以20世纪70年代日本静冈清水市为背景，这里生活着快乐而幸福的樱一家。樱桃子（小丸子）是家中最小的女儿，她贪玩懒惰，还迷迷糊糊，经常惹得妈妈和姐姐大发雷霆。不过身边有个没正形儿的父亲和溺爱她的爷爷，倒让小丸子的生活不致于太无聊。尤其是爷爷，祖孙俩在一起可没少闹笑话。\n\n学校里，小丸子还有一班性格各异的好朋友：最最亲近的小玉、超级自恋的花轮、骄傲自大的班长丸尾、阴森如背后灵的野口、搞笑的乐天派滨崎、脑袋如洋葱说话刻薄的永泽……和这些人在一起，小丸子的生活每天都充满了乐趣！',
        '樱桃小丸子(1995)', NULL, '1995-01-08', 'Nippon Animation', '完结', '搞笑 亲子 亲情', '搞笑 亲子 亲情', NULL,
        '10000', 'ちびまる子ちゃん'),
       (20000005, '名侦探柯南', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/H071986b673984cc0aba31adb3da21dbbu.jpg', 'TV',
        '电视动画《名侦探柯南》改编自青山刚昌创作的、连载于《周刊少年Sunday》上的漫画《名侦探柯南》。动画于1996年1月8日首播。\n\n高中生侦探工藤新一和青梅竹马的同学毛利兰一同去游乐园玩的时候，目击了黑衣男子的可疑交易现场。只顾偷看交易的工藤新一，却忽略了从背后接近的另一名同伙。他被那名男子灌下了毒药，当他醒来时，身体居然缩小了！\n\n如果让那些家伙知道工藤新一还活着的话，不仅性命难保，还会危及身边的人。在阿笠博士的建议下他决定隐瞒身份，在被小兰问及名字时，化名江户川柯南，为了搜集那些家伙的情报，寄住在父亲以侦探为业的小兰家中。\n\n谜团重重的黑衣组织……他所了解的，就只有他们是以酒的名称作为代号的。为了揭露那些家伙的真面目，小小侦探江户川柯南的活跃开始了！',
        '暂无', NULL, '1996-01-08', 'TMS Entertainment', '连载', '悬疑 推理 犯罪', '悬疑 推理 犯罪', NULL, '10000',
        '名探偵コナン'),
       (20000006, '海贼王特别篇 打倒海贼强萨克！', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/Ha5fdb57f05e44b8c8d037af673d93a5cZ.jpg', 'OVA',
        '在某个海岛小渔村长大。和暂驻在渔村的大海盗红发撒古斯感情很好，于是一心想成为海盗。眼下的疤痕就是为了显示自己够狠自己用刀划的（果然够狠，汗）。可是路飞7岁时糊里糊涂的吃了海盗们抢来的恶魔果实——橡皮果实，从此再也学不会游泳。这样还能成为海盗吗？路飞的答案是——只要不掉到海里就可以了（听上去好像很有道理，可是……我真的给这个单细胞的家伙打败了）。',
        '海贼王SP 打倒海贼强萨克', NULL, '1998-07-01', 'Production I.G', '完结', '搞笑 冒险 热血 励志',
        '搞笑 冒险 热血 励志', NULL, '10000',
        'ONE PIECE 倒せ!海賊ギャンザック'),
       (20000007, '海贼王TV版特别篇 路飞落下！秘境 海肚脐的大冒险', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/Ha7c40d5c87c94397b132eedc796aa288u.jpg',
        'TV',
        '《海贼王SP：路飞落下 秘境 海肚脐的大冒险》是尾田荣一郎导演的一部剧情电影。\n\n寻找秘宝的路飞一行，进入海肚脐的大冒险。',
        '暂无', NULL, '2000-12-20', '暂无', '完结',
        '搞笑 冒险 热血 励志', '搞笑 冒险 热血 励志', NULL, '10000', 'ルフィ落下! 秘境・海のヘソの大冒険'),
       (20000008, '海贼王剧场版 黄金岛冒险', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/H99deb0c882be41b39eb5d08059269eb8w.jpg', '剧场版',
        '《ONE PIECE 黄金岛大冒险》是于2000年上映的第一部《ONE PIECE》剧场版。中国中央电视台电影频道（CCTV-6）亦曾引进并于2011年8月8日下午14:50分首播，片名翻译为《航海王：黄金岛大冒险》。\n\n传说中的黄金大盗乌南，带着大批黄金隐居到某座岛屿，之后生死不明，向着伟大航道持续前进的的鲁夫一行人，遇到了梦想成为乌南的部下的少年托比欧，他因为不愿继承爷爷经营的甜不辣摊，和爷爷闹的很不愉快，而爱黄金成痴的海贼艾拉德哥也正窥视着乌南埋藏的黄金。',
        '海贼王剧场版1', NULL, '2000-03-04', '暂无', '完结', '搞笑 冒险 热血 励志', '搞笑 冒险 热血 励志', NULL,
        '10000', 'ONE PIECE the movie'),
       (20000009, '海贼王SP合集', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/H6c7f207c497e4965b144c7f79ebef8217.jpg', 'OVA',
        'TVSP&OVASP：\n\nSP01-1998-打倒海贼强萨克!\n\nSP02-1999-路飞的绝技\n\nSP03-1999-索隆的剑技\n\nSP04-2000-路飞落下 秘境 海肚脐的大冒险\n\nSP05-2001-剧场版2首映会\n\nSP06-2001-赞高的狂欢舞会\n\nSP07-2002-剧场版3首映会\n\nSP08-2002-剧场版3声优访谈\n\nSP09-2002-梦幻足球王\n\nSP10-2003-剧场版4首映会\n\nSP11-2003-在辽阔的海洋上驰骋!父亲伟大的梦想!\n\nSP12-2003-守卫!最后的大舞台\n\nSP13-2004-目标-海贼棒球王\n\nSP14-2005-海贼王的轨迹\n\nSP15-2005-年底特别企画!草帽小子路飞的捕头传\n\nSP16-2005-简单易懂 路飞大百科\n\nSP17-2006-草帽小子海贼团的秘密!\n\nSP18-2007-乔巴超人\n\nSP19-2008-ROMANCE DAWN\n\nSP20-2010-强者世界前传\n\nSP21-2012-娜美篇-航海士的眼泪与牵绊\n\nSP22-2012-路飞篇-路飞手掌岛的冒险\n\nSP23-2013-梅丽篇-另一位同伴的故事\n\nSP24-2014-薇薇回忆录-阿拉巴斯坦前奏\n\nSP25-2014-3D2Y-跨越艾斯之死!路飞与伙伴的誓言\n\nSP26-2015-萨博的故事\n\nSP27-2015-迷雾岛大冒险\n\nSP28-2013 剧场版Z特别篇 Glorious Island\n\nSP29-2013 梅丽篇—另一名伙伴的故事\n\nSP30-2014 薇薇回忆录—阿拉巴斯坦前奏\n\nSP31-2014 3D2Y 跨越艾斯之死！与路飞伙伴的誓言、\n\nSP32-2014无字幕 乔巴篇-冬季盛开的奇迹之樱\n\nSP33-2015 3D陷阱过山车\n\nSP34-2015 三兄弟的羁绊 萨博的故事',
        '海贼王特别篇合集', NULL, '1998-07-01', '暂无', '完结', '搞笑 冒险 热血 励志', '搞笑 冒险 热血 励志', NULL,
        '10000', '暂无'),
       (20000010, '咕噜咕噜魔法阵剧场版', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/Hc837075d77fe4db5b729239a2b2830e1t.jpg', '剧场版',
        '传说中有个吃了后无论什么愿望都能实现的道具，名为幸福的咸菜，巨大龙在巨大山等待着勇者的愿望，只要是巨大龙认可的愿望，谁都能得到幸福的咸菜。得知此传闻的勇者仁傑和魔女歌莉决定出发寻找幸福的咸菜……',
        '暂无', NULL,
        '1996-04-20', 'Nippon Animation', '完结', '奇幻 搞笑 亲子 冒险', '奇幻 搞笑 亲子 冒险', NULL, '10000',
        '劇場版 魔法陣グルグル'),
       (20000011, '樱桃小丸子', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/Hbf8cf4d31bbd486690ac85f35577d042c.jpg', 'TV',
        '《樱桃小丸子》是全球知名度最高及最具影响力的动漫作品之一。其动画连续二十余年高居日本动画收视率前三位，到2013年时已超过1000集，仍于每周日黄金时段下午六点在日本富士电视台上进行连载热播，是日本男女老少心中的国民动画。本作品是以作者的童年生活为蓝本，故事围绕着小丸子以及其家人和同学展开，有关于亲情、友谊，或是一些生活小事，其中有笑有泪，令人回想起童年的稚气。\n\n在1990年至1992年，《樱桃小丸子》第一次动画化，于富士电视台播出，并曾于1990年10月28日达到39.9%的收视率，在1991年9月26日成为有纪录以来日本史上最高收视的动画。而第二次动画化于1995年开始，直至2005年现仍播放中，并于2005年1月9日迎来了播放15周年纪念。\n\n该片讲述了小丸子上幼稚园和小学低年级的故事，大家已经熟知了这个俏皮、童真、聪慧、富有创意又缺点一大把的女孩子。而在第二部中，小丸子已经升入了三年级。故事自然还是围绕着她在生活和学习中与家人、朋友、老师、同学之间发生的一桩桩有趣的情景展开，有关于亲情、爱心以及同学之间的友情。 [4]  或是一些生活小事，但当中有笑有泪，令人回想起童年的稚气。最特别的，当在故事人物尴尬时的招牌表情，会突然出现在脸上的黑线，有时还会伴随着一阵寒风从头后吹过。 [1] \n\n在2013年12月29日第936话时，小丸子破天荒换了个新发型，引起热议，从之前的锯齿形的刘海变成如今的时尚短发，刘海用两个小发箍别在两边。 [5]  第937话时，小丸子的发型又换回来了。',
        'Chibi Maruko-chan', NULL, '1990-01-07', 'Nippon Animation', '完结', '搞笑 亲子 亲情', '搞笑 亲子 亲情', NULL,
        '10000',
        'ちびまる子ちゃん'),
       (20000012, '樱桃小丸子剧场版 大野与杉山', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/H7782d2eb368f428d8aa9da4d55c5834cw.jpg', '剧场版',
        '《樱桃小丸子:友情岁月》是根据漫画家樱桃子创作的漫画《樱桃小丸子》改编的动画电影。本作同时也是《樱桃小丸子》首次改编成电影，登上大荧幕。影片于1990年12月15日公映。\n\n就讀小學三年班的小丸子，被分配與兩位新同學大野和杉山同一組參與多項活動。在騎馬戰中，杉山因來不及支援大野而被打到，兩人因此絕交，小丸子感到悶悶不樂。音樂會表演當日，負責男音獨唱的大野突然失聲，幸好杉山杖義相助替大野繼續唱下去，二人亦因此和好如初。然而，大野因爸爸調職而要與這一班好朋友道別。在歡送會中，眾人合唱友誼之歌，場面非常感動，而這段友情歲月，將永藏於小丸子及小朋友的心坎中。',
        '樱桃小丸子 电影版 友情岁月', NULL, '1990-12-15', 'Nippon Animation', '完结', '搞笑 亲子 亲情',
        '搞笑 亲子 亲情', NULL, '10000',
        'ちびまる子ちゃん 劇場版 大野君と杉山君'),
       (20000013, '樱桃小丸子剧场版 我喜欢的歌', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/H4035f6fec9dc4f5ca5222cf3250b5b21t.jpg', '剧场版',
        '《樱桃小丸子：我喜欢的歌》是1992年上映的，搞笑、儿童类型的作品。\n\n讲述了同学们根据自己喜欢的歌曲编出一副图画来。小丸子在去静冈县的外婆家途中，遇到了帮路人素描打工的大姐姐，并成为了忘年交。在大姐姐对歌曲故事的讲述下，小丸子也画出了得奖的作品，并且还“童言无忌”的一番话感动了大姐姐，让大姐姐重新权衡了与北海道大哥哥的 恋情和自己的梦想哪个更重要。',
        '暂无', NULL, '1992-12-19', 'Nippon Animation', '完结', '搞笑 亲子 亲情', '搞笑 亲子 亲情', NULL, '10000',
        'びまる子ちゃん 劇場版 わたしの好きな歌'),
       (20000014, '钢铁杰克', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/Heebf806b45034cbcb3e0dd444e507af0j.jpg', 'TV',
        '本作时代设定成‘钢铁吉克’的50年后、不过非动画版‘钢铁吉克’的续集而是采用安田达矢作画而在テレビマガジン志上连载的漫画版作为续篇、一部份角色的设定也有所差易。本作有着热血主角的设定和女主角的性感表现、宛如1970年到1980年时的永井豪作品作风一样。\n\n曾经，人类与拥有凶恶咒术力的女王--妃魅祸率领的邪魔大王国的埴轮幻神发生过壮绝的战争，战争最后以人类封印了妃魅祸而获得了胜利。在那场战争的50年后，人类在平静的生活中渐渐忘记了那场战争。但是，埴轮幻神又一次出现了！与它们展开战斗的是司马迁次郎博士率领的BUILD BASE！高校生草薙剑儿借着由从BIG SHOOTER射出的各种部件装着组合而成「钢铁神吉克」，与它们展开了激烈的战斗。现在，关系到人类存亡的新的战斗开始了……',
        '钢铁基克 / 钢铁神杰克 / 钢之魂 / 磁力铁甲人', NULL, '1975-10-05', '東映動画', '完结', '科幻 热血 战斗',
        '科幻 热血 战斗', NULL, '10000', '鋼鉄ジーグ'),
       (20000015, '星际牛仔', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/Hcacfed205f064ac5a235f0c9a4ed9bafp.jpg', 'TV',
        '《星际牛仔》（カウボーイビバップ；Cowboy Bebop），是日本SUNRISE动画公司制作的原创电视动画，于1998年播出，同年夺得第三回神户动画奖的年度最佳电视动画奖，并于2000年获得日本科幻大会星云奖。\n\n2021年，随着超光速航行技术的实现，人类得以在太阳系范围内方便的自由移动，但是由于设计上的失误，这种技术引发了月球的爆炸，无数的月球碎片被吸引向地球，造成了空前绝后的大灾难。存活下来的人类逃离地球，并开始在太阳系各地建立家园。由于这次灾难，国家、政府等权利机构都极为不稳定、治安问题也成为了一个难题。为了在人力资源不足的情况下抓捕罪犯，有些组织开始允许个人抓捕通缉的罪犯并换取奖金，“赏金猎人”这个职业也就由此诞生了。\n\n史派克（Spike）和杰特（Jet）是驾驶飞船Bebop号在宇宙中以捉拿逃犯获取奖金为生的赏金猎人。两人在星际间的旅程中，结识了身负巨债、嗜财如命的美女菲（Faye）和电脑神童艾德（Ed），并收养了拥有高智商的数据狗爱因（Ein）。从此，四人一狗游荡在广阔之宇宙之中，在自己与他人的生活中经历著种种悲欢离合，也寻找著各自的过去。',
        '赏金猎人 / Cowboy Bebop', NULL, '1998-10-23', 'SUNRISE', '完结', '科幻 冒险 犯罪 剧情', '科幻 冒险 犯罪 剧情',
        NULL, '10000',
        'カウボーイビバップ'),
       (20000016, '暗之末裔', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/H270c8034b0634825857d5fcb7bda5a39r.jpg', 'TV',
        '电视动画《暗之末裔》改编自日本漫画家松下容子原作的同名漫画。电视动画于2000年10月2日—12月18日在WOWOW播出，全13话。\n\n在幽暗可怖的冥府之中，有一个相当于警察局的，被称为“十王厅”的神秘机构，除了审判一些罪孽深重的死者外，十王厅还担当了调查人间非正常死亡事件的重要职责。个性开朗平和的青年都筑麻斗就供职于此，有着丰富办案经验的他渐渐成为了十王厅的顶梁柱。\n\n长崎发生了一连串的不思议杀人事件，疑为凶残嗜血的吸血鬼所为。为了调查事件的真相，都筑麻斗和其搭档黑崎密开始了他们危险的旅程。在好友亘理温和巽真一郎的帮助下，所有线索指向了名为邑辉一贵的变态医师身上。令密没有想到的是，在过去，邑辉一贵和都筑麻斗竟然还有着说不清道不明的纠葛关联，而早已被埋没的，麻斗的过去也渐渐的浮出了水面。',
        '暂无', NULL, '2000-10-02', 'J.C.STAFF', '完结', '耽美 乙女向', '耽美 乙女向', NULL, '10000', '闇の末裔'),
       (20000017, '新世纪福音战士', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/H47c9dee9bbb84856b0bd739998b67de5X.jpg', 'TV',
        '《新世纪福音战士》是由龙之子工作室、GAINAX两家日本动画公司共同制作的动画作品，简称《EVA》。该片于1995年10月4日-1996年3月27日在日本首播，全26集。由庵野秀明担任主要编剧及总导演，贞本义行担任角色设计，绪方惠美、林原惠、宫村优子、三石琴乃等人担任主要配音。\n\n2000年，一个科学探险队在南极洲针对被称作“第一使徒”亚当的“光之巨人”进行探险。在对其进行接触实验时，“光之巨人”自毁，从而发生了“第二次冲击”，进而导致世界大战。最后，人类人口减半，地轴偏转、气候改变。根据对“第二次冲击”的调查，联合国在日本箱根成立人工进化研究所（即 GEHIRN）从事EVA（指机器人）的发展研究，后GEHIRN利用在人工进化研究所下方发现的巨大空洞建造了总部。\n\n另一方面，联合国下属秘密组织SEELE为了使人类进化，开始实行人类补完计划，就是将所有人的灵魂汇集在一起，通过中和每个人的AT力场，使每个人回归LCL之海。\n\n2004年，EVA初号机进行启动试验时发生事故，碇真嗣的母亲碇唯消失，碇源渡开始执行“碇源渡版本的人类补完计划”。2010年，GEHIRN被改建成NERV。\n\n2015年开始，根据SEELE人类补完计划剧本的安排，一种巨型人形生物“使徒”开始在日本登陆，并向NERV总部进攻，NERV组织EVA消灭使徒。在NERV与使徒作战的同时，碇源渡秘密地执行它自己的计划。随着时间推移，碇源渡的计划逐渐被SEELE发现，NERV与SEELE产生了矛盾并不断恶化。\n\nDirector\'s Cut版本的第21～24集由剧场版《Death》篇剪辑而成，收录在20周年纪念版的蓝光中。',
        'EVA', NULL, '1995-10-04', 'GAINAX / タツノコプロ', '完结', '科幻 机战 爱情', '科幻 机战 爱情', NULL, '10000',
        '新世紀エヴァンゲリオン'),
       (20000018, '新世纪福音战士剧场版 死与新生', NULL,
        'https://vo-1255705827.cos.ap-guangzhou.myqcloud.com/H1bb31b526ed541ff8ed51a6e67ff891cY.jpg', '剧场版',
        '《新世纪福音战士》电影版第1部。分为“DEATH篇（死亡篇）”与“REBIRTH篇（新生篇）”两个部分。“死亡篇”以原TV版动画第1集到第 24集的内容为基础，重新剪辑了一个总结篇。“新生篇”内容承接第24集内容：\n\n第十七使徒被消灭后，SEELE向NERV下达命令，要EVA 初号机负责执行“人类补完计划”。然而碇元度不认同SEELE的做法，拒绝执行。SEELE认定这是一种叛变的行为，决定把NERV彻底消灭。\n\n破晓时分，NERV本部突然遭到来自战略自卫队的袭击，他们对NERV的人员进行了惨无人道的大屠杀。为了保护驾驶员，葛城美里命令把精神崩溃的明日香送上二号机，并放在湖底的深处，自已就亲自去救碇真嗣 。但此时的碇真嗣已经处在精神崩溃的边缘。\n\n=============================\n\n死与新生包括DEATH以及REBIRTH两个部分\n\n电影上映的版本 包括了REBIRTH ；\n\n之后，在日本某电视台放时修改了少量内容；\n\n之后发行的录像带去除了REBIRTH，所以叫DEATH；\n\n然后又发了个版本，叫DEATH TRUE；\n\n后来又发了，修改了少许东西， 叫DEATH TRUE^2 ；\n\n现在网络上流传的大都是DEATH TRUE^2。',
        '新世紀エヴァンゲリオン劇場版 DEATH & REBIRTH', NULL, '1997-03-15', 'Production I.G / GAINAX', '完结', '科幻 机战 爱情',
        '科幻 机战 爱情',
        NULL, '10000', '新世紀エヴァンゲリオン劇場版 シト新生')


# 插入测试播放列表
insert into qing.anime_playlist(id, name, anime_id, description)
values (1, '播放列表1', 20000001, 'description'),
       (2, '播放列表2', 20000001, 'description');

# 插入播放列表
INSERT
INTO qing.anime_episode (anime_id, list_id, name, status, uploader_name, uploader_id, url, order_no)
VALUES (20000001, 1, '第一集', 0, 'stan', 123, '123', 1),
       (20000001, 1, '第二集', 0, 'stan', 123, '123', 1),
       (20000001, 1, '第三集', 0, 'stan', 123, '123', 1),
       (20000001, 1, '第四集', 0, 'stan', 123, '123', 1),
       (20000001, 1, '第五集', 0, 'stan', 123, '123', 1),
       (20000001, 1, '第六集', 0, 'stan', 123, '123', 1),
       (20000001, 2, '第一集', 0, 'stan', 123, '123', 1),
       (20000001, 2, '第二集', 0, 'stan', 123, '123', 1),
       (20000001, 2, '第三集', 0, 'stan', 123, '123', 1)
