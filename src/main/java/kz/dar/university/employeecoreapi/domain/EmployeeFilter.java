package kz.dar.university.employeecoreapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeFilter {

    private String department;
    private String position;
    private double salary;

}
