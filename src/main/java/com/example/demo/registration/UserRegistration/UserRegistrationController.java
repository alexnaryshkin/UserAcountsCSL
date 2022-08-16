package com.example.demo.registration.UserRegistration;

import com.example.demo.AppMVC.AppUserInformation.AppUserInformationModel;
import com.example.demo.AppMVC.AppUserInformation.AppUserInformationService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.AppMVC.AppUserInformation.UserEducation.UserEducationModel;
import com.example.demo.AppMVC.AppUserInformation.UserInterest.UserInterestModel;
import com.example.demo.AppMVC.AppUserInformation.UserProject.UserProjectModel;
import com.example.demo.AppMVC.AppUserInformation.UserWork.UserWorkModel;

@RestController
@RequestMapping(path = "api/v1/registration/information")
@AllArgsConstructor
public class UserRegistrationController {
    private UserRegistrationService userRegistrationService;

    @PutMapping("/{id}")
    public String register(@PathVariable("id") Long appUserId,
                           @RequestBody UserRegistrationUpdateRequest request) {
        return userRegistrationService.update(appUserId, request);
    }

    @PostMapping("/{id}/education")
    public String registerEducation(@PathVariable("id") Long appUserId,
                                    @RequestBody UserRegistrationEductionRequest request) {
        return userRegistrationService.registerEducation(appUserId, request);
    }

    @PostMapping("/{id}/interest")
    public String registerInterest(@PathVariable("id") Long appUserId,
                                    @RequestBody UserRegistrationInterestRequest request) {
        return userRegistrationService.registerInterest(appUserId, request);
    }

    @PostMapping("/{id}/project")
    public String registerProject(@PathVariable("id") Long appUserId,
                                    @RequestBody UserRegistrationProjectRequest request) {
        return userRegistrationService.registerProject(appUserId, request);
    }

    @PostMapping("/{id}/work")
    public String registerWork(@PathVariable("id") Long appUserId,
                                    @RequestBody UserRegistrationWorkRequest request) {
        return userRegistrationService.registerWork(appUserId, request);
    }

    @PutMapping("/{id}/education/{order}")
    public String updateEducation(@PathVariable("id") Long appUserId,
                                  @PathVariable("order") int order,
                                  @RequestBody UserRegistrationEductionRequest request) {
        return userRegistrationService.updateEducation(appUserId, order, request);
    }

    @PutMapping("/{id}/interest/{order}")
    public String updateInterest(@PathVariable("id") Long appUserId,
                                  @PathVariable("order") int order,
                                  @RequestBody UserRegistrationInterestRequest request) {
        return userRegistrationService.updateInterest(appUserId, order, request);
    }

    @PutMapping("/{id}/work/{order}")
    public String updateWork(@PathVariable("id") Long appUserId,
                                  @PathVariable("order") int order,
                                  @RequestBody UserRegistrationWorkRequest request) {
        return userRegistrationService.updateWork(appUserId, order, request);
    }

    @PutMapping("/{id}/project/{order}")
    public String updateProject(@PathVariable("id") Long appUserId,
                                  @PathVariable("order") int order,
                                  @RequestBody UserRegistrationProjectRequest request) {
        return userRegistrationService.updateProject(appUserId, order, request);
    }

    @GetMapping("/{id}/education")
    public List<UserEducationModel> getEducation(@PathVariable("id") Long appUserId){
        return userRegistrationService.getEducation(appUserId);
    }

    @GetMapping("/{id}/interest")
    public List<UserInterestModel> getInterests(@PathVariable("id") Long appUserId){
        return userRegistrationService.getInterests(appUserId);
    }
    
    @GetMapping("/{id}/project")
    public List<UserProjectModel> getProject(@PathVariable("id") Long appUserId){
        return userRegistrationService.getProject(appUserId);
    }

    @GetMapping("/{id}/work")
    public List<UserWorkModel> getWork(@PathVariable("id") Long appUserId){
        return userRegistrationService.getWork(appUserId);
    }

    @GetMapping("/{id}")
    public AppUserInformationModel getUserInformation(@PathVariable("id") Long appUserId) {
        return userRegistrationService.getUserInformation(appUserId);
    }
}
