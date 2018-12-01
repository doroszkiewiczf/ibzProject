package ibz.edu.spring.service;

import java.util.ArrayList;

import ibz.edu.hib.model.SubjectComment;

public interface SubjectCommentService {
	public ArrayList<SubjectComment> getSubjectCommentList(int subjId);
	public long createSubjectCommet (SubjectComment comment);
}
