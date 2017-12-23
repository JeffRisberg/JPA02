DROP TABLE IF EXISTS tenant;

CREATE TABLE tenant (
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO tenant(name) values ('T1');
INSERT INTO tenant(name) values ('T2');
