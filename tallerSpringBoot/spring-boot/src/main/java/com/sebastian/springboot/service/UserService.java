package com.sebastian.springboot.service;

import com.sebastian.springboot.domain.User;
import com.sebastian.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(LocalDate birthDate){
        User u = new User();
        u.setBirthDate(birthDate);
        return userRepository.save(u);
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User updateUser(Integer id, LocalDate birthDate){
        User u = userRepository.findById(id).get();
        u.setBirthDate(birthDate);
        return userRepository.save(u);
    }

    public void deleteUserById(Integer id){
        userRepository.deleteById(id);
    }

}
