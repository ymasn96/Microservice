package com.tsi.yasir.siddig.myMicroService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int actor_id;
    private String first_name;
    private String last_name;

    //Constructor

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> filmList = new ArrayList<>();


    public Actor(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Actor() {}

    //Methods

    public int getActor_id() { return actor_id; }

    public void setActor_id(int actor_id) { this.actor_id = actor_id; }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}
