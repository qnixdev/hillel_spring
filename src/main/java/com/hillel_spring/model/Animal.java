package com.hillel_spring.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Builder
@Data
@ToString
public class Animal {
    @Id
    private Integer id;
    private String name;
    private Person owner;
}