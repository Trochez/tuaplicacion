package com.tuapp.tuapp.basicinfo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class createBasicInfo {

    @PersistenceContext
    private EntityManager entityManager;

    public Boolean createBasic(String email,String name, String lastName, int tel, String address){

        basicinfo bi = new basicinfo();
        bi.setName(name);
        bi.setLastName(lastName);
        bi.setEmail(email);
        bi.setTel(tel);
        bi.setAddress(address);

        entityManager.persist(bi);

        return true;
    }

}