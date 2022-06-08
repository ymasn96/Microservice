package com.tsi.yasir.siddig.myMicroService;


import javax.persistence.*;


@Entity
@Table(name = "actor")
public class Actor {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @org.springframework.data.annotation.Id
    private int actor_id;
    private String first_name;
    private String last_name;

    //Constructor

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
}
