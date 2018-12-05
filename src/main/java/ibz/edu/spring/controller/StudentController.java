package ibz.edu.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<?> createUser(@RequestBody Map<String,String> json){
		String login = json.get("login");
		String password = json.get("password");
		password = BCrypt.hashpw(password, BCrypt.gensalt());
		long id = studentService.createStudent(login, password);
		return ResponseEntity.ok().body("New student has been saved with ID:" + id);
	}
	@PostMapping("/studentt")
	public ResponseEntity testToken(@RequestParam String token){
		//String login = json.get("login");
		//String password = json.get("password");
		//password = BCrypt.hashpw(password, BCrypt.gensalt());
		//long id = studentService.createStudent(login, password);
		if (studentService.checkLoginToken(token)) {
			return ResponseEntity.ok().body("Good token");
		}
		else
		return ResponseEntity.ok().body("NOT Good token");
	}
	@GetMapping("/student/{id}")
	public ResponseEntity get(@PathVariable("id") int id) {
		Student student = studentService.get(id);	
		return ResponseEntity.ok().body(student);
	 
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String,String> json){
		String login = json.get("login");
		String password = json.get("password");
		System.out.println(login);
		boolean logged = studentService.checkLogin(login, password);
		if (logged) {
			String token = BCrypt.hashpw(login, BCrypt.gensalt());
			studentService.addLoginToken(token);
			return ResponseEntity.ok().body(token);
		}
		else
			return ResponseEntity.ok().body("Nie zalogowano");
	}
	
}
