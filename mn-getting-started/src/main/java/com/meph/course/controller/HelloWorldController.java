package com.meph.course.controller;

import com.meph.course.service.HelloWorldService;
import com.meph.course.service.MyService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/hello")
public class HelloWorldController {

    private final MyService myService;

    @Inject
    public HelloWorldController(MyService myService) {
        this.myService = myService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public String helloWorld() {
        return myService.helloFromService();
    }
}