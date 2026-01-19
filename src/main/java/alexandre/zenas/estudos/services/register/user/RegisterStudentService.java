package alexandre.zenas.estudos.services.register.user;

import alexandre.zenas.estudos.dto.auth.RegisterDTO;
import alexandre.zenas.estudos.model.user.Students;
import alexandre.zenas.estudos.model.user.User;
import alexandre.zenas.estudos.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegisterStudentService {

    private final UserRepository userRepository;

    public RegisterStudentService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> registerStudents(RegisterDTO registerDTO, UUID pathId){
        Optional<User> userFind = userRepository.findByPathId(pathId);

        //        if(userFind.isEmpty()) {
        //            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        //        }
        //
        //        UserType userType = userFind.get().getUserType();
        //
        //        //verifica se o Usuário tem permissão para criar novos usuários
        //        if(userType != UserType.ADMIN && userType != UserType.DIRECTOR && userType != UserType.TEACHER){
        //            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Alunos não podem adicionar novos usuários");
        //        }
        //verifica se a matrícula já existe no banco de dados
        if (userRepository.findByEnrollment(registerDTO.enrollment()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe um aluno com esse número de matrícula");
        }

        Students student = RegisterDTO.converToEntityStudents(registerDTO);
        student.setSchools(userFind.get().getSchools());
        userRepository.save(student);


        return ResponseEntity.status(HttpStatus.OK).body("O aluno foi registrado com sucesso");
    }

}
