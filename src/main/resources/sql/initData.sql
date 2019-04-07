-- Wyczyszczenie bazy
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS orders_products;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;

-- Tabela z użytkownikami
CREATE TABLE `users`
(
  `user_id`      bigint       NOT NULL AUTO_INCREMENT,
  `first_name`   varchar(100) DEFAULT NULL,
  `last_name`    varchar(100) DEFAULT NULL,
  `login`        varchar(100) NOT NULL,
  `email`        varchar(100) NOT NULL,
  `password`     varchar(100) NOT NULL,
  `phone_number` varchar(20),
  `address`      varchar(255),
  `postcode`     varchar(20),
  `city`         varchar(100),
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ow0gan20590jrb00upg3va2fn` (`login`)
);

-- Tabela z rolami użytkowników
CREATE TABLE `users_roles`
(
  `id`    bigint       NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `role`  varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

-- Tabela z zamówieniami
CREATE TABLE `orders`
(
  `order_id`     bigint NOT NULL AUTO_INCREMENT,
  `user_id`      bigint NOT NULL,
  `status`       varchar(100),
  `order_date`   date,
  `change_state` date,
  `description`  varchar(255),
  `total_cost`   decimal(15, 2),
  PRIMARY KEY (`order_id`),
  CONSTRAINT `FK9740l3kh8nu2fg4wmqvotf9u` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);

-- Tabela z kategoriami
CREATE TABLE `categories`
(
  `category_id` bigint       NOT NULL AUTO_INCREMENT,
  `name`        varchar(100) NOT NULL,
  `description` varchar(255),
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `UK_5snij5p1dj99c9kbmcuvsjjav` (`name`)
);

-- Tabela z produktami
CREATE TABLE `products`
(
  `product_id`         bigint         NOT NULL AUTO_INCREMENT,
  `name`               varchar(100)   NOT NULL,
  `price`              decimal(15, 2) NOT NULL,
  `warehouse_quantity` bigint         NOT NULL,
  `category_id`        bigint         NOT NULL,
  `description`        varchar(255),
  PRIMARY KEY (`product_id`),
  CONSTRAINT `FKc59alvkbjppgpy6i2d78yxj0u` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`)
);

-- Tabela z przypisaniem produktów do zamówienia
CREATE TABLE `orders_products`
(
  `id`         bigint NOT NULL AUTO_INCREMENT,
  `order_id`   bigint NOT NULL,
  `product_id` bigint NOT NULL,
  `quantity`   bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKeei7p9n9614j8chm4n9ydxukg` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `FKrkihyc1feqqekl9evawv8kg0q` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
);

ALTER TABLE categories CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE orders CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE orders_products CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE products CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE users CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE users_roles CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;