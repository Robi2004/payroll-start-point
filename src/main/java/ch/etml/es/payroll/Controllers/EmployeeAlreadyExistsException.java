package ch.etml.es.payroll.Controllers;

public class EmployeeAlreadyExistsException extends RuntimeException{

    EmployeeAlreadyExistsException(String name){
        super("Employee " + name + " already exists");
    }
}
