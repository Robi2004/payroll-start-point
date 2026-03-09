package ch.etml.es.payroll.Controllers;

import ch.etml.es.payroll.Entities.Department;
import ch.etml.es.payroll.Repositories.DepartmentRepository;
import ch.etml.es.payroll.Services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    private final DepartmentRepository repository;
    private final DepartmentService service;

    DepartmentController(DepartmentRepository repository, DepartmentService service){
        this.repository = repository;
        this.service = service;
    }

    /* curl sample :
    curl -X GET localhost:8080/api/v1/departments | jq
    */
    @GetMapping("/departments")
    List<Department> all(){
        return repository.findAll();
    }

    /* curl sample :
    curl -X GET localhost:8080/api/v1/departments/1
    */
    @GetMapping("/departments/{id}")
    Department one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    /* curl sample :
    curl -X POST -H "Content-Type: application/json" -d '{"name":"Informatique"}' localhost:8080/api/v1/departments | jq
    */
    @PostMapping("/departments")
    @ResponseStatus(HttpStatus.CREATED)
    Department newDepartment(@RequestBody Department department){
        return service.hire(department);
    }
}