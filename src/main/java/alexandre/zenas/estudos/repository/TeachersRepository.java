package alexandre.zenas.estudos.repository;

import alexandre.zenas.estudos.model.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachersRepository extends JpaRepository<Teachers, Long> {
}
