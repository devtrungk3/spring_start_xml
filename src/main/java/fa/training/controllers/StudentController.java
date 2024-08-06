package fa.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.entities.Student;
import fa.training.services.ClassRoomService;
import fa.training.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	ClassRoomService classRoomService;
	
	@GetMapping("/list")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			@RequestParam(name = "size", required = false, defaultValue = "5") int size) {
		Page<Student> students = studentService.getListStudentWithPaging(PageRequest.of(page-1, size));
		model.addAttribute("students", students);
		model.addAttribute("currentPage", page);
		model.addAttribute("currentSize", size);
		return "student/list";
	}
	
	@GetMapping("/create")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("classRooms", classRoomService.getListClassRoom());
		return "student/create";
	}
	
	@GetMapping("/update/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		model.addAttribute("classRooms", classRoomService.getListClassRoom());
		return "student/edit";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("student") Student student, Model model, RedirectAttributes redirectAttributes) {
		studentService.create(student);
		redirectAttributes.addFlashAttribute("message", "create successfully");
		return "redirect:/student/list";
	}
	
	@GetMapping("/search")
	public String search(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			@RequestParam(name = "size", required = false, defaultValue = "5") int size,
			@RequestParam(name = "studentName") String studentName) {
		Page<Student> students = studentService.findStudentByName(studentName, PageRequest.of(page-1, size));
		model.addAttribute("students", students);
		model.addAttribute("currentPage", page);
		model.addAttribute("currentSize", size);
		model.addAttribute("studentName", studentName);
		return "student/list";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("student") Student student, Model model, RedirectAttributes redirectAttributes) {
		studentService.update(student);
		redirectAttributes.addFlashAttribute("message", "update successfully");
		return "redirect:/student/list";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("id") int id, Model model, RedirectAttributes redirectAttributes) {
		studentService.delete(id);
		redirectAttributes.addFlashAttribute("message", "delete successfully");
		return "redirect:/student/list";
	}
}
