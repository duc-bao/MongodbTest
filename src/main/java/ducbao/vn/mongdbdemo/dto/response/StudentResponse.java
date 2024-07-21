package ducbao.vn.mongdbdemo.dto.response;

import java.time.LocalDate;
import java.util.List;

import ducbao.vn.mongdbdemo.entity.Department;
import ducbao.vn.mongdbdemo.entity.Subject;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private String name;
    private LocalDate age;

    private String gender;

    private String address;

    private String email;

    Department department;

    List<Subject> subjects;
}
