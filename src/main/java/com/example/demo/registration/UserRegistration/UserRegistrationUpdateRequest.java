package com.example.demo.registration.UserRegistration;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserRegistrationUpdateRequest {
    private final String resumeURL;
    private final String profilePicURL;
    private final String coverLetterURL;
    private final String websiteURL;
    private final String bio;
    private final String[] skills;
}
