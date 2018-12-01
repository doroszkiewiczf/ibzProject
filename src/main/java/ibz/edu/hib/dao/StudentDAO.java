package ibz.edu.hib.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ibz.edu.hib.model.Student;

public interface StudentDAO {


	public ArrayList<Student> listStudents();
	public long createStudent(String login, String password);
	public Student get(int id);
}

