package com.company.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IncidentTest {
    @Test
    public void test1() {
        Donation incident = new Donation();

        incident.setId(1L);
        incident.setContent("I cannot log in");
        incident.setDescription("No response");

        assertTrue(incident != null);
    }
}