INSERT INTO bobsbest_dev.CustomerPhone (
  CUSTOMER_REF_ID,
  PHONE_NUMBER,
  PHONE_TYPE,
  IS_PRIMARY,
  USE_FOR_TEXT
) VALUES (
  :refId,
  :phoneNumber,
  :phoneType,
  :isPrimary,
  :useForText
);
