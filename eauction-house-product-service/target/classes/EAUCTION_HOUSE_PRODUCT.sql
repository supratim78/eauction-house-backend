CREATE SCHEMA `eauction_house_product` ;

create user 'dev'@'%' identified by 'password1'; -- Creates the user;

grant all on eauction_house_product.* to 'dev'@'%'; -- Gives all privileges to the new user on the newly created database

CREATE TABLE `eauction_house_product`.`product` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` VARCHAR(100) NULL,
  `SHORT_DESCRIPTION` VARCHAR(50) NULL,
  `DETAIL_DESCRIPTION` VARCHAR(200) NULL,
  `CATEGORY` VARCHAR(45) NULL,
  `STARTING_PRICE` INT NULL,
  `BID_END_DATE` DATE NULL,
  `SELLER_ID` INT NULL,
  PRIMARY KEY (`ID`));
  
  ALTER TABLE `eauction_house_product`.`product` 
CHANGE COLUMN `DETAIL_DESCRIPTION` `DETAILED_DESCRIPTION` VARCHAR(200) NULL DEFAULT NULL ;

