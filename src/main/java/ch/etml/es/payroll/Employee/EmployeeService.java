package ch.etml.es.payroll.Employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    public Employee hire(Employee employee){
        if(repository.findByName(employee.getName()).isPresent()){
            throw new EmployeeAlreadyExistsException(employee.getName());
        }
        return repository.save(employee);
    }
}
