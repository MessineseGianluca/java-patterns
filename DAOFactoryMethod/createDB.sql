DROP DATABASE IF EXISTS footballers;
CREATE DATABASE footballers;

use footballers;

CREATE TABLE team (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name varchar(256) NOT NULL
);

CREATE TABLE footballer (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name varchar(256) NOT NULL,
  nationality varchar(256) NOT NULL,
  teamId INT NOT NULL,
  FOREIGN KEY (teamId) REFERENCES team(id)
);