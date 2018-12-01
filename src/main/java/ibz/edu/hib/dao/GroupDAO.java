package ibz.edu.hib.dao;

import java.util.ArrayList;
import java.util.Set;

import ibz.edu.hib.model.Group;

public interface GroupDAO {
	public long createGroup(Group group);
	public ArrayList<Group> getGroupList();
	public Set<Group> getGroupFromStudent(int studentId);
	
	
}
