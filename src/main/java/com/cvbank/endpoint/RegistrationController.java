package com.cvbank.endpoint;


import com.cvbank.model.ApplicationUser;
import com.cvbank.model.Response;
import com.cvbank.model.Views;
import com.cvbank.security.SecurityUtility;
import com.cvbank.service.CustomUserDetailsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import static com.cvbank.security.SecurityConstants.LOGOUT_URL;
import static com.cvbank.security.SecurityConstants.SIGN_UP_URL;

@RestController
public class RegistrationController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @PostMapping(value = SIGN_UP_URL, produces = "application/json")
    @Transactional
    public ResponseEntity<?> createNewUser(@RequestBody ApplicationUser user) throws JsonProcessingException  {

        user.setPassword(SecurityUtility.passwordEncoder().encode(user.getPassword()));
        customUserDetailsService.createUser(user);
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper
                .writerWithView(Views.Public.class)
                .writeValueAsString(user);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping(LOGOUT_URL)
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

        new SecurityContextLogoutHandler().logout(request, response, authentication);
        Response resp = new Response();
        resp.fillResponse("success",null, null, null);
        return new ResponseEntity(resp, HttpStatus.OK);
    }
}
