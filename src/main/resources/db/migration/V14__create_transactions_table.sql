CREATE TABLE `user_transactions` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT(11) NOT NULL,
    `transaction_type` VARCHAR(15) NOT NULL,
    `amount` DECIMAL(8,2) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_user_transactions_1_idx` (`user_id` ASC),
    CONSTRAINT `fk_user_transactions_1`
        FOREIGN KEY (`user_id`)
            REFERENCES `users` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION);
