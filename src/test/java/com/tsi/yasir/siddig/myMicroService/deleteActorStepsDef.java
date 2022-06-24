package com.tsi.yasir.siddig.myMicroService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class deleteActorStepsDef {

    private MyMicroServiceApplication microServiceApplication;
    @Mock
    private ActorRepository actorRepo;
    @Mock
    private FilmRepository filmRepo;
    @Mock
    private CategoryRepository categoryRepo;
    @Mock
    private LanguageRepository languageRepo;

    Actor testActor;

    void setUp(){
        actorRepo = mock(ActorRepository.class);
        microServiceApplication = new MyMicroServiceApplication(actorRepo, categoryRepo, filmRepo, languageRepo);
    }

    @Given("I have the id of the actor that I would like to delete")
    public void i_have_the_id_of_the_actor_that_i_would_like_to_delete() {
        testActor = new Actor("Testing", "Test");
        throw new io.cucumber.java.PendingException();
    }

    @When("I input the id of that specific actor")
    public void i_input_the_id_of_that_specific_actor() {
        setUp();
        when(actorRepo.findById(testActor.getActor_id())).thenReturn(Optional.of(testActor));
        throw new io.cucumber.java.PendingException();
    }

    @Then("I receive a response showing that the actor has been deleted")
    public void i_receive_a_response_showing_that_the_actor_has_been_deleted() {
        microServiceApplication.deleteActor(testActor.getActor_id());
        verify(actorRepo).delete(testActor);
        throw new io.cucumber.java.PendingException();
    }

}
