package com.tsi.yasir.siddig.myMicroService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MockitoTest {

    private MyMicroServiceApplication microServiceApplication;
    @Mock
    private ActorRepository actorRepo;
    @Mock
    private CategoryRepository categoryRepo;
    @Mock
    private FilmRepository filmRepo;
    @Mock
    private LanguageRepository languageRepo;

    @BeforeEach
    void setUp() {
        microServiceApplication = new MyMicroServiceApplication(actorRepo, categoryRepo, filmRepo, languageRepo);
    }

    // Actor Tests

    @Test
    void getAllActors() {
        microServiceApplication.getAllActors();
        verify(actorRepo).findAll();
    }

    @Test
    void getAnActor() {
        Actor testActor = new Actor("Benedict", "Cumberbatch");
        testActor.setActor_id(1);
        when(actorRepo.findById(1)).thenReturn(Optional.of(testActor));
        Optional<Actor> Actual = microServiceApplication.getAnActor(testActor.getActor_id());
        Actor Expected = testActor;
        Assertions.assertEquals(Expected, Actual.get(),"Could not find actor with ID: ");
    }

    @Test
    void addAnActor() {
        Actor testActor = new Actor("Johnny", "Depp");
        testActor.setActor_id(1); // Set actor id to 1
        Actor Actual = microServiceApplication.addActor(testActor.getFirst_name(), testActor.getLast_name()).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepo).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected, Actual, "Actor was not added.");

    }

    @Test
    void updateActor() {
        Actor testActor = new Actor("Tom", "Holland");
        testActor.setActor_id(1);
        when(actorRepo.findById(1)).thenReturn(Optional.of(testActor));
        Actor Actual = microServiceApplication.addNewActor(testActor.getActor_id(), testActor.getFirst_name(), testActor.getLast_name()).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepo).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Actor was not updated.");
    }

    @Test//delete method for an actor
    void deleteActor() {
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        when(actorRepo.findById(1)).thenReturn(Optional.of(testActor));
        doNothing().when(actorRepo).deleteById(1);
        Actor Actual = microServiceApplication.deleteActor(testActor.getActor_id()).getBody();
        actorRepo.deleteById(testActor.getActor_id());
        Actor Expected = testActor;
        Assertions.assertEquals(Expected,Actual,"Actor was not deleted.");
    }

    // Category Tests

    @Test
    void getAllCategories() {
        microServiceApplication.getAllCategories();
        verify(categoryRepo).findAll();
    }

    @Test
    void getCategory() {
        Category testCategory = new Category(1,"Testing");
        testCategory.setCategory_id(1);
        when(categoryRepo.findById(1)).thenReturn(Optional.of(testCategory));
        Category Actual = microServiceApplication.getCategory(testCategory.getCategory_id()).getBody();
        Category Expected = testCategory;
        Assertions.assertEquals(Expected, Actual,"Could not find category with ID: ");
    }

    @Test
    void addCategory() {
        Category testCategory = new Category(1,"Testing");
        testCategory.setCategory_id(1);
        Category Actual = microServiceApplication.addCategory(testCategory).getBody();
        ArgumentCaptor<Category> actorArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepo).save(actorArgumentCaptor.capture());
        Category Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"A new category was not added.");
    }

    @Test
    void updateCategory() {
        Category testCategory = new Category(1, "testCategory");
        testCategory.setCategory_id(1);
        Category testCategoryUpdated = new Category(1, "testCategoryUpdated");
        testCategoryUpdated.setCategory_id(1);
        when(categoryRepo.findById(testCategory.getCategory_id())).thenReturn(Optional.of(testCategoryUpdated));
        Category Actual = microServiceApplication.updateCategory(testCategoryUpdated).getBody();
        ArgumentCaptor<Category> actorArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepo).save(actorArgumentCaptor.capture());
        Category Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Category was not updated.");
    }

    @Test
    void deleteCategory() {
        Category testCategory = new Category(1, "testCategory");
        testCategory.setCategory_id(1);
        Category testCategoryDeleted = new Category(1, "testCategoryDeleted");
        testCategory.setCategory_id(1);
        when(categoryRepo.findById(testCategoryDeleted.getCategory_id())).thenReturn(Optional.of(testCategoryDeleted));
        doNothing().when(categoryRepo).deleteById(1);
        Category Actual = microServiceApplication.deleteCategory(testCategoryDeleted).getBody();
        categoryRepo.deleteById(testCategoryDeleted.getCategory_id());
        Category Expected = testCategoryDeleted;
        Assertions.assertEquals(Expected,Actual,"Category was not deleted.");
    }

    // Film Tests

    @Test
    void getAllFilms() {
        microServiceApplication.getAllFilms();
        verify(filmRepo).findAll();
    }

    @Test
    void getFilm() {
        Date testDate = new Date();
        Language testLanguage = new Language();
        Film testFilm = new Film("testTitle", "testDescription", testDate , testLanguage, 1, 95, "PG");
        testFilm.setFilm_id(1);
        when(filmRepo.findById(1)).thenReturn(Optional.of(testFilm));
        Film Actual = microServiceApplication.getFilm(testFilm.getFilm_id()).getBody();
        Film Expected = testFilm;
        Assertions.assertEquals(Expected, Actual,"Could not find Film with ID: ");
    }

    @Test
    void addFilm() {
        Date testDate = new Date();
        Language testLanguage = new Language();
        Film testFilm = new Film("testTitle", "testDescription", testDate , testLanguage, 1, 95, "PG");
        testFilm.setFilm_id(1);
        Film Actual = microServiceApplication.addFilm(testFilm).getBody();
        ArgumentCaptor<Film> actorArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepo).save(actorArgumentCaptor.capture());
        Film Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Film was not added.");
    }

    @Test
    void updateFilm() {
        Date testDate = new Date();
        Language testLanguage = new Language();
        Film testFilm = new Film("testTitle", "testDescription", testDate , testLanguage, 1, 95, "PG");
        testFilm.setFilm_id(1);
        Film testFilmUpdated = new Film("testTitle", "testDescription", testDate , testLanguage, 1, 95, "PG");
        testFilmUpdated.setFilm_id(1);
        when(filmRepo.findById(testFilm.getFilm_id())).thenReturn(Optional.of(testFilmUpdated));
        Film Actual = microServiceApplication.updateFilm(testFilmUpdated).getBody();
        ArgumentCaptor<Film> actorArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepo).save(actorArgumentCaptor.capture());
        Film Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Category was not updated.");
    }

    @Test
    void deleteFilm() {
        Date testDate = new Date();
        Language testLanguage = new Language();
        Film testFilm = new Film("testTitle", "testDescription", testDate , testLanguage, 1, 95, "PG");
        testFilm.setFilm_id(1);
        Film testFilmDelete = new Film("testTitle", "testDescription", testDate , testLanguage, 1, 95, "PG");
        testFilmDelete.setFilm_id(1);
        when(filmRepo.findById(testFilmDelete.getFilm_id())).thenReturn(Optional.of(testFilmDelete));
        doNothing().when(filmRepo).deleteById(1);
        Film Actual = microServiceApplication.deleteFilm(testFilmDelete).getBody();
        filmRepo.deleteById(testFilmDelete.getFilm_id());
        Film Expected = testFilmDelete;
        Assertions.assertEquals(Expected,Actual,"Film was not deleted.");
    }

    // Language Tests

    @Test
    void getAllLanguages() {
        microServiceApplication.getAllLanguages();
        verify(languageRepo).findAll();
    }

    @Test
    void getLanguage() {
        Language testLanguage = new Language("testLanguage");
        testLanguage.setLanguage_id(1);
        when(languageRepo.findById(1)).thenReturn(Optional.of(testLanguage));
        Language Actual = microServiceApplication.getLanguage(testLanguage.getLanguage_id()).getBody();
        Language Expected = testLanguage;
        Assertions.assertEquals(Expected, Actual,"Could not find Language with ID: ");
    }

    @Test
    void addLanguage() {
        Language testLanguage = new Language("testLanguage");
        testLanguage.setLanguage_id(1);
        Language Actual = microServiceApplication.addLanguage(testLanguage).getBody();
        ArgumentCaptor<Language> actorArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepo).save(actorArgumentCaptor.capture());
        Language Expected = testLanguage;
        Assertions.assertEquals(Expected, Actual,"Could not find Language with ID: ");
    }

    @Test
    void updateLanguage() {
        Language testLanguage = new Language("testLanguage");
        testLanguage.setLanguage_id(1);
        Language testLanguageUpdated = new Language("testLanguageUpdated");
        testLanguageUpdated.setLanguage_id(1);
        when(languageRepo.findById(testLanguage.getLanguage_id())).thenReturn(Optional.of(testLanguageUpdated));
        Language Actual = microServiceApplication.updateLanguage(testLanguageUpdated).getBody();
        ArgumentCaptor<Language> actorArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepo).save(actorArgumentCaptor.capture());
        Language Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Category was not updated.");
    }

    @Test//delete method for a Language
    void deleteLanguage() {
        Language testLanguage = new Language("testLanguage");
        testLanguage.setLanguage_id(1);
        Language testLanguageDelete = new Language("testLanguage");
        testLanguageDelete.setLanguage_id(1);
        when(languageRepo.findById(testLanguageDelete.getLanguage_id())).thenReturn(Optional.of(testLanguageDelete));
        doNothing().when(languageRepo).deleteById(1);
        Language Actual = microServiceApplication.deleteLanguage(testLanguageDelete).getBody();
        languageRepo.deleteById(testLanguageDelete.getLanguage_id());
        Language Expected = testLanguageDelete;
        Assertions.assertEquals(Expected,Actual,"Language was not deleted.");
    }

}
