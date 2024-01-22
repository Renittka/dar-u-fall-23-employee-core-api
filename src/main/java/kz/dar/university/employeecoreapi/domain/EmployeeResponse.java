package kz.dar.university.employeecoreapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeResponse {

    private String id;
    private String fullName;
    private String department;
    private String position;
    private String email;
    private double salary;

}
