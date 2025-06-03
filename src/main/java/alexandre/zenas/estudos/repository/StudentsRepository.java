package alexandre.zenas.estudos.repository;

import alexandre.zenas.estudos.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Long> {
}
