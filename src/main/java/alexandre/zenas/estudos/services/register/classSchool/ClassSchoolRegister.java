package alexandre.zenas.estudos.services.register.classSchool;

import alexandre.zenas.estudos.dto.data.RegisterClassSchoolDTO;
import alexandre.zenas.estudos.model.school.ClassSchool;
import alexandre.zenas.estudos.model.user.User;
import alexandre.zenas.estudos.repository.ClassSchoolRepository;
import alexandre.zenas.estudos.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClassSchoolRegister {
    private final UserRepository userRepository;
    private final ClassSchoolRepository classSchoolRepository;

    public ClassSchoolRegister(UserRepository userRepository, ClassSchoolRepository classSchoolRepository) {
        this.userRepository = userRepository;
        this.classSchoolRepository = classSchoolRepository;
    }


    public ResponseEntity<String> registerClassSchool(RegisterClassSchoolDTO registerClassSchoolDTO, UUID pathId){

        Optional<User> userFind = userRepository.findByPathId(pathId);
        ClassSchool classSchool = new ClassSchool();

        classSchool.setClassName(registerClassSchoolDTO.className());
        classSchool.setSchools(userFind.get().getSchools());
        classSchoolRepository.save(classSchool);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}