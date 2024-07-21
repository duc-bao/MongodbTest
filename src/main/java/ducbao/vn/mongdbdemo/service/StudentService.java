package ducbao.vn.mongdbdemo.service;

import org.springframework.data.domain.Page;

import ducbao.vn.mongdbdemo.dto.request.StudentRequest;
import ducbao.vn.mongdbdemo.dto.response.StudentResponse;

public interface StudentService {
    StudentResponse createStudent(StudentRequest studentRequest);

    StudentResponse getById(String idUser);

    Page<StudentResponse> getAll(int page, int size, String sortBy, String sortDir);
}
