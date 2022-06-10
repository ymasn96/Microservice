package com.tsi.yasir.siddig.myMicroService;


import javax.persistence.*;

@Entity
@Table(name="film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int film_id;
    private String title;
    private String description;
    private int release_year;
    private String language_id;
    private String original_language_id;
    private int length;

    private int rating;


    public Film (String title,
                String description,
                int release_year,
                String language_id,
                String original_language_id,
                int length,
                int rating
   )
    {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
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

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(String language_id) {
        this.language_id = language_id;
    }

    public String getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(String original_language_id) {
        this.original_language_id = original_language_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
