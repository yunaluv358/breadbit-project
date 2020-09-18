package com.bread.web.bread;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBread is a Querydsl query type for Bread
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBread extends EntityPathBase<Bread> {

    private static final long serialVersionUID = -90504411L;

    public static final QBread bread = new QBread("bread");

    public final StringPath allergy = createString("allergy");

    public final StringPath breadDescription = createString("breadDescription");

    public final NumberPath<Long> breadId = createNumber("breadId", Long.class);

    public final StringPath breadImage = createString("breadImage");

    public final StringPath breadImageDetail = createString("breadImageDetail");

    public final StringPath breadName = createString("breadName");

    public final StringPath breadPrice = createString("breadPrice");

    public final StringPath option = createString("option");

    public QBread(String variable) {
        super(Bread.class, forVariable(variable));
    }

    public QBread(Path<? extends Bread> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBread(PathMetadata metadata) {
        super(Bread.class, metadata);
    }

}

