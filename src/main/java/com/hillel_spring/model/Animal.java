package com.hillel_spring.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class Animal {
    private Integer id;
    private String name;
    private Person owner;
}