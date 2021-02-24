CREATE SCHEMA `links` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `links`.`urls` (
                               `id` INT NOT NULL AUTO_INCREMENT,
                               `urlName` VARCHAR(45) NOT NULL,
                               `status` VARCHAR(45) NOT NULL,
                               `deleted` TINYINT NOT NULL DEFAULT 0,
                               PRIMARY KEY (`id`));
