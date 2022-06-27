CREATE SCHEMA `eauction_house_buyer` ;

create user 'dev'@'%' identified by 'password1'; -- Creates the user;
grant all on eauction_house_buyer.* to 'dev'@'%'; -- Gives all privileges to the new user on the newly created database

CREATE TABLE `eauction_house_buyer`.`buyer` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` VARCHAR(100) NULL,
  `LAST_NAME` VARCHAR(100) NULL,
  `ADDRESS` VARCHAR(100) NULL,
  `CITY` VARCHAR(100) NULL,
  `STATE` VARCHAR(100) NULL,
  `PIN` VARCHAR(10) NULL,
  `PHONE` VARCHAR(10) NULL,
  `EMAIL` VARCHAR(100) NULL,
  PRIMARY KEY (`ID`));