package com.example.demo.registration.UserRegistration;

import com.example.demo.AppMVC.AppUserInformation.AppUserInformationModel;
import com.example.demo.AppMVC.AppUserInformation.AppUserInformationRepository;
import com.example.demo.AppMVC.AppUserInformation.AppUserInformationService;
import com.example.demo.AppMVC.AppUserInformation.UserEducation.UserEducationModel;
import com.example.demo.AppMVC.AppUserInformation.UserEducation.UserEducationRepository;
import com.example.demo.AppMVC.AppUserInformation.UserEducation.UserEducationService;
import com.example.demo.AppMVC.AppUserInformation.UserInterest.UserInterestModel;
import com.example.demo.AppMVC.AppUserInformation.UserInterest.UserInterestRepository;
import com.example.demo.AppMVC.AppUserInformation.UserInterest.UserInterestService;
import com.example.demo.AppMVC.AppUserInformation.UserProject.UserProjectModel;
import com.example.demo.AppMVC.AppUserInformation.UserProject.UserProjectRepository;
import com.example.demo.AppMVC.AppUserInformation.UserProject.UserProjectService;
import com.example.demo.AppMVC.AppUserInformation.UserWork.UserWorkModel;
import com.example.demo.AppMVC.AppUserInformation.UserWork.UserWorkRepository;
import com.example.demo.AppMVC.AppUserInformation.UserWork.UserWorkService;


import com.example.demo.AppMVC.AppUserModel;
import com.example.demo.AppMVC.UserRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRegistrationService {

    private final AppUserInformationService appUserInformationService;

    private final AppUserInformationRepository appUserInformationRepository;

    private final UserEducationService userEducationService;

    private final UserWorkService userWorkService;

    private final UserProjectService userProjectService;

    private final UserInterestService userInterestService;

    private final UserRepository userRepository;

    private final UserEducationRepository userEducationRepository;

    private final UserWorkRepository userWorkRepository;

    private final UserInterestRepository userInterestRepository;

    private final UserProjectRepository userProjectRepository;

    public String update(Long appUserId, UserRegistrationUpdateRequest request) {
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        AppUserInformationModel appUserInformationModel = appUserInformationRepository.findByAppUserId(appUserModel);
        if (request.getResumeURL() != null) {
            appUserInformationModel.setResumeURL(request.getResumeURL());
        }
        if (request.getProfilePicURL() != null) {
            appUserInformationModel.setProfilePicURL(request.getProfilePicURL());
        }
        if (request.getCoverLetterURL() != null) {
            appUserInformationModel.setCoverLetterURL(request.getCoverLetterURL());
        }
        if (request.getWebsiteURL() != null) {
            appUserInformationModel.setWebsiteURL(request.getWebsiteURL());
        }
        if (request.getBio() != null) {
            appUserInformationModel.setBio(request.getBio());
        }
        if (request.getSkills() != null) {
            appUserInformationModel.setSkills(request.getSkills());
        }

        appUserInformationService.saveAppUserInformation(appUserInformationModel);
        return "updated";
    }

    public String registerEducation(Long appUserId, UserRegistrationEductionRequest request) {
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        UserEducationModel userEducationModel = new UserEducationModel(
                request.getEducation(),
                request.getDegree(),
                request.getMajor(),
                request.getGPA(),
                request.getClubs(),
                request.getCourses(),
                request.getStartDate(),
                request.getGraduationDate(),
                appUserModel
        );

        userEducationService.saveAppUserInformation(userEducationModel);
        return "update education";
    }

    public String registerInterest(Long appUserId, UserRegistrationInterestRequest request) {
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        UserInterestModel userInterestModel = new UserInterestModel(
                request.getIndustries(),
                request.getLocation(),
                request.getRoles(),
                appUserModel
        );

        userInterestService.saveAppUserInformation(userInterestModel);
        return "update interest";
    }

    public String registerProject(Long appUserId, UserRegistrationProjectRequest request) {
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        UserProjectModel userProjectModel = new UserProjectModel(
                request.getName(),
                request.getDescription(),
                request.getPictures(),
                request.getRelevantWebsites(),
                appUserModel
        );

        userProjectService.saveAppUserInformation(userProjectModel);
        return "update project";
    }

    public String registerWork(Long appUserId, UserRegistrationWorkRequest request) {
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        UserWorkModel userWorkModel = new UserWorkModel(
                request.getCompany(),
                request.getTitle(),
                request.getLocation(),
                request.getStartDate(),
                request.getEndDate(),
                request.getDescription(),
                appUserModel
        );

        userWorkService.saveAppUserInformation(userWorkModel);
        return "update work";
    }

    public List<UserEducationModel> getEducation(Long appUserId){
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        return userEducationService.getEducation(appUserModel);
    }

    public List<UserInterestModel> getInterests(Long appUserId){
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        return userInterestService.getInterests(appUserModel);
    }

    public List<UserProjectModel> getProject(Long appUserId){
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        return userProjectService.getProject(appUserModel);
    }

    public List<UserWorkModel> getWork(Long appUserId){
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        return userWorkService.getWork(appUserModel);
    }

    public AppUserInformationModel getUserInformation(Long appUserId) {
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        return appUserInformationService.getUserInformation(appUserModel);
    }

    public String updateEducation(Long appUserId, int order, UserRegistrationEductionRequest request) {
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        List<UserEducationModel> userEducationModel = userEducationRepository.findByAppUserId(appUserModel);
        UserEducationModel educationModel = userEducationModel.get(order);
        if (request.getEducation() != educationModel.getEducation() && request.getEducation() != null) {
            educationModel.setEducation(request.getEducation());
        }
        if (request.getDegree() != educationModel.getDegree() && request.getDegree() != null) {
            educationModel.setDegree(request.getDegree());
        }
        if (!Arrays.equals(request.getClubs(), educationModel.getClubs()) && request.getClubs() != null) {
            educationModel.setClubs(request.getClubs());
        }
        if (!Arrays.equals(request.getCourses(), educationModel.getCourses()) && request.getCourses() != null) {
            educationModel.setCourses(request.getCourses());
        }
        if (request.getGPA() != educationModel.getGPA() && request.getGPA() != 0.0d) {
            educationModel.setGPA(request.getGPA());
        }
        if (request.getMajor() != educationModel.getMajor() && request.getMajor() != null) {
            educationModel.setMajor(request.getMajor());
        }
        if (request.getStartDate() != educationModel.getStartDate() && request.getStartDate() != null) {
            educationModel.setStartDate(request.getStartDate());
        }
        if (request.getGraduationDate() != educationModel.getGraduationDate() && request.getGraduationDate() != null) {
            educationModel.setGraduationDate(request.getGraduationDate());
        }
        userEducationService.saveAppUserInformation(educationModel);
        return "updated";
    }

    public String updateInterest(Long appUserId, int order, UserRegistrationInterestRequest request) {
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        List<UserInterestModel> userInterestModel = userInterestRepository.findByAppUserId(appUserModel);
        UserInterestModel interestModel = userInterestModel.get(order);
        if (!Arrays.equals(request.getIndustries(), interestModel.getIndustries()) && request.getIndustries() != null) {
            interestModel.setIndustries(request.getIndustries());
        }
        if (!Arrays.equals(request.getLocation(), interestModel.getLocations()) && request.getLocation() != null) {
            interestModel.setLocations(request.getLocation());
        }
        if (!Arrays.equals(request.getRoles(), interestModel.getRoles()) && request.getRoles() != null) {
            interestModel.setRoles(request.getRoles());
        }
        userInterestService.saveAppUserInformation(interestModel);
        return "updated";
    }

    public String updateWork(Long appUserId, int order, UserRegistrationWorkRequest request) {
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        List<UserWorkModel> userWorkModel = userWorkRepository.findByAppUserId(appUserModel);
        UserWorkModel workModel = userWorkModel.get(order);
        if (request.getCompany() != workModel.getCompany() && request.getCompany() != null) {
            workModel.setCompany(request.getCompany());
        }
        if (request.getTitle() != workModel.getTitle() && request.getTitle() != null) {
            workModel.setTitle(request.getTitle());
        }
        if (request.getLocation() != workModel.getLocation() && request.getLocation() != null) {
            workModel.setLocation(request.getLocation());
        }
        if (request.getStartDate() != workModel.getStartDate() && request.getStartDate() != null) {
            workModel.setStartDate(request.getStartDate());
        }
        if (request.getEndDate() != workModel.getEndDate() && request.getEndDate() != null) {
            workModel.setEndDate(request.getEndDate());
        }
        if (request.getDescription() != workModel.getDescription() && request.getDescription() != null) {
            workModel.setDescription(request.getDescription());
        }
        userWorkService.saveAppUserInformation(workModel);

        return "updated";
    }

    public String updateProject(Long appUserId, int order, UserRegistrationProjectRequest request) {
        AppUserModel appUserModel = userRepository.findById(appUserId).get();
        List<UserProjectModel> userProjectModels = userProjectRepository.findByAppUserId(appUserModel);
        UserProjectModel projectModel = userProjectModels.get(order);
        if (request.getName() != projectModel.getName() && request.getName() != null) {
            projectModel.setName(request.getName());
        }
        if (request.getDescription() != projectModel.getDescription() && request.getDescription() != null) {
            projectModel.setDescription(request.getDescription());
        }
        if (!Arrays.equals(request.getPictures(), projectModel.getPictures()) && request.getPictures() != null) {
            projectModel.setPictures(request.getPictures());
        }
        if (!Arrays.equals(request.getRelevantWebsites(), projectModel.getRelevantWebsites()) && request.getRelevantWebsites() != null) {
            projectModel.setRelevantWebsites(request.getRelevantWebsites());
        }
        userProjectService.saveAppUserInformation(projectModel);
        return "updated";
    }
}
