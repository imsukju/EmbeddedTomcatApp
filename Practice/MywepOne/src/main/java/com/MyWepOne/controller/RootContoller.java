package com.MyWepOne.controller;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RootContoller {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
}
