package com.MyWepOne.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBankDetail is a Querydsl query type for BankDetail
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QBankDetail extends BeanPath<BankDetail> {

    private static final long serialVersionUID = -1524497561L;

    public static final QBankDetail bankDetail = new QBankDetail("bankDetail");

    public final StringPath bankAccount = createString("bankAccount");

    public final StringPath bankName = createString("bankName");

    public QBankDetail(String variable) {
        super(BankDetail.class, forVariable(variable));
    }

    public QBankDetail(Path<? extends BankDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBankDetail(PathMetadata metadata) {
        super(BankDetail.class, metadata);
    }

}

