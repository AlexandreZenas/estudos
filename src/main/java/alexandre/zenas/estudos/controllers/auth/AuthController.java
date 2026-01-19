package alexandre.zenas.estudos.controllers.auth;

import alexandre.zenas.estudos.dto.auth.LoginDTO;
import alexandre.zenas.estudos.model.user.User;
import alexandre.zenas.estudos.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDTO request){

        Optional<User> userLogin = userRepository.findByEnrollment(request.enrollment());

        if (userLogin.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O usuário não foi encontrado");
        }
        if(!userLogin.get().getPassword().equals(request.password())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("A senha está incorreta");
        }


        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
