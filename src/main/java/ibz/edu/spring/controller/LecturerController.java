package ibz.edu.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibz.edu.hib.model.Lecturer;
import ibz.edu.hib.model.Student;
import ibz.edu.spring.service.LecturerService;

@RestController
public class LecturerController {

	@Autowired
	private LecturerService lecturerService;
	
	@GetMapping("/lecturer")
	public ResponseEntity<List<Lecturer>> list(){
		List<Lecturer> lecturers = lecturerService.listLecturers();
		return ResponseEntity.ok().body(lecturers);
	}
	
	@GetMapping("/lecturer/{id}")
	public ResponseEntity<Lecturer> get(@PathVariable("id") int id) {
	   Lecturer lecturer = lecturerService.get(id);
	   return ResponseEntity.ok().body(lecturer);
	}
	
	@PostMapping("/lecturer")
	public ResponseEntity<?> save(@RequestBody(required = false) Lecturer lecturer){
		lecturer.setIsAccepted(0);
		long id = lecturerService.createLecturer(lecturer);
		return ResponseEntity.ok().body("New student has been saved with ID:" + id);
	}
}
