package az.etibarli.demo.repository;

import az.etibarli.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByActiveIsTrue();

    //    Optional<Employee> findByActiveIsTrue(Long id);
//    Optional<Employee> findEmployeeByActiveIsTrue(Long id);
    Optional<Employee> findEmployeeByIdAndActiveIsTrue(Long id);
}
