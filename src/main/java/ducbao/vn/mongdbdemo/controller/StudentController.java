package ducbao.vn.mongdbdemo.controller;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import ducbao.vn.mongdbdemo.dto.request.StudentRequest;
import ducbao.vn.mongdbdemo.dto.response.StudentResponse;
import ducbao.vn.mongdbdemo.exception.APIResponse;
import ducbao.vn.mongdbdemo.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    StudentService studentService;

    @PostMapping("/create-student")
    public APIResponse<StudentResponse> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return APIResponse.<StudentResponse>builder()
                .result(studentService.createStudent(studentRequest))
                .build();
    }

    @GetMapping("/getById/{id}")
    public APIResponse<StudentResponse> getById(@PathVariable(value = "id") String idUser) {
        return APIResponse.<StudentResponse>builder()
                .result(studentService.getById(idUser))
                .build();
    }

    @GetMapping
    public APIResponse<Page<StudentResponse>> getAll(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int page,
            @RequestParam(value = "pageSize", defaultValue = "3", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
        return APIResponse.<Page<StudentResponse>>builder()
                .result(studentService.getAll(page, size, sortBy, sortDir))
                .build();
    }
}
