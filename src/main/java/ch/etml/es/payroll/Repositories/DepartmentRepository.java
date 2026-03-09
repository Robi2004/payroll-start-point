package ch.etml.es.payroll.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<ch.etml.es.payroll.Entities.Department, Long>{

    Optional<ch.etml.es.payroll.Entities.Department> findByName(String name);
}
