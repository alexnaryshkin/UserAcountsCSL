package com.example.demo.AppMVC.AppUserInformation.UserProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.AppMVC.AppUserModel;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface UserProjectRepository
        extends JpaRepository<UserProjectModel, Long> {

   public List<UserProjectModel> findByAppUserId(AppUserModel appUserId);
}
