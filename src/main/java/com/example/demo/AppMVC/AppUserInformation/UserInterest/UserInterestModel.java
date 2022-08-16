package com.example.demo.AppMVC.AppUserInformation.UserInterest;

import com.example.demo.AppMVC.AppUserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserInterestModel {
    @SequenceGenerator(
            name = "user_interest_sequence",
            sequenceName = "user_interest_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_interest_sequence"
    )
    private Long id;

    private String[] industries;

    private String[] locations;

    private String[] roles;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            nullable = false,
            name = "app_user_id",
            referencedColumnName = "id"
    )
    private AppUserModel appUserId;

    public UserInterestModel(String[] industries, String[] locations,
                             String[] roles, AppUserModel appUserId) {
        this.industries = industries;
        this.locations = locations;
        this.roles = roles;
        this.appUserId = appUserId;
    }

    public Long getId() {
        return id;
    }

    public String[] getIndustries() {
        return industries;
    }

    public String[] getLocations() {
        return locations;
    }

    public String[] getRoles() {
        return roles;
    }

    public AppUserModel getAppUserId() {
        return appUserId;
    }
}
