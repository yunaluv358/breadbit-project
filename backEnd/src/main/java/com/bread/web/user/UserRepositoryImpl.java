package com.bread.web.user;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Optional;

interface CustomUserRepository {
//    Optional<User> findByUserId(String userId);
}
@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements CustomUserRepository{

    private final  JPAQueryFactory jpaQueryFactory;
    public UserRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(User.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

//    @Override
//    public Optional<User> findByUserId(String userId) {
//        QUser qUser = QUser.user;
//        User findOne = jpaQueryFactory.selectFrom(qUser).where(qUser.userId.eq(userId)).fetchOne();
//        return Optional.ofNullable(findOne);
//    }
}