CREATE TABLE `routes` (
         `id` INT NOT NULL AUTO_INCREMENT,
         `route_name` VARCHAR(45) NOT NULL,
         `route_number` VARCHAR(10) NOT NULL,
         `start_location` INT NOT NULL,
         `end_location` INT NOT NULL,
         `start_location_name` VARCHAR(45) NULL,
         `end_location_name` VARCHAR(45) NULL,
         PRIMARY KEY (`id`),
         INDEX `fk_routes_1_idx` (`start_location` ASC),
         INDEX `fk_routes_2_idx` (`end_location` ASC),
         CONSTRAINT `fk_routes_1`
             FOREIGN KEY (`start_location`)
                 REFERENCES `locations` (`id`)
                 ON DELETE NO ACTION
                 ON UPDATE NO ACTION,
         CONSTRAINT `fk_routes_2`
             FOREIGN KEY (`end_location`)
                 REFERENCES `locations` (`id`)
                 ON DELETE NO ACTION
                 ON UPDATE NO ACTION);

