package com.company.services;

import com.company.common.base.config.AppConfig;
import com.google.inject.Inject;

public class HelloService {

    protected AppConfig appConfig;

    @Inject
    public HelloService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void handle() {
        Object alpha = appConfig.getString("ALPHA", "alpha");

        Object results = "Hello There " + alpha;
        System.out.println(results);
    }
}

