package com.example.demo.AppMVC;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserController implements UserDetailsService {

  private final static String USER_NOT_FOUND =
          "user with email %s not found";
  private final UserRepository userRepo;

  public AppUserController(UserRepository userRepo) { this.userRepo = userRepo; }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepo.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
  }
}
