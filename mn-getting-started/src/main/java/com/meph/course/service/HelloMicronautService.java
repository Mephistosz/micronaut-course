package com.meph.course.service;

import jakarta.inject.Singleton;

@Singleton
public class HelloMicronautService implements MyService {
    public String helloFromService() {
        return "{\"message\": \"Hello from Micronaut!\"}";
    }
}
