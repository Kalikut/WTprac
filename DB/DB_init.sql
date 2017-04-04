create database internet_shop;
use internet_shop;

CREATE TABLE `client` (
	`client_id` bigint NOT NULL,
	`first_name` varchar(30) CHARACTER SET utf8 NOT NULL,
	`middle_name` varchar(30) CHARACTER SET utf8,
	`last_name` varchar(30) CHARACTER SET utf8 NOT NULL,
	`adress` varchar(100) CHARACTER SET utf8,
	`phone_number` varchar(12) CHARACTER SET utf8 NOT NULL,
	`e_mail` varchar(50) CHARACTER SET utf8 NOT NULL UNIQUE,
	`password` varchar(30) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (`client_id`)
);

CREATE TABLE `book` (
	`book_id` bigint NOT NULL,
	`title` varchar(200) CHARACTER SET utf8 NOT NULL,
	`genre_id` bigint NOT NULL,
	`publishing_house` varchar(50) CHARACTER SET utf8 NOT NULL,
	`publishing_year` int NOT NULL,
	`pages_number` int NOT NULL,
	`amount` bigint NOT NULL,
	`price` bigint NOT NULL,
	`cover_id` bigint NOT NULL,
	PRIMARY KEY (`book_id`)
);

CREATE TABLE `orders` (
	`order_id` bigint NOT NULL,
	`client_id` bigint NOT NULL,
	`order_date` DATE NOT NULL,
	`delivery_date` DATE NOT NULL,
	`delivery_adress` varchar(100) CHARACTER SET utf8 NOT NULL,
	`delivery_cost` bigint NOT NULL,
	`status_id` bigint NOT NULL,
	`books_cost` bigint NOT NULL,
	PRIMARY KEY (`order_id`)
);

CREATE TABLE `orders_journal` (
	`id` bigint NOT NULL,
	`order_id` bigint NOT NULL,
	`book_id` bigint NOT NULL,
	`amount` bigint NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `author` (
	`author_id` bigint NOT NULL,
	`name` varchar(200) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (`author_id`)
);

CREATE TABLE `book_author` (
	`author_id` bigint NOT NULL,
	`book_id` bigint NOT NULL
);

CREATE TABLE `genre` (
	`genre_id` bigint NOT NULL,
	`genre` varchar(50) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (`genre_id`)
);

CREATE TABLE `cover` (
	`cover_id` bigint NOT NULL,
	`cover_view` varchar(50) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (`cover_id`)
);

CREATE TABLE `admin` (
	`id` bigint NOT NULL,
	`login` varchar(50) CHARACTER SET utf8 NOT NULL UNIQUE,
	`password` varchar(30) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `statuses` (
	`status_id` bigint NOT NULL,
	`status` varchar(40) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (`status_id`)
);

ALTER TABLE `book` ADD CONSTRAINT `book_fk0` FOREIGN KEY (`genre_id`) REFERENCES `genre`(`genre_id`);

ALTER TABLE `book` ADD CONSTRAINT `book_fk1` FOREIGN KEY (`cover_id`) REFERENCES `cover`(`cover_id`);

ALTER TABLE `orders` ADD CONSTRAINT `order_fk0` FOREIGN KEY (`client_id`) REFERENCES `client`(`client_id`);

ALTER TABLE `orders` ADD CONSTRAINT `order_fk1` FOREIGN KEY (`status_id`) REFERENCES `statuses`(`status_id`);

ALTER TABLE `orders_journal` ADD CONSTRAINT `order_journal_fk0` FOREIGN KEY (`order_id`) REFERENCES `orders`(`order_id`);

ALTER TABLE `orders_journal` ADD CONSTRAINT `order_journal_fk1` FOREIGN KEY (`book_id`) REFERENCES `book`(`book_id`);

ALTER TABLE `book_author` ADD CONSTRAINT `book_author_fk0` FOREIGN KEY (`author_id`) REFERENCES `author`(`author_id`);

ALTER TABLE `book_author` ADD CONSTRAINT `book_author_fk1` FOREIGN KEY (`book_id`) REFERENCES `book`(`book_id`);