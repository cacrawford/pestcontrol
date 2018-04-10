INSERT INTO bobsbest_dev.Customer(
  REF_ID,
  IS_ACTIVE,
  FIRST_NAME,
  LAST_NAME,
  CUSTOMER_TYPE,
  IS_BILLED,
  CORPORATE_CODE,
  LEAD_NAME,
  CANCEL_REASON,
  SUBDIVISION,
  SIGNUP_DATE,
  CANCEL_DATE
) VALUES (
  :refId,
  :isActive,
  :firstName,
  :lastName,
  :customerType,
  :isBilled,
  :corporateCode,
  :leadName,
  :cancelReason,
  :subdivision,
  :signupDate,
  :cancelDate
);
