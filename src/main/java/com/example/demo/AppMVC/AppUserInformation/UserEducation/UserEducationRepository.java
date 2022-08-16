package com.example.demo.AppMVC.AppUserInformation.UserEducation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.AppMVC.AppUserModel;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface UserEducationRepository
        extends JpaRepository<UserEducationModel, Long> {

    public List<UserEducationModel> findByAppUserId(AppUserModel appUserId);
}
