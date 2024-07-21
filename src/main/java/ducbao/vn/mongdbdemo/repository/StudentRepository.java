package ducbao.vn.mongdbdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ducbao.vn.mongdbdemo.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    boolean existsByName(String name);
}
