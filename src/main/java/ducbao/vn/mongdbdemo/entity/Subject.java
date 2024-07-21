package ducbao.vn.mongdbdemo.entity;

import jakarta.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
// @Document(collection = "subject")
public class Subject {
    @Field(name = "name_subject")
    @NotNull(message = "Namesubject is required")
    private String nameSubject;

    @Field(name = "mark_obtained")
    @NotNull(message = "MarkObtained is required")
    private double markObtained;
}
