package com.meph.course.controller;

import com.meph.course.model.entities.Product;
import com.meph.course.utils.InMemoryStore;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Controller("/products")
@RequiredArgsConstructor
public class ProductController {

    private final InMemoryStore store;

    @Get
    public List<Product> getProducts() {
        return new ArrayList<>(store.getProductMap().values());
    }
}
