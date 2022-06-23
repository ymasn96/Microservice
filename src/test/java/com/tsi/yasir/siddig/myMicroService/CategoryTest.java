package com.tsi.yasir.siddig.myMicroService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void testGetCategory_id() {
        Category testCategory = new Category(1,"test_name");
        testCategory.setCategory_id(1);
        Assertions.assertEquals(1, testCategory.getCategory_id(), "id is not present");
    }

    @Test
    void testSetCategory_id() {
        Category testCategory = new Category(1,"test_name");
        testCategory.setCategory_id(1);
        Assertions.assertEquals(1, testCategory.getCategory_id(), "Category id is not present");
    }

    @Test
    void testGetName() {
        Category testCategory = new Category(1,"test_name");
        testCategory.setName("newName");
        Assertions.assertEquals("newName", testCategory.getName(), "Name is not present");
    }

    @Test
    void testSetName() {
        Category testCategory = new Category(1,"test_name");
        testCategory.setName("newName");
        Assertions.assertEquals("newName", testCategory.getName(), "Name is not present");
    }



}
