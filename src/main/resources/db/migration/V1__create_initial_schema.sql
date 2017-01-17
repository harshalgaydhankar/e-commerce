CREATE TABLE `products` (
  `name` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `reviews` int(11) DEFAULT NULL,
  `list_price` float DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `actual_price` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `restricted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
