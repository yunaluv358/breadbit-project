package com.bread.web.review;

import com.bread.web.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long>, CustomReviewRepository {
    Optional<Review> findByDate(String date);
    Optional<Review> findByCategory(String categoly);
    Optional<Review> findByReviewId(Long reviewId);
    @Query("select r from Review r where r.title LIKE %:title%")
    List<Review> findByTitle(@Param("title") String title);


}
