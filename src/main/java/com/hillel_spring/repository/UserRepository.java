package com.hillel_spring.repository;

import com.hillel_spring.model.UserEntity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(
        value = "SELECT * FROM \"user\" WHERE email = :email",
        nativeQuery = true
    )
    Optional<User> findByEmail(@Param("email") String email);
}