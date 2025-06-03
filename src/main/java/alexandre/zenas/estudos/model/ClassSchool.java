package alexandre.zenas.estudos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ClassSchool")
public class ClassSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String className;
    //Passar para double e tirar a strategy e passar manualmente o Id como 801(turma).2019(ano)

    // FK para a escola
    @ManyToOne
    @JoinColumn(name = "schools_id")
    private Schools schools;

    @OneToMany(mappedBy = "classSchool", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Students> students;

    @ManyToMany(mappedBy = "classSchool", cascade = CascadeType.ALL)
    private List<Teachers> teachers;

    public ClassSchool() {
    }

    public ClassSchool(String className) {
        this.className = className;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Schools getSchools() {
        return schools;
    }

    public void setSchools(Schools schools) {
        this.schools = schools;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    public List<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teachers> teachers) {
        this.teachers = teachers;
    }
}