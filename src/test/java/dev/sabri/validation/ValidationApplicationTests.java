package dev.sabri.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidationApplicationTests {

    @Autowired
    private PersonController personController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(personController);
    }

}
