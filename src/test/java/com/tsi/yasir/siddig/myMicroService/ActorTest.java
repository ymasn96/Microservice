package com.tsi.yasir.siddig.myMicroService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ActorTest {

    @Test
    void testGetActor_id() {
        Actor testActor = new Actor("first_name", "last_name");
        testActor.setActor_id(1);
        Assertions.assertEquals(1, testActor.getActor_id(), "id is not available");
    }

    @Test
    void testSetActor_id() {
        Actor testActor = new Actor("first_name", "last_name");
        testActor.setActor_id(1);
        Assertions.assertEquals(1, testActor.getActor_id(), "id is not present");
    }

    @Test
    void testGetFirstName() {
        Actor testActor = new Actor("first_name", "last_name");
        testActor.setFirst_name("first_name");
        Assertions.assertEquals("first_name", testActor.getFirst_name(), "id is not available");
    }

    @Test
    void testSetFirstName() {
        Actor testActor = new Actor("first_name", "last_name");
        testActor.setFirst_name("first_name");
        Assertions.assertEquals("first_name", testActor.getFirst_name(), "id is not available");
    }

    @Test
    void testGetLastName() {
        Actor testActor = new Actor("first_name", "last_name");
        testActor.setLast_name("last_name");
        Assertions.assertEquals("last_name", testActor.getLast_name(), "id is not available");
    }

    @Test
    void testSetLastName() {
        Actor testActor = new Actor("first_name", "last_name");
        testActor.setLast_name("last_name");
        Assertions.assertEquals("last_name", testActor.getLast_name(), "id is not available");
    }

}
