package com.descomplica.FrameBlog.repositories;

import com.descomplica.FrameBlog.models.UserV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserV2, Long> {

    UserV2 findByUsername(String login);

}
