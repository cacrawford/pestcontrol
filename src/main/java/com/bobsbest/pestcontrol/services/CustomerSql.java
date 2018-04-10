package com.bobsbest.pestcontrol.services;

import com.google.common.io.Resources;

public enum CustomerSql {
    ADD_CUSTOMER("sql/queries/add_customer.sql"),
    ADD_CUSTOMER_ADDRESS("sql/queries/add_customer_address.sql"),
    ADD_CUSTOMER_COMMENT("sql/queries/add_customer_comment.sql"),
    ADD_CUSTOMER_EMAIL("sql/queries/add_customer_email.sql"),
    ADD_CUSTOMER_PHONE("sql/queries/add_customer_phone"),
    GET_CUSTOMER("sql/queries/get_customer.sql"),
    GET_CUSTOMER_ADDRESSES("sql/queries/get_customer_addresses.sql"),
    GET_CUSTOMER_COMMENTS("sql/queries/get_customer_comments.sql"),
    GET_CUSTOMER_EMAILS("sql/queries/get_customer_emails.sql"),
    GET_CUSTOMER_PHONES("sql/queries/get_customer_phones.sql")
    ;

    private String resourcePath;

    CustomerSql(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    String getSql() {
        return Resources.getResource(resourcePath).toString();
    }
}
