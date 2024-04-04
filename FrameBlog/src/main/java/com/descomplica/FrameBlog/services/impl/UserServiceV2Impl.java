package com.descomplica.FrameBlog.services.impl;

import com.descomplica.FrameBlog.models.v2.UserV2;
import com.descomplica.FrameBlog.repositories.UserRepository;
import com.descomplica.FrameBlog.repositories.v2.UserRepositoryV2;
import com.descomplica.FrameBlog.services.v2.UserServiceV2;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceV2Impl implements UserServiceV2 {

    @Autowired
    private UserRepositoryV2 userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserV2 save(final UserV2 userV2) {
        UserV2 existingUserV2 = userRepository.findByUsername(userV2.getUsername());

        if(Objects.nonNull(existingUserV2)){
            throw new RuntimeException("Existing User");
        }
        String passwordHash = passwordEncoder.encode(userV2.getPassword());

        UserV2 entity = new UserV2(userV2.getUserId(), userV2.getName(), userV2.getEmail(), passwordHash, userV2.getRole(), userV2.getUsername());

        UserV2 newUserV2 = userRepository.save(entity);

        return new UserV2(newUserV2.getUserId(), newUserV2.getName(), newUserV2.getEmail(), newUserV2.getPassword(), newUserV2.getRole(), newUserV2.getUsername());
    }

    @Override
    public List<UserV2> getAll(){
        return userRepository.findAll();
    }

    @Override
    public UserV2 get(final Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not found")
        );
    }

    @Override
    public UserV2 update(final Long id, final UserV2 userV2){
        UserV2 userV2Update = userRepository.findById(id).orElse(null);
        if(Objects.nonNull(userV2Update)){
            String passwordHash = passwordEncoder.encode(userV2.getPassword());
            userV2Update.setName(userV2.getName());
            userV2Update.setUsername(userV2.getUsername());
            userV2Update.setEmail(userV2.getEmail());
            userV2Update.setRole(userV2.getRole());
            userV2Update.setPassword(passwordHash);
            return userRepository.save(userV2Update);
        }
        return null;
    }

    @Override
    public void delete(final Long id){
        userRepository.deleteById(id);
    }


}