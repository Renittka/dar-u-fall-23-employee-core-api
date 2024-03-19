package kz.dar.university.employeecoreapi;

import kz.dar.university.employeecoreapi.controller.EmployeeController;
import kz.dar.university.employeecoreapi.domain.EmployeeResponse;
import kz.dar.university.employeecoreapi.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    private List<EmployeeResponse> employees;
    private EmployeeResponse employee;

    @BeforeEach
    void setUp() {
        employee = EmployeeResponse.builder()
                .employeeId("123")
                .fullName("John Smith")
                .email("john@email.com")
                .build();
        employees = Collections.singletonList(employee);

        given(employeeService.getAllEmployees())
                .willReturn(employees);
        given(employeeService.getEmployeeById("123")).willReturn(employee);
    }

    @Test
    void getAllEmployees_IsOk() throws Exception {
        mockMvc.perform(
                        get("/employee/all")
                )
                .andExpect(
                        status().isOk()
                )
                .andExpect(
                        jsonPath("$[0].id")
                                .value(employee.getEmployeeId())
                )
                .andExpect(
                        jsonPath("$[0].fullName")
                                .value(employee.getFullName())
                );
    }
}
