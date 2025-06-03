package alexandre.zenas.estudos.repository;

import alexandre.zenas.estudos.model.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEnrollment(Long enrollment);

    Optional<User> findByPathId(UUID pathId);

}
