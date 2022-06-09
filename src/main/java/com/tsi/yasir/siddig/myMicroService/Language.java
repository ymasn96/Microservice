package com.tsi.yasir.siddig.myMicroService;

import javax.persistence.*;

@Entity
@Table(name="language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int language_id;
    private String name;

    public Language(String name) {
        this.name = name;
    }

    public Language() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}