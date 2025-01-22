package com.neoris.account.account.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccountEntity is a Querydsl query type for AccountEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccountEntity extends EntityPathBase<AccountEntity> {

    private static final long serialVersionUID = -565793630L;

    public static final QAccountEntity accountEntity = new QAccountEntity("accountEntity");

    public final com.neoris.account.common.entities.QAbstractBaseAuditable _super = new com.neoris.account.common.entities.QAbstractBaseAuditable(this);

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    public final StringPath accountNumber = createString("accountNumber");

    public final StringPath accountType = createString("accountType");

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

    public final NumberPath<Long> openingBalance = createNumber("openingBalance", Long.class);

    //inherited
    public final StringPath status = _super.status;

    //inherited
    public final StringPath updatedFromIp = _super.updatedFromIp;

    public QAccountEntity(String variable) {
        super(AccountEntity.class, forVariable(variable));
    }

    public QAccountEntity(Path<? extends AccountEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountEntity(PathMetadata metadata) {
        super(AccountEntity.class, metadata);
    }

}

