package com.example.demo.AppMVC.AppUserInformation;

import com.example.demo.AppMVC.AppUserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserInformationService {
    private AppUserInformationRepository appUserInformationRepository;

    public AppUserInformationModel getUserInformation(AppUserModel appUserModel) {
        return appUserInformationRepository.findByAppUserId(appUserModel);
    }

    public void saveAppUserInformation(AppUserInformationModel appUserInformationModel) {
        appUserInformationRepository.save(appUserInformationModel);
    }

    public AppUserInformationModel getAppUserInformation(AppUserModel id) {
        return appUserInformationRepository.findByAppUserId(id);
    }
}
