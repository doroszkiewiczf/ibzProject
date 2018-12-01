package ibz.edu.hib.dao;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ibz.edu.hib.model.Lecturer;
import ibz.edu.hib.model.Subject;

@Repository
public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Set<Subject> getSubjectFromLecturer(int lecturerId) {
    	Session session = sessionFactory.openSession();
    	Lecturer lect = (Lecturer) session.get(Lecturer.class, lecturerId);
    	Hibernate.initialize(lect.getSubjects());
        Set <Subject> subSet = lect.getSubjects();
        	  for(Subject subject : subSet) {
        		    System.out.println(subject.getName());
        		}
        session.close();
        return subSet;
	}

	public long createSubject(Subject subject) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(subject);
        session.getTransaction().commit();
        session.close();
        return subject.getId();
	}

	public ArrayList<Subject> listSubjects() {
		Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	ArrayList<Subject> subjectList = null;
    	 try {
             tx = session.beginTransaction();
             subjectList = (ArrayList)session.createQuery("FROM Subject").list(); 
             for (Subject subj: subjectList)
            	 System.out.println(subj.getName());
             tx.commit();
          } catch (HibernateException e) {
             if (tx!=null) tx.rollback();
             e.printStackTrace(); 
          } finally {
             session.close(); 
          }
		return subjectList;
	}

	public Subject get(int id) {
		Session session = sessionFactory.openSession();
		Subject subject = (Subject)session.get(Subject.class, id);
        session.close();
        return subject;
	}

	public void AddLecturerToSubject(int lecturerId, int subjectId) {
		Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	String sql = String.format("INSERT INTO eduplatformdb.Subject_Lecturer (subjectId,lecturerId) VALUES(%s,%s);",subjectId, lecturerId);
    	session.createSQLQuery(sql).executeUpdate();
    	session.getTransaction().commit();
    	session.close();
	}

}
