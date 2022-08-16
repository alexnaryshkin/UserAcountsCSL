package com.example.demo.AppMVC.AppUserInformation.UserWork;

import com.example.demo.AppMVC.AppUserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserWorkModel {
    @SequenceGenerator(
            name = "user_work_sequence",
            sequenceName = "user_work_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_work_sequence"
    )

    private Long id;

    private String company;

    private String title;

    private String location;

    private String startDate;

    private String endDate;

    private String description;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id",
            referencedColumnName = "id"
    )

    private AppUserModel appUserId;

    public UserWorkModel(String company, String title, String location, String startDate,
                         String endDate, String description, AppUserModel appUserModel){
        this.company = company;
        this.title = title;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.appUserId = appUserModel;
    }

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
    
    public String getDescription() {
        return description;
    }

    public AppUserModel getAppUserId() {
        return appUserId;
    }
}
