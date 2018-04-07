package com.bobsbest.pestcontrol.models;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerEmail {
    String emailAddress;
    boolean isPrimary;
}
