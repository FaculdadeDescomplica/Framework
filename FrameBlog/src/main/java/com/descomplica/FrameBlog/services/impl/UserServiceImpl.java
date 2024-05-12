package com.descomplica.FrameBlog.services.impl;

import com.descomplica.FrameBlog.models.User;
import com.descomplica.FrameBlog.repositories.UserRepository;
import com.descomplica.FrameBlog.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @CircuitBreaker(name = "circuitBreaker")
    public User save(final User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if(Objects.nonNull(existingUser)){
            throw new RuntimeException("Existing User");
        }
        String passwordHash = passwordEncoder.encode(user.getPassword());

        User entity = new User(user.getUserId(), user.getName(), user.getEmail(), passwordHash, user.getUsername(), user.getRole());

        User newUser = userRepository.save(entity);

        return new User(newUser.getUserId(), newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getUsername(), newUser.getRole());
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User get(final Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not found")
        );
    }

    @Override
    public User update(final Long id, final User user){
        User userUpdate = userRepository.findById(id).orElse(null);
        if(Objects.nonNull(userUpdate)){
            String passwordHash = passwordEncoder.encode(user.getPassword());
            userUpdate.setName(user.getName());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setRole(user.getRole());
            userUpdate.setPassword(passwordHash);
            return userRepository.save(userUpdate);
        }
        return null;
    }

    @Override
    public void delete(final Long id){
        userRepository.deleteById(id);
    }


}