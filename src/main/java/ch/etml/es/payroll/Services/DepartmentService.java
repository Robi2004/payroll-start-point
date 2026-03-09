package ch.etml.es.payroll.Services;

import ch.etml.es.payroll.Controllers.DepartmentAlreadyExistsException;
import ch.etml.es.payroll.Entities.Department;
import ch.etml.es.payroll.Repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository){
        this.repository = repository;
    }

    public Department hire(Department department){
        if(repository.findByName(department.getName()).isPresent()){
            throw new DepartmentAlreadyExistsException(department.getName());
        }
        return repository.save(department);
    }
}
