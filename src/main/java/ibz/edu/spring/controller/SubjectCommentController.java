package ibz.edu.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibz.edu.hib.model.SubjectComment;
import ibz.edu.spring.service.StudentService;
import ibz.edu.spring.service.SubjectCommentService;

@RestController
public class SubjectCommentController {
	
	@Autowired
	private SubjectCommentService subjectCommentService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/subject/{id}/comments")
	public ResponseEntity<List<SubjectComment>> list(@PathVariable("id") int id){
		List<SubjectComment> comments = subjectCommentService.getSubjectCommentList(id);
		return ResponseEntity.ok().body(comments);
	}
	
	@PostMapping("/subject/{id}/comments")
	public ResponseEntity<?> save(@RequestBody(required = false) SubjectComment comment,
					              @PathVariable("id") int subjId){
		String token = comment.getToken();
		if (studentService.checkLoginToken(token)) {			
			if (comment.getDate()==null) {
				comment.setDate(LocalDate.now());
			}
	
			comment.setSubjectId(subjId);
			long id = subjectCommentService.createSubjectCommet(comment);
			return ResponseEntity.ok().body("New Comment has been saved with ID:" + id);
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error Message");
	}	


}
