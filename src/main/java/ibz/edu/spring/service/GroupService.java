package ibz.edu.spring.service;

import java.util.ArrayList;
import java.util.Set;

import ibz.edu.hib.model.Group;

public interface GroupService {
	public long createGroup(Group group);
	public ArrayList<Group> getGroupList();
	public Set<Group> getGroupFromStudent(int studentId);
	public long joinGroup(int subjectId, int groupId);
}
