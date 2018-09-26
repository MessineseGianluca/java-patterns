CREATE DATABASE footballers;

use footballers;

CREATE TABLE team (
  id AUTO_INCREMENT INT PRIMARY KEY,
  name varchar(256) NOT NULL
);


CREATE TABLE footballer (
  id AUTO_INCREMENT INT PRIMARY KEY,
  name varchar(256) NOT NULL,
  nationality varchar(256) NOT NULL,
  teamId INT NOT NULL,
  FOREIGN KEY (teamId) REFERENCES team(id)
);