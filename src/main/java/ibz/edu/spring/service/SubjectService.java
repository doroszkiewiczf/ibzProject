package ibz.edu.spring.service;

import java.util.ArrayList;
import java.util.Set;

import ibz.edu.hib.model.Subject;

public interface SubjectService {
	public Set<Subject> getSubjectFromLecturer(int lecturerId);
	public long createSubject(Subject subject);
	public ArrayList<Subject> listSubjects();
	public Subject get(int id);
	public void AddLecturerToSubject(int lecturerId, int subjectId);
}
