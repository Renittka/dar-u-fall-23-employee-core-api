package kz.dar.university.employeecoreapi.util;

import kz.dar.university.employeecoreapi.domain.EmployeeRequest;
import kz.dar.university.employeecoreapi.domain.EmployeeResponse;
import kz.dar.university.employeecoreapi.domain.model.Employee;
import kz.dar.university.employeecoreapi.domain.model.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
@Deprecated
public interface EmployeeMapper {

    @Mapping(
            target = "fullName",
            expression = "java(employeeRequest.getName() + \" \" + employeeRequest.getSurname())"
    )
    @Mapping(
            target = "id",
            expression = "java(employeeRequest.getEmployeeId() == null ? java.util.UUID.randomUUID().toString() : employeeRequest.getEmployeeId())"
    )
    Employee map(EmployeeRequest employeeRequest);

    EmployeeResponse map(Employee employee);

}
