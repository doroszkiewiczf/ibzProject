package ibz.edu.spring.service;

import java.rmi.RemoteException;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibz.edu.hib.dao.StudentDAO;
import ibz.edu.hib.model.Student;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	private ArrayList<String> tokenList = new ArrayList<String>();
	
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

	public boolean checkLogin(String login, String pass) {
		ArrayList <Student> studentList = studentDAO.getStudentList();
		for (Student s: studentList) {
			if (s.getLogin().equals(login)){
				if (BCrypt.checkpw(pass, s.getPassword())) {
					return true;
				}
				else
					return false;
			}
		}
		return false; 
	}

	public void addLoginToken(String token) {
		tokenList.add(token);
	}

	public boolean checkLoginToken(String token) {
		for (String key: tokenList) {
			System.out.println(key);
			if (key.equals(token)){
				return true;
			}
		}
		return false;
	}
}
