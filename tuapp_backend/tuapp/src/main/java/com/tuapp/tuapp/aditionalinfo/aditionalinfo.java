package com.tuapp.tuapp.aditionalinfo;

import javax.persistence.*;

@Entity
@Table(name="additionalinfo")

public class aditionalinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "art")
    private String art;

    @Column(name = "music")
    private String music;

    @Column(name = "movies")
    private String movies;

    @Column(name = "basicid")
    private int basicid;

    public aditionalinfo(String art, String music, String movies,int basicid) {
        this.art = art;
        this.music = music;
        this.movies = movies;
        this.basicid = basicid;
    }

    public aditionalinfo(){}

    public int getBasicid() {
        return basicid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBasicid(int basicid) {
        this.basicid = basicid;
    }

    public int getId() {
        return id;
    }



    public void setArt(String art) {
        this.art = art;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getArt() {
        return art;
    }

    public String getMusic() {
        return music;
    }

    public String getMovies() {
        return movies;
    }
}
