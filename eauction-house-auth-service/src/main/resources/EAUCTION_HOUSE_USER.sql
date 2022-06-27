CREATE SCHEMA `eauction_house_user` ;

create user 'dev'@'%' identified by 'password1'; -- Creates the user;
grant all on eauction_house_bid.* to 'dev'@'%'; -- Gives all privileges to the new user on the newly created database

CREATE TABLE `eauction_house_user`.`user` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NULL,
  `EMAIL` VARCHAR(100) NULL,
  `PASSWORD` VARCHAR(100) NULL,
  `CONFIRM_PASSWORD` VARCHAR(100) NULL,
  `TYPE` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));