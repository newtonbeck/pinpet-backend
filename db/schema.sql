CREATE DATABASE `pinpet`;

USE `pinpet`;

CREATE TABLE `users` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(255) NOT NULL,
  `created-at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `pets` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255),
  `user-id` INT,
  `created-at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (`user-id`) REFERENCES `users`(`id`)
);

CREATE TABLE `locations` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `pet-id` INT,
  `latitude` REAL,
  `longitude` REAL,
  `height` REAL,
  `created-at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (`pet-id`) REFERENCES `pets`(`id`)
);
