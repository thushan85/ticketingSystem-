CREATE TABLE `journeys` (
   `id` INT NOT NULL,
   `passenger_id` INT NULL,
   `start_time` TIMESTAMP NOT NULL,
   `end_time` TIMESTAMP NOT NULL,
   `start_location_id` INT NOT NULL,
   `end_location_id` INT NOT NULL,
   `journey_fare` DECIMAL(10,2) NOT NULL DEFAULT 0.00,
   PRIMARY KEY (`id`),
   INDEX `fk_journies_1_idx` (`start_location_id` ASC),
   INDEX `fk_journies_2_idx` (`end_location_id` ASC),
   CONSTRAINT `fk_journeys1`
       FOREIGN KEY (`start_location_id`)
           REFERENCES `ticketing_system`.`locations` (`id`)
           ON DELETE NO ACTION
           ON UPDATE NO ACTION,
   CONSTRAINT `fk_journeys_2`
       FOREIGN KEY (`end_location_id`)
           REFERENCES `ticketing_system`.`locations` (`id`)
           ON DELETE NO ACTION
           ON UPDATE NO ACTION);

ALTER TABLE `journeys`
    CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `ticketing_system`.`journeys`
    ADD INDEX `fk_journeys_1_idx` (`passenger_id` ASC);
;
ALTER TABLE `journeys`
    ADD CONSTRAINT `fk_journeys_1`
        FOREIGN KEY (`passenger_id`)
            REFERENCES `ticketing_system`.`users` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

