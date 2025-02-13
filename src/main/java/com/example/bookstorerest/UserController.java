package com.example.bookstorerest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final List<User> userList = new ArrayList<>();

    @GetMapping
    public List<User> findAll(){
        return userList;
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
    userList.add(user);
    return user;
    }

    @DeleteMapping("{id}")
    public User deleteUser(@PathVariable Long id){
        for (User user : userList ) {
            if(user.getId().equals(id)){
                return user;
            }
         }
        return null;

    }
}
