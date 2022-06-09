package com.tsi.yasir.siddig.myMicroService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyMicroServiceApplication microServiceApplication;
    @Mock
    private ActorRepository actorRepo;

    @BeforeEach
    void setUp() {
        microServiceApplication = new MyMicroServiceApplication(actorRepo);
    }

    @Test
    public void getAllActors() {
        microServiceApplication.getAllActors();
        verify(actorRepo).findAll();
    }

    @Test
    public void getAnActor() {
        Actor testActor = new Actor("Benedict", "Cumberbatch");
        testActor.setActor_id(1);
        when(actorRepo.findById(1)).thenReturn(Optional.of(testActor));
        Optional<Actor> Actual = microServiceApplication.getAnActor(testActor.getActor_id());
        Actor Expected = testActor;
        Assertions.assertEquals(Expected, Actual.get(),"Could not find actor with ID: ");
    }

    @Test//post method for an actor
    public void addAnActor() {
        Actor testActor = new Actor("Johnny", "Depp");
        testActor.setActor_id(1); // Set actor id to 1
        Actor Actual = microServiceApplication.addActor(testActor.getFirst_name(), testActor.getLast_name()).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepo).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected, Actual, "Actor was not added.");

//        ArgumentCaptor allows us to capture an argument passed to a method in order to inspect it.
//        This is especially useful when we can't access the argument outside the method we'd like to test.
    }

    @Test
    public void updateActor(){
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
    public void deleteActor(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        when(actorRepo.findById(1)).thenReturn(Optional.of(testActor));
        doNothing().when(actorRepo).deleteById(1);
        Actor Actual = microServiceApplication.deleteActor(testActor.getActor_id()).getBody();
        actorRepo.deleteById(testActor.getActor_id());
        Actor Expected = testActor;
        Assertions.assertEquals(Expected,Actual,"Actor was not deleted.");
    }

}
