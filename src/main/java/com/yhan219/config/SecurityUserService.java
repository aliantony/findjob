package com.yhan219.config;

import com.yhan219.domain.User;
import com.yhan219.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhan219 on 2017/2/13.
 */
@Service
public class SecurityUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if(user != null){
            List<GrantedAuthority> authorities = new ArrayList<>();
            userRepository.getRolesByUserId(user.getId()).forEach(userRole -> authorities.add(new SimpleGrantedAuthority(userRole.getName())));
            userRepository.getAuthsByUserId(user.getId()).forEach(auth -> authorities.add(new SimpleGrantedAuthority(auth.getName())));
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
        }
        throw new UsernameNotFoundException("没有user");
    }
}
