CREATE SCHEMA `eauction_house_seller` ;
create user 'dev'@'%' identified by 'password1'; -- Creates the user;
grant all on eauction_house_seller.* to 'dev'@'%'; -- Gives all privileges to the new user on the newly created database