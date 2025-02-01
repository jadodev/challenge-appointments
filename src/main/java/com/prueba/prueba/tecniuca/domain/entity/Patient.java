package com.prueba.prueba.tecniuca.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private long id;
    private String name;

    public Patient(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
