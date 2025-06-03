package alexandre.zenas.estudos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    @Column(nullable = false)
    private String subjectType;
    @Column(nullable = false)
    private Integer schoolYear;
    @Column(nullable = false)
    private Integer semester;
    @Column(nullable = false)
    private Double grade;
    @Column(nullable = false)
    private Integer absences;
    @Column(nullable = false)
    private Integer warnings;

    @ManyToMany(mappedBy = "subjects")
    private List<Students> students;

    @OneToMany(mappedBy = "subjects")
    private List<Teachers> teachers;


    public Subjects() {
    }

    public Subjects(String subjectType, int schoolYear, int semester, double grade, int absences, int warnings) {
        this.subjectType = subjectType;
        this.schoolYear = schoolYear;
        this.semester = semester;
        this.grade = grade;
        this.absences = absences;
        this.warnings = warnings;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getAbsences() {
        return absences;
    }

    public void setAbsences(int absences) {
        this.absences = absences;
    }

    public int getWarnings() {
        return warnings;
    }

    public void setWarnings(int warnings) {
        this.warnings = warnings;
    }
}
