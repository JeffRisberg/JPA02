DROP TABLE IF EXISTS tenants;

CREATE TABLE tenants (
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO tenants(name) values ('T1');
INSERT INTO tenants(name) values ('T2');
