package com.descomplica.FrameBlog.repositories.v2;

import com.descomplica.FrameBlog.models.v2.AddressV2;
import com.descomplica.FrameBlog.models.v2.UserV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoryV2 extends JpaRepository<AddressV2, Long> {

    AddressV2 findByUsername(String login);

}
