package ch.etml.es.payroll.Department;

public class DepartmentAlreadyExistsException extends RuntimeException{

    public DepartmentAlreadyExistsException(String name){ super("Department " + name + " already exists"); }
}
