package com.descomplica.FrameBlog.services;

import com.descomplica.FrameBlog.models.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> getAll();

    User get(Long id);

    User update(Long id, User user);

    void delete(Long id);
}
