package alexandre.zenas.estudos.controllers.register.user;

import alexandre.zenas.estudos.dto.auth.RegisterDTO;
import alexandre.zenas.estudos.dto.data.RegisterClassSchoolDTO;
import alexandre.zenas.estudos.model.user.Students;
import alexandre.zenas.estudos.repository.UserRepository;
import alexandre.zenas.estudos.services.register.classSchool.ClassSchoolRegister;
import alexandre.zenas.estudos.services.register.user.RegisterDirectorService;
import alexandre.zenas.estudos.services.register.user.RegisterStudentService;
import alexandre.zenas.estudos.services.register.user.RegisterTeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private final UserRepository userRepository;
    private final RegisterStudentService registerStudents;
    private final RegisterTeacherService registerTeacher;
    private final RegisterDirectorService registerDirector;
    private final ClassSchoolRegister registerClassSchool;

    public RegisterController(UserRepository userRepository, RegisterStudentService registerStudents, RegisterTeacherService registerTeacher, RegisterDirectorService registerDirector, ClassSchoolRegister registerClassSchool) {
        this.userRepository = userRepository;
        this.registerStudents = registerStudents;
        this.registerTeacher = registerTeacher;
        this.registerDirector = registerDirector;
        this.registerClassSchool = registerClassSchool;
    }
    @PostMapping("/students/{pathId}")
    public ResponseEntity<String> registerStudents(@RequestBody RegisterDTO registerDTO, @PathVariable UUID pathId){
        return registerStudents.registerStudents(registerDTO, pathId);
    }
    @PostMapping("/teachers/{pathId}")
    public ResponseEntity<String> registerTeachers(@RequestBody RegisterDTO registerDTO, @PathVariable UUID pathId){
        return registerTeacher.registerTeachers(registerDTO, pathId);
    }
    @PostMapping("/director")
    public ResponseEntity<String> registerDirector(@RequestBody RegisterDTO registerDTO){
        return registerDirector.registerDirector(registerDTO);
    }
    @PostMapping("/class/{pathId}")
    public ResponseEntity<String> registerClassSchool(@RequestBody RegisterClassSchoolDTO registerClassSchoolDTO, @PathVariable UUID pathId){
        return registerClassSchool.registerClassSchool(registerClassSchoolDTO, pathId);
    }
    @PostMapping("/test")
    public ResponseEntity<Void> registerPrePersist(){
        Students student = new Students();

        student.setName("joaozinho");

        userRepository.save(student);

        return ResponseEntity.ok().build();
    }
}