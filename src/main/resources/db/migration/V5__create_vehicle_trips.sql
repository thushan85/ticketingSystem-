CREATE TABLE `trips` (
                                            `id` INT NOT NULL AUTO_INCREMENT,
                                            `vehicle_id` INT NOT NULL,
                                            `route_name` VARCHAR(200) NOT NULL,
                                            `route_number` VARCHAR(45) NOT NULL,
                                            `start_time` TIME NOT NULL,
                                            `end_time` TIME NOT NULL,
                                            `current_location` INT NOT NULL,
                                            `is_current` SMALLINT(1) NOT NULL DEFAULT 0,
                                            `start_location_name` VARCHAR(45) NULL,
                                            `end_location_name` VARCHAR(45) NULL,
                                            PRIMARY KEY (`id`),
                                            INDEX `fk_trips_1_idx` (`vehicle_id` ASC),
                                            INDEX `fk_trips_2_idx` (`current_location` ASC),
                                            CONSTRAINT `fk_trips_1`
                                                FOREIGN KEY (`vehicle_id`)
                                                    REFERENCES `vehicles` (`id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION,
                                            CONSTRAINT `fk_trips_2`
                                                FOREIGN KEY (`current_location`)
                                                    REFERENCES `locations` (`id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION);
