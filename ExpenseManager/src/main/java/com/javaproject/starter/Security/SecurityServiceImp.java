package com.javaproject.starter.Security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImp implements SecurityService{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }

    @Override
    public void autologin(String email, String password) {
        UserDetails ud = userDetailsService.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(ud, password, ud.getAuthorities());

        authenticationManager.authenticate(token);

        if (token.isAuthenticated()) 
            SecurityContextHolder.getContext().setAuthentication(token);
       
    }
}