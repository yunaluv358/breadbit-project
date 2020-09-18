package com.bread.web.review;
import lombok.*;
import javax.persistence.*;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id") private Long reviewId;
    @Column(name = "user_id", nullable = false) private String userId;
    @Column(name = "category",nullable = false) private String category;
    @Column(name = "title", nullable = false) private String title;
    @Column(name = "contents", nullable = false,length = 1000) private String contents;
    @Column(name = "date", nullable = false) private String date;

    @Builder
    public Review(String userId,String category,String postTitle,String contents,String date){
    this.userId = userId;
    this.category = category;
    this.title = title;
    this.contents = contents;
    this.date = date;

    }
}
