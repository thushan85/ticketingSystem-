ALTER TABLE `journeys`
    ADD COLUMN `trip_id` INT NULL AFTER `journey_fare`,
    ADD COLUMN `is_current` INT NOT NULL DEFAULT 0 AFTER `trip_id`,

ADD INDEX `fk_journeys_3_idx` (`trip_id` ASC);
;
ALTER TABLE `journeys`
    ADD CONSTRAINT `fk_journeys_3`
        FOREIGN KEY (`trip_id`)
            REFERENCES `trips` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;
