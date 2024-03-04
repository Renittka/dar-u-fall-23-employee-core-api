package kz.dar.university.employeecoreapi.service;

import kz.dar.university.employeecoreapi.domain.EmployeeRequest;
import kz.dar.university.employeecoreapi.domain.EmployeeResponse;
import kz.dar.university.employeecoreapi.domain.model.EmployeeEntity;
import kz.dar.university.employeecoreapi.repository.EmployeeRepository;
import kz.dar.university.employeecoreapi.util.mapper.EmployeeDbMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDbMapper mapper;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.getEmployeeEntitiesBy()
                .stream()
                .map(mapper::map)
                .toList();
    }

    @Override
    public List<EmployeeResponse> getEmployeesByList(List<String> employeeIds) {
        return employeeRepository.getEmployeeEntitiesByEmployeeIdIn(employeeIds)
                .stream()
                .map(entity -> {
                    EmployeeResponse response = mapper.map(entity);
                    log.info("Employee entity: " + response);
                    return response;
                })
                .toList();
    }

    @Override
    public Map<String, EmployeeResponse> getEmloyeesMap(List<String> employeeIds) {
        HashMap<String, EmployeeResponse> employeesMap = new HashMap<>();
        List<EmployeeResponse> employeesList = getEmployeesByList(employeeIds);
        employeesList.forEach(employee -> employeesMap.put(employee.getEmployeeId(), employee));

        return employeesMap;
    }

    @Override
    public EmployeeResponse getEmployeeById(String id) {
        Optional<EmployeeEntity> maybeEntity = employeeRepository.getEmployeeEntityByEmployeeId(id);
        log.info("Maybe entity: " + maybeEntity);

        return maybeEntity.map(mapper::map).orElse(null);
        /*
        Alternative way:
        if(maybeEntity.isPresent()) {
            return mapper.map(maybeEntity.get());
        }
        return null;
         */
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        // request -> EmployeeEntity
        EmployeeEntity savedEntity = employeeRepository.save(
                mapper.map(employeeRequest)
        );

        // entity -> EmployeeResponse
        return mapper.map(savedEntity);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest) {
        Optional<EmployeeEntity> maybeEntity = employeeRepository.getEmployeeEntityByEmployeeId(employeeRequest.getEmployeeId());
        if (maybeEntity.isPresent()) {
            EmployeeEntity entityToUpdate = mapper.map(employeeRequest);
            entityToUpdate.setId(maybeEntity.get().getId());
            return mapper.map(
                    employeeRepository.save(
                            entityToUpdate
                    )
            );
        }
        return null;
    }

    @Override
    public void deleteEmployeeById(String id) {
        employeeRepository.deleteEmployeeEntityByEmployeeId(id);
    }

}
