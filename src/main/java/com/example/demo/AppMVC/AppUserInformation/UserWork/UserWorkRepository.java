package com.example.demo.AppMVC.AppUserInformation.UserWork;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.AppMVC.AppUserModel;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface UserWorkRepository
        extends JpaRepository<UserWorkModel, Long> {
    public List<UserWorkModel> findByAppUserId(AppUserModel appUserId);
}
