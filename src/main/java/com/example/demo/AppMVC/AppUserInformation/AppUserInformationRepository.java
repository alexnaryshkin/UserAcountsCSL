package com.example.demo.AppMVC.AppUserInformation;

import com.example.demo.AppMVC.AppUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AppUserInformationRepository
        extends JpaRepository<AppUserInformationModel, AppUserModel> {
    public AppUserInformationModel findByAppUserId(AppUserModel appUserId);
}
