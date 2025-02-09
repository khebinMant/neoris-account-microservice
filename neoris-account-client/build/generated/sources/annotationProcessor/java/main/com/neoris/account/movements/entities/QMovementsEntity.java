package com.neoris.account.movements.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovementsEntity is a Querydsl query type for MovementsEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMovementsEntity extends EntityPathBase<MovementsEntity> {

    private static final long serialVersionUID = 531912514L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMovementsEntity movementsEntity = new QMovementsEntity("movementsEntity");

    public final com.neoris.account.common.entities.QAbstractBaseAuditable _super = new com.neoris.account.common.entities.QAbstractBaseAuditable(this);

    public final com.neoris.account.account.entities.QAccountEntity accountEntity;

    public final NumberPath<Long> balance = createNumber("balance", Long.class);

    //inherited
    public final NumberPath<Long> createdByUser = _super.createdByUser;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final StringPath createdFromIp = _super.createdFromIp;

    //inherited
    public final NumberPath<Long> lastModifiedByUser = _super.lastModifiedByUser;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedDate = _super.lastModifiedDate;

    public final DateTimePath<java.util.Date> movementDate = createDateTime("movementDate", java.util.Date.class);

    public final NumberPath<Long> movementId = createNumber("movementId", Long.class);

    public final StringPath movementType = createString("movementType");

    //inherited
    public final StringPath status = _super.status;

    public final NumberPath<Long> transactionValue = createNumber("transactionValue", Long.class);

    //inherited
    public final StringPath updatedFromIp = _super.updatedFromIp;

    public QMovementsEntity(String variable) {
        this(MovementsEntity.class, forVariable(variable), INITS);
    }

    public QMovementsEntity(Path<? extends MovementsEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMovementsEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMovementsEntity(PathMetadata metadata, PathInits inits) {
        this(MovementsEntity.class, metadata, inits);
    }

    public QMovementsEntity(Class<? extends MovementsEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accountEntity = inits.isInitialized("accountEntity") ? new com.neoris.account.account.entities.QAccountEntity(forProperty("accountEntity")) : null;
    }

}

