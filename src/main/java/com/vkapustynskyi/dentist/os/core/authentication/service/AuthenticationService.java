package com.vkapustynskyi.dentist.os.core.authentication.service;

import com.vkapustynskyi.dentist.os.core.authentication.dto.AuthenticationRequest;
import com.vkapustynskyi.dentist.os.core.dto.StringValueDto;
import com.vkapustynskyi.dentist.os.core.user.entity.MyUser;
import com.vkapustynskyi.dentist.os.core.user.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final MyUserService userService;

    public StringValueDto authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        MyUser user = userService.getByEmail(request.getEmail());
        String token = jwtService.generateToken(user.getUserDetails());
        return new StringValueDto(token);
    }

}
