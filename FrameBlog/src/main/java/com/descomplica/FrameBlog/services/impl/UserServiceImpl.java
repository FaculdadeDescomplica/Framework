package com.descomplica.FrameBlog.services.impl;

import com.descomplica.FrameBlog.models.User;
import com.descomplica.FrameBlog.repositories.UserRepository;
import com.descomplica.FrameBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(final User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if(Objects.nonNull(existingUser)){
            throw new RuntimeException("Existing User");
        }

        User entity = new User(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(), user.getRole(), user.getUsername());

        User newUser = userRepository.save(entity);

        return new User(newUser.getUserId(), newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getRole(), newUser.getUsername());
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User get(final Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(final Long id, final User user){
        User userUpdate = userRepository.findById(id).orElse(null);
        if(Objects.nonNull(userUpdate)){
            userUpdate.setName(user.getName());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setRole(user.getRole());
            userUpdate.setPassword(user.getPassword());
            return userRepository.save(userUpdate);
        }
        return null;
    }

    @Override
    public void delete(final Long id){
        userRepository.deleteById(id);
    }


}