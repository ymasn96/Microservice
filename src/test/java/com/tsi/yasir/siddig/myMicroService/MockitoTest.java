package com.tsi.yasir.siddig.myMicroService;


import org.junit.Before;
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
    private IActorRepository actorRepo;

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
        Actor testActor = new Actor("hello", "world");
        testActor.setActor_id(1);
        when(actorRepo.findById(1)).thenReturn(Optional.of(testActor));
        Optional<Actor> Actual = microServiceApplication.getAnActor(testActor.getActor_id());
        Actor Expected = testActor;
        Assertions.assertEquals(Expected, Actual,"Could not find actor with ID: ");
    }

    @Test//post method for an actor
    public void addAnActor() {
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        Actor Actual = microServiceApplication.addActor(testActor.getFirst_name(), testActor.getLast_name()).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepo).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected, Actual, "Actor was not added.");
    }

    @Test//put  method for an actor
    public void updateActor(){
        Actor testActor = new Actor("testFName", "testLName");
        testActor.setActor_id(1);
        when(actorRepo.findById(1)).thenReturn(Optional.of(testActor));
        Actor Actual = microServiceApplication.updateActor(testActor.getActor_id(), testActor.getFirst_name(), testActor.getLast_name()).getBody();
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
        //ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        actorRepo.deleteById(testActor.getActor_id());
        Actor Expected = testActor;
        Assertions.assertEquals(Expected,Actual,"Actor was not deleted.");
    }

}
