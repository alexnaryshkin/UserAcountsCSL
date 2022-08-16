package com.example.demo.AppMVC;

import com.example.demo.AppMVC.AppUserInformation.AppUserInformationModel;
import com.example.demo.AppMVC.AppUserInformation.AppUserInformationService;
import com.example.demo.registration.token.ConfirmationToken;
import com.example.demo.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final UserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    private final AppUserInformationService appUserInformationService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }
    public String signUpUser(AppUserModel appUserModel){
        boolean existing = appUserRepository
                .findByEmail(appUserModel.getEmail())
                .isPresent();
        if(existing){
                throw new IllegalStateException("email is already taken"); 
        }
        String encodedPassword = bCryptPasswordEncoder
                .encode(appUserModel.getPassword());

        appUserModel.setPassword(encodedPassword);

        appUserRepository.save(appUserModel);
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUserModel
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

        AppUserInformationModel appUserInformationModel = new AppUserInformationModel(
                appUserModel
        );

        appUserInformationService.saveAppUserInformation(
                appUserInformationModel
        );

        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

    public AppUserModel getUser(Long id) {
        return appUserRepository.findById(id).get();
    }

    public void deleteUser(Long id) {
        appUserRepository.deleteById(id);
    }
}
