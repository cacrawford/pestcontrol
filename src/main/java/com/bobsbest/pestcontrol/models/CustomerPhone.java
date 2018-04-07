package com.bobsbest.pestcontrol.models;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerPhone {
    private String phoneNumber;
    private String type;
    private boolean isPrimary;
    private boolean useForText;
}
