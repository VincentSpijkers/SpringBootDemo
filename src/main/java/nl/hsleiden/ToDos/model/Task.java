package nl.hsleiden.ToDos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "Task")
public class Task {

    @javax.persistence.Id
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private boolean isDone = false;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private Category category;

    public Task() { }

    public Task(String name, String description, boolean isDone, Category category) {
        this.name = name;
        this.description = description;
        this.isDone = isDone;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                ", category=" + category +
                '}';
    }
}
