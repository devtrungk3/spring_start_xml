package fa.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.entities.Student;
import fa.training.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository repository;

	@Override
	public void create(Student student) {
		repository.save(student);
		
	}
	
	@Override
	public void update(Student student) {
		repository.save(student);
		
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public Student findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Student> getListStudent() {
		return repository.findAll();
	}

	@Override
	public Page<Student> getListStudentWithPaging(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Page<Student> findStudentByName(String name, Pageable pageable) {
		return repository.findAllStudentByNameContaining(name, pageable);
	}
	
}
