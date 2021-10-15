ALTER TABLE `users`
    ADD COLUMN `email` VARCHAR(255) NULL AFTER `nic`,
    ADD UNIQUE INDEX `uc_user_email` (`email`);

ALTER TABLE `users`
    ADD UNIQUE INDEX `user_unique_comb` (`email`, `nic`);
