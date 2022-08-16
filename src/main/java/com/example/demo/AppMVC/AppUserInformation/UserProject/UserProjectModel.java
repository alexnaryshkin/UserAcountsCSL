package com.example.demo.AppMVC.AppUserInformation.UserProject;


import com.example.demo.AppMVC.AppUserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserProjectModel {
    @SequenceGenerator(
            name = "user_project_sequence",
            sequenceName = "user_project_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_project_sequence"
    )

    private Long id;

    private String name;

    private String description;

    private String[] pictures;

    private String[] relevantWebsites;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            nullable = false,
            name = "app_user_id",
            referencedColumnName = "id"
    )

    private AppUserModel appUserId;

    public UserProjectModel(String name, String description,
                            String[] pictures, String[] relevantWebsites, AppUserModel appUserModel) {
        this.name = name;
        this.description = description;
        this.pictures = pictures;
        this.relevantWebsites = relevantWebsites;
        this.appUserId = appUserModel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getPictures() {
        return pictures;
    }

    public String[] getRelevantWebsites() {
        return relevantWebsites;
    }

    public AppUserModel getAppUserId() {
        return appUserId;
    }
}
