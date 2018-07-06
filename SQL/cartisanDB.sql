drop database if exists cartisan;

create database cartisan;

use cartisan;

CREATE TABLE repairs (
  `enquiry_id` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(36) NOT NULL DEFAULT '',
  `email_id` varchar(36) NOT NULL DEFAULT '',
  `phone_no` varchar(36) NOT NULL DEFAULT '',
  `description` text CHARACTER SET utf8,
  `vehicle_pictures` varchar(512) DEFAULT '',
  `vehicle_model` varchar(36) DEFAULT '',
  PRIMARY KEY (`enquiry_id`),
  KEY `phone_no` (`phone_no`),
  KEY `email_id` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;