package com.vkapustynskyi.dentist.os.core.user.repository;

import com.vkapustynskyi.dentist.os.core.user.entity.MyUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LmsUserRepository extends JpaRepository<MyUser, Long> {

    @EntityGraph(attributePaths = "userDetails")
    Optional<MyUser> findByEmail(String email);

}
