package kz.dar.university.employeecoreapi.util;

import kz.dar.university.employeecoreapi.domain.EmployeeRequest;
import kz.dar.university.employeecoreapi.domain.EmployeeResponse;
import kz.dar.university.employeecoreapi.domain.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EmployeeMapper {

    @Mapping(
            target = "fullName",
            expression = "java(employeeRequest.getName() + \" \" + employeeRequest.getSurname())"
    )
    @Mapping(
            target = "id",
            expression = "java(employeeRequest.getId() == null ? java.util.UUID.randomUUID().toString() : employeeRequest.getId())"
    )
    Employee map(EmployeeRequest employeeRequest);

    EmployeeResponse map(Employee employee);

}
