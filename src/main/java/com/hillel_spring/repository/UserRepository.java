package com.hillel_spring.repository;

import com.hillel_spring.model.UserEntity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT * FROM \"user\" WHERE email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}