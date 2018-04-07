DROP TABLE IF exists bobsbest_dev.CustomerComment;

CREATE TABLE bobsbest_dev.CustomerComment (
  CUSTOMER_REF_ID varchar(20) references bobsbest_dev.Customer(REF_ID),
  COMMENT varchar(500),
  SOURCE varchar(10),
  DATE_ADDED date,
  USER_NAME varchar(50)
);
