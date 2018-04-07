package com.bobsbest.pestcontrol.models;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

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
}

