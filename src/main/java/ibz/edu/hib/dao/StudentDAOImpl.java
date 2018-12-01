package ibz.edu.hib.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ibz.edu.hib.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ArrayList<Student> listStudents(){
		Session session = sessionFactory.openSession();
	    Transaction tx = null;
	    ArrayList<Student> studentList = null;
	    	try {
	             tx = session.beginTransaction();
	             studentList = (ArrayList)session.createQuery("FROM Student").list(); 
	             for (Student s : studentList) {
	            	 System.out.println(s.getLogin());
	            	 Hibernate.initialize(s.getGroups());
	             }
	             tx.commit();
	          } catch (HibernateException e) {
	             if (tx!=null) tx.rollback();
	             e.printStackTrace(); 
	          } finally {
	             session.close(); 
	          }
	    	
		return studentList;
	}
	public long createStudent(String login, String password) {
    	Session session = sessionFactory.openSession();
    	Student student = new Student();
    	student.setLogin(login);
    	student.setPassword(password);
    	Transaction tx = null;
    	try {
             tx = session.beginTransaction();
             student.setPermission(0);
         	 session.save(student);
             tx.commit();
          } catch (HibernateException e) {
             if (tx!=null) tx.rollback();
             e.printStackTrace(); 
          } finally {
             session.close(); 
          }
		return student.getStudentId();	
    }
	public Student get(int id) {
    	Session session = sessionFactory.openSession();
    	Student student = (Student)session.get(Student.class, id);
        session.close();
        return student;
    }
	
}
