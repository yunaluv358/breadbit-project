package com.bread.web.bread;

import com.bread.web.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface BreadRepository extends JpaRepository<Bread,Long>, CustomBreadRepository {

    @Query("select u FROM Bread u WHERE u.breadName LIKE %:breadName%")
    List<Bread> findByBreadName(@Param("breadName") String breadName);
}
