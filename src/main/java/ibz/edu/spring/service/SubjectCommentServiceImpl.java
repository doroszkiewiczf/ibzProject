package ibz.edu.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibz.edu.hib.dao.SubjectCommentDAO;
import ibz.edu.hib.model.SubjectComment;

@Service
@Transactional(readOnly = true)
public class SubjectCommentServiceImpl implements SubjectCommentService {

	@Autowired
	private SubjectCommentDAO subjectCommentDAO;
	
	public ArrayList<SubjectComment> getSubjectCommentList(int subjId) {
		return subjectCommentDAO.getSubjectCommentList(subjId);
	}

	public long createSubjectCommet(SubjectComment comment) {
		return subjectCommentDAO.createSubjectCommet(comment);
	}

}
