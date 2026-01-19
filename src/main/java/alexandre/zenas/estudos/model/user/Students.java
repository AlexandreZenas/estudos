package alexandre.zenas.estudos.model.user;

import alexandre.zenas.estudos.enums.UserType;
import alexandre.zenas.estudos.model.school.ClassSchool;
import alexandre.zenas.estudos.model.subjects.Subjects;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Students")
public class Students extends User {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_school_id")
    private ClassSchool classSchool;

    @ManyToMany
    @JoinTable(
            name = "Student_Subject",
            joinColumns = {@JoinColumn (name = "students_id")},
            inverseJoinColumns = {@JoinColumn(name = "subjects_id")}
    )
    private List<Subjects> subjects;

    public Students(String name, Long enrollment, String password) {
        super(
                name,
                enrollment,
                password,
                UserType.STUDENT
        );
    }
    public Students(){
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    public ClassSchool getClassSchool() {
        return classSchool;
    }

    public void setClassSchool(ClassSchool classSchool) {
        this.classSchool = classSchool;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }
    @PrePersist
    public void prePersist(){

    }
}
