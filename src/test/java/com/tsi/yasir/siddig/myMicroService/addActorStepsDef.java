package com.tsi.yasir.siddig.myMicroService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

public class addActorStepsDef {

    private MyMicroServiceApplication microServiceApplication;
    @Mock
    private ActorRepository actorRepo;

    @BeforeEach
    void setup() {
//        actorRepo = mock(ActorRepository.class);
//        microServiceApplication = new MyMicroServiceApplication(actorRepo);
    }



    @Given("I have the actors information")
    public void i_have_the_actors_information() {
        throw new io.cucumber.java.PendingException();
    }
    @When("I input the data into the database")
    public void i_input_the_data_into_the_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I get the success return string")
    public void i_get_the_success_return_string() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
