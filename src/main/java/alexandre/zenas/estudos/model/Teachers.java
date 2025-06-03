package alexandre.zenas.estudos.model;

import alexandre.zenas.estudos.enums.UserType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Teachers")
public class Teachers extends User{

    @ManyToMany()
    @JoinTable(
            name = "teacher_class_school",
            joinColumns = {@JoinColumn(name = "teachers_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_school_id")}
    )
    private List<ClassSchool> classSchool;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subjects_id")
    private Subjects subjects;



    public Teachers(String name, Long enrollment, String password) {
        super(
                name,
                enrollment,
                password,
                UserType.TEACHER
        );
    }
    public Teachers() {
    }
}
