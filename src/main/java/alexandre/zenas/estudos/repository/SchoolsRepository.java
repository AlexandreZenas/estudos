package alexandre.zenas.estudos.repository;

import alexandre.zenas.estudos.model.school.Schools;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolsRepository extends JpaRepository<Schools, Long> {
}
