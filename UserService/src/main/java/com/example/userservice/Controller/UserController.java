package com.example.userservice.Controller;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/show")
    public List<User> getAll(){
        List<User>list=userRepository.findAll();
        return list;
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable int id){
        return userRepository.findById(id).orElse(null);

    }
}
