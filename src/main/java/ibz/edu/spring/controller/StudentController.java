package ibz.edu.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ibz.edu.hib.model.Student;
import ibz.edu.spring.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	// Get all students
	@GetMapping("/student")
	public ResponseEntity<List<Student>> list(){
		List<Student> students = studentService.listStudents();
		return ResponseEntity.ok().body(students);
	}
	
	@PostMapping("/student")
	public ResponseEntity<?> save(@RequestBody Map<String,String> json){
		String login = json.get("login");
		String password = json.get("password");
		System.out.println(login);
		long id = studentService.createStudent(login, password);
		return ResponseEntity.ok().body("New student has been saved with ID:" + id);
	}
	/*---Get a book by id---*/
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> get(@PathVariable("id") int id) {
	   Student student = studentService.get(id);
	   return ResponseEntity.ok().body(student);
	}
	
	
}
