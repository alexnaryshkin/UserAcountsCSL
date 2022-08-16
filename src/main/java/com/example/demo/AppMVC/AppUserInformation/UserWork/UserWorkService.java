package com.example.demo.AppMVC.AppUserInformation.UserWork;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.demo.AppMVC.AppUserModel;

import java.util.List;

@Service
@AllArgsConstructor
public class UserWorkService {
    private UserWorkRepository userWorkRepository;

    public void saveAppUserInformation(UserWorkModel userWorkModel) {
        userWorkRepository.save(userWorkModel);
    }

    public List<UserWorkModel> getWork(AppUserModel id) {
        return userWorkRepository.findByAppUserId(id);
    }
}
