package ch.etml.es.payroll.Controllers;

import ch.etml.es.payroll.Entities.Employee;
import ch.etml.es.payroll.Repositories.EmployeeRepository;
import ch.etml.es.payroll.Services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeRepository repository;
    private final EmployeeService service;

    EmployeeController(EmployeeRepository repository, EmployeeService service){
        this.repository = repository;
        this.service = service;
    }

    /* curl sample :
    curl -X GET localhost:8080/api/v1/employees | jq
    */
    @GetMapping("/employees")
    Employee all(){
        return (Employee) repository.findAll();
    }

    /* curl sample :
    curl -X GET localhost:8080/api/v1/employees/1
    */
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    /* curl sample :
    curl -X POST -H "Content-Type: application/json" -d '{"name":"John","role":"Supervisor"}' localhost:8080/api/v1/employees | jq
    */
    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    Employee newEmployee(@RequestBody Employee employee){
        return service.hire(employee);
    }
}
