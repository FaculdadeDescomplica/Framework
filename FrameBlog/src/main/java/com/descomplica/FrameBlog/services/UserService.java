package com.descomplica.FrameBlog.services;

import com.descomplica.FrameBlog.models.User;

import java.util.List;

public interface UserService {

    User save(final User user);
    List<User> getAll();
    User get(final Long id);
    User update(final Long id, final User user);
    void delete(final Long id);
}