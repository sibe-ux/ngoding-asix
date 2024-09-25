CREATE DATABASE `news`;
USE `news`;
CREATE TABLE `Authors`(
	`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`name` varchar(15),
	`surname` varchar(30)
);
CREATE TABLE `Articles`(
	`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`title` varchar(30),
	`article` text,
	`article_date` date
);
CREATE TABLE `Articles_authors`(
	`article_id` int(11),
	`author_id` int(11)
);
INSERT INTO `Authors` (`id`, `name`, `surname`) VALUES
(1, 'Janina', 'Milek'),
(2, 'Adam', 'Michalak'),
(3, 'Bogdan', 'Nowacki'),
(4, 'Krzysztof', 'Wysocki'),
(5, 'Jadwiga', 'Mucha'),
(6, 'Magdalena', 'Kowal'),
(7, 'Maciej', 'Kowalski');
INSERT INTO `articles` (`id`, `title`, `article`, `article_date`) VALUES
(1, 'Lorem ipsum dolor sit', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent a massa ligula. Pellentesque non ullamcorper libero. Sed felis ligula, luctus eu nisi quis, fringilla interdum ante. Curabitur dui lectus, congue quis orci id, lobortis egestas leo. Ut pretium id magna quis vulputate. Maecenas convallis neque id enim hendrerit consectetur. Integer accumsan urna imperdiet lacus faucibus, non porttitor sem molestie. Aliquam eu laoreet mi, non mattis mauris. Phasellus pellentesque nisl auctor felis auctor pharetra. Duis lacinia pellentesque molestie. Morbi id tempor nisl, in maximus tortor. Nullam ac turpis ut augue maximus ornare. Phasellus semper aliquet augue, sit amet tincidunt erat pulvinar ut. Mauris congue tortor justo. Curabitur elementum, dolor ut tempus elementum, lacus libero dapibus turpis, suscipit tristique nisi nulla quis quam. Phasellus auctor sapien erat, nec finibus felis bibendum eu.', '2020-09-07'),
(2, 'Ut eget massa et justo', 'Phasellus sed porta sem. Integer sem augue, convallis id arcu lobortis, hendrerit sagittis nisl. Integer lacinia, diam in volutpat ultrices, ligula metus imperdiet elit, quis egestas purus libero nec massa. Duis est nulla, elementum ut ante et, egestas dignissim enim. Nunc gravida, tortor sit amet venenatis posuere, nunc dolor eleifend lorem, id consequat odio purus eu quam.', '2020-09-04'),
(3, 'Duis tincidunt ante eget', 'Duis tincidunt ante eget odio scelerisque, eget hendrerit magna mattis. Vestibulum tincidunt mauris quam. Ut eget massa et justo accumsan rhoncus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi placerat purus in lobortis accumsan. In non nunc blandit, faucibus enim vitae, gravida ipsum. Donec ultrices, enim in tristique placerat, metus est eleifend mauris, a accumsan sapien mauris a diam. In volutpat fringilla metus. Mauris sed orci in quam elementum congue.', '2020-09-02'),
(4, 'Phasellus accumsan eget mi sed', 'Phasellus accumsan eget mi sed euismod. Maecenas ullamcorper augue sit amet facilisis interdum. Quisque et mauris dictum, laoreet eros nec, blandit felis. Cras non purus et quam faucibus pharetra. Sed enim nibh, fermentum sed molestie ut, euismod quis elit. Vestibulum ac facilisis lorem. Pellentesque pharetra magna sit amet egestas malesuada. Morbi malesuada nunc semper mi posuere ullamcorper. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas augue erat, tristique eget pulvinar a, faucibus non nisi.', '2020-09-01'),
(5, 'Vivamus vel malesuada diam. Ma', 'Vivamus vel malesuada diam. Mauris eu diam eu orci blandit tempor et vitae tellus. Suspendisse in leo eget augue imperdiet cursus. Phasellus quis pharetra purus, a sodales lorem. Nulla facilisi. Vivamus ac dui et mi mattis facilisis vitae in odio. Integer at urna nisi. Praesent pretium enim dui, vel vehicula ante facilisis eget. Phasellus nibh magna, luctus fermentum mattis ut, tempus eu metus. Morbi vel dignissim est, eget rhoncus felis.', '2020-08-31');
INSERT INTO `articles_authors` (`article_id`, `author_id`) VALUES
(1, 3),
(1, 6),
(2, 1),
(2, 5),
(3, 1),
(4, 6),
(5, 1),
(5, 6),
(2, 4),
(4, 5),
(4, 3);