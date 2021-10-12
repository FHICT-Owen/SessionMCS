package com.example.sessionmcs.Dish;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dish {
    @Id
    private Integer id;
    private String name;

    public Dish() { }

    public Dish(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
