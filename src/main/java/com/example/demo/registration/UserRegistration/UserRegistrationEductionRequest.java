package com.example.demo.registration.UserRegistration;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserRegistrationEductionRequest {
    private String education;
    private String degree;
    private String major;
    private double GPA;
    private String[] clubs;
    private String[] courses;
    private String startDate;
    private String graduationDate;
}
