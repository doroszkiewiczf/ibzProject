package ibz.edu.hib.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ibz.edu.hib.model.Lecturer;
import ibz.edu.hib.model.Student;

@Repository
public class LecturerDAOImpl implements LecturerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ArrayList<Lecturer> listLecturers(){
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	ArrayList<Lecturer> lecturerList = null;
    	 try {
             tx = session.beginTransaction();
             lecturerList = (ArrayList)session.createQuery("FROM Lecturer").list(); 
             for (Lecturer lect: lecturerList)
            	 System.out.println(lect.getName());
             tx.commit();
          } catch (HibernateException e) {
             if (tx!=null) tx.rollback();
             e.printStackTrace(); 
          } finally {
             session.close(); 
          }
		return lecturerList;
    }
	public long createLecturer(Lecturer lecturer) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(lecturer);
		session.getTransaction().commit();
        session.close();
		return lecturer.getId();
    }
	public Lecturer get(int id) {
    	Session session = sessionFactory.openSession();
    	Lecturer lecturer = (Lecturer)session.get(Lecturer.class, id);
        session.close();
        return lecturer;
    }
}
