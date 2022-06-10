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

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}