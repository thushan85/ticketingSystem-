SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE `users`;
TRUNCATE `vehicles`;

INSERT INTO `users` (`id`, `nic`, `email`, `first_name`, `last_name`, `user_type`, `mobile_number`, `current_balance`) VALUES ('1', '1234567890', 'driver1@test.com', 'Test', 'Driver', 'DRIVER', '0777123123', '0.00');
INSERT INTO `users` (`id`, `nic`, `email`, `first_name`, `last_name`, `user_type`, `mobile_number`, `current_balance`) VALUES ('2', '1232345322', 'driver2@example.com', 'Test2', 'Driver', 'DRIVER', '0777111222', '0.00');
INSERT INTO `users` (`id`, `nic`, `email`, `first_name`, `last_name`, `user_type`, `mobile_number`, `current_balance`) VALUES ('4', '1232345322', 'driver3@example.com', 'Test3', 'Driver', 'DRIVER', '0777111555', '0.00');
INSERT INTO `users` (`id`, `nic`, `email`, `first_name`, `last_name`, `user_type`, `mobile_number`, `current_balance`) VALUES ('3', '6655718181', 'owner1@abc.com', 'Owner', 'owner-1', 'OWNER', '0777444333', '0.00');

INSERT INTO `vehicles` (`id`, `owner_id`, `reg_no`, `route_id`, `driver_id`) VALUES ('1', '3', 'NA-1020', '1', '1');
INSERT INTO `vehicles` (`id`, `owner_id`, `reg_no`, `route_id`, `driver_id`) VALUES ('2', '3', 'NB-3000', '2', '2');
INSERT INTO `vehicles` (`id`, `owner_id`, `reg_no`, `route_id`, `driver_id`) VALUES ('3', '3', 'NB-2000', '2', '4');

SET FOREIGN_KEY_CHECKS = 1;