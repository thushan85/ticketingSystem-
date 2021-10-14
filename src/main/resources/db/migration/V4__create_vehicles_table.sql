CREATE TABLE `vehicles` (
   `id` INT NOT NULL AUTO_INCREMENT,
   `owner_id` INT NULL,
   `reg_no` VARCHAR(15) NULL,
   PRIMARY KEY (`id`),
   INDEX `fk_vehicles_1_idx` (`owner_id` ASC),
   CONSTRAINT `fk_vehicles_1`
       FOREIGN KEY (`owner_id`)
           REFERENCES `users` (`id`)
           ON DELETE NO ACTION
           ON UPDATE NO ACTION
);