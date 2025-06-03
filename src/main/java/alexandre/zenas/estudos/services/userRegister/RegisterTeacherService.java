package alexandre.zenas.estudos.services.userRegister;

import alexandre.zenas.estudos.dto.auth.RegisterDTO;
import alexandre.zenas.estudos.model.Teachers;
import alexandre.zenas.estudos.model.User;
import alexandre.zenas.estudos.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegisterTeacherService {

    private final UserRepository userRepository;


    public RegisterTeacherService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> registerTeachers(RegisterDTO registerDTO, UUID pathId){
        Optional<User> userFind = userRepository.findByPathId(pathId);

        if (userRepository.findByEnrollment(registerDTO.enrollment()).isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Já existe um aluno com esse número de matrícula");
        }

        Teachers teacher = RegisterDTO.convertToEntityTeachers(registerDTO);
        teacher.setSchools(userFind.get().getSchools());
        userRepository.save(teacher);

        return ResponseEntity.status(HttpStatus.OK).body("O professor foi registrado com sucesso");
    }
}
