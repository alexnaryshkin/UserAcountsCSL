package com.example.demo.registration;
import com.example.demo.AppMVC.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String lastName;
    private final String firstName;
    private final String userName;
    private final String email;
    private final String password;
    private final AppUserRole appUserRole;
}
