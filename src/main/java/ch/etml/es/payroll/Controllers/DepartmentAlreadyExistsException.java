package ch.etml.es.payroll.Controllers;

public class DepartmentAlreadyExistsException extends RuntimeException{

    public DepartmentAlreadyExistsException(String name){ super("Department " + name + " already exists"); }
}
