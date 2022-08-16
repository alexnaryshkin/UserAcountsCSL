package com.example.demo.AppMVC.AppUserInformation.UserEducation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.demo.AppMVC.AppUserModel;

import java.util.List;

@Service
@AllArgsConstructor
public class UserEducationService {
    private UserEducationRepository userEducationRepository;

    public void saveAppUserInformation(UserEducationModel userEducationModel) {
        userEducationRepository.save(userEducationModel);
    }

    public List<UserEducationModel> getEducation(AppUserModel id) {
        return userEducationRepository.findByAppUserId(id);
    }

}
