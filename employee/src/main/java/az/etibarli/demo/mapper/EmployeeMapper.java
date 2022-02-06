package az.etibarli.demo.mapper;

import az.etibarli.demo.dto.request.EmployeeRequest;
import az.etibarli.demo.dto.response.EmployeeResponse;
import az.etibarli.demo.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequest request) {
        Employee employee = new Employee();
//        if (request.getFirstName() != null)
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setBirthdate(request.getBirthdate());
        employee.setEmail(request.getEmail());
        employee.setGender(request.getGender());
        employee.setPhone(request.getPhone());
        return employee;
    }

    public EmployeeResponse toResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setBirthdate(employee.getBirthdate());
        response.setEmail(employee.getEmail());
        response.setGender(employee.getGender());
        response.setPhone(employee.getPhone());
        response.setCreatedAt(employee.getCreatedAt());
        response.setModifiedAt(employee.getModifiedAt());
        response.setActive(employee.getActive());
        return response;
    }
}
