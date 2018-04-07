DROP TABLE IF exists bobsbest_dev.CustomerEmail;

CREATE TABLE bobsbest_dev.CustomerEmail (
  CUSTOMER_REF_ID varchar(20) references bobsbest_dev.Customer(REF_ID),
  EMAIL_ADDRESS varchar(200),
  IS_PRIMARY boolean
);
