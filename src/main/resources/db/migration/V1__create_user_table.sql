CREATE TABLE `ticketing_system`.`users` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `nic` VARCHAR(12) NOT NULL COMMENT 'nic = nic or pp number',
    `first_name` VARCHAR(100) NOT NULL,
    `last_name` VARCHAR(100) NOT NULL,
    `user_type` VARCHAR(40) NOT NULL COMMENT 'user_types 	= PASSENGER\n			= TRANSPORT_MANGER\n			= BUS_OWNER		',
    `mobile_number` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`id`));
CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1