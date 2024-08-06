package fa.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.ClassRoom;
import fa.training.repositories.ClassRoomRepository;

@Service
public class ClassRoomServiceImpl implements ClassRoomService{
	
	@Autowired
	ClassRoomRepository repository;

	@Override
	public void create(ClassRoom classRoom) {
		repository.save(classRoom);
	}

	@Override
	public void delete(ClassRoom classRoom) {
		repository.delete(classRoom);
	}

	@Override
	public ClassRoom findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<ClassRoom> getListClassRoom() {
		return repository.findAll();
	}

}
