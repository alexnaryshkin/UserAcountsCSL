package com.example.demo.AppMVC.AppUserInformation.UserEducation;

import com.example.demo.AppMVC.AppUserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserEducationModel {
    @SequenceGenerator(
            name = "user_education_sequence",
            sequenceName = "user_education_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_education_sequence"
    )
    private Long id;

    private String education;

    private String degree;

    private String major;

    private double GPA;

    private String[] clubs;

    private String[] courses;

    private String startDate;

    private String graduationDate;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            nullable = false,
            name = "app_user_id",
            referencedColumnName = "id"
    )
    private AppUserModel appUserId;

    public UserEducationModel(String education, String degree,
                              String major, double GPA, String[] clubs, String[] courses,
                              String startDate, String graduationDate, AppUserModel appUserModel) {
        this.education = education;
        this.degree = degree;
        this.major = major;
        this.GPA = GPA;
        this.clubs = clubs;
        this.courses = courses;
        this.startDate = startDate;
        this.graduationDate = graduationDate;
        this.appUserId = appUserModel;
    }

    public Long getId() {
        return id;
    }

    public String getEducation() {
        return education;
    }

    public String getDegree() {
        return degree;
    }

    public String getMajor() {
        return major;
    }

    public double getGPA() {
        return GPA;
    }

    public String[] getClubs() {
        return clubs;
    }

    public String[] getCourses() {
        return courses;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public AppUserModel getAppUserId() {
        return appUserId;
    }
}
