package com.bread.web.review;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -1535547183L;

    public static final QReview review = new QReview("review");

    public final StringPath category = createString("category");

    public final StringPath contents = createString("contents");

    public final StringPath date = createString("date");

    public final NumberPath<Long> reviewId = createNumber("reviewId", Long.class);

    public final StringPath title = createString("title");

    public final StringPath userId = createString("userId");

    public QReview(String variable) {
        super(Review.class, forVariable(variable));
    }

    public QReview(Path<? extends Review> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReview(PathMetadata metadata) {
        super(Review.class, metadata);
    }

}

