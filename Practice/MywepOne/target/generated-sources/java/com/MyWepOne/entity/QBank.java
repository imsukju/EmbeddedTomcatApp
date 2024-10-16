package com.MyWepOne.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBank is a Querydsl query type for Bank
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBank extends EntityPathBase<Bank> {

    private static final long serialVersionUID = -379392138L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBank bank = new QBank("bank");

    public final StringPath bankAccount = createString("bankAccount");

    public final NumberPath<Long> bankid = createNumber("bankid", Long.class);

    public final StringPath bankName = createString("bankName");

    public final NumberPath<Long> money = createNumber("money", Long.class);

    public final QUsers users;

    public QBank(String variable) {
        this(Bank.class, forVariable(variable), INITS);
    }

    public QBank(Path<? extends Bank> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBank(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBank(PathMetadata metadata, PathInits inits) {
        this(Bank.class, metadata, inits);
    }

    public QBank(Class<? extends Bank> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users")) : null;
    }

}

