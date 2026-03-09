package ch.etml.es.payroll.Department;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(
        name = "departments",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        }
)
public class Department {

    private @Id
    @GeneratedValue Long id;
    private String name;

    public Department(){}

    public Department(String name){
        this.setName(name);
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Department department))
            return false;
        return  Objects.equals(this.id, department.id) &&
                Objects.equals(this.name, department.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(
                this.id,
                this.name);
    }

    @Override
    public String toString(){
        return "Department{" + "id=" +
                this.getId() + ", name='" +
                this.getName() + '\''+
                '}';
    }
}
