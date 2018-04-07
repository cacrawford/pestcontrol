package com.bobsbest.pestcontrol.models;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerAddress {
    private String type;
    private String attn;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;
}
