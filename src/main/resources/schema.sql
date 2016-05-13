DROP TABLE IF EXISTS `users`;
CREATE TABLE users
(
    id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    email varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS `city`;
create table city (
id int(11) NOT NULL AUTO_INCREMENT,
name varchar(45) , state varchar(45) ,
country varchar(45) ,
    PRIMARY KEY (id));

