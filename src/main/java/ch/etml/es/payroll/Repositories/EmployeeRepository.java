package ch.etml.es.payroll.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<ch.etml.es.payroll.Entities.Employee, Long>{

    Optional<ch.etml.es.payroll.Entities.Employee> findByName(String name);
}
