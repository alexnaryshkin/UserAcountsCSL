package com.example.demo.registration.UserRegistration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserRegistrationWorkRequest {
    private String company;
    private String title;
    private String location;
    private String startDate;
    private String endDate;
    private String description;
}
