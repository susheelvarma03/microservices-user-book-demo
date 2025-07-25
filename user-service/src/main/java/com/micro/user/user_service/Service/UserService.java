package com.micro.user.user_service.Service;

import com.micro.user.user_service.Entity.UserEntity;
import com.micro.user.user_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserEntity saveUser(UserEntity user){
        return repository.save(user);
    }

    public List<UserEntity> getAllUsers(){
        return repository.findAll();
    }

    public UserEntity getUser(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found of ID:" + id));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
