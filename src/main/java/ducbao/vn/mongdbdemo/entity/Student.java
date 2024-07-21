package ducbao.vn.mongdbdemo.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "student")
public class Student {
    @Id
    private String id;

    private String name;
    private LocalDate age;
    private String gender;

    private String address;

    private String email;

    Department department;

    List<Subject> subjects;
}
