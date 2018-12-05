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

import ibz.edu.hib.model.LecturerComment;
import ibz.edu.hib.model.Student;
import ibz.edu.spring.service.LecturerCommentService;
import ibz.edu.spring.service.StudentService;

@RestController
public class LecturerCommentController {
	
	@Autowired
	private LecturerCommentService lecturerCommentService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/lecturer/{id}/comments")
	public ResponseEntity<List<LecturerComment>> list(@PathVariable("id") int id){
		List<LecturerComment> comments = lecturerCommentService.getLecturerCommentList(id);
		return ResponseEntity.ok().body(comments);
	}
	
	@PostMapping("/lecturer/{id}/comments")
	public ResponseEntity<?> save(@RequestBody(required = false) LecturerComment comment,
					              @PathVariable("id") int lectId){
		String token = comment.getToken();
		if (studentService.checkLoginToken(token)) {	
			if (comment.getDate() == null) {
				comment.setDate(LocalDate.now());
			}
			comment.setLecturerId(lectId);
			long id = lecturerCommentService.createLecturerComment(comment);
			return ResponseEntity.ok().body("New Comment has been saved with ID:" + id);
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error Message");
	}	

}
