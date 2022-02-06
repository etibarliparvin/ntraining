package az.etibarli.demo.service.impl;

import az.etibarli.demo.dto.request.EmployeeRequest;
import az.etibarli.demo.dto.response.EmployeeResponse;
import az.etibarli.demo.entity.Employee;
import az.etibarli.demo.mapper.EmployeeMapper;
import az.etibarli.demo.repository.EmployeeRepository;
import az.etibarli.demo.service.EmployeeService;
import az.etibarli.demo.utils.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponse create(EmployeeRequest request) {
//        Employee employee = employeeMapper.toEntity(request);
//        Employee savedEmployee = employeeRepository.save(employee);
//        return employeeMapper.toResponse(savedEmployee);
//        List<Employee> all = employeeRepository.findAll();
//        List<String> stringList = all.stream().map(s -> s.getEmail()).collect(Collectors.toList());
//        if(EmailUtil.checkAllEmails(request.getEmail(), stringList))
        if (EmailUtil.checkAllEmails(request.getEmail(), employeeRepository.findAll()
                .stream().map(s -> s.getEmail()).collect(Collectors.toList()))) {
            return employeeMapper.toResponse(employeeRepository.save(employeeMapper.toEntity(request)));
        }
        return null;
    }

    @Override
    public EmployeeResponse findById(Long id) {
        Optional<Employee> found = employeeRepository.findById(id);
        if (found.isPresent()) {
            if (found.get().getActive()) {
                return employeeMapper.toResponse(found.get());
            }
        }
        return null;
    }

    @Override
    public List<EmployeeResponse> findAll(Boolean isActive) {
//        List<Employee> all = employeeRepository.findAll();
//        List<EmployeeResponse> responses = new ArrayList<>();
//        for(Employee e : all) {
//            responses.add(employeeMapper.toResponse(e));
//        }
//        return responses;
        if (isActive) {
            return employeeRepository.findAllByActiveIsTrue().stream()
                    .map(employeeMapper::toResponse).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest request) {
        Optional<Employee> found = employeeRepository.findEmployeeByIdAndActiveIsTrue(id);
//        Optional<Employee> found = employeeRepository.findById(id);
        if (found.isPresent()) {
            if (EmailUtil.checkAllEmails(request.getEmail(), employeeRepository.findAll()
                    .stream().map(s -> s.getEmail()).collect(Collectors.toList()))) {
                Employee employee = employeeMapper.toEntity(request);
                employee.setActive(found.get().getActive());
                employee.setId(found.get().getId());
                employee.setCreatedAt(found.get().getCreatedAt());
                employee.setModifiedAt(LocalDateTime.now());
                return employeeMapper.toResponse(employeeRepository.save(employee));
            }
            return null;
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Employee> found = employeeRepository.findById(id);
        if (found.isPresent()) {
            found.get().setActive(Boolean.FALSE);
            found.get().setModifiedAt(LocalDateTime.now());
            employeeRepository.save(found.get());
            return true;
        }
        return false;
    }
}
