package com.example.demo.registration.UserRegistration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserRegistrationProjectRequest {
    private String name;
    private String description;
    private String[] pictures;
    private String[] relevantWebsites;
}
