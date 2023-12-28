package kz.dar.university.employeecoreapi.service;

import kz.dar.university.employeecoreapi.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    void createEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(String id);

}
