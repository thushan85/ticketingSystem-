ALTER TABLE `trips`
DROP COLUMN `end_location_name`,
DROP COLUMN `start_location_name`,
DROP COLUMN `end_time`,
DROP COLUMN `start_time`,
DROP COLUMN `route_number`,
DROP COLUMN `route_name`,
ADD COLUMN `created_at` TIMESTAMP NOT NULL AFTER `is_current_trip`,
ADD COLUMN `updated_at` TIMESTAMP NOT NULL AFTER `created_at`,
CHANGE COLUMN `is_current` `is_current_trip` SMALLINT(1) NOT NULL DEFAULT '0' ;
