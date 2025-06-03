package alexandre.zenas.estudos.dto.auth;

import alexandre.zenas.estudos.enums.UserType;
import alexandre.zenas.estudos.model.Students;
import alexandre.zenas.estudos.model.Teachers;
import alexandre.zenas.estudos.model.User;
import org.hibernate.sql.ast.tree.expression.SqlTuple;

public record RegisterDTO(
        String name,
        Long enrollment,
        String password,
        UserType userType,
        String schoolName,
        Long schoolId
) {
    public static User convertToEntityUser(RegisterDTO registerDTO){
        return new User(
                registerDTO.name,
                registerDTO.enrollment,
                registerDTO.password,
                registerDTO.userType
        );
    }

    public static Teachers convertToEntityTeachers(RegisterDTO registerDTO){
        return new Teachers(
                registerDTO.name,
                registerDTO.enrollment,
                registerDTO.password
        );
    }
    public static Students converToEntityStudents(RegisterDTO registerDTO){
        return new Students(
                registerDTO.name,
                registerDTO.enrollment,
                registerDTO.password
        );
    }
 }