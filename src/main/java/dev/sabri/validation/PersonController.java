package dev.sabri.validation;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private final Validator validator;

    public PersonController(Validator validator) {
        this.validator = validator;
    }

    @PostMapping("/person")
    public List<Person> showPersons(@RequestBody List<Person> persons) {

        List<Person> validPersons = new ArrayList<>();

        for (Person person : persons) {
            Set<ConstraintViolation<Person>> violations = validator.validate(person);
            if (violations.isEmpty()) {
                validPersons.add(person);
            } else {
                String message = violations.stream()
                        .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                        .collect(Collectors.joining("\n"));
                person = person.withError(ApiError.builder().message(message).build());
                validPersons.add(person);

            }

        }


        return validPersons;

    }
}
