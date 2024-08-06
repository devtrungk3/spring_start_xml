package fa.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.training.entities.ClassRoom;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer>{

}
