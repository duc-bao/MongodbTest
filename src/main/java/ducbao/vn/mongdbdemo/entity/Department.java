package ducbao.vn.mongdbdemo.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Document(collection = "department")
public class Department {
    @Field(name = "location")
    @NotNull
    @Size(min = 1, max = 50, message = "Location is required")
    private String location;
    @Field(name = "department_name")
    @Size(min = 3, max = 100, message = "Deparment is required")
    private String departmentName;
}
