package alexandre.zenas.estudos.config;

import alexandre.zenas.estudos.model.user.User;
import alexandre.zenas.estudos.repository.UserRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService implements UserDetailsService {
    private final UserRepository userRepository;
    public UserAuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEnrollment(Long.valueOf(username))
                .orElseThrow(() -> new AccessDeniedException("Acesso negado"));
        return new UserAuthentication(user);
    }
}
