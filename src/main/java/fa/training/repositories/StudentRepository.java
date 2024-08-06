package fa.training.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fa.training.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	Page<Student> findAllStudentByNameContaining(String name, Pageable pageable);
}