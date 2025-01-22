package com.neoris.account.account.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClientEntity is a Querydsl query type for ClientEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClientEntity extends EntityPathBase<AccountEntity> {

    private static final long serialVersionUID = -1546520266L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClientEntity clientEntity = new QClientEntity("clientEntity");

    public final com.neoris.account.common.entities.QAbstractBaseAuditable _super = new com.neoris.account.common.entities.QAbstractBaseAuditable(this);

    public final NumberPath<Long> clientId = createNumber("clientId", Long.class);

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

    public final StringPath password = createString("password");

    public final com.neoris.account.movements.entities.QPersonEntity person;

    //inherited
    public final StringPath status = _super.status;

    //inherited
    public final StringPath updatedFromIp = _super.updatedFromIp;

    public QClientEntity(String variable) {
        this(AccountEntity.class, forVariable(variable), INITS);
    }

    public QClientEntity(Path<? extends AccountEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClientEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClientEntity(PathMetadata metadata, PathInits inits) {
        this(AccountEntity.class, metadata, inits);
    }

    public QClientEntity(Class<? extends AccountEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.person = inits.isInitialized("person") ? new com.neoris.account.movements.entities.QPersonEntity(forProperty("person")) : null;
    }

}

