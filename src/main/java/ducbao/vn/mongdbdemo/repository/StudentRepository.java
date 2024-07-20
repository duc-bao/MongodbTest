package ducbao.vn.mongdbdemo.repository;

import ducbao.vn.mongdbdemo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends MongoRepository<Student, String> {
}
