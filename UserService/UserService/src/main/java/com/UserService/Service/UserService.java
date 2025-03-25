package com.UserService.Service;

import com.UserService.Entity.User;
import com.UserService.Exception.ResourceNotFoundException;
import com.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User with Given id not not on server"+id));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
