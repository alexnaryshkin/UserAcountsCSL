package com.example.demo.registration.UserRegistration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserRegistrationInterestRequest {
    private String[] industries;
    private String[] location;
    private String[] roles;
}
