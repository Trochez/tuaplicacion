package com.tuapp.tuapp.basicinfo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface getBasicEmail extends JpaRepository<basicinfo,String> {
    public List<basicinfo> findByEmail(String email);

}
