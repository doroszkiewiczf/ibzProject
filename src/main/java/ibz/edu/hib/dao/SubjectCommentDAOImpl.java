package ibz.edu.hib.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;


import ibz.edu.hib.model.SubjectComment;

@Repository
public class SubjectCommentDAOImpl implements SubjectCommentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ArrayList<SubjectComment> getSubjectCommentList(int subjId) {
		Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	ArrayList<SubjectComment> commentList = null;
    	 try {
             tx = session.beginTransaction();
             Query q = session.createQuery("select c from SubjectComment c where c.subjectId = :subjectId");
             q.setParameter("subjectId", subjId);
             commentList = (ArrayList) q.list();
             //commentList = (ArrayList)session.createQuery("FROM LecturerComment").list(); 
             for (SubjectComment subj: commentList)
            	 System.out.println(subj.getId());
             tx.commit();
          } catch (HibernateException e) {
             if (tx!=null) tx.rollback();
             e.printStackTrace(); 
          } finally {
             session.close(); 
          }
		return commentList;
	}

	public long createSubjectCommet(SubjectComment comment) {
    	LocalDate localDate = LocalDate.now();
    	comment.setDate(localDate);
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(comment);
        session.getTransaction().commit();
        session.close();
        return comment.getId();
	}

	
}
