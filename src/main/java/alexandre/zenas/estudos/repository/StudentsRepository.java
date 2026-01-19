package alexandre.zenas.estudos.repository;

import alexandre.zenas.estudos.model.user.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Long> {
}
