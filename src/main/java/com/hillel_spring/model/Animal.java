package com.hillel_spring.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Animal {
    private Integer id;
    private String name;
    private Person owner;
}