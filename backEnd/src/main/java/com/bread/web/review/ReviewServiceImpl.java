package com.bread.web.review;
import com.bread.web.user.User;
import com.bread.web.utils.GenericService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

interface ReviewService extends GenericService<Review> {
    void allUpdate(List<Review> review);
    Optional<Review> findReviewByDate(String date);
    List<Review> findByTitle(String title);

}
@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Iterable<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(String id) {
    }

    @Override
    public void allUpdate(List<Review> review) {
        reviewRepository.saveAll(review);
    }

    @Override
    public Optional<Review> findReviewByDate(String date) {
        return reviewRepository.findByDate(date);
    }

    @Override
    public List<Review> findByTitle(String title) {
        return reviewRepository.findByTitle(title);
    }
}
