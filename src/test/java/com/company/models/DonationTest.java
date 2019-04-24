package com.company.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DonationTest {
    @Test
    public void test1() {
        DonationEntity donation = new DonationEntity();

        donation.setId(1L);
        donation.setAmount(56.78);

        assertTrue(donation != null);
    }
}