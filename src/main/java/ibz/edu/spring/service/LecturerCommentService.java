package ibz.edu.spring.service;

import java.util.ArrayList;

import ibz.edu.hib.model.LecturerComment;


public interface LecturerCommentService {
	public ArrayList<LecturerComment> getLecturerCommentList(int lecturerId);
	public long createLecturerComment (LecturerComment comment);
}
