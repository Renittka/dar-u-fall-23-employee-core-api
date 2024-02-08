package kz.dar.university.employeecoreapi.repository;

import jakarta.transaction.Transactional;
import kz.dar.university.employeecoreapi.domain.model.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> getEmployeeEntityByEmployeeId(String employeeId);

    List<EmployeeEntity> getEmployeeEntitiesBy();

    List<EmployeeEntity> getEmployeeEntitiesByEmployeeIdIn(List<String> employeeIds);

    @Transactional
    void deleteEmployeeEntityByEmployeeId(String employeeId);
}
