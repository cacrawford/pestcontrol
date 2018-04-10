INSERT INTO bobsbest_dev.CustomerAddress (
  CUSTOMER_REF_ID,
  ADDRESS_TYPE,
  ATTN,
  FIRST_NAME,
  LAST_NAME,
  STREET,
  CITY,
  STATE,
  ZIP
) VALUES (
  :refId,
  :addressType,
  :attn,
  :firstName,
  :lastName,
  :street,
  :city,
  :state,
  :zip
);
