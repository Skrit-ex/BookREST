package com.example.bookstorerest;

import com.example.bookstorerest.entity.Operation;
import com.example.bookstorerest.entity.User;
import com.example.bookstorerest.repository.CalculatorOperation;
import com.example.bookstorerest.repository.UserRepository;
import com.example.bookstorerest.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private final List<User> userList = new ArrayList<>();
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public List<User> findAll(){
        return userList;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
    userList.add(user);
    userRepository.save(user);
    return ResponseEntity.ok(user);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        if(userList.removeIf(user -> user.getId().equals(id))){
                return ResponseEntity.ok().build();
         }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        for (User user1: userList) {
            if(user1.getId().equals(id)){
                return ResponseEntity.ok(user1);
            }
        }
        return null;
    }
    @PutMapping
    public User updateUser(@RequestBody User user,
                           @PathVariable Long id){
    return null;
    }
    @PostMapping("/calc")
    public ResponseEntity<?> getResult(@RequestBody Operation operation){
     Optional<CalculatorOperation> result = calculatorService.calculate(operation);
     if(result.isPresent()){
         return ResponseEntity.ok(result.get());
     }
     return ResponseEntity.badRequest().build();

    }
}
