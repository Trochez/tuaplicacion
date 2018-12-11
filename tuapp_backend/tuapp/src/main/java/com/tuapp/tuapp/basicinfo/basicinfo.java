package com.tuapp.tuapp.basicinfo;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name="basicinfo")

public class basicinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @NaturalId
    @Column(name="email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name="lastname")
    private String lastName;

    @Column(name = "tel")
    private int tel;

    @Column(name = "address")
    private String address;

    public basicinfo(){}

    public basicinfo(String email, String name, String lastName, int tel, String address) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.tel = tel;
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }
}
