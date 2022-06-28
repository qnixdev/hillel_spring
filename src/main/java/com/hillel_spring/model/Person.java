package com.hillel_spring.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Builder
@Data
@ToString
public class Person {
    @Id
    private Integer id;
    private String name;
}