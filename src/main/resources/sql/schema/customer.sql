DROP TABLE IF exists bobsbest_dev.Customer;

CREATE TABLE bobsbest_dev.Customer (
  REF_ID varchar (10) UNIQUE,
  IS_ACTIVE boolean,
  FIRST_NAME varchar(50),
  LAST_NAME varchar(50),
  CUSTOMER_TYPE varchar(20),
  IS_BILLED boolean,
  CORPORATE_CODE varchar(10),
  LEAD_NAME varchar(100),
  CANCEL_REASON varchar(300),
  SUBDIVISION varchar(20),
  SIGNUP_DATE date,
  CANCEL_DATE date
);

CREATE INDEX CUSTOMER_REF_ID on bobsbest_dev.Customer(REF_ID);
