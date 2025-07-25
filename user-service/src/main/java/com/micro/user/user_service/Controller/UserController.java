package com.micro.user.user_service.Controller;

import com.micro.user.user_service.Entity.UserEntity;
import com.micro.user.user_service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public UserEntity addUser(@RequestBody UserEntity user){
        return service.saveUser(user);
    }

    @GetMapping
    public List<UserEntity> getUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getOneUser(@PathVariable Long id){
        return service.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteById(id);
    }
}
