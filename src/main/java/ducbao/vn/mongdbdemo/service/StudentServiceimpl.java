package ducbao.vn.mongdbdemo.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import ducbao.vn.mongdbdemo.dto.request.StudentRequest;
import ducbao.vn.mongdbdemo.dto.response.StudentResponse;
import ducbao.vn.mongdbdemo.entity.Student;
import ducbao.vn.mongdbdemo.exception.AppException;
import ducbao.vn.mongdbdemo.exception.ErrorCode;
import ducbao.vn.mongdbdemo.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentServiceimpl implements StudentService {
    StudentRepository studentRepository;
    ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        this.modelMapper.addMappings(skipModifiedFieldsMap);
    }

    PropertyMap<StudentResponse, Student> skipModifiedFieldsMap = new PropertyMap<StudentResponse, Student>() {
        protected void configure() {
            skip().setDepartment(null);
            skip().setSubjects(null);
        }
    };

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        if (studentRepository.existsByName(studentRequest.getName())) {
            throw new AppException(ErrorCode.STUDENT_EXITED);
        }
        Student student = modelMapper.map(studentRequest, Student.class);
        student.setDepartment(studentRequest.getDepartment());
        student.setSubjects(studentRequest.getSubjects());
        studentRepository.save(student);
        return modelMapper.map(student, StudentResponse.class);
    }

    @Override
    public StudentResponse getById(String idUser) {
        Student student =
                studentRepository.findById(idUser).orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOT_FOUND));
        return modelMapper.map(student, StudentResponse.class);
    }

    @Override
    public Page<StudentResponse> getAll(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Student> students = studentRepository.findAll(pageable);
        // Chuyển đổi từng Student thành StudentResponse
        List<StudentResponse> studentResponses = students.getContent().stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());

        // Tạo một trang mới với các đối tượng đã chuyển đổi
        return new PageImpl<>(studentResponses, pageable, students.getTotalElements());
    }
}
