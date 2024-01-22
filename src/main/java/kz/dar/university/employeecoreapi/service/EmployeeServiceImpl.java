package kz.dar.university.employeecoreapi.service;

import kz.dar.university.employeecoreapi.domain.EmployeeRequest;
import kz.dar.university.employeecoreapi.domain.EmployeeResponse;
import kz.dar.university.employeecoreapi.domain.model.Employee;
import kz.dar.university.employeecoreapi.util.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    private HashMap<String, Employee> employees = new HashMap<>();

    private ModelMapper mapper = new ModelMapper();

    {
        Employee newEmployeeRequest = new Employee(
                "1234",
                "John Smith",
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
                        .fullName("Maria Smith")
                        .salary(120000)
                        .department("Backend dev")
                        .position("Java developer")
                        .email("hello@gmail.com")
                        .build()
        );

        employees.put(newEmployeeRequest.getId(), newEmployeeRequest);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employees.values()
                .stream()
                .map(employeeMapper::map)
                .toList();
    }

    @Override
    public EmployeeResponse getEmployeeById(String id) {
        Employee foundEmployee = employees.get(id);

        //return mapper.map(foundEmployee, EmployeeResponse.class);
        return employeeMapper.map(foundEmployee);
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        /* Input: ..Request
           Process: ..Entity, ..DTO (Data Transport Object)
           Output: ..Response
         */

        /*
        First Option
        Employee newEmployee =  new Employee();
        newEmployee.setId(UUID.randomUUID().toString());
        newEmployee.setDepartment(employeeRequest.getDepartment());
        newEmployee.setSalary(employeeRequest.getSalary());
        newEmployee.setEmail(employeeRequest.getEmail());
        newEmployee.setFullName(employeeRequest.getName() + " " + employeeRequest.getSurname());
        newEmployee.setPosition(employeeRequest.getPosition());
         */

        Employee employeeToSave = map(employeeRequest);
        employees.put(employeeToSave.getId(), employeeToSave);

        Employee createdEmployee = employees.get(employeeRequest.getId());

        return map(createdEmployee);
    }

    @Override
    public EmployeeResponse createEmployeeWithMapper(EmployeeRequest employeeRequest) {
        // Convert from EmployeeRequest to Employee
        /*
        Employee employeeToSave = mapper.map(employeeRequest, Employee.class);
        employeeToSave.setFullName(employeeRequest.getName() + " " + employeeRequest.getSurname());
        employeeToSave.setId(UUID.randomUUID().toString());
         */
        Employee employeeToSave = employeeMapper.map(employeeRequest);

        employees.put(employeeToSave.getId(), employeeToSave);

        Employee createdEmployee = employees.get(employeeToSave.getId());

        // Convert from Employee to EmployeeResponse
        //return mapper.map(createdEmployee, EmployeeResponse.class);
        return employeeMapper.map(createdEmployee);
    }

    @Override
    public void updateEmployee(EmployeeRequest employeeRequest) {
        String employeeId = employeeRequest.getId();

        if (employees.containsKey(employeeId)) {
//            employees.put(
//                    employeeId,
//                    mapper.map(employeeRequest, Employee.class)
//            );
            employees.put(
                    employeeId,
                    employeeMapper.map(employeeRequest)
            );
        }
    }

    @Override
    public void deleteEmployeeById(String id) {
        employees.remove(id);
    }

    private Employee map(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .fullName(employeeRequest.getName() + " " + employeeRequest.getSurname())
                .department(employeeRequest.getDepartment())
                .email(employeeRequest.getEmail())
                .salary(employeeRequest.getSalary())
                .id(employeeRequest.getId() == null ? UUID.randomUUID().toString() : employeeRequest.getId())
                .position(employeeRequest.getPosition())
                .build();
    }

    private EmployeeResponse map(Employee employee) {
        return EmployeeResponse.builder()
                .fullName(employee.getFullName())
                .department(employee.getDepartment())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .id(employee.getId())
                .position(employee.getPosition())
                .build();
    }

}
