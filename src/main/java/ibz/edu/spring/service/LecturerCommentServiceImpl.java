package ibz.edu.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibz.edu.hib.dao.LecturerCommentDAO;
import ibz.edu.hib.model.LecturerComment;

@Service
@Transactional(readOnly = true)
public class LecturerCommentServiceImpl implements LecturerCommentService {

	@Autowired
	private LecturerCommentDAO lecturerCommentDAO;
	
	@Transactional
	public ArrayList<LecturerComment> getLecturerCommentList(int lecturerId) {
		return lecturerCommentDAO.getLecturerCommentList(lecturerId);
	}

	public long createLecturerComment(LecturerComment comment) {
		return lecturerCommentDAO.createLecturerComment(comment);
	}

}
