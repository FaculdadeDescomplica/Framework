package com.descomplica.FrameBlog.services;

import com.descomplica.FrameBlog.models.UserV2;

import java.util.List;

public interface UserServiceV2 {
    UserV2 save(UserV2 userV2);

    List<UserV2> getAll();

    UserV2 get(Long id);

    UserV2 update(Long id, UserV2 userV2);

    void delete(Long id);
}
