package com.example.onlinestore.controller;
import com.example.onlinestore.model.User;
import com.example.onlinestore.service.Impl.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@NoArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return  userService.updateUser(user, id);
    }

    @DeleteMapping("{id}")
    public String deleteUser( @PathVariable ("id") Long id){
        userService.deleteUser(id);
        return "User deleted!";
    }


}
