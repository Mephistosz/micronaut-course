package com.meph.course.model.entities;

import com.meph.course.model.types.Type;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Serdeable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Introspected
public class Product {
    private Integer id;
    private String name;
    private Type type;
}

