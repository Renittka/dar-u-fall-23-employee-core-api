package kz.dar.university.employeecoreapi.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "employees")
@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, name = "employee_id")
    private String employeeId;
    @Column(nullable = false, length = 100)
    private String fullName;
    private String department;
    private String position;
    private String email;
    private double salary;

}
