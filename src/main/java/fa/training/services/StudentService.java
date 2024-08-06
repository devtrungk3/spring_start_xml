package fa.training.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.entities.Student;

public interface StudentService {
	void create(Student student);
	void update(Student student);
	void delete(int id);
	Student findById(int id);
	List<Student> getListStudent();
	Page<Student> getListStudentWithPaging(Pageable pageable);
	Page<Student> findStudentByName(String name, Pageable pageable);
}