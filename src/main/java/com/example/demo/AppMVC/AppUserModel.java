package com.example.demo.AppMVC;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class AppUserModel implements UserDetails {

  @Id
  @SequenceGenerator(
          name = "user_sequence",
          sequenceName = "user_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "user_sequence"
  )
  private Long id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column(nullable = false)
  private String email;
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  private String userName;
  @Enumerated(EnumType.STRING)
  private AppUserRole appUserRole;
  private Boolean locked = false;
  private Boolean enabled = false;

  public AppUserModel(String firstName, String lastName, String userName, String email, String password,
                      AppUserRole appUserRole) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.appUserRole = appUserRole;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
    return Collections.singletonList(authority);
  }

  @Override
  public String getPassword() {
    return password;
  }
  
  @Override
  public String getUsername() {

    return userName;
  }

  public String getFirstName() {

    return firstName;
  } 

  public String getLastName() {

    return lastName;
  }

  @Override
  public boolean isAccountNonExpired() {

    return true;
  }

  @Override
  public boolean isAccountNonLocked() {

    return !locked;
  }

  @Override
  public boolean isCredentialsNonExpired() {

    return true;
  }

  @Override
  public boolean isEnabled() {

    return enabled;
  }
}
