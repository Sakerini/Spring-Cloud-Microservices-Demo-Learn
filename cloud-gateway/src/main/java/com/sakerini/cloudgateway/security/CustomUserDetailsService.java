package com.sakerini.cloudgateway.security;

import com.sakerini.cloudgateway.entity.UserInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;

@Component
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    private final String LOGIN_SERVICE_GET_USER_URL = "http://localhost:3001/login/find-user/";


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("Inside loadUserByName in ApiGateway");

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(LOGIN_SERVICE_GET_USER_URL + username);
        UserInformation user = restTemplate.getForObject(uriBuilder.toUriString(), UserInformation.class);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new User(username, user.getPassword(), true, true,
                true,true, authorities);

    }
}
