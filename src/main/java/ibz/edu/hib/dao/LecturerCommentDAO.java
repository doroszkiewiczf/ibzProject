package ibz.edu.hib.dao;

import java.util.ArrayList;

import ibz.edu.hib.model.LecturerComment;

public interface LecturerCommentDAO {

	public ArrayList<LecturerComment> getLecturerCommentList(int lecturerId);
	public long createLecturerComment (LecturerComment comment);
}
