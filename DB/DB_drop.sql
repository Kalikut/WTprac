use internet_shop;

ALTER TABLE `book` DROP FOREIGN KEY `book_fk0`;

ALTER TABLE `book` DROP FOREIGN KEY `book_fk1`;

ALTER TABLE `orders` DROP FOREIGN KEY `order_fk0`;

ALTER TABLE `orders` DROP FOREIGN KEY `order_fk1`;

ALTER TABLE `orders_journal` DROP FOREIGN KEY `order_journal_fk0`;

ALTER TABLE `orders_journal` DROP FOREIGN KEY `order_journal_fk1`;

ALTER TABLE `book_author` DROP FOREIGN KEY `book_author_fk0`;

ALTER TABLE `book_author` DROP FOREIGN KEY `book_author_fk1`;

DROP TABLE IF EXISTS `client`;

DROP TABLE IF EXISTS `book`;

DROP TABLE IF EXISTS `orders`;

DROP TABLE IF EXISTS `orders_journal`;

DROP TABLE IF EXISTS `author`;

DROP TABLE IF EXISTS `book_author`;

DROP TABLE IF EXISTS `genre`;

DROP TABLE IF EXISTS `cover`;

DROP TABLE IF EXISTS `admin`;

DROP TABLE IF EXISTS `statuses`;

drop database internet_shop;