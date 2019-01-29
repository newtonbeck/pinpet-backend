CREATE DATABASE `pinpet`;

USE `pinpet`;

CREATE TABLE `users` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(255) NOT NULL
);

CREATE TABLE `pets` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255),
  `user_id` INT,
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`)
);

CREATE TABLE `locations` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `pet_id` INT,
  `latitude` REAL,
  `longitude` REAL,
  `height` REAL,
  `created_at` TIMESTAMP,
  FOREIGN KEY (`pet_id`) REFERENCES `pets`(`id`)
);
