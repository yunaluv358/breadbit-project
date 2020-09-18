package com.bread.web.shipping;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

interface CustomShippingRepository{

}

public class ShippingRepositoryImpl extends QuerydslRepositorySupport implements CustomShippingRepository {
  private final JPAQueryFactory jpaQueryFactory;
    public ShippingRepositoryImpl( JPAQueryFactory jpaQueryFactory) {
        super(Shipping.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
