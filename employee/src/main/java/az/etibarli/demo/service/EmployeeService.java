package az.etibarli.demo.service;

import az.etibarli.demo.dto.request.EmployeeRequest;
import az.etibarli.demo.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse create(EmployeeRequest request);

    EmployeeResponse findById(Long id);

    List<EmployeeResponse> findAll(Boolean isActive);

    EmployeeResponse update(Long id, EmployeeRequest request);

    Boolean delete(Long id);
}
