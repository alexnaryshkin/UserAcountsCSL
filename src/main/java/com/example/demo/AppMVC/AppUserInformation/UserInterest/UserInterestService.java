package com.example.demo.AppMVC.AppUserInformation.UserInterest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.demo.AppMVC.AppUserModel;

import java.util.List;


@Service
@AllArgsConstructor
public class UserInterestService {
    private UserInterestRepository userInterestRepository;

    public void saveAppUserInformation(UserInterestModel userInterestModel) {
        userInterestRepository.save(userInterestModel);
    }

    public List<UserInterestModel> getInterests(AppUserModel id) {
        return userInterestRepository.findByAppUserId(id);
    }
} 
