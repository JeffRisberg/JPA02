package com.company.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {
    @Test
    public void test1() {
        User user = new User();

        user.setId(1L);
        user.setFirstName("Jack");
        user.setLastName("Smith");

        assertTrue(user != null);
    }
}