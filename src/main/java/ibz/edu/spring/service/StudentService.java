package ibz.edu.spring.service;

import java.util.ArrayList;

import ibz.edu.hib.model.Student;

public interface StudentService {
	public ArrayList<Student> listStudents();
	public long createStudent(String login, String password);
	public Student get(int id);
}