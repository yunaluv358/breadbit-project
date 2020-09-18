package com.bread.web.review;
import com.bread.web.utils.Box;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/review")

public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;
    @Autowired Box box;

    @PostMapping("/save")
    public String reviewSave(@RequestBody Review review){
        reviewRepository.save(review);
        return "리뷰 저장완료";
    }
    // 리뷰 정보 변경
    @PatchMapping("/info")
    public ResponseEntity<Review> reviewInfo(@RequestBody Review review){
        Optional<Review> updateReview = reviewRepository.findByReviewId(review.getReviewId());
        if (updateReview.isPresent()){
            updateReview.ifPresent(selectReview ->{
                selectReview.setTitle(review.getTitle());
                selectReview.setContents(review.getContents());
                selectReview.setCategory(review.getCategory());
                selectReview.setDate(review.getDate());
                reviewRepository.save(selectReview);
            });
            return ResponseEntity.ok(updateReview.get());
        } else {
            System.out.println("정보수정 실패 재시도 바랍니다");

            return ResponseEntity.notFound().build();
        }
    }
    // 리뷰 리스트
    @GetMapping("/postlist")
    public List<Review> reviewList() {
        return reviewRepository.findAll();
    }

    // 제목으로 리뷰검색
    @GetMapping("/title/{title}")
    public List<Review> titleSearch(@PathVariable String title) {
        return reviewRepository.findByTitle(title);
    }

    // 리뷰삭제
    @PostMapping("/delete")
    public Optional<Review> reviewDelete(@RequestBody Review review) {
        Optional<Review> delete = reviewRepository.findByReviewId(review.getReviewId());
        delete.ifPresent(selectReview -> {
            reviewRepository.delete(selectReview);
        });
        return delete;
    }


}
