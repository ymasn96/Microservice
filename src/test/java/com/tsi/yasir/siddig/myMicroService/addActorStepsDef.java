package com.tsi.yasir.siddig.myMicroService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;



public class addActorStepsDef {

    String first_name;
    String last_name;
    String actualFirstName;
    String actualLastName;


    private MyMicroServiceApplication microServiceApplication;

    private ActorRepository actorRepo;

    private CategoryRepository categoryRepo;

    private FilmRepository filmRepo;

    private LanguageRepository languageRepo;


    @Given("The list of actors is not empty")
    public void the_list_of_actors_is_not_empty() {

        first_name = "Testing";
        last_name = "Test";

    }

    @When("The user requests the list of actors from the API")
    public void the_user_requests_the_list_of_actors_from_the_api() {

        ArgumentCaptor<Actor> argumentCaptor = ArgumentCaptor.forClass(Actor.class);
        actorRepo = mock(ActorRepository.class);
        microServiceApplication = new MyMicroServiceApplication(actorRepo, categoryRepo, filmRepo, languageRepo);
        microServiceApplication.addActor(first_name,last_name);
        verify(actorRepo).save(argumentCaptor.capture());
        actualFirstName = argumentCaptor.getValue().getFirst_name();
        actualLastName = argumentCaptor.getValue().getLast_name();

    }

    @Then("The actors are added to the database")
    public void the_actors_are_added_to_the_database() {

        Assertions.assertEquals(first_name,actualFirstName);
        Assertions.assertEquals(last_name,actualLastName);

    }
}
