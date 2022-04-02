package com.example.onlinestore.service;
import com.example.onlinestore.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public interface IUserService extends UserDetailsService {

    User addUser(User user);
    List<User>getAllUsers();
    User getUserById(Long id);
    User updateUser(User user, Long id);
    void deleteUser(Long id);
    UserDetails loadUserByUsername(String username);



}
