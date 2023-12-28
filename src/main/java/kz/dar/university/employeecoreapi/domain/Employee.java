package kz.dar.university.employeecoreapi.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String id;

    @NotNull(message = "Name can not be empty")
    @Size(min = 2, max = 16, message = "Name must be in size range 2-16")
    private String name;

    @NotNull
    private String surname;

    private String department;
    private String position;

    @Email
    private String email;

    private double salary;
}
