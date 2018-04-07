DROP TABLE IF exists bobsbest_dev.CustomerAddress;

CREATE TABLE bobsbest_dev.CustomerAddress (
  CUSTOMER_REF_ID varchar(20) references bobsbest_dev.Customer(REF_ID),
  TYPE varchar(20),
  ATTN varchar(100),
  FIRST_NAME varchar(50),
  LAST_NAME varchar(50),
  STREET varchar(200),
  CITY varchar(50),
  STATE varchar(15),
  ZIP varchar(12)
);
