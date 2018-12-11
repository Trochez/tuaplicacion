package com.tuapp.tuapp.aditionalinfo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface getAditional extends JpaRepository<aditionalinfo,Integer> {
    public List<aditionalinfo> findByBasicid(int basicid);

}
