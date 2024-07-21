package ducbao.vn.mongdbdemo.dto.request;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import ducbao.vn.mongdbdemo.entity.Department;
import ducbao.vn.mongdbdemo.entity.Subject;
import ducbao.vn.mongdbdemo.validatior.Dobcontrains;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StudentRequest {
    @NotNull
    private String name;

    @Dobcontrains(min = 18)
    @NotNull
    private LocalDate age;

    @NotNull
    private String gender;

    @NotNull
    private String address;

    @NotNull
    @Email
    private String email;

    Department department;

    List<Subject> subjects;
}
