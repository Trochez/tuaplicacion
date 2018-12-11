package com.tuapp.tuapp.aditionalinfo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional

public class createAditionalInfo {

    @PersistenceContext
    private EntityManager entityManager;

    public Boolean createAditional(String art, String music, String movies,int basicid){

        aditionalinfo ai = new aditionalinfo();
        ai.setArt(art);
        ai.setMusic(music);
        ai.setMovies(movies);
        ai.setBasicid(basicid);

        entityManager.persist(ai);

        return true;
    }
}
