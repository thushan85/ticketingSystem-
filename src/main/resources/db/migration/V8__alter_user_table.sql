ALTER TABLE `users`
    ADD COLUMN `current_balance` DECIMAL(8,2) NOT NULL DEFAULT 0.00 AFTER `mobile_number`;
