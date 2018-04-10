package com.bobsbest.pestcontrol.models;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
public class Customer {
    private String refId;
    private boolean active;
    private String firstName;
    private String lastName;
    private String type;
    private boolean billed;
    private String corporateCode;
    private String leadName;
    private String cancelReason;
    private String subdivision;
    private LocalDate signupDate;
    private LocalDate cancelDate;
    private List<CustomerAddress> addresses;
    private List<CustomerComment> comments;
    private List<CustomerEmail> emails;
    private List<CustomerPhone> phoneNumbers;
}

