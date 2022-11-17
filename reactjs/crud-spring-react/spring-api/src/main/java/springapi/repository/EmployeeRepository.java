package springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springapi.enlity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
