CREATE DATABASE `sharknado` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `chainsawnumber` (
  `id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  `chainsaw_type_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `chainsawtype` (
  `id` int(11) NOT NULL,
  `type` tinytext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `name` tinytext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `population` (
  `id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  `women_number` int(11) NOT NULL,
  `men_number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `sharknado`.`location` (`id`,`name`) VALUES (1,'New York');
INSERT INTO `sharknado`.`location` (`id`,`name`) VALUES (2,'Dallas');
INSERT INTO `sharknado`.`location` (`id`,`name`) VALUES (3,'Los Angeles');
INSERT INTO `sharknado`.`location` (`id`,`name`) VALUES (4,'Las Vegas');

INSERT INTO `sharknado`.`chainsawtype` (`id`,`type`) VALUES (1,"Electronic");
INSERT INTO `sharknado`.`chainsawtype` (`id`,`type`) VALUES (2,"Gasoline");

INSERT INTO `sharknado`.`population` (`id`,`location_id`,`women_number`,`men_number`) VALUES (1,1,5400,4200);
INSERT INTO `sharknado`.`population` (`id`,`location_id`,`women_number`,`men_number`) VALUES (2,2,2740,2460);
INSERT INTO `sharknado`.`population` (`id`,`location_id`,`women_number`,`men_number`) VALUES (3,3,4850,3890);
INSERT INTO `sharknado`.`population` (`id`,`location_id`,`women_number`,`men_number`) VALUES (4,4,900,840);

INSERT INTO `sharknado`.`chainsawnumber` (`id`,`location_id`,`chainsaw_type_id`,`number`) VALUES (1,1,1,1500);
INSERT INTO `sharknado`.`chainsawnumber` (`id`,`location_id`,`chainsaw_type_id`,`number`) VALUES (2,1,2,1000);
INSERT INTO `sharknado`.`chainsawnumber` (`id`,`location_id`,`chainsaw_type_id`,`number`) VALUES (3,2,1,500);
INSERT INTO `sharknado`.`chainsawnumber` (`id`,`location_id`,`chainsaw_type_id`,`number`) VALUES (4,2,2,0);
INSERT INTO `sharknado`.`chainsawnumber` (`id`,`location_id`,`chainsaw_type_id`,`number`) VALUES (5,3,1,1100);
INSERT INTO `sharknado`.`chainsawnumber` (`id`,`location_id`,`chainsaw_type_id`,`number`) VALUES (6,3,2,900);
INSERT INTO `sharknado`.`chainsawnumber` (`id`,`location_id`,`chainsaw_type_id`,`number`) VALUES (7,4,1,1700);
INSERT INTO `sharknado`.`chainsawnumber` (`id`,`location_id`,`chainsaw_type_id`,`number`) VALUES (8,4,2,1900);

