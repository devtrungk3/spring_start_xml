package fa.training.services;

import java.util.List;

import fa.training.entities.ClassRoom;

public interface ClassRoomService {
	void create(ClassRoom classRoom);
	void delete(ClassRoom classRoom);
	ClassRoom findById(int id);
	List<ClassRoom> getListClassRoom();
}
