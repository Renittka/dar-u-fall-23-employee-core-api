package kz.dar.university.employeecoreapi.service;

import kz.dar.university.employeecoreapi.domain.EmployeeRequest;
import kz.dar.university.employeecoreapi.domain.EmployeeResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<EmployeeResponse> getAllEmployees();

    List<EmployeeResponse> getEmployeesByList(List<String> employeeIds);

    Map<String, EmployeeResponse> getEmloyeesMap(List<String> employeeIds);

    EmployeeResponse getEmployeeById(String id);

    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

    //EmployeeResponse createEmployeeWithMapper(EmployeeRequest employeeRequest);

    EmployeeResponse updateEmployee(EmployeeRequest employeeRequest);

    void deleteEmployeeById(String id);

}
