
package com.example.onlinestore.service.Impl;

import com.example.onlinestore.Repository.UserRepository;
import com.example.onlinestore.exception.ResourceNotFoundException;
import com.example.onlinestore.model.User;
import com.example.onlinestore.service.IUserService;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Data
@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
     /* Optional<User> user = userRepository.findById(id);
      if (user.isPresent()){
          return user.get();
      }else {
          throw new ResourceNotFoundException("User","id",id);
      }
*/

        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id));
    }


    public User updateUser(User user, Long id){
        User existingUser = userRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User","id",id));

        existingUser.setUsername(user.getUsername());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setState(user.getState());

        userRepository.save(existingUser);

        return existingUser;
    }

    public void deleteUser(Long id){

        userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));

        userRepository.deleteById(id);
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if(user == null){
            throw new UsernameNotFoundException("User with this username and password does not exist!");
        }
        else
            return user;
    }
}
