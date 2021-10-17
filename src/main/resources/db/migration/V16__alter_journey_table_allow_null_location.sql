ALTER TABLE `journeys`
DROP FOREIGN KEY `fk_journeys_2`;
ALTER TABLE `ticketing_system`.`journeys`
    CHANGE COLUMN `end_location_id` `end_location_id` INT(11) NULL DEFAULT 0 ;
ALTER TABLE `journeys`
    ADD CONSTRAINT `fk_journeys_2`
        FOREIGN KEY (`end_location_id`)
            REFERENCES `locations` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;
