package com.bobsbest.pestcontrol.models;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class CustomerComment {
    private String comment;
    private String source;
    private LocalDate dateAdded;
    private String user;
}
