package com.cvbank.service;

import com.cvbank.model.ApplicationUser;
import com.cvbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = loadApplicationUserByUsername(username);
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
    }

    public ApplicationUser loadApplicationUserByUsername(String username) {

        ApplicationUser user = userRepository.findByUsername(username);
        if (null == user) {

            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        System.out.println(user.getUsername());
        return user;

       // return new ApplicationUser("batman", "$2a$12$T/20Kgb2C3vmTF8T2WhpD.PLAQ3D8l.KNFpS2OgLiIxzPM1NZ3Nwu");
    }

    @Transactional
    public ApplicationUser createUser(ApplicationUser user) {

        user = userRepository.save(user);


        return user;
    }
}
