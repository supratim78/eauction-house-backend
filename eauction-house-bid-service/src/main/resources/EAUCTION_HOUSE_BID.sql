CREATE SCHEMA `eauction_house_bid` ;

create user 'dev'@'%' identified by 'password1'; -- Creates the user;
grant all on eauction_house_bid.* to 'dev'@'%'; -- Gives all privileges to the new user on the newly created database

CREATE TABLE `eauction_house_bid`.`bid` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` INT NULL,
  `BID_AMOUNT` INT NULL,
  PRIMARY KEY (`ID`));

ALTER TABLE `eauction_house_bid`.`bid` 
ADD COLUMN `BUYER_ID` INT NULL AFTER `BID_AMOUNT`;