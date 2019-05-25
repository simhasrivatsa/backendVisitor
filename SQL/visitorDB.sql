drop database if exists greyamp;

create database greyamp;

use greyamp;

CREATE TABLE visitors (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `record_id` varchar(256) NOT NULL DEFAULT '',
  `ip_address` varchar(72) NOT NULL DEFAULT '',
  `visit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`record_id`),
  KEY `ip_address` (`ip_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;