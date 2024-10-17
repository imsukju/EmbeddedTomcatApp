package com.changeEmail.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccountForm is a Querydsl query type for AccountForm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccountForm extends EntityPathBase<AccountForm> {

    private static final long serialVersionUID = -1003557411L;

    public static final QAccountForm accountForm = new QAccountForm("accountForm");

    public final StringPath email = createString("email");

    public final StringPath username = createString("username");

    public QAccountForm(String variable) {
        super(AccountForm.class, forVariable(variable));
    }

    public QAccountForm(Path<? extends AccountForm> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountForm(PathMetadata metadata) {
        super(AccountForm.class, metadata);
    }

}

