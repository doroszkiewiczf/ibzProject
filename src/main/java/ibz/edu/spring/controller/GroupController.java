package ibz.edu.spring.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibz.edu.hib.model.Group;
import ibz.edu.spring.service.GroupService;
import ibz.edu.spring.service.StudentService;

@RestController
public class GroupController {

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/group")
	public ResponseEntity<List<Group>> list(){
		List<Group> groups = groupService.getGroupList();
		return ResponseEntity.ok().body(groups);
	}
	@PostMapping("/group")
	public ResponseEntity<?> saveGroup(@RequestBody(required = false) Group group){
		String token = group.getToken();
		if (studentService.checkLoginToken(token)) {	
			long id = groupService.createGroup(group);
			return ResponseEntity.ok().body("New Group has been saved with ID:" + id);
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error Message");
	}
	@GetMapping("/student/{id}/group")
	public ResponseEntity<Set<Group>> getGroupFromStudent(@PathVariable("id") int id,
														  @RequestParam String token){
		Set<Group> subjects = groupService.getGroupFromStudent(id);
		return ResponseEntity.ok().body(subjects);
	}

}
