package ibz.edu.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class LecturerCommentController {
	
	@Autowired
	private LecturerCommentService lecturerCommentService;
	
	@GetMapping("/lecturer/{id}/comments")
	public ResponseEntity<List<LecturerComment>> list(@PathVariable("id") int id){
		List<LecturerComment> comments = lecturerCommentService.getLecturerCommentList(id);
		return ResponseEntity.ok().body(comments);
	}
	
	@PostMapping("/lecturer/{id}/comments")
	public ResponseEntity<?> save(@RequestParam String author,
								  @RequestParam String text,
					              @RequestParam(required = false) LocalDate date,
					              @RequestParam int difficulty,
					              @RequestParam int teachingRating,
					              @RequestParam int rating,
					              @PathVariable("id") int lectId){
		LecturerComment comment = new LecturerComment();
		comment.setAuthor(author);
		comment.setText(text);
		if (date!=null) {
			comment.setDate(date);
		}else {
			comment.setDate(LocalDate.now());
		}
		comment.setLecturerId(lectId);
		comment.setDifficulty(difficulty);
		comment.setRating(rating);
		comment.setTeachingRating(teachingRating);
		long id = lecturerCommentService.createLecturerComment(comment);
		return ResponseEntity.ok().body("New Comment has been saved with ID:" + id);
	}	

}