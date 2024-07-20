package ducbao.vn.mongdbdemo.entity;

import ducbao.vn.mongdbdemo.validatior.Dobcontrains;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "student")
public class Student {
    @Id
    private String id;
    @NotNull
    private String name;
    @Dobcontrains(min = 18)
    @NotNull
    private int age;

    private String gender;

    private String address;

    private  String email;

    Department department;

    List<Subject> subjects;
}
