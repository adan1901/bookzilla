
DROP TABLE IF EXISTS `bz_role`;
CREATE TABLE IF NOT EXISTS `bookzilla_01`.`bz_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

LOCK TABLES `bz_role` WRITE;
INSERT INTO `bz_role` VALUES (1,'ROLE_USER');
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `bz_user`;
CREATE TABLE IF NOT EXISTS `bz_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rank` float(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `category`
--
DROP TABLE IF EXISTS `bz_category`;
CREATE TABLE IF NOT EXISTS `bz_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `bz_book`;
CREATE TABLE IF NOT EXISTS `bz_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rank` DOUBLE DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `book_category`
--

DROP TABLE IF EXISTS `bz_book_category`;
DROP TABLE IF EXISTS `bz_book_category`;
CREATE TABLE `bz_book_category` (
  `book_id` int,
  `category_id` int,
  PRIMARY KEY (`book_id`, `category_id`),
  CONSTRAINT `fk_book_category_bookid` FOREIGN KEY (`book_id`) REFERENCES `bz_book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_book_category_categoryid` FOREIGN KEY (`category_id`) REFERENCES `bz_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `user_books`
--
DROP TABLE IF EXISTS `bz_user_books_owned`;
CREATE TABLE `bz_user_books_owned` (
  `user_id` int,
  `book_id` int,
  PRIMARY KEY (`user_id`, `book_id`),
  CONSTRAINT `fk_user_book_userid` FOREIGN KEY (`user_id`) REFERENCES `bz_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_book_bookid` FOREIGN KEY (`book_id`) REFERENCES `bz_book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `user_books_rented`
--
DROP TABLE IF EXISTS `bz_user_books_rented`;
CREATE TABLE IF NOT EXISTS `bz_user_books_rented` (
  `user_id` int,
  `book_id` int,
  PRIMARY KEY (`user_id`, `book_id`),
  CONSTRAINT `fk_user_rent_books_userid` FOREIGN KEY (`user_id`) REFERENCES `bz_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_rent_books_bookid` FOREIGN KEY (`book_id`) REFERENCES `bz_book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `bz_user_role`;
CREATE TABLE if NOT EXISTS `bz_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `bz_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `bz_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE UNIQUE INDEX ux_bz_user_username
  on bz_user (username);

CREATE UNIQUE INDEX ux_bz_user_email
  on bz_user (email);

COMMIT ;
