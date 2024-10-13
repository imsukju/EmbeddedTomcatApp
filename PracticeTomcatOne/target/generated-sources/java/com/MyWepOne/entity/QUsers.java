package com.MyWepOne.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = 1141820430L;

    public static final QUsers users = new QUsers("users");

    public final StringPath BankAccount = createString("BankAccount");

    public final NumberPath<Long> RealID = createNumber("RealID", Long.class);

    public final StringPath UserId = createString("UserId");

    public final StringPath UserName = createString("UserName");

    public final StringPath UserPasswd = createString("UserPasswd");

    public QUsers(String variable) {
        super(Users.class, forVariable(variable));
    }

    public QUsers(Path<? extends Users> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsers(PathMetadata metadata) {
        super(Users.class, metadata);
    }

}

