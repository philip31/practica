package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "jobcategories")
public class JobCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(fetch =FetchType.LAZY, mappedBy = "jobCategories")
    private List<Employees> employees_list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Employees> getEmployees_list() {
        return employees_list;
    }

    public void setEmployees_list(List<Employees> employees_list) {
        this.employees_list = employees_list;
    }

    public void AddToList(Employees e){ this.employees_list.add(e); }

    public void RemoveFromList(Employees e){ this.employees_list.remove(e); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JobCategories{\n" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \nemployees_list=" + employees_list +
                '}';
    }
}
