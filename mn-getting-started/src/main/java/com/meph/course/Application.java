package com.meph.course;

import com.meph.course.service.HelloMicronautService;
import com.meph.course.service.HelloWorldService;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = Micronaut.run(Application.class, args);
        log.info("Message from service: {}", context.getBean(HelloWorldService.class).helloFromService());

        log.info("Message from Micronaut: {}", context.getBean(HelloMicronautService.class).helloFromService());
    }
}