package ch.etml.es.payroll.Employee;

public class EmployeeAlreadyExistsException extends RuntimeException{

    public EmployeeAlreadyExistsException(String name){
        super("Employee " + name + " already exists");
    }
}
