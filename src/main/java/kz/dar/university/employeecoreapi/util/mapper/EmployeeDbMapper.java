package kz.dar.university.employeecoreapi.util.mapper;

import kz.dar.university.employeecoreapi.domain.EmployeeRequest;
import kz.dar.university.employeecoreapi.domain.EmployeeResponse;
import kz.dar.university.employeecoreapi.domain.model.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EmployeeDbMapper {

    @Mapping(
            target = "fullName",
            expression = "java(employeeRequest.getName() + \" \" + employeeRequest.getSurname())"
    )
    @Mapping(
            target = "employeeId",
            expression = "java(employeeRequest.getEmployeeId() == null ? java.util.UUID.randomUUID().toString() : employeeRequest.getEmployeeId())"
    )
    EmployeeEntity map(EmployeeRequest employeeRequest);

//    @Mapping(
//            target = "id",
//            expression = "java(entity.getEmployeeId())"
//    )
    EmployeeResponse map(EmployeeEntity entity);
}
