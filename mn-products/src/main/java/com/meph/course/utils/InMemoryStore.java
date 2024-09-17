package com.meph.course.utils;

import com.meph.course.model.entities.Product;
import com.meph.course.model.types.Type;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@Slf4j
@Singleton
public class InMemoryStore {

    @Getter
    private final Map<Integer, Product> productMap = new HashMap<>();
    private final Faker faker = new Faker();

    @PostConstruct
    public void initialise() {
        IntStream.range(0, 10).forEach(this::addProduct);
    }

    private void addProduct(int id) {
        Product product = new Product(id, faker.coffee().blendName(), Type.COFFEE);
        productMap.put(id, product);
        log.info("Added product: {}", product);
    }

}
