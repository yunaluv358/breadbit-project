package com.bread.web.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {

    Optional<User> findByUserId(String userId);
    Optional<User> findAllByNameAndPhone(String name ,String phone);
    Optional<User> findAllByUserIdAndNameAndPhone(String userId ,String name ,String phone);

    @Query("select u.sales FROM User u WHERE u.name LIKE %:name%")
    Optional<User> findByName(@Param("name") String name);




}