package alexandre.zenas.estudos.services.register.user;

import alexandre.zenas.estudos.dto.auth.RegisterDTO;
import alexandre.zenas.estudos.enums.UserType;
import alexandre.zenas.estudos.model.school.Schools;
import alexandre.zenas.estudos.model.user.User;
import alexandre.zenas.estudos.repository.SchoolsRepository;
import alexandre.zenas.estudos.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegisterDirectorService {

    private final UserRepository userRepository;
    private final SchoolsRepository schoolsRepository;

    public RegisterDirectorService(UserRepository userRepository, SchoolsRepository schoolsRepository) {
        this.userRepository = userRepository;
        this.schoolsRepository = schoolsRepository;
    }
    public ResponseEntity<String> registerDirector(RegisterDTO registerDTO){

        Schools schools = new Schools();
        schools.setName(registerDTO.schoolName());
        schoolsRepository.save(schools);

        User user = RegisterDTO.convertToEntityUser(registerDTO);
        user.setSchools(schools);
        user.setUserType(UserType.DIRECTOR);
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body("O usuário foi registrado com sucesso");
    }
}