package com.example.demo.AppMVC.AppUserInformation;

import com.example.demo.AppMVC.AppUserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class  AppUserInformationModel {
    @SequenceGenerator(
            name = "app_user_information_sequence",
            sequenceName = "app_user_information_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_user_information_sequence"
    )
    private Long id;

    private String resumeURL;

    private String profilePicURL;

    private String coverLetterURL;

    private String websiteURL;

    private String bio;

    private String[] skills;

    @OneToOne(
            cascade = CascadeType.REMOVE
    )
    @JoinColumn(
            name = "app_user_id",
            referencedColumnName = "id"
    )
    private AppUserModel appUserId;

    public AppUserInformationModel(String resumeURL, String profilePicURL,
                              String coverLetterURL, String websiteURL, String bio, String[] skills) {
        this.resumeURL = resumeURL;
        this.profilePicURL = profilePicURL;
        this.coverLetterURL = coverLetterURL;
        this.websiteURL = websiteURL;
        this.bio = bio;
        this.skills = skills;
    }

    public AppUserInformationModel(AppUserModel appUserId) {
        this.appUserId = appUserId;
    }

    public Long getId() {
        return id;
    }

    public String getResumeURL() {
        return resumeURL;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }

    public String getCoverLetterURL() {
        return coverLetterURL;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public String getBio() {
        return bio;
    }

    public String[] getSkills() {
        return skills;
    }

    public AppUserModel getAppUserEmail() {
        return appUserId;
    }
}
