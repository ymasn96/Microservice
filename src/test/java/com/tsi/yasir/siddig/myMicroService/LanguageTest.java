package com.tsi.yasir.siddig.myMicroService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LanguageTest {

    @Test
    void testGetCategory_id() {
        Language testLanguage = new Language("test_name");
        testLanguage.setLanguage_id(1);
        Assertions.assertEquals(1, testLanguage.getLanguage_id(), "id is not available");
    }

    @Test
    void testSetLanguage_id() {
        Language testLanguage = new Language("test_name");
        testLanguage.setLanguage_id(1);
        Assertions.assertEquals(1, testLanguage.getLanguage_id(), "Language id is not present");
    }

    @Test
    void testGetName_id() {
        Language testLanguage = new Language("test_name");
        testLanguage.setName("newName");
        Assertions.assertEquals("newName", testLanguage.getName(), "Name is not present");
    }
}
