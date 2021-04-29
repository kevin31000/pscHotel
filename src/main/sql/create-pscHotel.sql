/* DELETE 'pscHotel' database*/
DROP SCHEMA IF EXISTS pscHotel;
/* DELETE USER 'spq' AT LOCAL SERVER*/
DROP USER IF EXISTS 'spq'@'localhost';

/* CREATE 'pscHotel' DATABASE */
CREATE SCHEMA pscHotel;
/* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'spq' */
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON pscHotel.* TO 'spq'@'localhost';