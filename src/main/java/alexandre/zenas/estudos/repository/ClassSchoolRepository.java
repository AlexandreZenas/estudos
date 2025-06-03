package alexandre.zenas.estudos.repository;

import alexandre.zenas.estudos.model.ClassSchool;
import alexandre.zenas.estudos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClassSchoolRepository extends JpaRepository<ClassSchool, Long> {

}
