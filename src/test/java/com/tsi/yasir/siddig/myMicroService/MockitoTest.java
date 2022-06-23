package com.tsi.yasir.siddig.myMicroService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

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

    @Test//post method for an actor
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
    void updateActor(){
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
    void deleteActor(){
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
    void updateCategory(){
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
    void deleteCategory(){
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

}
