package kz.dar.university.employeecoreapi.controller;

import jakarta.validation.Valid;
import kz.dar.university.employeecoreapi.domain.EmployeeRequest;
import kz.dar.university.employeecoreapi.domain.EmployeeFilter;
import kz.dar.university.employeecoreapi.domain.EmployeeResponse;
import kz.dar.university.employeecoreapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

//    @Autowired
//    private EmployeeService employeeService;

    private final EmployeeService employeeService;

    private final Environment env;

    @GetMapping("/check")
    public String check() {
        return "employee-core-api is working at the port: " + env.getProperty("local.server.port");
    }

    @GetMapping("/all")
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /*
    @GetMapping("/id/{id}/{second}") ->  /employee/id/123/456
    @GetMapping("/{id}") -> /employee/123
     */
    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(
            @PathVariable String id
    ) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/filter")
    public EmployeeResponse filter(
            @RequestBody EmployeeFilter employeeFilter
    ) {
        return employeeService.getEmployeeById(employeeFilter.getPosition());
    }

    @PostMapping
    public EmployeeResponse createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.createEmployeeWithMapper(employeeRequest);
    }

    @PutMapping("/{id}")
    public void updateEmployee(
            @PathVariable String id,
            @Valid @RequestBody EmployeeRequest employeeRequest
    ) {
        employeeRequest.setId(id);
        employeeService.updateEmployee(employeeRequest);
    }

    @PutMapping
    public void updateEmployee(
            @Valid @RequestBody EmployeeRequest employeeRequest
    ) {
        employeeService.updateEmployee(employeeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }


    /*
    localhost:8080/employee
    localhost:8080/employee/filter
    localhost:8080/employee/all
    localhost:8080/employee/{id}
     */
}
