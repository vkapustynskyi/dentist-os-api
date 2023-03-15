package com.vkapustynskyi.dentist.os.core.user.service;

import com.vkapustynskyi.dentist.os.core.user.entity.MyUser;
import com.vkapustynskyi.dentist.os.core.user.repository.LmsUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final LmsUserRepository repository;

    public MyUser getByEmail(String email) {
        return repository.findByEmail(email)  // todo: localized message and custom exception
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email '%1$s' not found", email)));
    }

}
