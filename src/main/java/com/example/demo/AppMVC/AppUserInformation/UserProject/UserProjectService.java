package com.example.demo.AppMVC.AppUserInformation.UserProject;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.demo.AppMVC.AppUserModel;

import java.util.List;

@Service
@AllArgsConstructor
public class UserProjectService {
    private UserProjectRepository userProjectRepository;

    public void saveAppUserInformation(UserProjectModel userProjectModel) {
        userProjectRepository.save(userProjectModel);
    }

    public List<UserProjectModel> getProject(AppUserModel id) {
        return userProjectRepository.findByAppUserId(id);
    }
}
