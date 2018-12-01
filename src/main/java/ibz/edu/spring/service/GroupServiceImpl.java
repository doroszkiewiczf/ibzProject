package ibz.edu.spring.service;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibz.edu.hib.dao.GroupDAO;
import ibz.edu.hib.model.Group;


@Service
@Transactional(readOnly = true)
public class GroupServiceImpl implements GroupService{

	@Autowired
	private GroupDAO groupDAO;
	
	
	public long createGroup(Group group) {
		return groupDAO.createGroup(group);
	}

	public ArrayList<Group> getGroupList() {
		return groupDAO.getGroupList();
	}

	public Set<Group> getGroupFromStudent(int studentId) {
		return groupDAO.getGroupFromStudent(studentId);
	}

}
