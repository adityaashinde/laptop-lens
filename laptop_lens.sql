create database useraccount;

use useraccount;

CREATE TABLE `laptops` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `information` varchar(255) NOT NULL,
  `ram` int NOT NULL,
  `brand` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `storagetype` varchar(50) NOT NULL,
  `processor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
