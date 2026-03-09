package ch.etml.es.payroll.Department;

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
