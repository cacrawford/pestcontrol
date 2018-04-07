DROP TABLE IF exists bobsbest_dev.CustomerPhone;

CREATE TABLE bobsbest_dev.CustomerPhone (
  CUSTOMER_REF_ID varchar(20) references bobsbest_dev.Customer(REF_ID),
  PHONE_NUMBER varchar(20),
  PHONE_TYPE varchar(20),
  IS_PRIMARY boolean,
  USE_FOR_TEXT boolean
);
