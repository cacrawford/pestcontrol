INSERT INTO bobsbest_dev.CustomerComment (
  CUSTOMER_REF_ID,
  COMMENT,
  SOURCE,
  DATE_ADDED,
  USER_NAME
) VALUES (
  :refId,
  :comment,
  :source,
  :dateAdded,
  :userName
);
