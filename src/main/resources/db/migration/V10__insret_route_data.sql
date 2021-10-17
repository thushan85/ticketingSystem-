
ALTER TABLE `locations`
    ADD COLUMN `name` VARCHAR(45) NULL AFTER `lng`;


SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE `locations`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `locations` (`id`, `lat`, `lng`, `name`) VALUES ('2', '6.952232', '80.212593', 'Avissawella');
INSERT INTO `locations` (`id`, `lat`, `lng`, `name`) VALUES ('3', '39.810699', '-84.247620', 'Colombo');
INSERT INTO `locations` (`id`, `lat`, `lng`, `name`) VALUES ('4', '-27.619570', '153.093216', 'Kadawatha');
INSERT INTO `locations` (`lat`, `lng`, `name`) VALUES ('6.716390', '79.913078', 'Panadura');

INSERT INTO  `routes` (`id`, `route_name`, `route_number`, `start_location`, `end_location`, `start_location_name`, `end_location_name`) VALUES ('1', 'Avissawella-Colombo', '122', '2', '3', 'Avissawella', 'Colombo');
INSERT INTO `routes` (`id`, `route_name`, `route_number`, `start_location`, `end_location`, `start_location_name`, `end_location_name`) VALUES ('2', 'Colombo-Kadawath', '138', '4', '3', 'Kadawatha', 'Colombo');
