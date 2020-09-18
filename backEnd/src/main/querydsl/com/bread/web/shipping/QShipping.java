package com.bread.web.shipping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QShipping is a Querydsl query type for Shipping
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QShipping extends EntityPathBase<Shipping> {

    private static final long serialVersionUID = -240031087L;

    public static final QShipping shipping = new QShipping("shipping");

    public final StringPath shippingAddr = createString("shippingAddr");

    public final StringPath shippingBreadImg = createString("shippingBreadImg");

    public final StringPath shippingBreadName = createString("shippingBreadName");

    public final StringPath shippingDate = createString("shippingDate");

    public final NumberPath<Long> shippingId = createNumber("shippingId", Long.class);

    public final StringPath shippingName = createString("shippingName");

    public final StringPath shippingPrice = createString("shippingPrice");

    public final StringPath shippingStatus = createString("shippingStatus");

    public QShipping(String variable) {
        super(Shipping.class, forVariable(variable));
    }

    public QShipping(Path<? extends Shipping> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShipping(PathMetadata metadata) {
        super(Shipping.class, metadata);
    }

}

