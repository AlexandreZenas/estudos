package alexandre.zenas.estudos;

import alexandre.zenas.estudos.model.Students;
import alexandre.zenas.estudos.model.Subjects;
import alexandre.zenas.estudos.repository.StudentsRepository;
import alexandre.zenas.estudos.repository.SubjectsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class controller {

    private final StudentsRepository repository;
    private final SubjectsRepository noteRepository;


    public controller(StudentsRepository repository, SubjectsRepository noteRepository) {
        this.repository = repository;
        this.noteRepository = noteRepository;
    }

    @PostMapping
    ResponseEntity<Students> createUser(@RequestBody Students students){
        repository.save(students);

        return  ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/notas")
    ResponseEntity<Subjects> registerNotes(@RequestBody Subjects subjects){
        noteRepository.save(subjects);

        return  ResponseEntity.status(HttpStatus.OK).build();
    }
//    @PostMapping("/a")
//    String abc(){
//        Students students = repository.findById(2L).stream().findFirst().orElse(null);
//        Subjects subjects = noteRepository.findById(1L).stream().findFirst().orElse(null);
//        students.getSubjects().add(subjects);
//        repository.save(students);
//
//       return "oi";
//    }
}
