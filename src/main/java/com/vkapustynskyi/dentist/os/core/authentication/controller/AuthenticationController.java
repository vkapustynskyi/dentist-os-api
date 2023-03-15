package com.vkapustynskyi.dentist.os.core.authentication.controller;

import com.vkapustynskyi.dentist.os.core.authentication.dto.AuthenticationRequest;
import com.vkapustynskyi.dentist.os.core.authentication.service.AuthenticationService;
import com.vkapustynskyi.dentist.os.core.dto.StringValueDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public StringValueDto authenticate(@RequestBody AuthenticationRequest request) {
        log.info("Authentication");
        return authenticationService.authenticate(request);
    }

}
