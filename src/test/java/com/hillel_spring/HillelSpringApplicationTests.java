package com.hillel_spring;

import com.hillel_spring.controller.AnimalController;
import com.hillel_spring.controller.PersonController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HillelSpringApplicationTests {
    @Autowired
    private AnimalController animalController;

    @Autowired
    private PersonController personController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(this.animalController);
        Assertions.assertNotNull(this.personController);
    }
}