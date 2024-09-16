package com.meph.course.service;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

@Primary
@Singleton
public class HelloWorldService implements MyService{

    public String helloFromService() {
        return "{\"message\": \"Hello from service!\"}";
    }
}
