
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
VALUES ('Sally', 'Smith');

INSERT INTO donations(content, description, severity)
VALUES ('Login Error', 'Unable to log into application', 'High');

INSERT INTO donations(content, description, severity)
VALUES ('Network Error', 'Network has not responded in over 5 minutes', 'High');
