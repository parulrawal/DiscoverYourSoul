create table Visitor
(
  id int not null AUTO_INCREMENT ,
  name varchar(255) not null ,
  gender varchar(20)default NULL ,
  birth_date DATE default NULL ,
  email VARCHAR(20) DEFAULT NULL ,
  primary key(id)
);

Alter table Visitor modify COLUMN id int AUTO_INCREMENT;

RENAME TABLE Visitor TO visitor;

Create table user
(
  id int NOT NULL AUTO_INCREMENT,
  name varchar(50) not null,
  email VARCHAR(50) NOT NULL ,
  PRIMARY KEY (id)
);


