package ibz.edu.hib.dao;

import java.util.ArrayList;

import ibz.edu.hib.model.SubjectComment;

public interface SubjectCommentDAO {
	public ArrayList<SubjectComment> getSubjectCommentList(int subjId);
	public long createSubjectCommet (SubjectComment comment);

}
