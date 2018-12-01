package ibz.edu.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibz.edu.hib.model.SubjectComment;
import ibz.edu.spring.service.SubjectCommentService;

@RestController
public class SubjectCommentController {
	
	@Autowired
	private SubjectCommentService subjectCommentService;
	
	@GetMapping("/subject/{id}/comments")
	public ResponseEntity<List<SubjectComment>> list(@PathVariable("id") int id){
		List<SubjectComment> comments = subjectCommentService.getSubjectCommentList(id);
		return ResponseEntity.ok().body(comments);
	}
	
	@PostMapping("/subject/{id}/comments")
	public ResponseEntity<?> save(@RequestParam String author,
								  @RequestParam String text,
					              @RequestParam(required = false) LocalDate date,
					              @RequestParam int difficulty,
					              @RequestParam int workEffort,
					              @RequestParam int rating,
					              @RequestParam int lectId,
					              @PathVariable("id") int subjId){
		SubjectComment comment = new SubjectComment();
		comment.setAuthor(author);
		comment.setText(text);
		if (date!=null) {
			comment.setDate(date);
		}
		else {
			comment.setDate(LocalDate.now());
		}
		comment.setLecturerId(lectId);
		comment.setDifficulty(difficulty);
		comment.setRating(rating);
		comment.setWorkEffort(workEffort);
		comment.setSubjectId(subjId);
		long id = subjectCommentService.createSubjectCommet(comment);
		return ResponseEntity.ok().body("New Comment has been saved with ID:" + id);
	}	


}
