
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS donations;

CREATE TABLE donations (
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  content VARCHAR(255) NOT NULL,
  description VARCHAR(255) NULL,
  severity VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO users(first_name, last_name)
VALUES ('Jack', 'Jones');

INSERT INTO donations(content, description, severity)
VALUES ('Install Error', 'Unable to install new application', 'Medium');

INSERT INTO donations(content, description, severity)
VALUES ('Billing Error', 'I was charged for my ride twice', 'High');
