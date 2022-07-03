package com.hillel_spring.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
@Table
public class Person {
    @Id
    private Integer id;
    private String name;
}