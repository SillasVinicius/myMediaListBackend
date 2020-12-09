package com.sd.myMediaList.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CredentialService implements CredentialServiceAPI {

    @Autowired
    private DataSource datasource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void create(String username, String password, String authority) {

        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(datasource);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(authority));

        User userDetails = new User(username, passwordEncoder.encode(password), authorities);

        userDetailsService.createUser(userDetails);
    }
}
