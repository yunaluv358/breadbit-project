package com.bread.web.review;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomReviewRepository {}

@Repository
public class ReviewRepositoryImpl extends QuerydslRepositorySupport implements CustomReviewRepository {
    private final JPAQueryFactory jpaQueryFactory;
    public ReviewRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Review.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
