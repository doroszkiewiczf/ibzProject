package ibz.edu.hib.dao;

import java.util.ArrayList;
import java.util.Set;

import ibz.edu.hib.model.Subject;

public interface SubjectDAO {
	public Set<Subject> getSubjectFromLecturer(int lecturerId);
	public long createSubject(Subject subject);
	public ArrayList<Subject> listSubjects();
	public Subject get(int id);
	public void AddLecturerToSubject(int lecturerId, int subjectId);
}
