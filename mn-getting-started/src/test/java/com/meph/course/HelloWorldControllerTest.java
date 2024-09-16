package com.meph.course;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class HelloWorldControllerTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void testItWorks() {
        assertTrue(application.isRunning());
    }

    @Nested
    @DisplayName("when GET /hello")
    class WhenGetHello {

        @Test
        @DisplayName("should return a json response with the status code 200")
        void helloWorldEndpointResponseWithStatusCode200() {
            HttpResponse<String> response = httpClient.toBlocking().exchange("/hello", String.class);
            assertEquals(HttpStatus.OK, response.getStatus());
            assertEquals("{\"message\": \"Hello from service!\"}", response.getBody().orElse(""));
        }

        @Test
        @DisplayName("should return a json response with the message 'Hello, World!'")
        void helloWorldEndpointResponseWithText() {
            String response = httpClient.toBlocking().retrieve("/hello");
            assertEquals("{\"message\": \"Hello from service!\"}", response);
        }
    }

}
