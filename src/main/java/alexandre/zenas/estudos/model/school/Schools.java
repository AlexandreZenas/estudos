package alexandre.zenas.estudos.model.school;

import alexandre.zenas.estudos.model.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Schools {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "schools")
    private List<User> users;

    @OneToMany(mappedBy = "schools")
    private List<ClassSchool> classSchool;

    public Schools(String name) {
        this.name = name;
    }
    public Schools() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

