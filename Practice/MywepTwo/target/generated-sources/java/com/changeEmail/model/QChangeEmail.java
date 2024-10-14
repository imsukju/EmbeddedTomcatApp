package com.changeEmail.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QChangeEmail is a Querydsl query type for ChangeEmail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChangeEmail extends EntityPathBase<ChangeEmail> {

    private static final long serialVersionUID = 746968856L;

    public static final QChangeEmail changeEmail = new QChangeEmail("changeEmail");

    public final StringPath Email = createString("Email");

    public final StringPath email = createString("email");

    public QChangeEmail(String variable) {
        super(ChangeEmail.class, forVariable(variable));
    }

    public QChangeEmail(Path<? extends ChangeEmail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChangeEmail(PathMetadata metadata) {
        super(ChangeEmail.class, metadata);
    }

}

