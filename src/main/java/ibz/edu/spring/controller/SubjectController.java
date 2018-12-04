package ibz.edu.spring.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibz.edu.hib.model.Lecturer;
import ibz.edu.hib.model.Subject;
import ibz.edu.spring.service.SubjectService;

@RestController
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/lecturer/{id}/subject")
	public ResponseEntity<Set<Subject>> getSubjectFromLecturer(@PathVariable("id") int id){
		Set<Subject> subjects = subjectService.getSubjectFromLecturer(id);
		return ResponseEntity.ok().body(subjects);
	}
	
	@PostMapping("/lecturer/{id}/subject")
	public ResponseEntity<?> saveSubject(@RequestBody(required=false) Subject subject,
										 @PathVariable("id") int lectId){
		subject.setIsAccepted(0);
		long id = subjectService.createSubject(subject);
		subjectService.AddLecturerToSubject(lectId, (int) id);
		return ResponseEntity.ok().body("New Subject has been saved with ID:" + id);
	}
	
	@GetMapping("/subject")
	public ResponseEntity<List<Subject>> list(){
		List<Subject> subjects = subjectService.listSubjects();
		return ResponseEntity.ok().body(subjects);
	}
	
	@GetMapping("/subject/{id}")
	public ResponseEntity<Subject> get(@PathVariable("id") int id) {
		Subject subject = subjectService.get(id);
	   return ResponseEntity.ok().body(subject);
	}
	@GetMapping("/subject/{id}/lecturer")
	public ResponseEntity<Set<Lecturer>> getLecturersFromSubject(@PathVariable("id") int id){
		Subject subject = subjectService.get(id);
		Set<Lecturer> lectSet = subjectService.getLecturersFromSubject(subject);
		return ResponseEntity.ok().body(lectSet);
	}
}
