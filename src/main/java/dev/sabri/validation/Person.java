package dev.sabri.validation;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Value
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@With
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {


    @NotEmpty
    @NotNull
    String name;
    @NotEmpty
    @NotNull
    @Length(min = 10, max = 50)
    String address;
    @Email
    String email;
    @Min(value = 1)
    @Max(value = 100)
    int age;
    @DecimalMin(value = "1.0")
    @NotNull
    @Numeric
    Double salary;
    ApiError error;

}
