package ibz.edu.spring.service;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibz.edu.hib.dao.SubjectDAO;
import ibz.edu.hib.model.Subject;

@Service
@Transactional(readOnly = true)
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectDAO subjectDAO;

	@Transactional
	public Set<Subject> getSubjectFromLecturer(int lecturerId) {
		return subjectDAO.getSubjectFromLecturer(lecturerId);
	}

	public long createSubject(Subject subject) {
		return subjectDAO.createSubject(subject);
	}

	public ArrayList<Subject> listSubjects() {
		return subjectDAO.listSubjects();
	}

	public Subject get(int id) {
		return subjectDAO.get(id);
	}

	public void AddLecturerToSubject(int lecturerId, int subjectId) {
		subjectDAO.AddLecturerToSubject(lecturerId, subjectId);
	}
	

}
