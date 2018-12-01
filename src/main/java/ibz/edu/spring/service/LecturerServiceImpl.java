package ibz.edu.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibz.edu.hib.dao.LecturerDAO;
import ibz.edu.hib.model.Lecturer;

@Service
@Transactional(readOnly = true)
public class LecturerServiceImpl implements LecturerService {
	
	@Autowired
	private LecturerDAO lecturerDAO;
	
	@Transactional
	public ArrayList<Lecturer> listLecturers(){
		return lecturerDAO.listLecturers();
	}
	
	public long createLecturer(Lecturer lecturer) {
		return lecturerDAO.createLecturer(lecturer);
	}
	
	public Lecturer get(int id) {
		return lecturerDAO.get(id);
	}

}
