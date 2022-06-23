package com.tsi.yasir.siddig.myMicroService;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="film")
public class Film {

    @org.springframework.data.annotation.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    private String title;
    private String description;
    private Date release_year;

    private Integer original_language_id;
    private int length;
    private String rating;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name="film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categoryList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToMany
    @JoinTable(name = "film_actor", joinColumns = {
            @JoinColumn(name = "film_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "actor_id", nullable = false)
    })

    Set<Actor> actors;


    public Film (String title,
                String description,
                Date release_year,
                Language language,
                 Integer original_language_id,
                int length,
                String rating
   )
    {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language = language;
        this.original_language_id = original_language_id;
        this.length = length;
        this.rating = rating;
    }

    public Film() {
    }


    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRelease_year() {
        return release_year;
    }

    public void setRelease_year( Date release_year) {
        this.release_year = release_year;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Integer getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(Integer original_language_id) {
        this.original_language_id = original_language_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
