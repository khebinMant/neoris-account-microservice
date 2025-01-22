package com.neoris.account.movements.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMovementsEntity is a Querydsl query type for MovementsEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMovementsEntity extends EntityPathBase<MovementsEntity> {

    private static final long serialVersionUID = 531912514L;

    public static final QMovementsEntity movementsEntity = new QMovementsEntity("movementsEntity");

    public final com.neoris.account.common.entities.QAbstractBaseAuditable _super = new com.neoris.account.common.entities.QAbstractBaseAuditable(this);

    public final StringPath address = createString("address");

    public final DateTimePath<java.util.Date> birthDate = createDateTime("birthDate", java.util.Date.class);

    //inherited
    public final NumberPath<Long> createdByUser = _super.createdByUser;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final StringPath createdFromIp = _super.createdFromIp;

    public final StringPath gender = createString("gender");

    public final StringPath identityNumber = createString("identityNumber");

    //inherited
    public final NumberPath<Long> lastModifiedByUser = _super.lastModifiedByUser;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath name = createString("name");

    public final NumberPath<Long> personId = createNumber("personId", Long.class);

    public final StringPath phone = createString("phone");

    //inherited
    public final StringPath status = _super.status;

    public final StringPath surname = createString("surname");

    //inherited
    public final StringPath updatedFromIp = _super.updatedFromIp;

    public QMovementsEntity(String variable) {
        super(MovementsEntity.class, forVariable(variable));
    }

    public QMovementsEntity(Path<? extends MovementsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovementsEntity(PathMetadata metadata) {
        super(MovementsEntity.class, metadata);
    }

}

