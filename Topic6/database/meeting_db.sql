/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `meetings_db`;

CREATE DATABASE `meetings_db`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `meetings_db`;

#
# Dropping database objects
#

DROP TABLE IF EXISTS `meeting_attendee`;
DROP TABLE IF EXISTS `meeting`;
DROP TABLE IF EXISTS `room`;
DROP TABLE IF EXISTS `attendee`;

#
# Structure for the `attendee` table : 
#

CREATE TABLE `attendee` (
  `id_attendee` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `first_name` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`id_attendee`) COMMENT ''
)ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `room` table : 
#

CREATE TABLE `room` (
  `id_room` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`id_room`) COMMENT ''
)ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `meeting` table : 
#

CREATE TABLE `meeting` (
  `id_meetings` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `starting_time` DATETIME NOT NULL,
  `ending_time` DATETIME NOT NULL,
  `id_room` BIGINT(20) NOT NULL,
  PRIMARY KEY USING BTREE (`id_meetings`) COMMENT '',
   INDEX `id_room` USING BTREE (`id_room`) COMMENT '',
  CONSTRAINT `meeting_room_fk` FOREIGN KEY (`id_room`) REFERENCES `room` (`id_room`) ON UPDATE CASCADE
)ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;

#
# Structure for the `meeting_attendee` table : 
#

CREATE TABLE `meeting_attendee` (
  `id_meeting` BIGINT(20) NOT NULL,
  `id_attendee` BIGINT(20) NOT NULL,
  PRIMARY KEY USING BTREE (`id_attendee`, `id_meeting`) COMMENT '',
   INDEX `id_meeting` USING BTREE (`id_meeting`) COMMENT '',
   INDEX `id_attendee` USING BTREE (`id_attendee`) COMMENT '',
  CONSTRAINT `meeting_attendee_attendee_fk` FOREIGN KEY (`id_attendee`) REFERENCES `attendee` (`id_attendee`) ON UPDATE CASCADE,
  CONSTRAINT `meeting_attendee_meeting_fk` FOREIGN KEY (`id_meeting`) REFERENCES `meeting` (`id_meetings`) ON UPDATE CASCADE
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT=''
;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

