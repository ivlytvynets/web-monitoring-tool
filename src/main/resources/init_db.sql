CREATE SCHEMA `links` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `links`.`urls` (
                                `id` INT NOT NULL AUTO_INCREMENT,
                                `url_name` VARCHAR(45) NOT NULL,
                                `status` VARCHAR(45) NOT NULL DEFAULT 'OK',
                                `ping` INT NOT NULL,
                                `code_response` INT NOT NULL,
                                `content_size` FLOAT NOT NULL,
                                PRIMARY KEY (`id`));
