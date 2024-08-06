package fa.training.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ClassRoom {
	@Id
	private int id;
	
	@Column(name="class_name", columnDefinition="varchar(20)")
	private String className;
	
	@OneToMany(mappedBy = "classRoom")
	private List<Student> students;
	
	public ClassRoom(int id, String className, List<Student> students) {
		super();
		this.id = id;
		this.className = className;
		this.students = students;
	}
	public ClassRoom() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
