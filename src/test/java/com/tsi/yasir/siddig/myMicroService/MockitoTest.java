package com.tsi.yasir.siddig.myMicroService;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

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




}
