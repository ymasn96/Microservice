package com.tsi.yasir.siddig.myMicroService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class FilmTest {


    @Test
    void testGetFilm_id() {
        Language testLanguage = new Language();
        Date testDate = new Date();
        Film testFilm = new Film("title", "description", testDate, testLanguage, 1, 300, "PG");
        testFilm.setFilm_id(1);
        Assertions.assertEquals(1, testFilm.getFilm_id(), "id is not present");
    }

    @Test
    void testGetTitle() {
        Language testLanguage = new Language();
        Date testDate = new Date();
        Film testFilm = new Film("title", "description", testDate, testLanguage, 1, 300, "PG");
        testFilm.setTitle("newTitle");
        Assertions.assertEquals("newTitle", testFilm.getTitle(), "title is not present");
    }

    @Test
    void testGetDescription() {
        Language testLanguage = new Language();
        Date testDate = new Date();
        Film testFilm = new Film("title", "description", testDate, testLanguage, 1, 300, "PG");
        testFilm.setDescription("newDescription");
        Assertions.assertEquals("newDescription", testFilm.getDescription(), "description is not present");
    }

    @Test
    void testGetReleaseYear() {
        Language testLanguage = new Language();
        Date testDate = new Date();
        Film testFilm = new Film("title", "description", testDate, testLanguage, 1, 300, "PG");
        testFilm.setRelease_year(testDate);
        Assertions.assertEquals(testDate, testFilm.getRelease_year(), "release year is not present");
    }

    @Test
    void testGetLanguage_id() {
        Language testLanguage = new Language();
        Date testDate = new Date();
        Film testFilm = new Film("title", "description", testDate, testLanguage, 1, 300, "PG");
        testFilm.setLanguage(testLanguage);
        Assertions.assertEquals(testLanguage, testFilm.getLanguage(), "language_id is not present");
    }

    @Test
    void testOriginalLanguage_id() {
        Language testLanguage = new Language();
        Date testDate = new Date();
        Film testFilm = new Film("title", "description", testDate, testLanguage, 1, 300, "PG");
        testFilm.setOriginal_language_id(1);
        Assertions.assertEquals(1, testFilm.getOriginal_language_id(), "original language id is not present");
    }

    @Test
    void testLength() {
        Language testLanguage = new Language();
        Date testDate = new Date();
        Film testFilm = new Film("title", "description", testDate, testLanguage, 1, 300, "PG");
        testFilm.setLength(300);
        Assertions.assertEquals(300, testFilm.getLength(), "length is not present");
    }

    @Test
    void testRating() {
        Language testLanguage = new Language();
        Date testDate = new Date();
        Film testFilm = new Film("title", "description", testDate, testLanguage, 1, 300, "PG");
        testFilm.setRating("PG");
        Assertions.assertEquals("PG", testFilm.getRating(), "rating is not present");
    }

}
