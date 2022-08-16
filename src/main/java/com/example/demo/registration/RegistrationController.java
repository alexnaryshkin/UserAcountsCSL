package com.example.demo.registration;

import com.example.demo.AppMVC.AppUserInformation.AppUserInformationService;
import com.example.demo.AppMVC.AppUserModel;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping("/{id}")
    public AppUserModel getUser(@PathVariable("id") Long id) {
        return registrationService.getUser(id);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
