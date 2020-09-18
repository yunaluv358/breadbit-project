package com.bread.web.bread;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface CustomBreadRepository {}

@Repository
public class BreadRepositoryImpl extends QuerydslRepositorySupport implements CustomBreadRepository {
   private final JPAQueryFactory jpaQueryFactory;
    public BreadRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Bread.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
