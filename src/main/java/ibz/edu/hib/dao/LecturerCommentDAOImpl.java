package ibz.edu.hib.dao;

import java.util.ArrayList;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ibz.edu.hib.model.LecturerComment;

@Repository
public class LecturerCommentDAOImpl implements LecturerCommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ArrayList<LecturerComment> getLecturerCommentList(int lecturerId) {
		Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	ArrayList<LecturerComment> commentList = null;
    	 try {
             tx = session.beginTransaction();
             Query q = session.createQuery("select c from LecturerComment c where c.lecturerId = :lecturerId");
             q.setParameter("lecturerId", lecturerId);
             commentList = (ArrayList) q.list();
             //commentList = (ArrayList)session.createQuery("FROM LecturerComment").list(); 
             for (LecturerComment lect: commentList)
            	 System.out.println(lect.getId());
             tx.commit();
          } catch (HibernateException e) {
             if (tx!=null) tx.rollback();
             e.printStackTrace(); 
          } finally {
             session.close(); 
          }
		return commentList;
	}

	public long createLecturerComment(LecturerComment comment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(comment);
		session.getTransaction().commit();
        session.close();
		return comment.getId();
	}


}
