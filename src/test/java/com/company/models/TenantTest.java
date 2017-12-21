package com.company.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TenantTest {
    @Test
    public void test1() {
        Tenant tenant  = new Tenant();

        tenant.setId(1L);
        tenant.setName("Tenant1");

        assertTrue(tenant != null);
    }
}