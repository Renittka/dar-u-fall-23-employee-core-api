package kz.dar.university.employeecoreapi.service;

import kz.dar.university.employeecoreapi.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private HashMap<String, Employee> employees = new HashMap<>();

    {
        Employee newEmployee = new Employee(
                "1234",
                "John",
                "Smith",
                "Backend dev",
                "Scala developer",
                "john@gmail.com",
                120000
        );

        employees.put(
                "123",
                Employee
                        .builder()
                        .id("123")
                        .name("Maria")
                        .surname("Smith")
                        .salary(120000)
                        .department("Backend dev")
                        .position("Java developer")
                        .email("hello@gmail.com")
                        .build()
        );

        employees.put(newEmployee.getId(), newEmployee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees.values().stream().toList();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees.get(id);
    }

    @Override
    public void createEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        String employeeId = employee.getId();

        if (employees.containsKey(employeeId)) {
            employees.put(employeeId, employee);
        }
    }

    @Override
    public void deleteEmployeeById(String id) {
        employees.remove(id);
    }

}
