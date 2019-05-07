DROP TABLE IF EXISTS tenants;

CREATE TABLE tenants (
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO tenants(name) values ('T1');
INSERT INTO tenants(name) values ('T2');

DELETE FROM orders;
DELETE FROM donations;
DELETE FROM donors;
DELETE FROM charities;

INSERT INTO charities (id, date_created, last_updated, name, ein, description)
  values(1, now(), now(), "Red Cross", "55-77777777", "disaster relief");

INSERT INTO charities (id, date_created, last_updated, name, ein, description)
values(2, now(), now(), "American Cancer Soc", "44-4545454545", "medical research");

INSERT INTO donors (id, date_created, last_updated, name, age)
    values(1, now(), now(), "Bob Jones", 30);

INSERT INTO donors (id, date_created, last_updated, name, age)
values(2, now(), now(), "Sally Smith", 29);