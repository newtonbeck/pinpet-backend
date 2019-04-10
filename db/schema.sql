CREATE DATABASE `pinpet` CHARACTER SET `UTF8` COLLATE `utf8_bin`;

USE `pinpet`;

CREATE TABLE `users` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(255) NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `trackers` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `code` VARCHAR(6) NOT NULL,
  `user_id` INT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`)
);

CREATE TABLE `trackers_events` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `tracker_id` INT NOT NULL,
  `latitude` REAL,
  `longitude` REAL,
  `height` REAL,
  `battery_level` REAL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (`tracker_id`) REFERENCES `trackers`(`id`)
);

CREATE TABLE `pets` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `user_id` INT NOT NULL,
  `tracker_id` INT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
  FOREIGN KEY (`tracker_id`) REFERENCES `trackers`(`id`)
);
