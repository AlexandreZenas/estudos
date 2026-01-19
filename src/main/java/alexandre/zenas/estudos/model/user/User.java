package alexandre.zenas.estudos.model.user;

import alexandre.zenas.estudos.enums.UserType;
import alexandre.zenas.estudos.model.school.Schools;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false, unique = true, updatable = false)
    protected UUID pathId;
    protected String name;
    protected Long enrollment;
    protected String password;

    @Enumerated(EnumType.STRING)
    protected UserType userType;

    @ManyToOne
    @JoinColumn(name = "schools_id") // cria a FK no banco
    private Schools schools;

    @PrePersist
    public void generateUuid() {
        this.pathId = UUID.randomUUID();
    }

    public User(String name, Long enrollment, String password, UserType userType) {
        this.name = name;
        this.enrollment = enrollment;
        this.password = password;
        this.userType = userType;
        this.pathId = UUID.randomUUID();
    }
    public User() {

    }

    public UUID getPathId() {
        return pathId;
    }

    public void setPathId(UUID pathId) {
        this.pathId = pathId;
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

    public Long getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Long enrollment) {
        this.enrollment = enrollment;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Schools getSchools() {return schools;}

    public void setSchools(Schools schools) {this.schools = schools;}
}
