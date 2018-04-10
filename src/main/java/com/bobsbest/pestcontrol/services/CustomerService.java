package com.bobsbest.pestcontrol.services;

import com.bobsbest.pestcontrol.models.*;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerService {
    private final NamedParameterJdbcTemplate jdbc;

    @Autowired
    public CustomerService(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Transactional
    public void addCustomer(Customer customer) {
        writeCustomer(customer);
        maybeWriteCustomerAddresses(customer);
        maybeWriteCustomerComments(customer);
        maybeWriteCustomerEmails(customer);
        maybeWriteCustomerPhones(customer);
    }

    public void updateCustomer(String refId, Customer customer) {
    }

    public Customer getCustomer(String refId) {
        List<CustomerAddress> addresses = jdbc.query(
                CustomerSql.GET_CUSTOMER_ADDRESSES.getSql(),
                ImmutableMap.of("refId", refId),
                (rs, rowNum) -> CustomerAddress.builder()
                        .type(rs.getString("ADDRESS_TYPE"))
                        .attn(rs.getString("ATTN"))
                        .firstName(rs.getString("FIRST_NAME"))
                        .lastName(rs.getString("LAST_NAME"))
                        .street(rs.getString("STREET"))
                        .city(rs.getString("CITY"))
                        .state(rs.getString("STATE"))
                        .zip(rs.getString("ZIP"))
                        .build());

        List<CustomerComment> comments = jdbc.query(
                CustomerSql.GET_CUSTOMER_COMMENTS.getSql(),
                ImmutableMap.of("refId", refId),
                (rs, rowNum) -> CustomerComment.builder()
                        .comment(rs.getString("COMMENT"))
                        .source(rs.getString("SOURCE"))
                        .dateAdded(toLocalDate(rs.getDate("DATE_ADDED")))
                        .user(rs.getString("USER_NAME"))
                        .build());

        List<CustomerEmail> emails = jdbc.query(
                CustomerSql.GET_CUSTOMER_EMAILS.getSql(),
                ImmutableMap.of("refId", refId),
                (rs, rowNum) -> CustomerEmail.builder()
                        .emailAddress(rs.getString("EMAIL_ADDRESS"))
                        .isPrimary(rs.getBoolean("IS_PRIMARY"))
                        .build());

        List<CustomerPhone> phones = jdbc.query(
                CustomerSql.GET_CUSTOMER_PHONES.getSql(),
                ImmutableMap.of("refId", refId),
                (rs, rowNum) -> CustomerPhone.builder()
                        .phoneNumber(rs.getString("PHONE_NUMBER"))
                        .type(rs.getString("PHONE_TYPE"))
                        .isPrimary(rs.getBoolean("IS_PRIMARY"))
                        .useForText(rs.getBoolean("USE_FOR_TEXT"))
                        .build());

        return jdbc.queryForObject(
                CustomerSql.GET_CUSTOMER.getSql(),
                ImmutableMap.of("refId", refId),
                (rs, rowNum) -> Customer.builder()
                        .refId(refId)
                        .active(rs.getBoolean("IS_ACTIVE"))
                        .firstName(rs.getString("FIRST_NAME"))
                        .lastName(rs.getString("LAST_NAME"))
                        .type(rs.getString("CUSTOMER_TYPE"))
                        .billed(rs.getBoolean("IS_BILLED"))
                        .corporateCode(rs.getString("CORPORATE_CODE"))
                        .leadName(rs.getString("LEAD_NAME"))
                        .cancelReason(rs.getString("CANCEL_REASON"))
                        .subdivision(rs.getString("SUBDIVISION"))
                        .signupDate(toLocalDate(rs.getDate("SIGNUP_DATE")))
                        .cancelDate(toLocalDate(rs.getDate("CANCEL_DATE")))
                        .addresses(addresses)
                        .comments(comments)
                        .emails(emails)
                        .phoneNumbers(phones)
                        .build());
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>();
    }

    private void writeCustomer(Customer customer) {
        jdbc.update(
                CustomerSql.ADD_CUSTOMER.getSql(),
                ImmutableMap.<String, Object>builder()
                        .put("refId", customer.getRefId())
                        .put("isActive", customer.isActive())
                        .put("firstName", customer.getFirstName())
                        .put("lastName", customer.getLastName())
                        .put("customerType", customer.getType())
                        .put("isBilled", customer.isBilled())
                        .put("corporateCode", customer.getCorporateCode())
                        .put("leadName", customer.getLeadName())
                        .put("cancelReason", customer.getCancelReason())
                        .put("subdivision", customer.getSubdivision())
                        .put("signupDate", customer.getSignupDate())
                        .put("cancelDate", customer.getCancelDate())
                        .build()
        );
    }

    private void maybeWriteCustomerAddresses(Customer customer) {
        customer.getAddresses().forEach(address ->
                jdbc.update(
                        CustomerSql.ADD_CUSTOMER_ADDRESS.getSql(),
                        ImmutableMap.<String, Object>builder()
                                .put("refId", customer.getRefId())
                                .put("addressType", address.getType())
                                .put("attn", address.getAttn())
                                .put("firstName", address.getFirstName())
                                .put("lastName", address.getLastName())
                                .put("street", address.getStreet())
                                .put("city", address.getCity())
                                .put("state", address.getState())
                                .put("zip", address.getZip())
                                .build()
                )
        );
    }

    private void maybeWriteCustomerComments(Customer customer) {
        customer.getComments().forEach(comment ->
                jdbc.update(
                        CustomerSql.ADD_CUSTOMER_COMMENT.getSql(),
                        ImmutableMap.<String, Object>builder()
                                .put("refId", customer.getRefId())
                                .put("comment", comment.getComment())
                                .put("source", comment.getSource())
                                .put("dateAdded", comment.getDateAdded())
                                .put("userName", comment.getUser())
                                .build()
                )
        );
    }

    private void maybeWriteCustomerEmails(Customer customer) {
        customer.getEmails().forEach(email ->
                jdbc.update(
                        CustomerSql.ADD_CUSTOMER_EMAIL.getSql(),
                        ImmutableMap.<String, Object>builder()
                                .put("refId", customer.getRefId())
                                .put("emailAddress", email.getEmailAddress())
                                .put("isPrimary", email.isPrimary())
                                .build()

                )
        );
    }

    private void maybeWriteCustomerPhones(Customer customer) {
        customer.getPhoneNumbers().forEach(phone ->
                jdbc.update(
                        CustomerSql.ADD_CUSTOMER_PHONE.getSql(),
                        ImmutableMap.<String, Object>builder()
                                .put("refId", customer.getRefId())
                                .put("phoneNumber", phone.getPhoneNumber())
                                .put("phoneType", phone.getType())
                                .put("isPrimary", phone.isPrimary())
                                .put("useForText", phone.isUseForText())
                                .build()
                )
        );
    }

    private LocalDate toLocalDate(Date date) {
        return date.toLocalDate();
    }
}
