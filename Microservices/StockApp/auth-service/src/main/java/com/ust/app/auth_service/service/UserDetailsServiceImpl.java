package com.ust.app.auth_service.service;
import com.ust.app.auth_service.model.UserModel;
import com.ust.app.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel=userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User with name "+username +" not found"));

        return new UserDetailsImpl(userModel);
    }
}
