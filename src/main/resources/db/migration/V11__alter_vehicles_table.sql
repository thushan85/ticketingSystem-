ALTER TABLE `vehicles`
ADD COLUMN `route_id` INT(11) NULL AFTER `reg_no`,
ADD COLUMN `driver_id` INT(11) NULL AFTER `route_id`,
ADD INDEX `fk_vehicles_2_idx` (`route_id` ASC),
ADD INDEX `fk_vehicles_3_idx` (`driver_id` ASC);
;
ALTER TABLE `vehicles`
    ADD CONSTRAINT `fk_vehicles_2`
        FOREIGN KEY (`route_id`)
            REFERENCES `locations` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_vehicles_3`
  FOREIGN KEY (`driver_id`)
  REFERENCES `users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
