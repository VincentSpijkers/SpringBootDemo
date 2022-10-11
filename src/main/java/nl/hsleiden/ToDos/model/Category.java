package nl.hsleiden.ToDos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Category")
public class Category {

    @javax.persistence.Id
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Task> tasks;

    public Category() { }

    public Category(String name, Set<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", naam='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
