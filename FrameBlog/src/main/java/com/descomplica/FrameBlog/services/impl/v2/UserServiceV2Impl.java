package com.descomplica.FrameBlog.services.impl.v2;

import com.descomplica.FrameBlog.models.v2.UserV2;
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
    private UserRepositoryV2 userRepositoryV2;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserV2 save(final UserV2 user) {
        UserV2 existingUser = userRepositoryV2.findByUsername(user.getUsername());

        if (Objects.nonNull(existingUser)) {
            throw new RuntimeException("Existing User");
        }

        String passwordHash = passwordEncoder.encode(user.getPassword());

        UserV2 entity = new UserV2(user.getUserId(), user.getName(), user.getEmail(), user.getUsername(), user.getRole(), passwordHash);

        UserV2 newUser = userRepositoryV2.save(entity);

        return new UserV2(newUser.getUserId(), newUser.getName(), newUser.getEmail(), newUser.getUsername(), newUser.getRole(), newUser.getPassword());
    }

    @Override
    public List<UserV2> getAll() {
        return userRepositoryV2.findAll();
    }

    @Override
    public UserV2 get(final Long id) {
        return userRepositoryV2.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public UserV2 update(final Long id, final UserV2 user) {
        UserV2 userUpdate = userRepositoryV2.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        if (Objects.nonNull(userUpdate)) {
            String passwordHash = passwordEncoder.encode(user.getPassword());
            userUpdate.setName(user.getName());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setRole(user.getRole());
            userUpdate.setPassword(passwordHash);
            return userRepositoryV2.save(userUpdate);
        }
        return null;
    }

    @Override
    public void delete(final Long id) {
        userRepositoryV2.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        userRepositoryV2.deleteById(id);
    }

}
