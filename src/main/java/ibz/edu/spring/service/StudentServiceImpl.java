package ibz.edu.spring.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibz.edu.hib.dao.StudentDAO;
import ibz.edu.hib.model.Student;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Transactional
	public ArrayList<Student> listStudents() {
		return studentDAO.listStudents();
	}
	
	@Transactional
	public long createStudent(String login, String password) {	
		return studentDAO.createStudent(login, password);
	}

	public Student get(int id) {
		return studentDAO.get(id);
	}

}
